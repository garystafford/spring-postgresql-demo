FROM openjdk:8-jdk-alpine
LABEL maintainer="Gary A. Stafford <garystafford@rochester.rr.com>"
ENV REFRESHED_AT 2018-04-22
EXPOSE 8080
RUN set -ex \
  && apk update \
  && apk upgrade
RUN mkdir /springdemo
COPY *.jar /springdemo/
WORKDIR /springdemo
CMD [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "spring-postgresql-demo.jar" ]
