# SQL example

### Database

#### Types of databases. DBMS type overview

DB-Engines is an initiative to collect and present information on database management systems (DBMS). 
In addition to established relational DBMS, systems and concepts of the growing NoSQL area are emphasized.

link: https://habr.com/ru/companies/amvera/articles/754702/
link: https://db-engines.com/en/ranking/document+store
link: https://dbdb.io

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

