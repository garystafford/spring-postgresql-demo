#!/bin/bash

# apply resources part 1

# change to match your local environment
export ISTIO_HOME="/Applications/istio-0.7.1"
export GCP_DEPLOYMENT_MANAGER="$ISTIO_HOME/install/gcp/deployment_manager"

export GCP_PROJECT="springdemo-199819"
export GKE_CLUSTER="springdemo-istio-gke"

# deploy gke istio cluster
gcloud deployment-manager deployments create springdemo-istio-demo-deployment \
  --template=$GCP_DEPLOYMENT_MANAGER/istio-cluster.jinja \
  --properties gkeClusterName:$GKE_CLUSTER,zone:us-east1-b,initialNodeCount:2,instanceType:n1-standard-1,enableAutomaticSidecarInjection:false,enableMutualTLS:true,enableBookInfoSample:false

# get creds for cluster
gcloud container clusters get-credentials $GKE_CLUSTER \
  --zone us-east1-b --project $GCP_PROJECT

# required dashboard access
kubectl apply -f ./other/kube-system-cluster-admin.yaml

# delete springdemo resources only
#kubectl delete namespace dev test

# delete gke cluster
# gcloud deployment-manager deployments delete springdemo-istio-demo-deployment -q
