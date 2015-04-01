//Author Akash
package testscripts.display;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import testscripts.Constants;

public class NGEnableLikesTest {
	
	@Test(groups = { "Display" })
	public static void checkNGEnabledLikesTest() throws Exception
	{

		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);

		PhantomJSDriver wd;
		wd = new PhantomJSDriver(caps);
		wd.manage().window().setSize(new Dimension(1920, 1080));

		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Login to wordpress by admin account
		wd.get(Constants.WP_SERVER);
		Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
		 System.out.println("Correctly Logged In");
		 
		 Constants.openrtMediaSettings(wd);

		wd.findElement(By.id("tab-rtmedia-display")).click();
		System.out.println("display clicked");
		
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Likes/NG/NGEnableLikesTest0.png');");	
		 
		Thread.sleep(2000);
		List<WebElement> views = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-1\"] > div.rt-switch.has-switch > div.switch-animate.switch-on"));
		int i=views.size();
		System.out.println("Views size:" + i);
		if (i==1){

			views.get(0).findElement(By.cssSelector("span.switch-left")).click();
			Thread.sleep(1000);
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Likes/NG/NGLikesTest1.png');");	

			wd.findElement(By.id("rtmedia-settings-submit")).click();
		}
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
						Thread.sleep(5000);
						

						((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Likes/NG/NGLikes btn media Test2.png');");
						//clicked on single media...
						
					    Thread.sleep(3000);
						wd.findElement(By.cssSelector("#bulk-edit-form > ul.rtmedia-list.rtmedia-list-media.context-id-1.rtm-pro-allow-action > li.rtmedia-list-item > a.rtmedia-list-item-a")).click();

						
						System.out.println("clicked on single media");
						((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Likes/NG/NGLikes btn media Test2.png');");

	        
			if(wd.findElements(By.cssSelector("button.rtmedia-like.rtmedia-action-buttons.button")).size()!=0)
			{
			
				 System.out.println("Like Button is  Present");
				// wd.findElement(By.className("rtmedia-like rtmedia-action-buttons button")).click();
				//System.out.println("clicked on like button");
				 Thread.sleep(1000);
				 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Likes/NG/NGlike Button is not present test3.png');");		
			
			}
			else
				System.out.println("Like button is not present");
			 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Likes/NG/NGlike Button is present test4.png');");		

			
			

			
			
			Constants.logout(wd);
			Capabilities caps2 = new DesiredCapabilities();
			((DesiredCapabilities) caps2).setJavascriptEnabled(true);
			((DesiredCapabilities) caps2).setCapability("takesScreenshot", true);

			PhantomJSDriver wd1 = new PhantomJSDriver(caps2);
			wd1.manage().window().setSize(new Dimension(1920, 1080));
			wd1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


			// Login to WordPress with other user roles :: Author , Editor , Contributor , Subscriber
			// Login to wordpress by as a TestEditor
					wd.get(Constants.WP_SERVER);
					Constants.login(wd, Constants.TestEditor, Constants.TestEditorPassword);
					 System.out.println("Correctly Logged In From another user");

					 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Likes/NG/NGanother user Test5.png');");		
						// Navigate to Media gallery
						
						//  Mouseover  on Profile (Howdy,other) section , click on Media 

										new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
										Thread.sleep(1000);
										new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).click();
										wd.findElement(By.linkText("Media")).click();
										
										System.out.println("Reached Media Gallery ");			
										Thread.sleep(5000);
										

										((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Likes/NG/NGLikes btn media other user Test6.png');");
										//clicked on single media...
										
										Thread.sleep(3000);
										wd.findElement(By.cssSelector("#bulk-edit-form > ul.rtmedia-list.rtmedia-list-media.context-id-3.rtm-pro-allow-action > li.rtmedia-list-item > a.rtmedia-list-item-a")).click();

										
										System.out.println("clicked on single media");
					        
						 if(wd.findElements(By.cssSelector("button.rtmedia-like.rtmedia-action-buttons.button")).size()!=0){
							 System.out.println("Like Button  is Present");
							 }
						 else
							 {
							 System.out.println("Like Button is not Present");
							 }
						   
						Constants.logout(wd);

	}
}

