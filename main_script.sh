#!/bin/bash

echo "script de instalacion de docker"
#sh script_install_docker.sh

echo "script de creacion docker mysql"
sh script_mysql_docker.sh

echo "script backend inicializando"
sh script_backend.sh

echo "script frontend inicializando"
sh script_frontend.sh 

echo "run ensolvers challenge"
