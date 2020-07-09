import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class facebookXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		//System.setProperty("webdriver.chrome.driver", "")
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\Downloads\\software\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("hellloebdggd");
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("Frerwrwff1234");
		driver.findElement(By.xpath("//input[@aria-label='Log In']")).click();
		

	}

}
