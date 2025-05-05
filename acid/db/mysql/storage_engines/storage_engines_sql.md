### Storage Engines

#### Chapter 17 The InnoDB Storage Engine

link: https://dev.mysql.com/doc/refman/8.4/en/innodb-storage-engine.html

InnoDB is a general-purpose storage engine that balances high reliability and high performance. 
In MySQL 8.4, InnoDB is the default MySQL storage engine. 
Unless you have configured a different default storage engine, issuing a CREATE TABLE statement without an ENGINE 
clause creates an InnoDB table.

Key Advantages of InnoDB:

* Its DML operations follow the ACID model, with transactions featuring commit, rollback, and crash-recovery 
  capabilities to protect user data.

* Row-level locking and Oracle-style consistent reads increase multi-user concurrency and performance.

* InnoDB tables arrange your data on disk to optimize queries based on primary keys. 
  Each InnoDB table has a primary key index called the clustered index that organizes the data 
  to minimize I/O for primary key lookups.

* To maintain data integrity, InnoDB supports FOREIGN KEY constraints. 
  With foreign keys, inserts, updates, and deletes are checked to ensure they do not result in inconsistencies across related tables

```
SHOW ENGINES
```

#### Chapter 18 Alternative Storage Engines

link: https://dev.mysql.com/doc/refman/8.4/en/storage-engines.html