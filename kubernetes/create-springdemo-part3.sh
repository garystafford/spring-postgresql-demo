#!/bin/bash

# apply springdemo resources part 3

# springapp v2 deployment with manual sidecar injection
istioctl kube-inject –kubeconfig "~/.kube/config" \
  -f ./services/springapp-deployment-v2.yaml \
  --includeIPRanges=$IP_RANGES > \
  springapp-deployment-istio-v2.yaml \
  && kubectl apply -f springapp-deployment-istio-v2.yaml \
  && rm springapp-deployment-istio-v2.yaml
