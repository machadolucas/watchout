#!/bin/bash
################################################################################
# Script for Installation: watchout on Ubuntu 14.04 LTS
# Author: Lucas Machado - machadolucas.me
#-------------------------------------------------------------------------------
# This script will install watchout on
# clean Ubuntu 14.04 Server
#-------------------------------------------------------------------------------
# USAGE:
#
# ./install.sh
#
################################################################################

# fixed parameters
WATCHOUT_USER="vagrant"
WATCHOUT_HOME="/home/$WATCHOUT_USER/watchout"

# branch to download from repository
CODE_BRANCH="master"

#sudo mkdir /home/vagrant/watchout

export LANGUAGE=en_US.UTF-8
export LANG=en_US.UTF-8
export LC_ALL=en_US.UTF-8
export LC_CTYPE=en_US.UTF-8
locale-gen en_US.UTF-8
dpkg-reconfigure locales
sudo locale-gen UTF-8
#--------------------------------------------------
# Update Server
#--------------------------------------------------
echo -e "\n---- Updating Ubuntu Server ----"
sudo apt-get update -y
sudo apt-get upgrade -y

#--------------------------------------------------
# Install Dependencies
#--------------------------------------------------
echo -e "\n---- Installing Dependencies ----"
sudo locale-gen UTF-8
export LC_ALL=en_US.UTF-8
export LANGUAGE=en_US.UTF-8

sudo echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections

sudo apt-get install build-essential rsync telnet screen man wget -y
sudo apt-get install strace tcpdump -y
sudo apt-get install libssl-dev zlib1g-dev libcurl3-dev libxslt-dev -y
sudo apt-get install software-properties-common python-software-properties -y
sudo apt-get install git -y

echo -e "\n==== Installing MySql database ===="
# MySql
sudo apt-get install debconf-utils
echo "mysql-server-5.5 mysql-server/root_password password watchout\!test" > /home/vagrant/mysql.preseed
echo "mysql-server-5.5 mysql-server/root_password_again password watchout\!test" >> /home/vagrant/mysql.preseed
echo "mysql-server-5.5 mysql-server/start_on_boot boolean true" >> /home/vagrant/mysql.preseed
cat /home/vagrant/mysql.preseed | sudo debconf-set-selections
sudo apt-get install -y mysql-server
echo -e "\n==== Creating and configuring database ===="
sudo cp /home/vagrant/watchout/.my.cnf /home/vagrant/
su $WATCHOUT_USER -c mysql < /home/vagrant/watchout/CreateDb.sql

echo -e "\n==== Installing Java ===="
# Java 8
sudo add-apt-repository ppa:webupd8team/java -y
sudo apt-get update -y
sudo apt-get install oracle-java8-installer -y
sudo apt-get install ant -y

echo -e "\n==== Installing Tomcat7 server ===="
# Tomcat7
sudo apt-get install tomcat7 -y
JAVA_FOR_TOMCAT=$(eval "which java | sed -e 's|/bin/java||g'")
sudo sed -i "s|^#JAVA_HOME=.*|JAVA_HOME=$JAVA_FOR_TOMCAT|g" /etc/default/tomcat7

# Maven, compile and deploy
sudo apt-get install maven -y
cd /home/vagrant/watchout
echo -e "\n==== Compiling and deploying project to server ===="
mvn package
sudo rm -rf /var/lib/tomcat7/webapps/ROOT/
sudo cp target/test-1.0.war /var/lib/tomcat7/webapps/ROOT.war

echo -e "\n==== Starting Tomcat7 server ===="
sudo service tomcat7 start

echo -e "\nDone! Server installed successfully!"