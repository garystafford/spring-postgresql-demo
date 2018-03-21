# Spring 2.0 PostgreSQL RESTful Service

Spring Boot 2.0 microservice, backed by PostgreSQL, and designed for deployment to Pivotal Cloud Foundry (PCF).

## Build and Run

Local PostgreSQL development database using Docker.

```bash
docker run --name postgres \
  -e POSTGRES_USERNAME=postgres \
  -e POSTGRES_PASSWORD=postgres1234 \
  -e POSTGRES_DB=elections \
  -p 5432:5432 \
  -d postgres
```

Optionally, you can override the db credentials in the `src\main\resources\application.yml` files, `default` Spring Profile.

```bash
set SPRING_DATASOURCE_USERNAME=postgres # export on linux
set SPRING_DATASOURCE_PASSWORD=postgres1234 # export on linux
```

Build and run service locally using local Docker PostgreSQL database instance.

```bash
gradle bootRun
```

## References

* <https://auth0.com/blog/integrating-spring-data-jpa-postgresql-liquibase>
* <http://mrbool.com/rest-server-with-spring-data-spring-boot-and-postgresql/34023>
* <https://www.tutorialspoint.com/postgresql/postgresql_create_database.htm>
* <http://www.vogella.com/tutorials/Lombok/article.html>
* <https://spring.io/guides/gs/accessing-data-jpa>
* <https://dzone.com/articles/integrating-spring-data-jpa-postgresql-and-liquiba>