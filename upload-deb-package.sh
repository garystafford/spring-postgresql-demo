#!/bin/sh

# usage: sh ./upload-deb-package.sh ABCD12345

# build and upload Debian package to s3 bucket
# https://github.com/krobertson/deb-s3
# gem install deb-s3

# ar -x spring-postgresql-demo_2.1.0_all.deb # inspect .deb on mac

# sudo apt-get update && sudo apt-get install -y spring-postgresql-demo
# sudo apt-get --force-yes remove spring-postgresql-demo -y
# service --status-all
# service election status

if [ -n "$1" ]
then
  set -xe

  # ./gradlew clean candidate -x test packDeb --info

  deb-s3 upload \
    --bucket garystafford-spinnaker-repo \
    --arch=amd64 \
    --codename=trusty \
    --component=main \
    --visibility=public \
    --sign=$1 \
    build/distributions/*.deb
  echo "Package upload completed successfully!"
else
  echo "No GPG key ID provided?\n(usage: 'sh ./upload-deb-package.sh ABCD12345')"
fi
