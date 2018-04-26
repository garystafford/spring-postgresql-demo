#!/bin/bash

# part 3: deploy v1 to all environments

env | sort

# election v1 deployment with manual sidecar injection
istioctl kube-inject –kubeconfig "~/.kube/config" \
  -f ./deployments/election-deployment-v1-dev.yaml \
  --includeIPRanges=$IP_RANGES > \
  election-deployment-istio.yaml \
  && kubectl apply -f election-deployment-istio.yaml \
  && rm election-deployment-istio.yaml

istioctl kube-inject –kubeconfig "~/.kube/config" \
  -f ./deployments/election-deployment-v1-test.yaml \
  --includeIPRanges=$IP_RANGES > \
  election-deployment-istio.yaml \
  && kubectl apply -f election-deployment-istio.yaml \
  && rm election-deployment-istio.yaml

istioctl kube-inject –kubeconfig "~/.kube/config" \
  -f ./deployments/election-deployment-v1-uat.yaml \
  --includeIPRanges=$IP_RANGES > \
  election-deployment-istio.yaml \
  && kubectl apply -f election-deployment-istio.yaml \
  && rm election-deployment-istio.yaml

# services
kubectl apply -f ./services/election-service.yaml -n dev
kubectl apply -f ./services/election-service.yaml -n test
kubectl apply -f ./services/election-service.yaml -n uat
# kubectl describe services -n dev

# route rules
kubectl apply -f ./routerules/routerule-election-v1.yaml -n dev
kubectl apply -f ./routerules/routerule-election-v1.yaml -n test
kubectl apply -f ./routerules/routerule-election-v1.yaml -n uat
# kubectl describe routerule -n dev

kubectl get pods -n dev
kubectl get pods -n test
kubectl get pods -n uat
