FROM java:8
VOLUME /tmp
ADD /build/libs/roster_services-0.1.0.jar app.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://172.17.0.3:27017/employee", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
