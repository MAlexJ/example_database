#### Unidirectional One-to-Many

Unidirectional One-to-Many Relationship

Essentially, in a relational data model, a unidirectional one-to-many relationship is a type of relationship
between two tables where one table has multiple related records in another table.
Still, the second table doesn’t directly relate to the first table.
This means that the relationship flows in only one direction.

Moving onto the JPA, a unidirectional One-to-Many relationship can be established between two entities
when one entity has a reference to the collection of related entities.
Still, we cannot traverse back from the related entities to the first entity.
Generally, the entity containing the reference is called the parent entity,
and the referenced entity is called the child entity.

link: https://www.baeldung.com/spring-jpa-unidirectional-one-to-many-and-cascading-delete

### Hibernate

#### Unidirectional with join table

Unidirectional

A unidirectional one to many using a foreign key column in the owned entity is not that common and not really
recommended.
We strongly advise you to use a join table for this kind of association (as explained in the next section).
This kind of association is described through a @JoinColumn

```
@Entity
public class Customer implements Serializable {
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="CUST_ID")
    public Set<Ticket> getTickets() {
    ...
}

@Entity
public class Ticket implements Serializable {
    ... //no bidir
} 
```

Unidirectional with join table

A unidirectional one to many with join table is much preferred.
This association is described through an @JoinTable.

```
@Entity
public class Trainer {
    @OneToMany
    @JoinTable(
            name="TrainedMonkeys",
            joinColumns = @JoinColumn( name="trainer_id"),
            inverseJoinColumns = @JoinColumn( name="monkey_id")
    )
    public Set<Monkey> getTrainedMonkeys() {
    ...
}

@Entity
public class Monkey {
    ... //no bidir
}
```

Trainer describes a unidirectional relationship with Monkey using the join table TrainedMonkeys,
with a foreign key trainer_id to Trainer (joinColumns) and a foreign key monkey_id to Monkey (inversejoinColumns).

link: https://docs.jboss.org/hibernate/stable/annotations/reference/en/html/entity.html#entity-mapping-association-collections

### ENV file

create `.env` file:

spring-boot variable:

```
APP_SERVICE_MYSQL_URL=xxx
APP_SERVICE_MYSQL_PORT=3306
APP_SERVICE_MYSQL_USERNAME=...........
APP_SERVICE_MYSQL_DATABASE=example_database_db
APP_SERVICE_MYSQL_PASSWORD=...........
```

Docker compose variable:

```
MYSQL_DATABASE=example_database_db
MYSQL_ROOT_PASSWORD=...........
```

### Docker

#### Docker-compose: MySQL

link: link: https://hub.docker.com/_/mysql

Example `docker-compose.yml` for` mysql`:

```
version: '3.1'

services:

  db:
    env_file:
      - ../.env
    image: mysql
    restart: always
    ports:
      - "3306:3306"
    expose:
      - ${APP_SERVICE_MYSQL_PORT}
```

#### Docker: MySQL

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

