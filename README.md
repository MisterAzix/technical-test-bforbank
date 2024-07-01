# 🚀 BforBank Technical Test 🚀

## Introduction

Welcome to the BforBank MoneyPot Microservice. This project is a part of the technical test for BforBank's internship program. The microservice is designed to manage a "MoneyPot" for each customer. Every time a customer makes a purchase, the merchant can add a certain amount to the customer's MoneyPot. The customer can check their MoneyPot at any time to see if it is available. A MoneyPot is considered available if the customer has made at least 3 purchases and has a minimum of €10 in their MoneyPot.

The microservice is built using Java, Spring Boot, SQL, and Maven. It exposes a REST API for managing the MoneyPots.

## What could be improved ?
- Add rights management with a canExecute method at usecase level
- Add Deployment 
- Add environment management (to prepare deployment)
- Add E2E tests
- Add coverage check to prevent pull request to be merged if test coverage is not enough
- Add a small front to interact with the API

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
Project available at http://localhost:8080

## Examples

1. View moneypot containing 15€ and 3 transactions, available is true
<img width="1311" alt="image" src="https://github.com/MisterAzix/technical-test-bforbank/assets/40914400/e95361fc-1419-45c7-b67d-e974dbfe58e0">

2. View moneypot containing 20€ but only 2 transactions, available is false
<img width="1311" alt="image" src="https://github.com/MisterAzix/technical-test-bforbank/assets/40914400/aecba14e-ff68-4a45-9497-d1a62bbe96f6">

3. Adding money to moneypot
<img width="1311" alt="image" src="https://github.com/MisterAzix/technical-test-bforbank/assets/40914400/9737ee5f-f85b-4377-9d28-8cd1a8b6af5a">
<img width="1312" alt="image" src="https://github.com/MisterAzix/technical-test-bforbank/assets/40914400/7fdfc7f7-a99a-48b8-9ccb-f36d1beb9d20">

4. View a not found moneypot
<img width="1312" alt="image" src="https://github.com/MisterAzix/technical-test-bforbank/assets/40914400/e4540cd0-9a70-4ba7-9a3f-81c141bd6ece">

## 👤️ Authors 👤

- Maxence BREUILLES ([@MisterAzix](https://github.com/MisterAzix))<br />
