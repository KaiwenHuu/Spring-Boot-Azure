# Spring-Boot-Azure

The purpose of this repository is to demonstrate how to build a simple web application with Spring Boot application using Azure App Service that runs on Java 17. We will also connect to other resources like Azure SQL databases, Storage Accounts, Key Vaults, etc.

## Initialize Spring Boot Application

### 1 Generate Spring Boot Project

Go to https://start.spring.io/ and pick the following.

| Element      |   Value  |
|:------------|:--------|
| Project      |   Maven  |
| Language     |    Java  |
| Spring Boot  |    2.7.x |
| Packaging    |    Jar   |
| Java         |    17    |

_We can achieve the same goal using Gradle and War packaging. Also, any Spring Boot version below 2.7.x and Java version below 17 would work as well._

Add the following depdencies: 

- Spring Web
- Thymeleaf
- Spring Data JDBC
- Spring Data JPA
- H2 Database
- Spring Boot DevTools
- Azure Support
- Azure Active Directory
- Azure Cosmos DB
- Azure Key Vault
- Azure Storage
- MS SQL Server Driver.

Finally, click Generate. This will download a zip file that contains the Spring Boot Project.

### 2 Some Coding

Extract the zip file that contains the Spring Boot Project, and open it in any IDE.

Under the same directory where Application.java is, create a new directory named "controller". Under the newly created controller directory, create a Controller.java file. Now, add the following lines of code.

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

Go to the root directory where the Spring Boot Project is located in the command line and run the application locally with the following command.
```
mvn package
 # this creates a .jar file for the application to run. Azure App Service will build and deploy the code from the .jar file.
 
java -jar target/<your-jar-file>-SNAPSHOT.jar
 # this runs the jar file
```

Browse http://127.0.0.1:8080 to check if the application runs locally.

### 4 Deploy Spring Boot Application on Azure Web Apps

Go to your Azure Portal and create an App Service with the following configuration

| Element      |   Value  |
|:------------|:--------|
| Resoruce Group|   Any Resource Group  |
| Name     |    A name for your application  |
| Region   | Any region |
| Publish  |    Code (default value) |
| Runtime stack    |    Java 17 (this should be the same as the Java version you selected when intializing your Spring Boot project)   |
| App Service Plan       |     P1v2 (default value)    |

_For the App Service Plan, pick the plan that best suits your need._

Then, create the resource.

Once the resource is created, you should be able to browse `<name>.azurewebsites.net` now.

To deploy your code on Azure Web Apps, first make sure that your code is pushed on a Github repository.

Now go to the App Service we just created in the Azure Portal, and on the left plane select Deployment Center. In Settings, select Github as your source. If this is your first time using Github in your Azure Portal, follow the instructions and sign into your Github account for authorization. Select the organization (your github user id), repository that you want to deploy, and the branch that you want to deploy (usually main). Make sure that the Build configuration is correct. By selecting Save, you will create a workflow yml file. This yml file enables you to deploy the code to App Service everytime there is a new code change pushed into the main branch.

Now if everything works fine, when we browse `<name>.azurewebsites.net` again, we should see a blank page with **"Hello from Azure App Service! Let's start connecting to Azure SQL Server!"**
