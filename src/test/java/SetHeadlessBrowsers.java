

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class SetHeadlessBrowsers {

	public void setBrowsers() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		
		//HtmlUnitDriver is fastest from all apis
		final WebClient wb=new WebClient();
		final HtmlPage page=wb.getPage("https://www.yahoo.com/");
		System.out.println(page.getTitleText());
		System.out.println(page.asXml());
		
		WebDriver driver=new HtmlUnitDriver();
		driver.get("https://www.yahoo.com/");
		System.out.println(driver.getTitle());
		
		//may also use
		WebDriver driver1=new HtmlUnitDriver(BrowserVersion.CHROME);
		//WebDriver driver1=new HtmlUnitDriver(BrowserVersion.FIREFOX);
		//WebDriver driver1=new HtmlUnitDriver(BrowserVersion.EDGE);
		//WebDriver driver1=new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER);
		driver1.get("https://www.yahoo.com/");
		
		//use ChromeOptions
		ChromeOptions co=new ChromeOptions();
		co.addArguments("window-size-1400, 800");//need to set window size
		co.addArguments("headless");
		//then use Webdriver driver=new ChromeDriver(co); and pass ChromeOptions object
		
		FirefoxOptions fo=new FirefoxOptions();
		fo.addArguments("--headless");
		//then use WebDriver driver=new FirefoxDriver(fo); and pass FirefoxOptions object
		
		EdgeOptions eo=new EdgeOptions();
		eo.addArguments("--headless");
		//then use WebDriver driver=new EdgeDriver(eo); and pass EdgeOptions object
	}
	
}
