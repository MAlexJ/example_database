### Spring Data JPA One-To-One Unidirectional Relationship

In Spring Data JPA, a one-to-one unidirectional relationship between two entities means that one entity is related
to exactly one instance of another entity, and the relationship is navigable from one entity to the other,
but not the other way around. That is, Entity A has a reference to Entity B,
but Entity B does not have a reference to Entity A.

In this example, we’ll create a one-to-one unidirectional relationship between Product and Stock entities,
where each Product can have at most one associated Stock.

link: https://medium.com/@bectorhimanshu/spring-data-jpa-one-to-oneunidirectional-relationship-0c6199bc6e8a


###### Explanation:
`@OneToOne` annotation is used to define the one-to-one relationship.

`cascade` = `CascadeType.ALL` specifies that all operations (e.g., persist, remove) should be cascaded 
to the associated Stock.

In Spring Data JPA, the cascade attribute in the `@OneToOne` annotation specifies how operations 
(such as persist, merge, remove, etc.) should propagate from the parent entity to the associated child entity.

`@JoinColumn` annotation specifies the `foreign key` column in the Product table that references 
the id column in the Stock table.
