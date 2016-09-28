FROM java:8
VOLUME /tmp
ADD /build/libs/easyclean_timesheets-0.0.1.jar app.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://172.17.0.2:27017/timesheets", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]