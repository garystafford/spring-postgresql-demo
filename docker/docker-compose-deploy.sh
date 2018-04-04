#!/bin/sh

docker rm -f postgres springdemo
docker-compose -p springdemo up -d
docker logs springdemo --follow
