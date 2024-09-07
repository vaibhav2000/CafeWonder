# CafeWonder
This spring boot web application is made for the purpose of ordering cakes online!

Tools used: Spring Boot (Security, JPA and Hibernate), Thymeleaf, MySQL.

User can register/login through spring security and then can place orders from the list of cakes present in the database, and can see the list of their own orders and their respective status.

The admin has the option for adding or removing cakes, and seeing the complete list of all orders and progressing the status of the order.

User and Cake entites are related through Many-To-Many relation, for which a separate join table, called "ORDER_DETAILS" is created in the database.

Please refer to the draw.io diagram for a deeper understanding of the relation between these entities.

## Main Page
![Screenshot](Capture.PNG)

