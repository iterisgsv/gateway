# Gateway de pagamentos

Este projeto define uma proposta de arquitetura em microserviços para um gateway de pagamentos.

## Descrição

A proposta consiste em 4 microserviços, descritos abaixo:

1. **Transação** - O microserviço principal, que coordena o acesso aos outros serviços. Segue o fluxo desse microserviço:
   1. Primeiramente nos conectamos ao microserviço de autenticação e recebe deste um retorno informando se a autenticação foi bensucedida e qual o tipo de autenticação (Rede ou Cielo). 
   1. Feito isso, ele acessa um dos outros microserviços (transação Rede ou Cielo), dependendo de qual o tipo de autenticação foi recebida, para autorizar a transação no adquirente
   1. Por fim, armazenamos o resultado em uma base PostgreSQL para efeito de log.
1. **Autorização** - Esse microserviço recebe Afiliação e Token e, com base nessas informações, retorna um token válido para autorizar transações na Cielo ou Rede, ou retorna dados de autorização inválida. O mapeamento de dados do cliente e de tokens de autorização é mantido em memória.
1. **Transação Rede** - Microserviço de autorização de transação na Rede. Esse microserviço simula uma requisição de autorização e retorna simplesmente se a transação foi autorizada ou não.
1. **Transação Cielo** - Microserviço de autorização de transação na Cielo. Esse microserviço simula uma requisição de autorização e retorna simplesmente se a transação foi autorizada ou não.

## Módulos
O projeto consiste dos seguintes módulos:

1. **payment-gateway-model** - Contém classes de modelagem de dados comuns a outros projetos
1. **payment-gateway-discovery-server** - Módulo usado como base para criar uma imagem Docker de um servidor Eureka executando na porta padrão 8761.
1. **payment-gateway-proxy** - Este módulo foi criado para gerar uma imagem Docker para subir um servidor de proxy usando a biblioteca Netflix Zuul. Este módulo se conecta ao servidor Eureka para descobrir os microserviços públicos que devem ser expostos, que atualmente inclui apenas o microserviço de transação.
1. **payment-gateway-authentication** - Módulo referente ao microserviço de autenticação descrito acima. Gera uma imagem Docker.
1. **payment-gateway-transaction** - Módulo referente ao microserviço de transação descrito acima. Gera uma imagem Docker.
1. **payment-gateway-transaction-rede** - Módulo referente ao microserviço de simulação de autorização de transações na Rede, descrito acima. Gera uma imagem Docker.
1. **payment-gateway-transaction-cielo** - Módulo referente ao microserviço de simulação de autorização de transações na Cielo, descrito acima. Gera uma imagem Docker.

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

**Observação:** O comando acima executará com sucesso apenas nos módulos que geram uma imagem Docker. Por esse motivo, executar esse comando dentro da pasta raiz do projeto ou na pasta do módulo **payment-gateway-model** irá falhar.

### Kubernetes

Na pasta kubernetes do módulo principal, existem alguns arquivos de configuração usados para subir todos os módulos da aplicação em um cluster Kubernetes. Todos os arquivos contém a definição de um serviço e de uma implantação (deployment).

Para subir todos os módulos da aplicação, basta rodar o comando ```kubectl create``` apontando para essa pasta.

### Docker Compose
A pasta docker do módulo principal contém um arquivo de configuração docker-compose usado para subir todos os módulos da aplicação em containeres do Docker.

Para subir a aplicação usando esse arquivo, basta executar o comando ```docker-compose up``` dentro da pasta ```docker```.
 
Para parar todos os módulos, basta executar o comando ```docker-compose stop``` nessa mesma pasta.

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