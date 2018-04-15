#!/bin/bash

export GATEWAY_URL=$(minikube ip):$(kubectl get svc istio-ingress -n istio-system -o 'jsonpath={.spec.ports[0].nodePort}')
echo $GATEWAY_URL

curl $GATEWAY_URL/v2/actuator/health && echo
