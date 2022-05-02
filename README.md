# Homework1 - Midterm Assignment
### Pedro Monteiro 97484
### pmapm@ua.pt
<br>

# How to run the application
Just run the following command in the pom.xml folder
```
./mvnw spring-boot:run
```

Application will launch at [localhost:8080](http://localhost:8080/)
<br>
After start the application, to see information about the API just enter the following urls
- [localhost:8080/api/v1](http://localhost:8080/api/v1): see all data comming from External API
- [localhost:8080/api/v1/countries](http://localhost:8080/api/v1/countries): see all countries available
- [localhost:8080/api/v1/countries/data](http://localhost:8080/countries/data): see covid data about all countries
- [localhost:8080/api/v1/countries/{country}](http://localhost:8080/countries/{country}): see covid data about a specific country
- [localhost:8080/api/v1/cache](http://localhost:8080/cache): see cache details (hits, misses and requests)

<br>

# How to run tests
Just run the following command
```
mvn test
```