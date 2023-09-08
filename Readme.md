# BookMyShow


BMS is a movie ticket booking system provides its customers the ability to purchase theatre seats online.
E-ticketing systems allow the customers to browse through movies currently being played and to book seats, anywhere and anytime.
The following was discovered as part of building this project:


# Requirement:

1. User able to register with the following info: Name, DOB, Phone, Email
2. User could book movie ticket in the order. 
   Our ticket booking service should be able to list down different cities where its affiliate cinemas are located.
   Once the user selects the city, the service should display the movies released in that particular city.
   Once the user selects the movie, the service should display the cinemas running that movie and its available shows.
   The user should be able to select the show at a particular cinema and book their tickets.
   The service should be able to show the user the seating arrangement of the cinema hall and the user should be able to select multiple seats according to their preference.
   The user should be able to distinguish available seats from the booked ones.
   Users should be able to put a hold on the seats for five minutes before they make a payment to finalize the booking.
   The user should be able to wait if there is a chance that seats might become available – e.g. when holds by other users expire.
   Waiting customers should be serviced fairly in a first come first serve manner.
3. Design Consideration:
   For simplicity, let’sassume our service doesn’t require user authentication.
   The system will not handle partial ticket orders. Either user gets all the tickets they want, or they get nothing.
   Fairness is mandatory for the system.
   To stop system abuse, we can restrict users not to book more than ten seats.
   We can assume that traffic would spike on popular/much-awaited movie releases, and the seats fill up pretty fast.
   The system should be scalable, highly available to cope up with the surge in traffic. 


# Schema Design
USER:
- NAME
- EMAIL
- DOB
- PHONE

CITY:
- NAME
- STATE
- LIST of THEATER

THEATER
- NAME
- ADDRESS
- LIST of AUDITORIUM

AUDITORIUM:
- NAME
- LIST of SEATS
- LIST of SHOW
- LIST of FEATURES

SEAT:
- NAME
- SEATTYPE
- SEATSTATUS
- ROW
- COLUMN

SHOW:
- MOVIE
- START TIME
- END TIME
- LIST of FEATURES

MOVIE:
- NAME
- DURATION
- ACTORS
- GENRE
- LIST of FEATURE

ACTOR:
- NAME

TICKET:
- BOOKINGID
- LIST of PAYMENT
- SHOW
- USER
- AMOUNT
- LIST of SHOWSEAT

PAYMENT:
- PAYMENT METHOD
- AMOUNT
- PAYMENTSTATUS
- REFERENCEID
- TICKET






ENUMS:
- SEATTYPE : VIP, GOLD, PLATINUM
- SEATSTATUS ENUM : EMPTY, BOOKED, HOLD
- FEATURES ENUM: 2D, IMAX
- GENRE ENUM : ROMANCE
- PAYMENT METHOD: DEBIT, CREDIT, UPI
- PAYMENTSTATUS : SUCC, FAIL
- 



### Reference Documentation

For further reference, please consider the following sections:

* [Concurrency In Booking system](https://medium.com/@abhishekranjandev/concurrency-conundrum-in-booking-systems-2e53dc717e8c)
* [Concurrency and Locking](https://medium.com/javarevisited/concurrency-and-locking-on-databases-daa14e2aa68d)
* [Database Isolation Level](https://medium.com/nerd-for-tech/understanding-database-isolation-levels-c4ebcd55c6b9)
* [Transaction Iso Level](https://www.geeksforgeeks.org/transaction-isolation-levels-dbms)
* [@Transactional](https://www.geeksforgeeks.org/spring-boot-transaction-management-using-transactional-annotation/)
* 

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)

