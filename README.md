# Easy-Invest

## Short Description
This application aims to help both project managers and sponsors by offering the possibility to connect easily.

## Tools
* [Java 15]
* [JavaFX]
* [Gradle]
* [Nitrite Java]

## Registration
The user needs to first register into the application by selecting one of the 2 roles: sponsor or project manager. Both roles require a unique username, a password and the basic information like full name / company name, address, contact information: email and optionally a phone number.

## Project Manager
After the project manager logs in, he can add, edit or delete a project. 
Also, after logging in, he will see a list of offers from sponsors. 
From the list of offers, the project manager can accept or reject an offer, specifying a rejection reason.
A logged in project manager can see all the projects a sponsor invested in, his contact information, by selecting the sponsor from the list of offers. 

## Sponsor
A sponsor needs to login into the application where he will be able to see a list with all the projects. The list should be searchable by the project’s name.
A logged in sponsor can also see all the projects created by a specific project manager, the contact information provided by him, by selecting the project manager from the description of the project.
Also, logged in sponsor can select to invest into a project (if the offer is accepted by the project manager), and retract the offer(from a list of offers).
A logged in sponsor can also see a list of past offers, with their status (accepted, rejected, retracted). 
