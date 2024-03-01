# Backpack-api

## Description

Provides an API to retrieve backpack items based on kilometers and date of the hike.

### Uses:

* [**Java** 17](https://www.oracle.com/java/technologies/downloads/)

* [**Spring-boot** 3+](https://spring.io/projects/spring-boot)

* [**Gradle** 8+](https://docs.gradle.org/8.0/release-notes.html)


# Application local environment

1. Open terminal

2. Download project `gh repo clone https://github.com/elisiejuskumiscius/backpack-api.git`

3. Set Project SDK to Java 17

4. Build project `gradlew build`

5. Run application `gradlew bootRun`

6. Once application started go to **http://localhost:8080/h2-console/** login with your credentials and DML script from resource directory
![image](https://github.com/elisiejuskumiscius/backpack-api/assets/58907786/176deb68-d3a8-4ef3-b14e-7e3176205044)

7. After you should be able to do a request. Something similar like this one using some tool like Postman or Insomnia or direcly in browser **http://localhost:8080/backpack?kilometers=75&hikeDate=2024-02-29**
![image](https://github.com/elisiejuskumiscius/backpack-api/assets/58907786/85de8d14-6fb8-4e18-b3f5-30c702a1671f)
 

