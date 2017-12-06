# Books Exchange Backend
## Spring Boot application for training purpose 

### prerequisites

* Java 1.8
* Docker installed
* Maven 3.x

### Installation :

1- Clone project : 

	'git clone https://github.com/bdridi/books-exchange.git'
	
2- Buid the project and create the docker image : 

	'mvn clean package docker:build'
	
3- Run the container : 

	'docker run -t books-exchanges-docker-image'
	