Automation Project — Cyclos Application

A production-grade Selenium BDD automation framework built with Java, Cucumber, TestNG, and Maven.
Designed for scalability, maintainability, reporting, and CI/CD integration.

Application Under Test:Cyclos Web Application

Table of Contents

* Project Overview
* Tech Stack
* Prerequisites
* Project Structure
* Features Covered
* Configuration
* Running Tests
* Reports
* Logging
* Jenkins Integration
* Contributors

Project Overview

This framework automates end-to-end UI scenarios for the Cyclos application using a hybrid architecture combining BDD, Page Object Model, and data-driven testing.

| Key             | Value                       |
| --------------- | --------------------------- |
| Project Name    | Cyclos_AutomationTesting    |
| Framework Type  | Hybrid — BDD + POM + TestNG |
| Build Tool      | Maven                       |
| Java Version    | Java 17                     |
| Version Control | Git + GitHub                |
| Reporting       | Allure + Extent + Cucumber  |

Core capabilities

* Page Object Model (POM)
* Cucumber BDD feature files using Gherkin
* TestNG execution support
* Selenium WebDriver automation
* Data-driven test support
* WebDriverManager integration
* Log4j2 logging
* Jenkins CI/CD support
* Multiple report generation formats
* Hooks support for setup and teardown

Tech Stack

| Technology       | Version |
| ---------------- | ------- |
| Java             | 17      |
| Selenium         | 4.43.0  |
| Cucumber         | 7.34.3  |
| TestNG           | 7.12.0  |
| Maven            | 3.x     |
| WebDriverManager | 6.1.0   |
| Extent Reports   | 5.1.2   |
| Allure           | 2.34.0  |
| Log4j2           | 2.25.4  |

Prerequisites

Install the following:

| Requirement     | Version     |
| --------------- | ----------- |
| Java JDK        | 17          |
| Maven           | 3.x         |
| Git             | Latest      |
| Chrome Browser  | Latest      |
| Firefox Browser | Latest      |
| IntelliJ IDEA   | Recommended |

Verify:

bash
java -version
mvn -version
git --version

Project Structure

text
Cyclos_AutomationTesting/
│
├── src/test/java/
│   ├── StepDefinitions/
│   ├── Hooks/
│   ├── Runners/
│   ├── Pages/
│   └── Utilities/
│
├── src/test/resources/
│   ├── Features/
│   ├── config.properties
│   └── testdata/
│
├── testng.xml
├── pom.xml
├── target/
└── reports/

Features Covered

Current automation modules include:

* QR Code functionality
* Payment Request module
* User Invite functionality
* Receive payment scenarios
* Advertisements module
* Business Directory workflows
* Payment to User module

Configuration

Update values in:

properties
src/test/resources/config.properties


Example:

properties
browser=chrome
url=<application-url>
username=<username>
password=<password>

Running Tests

Execute all tests:

bash
mvn clean test

Execute using TestNG suite:

bash
mvn test -DsuiteXmlFile=testng.xml

Generate reports:

bash
mvn clean verify

Run specific Cucumber tags:

bash
mvn test -Dcucumber.filter.tags="@krishna"

Reports

Framework supports:

* Cucumber HTML Reports
* Cucumber JSON Reports
* Extent Reports
* Allure Reports
* Surefire Reports

Allure:

bash
allure serve target/allure-results

Report directories:

text
target/CucumberReports/
target/allure-results/
target/surefire-reports/

Logging

Logging is implemented using Log4j2.

Log files help track:

* Test execution
* Failures
* Browser actions
* Debug information

Jenkins Integration

Integrated with Jenkins pipeline execution.

Pipeline supports:

* Git checkout
* Maven build execution
* Report generation
* Test result publishing
* Scheduled execution

Sample:

bash
mvn clean verify
