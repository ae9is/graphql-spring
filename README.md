# graphql-spring

The [Spring GraphQL server example](https://spring.io/guides/gs/graphql-server) extended to run off a Postgres database via Spring JDBC.

# Run

```bash
direnv allow
docker compose up -d
make run
```

Open http://localhost:8080/graphiql?path=/graphql

# Database cli

```bash
make docker-bash-db
postgres@...$ psql test
test=# \d
```
