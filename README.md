# Casa Câmbio

Serviço responsável pelo cadastro e consulta dos clientes da aplicação Casa de Câmbio.

## Tecnologias

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

## Responsabilidade

O `casa-cambio` mantém os dados dos clientes.

Atualmente permite:

- cadastrar cliente;
- consultar cliente pelo CPF;
- armazenar os clientes no banco H2.

## Estrutura

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
H2
```

## Executando

```bash
mvn spring-boot:run
```

## Cadastrar cliente

```http
POST /clientes
```

Exemplo:

```bash
curl.exe -X POST "http://localhost:8080/clientes" \
-H "Content-Type: application/json" \
-d "{\"nome\":\"Joao Serra\",\"cpf\":\"52998224725\",\"dataNascimento\":\"1990-01-01\",\"sexo\":\"M\",\"estadoCivil\":\"Solteiro\"}"
```

## Consultar cliente

```http
GET /clientes/{cpf}
```

Exemplo:

```bash
curl.exe "http://localhost:8080/clientes/52998224725"
```

Exemplo de resposta:

```json
{
  "id": 2,
  "nome": "Joao Serra",
  "cpf": "52998224725",
  "dataNascimento": "1990-01-01",
  "sexo": "M",
  "estadoCivil": "Solteiro"
}
```

O serviço é utilizado pelo `ordem-service` para verificar se o cliente informado na ordem está cadastrado.
