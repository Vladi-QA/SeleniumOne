package first;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenLinks {
	public   static void  main(String[]args)    {
		
		System.setProperty(
	             "webdriver.chrome.driver",
	             "C:\\chrome\\new\\sypernew\\New folder\\chromedriver.exe");
		
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get("http://www.webkul.com");
	//capture all elements
	List<WebElement> links=driver.findElements(By.tagName("a"));
	System.out.println(links.size());
 for(WebElement link:links) {
	 String url=link.getAttribute("href");
	 System.out.println("__________________________________________");
	 System.out.println(url);
 if (url==null||url.isEmpty()) {
	 System.out.println("Url empty");
	 continue;
 }
 
		HttpURLConnection huc;
		try {
			huc = (HttpURLConnection)(new URL(url).openConnection());
			
			
			huc.connect();
			if(huc.getResponseCode()>=400) {
				System.out.println(url +" "+" Broken url");}
			else {
				System.out.println(url +" "+ "Is Valid");
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		}
 
	}
}
 
 