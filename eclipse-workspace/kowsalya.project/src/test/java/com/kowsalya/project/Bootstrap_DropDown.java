package com.kowsalya.project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bootstrap_DropDown {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-notifications");

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://www.hdfcbank.com/");

		WebElement findElement = driver
				.findElement(By.xpath("//a[text()='Select Product Type']"));

		findElement.click();

		// Select Product Type
		List<WebElement> findElements = driver.findElements(
				By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));

		System.out.println("Number of options:" + findElements.size());

		for (WebElement webElement : findElements) {

			if (webElement.getText().equals("Health Insurance")) {
				webElement.click();
				break;
			}

		}

		// Select product

		WebElement findElement2 = driver
				.findElement(By.xpath("//a[text()='Select Product']"));

		findElement2.click();

		List<WebElement> findElements2 = driver.findElements(
				By.xpath("//ul[@class='dropdown2 dropdown-menu']/li"));
		
		System.out.println("Number of elements in the product type:"+findElements2.size());

		for (WebElement webElement : findElements2) {

			if (webElement.getText().equals("Super Top-up Insurance")) {
				webElement.click();
				break;
			}
		}

	}
}
