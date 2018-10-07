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

// Authority Collection
db.authority.drop()
db.createCollection("authority")
db.authority.insert([
    {_id: 1, "name": "ROLE_USER"},
    {_id: 2, "name": "ROLE_ADMIN"}
    ])
db.authority.find()

//User Collection
db.user.drop()
db.createCollection("user")
db.user.insert([{
    "username" : "jsienfeld",
    "password" : "$2a$04$1OiJzsX6i6BBFgmFzC50nu1rkFqkfErXac.RSu9lYfeE1WL/TH95a",
    "firstName" : "Jerry",
    "lastName" : "Sienfeld",
    "email" : "",
    "authorities" : [
        {_id: 1, "name": "ROLE_USER"},
        {_id: 2, "name": "ROLE_ADMIN"}
    ],
    "enabled" : true,
    "createdOn" : new Date(),
    "lastLogin" : new Date(),
    "passwordResetDate" : new Date()
  },
{
    "username" : "ebenes",
    "password" : "$2a$04$1OiJzsX6i6BBFgmFzC50nu1rkFqkfErXac.RSu9lYfeE1WL/TH95a",
    "firstName" : "Elaine",
    "lastName" : "Benes",
    "email" : "",
    "authorities" : [
        {_id: 1, "name": "ROLE_USER"},
    ],
    "enabled" : true,
    "createdOn" : new Date(),
    "lastLogin" : new Date(),
    "passwordResetDate" : new Date()
  }])
db.user.find()