#!/bin/bash

# apply resources part 2

# namespace
kubectl apply -f ./other/namespace-dev.yaml
kubectl apply -f ./other/namespace-test.yaml
# kubectl get namespace
# kubectl describe namespace dev
# kubectl describe namespace test

# ingress
kubectl apply -f ./other/ingress-dev.yaml
kubectl apply -f ./other/ingress-test.yaml
# kubectl get ingresses -n dev
# kubectl get ingresses -n test

# secrets
kubectl apply -f ./secrets/secret-postgresql-conn-info-dev.yaml
kubectl apply -f ./secrets/secret-postgresql-conn-info-test.yaml
# kubectl describe secrets -n dev -l type=db
# kubectl describe secrets -n test -l type=db
