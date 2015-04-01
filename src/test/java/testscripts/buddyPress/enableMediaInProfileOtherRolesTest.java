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

public class enableMediaInProfileOtherRolesTest {
	@Test(groups = {"buddypress"})
	public static void enablemediaotherroles() throws Exception {
		
// Admin login first.  Admin login done to switch on the setting if disabled		
		
		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
		
		PhantomJSDriver wdAdmin = new PhantomJSDriver(caps);
		wdAdmin.manage().window().setSize(new Dimension(1920, 1080));
		//wdAdmin.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	
		wdAdmin.get(Constants.WP_SERVER);
		Constants.login(wdAdmin, Constants.USERNAME1, Constants.UPASSWORD1);
		
		//Thread.sleep(1000);
		
		
		System.out.println("Correctly Logged In With Admin Account to switch on the setting if off");		
				
		// Open rtMedia Settings 
		Constants.openrtMediaSettings(wdAdmin);
			//Thread.sleep(5000);
		// Click on rtMedia settings BuddyPress Tab 
			wdAdmin.findElement(By.id("tab-rtmedia-bp")).click();

		System.out.println("BuddyPress Tab Opened");

		
		// Check if the switch is on or off, if its off then switch on and Proceed
		
List<WebElement> switchElement = wdAdmin.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-15\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

System.out.println("switch size:"+switchElement.size());
	if (switchElement.size() != 0) {

			switchElement.get(0).findElement(By.cssSelector("span.switch-right")).click();
					System.out.println("'Enable Media in Profile ' is switched  on");
						} else System.out.println("'Enable Media in Profile' is already on");
		//  Enable Terms and Conditions 
		
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
					wdAdmin.findElement(By.id("rt-form-text-15")).click();
					wdAdmin.findElement(By.id("rt-form-text-15")).clear();
					wdAdmin.findElement(By.id("rt-form-text-15")).sendKeys("https://rtcamp.com/refund-policy/");    	
				}catch (Throwable t){
					System.out.println("Move on if rtMedia Core is installed. T & C is only available in rtMedia Pro");
				}	
	
				wdAdmin.findElement(By.id("rtmedia-settings-submit")).click();
		System.out.println("Settings saved");
		Thread.sleep(2000);	
		new Actions(wdAdmin).moveToElement(wdAdmin.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
		wdAdmin.findElement(By.linkText("Log Out")).click();
	
		
	// Login to WordPress with other user roles :: Author , Editor , Contributor , Subscriber
		// Phantom js : headless
		// Code to take screenshots
		Capabilities caps2 = new DesiredCapabilities();
		((DesiredCapabilities) caps2).setJavascriptEnabled(true);
		((DesiredCapabilities) caps2).setCapability("takesScreenshot", true);
		
		PhantomJSDriver wd = new PhantomJSDriver(caps);
		wd.manage().window().setSize(new Dimension(1920, 1080));
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

/*Constants.login(wd, Constants.TestSubscriber, Constants.TestSubscriberPassword);*/
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediaInProfileOtherRoles/Functional/EnableMediaInProfileOtherRoles01.png');");

		wd.get(Constants.WP_SERVER);
		Constants.login(wd, Constants.TestEditor, Constants.TestEditorPassword);
		/*Constants.login(wd, Constants.DotNetUSERNAME1, Constants.DotNetUPASSWORD1);*/
		
		System.out.println("Correctly Logged In From another user");		
		
				
			// Click on Profile (Howdy, admin) section to check Media is present in BuddyPress profile or not
		
		wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item")).click();

		// If enabled click on Media to open Media Gallery

		wd.findElement(By.id("user-media")).click();

		// UPLOAD MEDIA  VIA PHANTOMJSDRIVER

		// Click on Upload
		
			//Thread.sleep(3000);
		
			wd.findElement(By.cssSelector(".rtmedia-upload-media-link")).click();
			
			System.out.println("rtMedia-upload-button Clicked");
			
			//Thread.sleep(3000);
			
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediaInProfileOtherRoles/Functional/EnableMediaInProfileOtherRoles02.png');");

		try{
		// click on Terms and Conditions .
		
		if (!wd.findElement(By.cssSelector("input#rtmedia_upload_terms_conditions")).isSelected()) {
			wd.findElement(By.cssSelector("input#rtmedia_upload_terms_conditions")).click();
			System.out.println("Terms and Conditions Enabled");
		} 
}catch(Throwable t) {
	System.out.println("rtMedia Pro only feature.  ");
}			
	
			
			
	// Click Select Files
					
		wd.findElement(By.cssSelector(".rtm-select-files")).click() ;
		
		/*wd.findElement(By.cssSelector(".rtmedia-upload-input")).click() ;*/
				
		System.out.println("Select Files Clicked");
			
		
((PhantomJSDriver) wd).executePhantomJS("var page=this; "+ "var count=0;" + "page.uploadFile('input[type=file]','"+ Constants.MusicPhantom + "');"
	+"page.render('./screen/BuddyPress/EnableMediaInProfileOtherRoles/Functional/EnableMediaInProfile06.png');");
				
	//Thread.sleep(11000); // Increase sleep for Music and Video uploads
				
				
		// click Start Upload button

					
			 wd.findElement(By.cssSelector("input.start-media-upload")).click();
			
			System.out.println("Start Media  Upload button clicked");
			Thread.sleep(10000); // Increase sleep for Music and Video uploads
				
					
			
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediaInProfileOtherRoles/Functional/EnableMediaInProfilePOtherRoles03.png');");
	//Thread.sleep(5000);

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
