#!/bin/bash

# apply resources part 2A: dev environment

# namespace
kubectl apply -f ./other/namespace-dev.yaml
# kubectl get namespace
# kubectl describe namespace dev

# ingress
kubectl apply -f ./other/ingress-dev.yaml
# kubectl get ingresses -n dev

# secrets
kubectl apply -f ./secrets/secret-postgresql-conn-info-dev.yaml
# kubectl describe secrets -n dev -l type=db
