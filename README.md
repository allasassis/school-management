# School Management API
### EN-US:
An RESTful API made in Java, for school management.

This is an API made in Java for school management: students, teachers and support (a controller created for students make questions for their teachers). <br>
It has an authentication method used with Spring Security, where the user needs to
register and then login to generate a JWT code that will track all user requests in the API. All functions use DTO on data input and output.
<br><br>
**All passwords are encrypted when they are registered in the database.** <br><br>
This API uses MongoDB as its database and has unit tests with JUnit 5.
## API Functions:
### Students:
- List Students (Just matriculated students) - `/student`
- Register student - `/student`
- Find student by name - `/student/{name}`
- Find student by zipcode - `/student/address/{zipcode}`
- Update student - `/student`
- Unenroll student - `/student/{id}`

### Teachers:
- List teachers - `/teacher`
- Insert teachers - `/teacher`
- Update teachers - `/teacher/{id}`
- Delete teacher - `/teacher/{id}`

### Support:

- List all questions - `/support`
- List solved questions - `/support/solved`
- List unsolved questions - `/support/notsolved`
- Post question - `/support`
- Mark question as solved - `/support/{id}`

### Authentication:
- Sign up (username and password) - `/authentication/new`
- Sign in - `/authentication`

## Technologies used:

- Java
- Spring Boot
- Spring Security
- MongoDB
- JUnit 5
- Tomcat
- Maven
- Insomnia
- Spring Doc (Open API - Swagger)
- Auth0 (JWT Tokens generator)
- BCrypt Password Encoder

## Documentation
Clone or download the application, upgrade the application.properties with your database link (it must be
a MongoDB database) then
run it, after that consult the documentation with all the methods in the link bellow:
<br>http://localhost:8080/swagger-ui.html

## Author

#### Allas Assis de Oliveira
https://www.linkedin.com/in/allasassis

--------------------------------------------------------
# API de gerenciamento de escola
### PT-BR:

Uma API RESTful feita em Java, para gerenciamento de estoque.

Trata-se de uma API feita em Java para gestão escolar: alunos, professores e suporte (um controlador criado para os alunos tirarem dúvidas para seus professores). <br>
Possui um método de autenticação utilizado com Spring Security, onde o usuário precisa
registrar-se e fazer o login para gerar um código JWT que acompanhará todas as solicitações do usuário na API. Todas as funções usam DTO na entrada e saída de dados.
<br><br>
**Todas as senhas são criptografadas quando são cadastradas no banco de dados.** <br><br>
Essa API utiliza o MongoDB como banco de dados e possui testes unitários com JUnit 5.
## Funções da API:
### Estudantes:
- Listar estudantes (Apenas estudantes matriculados) - `/student`
- Registrar estudante - `/student`
- Encontrar estudante pelo nome - `/student/{name}`
- Encontrar estudante pelo CEP - `/student/address/{zipcode}`
- Atualizar estudante - `/student`
- Desmatricular estudante - `/student/{id}`

### Professores:
- Listar professores - `/teacher`
- Inserir professores - `/teacher`
- Atualizar professores - `/teacher/{id}`
- Deletar professores - `/teacher/{id}`

### Suporte:

- Listar todas as questões - `/support`
- Listar todas as questões resolvidas - `/support/solved`
- Listar todas as questões ***não*** resolvidas  - `/support/notsolved`
- Postar questão - `/support`
- Marcar questão como resolvida - `/support/{id}`

### Autenticação:
- Cadastrar (nome de usuário e senha) - `/authentication/new`
- Fazer login - `/authentication`

## Tecnologias usadas:

- Java
- Spring Boot
- Spring Security
- MongoDB
- JUnit 5
- Tomcat
- Maven
- Insomnia
- Spring Doc (Open API - Swagger)
- Auth0 (Gerador de tokens JWT)
- BCrypt Password Encoder

## Documentação
Clone ou baixe a aplicação, atualize o application.properties com o link do seu banco de dados (tem que ser
um banco de dados MongoDB), após
isso execute o programa e consulte a documentação com todos os métodos no link abaixo:
<br>http://localhost:8080/swagger-ui.html

## Autor

#### Allas Assis de Oliveira
https://www.linkedin.com/in/allasassis


