# Zai Weather Application

A simple Spring Boot application that exposes an HTTP service to fetch weather details from third-party weather APIs.
The service uses Weatherstack as the primary API ans OpenWeather as a fallback if Weatherstack is unavailable.

### Technologies
- Java 21
- Spring Boot
- RestTemplate
- Lombok
- Jackson

### API Endpoint
> GET http://localhost:8080/v1/weather?city=Melbourne

### Sample Response
> {
"wind_speed": 1,
"temperature_degrees": 20
}

### Local Setup
1. Clone the repository -> https://github.com/cadls/zai.git
2. Update application.properties _(if applicable)_
3. Run the application
> ./gradlew bootRun

### To Improve
- Improve error handling with custom exception and global exception handler
- Add API Authorization
- Add Unit & Integration Tests
__________________
#### Author
- Cheska