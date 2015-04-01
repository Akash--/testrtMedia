/*@ Author Sumeet   */  
package testscripts.buddyPress;
import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import testscripts.Constants;
public class allowUserToCreateNewAlbumsTest {
	@Test(groups = {"buddypress"})
// PRO only feature . rtMedia Pro must be activated 
//  checking for admin role
	public static void allowUserCreateNewAlbums() throws Exception{
	
	//CHECK FOR PROFILES
	// Phantom js : headless
	// Code to take screenshots
	
	Capabilities caps = new DesiredCapabilities();
	((DesiredCapabilities) caps).setJavascriptEnabled(true);
	((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
	
	PhantomJSDriver wd = new PhantomJSDriver(caps);
	wd.manage().window().setSize(new Dimension(1920, 1080));
	//wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	

	// Login to wordpress by admin account
			wd.get(Constants.WP_SERVER);
			Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
			 System.out.println("Correctly Logged In");

	
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow user to create new album/Functional/Allow User to Create Albums01.png');");	
	/*// Login to WordPress 
	wd.get(Constants.WP_SERVER); 	
	Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);*/
			
	// Open rtMedia Settings 
	Constants.openrtMediaSettings(wd);
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow user to create new album/Functional/Allow User to Create Albums02.png');");		
	
	//Thread.sleep(5000);
	// Click on rtMedia settings BuddyPress Tab
	wd.findElement(By.id("tab-rtmedia-bp")).click();
	System.out.println("BuddyPress Tab Opened");
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow user to create new album/Functional/Allow User to Create Albums03.png');");
	// Enable Organize Media into Albums, it will enable Allow users to create albums
	
	List<WebElement> switchElement1 = wd.findElements(By
			.cssSelector("span.rt-form-checkbox> label[for=\"rtmedia-album-enable\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

		if (switchElement1.size() != 0) {

		switchElement1.get(0).findElement(By.cssSelector("span.switch-right")).click();
		System.out.println("'Organise Media into Albums' is switched  on");
			} else
				System.out.println("'Organise Media into Albums' is already on");
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow user to create new album/Functional/Allow User to Create Albums04.png');");		
	// Re- enable  Allow users to create albums 
	List<WebElement> switchElement2 = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-17\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

if (switchElement2.size() != 0) {

switchElement2.get(0).findElement(By.cssSelector("span.switch-right")).click();
System.out.println("'Allow User To Create New Albums' is switched  on");
	} else
		System.out.println("'Allow User To Create New Albums' is already on");
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow user to create new album/Functional/Allow User to Create Albums05.png');");
	
		
// Save the BuddyPress settings Form
	
				wd.findElement(By.id("rtmedia-settings-submit")).click();
				System.out.println("rtMedia Settings Saved");
				//Thread.sleep(2000);
				
				// Do a mouse over on the primary menu on top LHS
				
				new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
				
				//Thread.sleep(1000);

				// Click on Visit Site

				wd.findElement(By.linkText("Visit Site")).click();
								
			 // Mouseover on Profile (Howdy, admin) section
				
			new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
				//Thread.sleep(1000);
						   
			// Mouseover on Media 
					
				new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).build().perform();
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow user to create new album/Functional/Allow User to Create Albums06.png');");				
			// Mouseover and click  Albums 
				new Actions(wd).moveToElement(wd.findElement(By.linkText("Albums"))).build().perform();
		        wd.findElement(By.linkText("Albums")).click();				
			System.out.println("Albums opened") ; 

			//Thread.sleep(6000);
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow user to create new album/Functional/Allow User to Create Albums07.png');");			
				//click on Options
				
				wd.findElement(By.id("rtm-media-options-list")).click();
				
				System.out.println("Options Opened");
				//Thread.sleep(1000);
				((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow user to create new album/Functional/Allow User to Create Albums08.png');");	
				//click on Add Album
				
				wd.findElement(By.cssSelector("#rtm-media-options-list > span.js > span.clicker.rtmedia-action-buttons")).click();
		        wd.findElement(By.linkText("Add Album")).click();
		        wd.findElement(By.id("rtmedia_album_name")).click();
		        wd.findElement(By.id("rtmedia_album_name")).clear();
		        wd.findElement(By.id("rtmedia_album_name")).sendKeys("Fresh album added by user");
			    ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress//Allow user to create new album/Functional/Allow User to Create Albums09.png');");		        
		        wd.findElement(By.id("rtmedia_create_new_album")).click();
			     //Thread.sleep(5000);
			   
				    ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow user to create new album/Functional/Allow User to Create Albums10.png');");		
			     System.out.println("Album successfully added");
				     
			    // Assert Album added
	/*String actual1=  wd.findElement(By.cssSelector("img[alt=\"Fresh album added by user\"]")).getText(); 
	String expected1= "Fresh album added by user"; 
			    
			 try{  
				Assert.assertEquals(actual1, expected1);
				System.out.println("Expected Album Present");
			 }catch(Throwable e){
				 System.out.println("Expected Album is not present- failed");
			 }*/
			   // Verify Album Added  
			     if (!(wd.findElements(By.cssSelector("img[alt=\"Fresh album added by user\"]")).size() != 0)) {
			            System.out.println("verifyElementPresent failed"); 
			     }
			    
			     else {
			    	 System.out.println("verifyElementPresent Pass");
			     }
			/*
			     // check for Albums in BuddyPress Groups
			     
				// Click on Profile (Howdy, admin) section

				wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item")).click();

				// Click on Groups

				wd.findElement(By.id("user-groups")).click();

				// Make a group named test.  If already there, click on a group named "test"

				wd.findElement(By.linkText("test")).click();

				// click on Media inside test group

				wd.findElement(By.id("rtmedia-media-nav")).click();
				
				//click on Albums  
				
				wd.findElement(By.id("rtmedia-nav-item-albums")).click();
				Thread.sleep(3000);
				
				wd.navigate().refresh();
				

				//click on Options
				
				wd.findElement(By.id("rtm-media-options-list")).click();
				
				//click on Add Album
				
				wd.findElement(By.cssSelector("#rtm-media-options-list > span.js > span.clicker.rtmedia-action-buttons")).click();
		        wd.findElement(By.linkText("Add Album")).click();
		        wd.findElement(By.id("rtmedia_album_name")).click();
		        wd.findElement(By.id("rtmedia_album_name")).clear();
		        wd.findElement(By.id("rtmedia_album_name")).sendKeys("New album added by user in a group named test");
		        wd.findElement(By.id("rtmedia_create_new_album")).click();
				
		        Thread.sleep(7000);
		        wd.navigate().refresh();
		
*/		        //Logout 
		Constants.logout(wd);

				
}

}
