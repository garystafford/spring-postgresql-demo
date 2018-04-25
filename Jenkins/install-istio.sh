#!/bin/bash

# Install Istio


ISTIO_VERSION="0.7.1"

# install Istio
RUN set +x \
  && curl -O "https://github.com/istio/istio/releases/download/${ISTIO_VERSION}/istio-${ISTIO_VERSION}-linux.tar.gz" \
  && unzip istio-${ISTIO_VERSION}-linux.tar.gz \
  && rm -rf istio-${ISTIO_VERSION}-linux.tar.gz \
  && mv istio-${ISTIO_VERSION} /usr/bin
