# <p align="center">Welcome to Health Tracking Application</p>
![image](https://github.com/user-attachments/assets/f84c65a4-4195-45c6-9fee-0ed54cd5dac7)


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

## 4. Heart Rate, Calories, Sleep, and Blood Metrics

- Collects data on heart rate, calories burned, sleep duration, blood pressure, and blood sugar levels.

- Displays a health report with recommendations.

## 5. Sleep Tracker

- Tracks resting heart rate.

- Helps monitor cardiovascular health.

# 📂 Project Structure

Health_Tracker/
├── src/
│   ├── Main.java              # Entry point of the program
|   ├── Menu.java
│   ├── Client.java            # Manages user information
│   ├── BMI.java               # Handles BMI calculations
│   ├── StepTracker.java       # Manages step tracking
│   ├── WaterTracker.java      # Tracks water intake
│   ├── InputBMIData.java      # Handles user input for BMI
│   ├── Colors.java          # MySQL database connection
|   ├── SleepTracker.java
├── README.md                  # Project documentation
├── requirements.txt            # List of dependencies
└── .gitignore                  # Ignored files in Git
