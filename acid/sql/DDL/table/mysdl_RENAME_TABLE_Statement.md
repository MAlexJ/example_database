### RENAME TABLE Statement

link: https://dev.mysql.com/doc/refman/8.4/en/rename-table.html

RENAME TABLE renames one or more tables.
You must have ALTER and DROP privileges for the original table, and CREATE and INSERT privileges for the new table.

```
RENAME TABLE
    tbl_name TO new_tbl_name
    [, tbl_name2 TO new_tbl_name2] ...
```

That statement is equivalent to the following ALTER TABLE statement:

```
ALTER TABLE old_table RENAME new_table;
```