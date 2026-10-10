# Gerenciamento de Pedidos

Projeto desenvolvido em Java com o objetivo de implementar um sistema simples de gerenciamento de pedidos, aplicando conceitos de programação orientada a objetos, validação de dados e regras de negócio.

A aplicação permite criar pedidos, adicionar produtos, calcular valores e controlar o status dos pedidos, com testes automatizados para validar os comportamentos implementados.

## Funcionalidades

- Cadastro de produtos por meio de objetos.
- Validação dos dados dos produtos.
- Criação de itens de pedido com produto e quantidade.
- Cálculo do subtotal de cada item.
- Cálculo do valor total do pedido.
- Controle de status: pendente, pago e cancelado.
- Validação das operações de pagamento e cancelamento.
- Bloqueio da inclusão de itens em pedidos pagos ou cancelados.
- Testes automatizados das principais regras de negócio.

## Tecnologias utilizadas

- **Java 21** — linguagem de programação.
- **Maven** — gerenciamento do projeto e das dependências.
- **JUnit 5** — testes automatizados.
- **IntelliJ IDEA** — ambiente de desenvolvimento.

## Estrutura do projeto

```text
gerenciamento-pedidos/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/pedro/pedidos/
│   │           ├── App.java
│   │           ├── Produto.java
│   │           ├── ItemPedido.java
│   │           ├── Pedido.java
│   │           └── StatusPedido.java
│   └── test/
│       └── java/
│           └── com/pedro/pedidos/
│               ├── ProdutoTest.java
│               ├── ItemPedidoTest.java
│               └── PedidoTest.java
├── .gitignore
├── pom.xml
└── README.md
```

## Regras de negócio

### Produtos
- O ID deve ser positivo.
- O nome não pode ser nulo ou vazio.
- O preço deve ser maior que zero.

### Itens do pedido
- O produto deve ser válido.
- A quantidade deve ser maior que zero.
- O subtotal é calculado multiplicando o preço do produto pela quantidade.

### Pedidos
- Um pedido começa com o status `PENDENTE`.
- Apenas pedidos pendentes podem ser pagos ou cancelados.
- Apenas pedidos pendentes podem receber novos itens.
- O valor total corresponde à soma dos subtotais dos itens.

## Como executar

### Pré-requisitos

- JDK 21 instalado.
- Maven instalado ou configuração Maven disponível na IDE.

### Executar a aplicação

Abra o projeto no IntelliJ IDEA, localize a classe `App.java` e execute o método `main()`.

A aplicação apresenta no console um exemplo de criação de pedido, cálculo dos subtotais, cálculo do total e alteração do status após o pagamento.

### Executar os testes

No IntelliJ IDEA, acesse `src/test/java`, clique com o botão direito no pacote de testes e selecione a opção para executar todos os testes.

Também é possível executar os testes pelo terminal, na raiz do projeto, com:

```bash
mvn test
```

## Exemplo de execução

```text
=== GERENCIAMENTO DE PEDIDOS ===
Status: PENDENTE
Subtotal dos notebooks: R$ 7000.00
Subtotal do teclado: R$ 150.00
Total do pedido: R$ 7150.00
Status após pagamento: PAGO
```

## Limitações da versão atual

Esta é a primeira versão funcional do projeto. Os dados são mantidos em memória durante a execução, sem persistência em banco de dados ou integração com API.

O foco desta versão é consolidar as regras de negócio, a orientação a objetos e os testes automatizados. Novas funcionalidades e melhorias arquiteturais poderão ser implementadas em versões futuras.

## Autor

Desenvolvido por Pedro Henrique como projeto de estudo e portfólio na área de desenvolvimento de software.