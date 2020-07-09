import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedifE2E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\Downloads\\software\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rediff.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.cssSelector("a[title*='Sign in")).click();
		//driver.findElement(By.xpath("//input[conatins(@name,'Login')]")).sendKeys("Email_useraname");
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("dyguweyuwu");
		
		driver.findElement(By.xpath("//input[contains(@id,'pass')]")).sendKeys("Password_enter");
		//driver.findElement(By.cssSelector("input#password")).sendKeys("dyguweyuwu376716");
		driver.findElement(By.cssSelector("input.signinbtn")).click();
		System.out.print(driver.findElement(By.cssSelector("#div_login_error")).getText());
		
		//driver.close();
		
	}

}
