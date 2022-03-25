# Currency Convert
 >API em java e Spring Boot para converter moeda.
## Descrição

O projeto consiste em uma API Rest usando Java, Spring Boot, H2 e Maven.

 Spring Boot na versão 2.6.4 
``https://spring.io/projects/spring-boot`` 

## Pré-requisitos
Você vai precisar:
* Maven - Apache Maven 3.8.4
* Java - JDK 8
* Lombok 

## Iniciando...

- `git clone https://github.com/lost-username/current-convert.git`

  
# Instruções básicas de como executar o projeto

Vamos construir e executar o programa. Abra uma linha de comando (ou terminal) e navegue até a pasta onde você tem os arquivos do projeto. Podemos construir e executar o aplicativo emitindo o seguinte comando:

OS X & Linux:

```sh
./mvnw spring-boot:run
```

Windows:

```sh
mvnw spring-boot:run
```
## Executando o aplicativo localmente


```sh
http://localhost:8080/v1/convert
```


| Status | Feature | HTTP | Endpoint                            
| ------ | ----------------------------- | ---- | -------------------- |
|   201  | principal                     | POST | **/new**             |
|   200  | busca por Id                  | GET  | **/findby/{id}**     | 
|   200  | busca todos por Id do usuario | GET  | **/findbyname/{id}** |

- ### Payload:
```sh
{
    "fromCurrency": "EUR",
    "toCurrency": "BRL",
    "amount": "50",
    "user": {
        "name": "joao",
        "email":"meumail@email.com"
    }
}
```

## Swagger
Use a biblioteca Swagger atraves uma GUI para executar testes HTTP (GET, POST).

```sh
http://localhost:8080/swagger-ui.html
```

## H2 Database
Para acessar o banco de dados em memória:

```sh
http://localhost:8080/h2-console
```
- url: jdbc:h2:mem:testdb
- username: root
- password: root

## Lombok
O uso da biblioteca do Lombok para gera getter / setter e implementa os métodos toString() e hashCode() de suas bibliotecas de modelo em tempo de compilação. Ele mantém as classes do modelo organizadas e limpas. 
>Você precisa instalar o plugin lombok na ferramenta IDE. Para o eclipse, baixe o lombok.jar do terminal, execute o jar
```sh
$ java -jar lombok.jar
```
# Outras informações

A API foi desenvolvida com arquitetura de camadas entre elas as principais são: Domain, controller, repository e service.