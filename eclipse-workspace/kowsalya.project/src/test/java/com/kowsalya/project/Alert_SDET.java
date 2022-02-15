package com.kowsalya.project;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert_SDET {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-notifications");

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		driver.manage().window().maximize();

		// JS Alert

		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

		Thread.sleep(3000);

		Alert alert = driver.switchTo().alert();

		System.out.println(alert.getText());

		alert.accept();

		// JS Confirm

		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"))
				.click();

		Thread.sleep(3000);

		Alert alert2 = driver.switchTo().alert();

		System.out.println(alert.getText());

		alert2.accept();

		// JS Prompt

		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

		Thread.sleep(3000);

		Alert alert3 = driver.switchTo().alert();

		alert3.sendKeys(
				"Deepak Prabhu is one of the Best SDET Engineer in the world");

		Thread.sleep(3000);

		System.out.println(alert.getText());

		alert3.accept();

	}

}
