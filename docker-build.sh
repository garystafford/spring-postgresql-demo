#!/bin/sh

# docker build -t spring-postgresql-demo:$(git rev-parse --short HEAD) .
docker build --no-cache -t spring-postgresql-demo:latest .

docker-compose -p springdemo up -d
