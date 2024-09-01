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

### Versions:
* java-11
* Apache Maven 3.9.3
* Quarkus 3.2.12.FINAL
