package screenshot;

import java.io.File;
import java.io.IOException;

import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class screenshot {

public static WebDriver driver;
public static void initialization() {
	System.setProperty("webdriver.chrome.driver",
	             "C:\\chrome\\new\\sypernew\\New folder\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.get("http://google.com");
}
public void failed(String testMethodName) {
	File ScFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtil.copyFile(ScFile, new File("/Users/localadmin/eclipse-workspaceDIMA/first/ScreenShot"+testMethodName+"_"+".png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}

 
