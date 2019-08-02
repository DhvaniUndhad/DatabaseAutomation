import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JdbcConnection {

	public static void main(String[] args) throws SQLException {
		String host = "localhost";
		String port = "3306";
		String url = "jdbc:mysql://localhost/Qadbt?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		Connection con = DriverManager.getConnection(url, "root", "admin");

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from Employeeinfo where id=1");
		
		while (rs.next()) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/vivekbhalala/Downloads/selenium-java-3.141.59/chromedriver");
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://login.salesforce.com/");
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(rs.getString("name"));

			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(rs.getString("location"));

			// System.out.println(rs.getString("name"));
			// System.out.println(rs.getString("location"));
		}
	}

}
