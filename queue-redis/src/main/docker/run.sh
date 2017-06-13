#!/bin/bash
cp -rf /mnt/config/* /
java ${JAVA_OPTS} -jar app.jar
