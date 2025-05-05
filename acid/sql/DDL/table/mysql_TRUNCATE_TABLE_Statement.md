### TRUNCATE TABLE Statement

TRUNCATE TABLE empties a table completely.
It requires the DROP privilege.

Logically, TRUNCATE TABLE is similar to a DELETE statement that deletes all rows,
or a sequence of DROP TABLE and CREATE TABLE statements.

link: https://dev.mysql.com/doc/refman/8.4/en/truncate-table.html

```
TRUNCATE [TABLE] tbl_name
```

Although TRUNCATE TABLE is similar to DELETE, it is classified as a DDL statement rather than a DML statement.
It differs from DELETE in the following ways:

* Truncate operations drop and re-create the table, which is much faster than deleting rows one by one, particularly for
  large tables.

* Truncate operations cause an implicit commit, and so cannot be rolled back.

* Truncation operations cannot be performed if the session holds an active table lock.

* TRUNCATE TABLE fails for an InnoDB table or NDB table if there are any FOREIGN KEY constraints from
  other tables that reference the table.
  Foreign key constraints between columns of the same table are permitted.

* Truncation operations do not return a meaningful value for the number of deleted rows.
  The usual result is “0 rows affected,” which should be interpreted as “no information.”

* As long as the table definition is valid, the table can be re-created as an empty table with TRUNCATE TABLE,
  even if the data or index files have become corrupted.

* Any AUTO_INCREMENT value is reset to its start value.
  This is true even for MyISAM and InnoDB, which normally do not reuse sequence values.

* When used with partitioned tables, TRUNCATE TABLE preserves the partitioning;
  that is, the data and index files are dropped and re-created, while the partition definitions are unaffected.

* The TRUNCATE TABLE statement does not invoke ON DELETE triggers.

* Truncating a corrupted InnoDB table is supported.