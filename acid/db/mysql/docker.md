### Run Mysql

```
docker run --name mysql-container \
  -e MYSQL_ROOT_PASSWORD=rootpassword \
  -e MYSQL_DATABASE=mydb \
  -e MYSQL_USER=myuser \
  -e MYSQL_PASSWORD=mypassword \
  -p 3306:3306 \
  -d mysql:9.3
```

#### Explanation:

    --name mysql-container — container name.
    -e MYSQL_ROOT_PASSWORD=... — sets the root user password.
    -e MYSQL_DATABASE=... — creates a new database on container startup.
    -e MYSQL_USER and -e MYSQL_PASSWORD — create a new user and set a password.
    -p 3306:3306 — maps container port 3306 to the host.
    -d — runs the container in the background.
    mysql:9.3 — specifies the MySQL version (can be changed to 5.7, latest, etc.).