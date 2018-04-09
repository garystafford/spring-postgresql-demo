#!/bin/sh

# docker login --username <username> --password <password>

# docker build -t spring-postgresql-demo:$(git rev-parse --short HEAD) .
# docker build --no-cache -t garystafford/spring-postgresql-demo:latest .

docker build --no-cache -t garystafford/spring-postgresql-demo:1.0.0 .
docker push garystafford/spring-postgresql-demo:1.0.0
