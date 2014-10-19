#!/bin/bash
################################################################################
# Script for Build: watchout on Ubuntu 14.04 LTS
# Author: Lucas Machado - machadolucas.me
#-------------------------------------------------------------------------------
# This script will build only the watchout java project
# on a configured Ubuntu server
#-------------------------------------------------------------------------------
# USAGE:
#
# ./build.sh
#
################################################################################

# Maven, compile and deploy
cd /home/vagrant/watchout

echo -e "\n==== Stopping Tomcat7 server ===="
sudo service tomcat7 stop

echo -e "\n==== Compiling and deploying project to server ===="
mvn package
sudo rm -rf /var/lib/tomcat7/webapps/ROOT/
sudo rm -rf /var/lib/tomcat7/webapps/ROOT.war
sudo cp target/test-1.0.war /var/lib/tomcat7/webapps/ROOT.war

echo -e "\n==== Starting Tomcat7 server ===="
sudo service tomcat7 start

echo -e "\nDone! Server updated successfully!"