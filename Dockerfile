FROM java:8
VOLUME /tmp
EXPOSE 8000
ADD /target/backend-books-exchange-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]