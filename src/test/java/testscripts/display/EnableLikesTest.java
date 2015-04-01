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

public class EnableLikesTest {
	@Test(groups = { "Display" })
	public static void checkEnablLikesTest() throws Exception
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
		
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Likes/Functional/EnableLikesTest0.png');");	
		 
		//Thread.sleep(2000);
		
		
		List<WebElement> likes = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-1\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));
		
		if (likes.size() != 0){

			likes.get(0).findElement(By.cssSelector("span.switch-right")).click();
			Thread.sleep(1000);
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Likes/Functional/EnableLikesTest1.png');");	

				
		}
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		
		System.out.println("rtMedia Settings Saved");
		
		//Do a mouse over on the primary menu on top LHS
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
///Thread.sleep(1000);

		// Click on Visit Site

		wd.findElement(By.linkText("Visit Site")).click();
		
		
		// Navigate to Media gallery
		
	//  Mouseover  on Profile (Howdy, admin) section , click on Media 

					new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
					Thread.sleep(1000);
					new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).click();
					wd.findElement(By.linkText("Media")).click();
					
					System.out.println("Reached Media Gallery ");			
	//				Thread.sleep(5000);
					

					((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Likes/Functiional/Likes btn media Test2.png');");
					//clicked on single media...
					
		//			Thread.sleep(3000);
					
					//wd.findElement(By.id("rtmedia-nav-item-photo")).click();
		
		wd.findElement(By.cssSelector("#bulk-edit-form > ul.rtmedia-list.rtmedia-list-media.context-id-1.rtm-pro-allow-action > li.rtmedia-list-item > a.rtmedia-list-item-a")).click();
		

		 System.out.println("clicked on Media");
			
		 //Thread.sleep(5000);
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Likes/Functional/click media for Like.png');");

		if(!wd.findElement(By.cssSelector("button.rtmedia-like.rtmedia-action-buttons.button")).isDisplayed()){
		
			 System.out.println("Like Button is not Present");
			// wd.findElement(By.className("rtmedia-like rtmedia-action-buttons button")).click();
			//System.out.println("clicked on like button");
			// Thread.sleep(1000);
			 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Likes/Functional/like Button is not present test3.png');");		
		
		}
		else
			wd.findElement(By.cssSelector("button.rtmedia-like.rtmedia-action-buttons.button")).click();
			System.out.println("Like button is present ");
			System.out.println("clicked on Like Button ");
		 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Likes/Functional/like Button is present test4.png');");		

		
		
		Constants.logout(wd);
		
		
		//log in with another user.
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
				 System.out.println("Correctly Logged In from another user");
				 
				 
				 
					
					//  Mouseover  on Profile (Howdy, admin) section , click on Media 

									new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
			//						Thread.sleep(1000);
									new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).click();
									wd.findElement(By.linkText("Media")).click();
									
									System.out.println("Reached Media Gallery ");			
									Thread.sleep(1500);
									
				 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Likes/Functional/another user like test5.png');");		
					Thread.sleep(3000);

				 //Click to first Media
				wd.findElement(By.cssSelector("#bulk-edit-form > ul.rtmedia-list.rtmedia-list-media.context-id-3.rtm-pro-allow-action > li.rtmedia-list-item > a.rtmedia-list-item-a")).click();
				 
				  System.out.println("clicked on Media");
					
				 //Thread.sleep(3000);
				 if(!wd.findElement(By.cssSelector("button.rtmedia-like.rtmedia-action-buttons.button")).isDisplayed()){
						
					 System.out.println("Like Button is not Present");
					// wd.findElement(By.className("rtmedia-like rtmedia-action-buttons button")).click();
					//System.out.println("clicked on like button");
					 Thread.sleep(1000);
					 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Likes/Functional/another user like Button present not present  test6.png');");		
				
				}
				else
					wd.findElement(By.cssSelector("button.rtmedia-like.rtmedia-action-buttons.button")).click();
					System.out.println("Like button is present ");
					System.out.println("clicked on Like Button ");
				 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Likes/Functional/another user  like Button test7.png');");		
            Constants.logout(wd);		 
		
	}

}
