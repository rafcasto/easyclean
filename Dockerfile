FROM java:8
VOLUME /tmp
ADD /build/libs/easyclean.jar app.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://192.168.1.2:32776/microserviceblog", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
