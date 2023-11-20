# Final activity - Java using SQLite ☕

## Table of contents
- [About the project](#--ℹ%EF%B8%8F-about-the-project)
  - [Technologies](#-technologies--)
 

<br>

<h2 align="center">  ℹ️ About the project</h2>

This project consists in small **message board**. Users can register their nicknames and send messages to other users. All of this information is stored in a database called `messages.db`. 

This database contains two tables: `user` and `message`. The table `user` has a column called `nickname`, in this column all the nicknames from users are stored.

The table `message` has three columns: `idSender`, `idRecipient` and `message`. Considering the IDs, it is possible to verify who sent the message and for which person, and the content of the message. 

Based on that, users can register themselves, send messages, check received messages and verify other registered users. 

<br>


<h3 align="center"> Technologies 🧑‍💻 </h3>

- Java JDBC Api
- SQLITE
