# 🎓 Aluno Online API

Uma API RESTful desenvolvida em **Java** com **Spring Boot** para o gerenciamento acadêmico de alunos, professores, disciplinas e matrículas. O sistema conta com uma arquitetura robusta e segura, utilizando **Spring Security** e **JWT (JSON Web Token)** para controle de acesso *Stateless*, além de documentação automatizada com **Swagger**.

---

## 🚀 Tecnologias Utilizadas

*   **Java 17+**
*   **Spring Boot 3**
*   **Spring Data JPA** (Persistência de dados)
*   **Spring Security** (Autenticação e Autorização)
*   **Auth0 JWT** (Geração e validação de tokens)
*   **SpringDoc OpenAPI / Swagger** (Documentação da API)
*   **Lombok** (Redução de boilerplate)
*   **Maven** (Gerenciamento de dependências)

---

## ⚙️ Funcionalidades

### 📚 Regra de Negócio (Core)
*   **Alunos & Professores:** CRUD completo.
*   **Disciplinas:** Cadastro de disciplinas vinculadas a professores.
*   **Matrículas:** Matrícula de alunos em disciplinas, atualização de notas, trancamento e emissão de histórico escolar.

### 🔒 Segurança (Spring Security + JWT)
*   **Stateless:** API sem guarda de estado (sessão), ideal para escalabilidade.
*   **Criptografia:** Senhas salvas no banco de dados com Hashing irreversível (**BCrypt**).
*   **Filtro de Interceptação:** Validação de token via cabeçalho `Authorization: Bearer <token>` em todas as requisições privadas.
*   **Controle de Rotas:** Endpoints de login, cadastro e documentação totalmente abertos; demais rotas restritas a usuários autenticados.

---

## 📖 Documentação da API (Swagger)

A API possui documentação interativa gerada automaticamente. Após iniciar o projeto, você pode acessá-la em:

👉 **[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)**

*Nota: A interface do Swagger foi configurada com o `SecurityScheme`. Basta clicar no botão verde **"Authorize"**, colar o seu Token JWT e testar todas as rotas privadas diretamente pelo navegador.*

---

## 🛠️ Como rodar o projeto localmente

### 1. Pré-requisitos
*   Java JDK 17 ou superior.
*   Maven instalado.
*   Banco de dados configurado (MySQL/PostgreSQL) ou uso do H2 (em memória).

### 2. Variáveis de Ambiente
O sistema utiliza uma assinatura de segurança para gerar o Token JWT. Você deve configurar a seguinte variável de ambiente (ou adicioná-la ao `application.properties` para testes locais):

```properties
api.security.token.secret=SUA_CHAVE_SECRETA_AQUI

3. Executando a Aplicação

Clone o repositório e rode os comandos abaixo na raiz do projeto:

# Limpar e compilar o projeto
mvn clean install

# Rodar a aplicação
mvn spring-boot:run

A API estará disponível na porta 8080.

🔐 Fluxo de Autenticação (Como testar)

A API bloqueia acessos não autorizados (Erro 403 Forbidden). Para testar, siga o
fluxo:

1. Crie um usuário:

  - POST /cadastros

{
  "login": "usuario@email.com",
  "senha": "123"
}

2. Faça o Login:

  - POST /login

{
  "login": "usuario@email.com",
  "senha": "123"
}

O sistema retornará um JSON contendo o token.

3. Acesse rotas privadas: Copie o token gerado e envie nas próximas requisições
no cabeçalho HTTP:

  - Key: Authorization
  - Value: Bearer SEU_TOKEN_AQUI

Exemplo de requisição privada:

  - GET /alunos
  - GET /professores

👨‍💻 Autoria

Desenvolvido como parte do aprendizado em Arquitetura Back-end, Boas Práticas,
Autenticação e Segurança de APIs REST.

