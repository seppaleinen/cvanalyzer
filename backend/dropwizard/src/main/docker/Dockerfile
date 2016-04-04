FROM anapsix/alpine-java:8
VOLUME /tmp
ADD dropwizard.jar app.jar
ADD classes/cv.yml cv.yml
RUN bash -c 'touch /app.jar'
EXPOSE 8080 8081
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar", "server", "cv.yml"]
