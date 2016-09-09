FROM java:8
VOLUME /tmp
ADD /build/libs/easyclean_roster-0.1.0.jar app.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://172.17.0.2:27017/roster", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
