package week2.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Rahul");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Singh");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("8838959367");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("SinRa@567");
		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		Select d = new Select(day);
		d.selectByValue("11");
		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		Select m = new Select(month);
		m.selectByIndex(2);
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		Select y = new Select(year);
		y.selectByValue("2000");
		driver.findElement(By.xpath("//input[@class='_8esa']")).click();		

	}

}
