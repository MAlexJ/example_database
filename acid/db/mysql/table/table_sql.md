To create a table in MySQL, you can use the CREATE TABLE statement.

Below is a general structure for creating a table:

```
CREATE TABLE schema_name.table_name (
    column1_name column1_data_type [column_constraints],
    column2_name column2_data_type [column_constraints],
    ...
    [table_constraints]
);
```

Example:

Let's create a table users in a schema testdb, with columns id, username, and email:

```
CREATE TABLE test_db.users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

Explanation:

* id INT AUTO_INCREMENT PRIMARY KEY: An integer column that auto-increments, making it a unique identifier for each row.
* username VARCHAR(50) NOT NULL: A string column for the username that cannot be NULL.
* email VARCHAR(100) NOT NULL UNIQUE: A string column for the email that is unique and cannot be NULL.
* created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP:
  A timestamp column that automatically gets the current time when a new row is created.

Verify the Table:

After creating the table, you can check if it was created successfully by listing the tables in the schema:

```
SHOW TABLES IN test_db;
```