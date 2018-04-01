FROM openjdk:8u162-jdk-alpine
LABEL maintainer="Gary A. Stafford <garystafford@rochester.rr.com>"
ENV REFRESHED_AT 2018-03-31
EXPOSE 8080
RUN set -ex \
  && apk update \
  && apk upgrade \
  && apk add git
RUN mkdir /springdemo \
  && git clone --depth 1 --branch build-artifacts-gke \
      "git@github.com:garystafford/spring-postgresql-demo.git" /springdemo \
  && cd /springdemo \
  && mv spring-postgresql-demo-*.jar spring-postgresql-demo.jar
CMD [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "springdemo/spring-postgresql-demo.jar" ]
