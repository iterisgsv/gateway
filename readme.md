# Gateway de pagamentos

Este projeto define uma proposta de arquitetura em microserviços para um gateway de pagamentos.
 
Nesta proposta, temos os seguintes módulos:

1. **payment-gateway-model** - Contém classes de modelagem de dados comuns a outros projetos
1. **payment-gateway-discovery-server** - Módulo usado como base para criar uma imagem Docker de um servidor Eureka executando na porta padrão 8761.
1. **payment-gateway-proxy** - Este módulo foi criado para gerar uma imagem Docker para subir um servidor de proxy usando a biblioteca Netflix Zuul. Este módulo se conecta ao servidor Eureka para descobrir os microserviços a ser proxiados.
1. **payment-gateway-authentication** - Módulo que consiste em um microserviço de autenticação em uma adquirente. Esse módulo é usado para gerar uma imagem Docker que sobe um servidor que no momento expõe um serviço REST
1. **payment-gateway-transaction** - Módulo que consiste em um microserviço de criação de uma nova transação. Esse módulo é usado para gerar uma imagem Docker que sobe um servidor que no momento expõe um serviço REST
1. **payment-gateway-transaction-rede** - Módulo que consiste em um microserviço de teste para autorizar uma transação no adquirente Rede. Esse módulo gera uma imagem Docker que expõe um microserviço a ser chamado pelo módulo **payment-gateway-transaction**.
1. **payment-gateway-transaction-cielo** - Módulo que consiste em um microserviço de teste para autorizar uma transação no adquirente Cielo. Esse módulo gera uma imagem Docker que expõe um microserviço a ser chamado pelo módulo **payment-gateway-transaction**.

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

O comando ```buildDockerImages.bat``` (para Windows) incluído no projeto realiza a construção do mesmo e constrói todas as imagens Docker de uma só vez. Caso esteja usando um sistema baseado em Unix, utilize o comando ```buildDockerImages.sh```.

Para construir uma imagem Docker específica, execute o comando abaixo dentro da pasta do módulo desejado:

```
mvn docker:build
```

**Observação:** O comando acima executará com suceso apenas nos módulos que geram uma imagem Docker. Por esse motivo, executar esse comando dentro da pasta raiz do projeto ou na pasta do módulo **payment-gateway-model** irá falhar.

## Teste

O microserviço de transaction recebe um json no seguinte formato:

```
{
	"affiliation": "",
	"token": "",
	"transactionType": "CREDIT|DEBIT",
	"amount": 0,
	"cardNumber": "",
	"securityCode": ""
}
```

Os códigos para affiliation e token aceitos pela aplicação são os seguintes:

| Affiliation | Token | Adquirente |
|---|---|---|
| 12345 | 1343234123 | Rede |
| 12346 | 2345244565 | Rede |
| 12347 | 9876574728 | Rede |
| 12348 | 2452345213 | Cielo |
| 12349 | 4325554592 | Cielo |
| 12350 | 8658473676 | Cielo |