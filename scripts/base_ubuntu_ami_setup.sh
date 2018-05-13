#!/usr/bin/env sh

# based on ami-6dfe5010
# Canonical, Ubuntu, 16.04 LTS, amd64 xenial image build on 2018-04-05

# References:
# https://docs.spring.io/spring-boot/docs/current/reference/html/deployment-install.html
# https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/building-shared-amis.html
# https://gist.github.com/justindowning/5921369

set +x

# update and install java
sudo apt-get update -y \
  && sudo apt-get upgrade -y \
  && sudo apt-get install \
    openjdk-8-jre-headless \
    tree htop glances -y

# a few optional ops tools
sudo apt-get install \
    tree htop glances -y

# user:group application will run as
sudo useradd springapp
sudo usermod -a -G springapp springapp
sudo usermod -s /usr/sbin/nologin springapp

# add s3 deb repo
echo "deb http://garystafford-spinnaker-repo.s3-website-us-east-1.amazonaws.com trusty main" | \
  sudo tee -a /etc/apt/sources.list.d/gary-stafford.list
curl -s https://s3.amazonaws.com/garystafford-spinnaker-repo/apt/doc/apt-key.gpg | \
  sudo apt-key add -

# clean up and secure
sudo passwd -l root

sudo shred -u /etc/ssh/*_key /etc/ssh/*_key.pub
[ -f /home/ubuntu/.ssh/authorized_keys ] && rm /home/ubuntu/.ssh/authorized_keys

sudo rm -rf /tmp/*
cat /dev/null > ~/.bash_history
shred -u ~/.*history
history -c
exit
