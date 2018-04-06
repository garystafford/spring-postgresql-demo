#!/bin/bash

export COLLECTION="spring-postgresql-demo.postman_collection.json"
export ENVIRONMENT="spring-postgresql-demo_gke_dev.postman_environment.json"

newman run $COLLECTION \
  --environment $ENVIRONMENT \
  --iteration-count 5 \
  --delay-request 250
