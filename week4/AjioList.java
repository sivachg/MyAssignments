package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AjioList {

	public static void main(String[] args) throws InterruptedException {
		//Chrome driver setup
		WebDriverManager.chromedriver().setup();
		//create object for chrome driver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		//maximize window
		driver.manage().window().maximize();
		//get web page url
		driver.get("https://www.ajio.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement searchBar = driver.findElement(By.xpath("//div[@class='searchbar-view']//input"));
		searchBar.sendKeys("bags");
		searchBar.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[@class='facet-linkhead'])[3]//label")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//div[@class='facet-linkhead'])[6]//label")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//div[@class='length']")).getText());
		List<WebElement> brand = driver.findElements(By.xpath("//div[@class='brand']"));
		System.out.println(brand.size());
		List<String> brandList = new ArrayList<String>();
		for (int i = 1; i <= brand.size(); i++) {
			String text = driver.findElement(By.xpath("//div[@class='brand']")).getText();
			brandList.add(text);
		}
		System.out.println("Brands available in the page : " +brandList);
		List<WebElement> name = driver.findElements(By.xpath("//div[@class='nameCls']"));
		List<String> nameList = new ArrayList<String>();
		for (int i = 1; i <= name.size(); i++) {
			String text = driver.findElement(By.xpath("//div[@class='nameCls']")).getText();
			nameList.add(text);
		}
		System.out.println("Name of bags : " +nameList);
	}

}
