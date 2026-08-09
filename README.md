# Spendwise

## What is Spendwise?

Spendwise is an application to track financials for a user. Financials include accounts own by the user, accounts they own and its balance
transactions made from those accounts, money lent and/or borrowed from another user, and having options to create custom budget

## TechStack

- Backend 
  - Neon DB/PostgreSQL
  - Spring boot
  - Java 21
  - MyBatis
- Frontend
  - React Native

## Tools

- Maven
- Git
- Docker

## API Documentation

```
http://localhost:8080/swagger-ui/index.html
```

## Configuration

| Property      | Description      | Default |
|---------------|------------------|---------|
| Server Port   | Application port | 8080    |
| Logging level | Log verbosity    | INFO    |

## Environment Variable

| Variable   | Description                |
|------------|----------------------------|
| DB_HOST    | Database connection string |
| DB_USER    | Database username          |
| DB_PASS    | Database password          |
| JWT_SECRET | JWT signing key            |

