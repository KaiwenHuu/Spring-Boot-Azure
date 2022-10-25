package com.example.springbootazure.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @RequestMapping("/")
  public String home() {
    return "Hello from Azure App Service! Let's start connecting to Azure SQL Server!";
  }
  
}
