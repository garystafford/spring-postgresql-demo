#!/bin/bash

# apply resources part 4b: v2 to test

# election v2 deployment with manual sidecar injection
istioctl kube-inject –kubeconfig "~/.kube/config" \
  -f ./services/election-deployment-v2-test.yaml \
  --includeIPRanges=$IP_RANGES > \
  election-deployment-istio.yaml \
  && kubectl apply -f election-deployment-istio.yaml \
  && rm election-deployment-istio.yaml
# kubectl get deployments -n test

# route rules
kubectl apply -f ./routerules/routerule-election-v2.yaml -n test
# kubectl describe routerule -n test
