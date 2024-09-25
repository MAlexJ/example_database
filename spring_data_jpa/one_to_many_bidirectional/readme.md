#### One-to-many Bidirectional relationship

In Spring Data JPA, a bidirectional one-to-many relationship involves two entities where one entity
has a collection that holds multiple instances of another entity.
This relationship is bidirectional, meaning that each entity is aware of its relationship with the other.

link: https://medium.com/@bectorhimanshu/spring-data-jpa-one-to-many-bidirectional-relationship-mapping-1dd7088bec3a

#### Bidirectional association via a join table

Rules:
If the relationship is bidirectional, the ``mappedBy`` element must be used to specify the relationship field
or property of the entity that is the owner of the relationship.

link: https://stackoverflow.com/questions/37542208/what-is-joincolumn-and-how-it-is-used-in-hibernate

```
   In Customer class:
   { 
     @OneToMany(cascade=ALL, mappedBy="customer")
     public Set<Order> getOrders() { return orders; }
   }
     
   In Order class:
   {
     @ManyToOne
     @JoinColumn(name="CUST_ID", nullable=false)
     public Customer getCustomer() { return customer; }
   }
```
