FROM java:8
VOLUME /tmp
ADD /build/libs/roster_services-0.1.0.jar app.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://192.168.1.2:32776/employee", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
