### Cascade Operations and Relationships

Oracle Java EE, link: https://docs.oracle.com/cd/E19798-01/821-1841/6nmq2cpav/index.html

Entities that use relationships often have dependencies on the existence of the other entity in the relationship.
For example, a line item is part of an order;
if the **order is deleted**, the line **item also should be deleted**.
**This is called a cascade delete relationship**.

The `javax.persistence.CascadeType` enumerated type defines the cascade operations that are applied
in the cascade element of the relationship annotations.

|--------------- Cascade --------- |--------- Operation Description ---------- |

``ALL``

All cascade operations will be applied to the parent entity’s related entity.
All is equivalent to specifying cascade={DETACH, MERGE, PERSIST, REFRESH, REMOVE}

``DETACH``

If the parent entity is detached from the persistence context, the related entity will also be detached.

``MERGE``

If the parent entity is merged into the persistence context, the related entity will also be merged.

``PERSIST``

If the parent entity is persisted into the persistence context, the related entity will also be persisted.

``REFRESH``

If the parent entity is refreshed in the current persistence context, the related entity will also be refreshed.

``REMOVE``

If the parent entity is removed from the current persistence context, the related entity will also be removed.

|--------------------------------------

Cascade delete relationships are specified using the cascade=REMOVE element specification for `@OneToOne` and
`@OneToMany` relationships.

For example:

```
@OneToMany(cascade=REMOVE, mappedBy="customer")
public Set<Order> getOrders() { return orders; }
```