#!/bin/sh

docker build --no-cache -t garystafford/spring-postgresql-demo:2.1.0 .
docker push garystafford/spring-postgresql-demo:2.1.0
