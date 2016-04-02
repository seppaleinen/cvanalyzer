# Backend

The backend part of the system
Responsible for 

* Connecting to database
* [Apache Tika - Parsing different document types like (doc, docx, pdf...)](https://tika.apache.org/1.8/examples.html)
* Providing rest-api

Implemented now with [Dropwizard](http://www.dropwizard.io/)
Only a hello world template now, but should be easily replaced with real services from DropwizardApplication

To compile
```
mvn clean install
```

To run mutation tests
```
mvn clean install -Ppitest
```

To run server
```
java -jar target/cvanalyzer-backend.jar server src/main/resources/cv.yml
```