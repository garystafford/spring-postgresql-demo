#!/bin/bash

# apply resources part 2B: test environment

# namespace
kubectl apply -f ./other/namespace-test.yaml
# kubectl get namespace
# kubectl describe namespace test

# ingress
kubectl apply -f ./other/ingress-test.yaml
# kubectl get ingresses -n test

# secrets
kubectl apply -f ./secrets/secret-postgresql-conn-info-test.yaml
# kubectl describe secrets -n test -l type=db
