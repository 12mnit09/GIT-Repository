package com.kowsalya.project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window_Handling {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/");

		// getWindowHandle is a method by which we can get the ID of the single
		// browser window

		String windowID = driver.getWindowHandle();

		System.out.println(windowID);

		// getWindowhandles

		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();

		// Return IDs of Multiple Windows

		Set<String> windowIDs = driver.getWindowHandles();
		
		/*
		 * Iterator<String> it = windowIDs.iterator();
		 * 
		 * String parentID = it.next();
		 * 
		 * String childID = it.next();
		 * 
		 * System.out.println("Parent Window ID:"+parentID);
		 * 
		 * System.out.println("Child Window ID:"+childID);
		 */
		
		//Using Array List
		
		List<String> windowsIDList= new ArrayList<String>(windowIDs);
		
		System.out.println("Parent Window ID:"+windowsIDList.get(0));
		
		System.out.println("Child Window ID"+windowsIDList.get(1));

		driver.switchTo().window(windowsIDList.get(0));
		
		driver.switchTo().window(windowsIDList.get(1));
		

		
	}
}
