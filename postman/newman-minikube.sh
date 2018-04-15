#!/bin/bash

export COLLECTION="spring-postgresql-demo-v2.postman_collection.json"
export ENVIRONMENT="spring-postgresql-demo_gke_minikube.postman_environment.json"

newman run $COLLECTION \
  --environment $ENVIRONMENT \
  --iteration-count 5 \
  --delay-request 250 \
  --no-color
