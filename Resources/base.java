

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public WebDriver driver;
	public Properties properties;
	
	public WebDriver initializeDriver() throws IOException {
		
		properties = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Admin\\MavenJavaReview\\src\\main\\java\\Resources\\data.properties");
		
		properties.load(fis);
		String browserName = properties.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C://Users//Admin//Documents//chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Admin\\Documents\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\Admin\\Documents\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\Admin\\Documents\\IEDriverServer_Win32_3.150.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

}
