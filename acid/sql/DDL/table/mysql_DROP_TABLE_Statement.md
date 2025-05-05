### DROP TABLE Statement

DROP TABLE removes one or more tables. You must have the DROP privilege for each table.

Be careful with this statement! 
For each table, it removes the table definition and all table data. 
If the table is partitioned, the statement removes the table definition, all its partitions, 
all data stored in those partitions, and all partition definitions associated with the dropped table.

Dropping a table also drops any triggers for the table.

link: https://dev.mysql.com/doc/refman/8.4/en/drop-table.html

```
DROP [TEMPORARY] TABLE [IF EXISTS]
    tbl_name [, tbl_name] ...
    [RESTRICT | CASCADE]
```