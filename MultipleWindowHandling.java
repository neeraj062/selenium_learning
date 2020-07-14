package actionAndframes;

import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleWindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\acer\\Downloads\\software\\ChromeDriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//ul[@class='Bgzgmd']/li[1]"))).click().build().perform();
		System.out.println(driver.getTitle());
		
		Set<String>ids = driver.getWindowHandles();
		Iterator<String> it =ids.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		String childWindow1 = it.next();
		driver.switchTo().window(childWindow1);
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
		
		driver.quit();
		System.out.println("Ran Successfully");
		

	}

}
