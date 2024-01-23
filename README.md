# SQL example

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

### Docker

MySQL database

Info: https://hub.docker.com/_/mysql

* MYSQL_USER - user
* MYSQL_PASSWORD - user password
* MYSQL_ROOT_PASSWORD - password for 'root' username

one-line command

```
docker run -p 3306:3306 --name mysql-db-v.8.3 -e MYSQL_ROOT_PASSWORD=12345 -d mysql:8.3.0
```

Connect to MYSQL and create database:

```
create database if not exists sample_db;
```

### Liquibase

documentation: https://docs.liquibase.com/change-types/home.html

application yaml file configuration:

```
spring:
  application:
    name: sql-web-service

  liquibase:
    user: ${APP_MYSQL_USER:root}
    url: jdbc:mysql://${APP_MYSQL_HOSTNAME:localhost}:3306/sample_db
    password: ${APP_MYSQL_PASSWORD:12345}
    change-log: classpath:db/changelog/db.changelog-master.yaml
```

