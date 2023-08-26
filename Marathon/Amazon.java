package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags");
		driver.findElement(By.xpath("//div[@class='left-pane-results-container']//div[@aria-label='bags for boys']")).click();
		String result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
		System.out.println("Results Found : " +result);
		driver.findElement(By.xpath("//li[@id='p_89/Skybags']//i[@class='a-icon a-icon-checkbox']")).click();
		driver.findElement(By.xpath("//li[@id='p_89/American Tourister']//i[@class='a-icon a-icon-checkbox']")).click();
		WebElement sorting = driver.findElement(By.xpath("//select[@id='s-result-sort-select']"));
		Select sort = new Select(sorting);
		sort.selectByIndex(4);
		String bagname = driver.findElement(By.xpath("(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2'])[1]//span")).getText();
		System.out.println("New Arrival Bag Name : " +bagname);
		String offerprice = driver.findElement(By.xpath("(//div[@class='a-row a-size-base a-color-base'])[1]//span[2]")).getText();
		System.out.println("Discounted Price : " +offerprice);		
		String title = driver.getTitle();
		System.out.println("WebPage Title : " +title);
		driver.quit();
		
	}

}
