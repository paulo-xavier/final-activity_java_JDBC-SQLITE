# Final activity - Java using SQLite ☕

## Table of contents
- [About the project](#--ℹ%EF%B8%8F-about-the-project)
  - [Technologies](#-technologies--)
  - [Tutorial] ()
 

<br>

<h2 align="center">  ℹ️ About the project</h2>

This project consists in small **message board**. Users can register their nicknames and send messages to other users. All of this information is stored in a database called `messages.db`. 

This database contains two tables: `user` and `message`. The table `user` has a column called `nickname`, in this column all the nicknames from users are stored.

The table `message` has three columns: `idSender`, `idRecipient` and `message`. Considering the IDs, it is possible to verify who sent the message and for which person, and the content of the message. 

Based on that, users can register themselves, send messages, check received messages and verify other registered users. 

<br>



<h3> Technologies 🧑‍💻 </h3>

- Java JDBC API
- SQLITE


---

<h3 align="center"> Tutorial 🖋️ </h3>

<br>

- To run this code, you must have the driver `sqlite-jdbc-3.43.0.0.jar` obligatory in the same folder as the source code.

<br>

- The first thing you have to do is to compile all the files before runing the program:

<p align="center"> <code> javac *.java </code></p>

<br> 

- After that, if you want to create an empty database, just with the rows and columns, you can remove the original `messages.db` and run this command:
 
<p align="center"> <code>  java -classpath ".;sqlite-jdbc-3.43.0.0.jar" Db </code> </p>

<br>

- Or if you prefer, you can keep the same database. However, it contains some users and messages registered.

<br>

- Finally, just execute the class Menu:

  <p align="center"> <code> java -classpath ".;sqlite-jdbc-3.43.0.0.jar" Menu </code></p>
   



