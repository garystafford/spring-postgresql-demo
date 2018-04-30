#!/bin/sh

# build and deploy new jar artifact to the github repository
# jar is then pulled by dockerfile during docker build

#sh ./commit-deb-package.sh

set -xe

./gradlew clean build -x test buildDeb

cd build/distributions

git init
git config user.name "garystafford"
git config user.email "garystafford@rochester.rr.com"
git add *.deb
git commit -m "Deploy Debian package to GitHub"
git push --force --quiet --progress \
  "git@github.com:garystafford/spring-postgresql-demo.git" \
  master:dpkg
