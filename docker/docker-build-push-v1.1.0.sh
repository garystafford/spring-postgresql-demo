#!/bin/sh

# docker login --username <username> --password <password>

docker build --no-cache -t garystafford/spring-postgresql-demo:1.1.0 .
docker push garystafford/spring-postgresql-demo:1.1.0
