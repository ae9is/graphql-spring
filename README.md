# graphql-spring

The [Spring GraphQL server example](https://spring.io/guides/gs/graphql-server) extended to run off a Postgres database via Spring JDBC.

# Run

To run the Spring api and Postgres database via Docker:

```bash
direnv allow
make build
make docker-build-gradle
docker compose up -d
```

Open http://localhost:4000/graphiql?path=/graphql

You can also directly run the Spring api at the same time with:

```bash
make run
```

Open http://localhost:8080/graphiql?path=/graphql

# Database cli

```bash
make docker-bash-db
postgres@...$ psql test
test=# \d
```
