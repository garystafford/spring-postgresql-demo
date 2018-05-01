#!/usr/bin/sh

set -x

APP_HOME="/opt/spring-postgresql-demo/lib"
APP_NAME="spring-postgresql-demo-2.1.0.jar"

ls -al /opt/spring-postgresql-demo/lib

echo $APP_HOME/$APP_NAME

# java -Dserver.port=8199 -jar $APP_HOME/$APP_NAME
# java -jar $APP_HOME/$APP_NAME
