#!/bin/sh

# usage: sh ./upload-deb-package.sh ABCD12345

# build and upload Debian package to s3 bucket
# https://github.com/krobertson/deb-s3
# gem install deb-s3

# ar -x spring-postgresql-demo_2.1.0_all.deb # inspect .deb on mac

# sudo apt-get update && sudo apt-get install -y spring-postgresql-demo
# sudo apt-get --force-yes remove spring-postgresql-demo -y
# service election status

# deb-s3 delete spring-postgresql-demo \
#   --arch all \
#   --bucket garystafford-spinnaker-repo \
#   --versions "4.5.0"

if [ -n "$GPG_KEY_ID" ]
then
  set -xe

  deb-s3 upload \
    --bucket garystafford-spinnaker-repo \
    --access-key-id=$AWS_ACCESS_KEY_ID \
    --secret-access-key=$AWS_SECRET_ACCESS_KEY \
    --arch=amd64 \
    --codename=trusty \
    --component=main \
    --visibility=public \
    --sign=$GPG_KEY_ID \
    build/distributions/*.deb
  echo "Package upload completed successfully!"
else
  echo "No GPG key ID provided?\n(usage: 'sh ./upload-deb-package.sh ABCD12345')"
fi
