# Sistema de Microserviços para Cadastro de Usuários e Envio de E-mails

Este é um projeto de microserviços em Java para o cadastro de usuários e o envio de e-mails utilizando serviços do Google API e RabbitMQ. O sistema é composto por dois microserviços: um responsável pelo cadastro de usuários e envio de mensagens para o RabbitMQ, e outro para o envio de e-mails aos usuários recém-cadastrados.

## Funcionalidades Principais

- **Cadastro de Usuários:** O microserviço de cadastro de usuários recebe requisições via endpoint para inserir novos usuários no banco de dados PostgreSQL.
- **Envio de Mensagens ao RabbitMQ:** Após o cadastro bem-sucedido, o microserviço envia uma mensagem para um servidor do RabbitMQ para notificar outros serviços sobre o novo cadastro.
- **Envio de E-mails:** O segundo microserviço é responsável por enviar e-mails de boas-vindas aos usuários recém-cadastrados, utilizando a API de envio de e-mails do Google.

## Configuração

1. **Clonagem dos Repositórios:** Clone os repositórios dos microserviços em sua máquina local.

2. **Configuração do Banco de Dados:** Certifique-se de configurar corretamente o PostgreSQL para cada microserviço. Utilize `ms-users` como o nome do banco de dados para o microserviço de usuários e `ms-emails` para o microserviço de e-mails. Atualize as configurações de conexão nos arquivos de propriedades dos microserviços.

3. **Configuração do RabbitMQ:** Configure o RabbitMQ e atualize as configurações de conexão nos microserviços conforme necessário.

4. **Configuração da API do Google:** Obtenha as credenciais e configure o acesso à API de envio de e-mails do Google, atualizando as informações nos arquivos de propriedades do microserviço de envio de e-mails.

5. **Configuração do E-mail de Envio:** Antes de utilizar a aplicação, certifique-se de configurar no arquivo `application.properties` do microserviço de envio de e-mails o seu próprio e-mail de onde devem sair as mensagens de boas-vindas.

6. **Compilação e Execução:** Utilize Maven para compilar e executar cada microserviço.

```bash
# Microserviço de Cadastro de Usuários
cd microservico-usuarios
mvn clean install
mvn spring-boot:run -Dserver.port=8081

# Microserviço de Envio de E-mails
cd microservico-emails
mvn clean install
mvn spring-boot:run -Dserver.port=8082
```

7. **Acesso aos Endpoints:** Os endpoints estarão disponíveis de acordo com a configuração do servidor de aplicação.

## Endpoints

### Microserviço de Cadastro de Usuários

- **GET /users**: Retorna a lista de todos os usuários cadastrados.
- **GET /users/{id}**: Retorna os detalhes do usuário correspondente ao ID especificado.
- **POST /users**: Adiciona um novo usuário ao sistema.
- **PUT /users/{id}**: Atualiza as informações do usuário correspondente ao ID especificado.
- **DELETE /users/{id}**: Remove o usuário correspondente ao ID especificado.

### Microserviço de Envio de E-mails

- **GET /emails**: Retorna todos os e-mails enviados.
- **GET /emails/{id}**: Retorna o e-mail correspondente ao ID especificado.

## Exemplo de Criação de Usuário

Para criar um novo usuário, envie uma requisição HTTP POST para o endpoint `/users` do microserviço de usuários com os detalhes do usuário em formato JSON no corpo da requisição.

Exemplo de JSON:

```json
{
    "name": "João",
    "email": "joao@example.com"
}
```

Este exemplo cria um novo usuário com o nome "João" e o e-mail "joao@example.com". Você pode adaptar os valores do nome e do e-mail conforme necessário para criar diferentes usuários na aplicação.

## Integrações e Tecnologias Utilizadas

- **PostgreSQL:** Banco de dados utilizado para armazenar os dados dos usuários e dos e-mails.
- **RabbitMQ:** Servidor de mensagens utilizado para comunicação entre os microserviços.
- **Google API:** API utilizada para envio de e-mails aos usuários cadastrados.
- **Spring Boot:** Framework utilizado para desenvolvimento dos microserviços em Java.
- **Maven:** Ferramenta de automação de compilação utilizada para gerenciar as dependências e construir os projetos.

Estes microserviços foram configurados para rodar simultaneamente nas portas 8081 e 8082, respectivamente, e utilizam bases de dados PostgreSQL locais para armazenar os dados dos usuários e dos e-mails. Se precisar de mais alguma informação, estou à disposição para ajudar!
