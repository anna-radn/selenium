package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FixChromeIssue {

	public static void main(String[] args) {
		
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");//current issues with Chrome browser from 111
		WebDriver driver=new ChromeDriver(co);
		driver.get("https://www.yahoo.com/");
		System.out.println(driver.getTitle());
		
	}
	
}
