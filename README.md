# BS23-AutomationPractice
## Prerequisites
* Install jdk 8 or any LTS version
* Configure **JAVA_HOME** and **GRADLE_HOME**
* Download Allure 2.17.2 and configure environment path
* Stable internet connection
## How to run this project
* Clone the repo
* Open cmd in the root folder
* Give following commands:
```
gradle clean test
```
```
allure generate allure-results --clean -o allure-report
```
```
allure serve allure-results
```
## Screenshot
These are the snapshot of the allure reports:


![Screenshot_1](https://user-images.githubusercontent.com/71173675/154655298-2b884bee-fcff-4438-a3bb-1db2bd5652e1.png)
