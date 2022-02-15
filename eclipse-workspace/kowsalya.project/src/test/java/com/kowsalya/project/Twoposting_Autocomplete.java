package com.kowsalya.project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Twoposting_Autocomplete {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.twoplugs.com/");

		driver.manage().window().maximize();

		WebElement findElement = driver
				.findElement(By.xpath("//a[text()='Live Posting']"));
		findElement.click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement findElement2 = driver
				.findElement(By.xpath("//input[@id='autocomplete']"));

		findElement2.clear();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		findElement2.sendKeys("Toronto");

		Thread.sleep(3000);
		String text;

		do {

			findElement2.sendKeys(Keys.ARROW_DOWN);

			Thread.sleep(3000);

			text = findElement2.getAttribute("value");

			if (text.equals("Toronto, OH, USA")) 
			{
				
				findElement2.sendKeys(Keys.ENTER);
				break;
			}
			Thread.sleep(3000);

		} while (!text.isEmpty());

	}
}
