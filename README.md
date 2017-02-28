
Decathlon-assessment - simple console application for decathlon assessment
===================
Decathlon-assessment is a simple console application that can be used for decathlon assessment

![image](https://raw.githubusercontent.com/viktornar/decathlon-assessment/master/images/application.png)

The main technologies (frameworks, build tools) that was used in project
-------------
- Standard Java API (that comes with Java 1.8 JDK. Javax packages as part of JDK was used as well)
- JUnit for testing
- Maven > 3.0 for project build is needed

> **Note:**

> - Project was written by using Java SDK 1.8. Source was compiled without compatibility with older Java version.

How to build and run project
-------------
Clone the project with the following command:

```bash
$ git clone https://github.com/viktornar/decathlon-assessment
```

Go to the project directory:

```bash
$ cd decathlon-assessment
```

and run:

```bash
mvn package
```

During compile and package process test will be executed. If everything will be ok IE or other browser should be invoked. In opened browser you will see nicely formatted xml.

To execute program run:

```bash
java -jar decathlon.jar --input input.txt --output output.xml
```

> **Note:**

> - In current application version cli argument parser is still experimental. So do not use spaces and special characters in file paths.


How to develop project
-------------
If you use IDEA or Eclipse just import project as maven project. In IDEA use mvn wrapper. 