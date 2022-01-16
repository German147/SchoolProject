

# SchoolProject
###### Desktop application created with SpringBoot, and Postgresql relational database.
<br/>

### Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
SpringBoot Resfull Aplication where students, teachers, tutors and Admins can performs the correspond services like Get, Put, Post, Delete...but with their permissions.
It is implemented SpringSecurity with their Roles and permiossions. It has many branches because I am learniong about SpringSecurity.


### Technologies and dependencies


````
* Java 11
* Spring Boot version: 2.6.1
* Spring Web
* Spring Security
* Devtools
* Validation
* Guava version 28.1-jre
* Jpa
* PostgreSQL
* Lombok
````

## Setup
To run this project, install it locally, open it into your IDE, go to the properties file and then 
change the database configuration like driver, Url, db name, user and password. Finally, run it as any other java 
application. 

```
   dataSourceBuilder.driverClassName("org.postgresql.Driver");
   dataSourceBuilder.url("jdbc:postgresql://localhost:5432/dbName");
   dataSourceBuilder.username("username");
   dataSourceBuilder.password("password");
```

### Author
This repository was built using documentation and other tutorials from the internet.

* **Barrera Luis German**  - *Java Developoer*




 
 



