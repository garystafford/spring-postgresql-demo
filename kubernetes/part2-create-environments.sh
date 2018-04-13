#!/bin/bash

# part 2: create dev, test, uat environments

# namespace
kubectl apply -f ./namespaces/namespace-dev.yaml
kubectl apply -f ./namespaces/namespace-test.yaml
kubectl apply -f ./namespaces/namespace-uat.yaml
# kubectl get namespaces
# kubectl describe namespace dev

# ingress
kubectl apply -f ./ingresses/ingress-dev.yaml
kubectl apply -f ./ingresses/ingress-test.yaml
kubectl apply -f ./ingresses/ingress-uat.yaml
# kubectl get ingresses -n dev

# secrets
kubectl apply -f ./secrets/secret-postgresql-conn-info-dev.yaml
kubectl apply -f ./secrets/secret-postgresql-conn-info-test.yaml
kubectl apply -f ./secrets/secret-postgresql-conn-info-uat.yaml
# kubectl describe secrets -n dev -l type=db

# delete springdemo resources only
#kubectl delete namespace dev test uat

kubectl get namespaces
