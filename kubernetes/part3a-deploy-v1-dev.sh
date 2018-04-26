#!/bin/bash

# apply resources part 3a: v1 to dev

# election v1 deployment with manual sidecar injection
kubectl apply -f ./deployments/election-deployment-v1-dev.yaml

# services
kubectl apply -f ./services/election-service.yaml -n dev

# route rules
kubectl apply -f ./routerules/routerule-election-v1.yaml -n dev

kubectl get pods -n dev
