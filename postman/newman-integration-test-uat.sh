#!/bin/bash

COLLECTION="spring-postgresql-demo-v2.postman_collection.json"
ENVIRONMENT="spring-postgresql-demo_gke_uat.postman_environment.json"
ITERATIONS=3
DELAY=250

newman run $COLLECTION \
  --environment $ENVIRONMENT \
  --iteration-count $ITERATIONS \
  --delay-request $DELAY \
  --no-color \
  --reporters cli,junit
