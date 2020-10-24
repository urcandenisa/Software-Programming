# Disneyland Vision

# Introduction
The purpose of this document is to collect, analyze, and define high-level needs and features of the Disneyland system. It focuses on the capabilities needed by the stakeholders and the target users, and why these needs exist. The details of how the Disneyland system fulfills these needs are detailed in the use-case and supplementary specifications.

The introduction of the Vision document provides an overview of the entire document. It includes the purpose, scope, definitions, acronyms, abbreviations, references, and overview of this Vision document.

## Purpose
The purpose of this section is to collect, analyze and define high-level needs and features of the Disneyland system. This document also identifies the sakeholders and target-users, their capabilities and why these needs exists. The details of how this applications fullfills these needs are detailed in the use-case and supplementary specifications.

## Scope
The scope of this project is to implement a desktop application for ordinary users that can search and choose for certain activities at Disneyland. This system will provide a listing for all the people that want to participate at activities during their Disneyland visit. Users can perform a series of operations like searching fun activities after keywords, or certain properties while the system is checking their availability. They can register and afterwards introduce a valid combination of username and password. The system will be coordonated by the administrator, who is able to make operations (CRUD) on regular users, activities and to generate report files containing the activities and users that registered for a certain activity.

## Definitions, Acronyms, and Abbreviations
This subsection provides the definitions of all terms, acronyms, and abbreviations required to properly interpret the Vision document.
* **JVM** - Java Virtual Machine, 
virtual machine that enables a computer to run Java programs as well as programs written in other languages that are also compiled to Java bytecode.
* **Java** - set of computer software and specifications that provides a system for developing application software.
* **CRUD** - create, remove, update and delete operations

## References
This subsection provides a complete list of all documents referenced elsewhere in the Vision document.
- [Java Virtual Machine](https://en.wikipedia.org/wiki/Java_virtual_machine)
- [Java](https://en.wikipedia.org/wiki/Java_(software_platform))

## Overview
This subsection describes what the rest of the Vision document contains and explains how the document is organized. In the next subsections, this document will present the main problem that the deployment of this application solves( the problem statement), why this software is better than the existing ones( product position statement), the stakeholders and users, the user environment, product requirements and the bibliography. Each of this section will contain a summary.
# Positioning
## Problem Statement
Provide a statement summarizing the problem being solved by this project. The following format may be used:

|||
|----|------- |
| **The problem of** |  not having a system listing the available activities at Disneyland and being able to register for them
| **affects**  | the people who want to visit/ are visiting Disneyland
| **the impact of which is** |  unsatisfied visitors, a difficult management of registering for activities and lack of information about availability
| **a successful solution would be** | a simple, friendly application which allows visitors to search for activities and their availability, register for them instead of staying in line for it.

## Product Position Statement

|||
|----|------- |
| **For** | the two companies that owns Disneyland Paris |
| **Who** | need a modern, friendly application management system |
| **The** | Disneyland is a software application
| **That** | provides an easier way to gather information about activities and manage them more efficiently 
| **Unlike** | currently available system which does not offer information and the possibility to register to certain activities 
| **Our product** |  provides a simple way for anyone who wants to visit or is visiting Disneyland to search for all possible atractions and activites in many ways to register for them, while the administrator will have generated reports containing the registered users and the type of activity they signed for.


# Stakeholder and User Descriptions
The stakeholders are divided in two categories: the ones who are not directy involved in the development of the application, the users, and the ones who are actively involved in the development process, ensuring that the needs of the users are fulfilled. The users are represented by all the people who have shown interest in visiting Disneyland.

## Stakeholder Summary
There are a number of stakeholders with an interest in the development and not all of them are end users. 

### Stakeholder 1
* **Name**: software architect.
* **Description**: a primary lead in the process of development of the application.
* **Responsibilities**: this stakeholder:
* is responsible for the architecture of the system;
* guides the design and implementation( deployment) of the system.

### Stakeholder 2
* **Name**: developer.
* **Description**: leads the development of the system.
* **Responsibilities**: this stakeholder:
    * ensures that the system will be maintainable
    * implements the application in order to satisfy the client's needs
    * adds new features to the system

## User Summary
This subsection present a summary of the two types of users.

### User 1
* **Name**: regular user.
* **Description**: primary end user of the system.
* **Responsibilities**: 
* provide a valid combination of username and password;
* search activities providing different properties;
* register to a certain activity.
* **Stakeholder**: self.

### User 2
* **Name**: administrator.
* **Description**: primary end user of the system.
* **Responsibilities**:
* CRUD operations on activities;
* CRUD operations on regular users information;
* generate report files.
* **Stakeholder**: Self

## User Environment
The Disneyland system will be used by people, mostly people who are visiting/ want to visit Disneyland, in order to avoid staying in lines to register for activities and going without having any type of information about the available activities that can be performed. Users can use the application without the administrator online, all the activities being listed and refreshed for availability at certain period of times. The time spent on each activity may vary depending on the service the client wants and the availability of it. 

# Product Requirements
At a high lever, for the application to run it needs a computer with any operating system which has JVM installed. In terms of performance, it should run in at least liniar time, depending on user's needs.
Environmental requirements are good internet connection.

# Bibliography

- [Markdown online editor](http://dillinger.io/)
- [Markdown Tutorial](https://www.markdowntutorial.com )
- [Mastering Markdown](https://guides.github.com/features/mastering-markdown/)
