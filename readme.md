# Gateway de pagamentos

Este projeto define uma proposta de arquitetura em microserviços para um gateway de pagamentos.
 
Nesta proposta, temos os seguintes módulos:

1. **payment-gateway-model** - Contém classes de modelagem de dados comuns a outros projetos
1. **payment-gateway-discovery-server** - Módulo usado como base para criar uma imagem Docker de um servidor Eureka executando na porta padrão 8761.
1. **payment-gateway-proxy** - Este módulo foi criado para gerar uma imagem Docker para subir um servidor de proxy usando a biblioteca Netflix Zuul. Este módulo se conecta ao servidor Eureka para descobrir os microserviços a ser proxiados.
1. **payment-gateway-authentication** - Módulo que consiste em um microserviço de autenticação em uma adquirente. Esse módulo é usado para gerar uma imagem Docker que sobe um servidor que no momento expõe um serviço REST
1. **payment-gateway-transaction** - Módulo que consiste em um microserviço de criação de uma nova transação. Esse módulo é usado para gerar uma imagem Docker que sobe um servidor que no momento expõe um serviço REST

## Tecnologias usadas

A arquitetura desse sistema utiliza as seguintes tecnologias

* **Maven** para gestão de dependências (bibliotecas) e construção dos artefatos
* **Docker** para gerar containeres em que os módulos da aplicação serão executados
* **Spring** para injeção de dependências e controle do ciclo de vida dos objetos gerados pela aplicação
* **Spring Boot** para configuração e inicialização dos módulos
* **Spring Cloud** para facilitar a integração com tecnologias de provisionamento em nuvem

## Construção e execução

Para construir o projeto, execute o seguinte comando na pasta raiz do projeto

```
mvn install
```

Para construir uma imagem Docker, execute o comando abaixo:

```
mvn docker:build
```

**Observação:** O comando acima executará com suceso apenas nos módulos que geram uma imagem Docker. Por esse motivo, executar esse comando dentro da pasta raiz do projeto ou na pasta do módulo **payment-gateway-model** irá falhar.