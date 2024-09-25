### Many-To-Many Unidirectional Relationship Mapping

In a many-to-many unidirectional relationship using Spring Data JPA, we’ll have two entities,
and each entity will be related to the other in a many-to-many relationship. 

However, one entity will not maintain a direct reference to the other entity, creating a unidirectional relationship.

In a many-to-many relationship, each entity can be associated with multiple instances of the other entity. 
This relationship is typically defined using two one-to-many relationships. 
However, in a unidirectional many-to-many relationship, one entity knows about the other, 
but the other entity doesn’t maintain a direct reference to the first entity. 
T his is accomplished using the @ManyToMany annotation in JPA.