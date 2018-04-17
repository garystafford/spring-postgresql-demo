#!/bin/bash

# part 2: deploy v2 to minimkube local dev

# election v2 deployment with manual sidecar injection
istioctl kube-inject –kubeconfig "~/.kube/config" \
  -f ./resources/election-deployment-v2.yaml \
  --includeIPRanges=10.0.0.1/24 > \
  election-deployment-istio.yaml \
  && kubectl apply -f election-deployment-istio.yaml \
  && rm election-deployment-istio.yaml
# kubectl get deployments -n dev

# route rules
kubectl apply -f ./resources/routerule-election-v2.yaml
# kubectl describe routerule -n dev

kubectl apply -f ./resources/election-service.yaml
# kubectl describe services -n dev
