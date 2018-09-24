// Update Cluster Name to Atom Cluster

// Step 1:
UPDATE system.local SET cluster_name = 'Atom Cluster' where key='local';

// Step 2-4:
// In casandra.yaml make sure that the cluster_name is 'Atom Cluster'
// run: nodetool flush system
// Restart Cassandra

// Miscellaneous Checks

// nodetool status atom
// nodetool describering atom
// nodetool ring

// Create Keyspace for atom
DROP KEYSPACE atom;
CREATE KEYSPACE atom
  WITH REPLICATION = { 
   'class' : 'SimpleStrategy', 
   'replication_factor' : 1 
  };
  
// Create Tables
USE atom;
DROP TABLE IF EXISTS user;
CREATE TABLE user (
        id uuid,
        firstname varchar,
        lastname varchar,
        password varchar,
        authlevel set<varchar>,
        created timestamp,
        lastlogin timestamp,
        primary key (id)
    ) with comment = 'A table of users';
    
// Create Secondary Index
USE atom;
CREATE INDEX ON user (authlevel);
    
// Insert User Data
USE atom;
insert into user (id, firstname, lastname, password, authlevel, created, lastlogin) 
values (uuid(),'John', 'Cena', 'jangil', {'Admin','Guest'}, dateof(now()), null) if not exists;

insert into user (id, firstname, lastname, password, authlevel, created, lastlogin) 
values (uuid(),'Dwayne', 'Johnson', 'chimpiri', {'Admin'}, dateof(now()), null) if not exists;

// Query User Data
USE atom;
SELECT * FROM user;

// Clear Table Data
USE atom;
TRUNCATE user;
