package com.kowsalya.project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Javasc {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com/");

		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement findElement = driver
				.findElement(By.xpath("//h2[text()='Welcome to our store']"));

// Drawborder using javascript in any webelement
		js.executeScript("arguments[0].style.border='3px solid orange'",
				findElement);

		WebElement findElement2 = driver
				.findElement(By.xpath("//strong[text()='Community poll']"));

		js.executeScript("arguments[0].style.border='3px solid green'",
				findElement2);

		// getTitle
		String string = js.executeScript("return document.title;").toString();

		System.out.println(string);

		WebElement findElement3 = driver
				.findElement(By.xpath("//a[text()='Register']"));

//For clicking an element using Javascript
		js.executeScript("arguments[0].click();", findElement3);
		
///For Refreshing		
		js.executeScript("history.go(0)");
		
// For zooming the webpage
		js.executeScript("document.body.style.zoom='150%'");	
		
	}
}
