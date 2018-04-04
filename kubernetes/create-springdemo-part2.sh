#!/bin/bash

# apply springdemo resources part 2

# namespace
kubectl apply -f ./other/springdemo-namespace.yaml

# ingress
kubectl apply -f ./other/springdemo-ingress.yaml

# secrets
kubectl apply -f ./secrets/postgresql-connection-info-secret.yaml

# *** change to your own gke cluster's ranges! ***
# gcloud container clusters describe springdemo-istio-gke \
#   --zone us-east1-b --project springdemo-199819 \
#   | egrep 'clusterIpv4Cidr|servicesIpv4Cidr'

export IP_RANGES="10.32.0.0/14,10.35.240.0/20"

# springapp v1 deployment with manual sidecar injection
istioctl kube-inject –kubeconfig "~/.kube/config" \
  -f ./services/springapp-deployment-v1.yaml \
  --includeIPRanges=$IP_RANGES > \
  springapp-deployment-istio-v1.yaml \
  && kubectl apply -f springapp-deployment-istio-v1.yaml \
  && rm springapp-deployment-istio-v1.yaml

# services
kubectl apply -f ./services/springapp-service.yaml
