import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest{
	
static WebDriver driver;
	
	
	@BeforeMethod(alwaysRun = true)
	public void setUpBrowser(@Optional("chrome") String browserName) {
	
		if(browserName.contains("chrome")) {
			//ChromeOptions co=new ChromeOptions();
			//co.addArguments("--remote-allow-origins");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		} else if(browserName.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		}
		else {
			System.out.println("Browser name not specified");
		}
		
		driver.manage().window().maximize();
		driver.get("https://www.tarladalal.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();
		
	}
	
	
	@AfterClass(alwaysRun = true)
	public void browserTearDown() {
	//	driver.quit();
	}
	/*
	@AfterMethod(alwaysRun = true)
	public void browserClose() {
		driver.quit();
	}
	*/
	}
