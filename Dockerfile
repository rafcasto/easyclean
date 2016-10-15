FROM java:8
VOLUME /tmp
ADD /build/libs/easyclean_profile-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://172.17.0.3:27017/profile", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
