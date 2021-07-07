#!/bin/bash
LABEL=$(date +'%Y%m%d-%H%M%S')
mvn clean package && docker build -t cl.ulagos/electivo2:$LABEL .
docker rm -f electivo2 || true && docker run -it -p 8080:8080 -p 4848:4848 --name electivo2 cl.ulagos/electivo2:$LABEL

