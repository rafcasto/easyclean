FROM java:8
VOLUME /tmp
ADD /build/libs/manager-dashboard-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8086
RUN bash -c 'touch /app.jar'