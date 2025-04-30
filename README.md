### Spring data jpa samples

### JPA / Hibernate

Show sql statements with params

```
spring:
  jpa:
#    show-sql: true
    hibernate:
      ddl-auto: create
    generate-ddl: false
    properties:
      hibernate:
        format_sql: true
        use_sql_comments: false
    open-in-view: false

logging:
  level:
    org.hibernate.SQL: debug
    org.hibernate.type.descriptor.sql: trace
    org.hibernate.orm.jdbc.bind: trace
    org:
      hibernate:
        type:
          descriptor:
            sql:
              BasicBinder=TRACE:
        orm:
          jdbc:
            bind: trace  
```

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

### Github action

issue:  ./gradlew: Permission denied
link: https://stackoverflow.com/questions/17668265/gradlew-permission-denied

You need to update the execution permission for gradlew

1. add action workflow

2. locally pull changes

3. run Git command:

```
git update-index --chmod=+x gradlew
git add .
git commit -m "Changing permission of gradlew"
git push
```

### Gradle

#### Gradle Versions Plugin

Displays a report of the project dependencies that are up-to-date, exceed the latest version found, have upgrades, or
failed to be resolved, info: https://github.com/ben-manes/gradle-versions-plugin

command:

```
gradle dependencyUpdates
```

#### Gradle wrapper

Gradle Wrapper Reference:
https://docs.gradle.org/current/userguide/gradle_wrapper.html

How to Upgrade Gradle Wrapper:
https://dev.to/pfilaretov42/tiny-how-to-upgrade-gradle-wrapper-3obl

```
./gradlew wrapper --gradle-version latest
```
