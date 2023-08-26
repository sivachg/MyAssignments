package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PvrCinemas {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.pvrcinemas.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//p-autocomplete[@id='locationsearch']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Chennai']")).click();
		driver.findElement(By.xpath("(//i[@class='icon-bar icon'])[2]")).click();
		driver.findElement(By.xpath("//a[text()='Movie Library']")).click();
		Thread.sleep(2000);
		WebElement genres = driver.findElement(By.xpath("//select[@name='genre']"));
		Select genre = new Select(genres);
		genre.selectByVisibleText("ANIMATION");
		WebElement languages = driver.findElement(By.xpath("//select[@name='lang']"));
		Select language = new Select(languages);
		language.selectByVisibleText("ENGLISH");
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//div[@class='movie-list']/div[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Proceed To Book']")).click();
		Thread.sleep(3000);
		WebElement cinemas = driver.findElement(By.xpath("//select[@id='cinemaName']"));
		Select cinema = new Select(cinemas);
		cinema.selectByIndex(5);
		//driver.findElement(By.xpath("//div[@class='datepicker-container datepicker-default']")).click();
		WebElement timings = driver.findElement(By.xpath("//select[@name='timings']"));
		Select time = new Select(timings);
		time.selectByIndex(4);
		driver.findElement(By.xpath("//input[@name='noOfTickets']")).sendKeys("10");
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("SivaG");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("leaftaps@gmail.com");
		driver.findElement(By.name("mobile")).sendKeys("8838959367");
		Thread.sleep(5000);
		WebElement foods = driver.findElement(By.xpath("//select[@name='food']"));
		Select food = new Select(foods);
		food.selectByIndex(1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='comment']")).sendKeys("Nothing");
		driver.findElement(By.xpath("//span[text()='Copy To Self']")).click();
		driver.findElement(By.xpath("//button[text()='SEND REQUEST']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[text()='CANCEL'])[2]")).click();
		driver.findElement(By.xpath("//button[@class='swal2-close']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		
		
		
		

	}

}
