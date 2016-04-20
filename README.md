Scala/Play Async Request Demo
=============================

This is just a simple demo of how one could call multiple REST APIs during a
single request in parallel.

How to use
==========

Just start the app `sbt run` (or run the tests `sbt test`) as usual.
Hit `http://localhost:9000/users/1` and you should get a JSON object
 that joins a user object (`http://jsonplaceholder.typicode.com/users/1`)
 and their posts (`http://jsonplaceholder.typicode.com/posts?userId=1`).