#!/bin/bash

# should show routing between v1 and v2

# set -x

export URL="http://api.test.voter-demo.com"

for i in {1..12}
do
  curl $URL/actuator/configprops \
    --silent | jq . | grep "PCF Spring PostgreSQL Demo v" | cut -c 6-38
done
