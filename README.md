# Desafio back-end - fluig
API desafio que permite a visualização dos veículos com menor consumo de gasolina.

## Testes de API
[Postman](https://www.postman.com/pedrobicudo/workspace/desafio-totvs-fluig/overview)

## Executando o projeto manualmente
#### Gerando o jar pelo Maven
```shell
mvn clean install
```
#### Executando o JAR
Acessando o diretório gerado pelo build
```shell
cd target
```
Executando o jar
```shell
java -jar desafio-0.0.1-SNAPSHOT.jar
```

## Executando o projeto em container Docker
### Criando a imagem
Acesse o diretório do projeto e digite o comando abaixo
```shell
docker build -t desafio .
```
### Criando um container
```shell
docker run -d -p 8080:8080 --name desafio-totvs-fluig desafio
```