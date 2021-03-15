# Packaging Challenge
### Problem Definition
You want to send your friend a package with different things. Each thing you put inside the package has such parameters as index number, weight and cost. The package has a weight limit. Your goal is to determine which things to put into the package so that the total weight is less than or equal to the package limit and the total cost is as large as possible. You would prefer to send a package which weighs less in case there is more than one package with the same price.
##### Input Sample
Your API should accept as its first argument a path to a filename. The input file contains several lines. Each line is one test case. Each line contains the weight that the package can take (before the colon) and the list of items you need to choose. Each item is enclosed in parentheses where the 1st number is a item's index number, the 2nd is its weight and the 3rd is its cost. E.g
```shell
81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)
8 : (1,15.3,€34)
75 : (1,85.31,€29) (2,14.55,€74) (3,3.98,€16) (4,26.24,€55) (5,63.69,€52) (6,76.25,€75) (7,60.02,€74) (8,93.18,€35) (9,89.95,€78)
56 : (1,90.72,€13) (2,33.80,€40) (3,43.15,€10) (4,37.97,€16) (5,46.81,€36) (6,48.77,€79) (7,81.80,€45) (8,19.36,€79) (9,6.76,€64)
```
##### Output Sample
For each set of items that you put into a package provide a new row in the output string (items' index numbers are separated by comma). E.g.
```shell
4
-
2,7
8,9
```
##### Constraints
1. Max weight that a package can take is ≤ 100
2. There might be up to 15 items you need to choose from
3. Max weight and cost of an item is ≤ 100

------------
# Solution
The packer challenge is a kind of **knapsack** problem. It is an NP-hard problem. There are brute force techniques like recursion to solve such kind of problems. In this solution** dynamic programming** is implemented. Dynamic programming is a really useful general technique for solving problems that involves breaking down problems into smaller overlapping sub-problems, storing the results computed from the sub-problems and reusing those results on larger chunks of the problem. 
The solution is implemented in **Java 8**. As a build automation tool **Gradle** is used.
#### Requirements
This program is written in Java, and therefore requires a **JVM**.

#### Usage
You can get up and run with the gradle project quickly wtihout having to follow manual installation processes.  **Gradle Wrapper** script is used to invoke the declared version of Gradle which is specified in the properties. It automatically downloads the gradle version beforehand.

**Clean and build the project.**


    gradlew clean build  

or

     ./gradlew clean build

**Run unit test**

    gradlew clean test

or

    ./gradlew clelan test

- Executable jar file is located under build/libs folder with the name **packer-1.0.0.jar**

**Execution**
```shell
java -jar packer-1.0.0.jar absolute-file-path
```
![Application Execution Result](https://user-images.githubusercontent.com/76202242/103179240-e0495d80-489a-11eb-9dda-262010ff64a3.PNG "Application Execution Result")

**Mockito** is a mocking framework, Java-based library that is used for effective unit testing of Java applications. Mockito is used to mock interfaces so that a dummy functionality can be added to a mock interface that can be used in unit testing.

**TestNG** is a testing framework designed for unit testing for Java programming language. TestNG annotations are used to create test cases.

**JaCoCo** is a Java Code Coverage Library. Jacoco is used to measure how many lines of the code are executed during automated tests.

- Test coverage report is located under build/jacoco/test/html folder with the name **index.html**

![Jacoco - Test Coverage Report](https://user-images.githubusercontent.com/76202242/103179326-e2f88280-489b-11eb-93d6-00fc05ff092f.PNG "Jacoco - Test Coverage Report")
