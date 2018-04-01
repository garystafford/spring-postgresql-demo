#!/bin/sh

set -xe

# spring-postgresql-demo-0.0.1-SNAPSHOT.jar

gradle clean build

cd build/libs
mv *.jar "spring-postgresql-demo-$(git rev-parse --short HEAD).jar"

git init

git add *.jar
git commit -m "Deploy Build artifacts to GitHub"
git push --force --quiet "git@github.com:garystafford/spring-postgresql-demo.git" master:build-artifacts-gke
