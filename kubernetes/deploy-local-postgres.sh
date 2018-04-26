#!/bin/bash

# deploy postgres within cluster vs. external postgres (i.e. AWS)

# set -x

# postgresql in a pod
kubectl apply -f ./postgres-local/postgres-deployment.yaml -n dev

kubectl apply -f ./postgres-local/postgres-service.yaml -n dev
