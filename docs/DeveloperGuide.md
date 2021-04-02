# Developer Guide

![Supported Java versions](https://img.shields.io/badge/Java-11-blue.svg)
![Supported OS](https://img.shields.io/badge/Supported%20OS-Windows|MacOS|Linux-yellow.svg)
![Java CI](https://github.com/AY2021S1-CS2113T-T09-4/tp/workflows/Java%20CI/badge.svg)

## Table of Contents

- [1. Introduction](#1-introduction)
    - [1.1. Software Overview](#11-software-overview)
    - [1.2. Prerequisites](#12-prerequisites)
    - [1.3. Setting up](#13-setting-up)
- [2. Design](#2-design)
    - [2.1. Architecture](#21-architecture)
    - [2.2. EasyLog Component](#22-easylog-component)
    - [2.3. UI Component](#23-ui-component)
    - [2.4. Parser Component](#24-parser-component)
    - [2.5. Command Component](#25-command-component)
    - [2.6. Model Component](#26-model-component)
    - [2.7. Storage Component](#27-storage-component)
    - [2.8. Common Component](#28-common-component)
- [3. Implementation](#3-implementation)
    - [3.1. App Initialization](#31-app-initialization)
- [4. Documentation](#4-documentation)
- [5. Testing](#5-testing)<br>
  [5.1 Running Tests](#51-running-tests)<br>
  [5.2. Types of Tests](#52-types-of-tests)<br>
- [6. Dev Ops](#6-dev-ops)<br>
    - [6.1. Build Automation](#61-build-automation)<br>
    - [6.2. Continuous Integration](#62-continuous-integration)<br>
    - [6.3. Coverage Report](#63-coverage-report)<br>
    - [6.4. Making a Release](#64-making-a-release)<br>
    - [6.5. Managing Dependencies](#65-managing-dependencies)
- [Appendices](#appendices)
    - [Appendix A: Product Scope](#appendix-a-product-scope)
    - [Appendix B: User Stories](#appendix-b-user-stories)
    - [Appendix C: Non-Functional Requirements](#appendix-c-non-functional-requirements)
    - [Appendix D: Glossary](#appendix-d-glossary)
    
## 1. Introduction

### 1.1 Software Overview

easyLog is a Command Line Interface (CLI) application for home based businesses to manage items and orders in their
inventory. easyLog allows users to add new items and orders, view existing items and orders, remove specific items and
orders and clear all existing items and orders in the inventory at ease. If the user types fast, easyLog can get
logistic management tasks done faster than traditional Graphical User Interface (GUI) applications.

easyLog, comprises a Parser component, Ui component, Storage component, Item component, Order component and Command
component. Each component consists of various classes that work in tandem, to ensure it meets the purpose of our
program.

The purpose of this developer guide is to allow any interested contributors who wish to develop this application
further or just curious about the workings of this application. This would allow potential contributors to be able to
dive right in to improving the code, performance, features or even adding new features much more easily due to the
understanding of the structure of the codebase and implementation of existing features.

### 1.2 Prerequisites

- Java 11 (can be downloaded from [here](https://www.oracle.com/sg/java/technologies/javase-jdk11-downloads.html))
- IntelliJ Idea (can be downloaded from [here](https://www.jetbrains.com/idea/download/#section=mac))

### 1.3 Setting up

1. Fork the easyLog repository [here](https://github.com/AY2021S2-CS2113T-T09-4/tp) and git clone it to any location on
   your computer.

2. Open any IDE (IntelliJ Idea preferred as mentioned in the prerequisites) and click `Configure` -> `Project Defaults`
   -> `Project Structure` -> `New`

3. Next, go to `Import Project` and select the build.gradle file.

4. After opening the project, go to `src` -> `main` -> `java` -> `seedu.easylog` -> EasyLog and right click on the
   EasyLog class.

5. Upon successful run, the following opening message will be shown:

```
                       _                 
                      | |                
   ___  __ _ ___ _   _| |     ___   __ _ 
  / _ \/ _` / __| | | | |    / _ \ / _` |
 |  __/ (_| \__ \ |_| | |___| (_) | (_| |
  \___|\__,_|___/\__, |______\___/ \__, |
                  __/ |             __/ |
                 |___/             |___/ 
____________________________________________________________
Hello! I'm easyLog!
What can I do for you? Enter help to view commands.
____________________________________________________________

Looking for save data.
Save data not found.
____________________________________________________________
```

## 2. Design

### 2.1 Architecture

![Architecture Diagram](https://user-images.githubusercontent.com/57165946/112990632-ddf7e780-9198-11eb-99ec-f29aafbfc04f.png)

The EasyLog component contains the main method which is required by Java to run the application. Its main 
responsibility is to initialize the app and after initialization continuously ask for user's input until the exit
command is executed. More details of the EasyLog component will be explained in the future sections.

Apart from the `EasyLog` component, the application also consists of the following components:
- `Ui`: Handles asking for user's input and printing of feedback from user's input.
- `Parser`: Processes user's input to decide what command should be executed.
- `Command`: Executes actions related to the command.
- `Model`: Holds data related to inputs from the user.
- `Storage`: Handles loading, creating and saving of data into `.txt` files.
- `Common`: Contains variables and messages commonly used in all the components.

### 2.2 EasyLog Component

The EasyLog component is responsible for initializing the app. It initializes the app by
instantiating classes from the `Ui`, `Parser`, `Model` and `Storage` components. More details regarding the
initialization will be covered in the [Implementation](#3-implementation) section.

### 2.3 Ui Component

The UI component does the following:
1. It asks for users input.
2. It is responsible for printing and showing responses to the user's input while executing commands related to the
user's input.

### 2.4 Parser Component

![Parser Diagram](https://user-images.githubusercontent.com/57165946/113112907-4c41b600-923c-11eb-897a-314cd186b578.png)

The Parser component deals with the input of the user. It makes sense of the users input and executes respective
commands according to the user's input. This component consists of 3 different classes:
1. `Parser` class to determine the type of feature the user wants to use. (e.g. items or orders feature)
2. `ItemsParser` class to process inputs related to `items` features.
3. `OrdersParser` class to process inputs related to `orders` features.


### 2.5 Command Component

![Command Class Diagram](https://user-images.githubusercontent.com/60378963/113397031-ff421900-93ce-11eb-8e31-a9207d23f2f1.png)
All four ExitCommand, OrdersCommand, ItemsCommand and HelpCommand classes extend the abstract Command class.
OrdersCommand and ItemsCommand Classes are abstract class and it has various Command classes (e.g. OrdersXXXCommand, ItemsXXXCommand) extending them, in order to
deal with different command actions ask by the user.

1. Once the user input is been parsed by the `Parser` class new `Command` object will be created.
2. Different actions will be executed by the execute method in different `Command` class.
3. Command execution take place and it will affect the `Model` and its data (e.g. adding a new item).
### 2.6 Model Component

![Command Diagram](https://user-images.githubusercontent.com/75139323/113146529-5f677c80-9262-11eb-9cff-300d5496d089.png)

The model component consists of `Item`, `ItemManager`, `Order` and `OrderManager` classes.

* Item: Consists of items in the inventory.
* ItemManager: Contains the item list e.g., it has operations to add / delete items in the list.
* Order: Consists of orders by customers.
* OrderManager: Contains the order list e.g., it has operations to add / delete orders in the list.

### 2.7 Storage Component

![image](https://user-images.githubusercontent.com/57165946/113095572-3d500900-9226-11eb-83b0-44d3729442b7.png)

The Storage component consists of 3 different classes
1. `Storage` class to initialize required classes for it's subclasses.
2. `SaveData` class to deal with the loading, saving and creation of save data.
3. `Receipt` class to deal with the generation of receipts when an order is done.

### 2.8 Common Component

The Common component consists of 2 different classes:
1. `Constants` class to store all variables that are frequently used in the various components.
2. `Messages` class to store all the texts for the UI to print onto the command line.

## 3. Implementation

In this section, we explain the details and implementation of the more important features of easyLog.

## 3.1. App Initialization

![App Initialization Diagram](https://user-images.githubusercontent.com/57165946/113379984-99916500-93ad-11eb-8fa7-f3c00fd71163.png)

As seen from the sequence diagram above, upon initialization,
1. The main class located in EasyLog will show the user a greeting message.
2. Proceed to load save file if any. More details on the implementation of loading save files will be
discussed in future sections.
3. Set up the environment for logging messages to be logged.
4. Proceed to ask for user's input.
5. Write a log to show that user's input has been requested.
6. Proceed to process user input to determine the type of command to execute. More details on the implementation of
processing user input will be discussed in future sections.
7. Repeat steps 4-6 if user does not input exit command.   

## 4. Documentation

All documentation can be found under the `docs/` folder. Alternatively, visit
https://ay2021s2-cs2113t-t09-4.github.io/tp/ to browse all the document.

* [Jekyll](https://jekyllrb.com/) is used to manage the documentation.
* [GitHub Flavored Markdown](https://guides.github.com/features/mastering-markdown/) is used to write the documentation.
* [diagrams.net](https://draw.io/) (formerly draw.io) is used to create various UML diagrams.

## 5. Testing

## 5.1. Running Tests

There are two ways to test easyLog.

**Method 1: Using IntelliJ JUnit Tests**

**Method 2: Using Gradle**

## 5.2. Types of Tests

We have employed several types of tests as follows:

## 6. Dev Ops

### 6.1. Build Automation

### 6.2. Continuous Integration

### 6.3. Coverage Report

### 6.4. Making a Release

### 6.5. Managing Dependencies

## Appendices

### Appendix A: Product Scope

### Target user profile

- IT savvy home-based businessmen
- Have a need to manage numerous sales data
- The inventory list gets constantly updated (add & delete items/orders)
- Prefer typing over mouse/handwritten
- Can type fast
- Enjoy using CLI software

### Value proposition

A simple database application that helps target user to store and accesse a collection of data electronically from a
computer system.

### Appendix B: User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|user|add new items|track the items added to the warehouse|
|v1.0|user|view the items in the warehouse|track the items that are added or not added to the warehouse|
|v1.0|user|remove items|remove the items that are no longer required to be tracked|
|v1.0|user|add new orders|track the orders added to the system|
|v1.0|user|view the orders in the system|track the orders that are added or not added to the system|
|v1.0|user|remove orders|remove the orders that are no longer required to be tracked|
|v1.0|user|clear all items|re-track all the items if there are any problems|
|v1.0|user|clear all orders|re-track all the orders if there are any problems|
|v1.0|user|view all available commands|refer to them when I forget how to use the application|
|v1.0|user|view all items-related commands|refer to them when I forget how to use the items feature|
|v1.0|user|view all orders-related commands|refer to them when I forget how to use the orders feature|
|v2.0|user|create, save data and load existing data|work on another device with the saved data|
|v2.0|expert user|create, save data and load existing data|edit the data file directly|
|v2.0|user|delete multiple items|save time by not deleting items one by one|
|v2.0|user|delete multiple orders|save time by not deleting orders one by one|
|v2.0|user|find relevant items|save time by looking through relevant items|
|v2.0|user|find relevant orders|save time by looking through relevant orders|
|v2.0|user|add a new item with a specified unit price|calculate order price more easily|
|v2.0|user|update the unit price of an item|revise unit price or correct mistaken unit price entered earlier|
|v2.0|user|add a new item with its stock|keep track of total number of stock and calculate order price more easily|
|v2.0|user|update the stock of an item|Correct mistaken stock number entered earlier|
|v2.0|user|specify the quantity of a item to add to the order|calculate the total price of the order and update the item inventory correctly.|
|v2.0|user|check the total price of a specific order|feedback to customer when they ask for it and do not have to look through the order list.|
|v2.0|user|update the status of an order|differentiate the orders by their status.|

### Appendix C: Non-Functional Requirements

- A user should be able to work on any mainstream OS as long as it has Java 11 or above installed.
- A user should be able to respond to any command in less than 2 seconds.
- A user should be able to complete majority of tasks faster using CLI than GUI.

### Appendix D: Glossary

Abbreviation | Full title | Definition
-------- | ---------- | ----------
**CI**   | Continuous Integration | Combining parts of a software product to form a whole
**IntelliJ** | IntelliJ | An Integrated Development Environment written in Java
**CLI** | Command Line Interface | A program that accepts text inputs to execute operating system functions
**GUI** | Graphical User Interface | An interface that allows users to interact through graphical icons
**Mainstream OS** | Windows, Linux, Unix, OS-X | Operating systems

[Return to Top](#1-introduction)