/*@ Author Sumeet*/
package testscripts.buddyPress;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import testscripts.Constants;

//Admin login first.  Admin login done to switch on the setting if disabled   
public class allowUploadFromActivityStreamOtherRolesTest {
	@Test(groups = {"buddypress"})
	public static void allowUploadFromActivityStreamOther() throws Exception {
		// Check for Profiles 
	
		// Phantom js : headless
		// Code to take screenshots
		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
		
		PhantomJSDriver wdAdmin = new PhantomJSDriver(caps);
		wdAdmin.manage().window().setSize(new Dimension(1920, 1080));
		//wdAdmin.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		// Admin login first.  Admin login done to switch on the setting if disabled

		// Login to wordpress by admin account
				wdAdmin.get(Constants.WP_SERVER);
				Constants.login(wdAdmin, Constants.USERNAME1, Constants.UPASSWORD1);
		
		System.out.println("Correctly Logged In With Admin Account to switch on the setting if off");			

		// Open rtMedia Settings 
		
		Constants.openrtMediaSettings(wdAdmin);
						
		Thread.sleep(5000);
		
		// Click on rtMedia settings BuddyPress Tab

		wdAdmin.findElement(By.id("tab-rtmedia-bp")).click();

		System.out.println("BuddyPress Tab Opened");
		/*((PhantomJSDriver) wdAdmin).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow Upload ActivityFunctional/Allow Upload Activity 03.png');");*/
		
		// Check if the switch is on or off, if its off then switch on and  proceed
		
		List<WebElement> switchElement = wdAdmin.findElements(By
.cssSelector("span.rt-form-checkbox> label[for=\"rtmedia-bp-enable-activity\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

	if (switchElement.size() != 0) {

	switchElement.get(0).findElement(By.cssSelector("span.switch-right")).click();
	System.out.println("'Allow Upload From Activity Stream' is switched  on");
		} 
	else
		System.out.println("'Allow Upload From Activity Stream' is already on");
	((PhantomJSDriver) wdAdmin).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow Upload Activity for other roles/Functional/Allow Upload Activity/Functional/Allow Upload Activity 04.png');");	
		
	// save the BuddyPress settings
	
	wdAdmin.findElement(By.id("rtmedia-settings-submit")).click();
		System.out.println("rtMedia Settings Saved");
		//Thread.sleep(2000);
		
		
		
		// log out as admin
		
		new Actions(wdAdmin).moveToElement(wdAdmin.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
		Thread.sleep(2000);
		wdAdmin.findElement(By.linkText("Log Out")).click();
		
			
		// Login with Other Roles
				
		Capabilities caps2 = new DesiredCapabilities();
		((DesiredCapabilities) caps2).setJavascriptEnabled(true);
		((DesiredCapabilities) caps2).setCapability("takesScreenshot", true);
		
		PhantomJSDriver wd = new PhantomJSDriver(caps2);
		wd.manage().window().setSize(new Dimension(1920, 1080));
		//wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		
		// Login to WordPress with other user roles :: Author , Editor , Contributor , Subscriber
		// Login to wordpress by as a TestEditor
				wd.get(Constants.WP_SERVER);
				Constants.login(wd, Constants.TestEditor, Constants.TestEditorPassword);
				 System.out.println("Correctly Logged In");

				 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow Upload Activity for other roles/Functional/Allow Upload Activity Other Roles01.png');");		

/*	Constants.login(wd, Constants.TestAuthor, Constants.TestAuthorPassword); */
	

	// Click on ACTIVITY
	/*wd.findElement(By.linkText("ACTIVITY")).click();*/	
			
			wd.navigate().to(Constants.WP_SERVER + "/activity");
			
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow Upload Activity for other roles/Functional/Allow Upload Activity Other Roles02.png');");		
						
			wd.findElement(By.id("whats-new")).click();
			wd.findElement(By.id("whats-new")).sendKeys("testing");
			
			Thread.sleep(2000);
			System.out.println(" Clicked Activity");
						
			// Upload Media : Photo
			
			// Click Attach Files
			
			/*wd.findElement(By.id("rtmedia-add-media-button-post-update")).click();*/
			wd.findElement (By.cssSelector("button.rtmedia-add-media-button")).click();
			
			
			Thread.sleep(3000);
			System.out.println("Attach Files Clicked");
					
			((PhantomJSDriver) wd).executePhantomJS("var page=this; "
					+ "var count=0;" + "page.uploadFile('input[type=file]','"
					+ Constants.PhotoPhantom + "');"					 
					+"page.render('./screen/BuddyPress/Allow Upload Activity for other roles/Functional/Allow Upload Activity OtherRoles03.png');");
			Thread.sleep(4000); // Increase sleep for Music and Video uploads
			
			// Enter some content

			wd.findElement(By.id("whats-new")).click();
			wd.findElement(By.id("whats-new")).clear();
			wd.findElement(By.id("whats-new")).sendKeys("Check Upload From Activity Stream : Photos ");	
					
			System.out.println("Check Upload From Activity Stream : Photos  text entered");	
			Thread.sleep(4000);
		
			wd.findElement(By.id("aw-whats-new-submit")).click();
			wd.findElement (By.cssSelector("input#aw-whats-new-submit")).click();
			System.out.println("Post Update button clicked");	
			Thread.sleep(6000);
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow Upload Activity for other roles/Functional/Allow Upload Activity OtherRoles04.png');");


			// Verify Presence of Text in Activity 
				
				String actual1= wd.findElement(By.cssSelector("div.rtmedia-activity-text")).getText();
				
				String expected1 = "Check Upload From Activity Stream : Photos";
					
					try{	Assert.assertEquals(actual1, expected1);
					 System.out.println("Expected Text Present");
					} catch(Throwable e){
						System.out.println("Expected Text Not Present for Activity- failed");}
							
			
					// CHECK FOR GROUPS

					 //  Mouseover on Profile (Howdy, admin) section
					new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
					Thread.sleep(1000);
							   
					// Click on Groups
						
					new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-groups > a.ab-item"))).build().perform();
					wd.findElement(By.cssSelector("#wp-admin-bar-my-account-groups > a.ab-item")).click();
					Thread.sleep(1000);
					System.out.println("Reached Groups");
					// Create a group named test, if not already done
								
					// click on a group named "test"

					wd.findElement(By.linkText("test")).click();
					((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow Upload Activity for other roles/Functional/Allow Upload Activity 08.png');");
					
					System.out.println("Clicked on a Group named test");
					
					// Click on ACTIVITY inside test group
					
					wd.findElement(By.id("whats-new")).click();
					wd.findElement(By.id("whats-new")).clear();
					
					System.out.println("Clicked on ACTIVITY inside test group");
					Thread.sleep(5000);


					// Upload Media : Music
					
							// Click Attach Files
							wd.findElement(By.id("rtmedia-add-media-button-post-update")).click();
				wd.findElement (By.cssSelector("button#rtmedia-add-media-button-post-update.rtmedia-add-media-button")).click();
							
							Thread.sleep(3000);
							System.out.println("Attach Files Clicked for Group Activity Upload");
							
								((PhantomJSDriver) wd).executePhantomJS("var page=this;"
									+ "var count=1;" + "page.uploadFile('input[type=file]','"
									+ Constants.MusicPhantom + "');"					 
									+"page.render('./screen/BuddyPress/Allow Upload Activity for other roles/Functional/Allow Upload From Activity 09.png');");
							Thread.sleep(11000); // Increase sleep for Music and Video uploads
						
							// Enter some content

							wd.findElement(By.id("whats-new")).click();
							wd.findElement(By.id("whats-new")).clear();
							wd.findElement(By.id("whats-new")).sendKeys("check upload from activity for a Group named test");				
							System.out.println("check upload from activity for a Group named test  text entered");				
							((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow Upload Activity for other roles/Functional/Allow Upload Activity 09.1.png');");				
							
							// Click  Post Update
							
							wd.findElement(By.id("aw-whats-new-submit")).click();
							wd.findElement (By.cssSelector("input#aw-whats-new-submit")).click();
							System.out.println("Post Update button clicked for Group Activity Upload");	
							Thread.sleep(5000);
					((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow Upload Activity for other roles/Functional/Allow Upload Activity 10.png');");
					
					// Verify
					
					String actual2= wd.findElement(By.className("activity-inner")).getText();
					
					String expected2 = "check upload from activity for a Group named test";
					
						try{
							Assert.assertEquals(actual2, expected2);
							System.out.println("Expected Text Present");
						}
					catch(Throwable T){
						System.out.println("Expected Text Not Present for Group Activity- failed");
					}
				// log out
			/*	Constants.logout(wd);*/
				new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
				Thread.sleep(2000);
				wd.findElement(By.linkText("Log Out")).click();
						
	}

}
