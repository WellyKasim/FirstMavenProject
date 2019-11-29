package FirstPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        
        driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS); //this will fail the test, 
        // because of too short time amount.
// driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);  //this will be ok.
driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
// below code is to get a web page loading status, to know if a page is fully loaded or not.
JavascriptExecutor js = (JavascriptExecutor)driver;
String pageLoadStatus = js.executeScript("return document.readyState").toString();
//normally it will return 3 different status: loading, interactive, complete
System.out.println("Page load status is "+pageLoadStatus);

driver.findElement(By.name("q")).sendKeys("book"+Keys.ENTER);

try {
Thread.sleep(3000);
} catch (InterruptedException e) {
e.printStackTrace();
}
driver.close();
}
}
