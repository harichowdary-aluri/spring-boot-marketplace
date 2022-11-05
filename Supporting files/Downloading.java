package com.Login;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Downloading{
	

	 private static final String FileUtils = null;

	public static void main(String[] args)  {

	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\s546945\\Downloads\\chromedriver_win32\\chromedriver.exe");

	  	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://localhost:8080/#/");
	  
	  String output = driver.findElement(By.xpath("http://localhost:8080/#/")).getText();
	 System.out.println(output);
	 
}}

