package marathon08sept;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Servicenow {

	public static void main(String[] args) throws IOException, InterruptedException {
		//Driver setup
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://dev124621.service-now.com");		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//user login
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Ak^x88vhDMV=");
		driver.findElement(By.id("sysverb_login")).click();
			
		Shadow root = new Shadow(driver);
		//click All and service catalog
		root.setImplicitWait(10);
		root.findElementByXPath("//div[text()='All']").click();
		root.findElementByXPath("//span[text()='Service Catalog']").click();
		WebElement iframe = root.findElementByXPath("//iframe[@id='gsft_main']");
		
		driver.switchTo().frame(iframe);
		driver.findElement(By.linkText("Mobiles")).click();
		driver.findElement(By.linkText("Apple iPhone 13 pro")).click();
		//radio button lost or broken
		driver.findElement(By.xpath("(//label[@class='radio-label'])[1]")).click();
		driver.findElement(By.id("IO:4afecf4e9747011021983d1e6253af34")).sendKeys("8838959367");
		//Drop down for monthly data allowance
		WebElement Mdata = driver.findElement(By.id("IO:ff1f478e9747011021983d1e6253af68"));
		Select data = new Select(Mdata);
		data.selectByIndex(2);
		//choose color and storage
		driver.findElement(By.xpath("(//label[@class='radio-label'])[7]")).click();
		driver.findElement(By.xpath("(//label[@class='radio-label'])[10]")).click();
		//click order now button
		driver.findElement(By.id("oi_order_now_button")).click();
		Thread.sleep(3000);
		String success = driver.findElement(By.xpath("//div[@class='notification notification-success']")).getText();
		System.out.println("Verified :" +success);
		String order = driver.findElement(By.id("requesturl")).getText();
		System.out.println("Order placed with request number : " + order);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snapshot/iphone.png");
		FileUtils.copyFile(source, target);
	}
}
