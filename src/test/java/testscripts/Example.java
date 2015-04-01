package testscripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Example {
	@Test
	public static void exampleTest() throws Exception {

		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
		
		PhantomJSDriver wd = new PhantomJSDriver(caps);
		wd.manage().window().setSize(new Dimension(1920, 1080));
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	

		//Login to wordpress by admin account
		wd.get(Constants.WP_SERVER);
		Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
		System.out.println("Correctly Logged In");


			new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a"))).build().perform();
			
			Thread.sleep(1000);
			
			wd.findElement(By.cssSelector("#wp-admin-bar-my-account-activity > a")).click();
			Thread.sleep(2000);
			
			
			/*int i = wd.findElements(By.cssSelector("#item-body > div.activity")).size();
			
			System.out.println(i);
			*/
			
		if(wd.findElement(By.cssSelector("#activity-stream > li.load-more > a")).isDisplayed())
		{
			do{
			Thread.sleep(2000);
			wd.findElement(By.cssSelector("#activity-stream > li.load-more > a")).click();
			Thread.sleep(2000);
			}while(!wd.findElement(By.cssSelector("#activity-stream > li.load-more > a")).isDisplayed());{
				
			}
		}
		
			List<WebElement> count=wd.findElements(By.cssSelector("div.rtmedia-item-thumbnail"));
			int j=count.size();
			System.out.println("media are"+j);
			
			//int j=wd.findElement(By.cssSelector("div.rtmedia-item-thumbnail")).
			
			
			
			
			
			
			
			
			
			/*wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a")).click();
			Thread.sleep(2000);
			int a = wd.findElements(By.cssSelector("#bulk-edit-form > ul.rtmedia-list.rtmedia-list-media.context-id-1.rtm-pro-allow-act"
				+ "ion > li.rtmedia-list-item > a.rtmedia-list-item-a")).size();
			
			System.out.println(a);
			wd.findElement(By.id("rtMedia-galary-next")).click();
			System.out.println("Clicked Load More Button");
			Thread.sleep(2000);
		
			
			
          WebElement ele= wd.findElements(By.cssSelector("#bulk-edit-form > ul.rtmedia-list.rtmedia-list-media.context-id-1.rtm-pro-allow-act"
				+ "ion > li.rtmedia-list-item > a.rtmedia-list-item-a")).get(2);
           ele.click();
            Thread.sleep(2000);
            
           
            
            
     */       
            /*
            List<WebElement> drop = wd.findElements(By.cssSelector("li.rtmedia-list-item.masonry-brick"));
            
            java.util.Iterator<WebElement> i = drop.iterator();
            while(i.hasNext())
            {
            	WebElement row = i.next();
            	Thread.sleep(3000);
            	
            	row.findElement(By.cssSelector("li.rtmedia-list-item.masonry-brick")).click();
            		System.out.println("clicked on second media");
            } 
            Thread.sleep(3000);
*/
            ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/FavList 01 .png');");

            Constants.logout(wd);

	}
}