#!/bin/bash

# apply springdemo resources part 2

# change to match your local environment
export ISTIO_HOME="/Applications/istio-0.7.1"
export GCP_DEPLOYMENT_MANAGER="$ISTIO_HOME/install/gcp/deployment_manager"

# deploy gke istio cluster
gcloud deployment-manager deployments create springdemo-istio-demo-deployment \
  --template=$GCP_DEPLOYMENT_MANAGER/istio-cluster.jinja \
  --properties gkeClusterName:springdemo-istio-gke,zone:us-east1-b,instanceType:n1-standard-1,enableAutomaticSidecarInjection:false,enableBookInfoSample:false,enableMutualTLS:true

# get creds for cluster
gcloud container clusters get-credentials springdemo-istio-gke \
  --zone us-east1-b --project springdemo-199819

# required dashboard access
kubectl apply -f ./other/kube-system-cluster-admin.yaml

# delete cluster
# gcloud deployment-manager deployments delete springdemo-istio-demo-deployment -q
