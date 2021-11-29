/*Assignment

* 1. Validate the title of the page is OrangeHRM

* 2. Validate username field is displayed

* 3. Validate Login Panel Text is displayed

* 4. In Users tab >> Search for ajay >> No record found should be displayed

* 5. In Users tab >> Search for aravind >> Atleast one record should be displayed

*/
package TestNg;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestNGAssignment {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		
	}
	@Test

	public void validateUserName() {

	boolean userName = driver.findElement(By.id("txtUsername")).isDisplayed();

	Assert.assertTrue(userName);

	}
	
	@Test

	public void validateLoginPanel() {
		boolean loginPanel= driver.findElement(By.id("logInPanelHeading")).isDisplayed();
		Assert.assertTrue(loginPanel);
		
	}
	
	@Test
	
	public void validateSearchAjay(){
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("menu_admin_UserManagement")).click();
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("Ajay");
		driver.findElement(By.id("searchBtn")).click();
		boolean SearchAjay= driver.findElement(By.id("searchSystemUser_userName")).isDisplayed();
		Assert.assertTrue(SearchAjay);
		
		}
	
	@Test
	
	public void validateSearchArvind() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("menu_admin_UserManagement")).click();
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("Aravind");
		driver.findElement(By.id("searchBtn")).click();
		boolean SearchAravind= driver.findElement(By.id("searchSystemUser_userName")).isDisplayed();
		Assert.assertTrue(SearchAravind);
		
		
	}
	
	
	

}
