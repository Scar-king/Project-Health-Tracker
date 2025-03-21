# <p align="center">Welcome to Health Tracking Application</p>
![image](https://github.com/user-attachments/assets/f84c65a4-4195-45c6-9fee-0ed54cd5dac7)

# 📋 Table of Contents

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Techology Used](#technology-used)
- [Setup & Installation](#setup-&-installation)
- [Systems Requirement](#systems-requirement)


# 📌 Overview

The **Health Tracker Application** is a Java-based console application designed to help users monitor their health metrics, including BMI calculation, step tracking, and water intake. It provides insights and suggestions based on user inputs and supports database integration using MySQL.

# 🚀 Features

## 1. BMI Calculator

- Calculates Body Mass Index (BMI) based on weight and height.

- Provides health recommendations based on BMI values.

## 2. Step Tracker

- Tracks daily steps taken by the user.

- Compares progress with a user-defined goal.

## 3. Water Intake Tracker

- Records daily water intake.

- Suggests hydration goals based on user profile.

## 4. Heart Rate, and Blood Metrics

- Collects data on heart rate, resting heart rate

- Displays a health report with recommendations.

## 5. Sleep Tracker

- Tracks resting .

- Helps monitor cardiovascular health.

# 📂 Project Structure

```
Health_Tracker/
├── src/
│   ├── Main.java
|   ├── Menu.java
│   ├── Client.java
│   ├── BMI.java
│   ├── StepTracker.java
│   ├── WaterTracker.java
│   ├── InputData.java
│   ├── Colors.java
|   ├── SleepTracker.java
|   ├── HeartTracker.java
├── README.md
└── .gitignore
```

# 🌐 Technology Used

- Java Language
- MySQL (Database for storing user data)
- Visual Studio Code ( IDE )
- GitHub ( Code Communication )

# 🛠️ Setup & Installation

## 1. Prerequisites

- Java 17 or later
- MySQL ( DataBase )
- VsCode

## 2. Clone the Repository

```
git clone https://github.com/yourusername/health-tracker.git
cd health-tracker
```

## 3. Set Up the Database

3.1. Go to MySQL and Import "DataBase.sql" to your workbench
3.2. Find this code below in each features( BMI, StepTracker, WaterTracker, StepTracker, HeartTracker ):
   
```
   private void connectionToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/health_tracker", "root", System.getenv("PASSWORD"));
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }
```


  **Change your user name and your password according to your  your workbench**

## 4. Run the Program

Compile and execute the main Java file:
```
javac src/Main.java

java src.Main
```

# 💻 Systems Requirement

- **OS:** Windows 10 / macOS 10.15 / Linux
- **CPU:** Intel Core i3 (or equivalent)
- **RAM:** 4GB
- **Storage:** 500MB of free disk space
- **Java Version:** Java 17 or higher
- **Database:** MySQL 8.0+
