package com.kowsalya.project;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Autosuggest {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		WebElement fe = driver.findElement(By.xpath("//input[@name='q']"));
		fe.click();

		driver.manage().window().maximize();

		fe.sendKeys("Selenium");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		List<WebElement> findElements = driver
				.findElements(By.xpath("(//ul[@class='G43f7e'])[1]//li"));

		System.out.println(findElements.size());

		for (WebElement webElement : findElements)
		{

			String text = webElement.getText();

			if (text.equalsIgnoreCase("selenium rich foods"))
			{
				webElement.click();
				break;
			}
		}

	}

}
