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
import org.testng.annotations.Test;

import testscripts.Constants;
//  To run this test successfully  :  Join the group "test"  or accept invite to join group : test . 
public class enableMediaInGroupOtherRolesTest {
	@Test(groups = {"buddypress"})
public static void enableMediaInGroupOther() throws Exception {

	 // Admin login first.  Admin login done to switch on the setting if disabled
	
			Capabilities caps = new DesiredCapabilities();
			((DesiredCapabilities) caps).setJavascriptEnabled(true);
			((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
			
			PhantomJSDriver wdAdmin = new PhantomJSDriver(caps);
			wdAdmin.manage().window().setSize(new Dimension(1920, 1080));
			//wdAdmin.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			// Login to wordpress by admin account
			wdAdmin.get(Constants.WP_SERVER);
			Constants.login(wdAdmin, Constants.USERNAME1, Constants.UPASSWORD1);
			System.out.println(" Correctly Logged In With Admin Account to switch on the setting if off");		
					
			// Open rtMedia Settings 
			Constants.openrtMediaSettings(wdAdmin);
				//Thread.sleep(5000);
			// Click on rtMedia settings BuddyPress Tab 
				wdAdmin.findElement(By.id("tab-rtmedia-bp")).click();

			System.out.println("BuddyPress Tab Opened");
			// Check if the switch is on or off, if its off then switch on and  proceed
			List<WebElement> switchElement = wdAdmin.findElements(By
		.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-16\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

		if (switchElement.size() != 0) {

		switchElement.get(0).findElement(By.cssSelector("span.switch-right")).click();
		System.out.println("'Enable Media in Group' is switched  on");
			} else
				System.out.println("'Enable Media in Group' is already on");

		// Enable Terms and Conditions
			 
			//Click on rtMedia settings OtherSettings Tab

			wdAdmin.findElement(By.id("tab-rtmedia-general")).click();
						
	try{				
		List<WebElement> switchElement2 = wdAdmin.findElements(By
		.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-39\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

		if (switchElement2.size() != 0) {

		switchElement2.get(0).findElement(By.cssSelector("span.switch-right")).click();
		System.out.println("'Terms and Conditions' is switched  on");
			} else
				System.out.println("Terms and Conditions  is already enabled");
		// Enter a  Link for "Terms of Service" page 		
		wdAdmin.findElement(By.id("rt-form-text-16")).click();
	    wdAdmin.findElement(By.id("rt-form-text-16")).clear();
	    wdAdmin.findElement(By.id("rt-form-text-16")).sendKeys("https://rtcamp.com/refund-policy/");
	 
	}catch (Throwable t){
		System.out.println("Move on if rtMedia Core is installed. T & C is only available in rtMedia Pro");
	}		
	((PhantomJSDriver) wdAdmin).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediaingroupOtherRoles/Functional/EnableMediaInGroupOtherRoles01.png');");				
		
	 // save the settings Form
	
		wdAdmin.findElement(By.id("rtmedia-settings-submit")).click();
			
			System.out.println("Settings saved");

			//Thread.sleep(2000);	
			new Actions(wdAdmin).moveToElement(wdAdmin.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
			wdAdmin.findElement(By.linkText("Log Out")).click();
		
			
	// Login with Non Admin user(s)
	// Phantom js : headless
	// Code to take screenshots
	Capabilities caps2 = new DesiredCapabilities();
	((DesiredCapabilities) caps2).setJavascriptEnabled(true);
	((DesiredCapabilities) caps2).setCapability("takesScreenshot", true);
	
	PhantomJSDriver wd = new PhantomJSDriver(caps);
	wd.manage().window().setSize(new Dimension(1920, 1080));
	//wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	
	// Login to WordPress with other user roles :: Author , Editor , Contributor , Subscriber
	
			wd.get(Constants.WP_SERVER);
			wd.findElement(By.linkText("Log in")).click();
			wd.findElement(By.id("user_login")).click();
			wd.findElement(By.id("user_login")).clear();
			wd.findElement(By.id("user_login")).sendKeys(Constants.TestEditor);
			wd.findElement(By.id("user_pass")).click();
			wd.findElement(By.id("user_pass")).clear();
			wd.findElement(By.id("user_pass")).sendKeys(Constants.TestEditorPassword);
			wd.findElement(By.id("wp-submit")).click();
			Thread.sleep(1000);
			/*Constants.login(wd, Constants.DotNetUSERNAME1, Constants.DotNetUPASSWORD1);*/
			
	System.out.println("Correctly Logged In");	

((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediaingroupOtherRoles/Functional/EnableMediaInGroupOtherRoles01.png');");		

// Click on Profile (Howdy, admin) section

			wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item")).click();

		/*	// Click on Groups

			wd.findElement(By.id("user-groups")).click();
*/		
				// Navigate to Group named test
				
				wd.navigate().to(Constants.WP_SERVER + "/groups/test/");			
			/*wd.findElement(By.linkText("test")).click();*/
			
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediaingroupOtherRoles/Functional/EnableMediaInGroupOtherRoles02.png');");
			
// Join a group named test if not already Joined 

try{wd.findElement(By.linkText("Join Group")).click(); } catch(Throwable T){System.out.println("Already Joined. Move On.");}

((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Functional/EnableMediaInGroupOtherRoles03.png');");
// click on Media inside test group

			wd.findElement(By.id("rtmedia-media-nav")).click();
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediaingroupOtherRoles/Functional/EnableMediaInGroupOtherRoles04.png');");			
			// Upload Media in Gallery by clicking Upload button
			Thread.sleep(3000);
						
			// Click on Upload
			
						
				wd.findElement(By.cssSelector(".rtmedia-upload-media-link")).click();
				
					
				System.out.println("rtMedia-upload-button Clicked");
				
		//		Thread.sleep(3000);
			
			
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediaingroupOtherRoles/Functional/EnableMediaInGroupOtherRoles05.png');");		
			
			// click on Terms and Conditions.  
			try{	
			if (!wd.findElement(By.id("rtmedia_upload_terms_conditions")).isSelected()) {
					wd.findElement(By.id("rtmedia_upload_terms_conditions")).click();
					System.out.println("Terms and Conditions Enabled");
				}  }catch(Throwable t){System.out.println("Terms and Conditions is Pro only");}
		
		
			// Click Select Files
			
			wd.findElement(By.cssSelector(".rtm-select-files")).click() ;
			System.out.println("Select Files Clicked");
					
((PhantomJSDriver) wd).executePhantomJS("var page=this; "+ "var count=0;" + "page.uploadFile('input[type=file]','"+ Constants.MusicPhantom + "');"
+"page.render('./screen/BuddyPress/Functional/EnableMediaInGroupOtherRoles06.png');");	

Thread.sleep(11000); // Increase sleep for Music and Video uploads


// click Start Upload button
			
	 wd.findElement(By.cssSelector("input.start-media-upload")).click();
	 System.out.println("Start Media  Upload button clicked");
			//Thread.sleep(5000);
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress//EnableMediaingroupOtherRoles/Functional/EnableMediaInGroupPOtherRoles07.png');");
			Thread.sleep(5000);			

			// Verify Media Upload  : mpthreetest.mp3  in Group : test
			
			if (!wd.findElement(By.tagName("html")).getText().contains("mpthreetest")) {
		        System.out.println("verifyMediaNamePresent failed");
		    }
			else {
				System.out.println("verifyMediaNamePresent Passed");
			}
			
			
			// log out
			Constants.logout(wd);
	
}
}







