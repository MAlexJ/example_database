### CREATE TABLE Statement

link: https://dev.mysql.com/doc/refman/8.4/en/create-table.html

```
CREATE [TEMPORARY] TABLE [IF NOT EXISTS] tbl_name
    [(create_definition,...)]
    [table_options]
    [partition_options]
    [IGNORE | REPLACE]
    [AS] query_expression
```

In SQL, creating a table is one of the most essential tasks for structuring your database. 
The CREATE TABLE statement defines the structure of the database table, specifying column names, 
data types, and constraints such as PRIMARY KEY, NOT NULL, and CHECK. 

Mastering this statement is fundamental to ensuring that our data is organized and easily accessible.

