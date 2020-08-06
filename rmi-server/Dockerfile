FROM adoptopenjdk/openjdk11:x86_64-alpine-jre-11.0.8_10
ENV JAVA_OPTS="-Djava.net.preferIPv4Stack=true -Djava.net.preferIPv4Addresses=true"
RUN mkdir /opt/app
COPY target/rmi-server-*-exec.jar /opt/app/app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar /opt/app/app.jar