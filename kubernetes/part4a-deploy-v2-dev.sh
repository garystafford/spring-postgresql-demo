#!/bin/bash

# apply resources part 4a: v2 to dev

# election v2 deployment with manual sidecar injection
istioctl kube-inject –kubeconfig "~/.kube/config" \
  -f ./services/election-deployment-v2-dev.yaml \
  --includeIPRanges=$IP_RANGES > \
  election-deployment-istio.yaml \
  && kubectl apply -f election-deployment-istio.yaml \
  && rm election-deployment-istio.yaml
# kubectl get deployments -n test

# routing
kubectl apply -f ./routerules/routerule-election-v2-canary-dev.yaml
# kubectl describe routerule -n dev
