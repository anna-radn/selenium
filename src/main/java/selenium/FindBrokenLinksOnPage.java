package selenium;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindBrokenLinksOnPage {

	static WebDriver driver;
	static String browser;
	static String url="https://www.yahoo.com/";
	
	public static void main(String[] args) {
		
		driver=WebDriverManager.edgedriver().create();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().getPageLoadTimeout();
		driver.manage().timeouts().getImplicitWaitTimeout();
		
		List<WebElement> links=driver.findElements(By.tagName("a"));//find all links
		System.out.println("total number of links is: "+links.size());
		
//create list of WebElements to store them as working links, then iterate through all links
//and add only working links to another list
		List<WebElement> workingLinks=new ArrayList<WebElement>();
		
		for(int i=0;i<links.size();i++) {
			if(links.get(i).getAttribute("href")!=null) {
				workingLinks.add(links.get(i));
			}
		}
		System.out.println("total number of working links is: "+workingLinks.size());
		driver.quit();
		
	}
	
}
