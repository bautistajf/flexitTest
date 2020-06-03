# Backend

This project was generated with Java 8 and Springboot.

## Development server

Navigate to `http://localhost:8081/`. 

## Employee services

The list of all employees sorted by the last event date.
http://localhost:8081/employees/getEmployeesSortedLastEventDate

The employee who has to organize the next event.
http://localhost:8081/employees/getEmployeeWhoOrganizeNextEvent

## Swagger
http://localhost:8081/swagger-ui.html#/


## Docker pull and run


docker pull bautistajf/flexit-service      .


docker run -p 8081:8081 --name flexit-service bautistajf/flexit-service:latest      .