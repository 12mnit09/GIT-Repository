package com.kowsalya.project;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-notifications");

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.linkText("Customer Service")).click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.partialLinkText("Books")).click();

		// How to capture all the links in the webpage

		List<WebElement> findElements = driver.findElements(By.tagName("a"));
		System.out.println("No of links present are:" + findElements.size());
		for (WebElement webElement : findElements) {

			String text2 = webElement.getText();
			System.out.println(text2);
			String text = webElement.getAttribute("href");
			System.out.println(text);
			System.out.println();
			System.out.println("---------------------------------------------");
			System.out.println();
		}
	}

}
