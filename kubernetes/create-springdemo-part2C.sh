#!/bin/bash

# apply resources part 2C: uat environment

# namespace
kubectl apply -f ./other/namespace-uat.yaml
# kubectl get namespace
# kubectl describe namespace uat

# ingress
kubectl apply -f ./other/ingress-uat.yaml
# kubectl get ingresses -n uat

# secrets
kubectl apply -f ./secrets/secret-postgresql-conn-info-uat.yaml
# kubectl describe secrets -n uat -l type=db
