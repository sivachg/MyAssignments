package marathon08sept;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TataCliq {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(opt);
		driver.get("https://www.tatacliq.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement brand = driver.findElement(By.xpath("//div[@class='DesktopHeader__categoryAndBrand'][2]"));
		Actions act = new Actions(driver);
		act.moveToElement(brand).perform();
		
		driver.findElement(By.xpath("//div[text()='Watches & Accessories']")).click();
		driver.findElement(By.xpath("(//div[@class='DesktopHeader__brandsDetails'])[1]")).click();
		
		WebElement sortBy = driver.findElement(By.xpath("//select[@class='SelectBoxDesktop__hideSelect']"));
		Select sort = new Select(sortBy);
		sort.selectByVisibleText("New Arrivals");
		
		driver.findElement(By.xpath("(//div[@class='FilterDesktop__newFilName'])[1]")).click();
		List<WebElement> sizePrice = driver.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']"));
		List<String> allPrice = new ArrayList<String>();
		for (int i = 0; i < sizePrice.size(); i++) {
		String text = sizePrice.get(i).getText();
		allPrice.add(text);
		}
		System.out.println(allPrice);
		
		String secondPrice = driver.findElement(By.xpath("(//div[@class='ProductDescription__priceHolder'])[2]")).getText();
		System.out.println("Price of second listed watch : " + secondPrice);
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//div[@class='ProductModule__base'])[2]")).click();
		
		Set<String> winHandle = driver.getWindowHandles();
		List<String> handleWindow = new ArrayList<String>(winHandle);
		driver.switchTo().window(handleWindow.get(2));
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		String confirmPrice = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']/h3")).getText();
		System.out.println("Product price from second window : " + confirmPrice);
		if(confirmPrice.contains(secondPrice)) {
			System.out.println("Both prices are equal");
		}
		
		driver.findElement(By.xpath("(//div[@class='Button__base'])[3]")).click();
		String bagCount = driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).getText();
		System.out.println("No. of items available in the cart bag : " + bagCount);
		
		driver.findElement(By.xpath("//div[@class='DesktopHeader__myBagShow']")).click();
		Thread.sleep(2000);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snapshot/Cliq-Watch1.png");
		FileUtils.copyFile(source, target);
		driver.close();
		Thread.sleep(5000);
		driver.switchTo().window(handleWindow.get(1));
		driver.close();
		Thread.sleep(5000);
		driver.switchTo().window(handleWindow.get(0));
		driver.close();
	}

}
