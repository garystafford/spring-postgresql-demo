#!/bin/bash

# *** run from command line ***
# capture the clusterIpv4Cidr and servicesIpv4Cidr values
# required for manual sidecar injection with kube-inject

# change to match your environment
GCP_PROJECT="springdemo-199819"
GKE_CLUSTER="election-nonprod-cluster"
GCP_ZONE="us-east1-b"

CLUSTER_IPV4_CIDR=$(gcloud container clusters describe ${GKE_CLUSTER} \
  --zone ${GCP_ZONE} --project ${GCP_PROJECT} \
  | egrep clusterIpv4Cidr | grep -oE "\b([0-9]{1,3}\.){3}[0-9]{1,3}\/[0-9]{2}\b")

SERVICES_IPV4_CIDR=$(gcloud container clusters describe ${GKE_CLUSTER} \
  --zone ${GCP_ZONE} --project ${GCP_PROJECT} \
  | egrep servicesIpv4Cidr | grep -oE "\b([0-9]{1,3}\.){3}[0-9]{1,3}\/[0-9]{2}\b")

export IP_RANGES="$CLUSTER_IPV4_CIDR,$SERVICES_IPV4_CIDR"

echo $IP_RANGES
