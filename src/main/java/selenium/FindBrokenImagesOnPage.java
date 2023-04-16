package selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindBrokenImagesOnPage {

	static WebDriver driver;
	static String browser;
	static String url="https://www.yahoo.com/";
	
	public static void main(String[] args) throws IOException {
		
		driver=WebDriverManager.edgedriver().create();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().getPageLoadTimeout();
		driver.manage().timeouts().getImplicitWaitTimeout();
		
		List<WebElement> images=driver.findElements(By.tagName("img"));
		System.out.println(images.size());
		
		for(WebElement image:images) {
			String src=image.getAttribute("src");
			
			URL url=new URL(src);
			URLConnection urlConnection=url.openConnection();
			HttpURLConnection httpUrlConnection=(HttpURLConnection) urlConnection;
			httpUrlConnection.setConnectTimeout(5000);
			httpUrlConnection.connect();
			
			if(httpUrlConnection.getResponseCode()==200) {
				System.out.println(httpUrlConnection.getResponseCode()+" "+httpUrlConnection.getResponseMessage());
			}else 
					System.err.println(httpUrlConnection.getResponseCode()+" "+httpUrlConnection.getResponseMessage());
				httpUrlConnection.disconnect();	
		}
		driver.quit();
		
	}
}
