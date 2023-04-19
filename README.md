# üK295_Projektauftrag
### Wie Sie diesen Code zu Ihrem Projekt hinzufügen können:
Um dieses Programm in Ihr Projekt zu integrieren, müssen Sie dieses Repository klonen.

Nach der Integrierung starten Sie den [Docker](https://www.docker.com/products/docker-desktop). Melden Sie sich an auf [Postman](https://www.postman.com/downloads/) und [Local Host](http://localhost:8080/) mit dieser  Information:
<br>
**Information um den PostgreSQL Docker Containter zu starten:**
> Name: 'uek295db' <br>
> Postgres Passwort: 'postgres'<br>
> Port: '5432'
<br>

**In CMD einfügen:**
```Bash
docker run -d -p 5432:5432 -e POSTGRES_PASSWORD = postgres --name uek295db postgres
```

</br>

**Benutzer Rolle:**
> Benutzername: `user2` <br>
> Passwort: `user02_uek295` 
</br>

Führen Sie zuletzt Ihr Programm in [IntelliJ](https://jdk.java.net/17/) aus.
> Laden Sie am besten die JDK Version 17 herunter.
</br>

**Zugriff auf**:
> [Local Host](http://localhost:8080/bookstore/reviews) 
> 
> [Swagger-Documentation](http://localhost:8080/swagger-ui/index.html#/review-web/updateReview)


