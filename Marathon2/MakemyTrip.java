package marathon08sept;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakemyTrip {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		driver.switchTo().frame(3);
		driver.findElement(By.xpath("//i[@class='wewidgeticon we_close']")).click();
		System.out.println("Sweet Alert Closed");
		Thread.sleep(1000);
		//select logo
		WebElement logo = driver.findElement(By.xpath("//a[@class='mmtLogo makeFlex']/picture"));
		driver.executeScript("arguments[0].click();",logo);
		Thread.sleep(3000);
		//click holiday packages
		driver.findElement(By.xpath("(//span[@class='chNavText darkGreyText'])[4]")).click();
		Thread.sleep(3000);
		//choose from city
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		WebElement fromCity = driver.findElement(By.xpath("//input[@class='citypicker_input']"));
		fromCity.clear();
		fromCity.sendKeys("Chennai");
		driver.findElement(By.xpath("(//p[@class='makeFlex hrtlCenter'])[3]")).click();
		//choose to city
		driver.findElement(By.xpath("//label[@for='toCity']")).click();
		driver.findElement(By.xpath("//input[@class='dest-search-input']")).sendKeys("Goa");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='dest-city-container'])[1]")).click();
		Thread.sleep(2000);
		//select date
		driver.findElement(By.xpath("(//div[@class='DayPicker-Day'])[21]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='pointer plus-sign-wrapper'])[1]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='APPLY']")).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[@class='field-label blue-font up-arrow']")).click();
		
		WebElement slide1 = driver.findElement(By.xpath("//div[@class='rc-slider-handle rc-slider-handle-1']"));
        Point location1 = slide1.getLocation();
        System.out.println(location1);
        
        Actions builder =new Actions(driver);
        builder.dragAndDropBy(slide1, 50, 0).perform();
		
        WebElement slide2 = driver.findElement(By.xpath("//div[@class='rc-slider-handle rc-slider-handle-2']"));
        Point location2 = slide2.getLocation();
        System.out.println(location2);
        builder.dragAndDropBy(slide2, -200, 0).perform();
		
        driver.findElement(By.xpath("//button[@class='action']")).click();
        driver.findElement(By.xpath("//button[@id='search_button']")).click();
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//button[@class='skipBtn']")).click();
        Thread.sleep(3000);
        //driver.findElement(By.xpath("//span[@class='close closeIcon']")).click();
        //Thread.sleep(3000);
        
        WebElement snap = driver.findElement(By.xpath("(//div[@class='slideItem relative'])[1]"));
        js.executeScript("window.scrollBy(0,300)", "");
        //WebElement shot = driver.findElement(By.xpath("(//div[@class='sliderCard'])[1]"));
        File source = snap.getScreenshotAs(OutputType.FILE);
		File target = new File("./snapshot/HolidayPackage4.png");
		FileUtils.copyFile(source, target);
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
