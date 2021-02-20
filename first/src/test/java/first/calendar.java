package first;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

	public class calendar {

		public   static void  main(String[]args) throws InterruptedException {
			
			System.setProperty(
		             "webdriver.chrome.driver",
		             "C:\\chrome\\new\\sypernew\\New folder\\chromedriver.exe");
			
				WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.get("https://www.spicejet.com/");
				driver.getTitle();
		 
				driver.findElement(By.xpath("//*[@id='c"
						+ "tl00_mainContent_view_date1']")).click();//obschii clik na kalendar na main page
				//mounth
				 while(!driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().contains("April")) {
				 	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
				 }
			
				
				//Thread.sleep(4000);
			//	List<WebElement> data =driver.findElements(By.xpath("//a[@class='ui-state-default']"));//click on calendar
				 int count = driver.findElements(By.xpath("//a[@class='ui-state-default']")).size(); //obshego kalendar
			 
			  for(int i=0;i<count; i++) {
			 String text=driver.findElements(By.xpath("//a[@class='ui-state-default']")).get(i).getText();// polychit text
			 if(text.equalsIgnoreCase("28")) {
				 driver.findElements(By.xpath("//a[@class='ui-state-default']")).get(i).click();
				 break;
			 }
			 }
				 }

	}