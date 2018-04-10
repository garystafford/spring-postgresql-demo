#!/bin/bash

# should show routing between v1 and v2

export URL="http://35.185.126.152"

for i in {1..12}
do
  curl $URL/test/actuator/configprops \
    --silent | jq . | grep "PCF Spring PostgreSQL Demo v" | cut -c 6-38
done
