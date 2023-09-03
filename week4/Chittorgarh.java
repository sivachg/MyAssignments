package week4.day2;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {

	public static void main(String[] args) {
				//Chrome driver setup
				WebDriverManager.chromedriver().setup();
				//create object for chrome driver
				ChromeDriver driver = new ChromeDriver();
				//maximize window
				driver.manage().window().maximize();
				//get web page url
				driver.get("https://www.chittorgarh.com/");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.findElement(By.id("navbtn_stockmarket")).click();
				driver.findElement(By.linkText("NSE Bulk Deals")).click();
				WebElement table = driver.findElement(By.xpath("(//div[@class='table-responsive']/table)[1]"));
				List<WebElement> row = table.findElements(By.tagName("tr"));
				List<WebElement> column = table.findElements(By.tagName("th"));
				System.out.println("Row Size : " + row.size());
				System.out.println("Column Size : " + column.size());
				Set<String> securities = new TreeSet<String>();
				for (int i = 1; i < row.size(); i++) {
					String text = driver.findElement(By.xpath("(//div[@class='table-responsive']/table)[1]/tbody/tr["+i+"]/td[1]")).getText();
					securities.add(text);
					
				}
				for (String stocks : securities) {
					System.out.println(stocks);
				}
	}

}
