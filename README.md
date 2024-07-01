# 🚀 BforBank Technical Test 🚀

## Introduction

Welcome to the BforBank MoneyPot Microservice. This project is a part of the technical test for BforBank's internship program. The microservice is designed to manage a "MoneyPot" for each customer. Every time a customer makes a purchase, the merchant can add a certain amount to the customer's MoneyPot. The customer can check their MoneyPot at any time to see if it is available. A MoneyPot is considered available if the customer has made at least 3 purchases and has a minimum of €10 in their MoneyPot.

The microservice is built using Java, Spring Boot, SQL, and Maven. It exposes a REST API for managing the MoneyPots.

## Installation Guide

### Prerequisites

- Java 17
- Maven

### Steps

1. Clone the repository to your local machine.
```bash
git clone git@github.com:MisterAzix/technical-test-bforbank.git
```
2. Navigate to the project directory.
```bash
cd technical-test-bforbank
```
3. Build the project using Maven.
```bash
mvn clean install
```
4. Launch database using Docker.
```bash
docker-compose up -d
```
5. Run the application.
```bash
mvn spring-boot:run
```

## 👤️ Authors 👤

- Maxence BREUILLES ([@MisterAzix](https://github.com/MisterAzix))<br />