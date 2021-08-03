# Register of vehicles


<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#about-the-project">Sobre o projeto</a>
      <ul>
        <li><a href="#built-with">Tecnologias utilizadas</a></li>
        <li><a href="#prerequisites">Pré-requisitos</a></li>
        <li><a href="#installation">Como utilizar</a></li>
      </ul>
    </li>
    <li><a href="#contact">Contato</a></li>
    <li><a href="#acknowledgements">Links úteis</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## Sobre o projeto

Esse projeto visa responder os exercícios enviados por email para a avaliação técnica.

Cada Controller desenvolvido correponde a um dos exercícios presentes no pdf enviado.

A lógica do desenvolvimento dos exercícios se encontra nos services utilizados pelos controllers correspondentes

A documentação de cada endpoint utilizado encontra-se nesta página:

http://localhost:8080/swagger-ui.html

### Tecnologias utilizadas

As principais tecnologias utilizadas neste projeto foram:

* [Java 11](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
* [Maven](https://maven.apache.org/)
* [Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [H2 Embedded database](https://www.h2database.com/html/main.html)
* [Swagger](https://swagger.io/)
* [Junit](https://junit.org/junit5/)

### Pré-requisitos

1. Possuir a jdk do java 11 instalada e configurada em seu ambiente
2. Instalar o maven localmente
3. Nenhuma aplicação deve utilizar a porta 8080

### Como utilizar

Após instalar o Java 11 e configurar o maven, será necessário apenas executar o seguinte comando no terminal ou console do seu dispositivo:

`mvn clean spring-boot:run`

Para executar as APIs desenvolvidas pode-se utilizar o endpoint http://localhost:8080/swagger-ui.html que possui todas 
as APIs desenvolvidas no projeto

## Contato

https://www.linkedin.com/in/henrique-silva-bortoletti/

## Links úteis

Download Java 11:

https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html

Como instalar o Maven?

https://maven.apache.org/install.html


