package com.br.luizortizdev.groceryStore.service;

import com.br.luizortizdev.groceryStore.client.OrderClient;
import com.br.luizortizdev.groceryStore.model.OrderItem;
import com.br.luizortizdev.groceryStore.model.Product;
import com.br.luizortizdev.groceryStore.model.Promotion;
import com.br.luizortizdev.groceryStore.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderClient orderClient;


    public List<Product> getAllProducts() {
        return orderClient.listProducts();
    }

    public Product getProductById(String productId) {
        return orderClient.getProductById(productId);
    }

    private List<OrderItem> orders = new ArrayList<>();

    public void addItemToOrder(String productId, int quantity) {
        Product product = orderClient.getProductById(productId);

        OrderItem order = new OrderItem();
        order.setProduct(product);
        order.setQuantity(quantity);
        order.setDiscount(0);
        orders.add(order);
        orderRepository.saveAll(orders);
    }

    public int calculateTotal() {
        if (orders.isEmpty()) {
            return 0;
        }

        int total = 0;
        int totalDiscount = 0;

        for (OrderItem order : orders) {
            int totalOrder = order.getProduct().getPrice() * order.getQuantity();
            int orderDiscount = applyPromotions(order);
            total += totalOrder;
            totalDiscount += orderDiscount;
        }
        System.out.println("Total Savings: " + totalDiscount + " pennies");
        return total - totalDiscount;
    }

    private int applyPromotions(OrderItem order) {
        List<Promotion> promotions = order.getProduct().getPromotions();
        if (promotions == null || promotions.isEmpty()) {
            return 0;
        }
        int discount = 0;
        for (Promotion promotion : promotions) {
            switch (promotion.getType()) {
                case BUY_X_GET_Y_FREE:
                    discount += applyBuyXGetYFreePromotion(order, promotion);
                    break;
                case QTY_BASED_PRICE_OVERRIDE:
                    discount += applyQtyBasedPriceOverridePromotion(order, promotion);
                    break;
                case FLAT_PERCENT:
                    discount += applyFlatPercentPromotion(order, promotion);
                    break;
                default:
            }
        }
        order.setDiscount(discount);
        return discount;
    }

    private int applyBuyXGetYFreePromotion(OrderItem order, Promotion promotion) {
        if (promotion.getRequiredQty() <= 0) {
            return 0;
        }

        int sets = order.getQuantity() / promotion.getRequiredQty();
        int freeItems = sets * promotion.getFreeQty();
        return freeItems * order.getProduct().getPrice();
    }

    private int applyQtyBasedPriceOverridePromotion(OrderItem order, Promotion promotion) {
        if (order.getQuantity() >= promotion.getRequiredQty()) {
            int sets = order.getQuantity() / promotion.getRequiredQty();
            int remainingItems = order.getQuantity() % promotion.getRequiredQty();
            int priceForSets = sets * promotion.getPrice();
            int priceForRemainingItems = remainingItems * order.getProduct().getPrice();
            int originalPrice = order.getProduct().getPrice() * order.getQuantity();
            return originalPrice - (priceForSets + priceForRemainingItems);
        }
        return 0;
    }

    private int applyFlatPercentPromotion(OrderItem item, Promotion promotion) {
        return (int) ((item.getProduct().getPrice() * item.getQuantity()) * (promotion.getAmount() / 100.0));
    }
}
