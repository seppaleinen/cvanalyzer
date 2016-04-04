FROM java:8

RUN wget -qO - https://packages.elastic.co/GPG-KEY-elasticsearch | apt-key add -

RUN echo "deb http://packages.elastic.co/elasticsearch/2.x/debian stable main" | tee -a /etc/apt/sources.list.d/elasticsearch-2.x.list && \
    echo "deb http://packages.elastic.co/kibana/4.4/debian stable main" | tee -a /etc/apt/sources.list.d/kibana-4.4.x.list && \
    echo 'deb http://packages.elastic.co/logstash/2.2/debian stable main' | tee /etc/apt/sources.list.d/logstash-2.2.x.list

RUN apt-get update -y

RUN apt-get install -y elasticsearch kibana nginx apache2-utils logstash unzip

# TODO set network.host: localhost in /etc/elasticsearch/elasticsearch.yml
# TODO set server.host: "localhost" in /opt/kibana/config/kibana.yml
ADD default /etc/nginx/sites-available/default
ADD htpasswd.users /etc/nginx/htpasswd.users

RUN mkdir -p /etc/pki/tls/certs
RUN mkdir /etc/pki/tls/private
RUN openssl req -subj '/CN=ELK_server_fqdn/' \
    -x509 -days 3650 -batch -nodes -newkey rsa:2048 \
    -keyout /etc/pki/tls/private/logstash-forwarder.key -out /etc/pki/tls/certs/logstash-forwarder.crt
ADD 02-beats-input.conf /etc/logstash/conf.d/02-beats-input.conf
ADD 10-syslog-filter.conf /etc/logstash/conf.d/10-syslog-filter.conf
ADD 30-elasticsearch-output.conf /etc/logstash/conf.d/30-elasticsearch-output.conf

RUN curl -L -O https://download.elastic.co/beats/dashboards/beats-dashboards-1.1.0.zip && \
    curl -O https://gist.githubusercontent.com/thisismitch/3429023e8438cc25b86c/raw/d8c479e2a1adcea8b1fe86570e42abab0f10f364/filebeat-index-template.json

RUN service elasticsearch restart && \
    service kibana start && \
    service nginx restart && \
    service logstash restart

#RUN unzip beats-dashboards-*.zip && cd beats-dashboards-1.1.0 && ./load.sh
#RUN curl -XPUT 'http://localhost:9200/_template/filebeat?pretty' -d@filebeat-index-template.json