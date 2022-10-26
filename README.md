# Spring-Boot-Azure

The purpose of this repository is to demonstrate how to build a simple web application with Spring Boot application using Azure App Service that runs on Java 17. We will also connect to other resources like Azure SQL databases, Storage Accounts, Key Vaults, etc.

## Initialize Spring Boot Application

### 1 Generate Spring Boot Project

Go to https://start.spring.io/ and pick the following.

| Left |  Center  | Right |
|:-----|:--------:|------:|
| L0   | **bold** | $1600 |
| L1   |  `code`  |   $12 |
| L2   | _italic_ |    $1 |

Project = Maven (this can be done with Gradle as well)
Language = Java
Packaging = Jar
Java = 17 (this can be older versions as well)

Add the following depdencies: Spring Web, Thymeleaf, Spring Data JDBC, Spring Data JPA, H2 Database, Spring Boot DevTools, Azure Support, Azure Active Directory, Azure Cosmos DB, Azure Key Vault, Azure Storage, MS SQL Server Driver.

Finally, click Generate.

### 2 Some Coding

Open the Spring Boot Project you just generated in any IDE.

Under the same directory where Application.java is located, create a new directory named "controller". Under the new controller directory, create a new Controller.java file.

```java
@RestController
public class Controller {

  @RequestMapping("/")
  public String home() {
    return "Hello from Azure App Service! Let's start connecting to Azure SQL Server!";
  }
  
}
```

### 3 Compile Locally

Go to the root directory where the SPring Boot Project is located in the command line and run the application locally with the following command.
```
mvn package
 # this creates a .jar file for the application to run. Azure App Service will build and deploy the code from the .jar file.
java -jar target/<your-jar-file>-SNAPSHOT.jar
```

Browse http://127.0.0.1:8080 to check if the application compiles.

### 4 Deploy Spring Boot Application on Azure Web Apps

Go to your Azure Portal and create an App Service with the following configuration

Resoruce Group = Any resource group
Name = Any name
Publish = Code (default value)
Runtime stack = Java 17
Java web server stack = Java SE (Embedded Web Server)
Operating System = Linux or Windows
Region = Any region
App Service Plan = P1v2 (any plan would do)

Then, create the resource.

Once the resource is created, you should be able to browse <name>.azurewebsites.net now.

To deploy your code on Azure Web Apps, first make sure that your code is pushed on a Github repository.

Now go to the web app in the Azure Portal, and on the left plane select Deployment Center. In Settings, select Github as your source. If this is your first time using Github in your Azure portal, follow the instructions and sign into your Github account for authorization. Select the organization (your github user id), repository that you want to deploy, and the branch that you want to deploy (usually main). Make sure that the Build configuration is correct. By selecting Save, you will create a workflow yml file. This yml file enables you to deploy the code everytime there is a new code change pushed into the main branch.
