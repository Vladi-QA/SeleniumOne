package screenshot;

 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

 
@Listeners(CustomListner.class)
public class ScreenShot2Page extends screenshot{
@BeforeMethod
public void setUp() {
	initialization();
	
	
}
@AfterMethod
public void tearDown() {
	driver.quit();
	
}
@Test
public void isDisplay() {
	WebElement element = driver.findElement(By.className("lnXdpd"));
	if(!element.isDisplayed()) {
		System.out.println("Element is not displayed");
	}else {
		System.out.println("Element is present");
	}
}
@Test
public void takeScreenshotTest2() throws InterruptedException {
	driver.findElement(By.name("q")).sendKeys("Volodymyr Dziuba");
	 Thread.sleep(3000);
	WebElement a = driver.findElement(By.className("gNO89b"));
	a.click();
	String actresult = driver.getTitle();
	String expTitle = "Volodymyr Dziuba - Google Search";
	 
	Assert.assertEquals(actresult, expTitle);
}
}
