#### One-to-many Bidirectional relationship

In Spring Data JPA, a bidirectional one-to-many relationship involves two entities where one entity
has a collection that holds multiple instances of another entity.
This relationship is bidirectional, meaning that each entity is aware of its relationship with the other.

link: https://medium.com/@bectorhimanshu/spring-data-jpa-one-to-many-bidirectional-relationship-mapping-1dd7088bec3a


#### Bidirectional association via a join table

link: https://stackoverflow.com/questions/37542208/what-is-joincolumn-and-how-it-is-used-in-hibernate

```
@Entity
class Patient {

    @OneToMany
    private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
}

@Entity
class Vehicle {

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;
}
```
