package first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class database {

	public static void main(String[] args) throws SQLException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\chrome\\new\\sypernew\\New folder\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://book.spicejet.com/Login.aspx");
		// TODO Auto-generated method stub
		String host ="localhost";
		String port ="3306";
Connection con =DriverManager.getConnection("jdbc:mysql://" + host+":" + port + "/Employee_one", "root", "Vova1982");
Statement s=con.createStatement();
ResultSet rs =s.executeQuery("select name, salary from employee where department=\"IT\" ");
while (rs.next()){
System.out.println(rs.getString("name"));
System.out.println(rs.getString("salary"));
driver.findElement(By.id("ControlGroupLoginView_MemberLoginView2LoginView_TextBoxUserID")).sendKeys(rs.getString("name"));
driver.findElement(By.id("ControlGroupLoginView_MemberLoginView2LoginView_PasswordFieldPassword")).sendKeys(rs.getString("salary"));
}


	}

}
