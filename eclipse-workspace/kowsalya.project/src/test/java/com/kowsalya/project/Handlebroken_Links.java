package com.kowsalya.project;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handlebroken_Links {

	public static void main(String[] args) throws IOException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.deadlinkcity.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Broken Links

		List<WebElement> findElements = driver.findElements(By.tagName("a"));

		for (WebElement webElement : findElements) {

			String link = webElement.getAttribute("href");
			int brokenlinks = 0;

			if (link == null || link.isEmpty()) {
				System.out.println("URL is empty:");
				continue;
			}

			URL ur = new URL(link);
			HttpURLConnection httpconn = (HttpURLConnection) ur
					.openConnection();

			httpconn.connect();

			if (httpconn.getResponseCode() >= 400) {

				System.out.println(
						httpconn.getResponseCode() + " is " + " Broken Link ");

				brokenlinks++;
			} else {

				System.out.println(httpconn.getResponseCode() + " is "
						+ " not a broken link ");

			}

		}

	}

}
