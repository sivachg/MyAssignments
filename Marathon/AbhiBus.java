package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbhiBus {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.abhibus.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[@id='pills-home-tab']")).click();
		driver.findElement(By.xpath("//input[@id='source']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//li[text()='Chennai']")).click();
		driver.findElement(By.xpath("//input[@id='destination']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//li[text()='Bangalore']")).click();
		driver.findElement(By.id("datepicker1")).click();
		driver.findElement(By.xpath("(//a[text()='26'])[1]")).click();
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		String f1 = driver.findElement(By.xpath("(//h2[@class='TravelAgntNm ng-binding'])[1]")).getText();
		System.out.println("Bus Name : " +f1);
		driver.findElement(By.id("Bustypes4")).click();
		String f2 = driver.findElement(By.xpath("(//p[@class='noseats AvailSts ng-binding'])[1]")).getText();
		System.out.println("Bus Seat Count Available : " +f2);
		driver.findElement(By.xpath("(//span[text()='Select Seat'])[1]")).click();
		driver.findElement(By.id("UO4-7ZZ")).click();
		String f3 = driver.findElement(By.id("seatnos")).getText();
		System.out.println("Seat Selected : " +f3);
		String f4 = driver.findElement(By.id("ticketfare")).getText();
		System.out.println("Total Fare : " +f4);
		WebElement boarding = driver.findElement(By.name("boardingpoint_id"));
		Select board = new Select(boarding);
		board.selectByVisibleText("Koyambedu-23:11");
		WebElement dropping = driver.findElement(By.name("droppingpoint_id"));
		Select drop = new Select(dropping);
		drop.selectByVisibleText("Madiwala-05:56");
		String title = driver.getTitle();
		System.out.println(title);
		driver.quit();
	}

}
