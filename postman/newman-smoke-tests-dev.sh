#!/bin/bash

COLLECTION="election-k8s-smoke.postman_collection.json"
ENVIRONMENT="spring-postgresql-demo_gke_dev.postman_environment.json"
ITERATIONS=1
DELAY=250

newman run $COLLECTION \
  --environment $ENVIRONMENT \
  --iteration-count $ITERATIONS \
  --no-color \
  --reporters cli,junit
