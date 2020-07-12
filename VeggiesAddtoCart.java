import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VeggiesAddtoCart {

	public static void productsItem(WebDriver driver, String[] veggieMenu,WebDriverWait w) {
		List<WebElement> products = driver.findElements(By.xpath("//*[@class='product-name']"));

		List<String> productList = Arrays.asList(veggieMenu);
		// int j=0;
		for (int i = 0, j = 0; i < products.size(); i++) {
			String[] pName = products.get(i).getText().split("-");
			String actualText = pName[0].trim();

			if (productList.contains(actualText)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				// Thread.sleep(3000);

				if (j == productList.size())
					break;

			}

		}
		driver.findElement(By.xpath("//a[@class='cart-icon']/img")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='promoWrapper']/input")));
		
		driver.findElement(By.xpath("//div[@class='promoWrapper']/input")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		//defining explicit wait -- driver on which we are working and the time in seconds --Specifically tageting this element
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\acer\\Downloads\\software\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); -----> Sysntax of implicit Wait
		WebDriverWait w = new WebDriverWait(driver,5);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		String[] veggieMenu = { "Brocolli", "Cucumber" };
		Thread.sleep(3000);
		productsItem(driver, veggieMenu,w);

		System.out.println("Products are added to cart Successfully");

	}

}
