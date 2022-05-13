# Desafio back-end - fluig
API desafio que permite a visualização dos veículos com menor consumo de gasolina.

## API
### URL base
```
localhost:8080/api
```
### Rota de cadastro de veículos
Verbo HTTP: **POST**
```
/veiculos
```
Estrutura do corpo da requisição
```
{
    "nome": string,
    "marca": string,
    "modelo": string,
    "dataFabricacao": "yyyy-MM-dd",
    "consumoMedioCidadeKML":  double,
    "consumoMedioRodoviaKML": double
}
```
Exemplo
```
{
    "nome": "Renault Kwid",
    "marca": "Renault",
    "modelo": "Kwid",
    "dataFabricacao": "2017-12-12",
    "consumoMedioCidadeKML":  13.6,
    "consumoMedioRodoviaKML": 14.2
}
```

### Rota previsão de gastos
Verbo HTTP: **GET**
```
/previsao-gastos/rank
```
Parâmetros obrigatórios
```
precoGasolina: double  -> Preço da gasolina
totalKmCidade: double  -> Total de Kilômetros percorridos na cidade
totalKmRodovia: double -> Total de Kilômetros percorridos na rodovia
```
Formato de resposta
```
[
  {
        "nome": string,
        "marca": string,
        "modelo": string,
        "ano": integer,
        "litrosDeCombustivelGastos": double,
        "precoTotalGastoComCombustivel": double
  },
  // ...
]
```

Exemplo
```
/previsao-gastos/rank?precoGasolina=8.99&totalKmCidade=50&totalKmRodovia=80

[
    {
        "nome": "Renault Kwid",
        "marca": "Renault",
        "modelo": "Kwid",
        "ano": 2017,
        "litrosDeCombustivelGastos": 9.31,
        "precoTotalGastoComCombustivel": 83.70
    }
]
```

## Testes de API
[Postman](https://www.postman.com/pedrobicudo/workspace/desafio-totvs-fluig/overview)

## Clonando o projeto
```shell
git clone https://github.com/PedroBicudo/desafio-totvs-fluig
```

## Executando o projeto manualmente
#### Gerando o jar pelo Maven
Dentro da pasta `desafio-totvs-fluig` execute o comando abaixo.
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
Dentro da pasta `desafio-totvs-fluig` execute o comando abaixo.
```shell
docker build -t desafio .
```
### Criando um container
```shell
docker run -d -p 8080:8080 --name desafio-totvs-fluig desafio
```
