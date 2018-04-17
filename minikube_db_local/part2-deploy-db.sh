#!/bin/bash

# part 2: deploy db to minimkube local dev

# postgresql in a pod
kubectl apply -f ./resources/postgres-deployment.yaml
# kubectl get deployments -n dev

kubectl apply -f ./resources/postgres-service.yaml
# kubectl describe services -n dev
