#!/bin/sh

# spring-postgresql-demo-0.0.1-SNAPSHOT.jar

cd build/libs
mv *.jar "spring-postgresql-demo-$(git rev-parse --short HEAD).jar"

git init

git add *.jar
git commit -m "Deploy Build artifacts to GitHub"
git push --force --quiet "git@github.com:garystafford/spring-postgresql-demo.git" master:build-artifacts-gke
