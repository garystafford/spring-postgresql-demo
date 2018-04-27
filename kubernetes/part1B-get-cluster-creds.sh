#!/bin/bash

# part 1b: just get gke/istio cluster creds

# change to match your environment
GCP_PROJECT="springdemo-199819"
GKE_CLUSTER="election-nonprod-cluster"
GCP_ZONE="us-east1-b"

# get creds for cluster
gcloud container clusters get-credentials $GKE_CLUSTER \
  --zone $GCP_ZONE --project $GCP_PROJECT
