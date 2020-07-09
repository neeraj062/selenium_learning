import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Salesforce {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\Downloads\\software\\ChromeDriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://login.salesforce.com");
		System.out.println("Tile of the page" +" "+driver.getTitle());
		System.out.println("Current URl"+" "+driver.getCurrentUrl());
		driver.findElement(By.xpath("//*[@id=\'username\']")).sendKeys("hello");
		driver.findElement(By.cssSelector("#password")).sendKeys("12345");
		//driver.findElement(By.className("input r4 wide mb16 mt8 password")).click();
		//driver.findElement(By.xpath("//*[@id='forgot_password_link']")).click();
		driver.findElement(By.xpath("//*[@id=\'rememberUn\']")).isSelected();
		//driver.findElement(By.xpath("//*[@id=\'Login\']")).click();
		
		//System.out.println(driver.findElement(By.cssSelector("#error")).getText());
		//driver.quit();
		
	}

}
