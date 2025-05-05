### SHOW DATABASES Statement

SHOW DATABASES lists the databases on the MySQL server host.
SHOW SCHEMAS is a synonym for SHOW DATABASES.

link: https://dev.mysql.com/doc/refman/8.4/en/show-databases.html

```
SHOW {DATABASES | SCHEMAS}
    [LIKE 'pattern' | WHERE expr]
```

Use the SHOW statement to find out what databases currently exist on the server:

```
mysql> SHOW DATABASES;
```

#### SHOW TABLES Statement

SHOW TABLES lists the non-TEMPORARY tables in a given database.

link: https://dev.mysql.com/doc/refman/8.4/en/show-tables.html

```
SHOW [EXTENDED] [FULL] TABLES
    [{FROM | IN} db_name]
    [LIKE 'pattern' | WHERE expr]
```

#### SHOW GRANTS Statement

This statement displays the privileges and roles that are assigned to a MySQL user account or role, 
in the form of GRANT statements that must be executed to duplicate the privilege and role assignments.

link: https://dev.mysql.com/doc/refman/8.4/en/show-grants.html

```
SHOW GRANTS
    [FOR user_or_role
        [USING role [, role] ...]]

user_or_role: {
    user (see Section 8.2.4, “Specifying Account Names”)
  | role (see Section 8.2.5, “Specifying Role Names”.
}
```

#### SHOW TRIGGERS Statement

SHOW TRIGGERS lists the triggers currently defined for tables in a database 
(the default database unless a FROM clause is given). 
This statement returns results only for databases and tables for which you have the TRIGGER privilege.

```
SHOW TRIGGERS
    [{FROM | IN} db_name]
    [LIKE 'pattern' | WHERE expr]
```

#### SHOW INDEX Statement

HOW INDEX returns table index information.

```
SHOW [EXTENDED] {INDEX | INDEXES | KEYS}
    {FROM | IN} tbl_name
    [{FROM | IN} db_name]
    [WHERE expr]
```