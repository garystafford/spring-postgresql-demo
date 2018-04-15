#!/bin/bash

COLLECTION="spring-postgresql-demo-v2.postman_collection.json"
ENVIRONMENT="spring-postgresql-demo_gke_minikube.postman_environment.json"
ITERATIONS=1
DELAY=250

newman run $COLLECTION \
  --environment $ENVIRONMENT \
  --iteration-count $ITERATIONS \
  --no-color \
  --reporters cli,junit
