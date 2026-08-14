<h1 align="center">🚀 Cyclos Automation Testing Framework</h1>

<p align="center">
A robust UI Automation Framework built using <b>Selenium WebDriver</b>, <b>Java</b>, <b>Cucumber BDD</b>, <b>TestNG</b>, and <b>Maven</b> following the <b>Page Object Model (POM)</b> design pattern.
</p>

<p align="center">

![GitHub Repo stars](https://img.shields.io/github/stars/Subathra-subu/Cyclos_AutomationTesting?style=for-the-badge)
![GitHub forks](https://img.shields.io/github/forks/Subathra-subu/Cyclos_AutomationTesting?style=for-the-badge)
![GitHub issues](https://img.shields.io/github/issues/Subathra-subu/Cyclos_AutomationTesting?style=for-the-badge)
![GitHub last commit](https://img.shields.io/github/last-commit/Subathra-subu/Cyclos_AutomationTesting?style=for-the-badge)

</p>

---

# 📖 Overview

Cyclos Automation Testing is an enterprise-grade automation framework developed to automate the testing of the **Cyclos Banking Application**.

The framework is designed with scalability, maintainability, and reusability in mind by implementing the **Page Object Model (POM)** architecture. It supports Behavior Driven Development (BDD) using **Cucumber**, enabling test scenarios to be written in simple, business-readable language.

The framework also integrates reporting, logging, screenshots, and CI/CD support for efficient automated testing.

---

# ✨ Features

- ✅ Page Object Model (POM)
- ✅ Selenium WebDriver Automation
- ✅ Cucumber BDD (Gherkin)
- ✅ TestNG Test Runner
- ✅ Maven Build Management
- ✅ Explicit Waits
- ✅ Reusable Action Methods
- ✅ Utility Classes
- ✅ Configuration File Support
- ✅ HTML Reports
- ✅ Allure Reports
- ✅ Extent Reports
- ✅ Screenshot Capture
- ✅ Logging
- ✅ Cross Browser Execution
- ✅ Jenkins CI/CD Integration

---

# 🚀 Tech Stack

<p align="center">

![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-4.x-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-23D96C?style=for-the-badge&logo=cucumber&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-Framework-E53935?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

</p>

<p align="center">

![Git](https://img.shields.io/badge/Git-Version_Control-F05032?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-Repository-181717?style=for-the-badge&logo=github)
![Jenkins](https://img.shields.io/badge/Jenkins-CI/CD-D24939?style=for-the-badge&logo=jenkins&logoColor=white)
![Allure](https://img.shields.io/badge/Allure-Reports-8DD6F9?style=for-the-badge&logo=allure&logoColor=black)
![Extent Reports](https://img.shields.io/badge/Extent-Reports-4CAF50?style=for-the-badge)

</p>

<p align="center">

![Chrome](https://img.shields.io/badge/Chrome-Latest-4285F4?style=for-the-badge&logo=googlechrome&logoColor=white)
![Edge](https://img.shields.io/badge/Microsoft_Edge-Latest-0078D7?style=for-the-badge&logo=microsoftedge&logoColor=white)
![Eclipse](https://img.shields.io/badge/Eclipse-IDE-2C2255?style=for-the-badge&logo=eclipseide&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ-IDEA-000000?style=for-the-badge&logo=intellijidea)
![Windows](https://img.shields.io/badge/Windows-11-0078D6?style=for-the-badge&logo=windows&logoColor=white)

</p>

---

# 📂 Project Structure

```text
Cyclos_AutomationTesting
│
├── src
│   ├── main
│   │   ├── actions
│   │   ├── base
│   │   ├── listeners
│   │   ├── pages
│   │   └── utilities
│   │
│   └── test
│       ├── features
│       ├── hooks
│       ├── runners
│       └── stepdefinitions
│
├── screenshots
├── reports
├── allure-results
├── test-output
├── pom.xml
└── README.md
```

---

# ⚙️ Prerequisites

Install the following before running the framework.

- Java JDK 17+
- Maven 3.x
- Git
- Google Chrome
- ChromeDriver (or Selenium Manager)
- Eclipse / IntelliJ IDEA

---

# 📥 Clone Repository

```bash
git clone https://github.com/Subathra-subu/Cyclos_AutomationTesting.git
```

```bash
cd Cyclos_AutomationTesting
```

---

# 📦 Install Dependencies

```bash
mvn clean install
```

---

# ▶️ Execute Tests

## Execute All Tests

```bash
mvn test
```

---

## Execute Using TestNG

```bash
mvn clean test
```

---

## Execute Smoke Tests

```bash
mvn test -Dcucumber.filter.tags="@smoke"
```

---

## Execute Regression Tests

```bash
mvn test -Dcucumber.filter.tags="@regression"
```

---

# 📊 Reports

After execution, reports are generated automatically.

### HTML Report

```
test-output/
```

### Allure Results

```
allure-results/
```

Generate Allure Report

```bash
allure serve allure-results
```

---

# 🏗 Framework Components

- Base Driver Initialization
- Page Object Model (POM)
- Base Actions
- Utility Classes
- Configuration Reader
- Logger Utility
- Screenshot Utility
- Explicit Wait Utility
- Hooks
- Test Runner
- Test Data Management
- Reporting

---

# 🧪 Automated Modules

- Login
- Dashboard
- Registration
- QR Code
- Invite User
- Payment Request
- User Management
- Account Management
- Transaction Validation

---

# 📈 Reporting

The framework supports:

- 📄 HTML Report
- 📊 Extent Report
- 📉 Allure Report
- 📸 Screenshot on Failure
- 📝 Execution Logs

---

# 🔄 CI/CD

The framework is Jenkins-ready.

Typical pipeline stages include:

```
Checkout Repository
        ↓
Maven Clean Install
        ↓
Execute Test Suite
        ↓
Generate Reports
        ↓
Publish Reports
```

---

# 💡 Best Practices Followed

- ✔ Page Object Model (POM)
- ✔ Behavior Driven Development (BDD)
- ✔ Reusable Methods
- ✔ Explicit Waits
- ✔ Externalized Test Data
- ✔ Modular Framework Design
- ✔ Configuration Management
- ✔ Logging
- ✔ Screenshot Capture
- ✔ Clean Code Principles

---

# 👨‍💻 Contributors

| Name |
|------|
| **Subathra** |
| **Krishnaprasath B** |
| **Sriram** |
| **Akksheetha** |
| **Shobana** |

---

# 🚀 Future Enhancements

- Parallel Test Execution
- Selenium Grid Integration
- Docker Support
- API Automation
- Database Validation
- Cross Browser Parallel Execution
- GitHub Actions Workflow
- Email Report Integration

---

# 📜 License

This project is intended for **educational purposes**, **automation learning**, and **internal testing**.

---

<h3 align="center">⭐ If you find this project useful, don't forget to Star the repository! ⭐</h3>
