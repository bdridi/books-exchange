#READ ME FILE

##Maven repositories ubuntu : 

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

## Jenkins configuration

* user : admin
* password : admin

Manage Jenkins -> Global Tool Configuration
Configure Maven 
Configure JDK 
Install Git Plugin
Configure Git
Install Post-Build Script Plug-in : run shell commands and scripts after the build step ==> control docker to deploy the jar


## Spring Security :
1. credentials : 
	username :user
	password : 7689e348-fd59-48cc-97cd-499f3efd2d9a	
	
	
## DOCKER CONFIGURATION : 

Prepare a base docker image to deploy the application : 


Post build Script : 

1 - delete old snapshot docker image
2 - run Dockerfile to create a new snapshot image 
	a - copy the built application to the image
	b - copy data base    
   	