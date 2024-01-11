<h2> Demo banking app built on java spring, maven </h2>

Upon launching demoBankingApplication, you will be asked to create user 

press y - to add a user by entering the name of user
press n - to exit adding user

After user creation, you can test using following operation :

<br><h4>Get all the users </h4>
<p><code>curl --location --request GET 'http://localhost:8080/users/all'</code></p>
<br>
<img width="850" alt="Screenshot 2024-01-11 at 7 54 10 PM" src="https://github.com/shriharistark/banking-spring-demo/assets/28220088/7188631e-1dd0-445f-b892-950603ae2657">

<br><h4>Get balance of a user </h4>
<p><code>curl --location --request GET 'http://localhost:8080/users/doe/balance'</code></p>
<br>
<img width="866" alt="Screenshot 2024-01-11 at 7 54 35 PM" src="https://github.com/shriharistark/banking-spring-demo/assets/28220088/ce7f8518-5dff-4a65-9d4e-34ee199e80b4">

<br><h4>Update balance of a user </h4>
<p><code>curl --location --request PUT 'http://localhost:8080/users/dhoni/balance/700'</code></p>
<br>
<img width="848" alt="Screenshot 2024-01-11 at 7 52 45 PM" src="https://github.com/shriharistark/banking-spring-demo/assets/28220088/49dd3583-ef56-485c-bc35-d793cc359aa4">
