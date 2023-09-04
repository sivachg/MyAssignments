package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapdealAction {

	public static void main(String[] args) throws InterruptedException, IOException {
		//Chrome driver setup
		WebDriverManager.chromedriver().setup();
		//create object for chrome driver
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		//maximize window
		driver.manage().window().maximize();
		//get web page url
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement mensFashion = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(mensFashion).perform();
		driver.findElement(By.xpath("(//span[text()=\"Sports Shoes\"])[1]")).click();
		System.out.println("Count of Sports Shoes : " + driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText());
		driver.findElement(By.xpath("(//li[@class='child-cat-list cat-list '])[3]")).click();
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@class='search-li'][1]")).click();
		WebElement fromPrice = driver.findElement(By.xpath("//input[@name='fromVal']"));
		fromPrice.clear();
		fromPrice.sendKeys("500");
		act.sendKeys(Keys.TAB);
		WebElement toPrice = driver.findElement(By.xpath("//input[@name='toVal']"));
		toPrice.clear();
		toPrice.sendKeys("1200");
		driver.findElement(By.xpath("(//div[@class='filter-inner']/div)[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='sdCheckbox filters-list '])[2]/label")).click();
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.xpath("//div[@class='product-tuple-image ']"))).perform();
		driver.findElement(By.xpath("(//div[@class='product-tuple-image '])[1]/div/div")).click();
		System.out.println("Price : " + driver.findElement(By.xpath("//div[@class='lfloat']/div[2]/span[1]")).getText());
		System.out.println("Discount % : " + driver.findElement(By.xpath("//div[@class='lfloat']/div[2]/span[2]")).getText());
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snapshot/trainShoe.jpeg");
		FileUtils.copyFile(source, target);
		
	}

}
