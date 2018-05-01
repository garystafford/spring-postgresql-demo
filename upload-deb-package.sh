#!/bin/sh

# build and upload Debian package to s3 bucket
# https://github.com/krobertson/deb-s3
# gem install deb-s3

#sh ./upload-deb-package.sh ABCD12345

if [ -n "$1" ]
then
  ./gradlew clean build -x test packDeb

  deb-s3 upload \
    --bucket garystafford-spinnaker-repo \
    --arch=amd64 \
    --codename=trusty \
    --component=main \
    --visibility=public \
    --sign=$1 \
    build/distributions/*.deb
  echo "Upload completed successfully!"
else
  echo "No GPG key ID provided?\n(example: 'sh ./upload-deb-package.sh ABCD12345')"
fi
