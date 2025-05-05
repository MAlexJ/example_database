### ANSI/ISO SQL (e.g., SQL-92, SQL:1999, SQL:2016)

These official international standards do not explicitly use terms like DML, DQL, or DDL as formal categories.

✅ Fact: ANSI/ISO standards describe the behavior of commands, but they do not officially group them into categories
like DML, DQL, etc.

However, in practice, in textbooks, database documentation (such as for MySQL, PostgreSQL, Oracle),
and academic courses, the classification is widely used:

```
-----------------------------------------------------------------------------
Category        Example Commands	                Purpose
-----------------------------------------------------------------------------
DQL	            SELECT	                            Data retrieval (queries)
DML	            INSERT, UPDATE, DELETE, MERGE	    Modify data
DDL	            CREATE, ALTER, DROP	                Modify database structure
DCL	            GRANT, REVOKE	                    Control access to data
TCL	            COMMIT, ROLLBACK	                Manage transactions
```

Category;

- DQL (Data Query Language)
- DML (Data Manipulation Language)
- DDL (Data Definition Language)
- DCL (Data Control Language)
- TCL (Transaction Control Language)
