# üK295_Projektauftrag
### Wie Sie diesen Code zu Ihrem Projekt hinzufügen können:
For starters, We need to have a Java-project to where you can add this code to. If you do not have a completed Spring-Boot Project, follow the next steps tutorial in order to add the project to your program:<br><br>
**Do not have Docker running?**<br>
Install [Docker](https://www.docker.com/products/docker-desktop) and run it<br><br>

**bearbeitetes Foto**

If you do not have the Java Development Kit (JDK) Version 17, then install it [here](https://jdk.java.net/17/)
> If you already have the JDK Version 11 then you can also use that Version instead of the 17 but this instruction will be suited for Version 17.

If you do not know what version of JDK you have, go on your terminal and write ***java -version*** and if it is JDK version 17 you can proceed on.

**bearbeitetes Foto**

To create a database connection, we have to start a PostgreSQL Docker container and create a user and passwort for it. We will be using these information:
> Name: uek295db
> POSTGRES_PASSWORD=postgres
> Port: 5432
>
> docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres --name uek295db postgres 

**bearbeitetes Foto**

To test the database connedtion



To download the Spring-Boot Project itself, go on this [Website](https://start.spring.io) and press everything according to this picture:

**bearbeitetes Foto von der Webseite**

After you have pressed/ written everything according to the picture above generate, download and extract the file.

Now you are done with the downloading step.

> Why Spring Boot?
> 
>
