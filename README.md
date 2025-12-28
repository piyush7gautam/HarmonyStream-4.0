# HarmonyStream 4.0 

HarmonyStream is a Java-based online music streaming platform built using
Servlets, JSP, JDBC, MySQL, and Apache Tomcat.

The platform supports multiple user roles such as Admin, Artist, and Listener,
allowing music uploads, approvals, and streaming.

---

##  Features

###  User Roles
- Admin
- Artist
- Listener

###  Authentication
- Secure login using email and password
- Session-based authentication

###  Artist
- Upload songs (title, album, genre)
- Songs are marked as **PENDING** until approved

###  Admin
- View all pending songs
- Approve or reject uploaded music

###  Listener
- View and listen to approved songs
- See song details like title, album, and genre

---

##  Technologies Used

- Java (JDK 8)
- JSP & Servlets
- JDBC
- MySQL
- Apache Tomcat 9
- Maven
- HTML, CSS

---

##  Database Schema

### Users Table
- id
- name
- email
- password
- role

### Music Table
- id
- title
- album
- genre
- artist_id
- streams
- status (PENDING / APPROVED)

---

##  How to Run the Project

1. Clone the repository
2. Import as Maven project in Eclipse / IntelliJ
3. Configure MySQL database
4. Update DB credentials in `DBConnection.java`
5. Run using Apache Tomcat
6. Access via: http://localhost:8080/HarmonyStream-1.0/login.jsp
developed by Codexcrew
Piyush Kumar Gautam(Leader)
Anuj Rajpoot
Sanad Shakiya
