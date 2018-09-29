use atom

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
  
  db.user.find()