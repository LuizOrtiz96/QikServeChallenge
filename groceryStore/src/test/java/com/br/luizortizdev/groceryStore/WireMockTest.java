package com.br.luizortizdev.groceryStore;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import org.junit.ClassRule;
import org.junit.Test;

public class WireMockTest {
    @ClassRule
    public static WireMockClassRule wireMockRule = new WireMockClassRule(8080);

    @Test
    public void testWireMock() {
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/test"))
                .willReturn(WireMock.aResponse().withBody("Hello World!")));
    }
}
