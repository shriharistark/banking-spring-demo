<h2> Demo banking app built on java spring, maven </h2>

Upon launching demoBankingApplication, you will be asked to create user 

press y - to add a user
press n - to exit adding user

After user creation, you can test using following operation :

Get all the users 
http://localhost:8080/users/all [GET]

Get balance of a user
http://localhost:8080/users/username/balance [GET]

Update balance of a user
http://localhost:8080/users/username/balance/200 [PUT]
