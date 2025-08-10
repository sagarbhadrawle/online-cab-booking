# 🚖 Online Cab Booking System

![Online Cab Booking Logo](https://raw.githubusercontent.com/sagarbhadrawle/online-cab-booking/main/Online-Cab-Booking-Fronted/images/logo.png)


## 📖 Overview
The **Online Cab Booking System** is a Spring Boot application that allows customers to book cabs, track booking status, and manage driver and cab availability.  
It features secure authentication, role-based access, and real-time booking management.

---

## 🗄 Database Entity Representation

Below is the entity relationship diagram (ERD) based on your models:


### Entities
1. **Customer** – Stores user details, contact, and linked bookings. Implements Spring Security's `UserDetails`.
2. **Booking** – Contains trip details (source, destination, distance, total amount, status).
3. **BookingStatus** – Enum for booking states (`PENDING`, `CONFIRMED`, `CANCELLED`, `COMPLETED`).
4. **Cab** – Cab type, per km rate, and availability; linked to a driver.
5. **Driver** – Stores driver information and assigned cabs.
6. **RolesAndAuthority** – Defines system roles and authorities.

---

## 💻 Technologies Used
- **Java 17+** – Core programming language
- **Spring Boot** – Application framework
- **Spring Boot Security** – Authentication & authorization
- **Spring Data JPA** – ORM for database interaction
- **Maven** – Build and dependency management
- **Validation API (Jakarta Validation)** – Data validation
- **Swagger UI** – API documentation and testing
- **Lombok** – Reduces boilerplate code
- **MySQL / PostgreSQL** – Relational database support

---

## 📂 Package Structure

---

## 🚀 Features
- Customer registration & login
- Cab booking & fare calculation
- Booking status updates
- Driver and cab management
- Role-based access control
- Secure API endpoints
- API documentation with Swagger

---

## 🧑‍💻 Author
**Sagar Bhadrawle**

