FROM java:8
VOLUME /tmp
ADD dropwizard.jar app.jar
ADD classes/cv.yml cv.yml
RUN bash -c 'touch /app.jar'
EXPOSE 8080 8081

RUN sed -i 's_deb http://httpredir.debian.org/debian_#*/#_g' /etc/apt/sources.list.d/jessie-backports.list

RUN apt-get update -y
RUN apt-get install -y apt-utils apt-transport-https
RUN wget -qO - https://packages.elastic.co/GPG-KEY-elasticsearch | apt-key add -
RUN echo 'deb https://packages.elastic.co/beats/apt stable main' | tee -a /etc/apt/sources.list.d/beats.list
RUN apt-get update -y
RUN apt-get install -y filebeat

ADD filebeat.yml /etc/filebeat/filebeat.yml
#ADD logstash-forwarder.crt /etc/pki/tls/certs/logstash-forwarder.crt
#RUN service filebeat restart

CMD sleep 30 && service filebeat restart && \
    java -Djava.security.egd=file:/dev/./urandom -jar /app.jar server cv.yml