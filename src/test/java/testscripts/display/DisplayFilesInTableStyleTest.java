//Author akash
package testscripts.display;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.Wait;

import testscripts.Constants;

public class DisplayFilesInTableStyleTest
{
	
	@Test(groups = { "Display" })
	public static void checkDisplayFilesInTableStyleTest() throws Exception 
	{
		
		
		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);

		PhantomJSDriver wd;
		wd = new PhantomJSDriver(caps);
		wd.manage().window().setSize(new Dimension(1920, 1080));

		//wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Login to wordpress by admin account
		wd.get(Constants.WP_SERVER);
		Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
		 System.out.println("Correctly Logged In");
		 
		 Constants.openrtMediaSettings(wd);

		wd.findElement(By.id("tab-rtmedia-display")).click();
		System.out.println("display clicked");
		
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Tabular/Functional/displayfilesintableTest1.png');");	
		 
		Thread.sleep(1000);

		List<WebElement> table = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-8\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));
		System.out.println("Views size:" + table.size());
		if (table.size() != 0){

			table.get(0).findElement(By.cssSelector("span.switch-right")).click();
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Tabular/Functional/displayfilesintablestyleTest2.png');");	

				
		}
		List<WebElement> table1 = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-9\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));
		//System.out.println("Views size:" + table1.size());
		if (table1.size() != 0){

			table1.get(0).findElement(By.cssSelector("span.switch-right")).click();
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Tabular/Functional/displayGoogledocsTest2.png');");	

				
		}
		
		
		
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		
		System.out.println("rtMedia Settings Saved");
		
	
		//Do a mouse over on the primary menu on top LHS
				new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
		Thread.sleep(1000);

				// Click on Visit Site

				wd.findElement(By.linkText("Visit Site")).click();
				
				
				// Navigate to Media gallery
				
			//  Mouseover  on Profile (Howdy, admin) section , click on Media 

							new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
							Thread.sleep(1000);
							new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).click();
							wd.findElement(By.linkText("Media")).click();
							
							System.out.println("Reached Media Gallery ");			
							Thread.sleep(1500);
							

		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Tabular/Functional/displayfilesintablestyleTest3.png');");	

	    wd.findElement(By.id("rtmedia-nav-item-document")).click();
	    System.out.println("document clicked"); 
	    if(wd.findElement(By.cssSelector("table.rtmedia-list.rtmedia-list-media.rtmedia-list-document.context-id-1.rtm-pro-allow-action > tbody > tr.rtmedia-list-document-row")).isDisplayed())
	    {
	    String tabledata=wd.findElement(By.cssSelector("table.rtmedia-list.rtmedia-list-media.rtmedia-list-document.context-id-1.rtm-pro-allow-action > tbody > tr.rtmedia-list-document-row")).getText();
	    System.out.println("Table is:");
	    
	    String tabledatahead=wd.findElement(By.cssSelector("table.rtmedia-list.rtmedia-list-media.rtmedia-list-document.context-id-1.rtm-pro-allow-action > thead > tr.rtmedia-list-document-row")).getText();
	    System.out.println(tabledatahead);
	    System.out.println(tabledata);

	    
	    System.out.println("Verify the tabular format");
	    }
	    else
	    {
	    	
	    	System.out.println("table not found");
	    }
	    

	    
	    
		Constants.logout(wd);
		//log in from another user
		
		Capabilities caps2 = new DesiredCapabilities();
		((DesiredCapabilities) caps2).setJavascriptEnabled(true);
		((DesiredCapabilities) caps2).setCapability("takesScreenshot", true);

		PhantomJSDriver wd1 = new PhantomJSDriver(caps2);
		wd1.manage().window().setSize(new Dimension(1920, 1080));
		//wd1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


		// Login to WordPress with other user roles :: Author , Editor , Contributor , Subscriber
		// Login to wordpress by as a TestEditor
				wd.get(Constants.WP_SERVER);
				Constants.login(wd, Constants.TestEditor, Constants.TestEditorPassword);
				 System.out.println("Correctly Logged In from other user");

				//  Mouseover  on Profile (Howdy,) section , click on Media 

					new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
			//		Thread.sleep(1000);
					new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).click();
					wd.findElement(By.linkText("Media")).click();
					
					System.out.println("Reached Media Gallery ");			
				Thread.sleep(1500);
					

					((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Tabular/Functional/DisplaytableTest4.png');");
					//clicked on single media...
					 wd.findElement(By.id("rtmedia-nav-item-document")).click();
					    System.out.println("document clicked");
					    
					    
					    if(wd.findElement(By.cssSelector("table.rtmedia-list.rtmedia-list-media.rtmedia-list-document.context-id-3.rtm-pro-allow-action > thead > tr.rtmedia-list-document-row")).isDisplayed())
					    {
					    String tabledatahead=wd.findElement(By.cssSelector("table.rtmedia-list.rtmedia-list-media.rtmedia-list-document.context-id-3.rtm-pro-allow-action > thead > tr.rtmedia-list-document-row")).getText();
					    String tabledata=wd.findElement(By.cssSelector("table.rtmedia-list.rtmedia-list-media.rtmedia-list-document.context-id-3.rtm-pro-allow-action > tbody > tr.rtmedia-list-document-row")).getText();
					    System.out.println("Table is:");
					    System.out.println(tabledatahead);
					    System.out.println(tabledata);

					    
					    System.out.println("got the tabular format");
					    }
					    else
					    {
					    	
					    	System.out.println("table not found");
					    }
						((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Tabular/Functional/DiaplaytableTest5.png');");

	    
	    
	    
	    
		Constants.logout(wd);

}
		


	

}
