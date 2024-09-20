### Spring Data JPA One-To-One Unidirectional Relationship

In Spring Data JPA, a one-to-one unidirectional relationship between two entities means that one entity is related
to exactly one instance of another entity, and the relationship is navigable from one entity to the other,
but not the other way around. That is, Entity A has a reference to Entity B,
but Entity B does not have a reference to Entity A.

In this example, we’ll create a one-to-one unidirectional relationship between Product and Stock entities,
where each Product can have at most one associated Stock.

link: https://medium.com/@bectorhimanshu/spring-data-jpa-one-to-oneunidirectional-relationship-0c6199bc6e8a