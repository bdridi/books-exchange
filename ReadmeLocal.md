# READ ME FILE

##  Maven repositories ubuntu : 

deb http://ppa.launchpad.net/natecarlson/maven3/ubuntu precise main

deb-src http://ppa.launchpad.net/natecarlson/maven3/ubuntu precise main

##GIT Configuration 

1. Create a new repository on the command line

echo "# books-exchange" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/bdridi/books-exchange.git
git push -u origin master
 

2. Push an existing repository from the command line

git remote add origin https://github.com/bdridi/books-exchange.git
git push -u origin master

##Jenkins configuration

* user : admin
* password : admin

Manage Jenkins -> Global Tool Configuration
Configure Maven 
Configure JDK 
Install Git Plugin
Configure Git
Install Post-Build Script Plug-in : run shell commands and scripts after the build step ==> control docker to deploy the jar


##Spring Security :

1. credentials : 
	username :user
	password : 7689e348-fd59-48cc-97cd-499f3efd2d9a	
	
	
##DOCKER CONFIGURATION : 


### Java8 container :

#### Using DockerFile to create our image.
	
	1- cd to workspace and run the following command : 
	 'docker build -t books-exchanges-docker-image .'
	2 - check if the image is created : 
	 ' docker images '
	2 - run the container
	 ' docker run -t books-exchanges-docker-image'
	     
#### Using Maven docker plugin to create our image
	1- run : 
	 'mvn clean package docker:build'
	2- 
### Mysql container :  

Prepare a base docker image to deploy the application :  java:8 ( for the article ) 

Post build Script :  

1 - Copy the snapshot image => ( .back ) 
2 - delete  docker snapshot image
3 - run Dockerfile to create a new snapshot image
	 
	a - Copy the built application to the image 
   	