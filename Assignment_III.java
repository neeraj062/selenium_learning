import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_III {
	
	public static void useOfExplicitWait(WebDriver driver, WebDriverWait w) {
		driver.findElement(By.xpath("//div[@id='content']/a[2]")).click();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#results")));
		driver.findElement(By.cssSelector("#results")).getText();
		
		System.out.println("Expicit Wait is applied successfully");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\acer\\Downloads\\software\\ChromeDriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
		WebDriverWait w = new WebDriverWait(driver,5);
		useOfExplicitWait(driver,w);
	}

}
