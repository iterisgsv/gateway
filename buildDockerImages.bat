@echo off
call mvn clean install
call mvn -f ./payment-gateway-authentication/pom.xml docker:build
call mvn -f ./payment-gateway-discovery-server/pom.xml docker:build
call mvn -f ./payment-gateway-proxy/pom.xml docker:build
call mvn -f ./payment-gateway-transaction/pom.xml docker:build
call mvn -f ./payment-gateway-transaction-rede/pom.xml docker:build
call mvn -f ./payment-gateway-transaction-cielo/pom.xml docker:build