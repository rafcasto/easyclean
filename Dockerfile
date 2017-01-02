FROM java:8
VOLUME /tmp
ADD /build/libs/easyclean_sendmail-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://172.17.0.2:27017/employee", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
