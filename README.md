<br id="topo">

<h1 align="center"> APLICAÇÃO DE MICROSSERVIÇOS EM SISTEMA DE E-COMMERCE </h1>
<h2 align="center">Autor: Jonathas Henrique de Moraes </h2>
<h2 align="center">Orientador: Giuliano Araújo Bertoti </h2>
<h3 align="center"> FATEC Profº Jessen Vidal, SJC - Tecnólogo em Banco de Dados </h3>

<p align="center">
    <a href="#autor">Autor</a> |  
    <a href="#sobre">Sobre</a> | 
    <a href="#tecnologias">Tecnologias</a> | 
    <a href="#aplicacao">Aplicação</a>
</p>
   
<span id="autor">

## :bust_in_silhouette: Sobre o Autor

<img src="./Assets/perfil.jfif" alt="Perfil" width="200"/>

<div style="text-align: justify"> Graduando no curso de Tecnólogo em Banco de dados, técnico formado em Redes de Computadores e desenvolvedor iOS com experiência em Java, Typescript, Python e Javascript, utilizando frameworks como Spring Boot, NestJs e ExpressJS. </div>

&nbsp;
[![Linkedin](https://i.stack.imgur.com/gVE0j.png) LinkedIn](https://www.linkedin.com/in/jonathas-moraes/)
&nbsp;
[![GitHub](http://i.imgur.com/9I6NRUm.png) GitHub](https://github.com/JonyHM)
&nbsp;
[![Twitter](http://i.imgur.com/wWzX9uB.png) Twitter](https://twitter.com/JonyHMoraes)
&nbsp;

→ [Voltar ao topo](#topo)

<span id="sobre">

## :bookmark_tabs: Sobre o projeto

<div style="text-align: justify"> Este projeto foi desenvolvido para o <a href="./Assets/tg_microsservicos.docx">Trabalho de Graduação</a> do curso de Tecnólogo em Banco de Dados da FATEC Professor Jessen Vidal.</div>

## :newspaper: Introdução

<div style="text-align: justify"> A manutenção de um sistema disponível na internet pode se tornar um desafio no caso de um aumento repentino da demanda de acessos. Com a pandemia, muitos sistemas se depararam com este aumento repentino e enfrentam a necessidade de escalar seus serviços e aumentar a disponibilidade para seus clientes. Uma alternativa para uma maior agilidade ao escalar um sistema é construí-lo em componentes e separar cada um deles em diferentes servidores, possibilitando a redundância de instâncias de um mesmo recurso do sistema. Desta forma, o objetivo deste trabalho é construir um sistema de microsserviços exemplificando a aplicação do padrão em um serviço de e-commerce. Neste trabalho desenvolveu-se um sistema que separa funcionalidades em componentes desacoplados e executados em contêineres Docker, possibilitando a escalabilidade por meio da adição de novos serviços, além de permitir a redundância das instâncias de cada funcionalidade. Para que não haja concorrência no acesso ao banco de dados do sistema, cada funcionalidade foi desenvolvida com seu próprio banco de dados, e na eventual necessidade de replicar dados de um serviço para outro, foram utilizados eventos do Apache Kafka. Para atender o objetivo proposto, o sistema se mostrou eficaz, replicando os dados quando necessário e disponibilizando todos os recursos planejados. Entretanto, para um maior controle das instâncias de cada funcionalidade ativa, será necessária a adição de um orquestrador de contêineres Docker, que oferecem gerenciamento de rede, estado atual e escala dos serviços em execução. </div>

&nbsp;

**Palavras-Chave:** Microsserviços, Docker, Apache Kafka, Arquitetura Orientada a Serviços, Arquitetura Orientada a Eventos, GraphQL.

→ [Voltar ao topo](#topo)

<span id="tecnologias">

## 🛠️ Tecnologias

As seguintes ferramentas, linguagens, bibliotecas e tecnologias foram usadas na construção do projeto:

- [Java](https://www.java.com/): Linguagem utilizada no desenvolvimento de todos os serviços.
- [Hibernate](https://hibernate.org/): ORM para mapeamento dos modelos para o banco de dados.
- [Maven](https://maven.apache.org/): Gerenciamento de dependências.
- [H2](https://www.h2database.com/): Banco de dados durante desenvolvimento dos serviços.
- [MariaDB](https://mariadb.org/): Banco de dados para a versão final do projeto.
- [Docker](https://www.docker.com/): Conteinerização para a execução dos microsserviços.
- [Liquibase](https://www.liquibase.org/): Migração de banco de dados.
- [Apache Kafka](https://kafka.apache.org/): Mensageria para arquitetura orientada a eventos.
- [GraphQL](https://graphql.org/): Linguagem de consulta para APIs utilizada no desenvolvimento da maior parte dos microsserviços deste projeto.
- [Git](https://git-scm.com/): Versionamento do código
- [GitHub](https://github.com/): Armazenamento do código
- [Postman](https://www.postman.com/): Testes de chamadas para as APIs

→ [Voltar ao topo](#topo)

<span id="aplicacao">

## :desktop_computer: Aplicação

<div style="text-align: justify"> A aplicação desenvolvida é um simples e-commerce que exemplifica a arquitetura de microsserviços utilizando event-driven architecture. Está dividida em quatro microsserviços (User, Store, Order e Payment), uma API Gateway para requisições de outras aplicações e uma camada de mensageria utilizando Apache Kafka para comunicação entre os serviços. </div>

<img src="./Assets/arquitetura_do_sistema.png" alt="Arquitetura do sistema"/>

- O serviço 'User' armazena informações do perfil do usuário do sistema como nome, documento, endereços e formas de contato.
- O serviço 'Store' armazena dados dos produtos disponíveis para compra, seus valores e detalhes para exibição do catálogo.
- O serviço 'Order' armazena informações do carrinho de compras do usuário como produtos escolhidos e seus valores.
- O serviço 'Payment' armazena dados de pagamento do usuário. Possui uma cópia dos dados importatnes para compra e dados como cartão de crédito e pedido a ser pago.
- A API Gateway recebe as requisições de outras APIs ou de aplicações frontend e direciona para os microsserviços responsáveis pela operação desejada.

### :construction: Dependências para execução

<div style="text-align: justify"> Como o projeto está configurado para execução em contêineres docker, as dependências para a execução serão baixadas no momento da criação da imagem. Desta forma, a única dependência para a execução do projeto é a instalação do <a href="https://www.docker.com/get-started">Docker</a>. </div>

<span id="execucao">

### :arrow_forward: Executando a aplicação

Depois de baixar o Docker e clonar o repositório (ou baixá-lo):

```powershell
# Execute o comando do docker compose para a 
# montagem das imagens de cada microsserviço e instalação das dependências
 docker compose up 

# A API estará disponível pelo endereço: http://localhost:8079/
```

Para testar as requisições para as APIs, é aconselhável o uso do [Postman](https://www.postman.com/), com a ajuda da collection disponibilizada pelo autor. 

Primeiro, baixe o [arquivo](./Assets/microsservices.postman_collection.json) e importe no Postman.

Para importar a collection no Postman, clique em "import":

![Importar collection](./Assets/importar-1.png)

Uma janela com opções se abrirá. Clique em "Upload Files" e escolha o  [arquivo](./Assets/microsservices.postman_collection.json) disponibilizado.

![Importar collection](./Assets/importar-2.png)

→ [Voltar ao topo](#topo)

### :date: Eventos Kafka

A seguir estão alguns exemplos de interações dos eventos Kafka com os serviços que compõem o sistema.

- Criando usuário:

![Criando usuário](./Assets/gifs/create_user.gif)

- Enviando evento "USER_CREATED":

![Envio do evento kafka de criação de usuário](./Assets/gifs/SENDING_USER_CREATED.gif)

- Recebendo evento "USER_CREATED":

![Recebimento do evento kafka de criação de usuário](./Assets/gifs/USER_CREATED.gif)

- Dados replicados para o serviço de Pagamentos pelo evento "USER_CREATED":

![Customer criado por evento kafka](./Assets/gifs/customer_query.gif)

- Criando Endereço:

![Criando endereço](./Assets/gifs/create_address.gif)

- Enviando evento "ADDRESS_CREATED":

![Envio do evento kafka de criação de endereço](./Assets/gifs/ADDRESS_CREATED.gif)

- Recebendo evento "ADDRESS_CREATED":

![Recebimento do evento kafka de criação de endereço](./Assets/gifs/CREATE_ADDRESS-receive.gif)

- Dados replicados pelo evento "ADDRESS_CREATED":

![Endereço criado por evento kafka](./Assets/gifs/address_data_replication.gif)

- Excluíndo endereço e validando dados excluidos pelo evento "ADDRESS_DELETED":

![Excluíndo endereço](./Assets/gifs/address_deletion.gif)

- Enviando evento de exclusão de endereço "ADDRESS_DELETED":

![Envio do evento kafka de exclusão de endereço](./Assets/gifs/ADDRESS_DELETED_sent.gif)

- Recebendo evento de exclusão de endereço "ADDRESS_DELETED":

![Recebimento do evento kafka de exclusão de endereço](./Assets/gifs/ADDRESS_DELETED_received.gif)

- Criando produtos:

![Criando produtos](./Assets/gifs/create_products.gif)

- Criando carrinho de compras:

![Criando carrinho de compras](./Assets/gifs/create_cart.gif)

- Enviando evento "ORDER_STARTED":

![Enviando evento ORDER_STARTED](./Assets/gifs/ORDER_STARTED_sent.gif)

- Recebendo evento "ORDER_STARTED" na loja:

![Recebendo evento ORDER_STARTED na loja](./Assets/gifs/ORDER_STARTED_received_store.gif)

- Dados alterados pelo evento "ORDER_STARTED" na loja:

![Dados alterados pelo evento "ORDER_STARTED" na loja](./Assets/gifs/ORDER_STARTED_store_data.gif)

- Recebendo evento "ORDER_STARTED" no pagamento:

![Recebendo evento ORDER_STARTED no pagamento](./Assets/gifs/ORDER_STARTED_received_payment.gif)

- Dados replicados pelo evento "ORDER_STARTED" no pagamento:

![Dados replicados no pagamento](./Assets/gifs/ORDER_STARTED_payment_data.gif)

- Criando cartão para pagamentos:

![Criando cartão](./Assets/gifs/create_card.gif)

- Pagando pedido:

![Pagando pedido](./Assets/gifs/paying_order.gif)

- Enviando evento "ORDER_PAID":

![Enviando evento ORDER_PAID](./Assets/gifs/ORDER_PAID_sent.gif)

- Recebendo evento "ORDER_PAID" e enviando evento "CART_PAID" no OrderService:

![Recebendo evento "ORDER_PAID" e enviando evento "CART_PAID"](./Assets/gifs/ORDER_PAID_received_and_CART_PAID_sent.gif)

- Evento "ORDER_PAID" replicando para OrderService, mudando status:

![Evento "ORDER_PAID" mudando status no OrderService](./Assets/gifs/ORDER_PAID_received.gif)

- Recebendo evento "CART_PAID" no StoreService:

![Recebendo evento "CART_PAID" no StoreService](./Assets/gifs/CART_PAID_received.gif)

- Dados alterados pelo evento "CART_PAID" no StoreService:

![Dados alterados pelo evento "CART_PAID"](./Assets/gifs/CART_PAID_data_changed.gif)