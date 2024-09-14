# QikServe Engineer Technical Test

## Follow Up Questions

### 1. Quanto tempo você gastou no teste? O que você adicionaria se tivesse mais tempo?
Eu gastei aproximadamente 2 dias no teste. Se eu tivesse mais tempo, eu adicionaria:
- Testes unitários e de integração para garantir a robustez do código.
- Tratamento de erros mais sofisticado para lidar com diferentes cenários de falha.

### 2. Qual foi o recurso mais útil adicionado na última versão da linguagem escolhida? Inclua um trecho de código que mostre como você o utilizou.
Não utilizei nada exclusivo do Java 17, mas sei que poderia utilizar o `var` para declarar o tipo das minhas variáveis.

### 3. O que você achou mais difícil?
Eu achei mais difícil a aplicação das promoções para diferentes cenários.

### 4. Que mecanismo você colocou em prática para rastrear problemas em produção neste código? Se não colocou nada, escreva o que poderia fazer.
Não utilizei nenhum, mas acredito que poderia ter utilizado o Prometheus. Não tenho um amplo conhecimento na ferramenta, mas o pouco que vi e estudei sei que ela faz o monitoramento e emite alertas.

### 5. O Wiremock representa uma fonte de informação. Devemos estar preparados para integrar mais fontes. Liste os passos que precisaríamos tomar para adicionar mais fontes de itens com diferentes formatos e promoções.
1. Definir as interfaces no Spring Feign.
2. Atualizar os serviços.
3. Realizar os testes.
