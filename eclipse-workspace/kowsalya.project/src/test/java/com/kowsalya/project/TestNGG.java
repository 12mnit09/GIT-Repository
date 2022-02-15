package com.kowsalya.project;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class TestNGG {
	@BeforeSuite
	private void setProperty() {
		System.out.println("Set Property");
	}
	@BeforeTest
	private void launchBrowser() {
		System.out.println("Launch Browser");
	}
	@BeforeClass
	private void launchURL() {
		System.out.println("Launchin the URL");
	}

	@BeforeMethod
	private void signIn() {
		System.out.println("Sign in");
	}
	@Test
	private void appleIphone() {
		System.out.println("I am Apple Phone");
	}
	@Test
	private void samsung() {
		System.out.println("I am SamsumgPhone");
	}
	@Test
	private void redmi() {
		System.out.println("I am Rdmi Phone");
	}
	@AfterMethod
	private void signOff() {
		System.out.println("Sign off");
	}
	@AfterClass
	private void homePage() {
		System.out.println("HomePage");
	}
	@AfterTest
	private void close() {
		System.out.println("Close");
	}
	@AfterSuite
	private void deleteCookies() {
		System.out.println("Delete cookies");
	}
}
