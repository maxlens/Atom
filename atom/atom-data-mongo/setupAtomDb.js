use atom

db.createUser(
   {
     user: "atomapp",
     pwd: "password123",
     
     roles: [{"role":"readWrite","db":"atom"}],
    /* All built-in Roles 
     Database User Roles: read|readWrite
     Database Admin Roles: dbAdmin|dbOwner|userAdmin
     Cluster Admin Roles: clusterAdmin|clusterManager|clusterMonitor|hostManager
     Backup and Restoration Roles: backup|restore
     All-Database Roles: readAnyDatabase|readWriteAnyDatabase|userAdminAnyDatabase|dbAdminAnyDatabase
     Superuser Roles: root 
    */
    
    // authenticationRestrictions: [ {
    //     clientSource: ["192.168.0.0"],
    //     serverAddress: ["xxx.xxx.xxx.xxx"]
    //  } ],

    //mechanisms: [ "<SCRAM-SHA-1|SCRAM-SHA-256>", ... ], 

    //passwordDigestor: "<server|client>"
   }
)

db.createCollection("user")

db.user.insert([{
    "firstName" : "Jerry",
    "lastName" : "Sienfeld",
    "email" : "",
    "password" : "",
    "createdOn" : new Timestamp(),
    "lastLogin" : new Timestamp()
  },
{
    "firstName" : "Elaine",
    "lastName" : "Benes",
    "email" : "",
    "password" : "",
    "createdOn" : new Timestamp(),
    "lastLogin" : new Timestamp()
  }])
  
use atom
  
db.user.find()