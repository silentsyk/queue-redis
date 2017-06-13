FROM 10.10.6.174:5000/java-base-image:1.0.0
VOLUME /tmp
ENV  JAVA_HOME=/opt/java
ENV  PATH=$PATH:$JAVA_HOME/bin
COPY *.jar app.jar
COPY *.sh ./
RUN chmod +x *.sh
COPY *.properties ./
COPY *.xml ./
RUN bash -c 'touch ./app.jar'
EXPOSE 8520
CMD ["./run.sh"]