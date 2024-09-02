# reactive-message

This project is consisting of 2 microservices:

1. ### **service-one**:
    _Which is a message microservice, that does:_
      * Prints welcome message - GET
      * Print Success - POST
      * Throw exception - POST
   
2. ### **service-two**:
   _Which is a rest client microservice, that does:_
    * Consume all features that message microservice does.

### To Run the project
   * clone the repo
   * Once you are in the project repo
   * Open terminal then right the commands
     * cd .\rest-client\ 
     * ./mvnw compile quarkus:dev
   * Open another terminal page 
     * cd .\message-microservice\
     * ./mvnw compile quarkus:dev
   * Now you have 
     * Rest-Client (Service-two) running on 8090
     * Message-Microservice(Service-one) running 0n 8080

> **_NOTE:_**
> * you can use postman collection / http requests in each repo
> There's a Readme file for each service 

> **_NOTE: Service-one_**
> * now you can Swagger-Ui at <http://localhost:8080/q/swagger-ui/>.
> * or generate Openapi by <http://localhost:8080/q/openapi/>.


> **_NOTE: Service-two_**
> * now you can Swagger-Ui at <http://localhost:8090/q/swagger-ui/>.
> * or generate Openapi by <http://localhost:8090/q/openapi/>.


### Versions:
* java-11
* Apache Maven 3.9.3
* Quarkus 3.2.12.FINAL
