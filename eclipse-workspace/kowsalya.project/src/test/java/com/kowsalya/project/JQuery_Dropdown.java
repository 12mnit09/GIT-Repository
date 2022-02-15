package com.kowsalya.project;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQuery_Dropdown {

	private static void selectByChoices(WebDriver driver, String... value) {

		List<WebElement> findElements = driver
				.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));

		for (WebElement webElement : findElements) {

			String text = webElement.getText();

			if (text.equalsIgnoreCase("all")) {
				webElement.click();
			} else {
				for (String val : value) {
					if (text.equals(val)) {

						webElement.click();
					}
				}

			}
		}
	}
	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();

		WebElement findElement = driver
				.findElement(By.xpath("//input[@id='justAnInputBox']"));
		findElement.click();

		/*
		 * List<WebElement> findElements =
		 * driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		 */

		selectByChoices(driver, "choice 1", "choice 2 3", "choice 6",
				"choice 6 2 1", "choice 6 2");

	}
}
