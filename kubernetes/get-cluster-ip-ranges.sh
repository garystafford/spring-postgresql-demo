#!/bin/bash

# *** run from command line ***
# capture the clusterIpv4Cidr and servicesIpv4Cidr values
# required for manual sidecar injection with kube-inject

CLUSTER_IPV4_CIDR=$(gcloud container clusters describe election-nonprod-cluster \
  --zone us-east1-b --project springdemo-199819 \
  | egrep clusterIpv4Cidr | grep -oE "\b([0-9]{1,3}\.){3}[0-9]{1,3}\/[0-9]{2}\b")

SERVICES_IPV4_CIDR=$(gcloud container clusters describe election-nonprod-cluster \
  --zone us-east1-b --project springdemo-199819 \
  | egrep servicesIpv4Cidr | grep -oE "\b([0-9]{1,3}\.){3}[0-9]{1,3}\/[0-9]{2}\b")

export IP_RANGES="$CLUSTER_IPV4_CIDR,$SERVICES_IPV4_CIDR"

echo $IP_RANGES
