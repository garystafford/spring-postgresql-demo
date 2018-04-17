# Minikube

Before deploying to GKE, you should always test your application, as well as your Kubernetes resource files (secrets, deployments, services, namespaces, route rules, etc.) on minikube.

This version deploys one instance of PostgreSQL to a Pod in `dev` Namespace, as opposed to an external Amazon RDS instance. You should increase Minikube's RAM to at least 3 GB.

## Deploy DB and v2 to Minikube

```bash
# create cluster
minikube start
minikube status

# install Istio 0.7.1 without mTLS
kubectl apply -f $ISTIO_HOME/install/kubernetes/istio.yaml

# deploy postgres and v2 to local minikube dev environment
sh ./part1-create-environment.sh
sh ./part2-db.sh
sh ./part2-deploy-v2.sh
sh ./part3-smoke-test.sh

# kubernetes dashboard
minikube dashboard
```

## Misc. Commands

```bash
brew cask upgrade minikube

minikube version

minikube get-k8s-versions

eval $(minikube docker-env)
docker ps

kubectl config use-context minikube
kubectl get nodes
kubectl get namespaces
```
