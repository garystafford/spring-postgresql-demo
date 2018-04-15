#!/bin/bash

# part 1: build non-prod gke/istio cluster

# change to match your environment
ISTIO_HOME="/Applications/istio-0.7.1"
GCP_DEPLOYMENT_MANAGER="$ISTIO_HOME/install/gcp/deployment_manager"
GCP_PROJECT="springdemo-199819"
GKE_CLUSTER="election-nonprod-cluster"
ISTIO_VER="0.7.1"
GCP_ZONE="us-east1-b"
NODE_COUNT="1"
INSTANCE_TYPE="n1-standard-1"

# deploy gke istio cluster
gcloud deployment-manager deployments create springdemo-istio-demo-deployment \
  --template=$GCP_DEPLOYMENT_MANAGER/istio-cluster.jinja \
  --properties "gkeClusterName:$GKE_CLUSTER,installIstioRelease:$ISTIO_VER,"\
"zone:$GCP_ZONE,initialNodeCount:$NODE_COUNT,instanceType:$INSTANCE_TYPE,"\
"enableAutomaticSidecarInjection:false,enableMutualTLS:true,enableBookInfoSample:false"

# get creds for cluster
gcloud container clusters get-credentials $GKE_CLUSTER \
  --zone $GCP_ZONE --project $GCP_PROJECT

# required dashboard access
kubectl apply -f ./roles/clusterrolebinding-dashboard.yaml

# use dashboard token to sign into dashboard:
kubectl -n kube-system describe secret kubernetes-dashboard-token

# delete gke cluster
# gcloud deployment-manager deployments delete springdemo-istio-demo-deployment -q
