#!/bin/sh
mvn clean package && docker build -t com.avbravo/restclientconsumer .
docker rm -f restclientconsumer || true && docker run -d -p 9080:9080 -p 9443:9443 --name restclientconsumer com.avbravo/restclientconsumer