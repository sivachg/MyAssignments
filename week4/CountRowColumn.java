package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CountRowColumn {

	public static void main(String[] args) {
		//Chrome driver setup
		WebDriverManager.chromedriver().setup();
		//create object for chrome driver
		ChromeDriver driver = new ChromeDriver();
		//maximize window
		driver.manage().window().maximize();
		//get web page url
		driver.get("https://html.com/tags/table/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Details of Table 1
		WebElement table1 = driver.findElement(By.xpath("//div[@class='render']/table"));
		List<WebElement> rowCount1 = table1.findElements(By.tagName("tr"));
		List<WebElement> columnCount1 = table1.findElements(By.tagName("th"));
		System.out.println("Row count of Table1 :" + rowCount1.size());
		System.out.println("Column count of Table1 :" + columnCount1.size());
		//Details of Table2
		WebElement table2 = driver.findElement(By.xpath("//table[@class='attributes-list']"));
		List<WebElement> rowCount2 = table2.findElements(By.tagName("tr"));
		List<WebElement> columnCount2 = table2.findElements(By.tagName("th"));
		System.out.println("Row count of Table2 :" + rowCount2.size());
		System.out.println("Column count of Table2 :" + columnCount2.size());
		//Print the values present in Library of Table 1
		for (int i = 1; i <= rowCount1.size(); i++) {
			for (int j = 1; j <= columnCount1.size(); j++) {
			
		String text = driver.findElement(By.xpath("(//div[@class='render']/table)//tr["+i+"]/td["+j+"]")).getText();
		System.out.println(text);
		
			}
		}	
		//String text1 = driver.findElement(By.xpath("//div[@class='render']/table//tfoot")).getText();
		//System.out.println(text1);
	}	

}
