package week2.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccountX {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/logout");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demoSalesManager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("//div[@id='label']")).click();
		driver.findElement(By.xpath("//a[text()='Accounts']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Create Account']")).click();
		driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys("Debit Limited Account_SivaMadurai");
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Selenium Automation Tester");
		driver.findElement(By.xpath("//input[@id='groupNameLocal']")).sendKeys("Test Leaf");
		driver.findElement(By.xpath("//input[@id='officeSiteName']")).sendKeys("Nungambakkam Chennai");
		driver.findElement(By.xpath("(//input[@class='inputBox'])[5]")).sendKeys("20Lacs");
		WebElement drop = driver.findElement(By.xpath("//select[@name='industryEnumId']"));
		Select acc = new Select(drop);
		acc.selectByIndex(3);
		WebElement drop1 = driver.findElement(By.xpath("//select[@name='ownershipEnumId']"));
		Select acc1 = new Select(drop1);
		acc1.selectByVisibleText("S-Corporation");
		WebElement drop2 = driver.findElement(By.xpath("//select[@id='dataSourceId']"));
		Select acc2 = new Select(drop2);
		acc2.selectByValue("LEAD_EMPLOYEE");
		WebElement drop3 = driver.findElement(By.xpath("//select[@id='marketingCampaignId']"));
		Select acc3 = new Select(drop3);
		acc3.selectByIndex(6);
		WebElement drop4 = driver.findElement(By.xpath("//select[@id='generalStateProvinceGeoId']"));
		Select acc4 = new Select(drop4);
		acc4.selectByValue("TX");
		driver.findElement(By.xpath("//input[@value='Create Account']")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("(//span[@class='tabletext'])[3]")).getText();
		System.out.println("Account Name : " +text);
		
	}

}
