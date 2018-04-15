#!/bin/bash

# apply resources part 4c: v2 to uat

# election v2 deployment with manual sidecar injection
istioctl kube-inject –kubeconfig "~/.kube/config" \
  -f ./deployments/election-deployment-v2-uat.yaml \
  --includeIPRanges=$IP_RANGES > \
  election-deployment-istio.yaml \
  && kubectl apply -f election-deployment-istio.yaml \
  && rm election-deployment-istio.yaml
# kubectl get deployments -n uat

# route rules
kubectl apply -f ./routerules/routerule-election-v2.yaml -n uat
# kubectl describe routerule -n uat
