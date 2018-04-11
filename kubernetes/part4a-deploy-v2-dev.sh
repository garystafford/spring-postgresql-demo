#!/bin/bash

# apply resources part 4a: v2 to dev

# election v2 deployment with manual sidecar injection
istioctl kube-inject –kubeconfig "~/.kube/config" \
  -f ./deployments/election-deployment-v2.yaml \
  --includeIPRanges=$IP_RANGES > \
  election-deployment-istio.yaml \
  && kubectl apply -f election-deployment-istio.yaml -n dev \
  && rm election-deployment-istio.yaml
# kubectl get deployments -n test

# route rules
kubectl apply -f ./routerules/routerule-election-v2.yaml -n dev
# kubectl describe routerule -n dev
