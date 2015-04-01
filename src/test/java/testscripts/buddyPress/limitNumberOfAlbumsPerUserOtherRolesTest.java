/*@ Author Sumeet*/
/*improved by Akash*/
package testscripts.buddyPress;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import testscripts.Constants;

public class limitNumberOfAlbumsPerUserOtherRolesTest {

	@Test(groups = {"buddypress"})
	// PRO only feature . rtMedia Pro must be activated. Limit applies for all users.
	// Make sure Test Contributor user has created no  Album of its own 
	public static void limitNumberOfAlbumsPerUsrOther() throws Exception {

		
		// Login with Admin role : Set limit of albums by users :  1 
		
		// Phantom js : headless
				// Code to take screenshots
				Capabilities caps = new DesiredCapabilities();
				((DesiredCapabilities) caps).setJavascriptEnabled(true);
				((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
				
				PhantomJSDriver wdAdmin = new PhantomJSDriver(caps);
				wdAdmin.manage().window().setSize(new Dimension(1920, 1080));
				wdAdmin.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				wdAdmin.get(Constants.WP_SERVER);
	             Constants.login(wdAdmin, Constants.TestContributor, Constants.TestContributorPassword);
		System.out.println("Correctly Logged in");
		
				
				 
				 //clicked on user name
					wdAdmin.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item")).click();

					// click on Media
					wdAdmin.findElement(By.id("user-media")).click();

					// click on Albums. You will find Albums List
					wdAdmin.findElement(By.id("rtmedia-nav-item-albums")).click();
				
					String a = wdAdmin.findElement(By.cssSelector("#rtmedia-nav-item-albums > span")).getText();
					
					System.out.println("current album :" +a);

				int a1=Integer.parseInt(a);
				int b=a1+2;
				String b1=String.valueOf(b);
			
				 Constants.logout(wdAdmin);
				 
				wdAdmin.get(Constants.WP_SERVER);
				Constants.login(wdAdmin, Constants.USERNAME1, Constants.UPASSWORD1);
				 System.out.println("Correctly Logged In");
						
				// Open rtMedia Settings 
				Constants.openrtMediaSettings(wdAdmin);
						
				//Thread.sleep(5000);
				// Click on rtMedia settings BuddyPress Tab
				wdAdmin.findElement(By.id("tab-rtmedia-bp")).click();
				System.out.println("BuddyPress Tab Opened");
				
				
	
				// enter a number > 0 in settings

						wdAdmin.findElement(By.id("rt-form-number-2")).click();
						wdAdmin.findElement(By.id("rt-form-number-2")).clear();
						 
						//0 is unlimited albums . Change to set limits 
						wdAdmin.findElement(By.id("rt-form-number-2")).sendKeys(b1);// Only 1 album allowed
							
				
				//Thread.sleep(7000);
				// save the BuddyPress settings Form
				wdAdmin.findElement(By.id("rtmedia-settings-submit")).click();
				System.out.println("Settings saved");
		
		// Logout as admin
				
				new Actions(wdAdmin).moveToElement(wdAdmin.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
				//Thread.sleep(2000);
				wdAdmin.findElement(By.linkText("Log Out")).click();			
		
		// Login with a user with no albums created before	
		
				Capabilities caps2 = new DesiredCapabilities();
				((DesiredCapabilities) caps2).setJavascriptEnabled(true);
				((DesiredCapabilities) caps2).setCapability("takesScreenshot", true);
				
				PhantomJSDriver wd = new PhantomJSDriver(caps);
				wd.manage().window().setSize(new Dimension(1920, 1080));
				wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		
				// Login to WordPress with other user roles :: TestContributor
				
			     wd.get(Constants.WP_SERVER);
	             Constants.login(wd, Constants.TestContributor, Constants.TestContributorPassword);
		System.out.println("Correctly Logged in");
		
		// Do a mouse over on the primary menu on top LHS
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();

	
		// Click on Profile (Howdy, admin) section
				
		wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item")).click();

		
		//click on Media
		wd.findElement(By.id("user-media")).click();

		//click on Albums. You will find Albums List  
		wd.findElement(By.id("rtmedia-nav-item-albums")).click();
		//Thread.sleep(3000);

		//click on Options . Must show options to Proceed
		
		wd.findElement(By.id("rtm-media-options-list")).click();
		
		Thread.sleep(1000);
		
		//click on Add Album
		
		wd.findElement(By.cssSelector("#rtm-media-options-list > span.js > span.clicker.rtmedia-action-buttons")).click();
        wd.findElement(By.linkText("Add Album")).click();
        wd.findElement(By.id("rtmedia_album_name")).click();
        wd.findElement(By.id("rtmedia_album_name")).clear();
        wd.findElement(By.id("rtmedia_album_name")).sendKeys("MyAlbum1.Allowed1");
        
        Thread.sleep(4000);
        wd.findElement(By.id("rtmedia_create_new_album")).click();
		Thread.sleep(1000);
		System.out.println("create new album 1");
		wd.navigate().refresh();
        Thread.sleep(4000);
        

        




	wd.findElement(
		By.cssSelector("#rtm-media-options-list > span.js > span.clicker.rtmedia-action-buttons"))
		.click();
	if(wd.findElement(
		By.linkText("Add Album")).isDisplayed())
	{
			wd.findElement(By.linkText("Add Album")).click();
				wd.findElement(By.id("rtmedia_album_name")).click();
						wd.findElement(By.id("rtmedia_album_name")).clear();
						wd.findElement(By.id("rtmedia_album_name")).click();

						wd.findElement(By.id("rtmedia_album_name")).sendKeys(
								"new album 3 added by user");
						wd.findElement(By.id("rtmedia_create_new_album")).click();
						wd.navigate().refresh();
						System.out.println("created 2 Album : Test Fail");
	}
	else
	{
		System.out.println("created album is 1 now");
		System.out.println("Test Pass :Not allow to user create album greater than: "+b1);
	}
	/*
		//album 2 should not get created 
		wd.findElement(By.id("rtm-media-options-list")).click();
		wd.findElement(By.cssSelector("#rtm-media-options-list > span.js > span.clicker.rtmedia-action-buttons")).click();
        wd.findElement(By.linkText("Add Album")).click();
        wd.findElement(By.id("rtmedia_album_name")).click();
        wd.findElement(By.id("rtmedia_album_name")).clear();
        wd.findElement(By.id("rtmedia_album_name")).click();
        wd.findElement(By.id("rtmedia_album_name")).sendKeys("MyAlbum2.Allowed1");
        
        	wd.findElement(By.id("rtmedia_create_new_album")).click();
        *///Thread.sleep(2000);
        /*wd.navigate().refresh();*/
        
         
        
        //Logout 
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
wd.findElement(By.linkText("Log Out")).click();
/*wd.quit();*/

// Change the setting back to a higher number

// Login to WordPress 

	wdAdmin.get(Constants.WP_SERVER);
    Constants.login(wdAdmin, Constants.USERNAME1, Constants.UPASSWORD1);
	System.out.println("Correctly Logged In");
					
			
	// Open rtMedia Settings 
	Constants.openrtMediaSettings(wdAdmin);
			
	//Thread.sleep(5000);
	// Click on rtMedia settings BuddyPress Tab
	wdAdmin.findElement(By.id("tab-rtmedia-bp")).click();
	System.out.println("BuddyPress Tab Opened");
	
	

	// enter a number > 0 in settings

			wdAdmin.findElement(By.id("rt-form-number-2")).click();
			wdAdmin.findElement(By.id("rt-form-number-2")).clear();
			 
			//0 is unlimited albums . Change to set limits 
			wdAdmin.findElement(By.id("rt-form-number-2")).sendKeys("60");
				
	
	//Thread.sleep(7000);
	// save the BuddyPress settings Form
	wdAdmin.findElement(By.id("rtmedia-settings-submit")).click();
	System.out.println("Settings saved");

// Logout 
	
	new Actions(wdAdmin).moveToElement(wdAdmin.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
	Thread.sleep(2000);
	wdAdmin.findElement(By.linkText("Log Out")).click();			
wdAdmin.quit();

}




}

