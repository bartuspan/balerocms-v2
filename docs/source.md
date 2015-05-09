COMPILING
=========

To compile this source, use:

    $ pandoc -o target.pdf source.md
    
Note: Require pandoc software.

DOCUMENTATION
=============

Welcome to Balero CMS v2.

    Running:
    $ mvn test
    
Development Deploy:

    For testing, development and demo purposes. (H2 Memory-RAM Database)
    $ mvn spring-boot:run
    
Production Deploy:

    For live portals and production (MySQL) with resource minification (HTML/CSS/JS).
    $ mvn -Pprod spring-boot:run
    Open http://localhost:8080/

About this project

Balero CMS v2 is a Lightweight and Clean Full Stack, Portal, CMS. it uses Java Back-End for MVC Controllers and AngularJS Front-End for the API REST Services.

Frameworks and Toolchains: 

* Spring Boot
* Spring MVC
* Spring Security
* AngularJS
* Bootstrap
* Flyway DB
* Hibernate JPA
* Asset Pipeline
* Features and Plugins: 
* Spring MVC Controllers
* AngularJS Asynchronous Spring REST Controllers
* DB Migrations
* Development Profiles
* Embedded Server / Self-Executable Application
* i18n Embedded / Both Front-End / Back-End Multi-Language
* Method Security Protection Level (@Secure)
* Resource Minification (HTML, CSS, Javascript)
* Multiple Databases (SQL Standars)
* User / Admin Dashboard
* UX/Responsive Email Newsletter
* Hot Swap

IoT Support on v2
=================

* Arduino
* Raspberry Pi

Support or Contact

You feedback is welcome! anibalgomez@balerocms.com.

This project is under development, test only for development and not for production before release date.

[Powered by BaleroCMS V2](http://balerocms.com/).