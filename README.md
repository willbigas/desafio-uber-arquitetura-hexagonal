# Desafio Técnico Uber - EmailService  
##### API de envio de e-mail utilizando arquitetura hexagonal, utilizando do provider de envio de emails em cloud da AWS (SES) para envio de e-mails automatizado

#### [Regras do Desafio](https://github.com/uber-archive/coding-challenge-tools/blob/master/coding_challenge.md)


## Instalação e Uso

#### docker:
  * Rodar no Terminal : `docker image build -t email-service .` 
  * Depois rode no terminal o comando RUN passando as variaveis de suas chaves na AWS como parâmetro (acess-key, secret-key e region) : 
  * `docker run --name email-service -e aws-acess-key='[aws-acess-key]' -e aws-secret-key='[aws-secret-key]' -e aws-region-static='[aws-region-static]' -p 8080:8080 email-service`

#### docker-compose:
  Para rodar no docker compose, ajuste as variaveis de ambiente da imagem dentro do arquivo docker-compose-yml na raiz do projeto:
    `- environment:
      - aws-acess-key: "acessKey"
      - aws-secret-key: "secretKey"
      - aws-region-static: "regiao"`
  * Em seguida Rode no Terminal `docker-compose up -d`
 


## JDK e Dependências
* JDK 17.0.8 LTS
* Spring Boot 3.1.2 (spring-boot-starter-web, spring-boot-devtools, spring-data-jpa , h2-database) 
 
 
## Informações complementares

#### Endpoints
Collection do postman anexada (desafio-uber-email-sender.postman_collection.json) no arquivo do projeto