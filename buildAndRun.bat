@echo off
call mvn clean package
call docker build -t com.avbravo/restclientconsumer .
call docker rm -f restclientconsumer
call docker run -d -p 9080:9080 -p 9443:9443 --name restclientconsumer com.avbravo/restclientconsumer