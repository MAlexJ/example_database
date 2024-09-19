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
 vand the referenced entity is called the child entity.

link: https://www.baeldung.com/spring-jpa-unidirectional-one-to-many-and-cascading-delete

