#!/bin/sh

# build and upload Debian package to s3 bucket
# https://github.com/krobertson/deb-s3
# gem install deb-s3

#sh ./upload-deb-package.sh

set -xe

./gradlew clean build -x test buildDeb

deb-s3 upload \
  --bucket garystafford-spinnaker-repo \
  --arch=amd64 \
  --codename=trusty \
  --component=main \
  --visibility=public \
  build/distributions/spring-postgresql-demo_2.1.0_all.deb
