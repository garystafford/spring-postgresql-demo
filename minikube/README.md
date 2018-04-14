# Minikube

Before deploying to GKE, you should always test your application, as well as your Kubernetes resource files (secrets, deployments, services, namespaces, routerules, etc.) on minikube.

## Deploy v2 to Minikube

```bash
# create cluster
minikube start

# install Istio 0.7.1 without mTLS
kubectl apply -f $ISTIO_HOME/install/kubernetes/istio.yaml

# deploy v2 to local minikube dev environment
sh ./part1-create-environment.sh
sh ./part2-deploy-v2-dev.sh

# discover URL and port for to connect to v2
# https://istio.io/docs/guides/bookinfo.html
# adjust for minikube ip
export GATEWAY_URL=$(minikube ip):$(kubectl get svc istio-ingress -n istio-system -o 'jsonpath={.spec.ports[0].nodePort}')
echo $GATEWAY_URL

# smoke test election-v2
curl $GATEWAY_URL/v2/
curl $GATEWAY_URL/dev/v2/actuator/health && echo

# kubernetes dashboard
minikube dashboard
```

## Misc. Commands

```bash
brew cask upgrade minikube

minikube version
minikube status
minikube dashboard

minikube get-k8s-versions

eval $(minikube docker-env)
docker ps

kubectl config use-context minikube
kubectl get nodes
kubectl get namespaces
```
