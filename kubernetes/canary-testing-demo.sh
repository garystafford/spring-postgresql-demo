#!/bin/bash

# should show routing of 75% of requests to v2 and 25% to v1

export URL="http://35.196.97.146"

for i in {1..12}
do
  curl $URL/test/actuator/configprops \
    --silent | jq . | grep "PCF Spring PostgreSQL Demo v" | cut -c 6-38
done
