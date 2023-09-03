package week4.day2;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailWebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://erail.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
		fromStation.clear();
		fromStation.sendKeys("MS");
		fromStation.sendKeys(Keys.ENTER);
		WebElement toStation = driver.findElement(By.id("txtStationTo"));
		toStation.clear();
		toStation.sendKeys("BNC");
		toStation.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//table[@id='tableTopMenu']//tr[1]/td[6]")).click();
		driver.findElement(By.id("buttonFromTo")).click();
		WebElement table = driver.findElement(By.xpath("//div[@id='divTrainsList']/table[1]"));
		List<WebElement> rowCount = table.findElements(By.tagName("tr"));
		List<WebElement> columnCount = table.findElements(By.tagName("th"));
		System.out.println("Row Count : " +rowCount.size());
		System.out.println("Column Count : " +columnCount.size());
		System.out.println("List of Available Trains");
		for (int i = 2; i <= rowCount.size(); i++) {
			String text = driver.findElement(By.xpath("(//div[@id='divTrainsList']/table)[1]//tr["+i+"]/td[2]")).getText();
			System.out.println(text);
			
		}
		
	}

}
