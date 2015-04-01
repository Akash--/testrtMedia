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
import testscripts.Constants;
// For this test to run successfully have a group named : test
public class enableMediaInGroupTest {
	@Test(groups = {"buddypress"})
	public static void enablemediagroup() throws Exception {
	
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


		// Open rtMedia Settings 
		Constants.openrtMediaSettings(wd);
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediainGroup/Functional/EnableMediaInGroup01.png');");			
		//Thread.sleep(5000);
		
		// Click on rtMedia settings BuddyPress Tab

		wd.findElement(By.id("tab-rtmedia-bp")).click();

		System.out.println("BuddyPress Tab Opened");
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediainGroup/Functional/EnableMediaInGroup02.png');");
		// Check if the switch is on or off, if its off then switch on and  proceed
		List<WebElement> switchElement = wd.findElements(By
	.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-16\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

	if (switchElement.size() != 0) {

	switchElement.get(0).findElement(By.cssSelector("span.switch-right")).click();
	System.out.println("'Enable Media in Group' is switched  on");
		} else
			System.out.println("'Enable Media in Group' is already on");
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediainGroup/Functional/EnableMediaInGroup03.png');");
	// Enable Terms and Conditions
		 
		//Click on rtMedia settings OtherSettings Tab

		wd.findElement(By.id("tab-rtmedia-general")).click();
					
try{				
	List<WebElement> switchElement2 = wd.findElements(By
	.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-39\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

	if (switchElement2.size() != 0) {

	switchElement2.get(0).findElement(By.cssSelector("span.switch-right")).click();
	System.out.println("'Terms and Conditions' is switched  on");
		} else
			System.out.println("Terms and Conditions  is already enabled");
	// Enter a  Link for "Terms of Service" page 		
	wd.findElement(By.id("rt-form-text-16")).click();
    wd.findElement(By.id("rt-form-text-16")).clear();
    wd.findElement(By.id("rt-form-text-16")).sendKeys("https://rtcamp.com/refund-policy/");
 
}catch (Throwable t){
	System.out.println("Move on if rtMedia Core is installed. T & C is only available in rtMedia Pro");
}		
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediainGroup/Functional/EnableMediaInGroup04.png');");				
		// save the settings Form
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		
		System.out.println("Settings saved");
		Thread.sleep(4000);
		
		// Do a mouse over on the primary menu on top LHS
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();

		// Click on Visit Site

			wd.findElement(By.linkText("Visit Site")).click();
			
	/*	// Click on Profile (Howdy, admin) section

		wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item")).click();

		// Click on Groups

		wd.findElement(By.id("user-groups")).click();*/
			
		// Navigate to Groups
			
	wd.navigate().to(Constants.WP_SERVER + "/groups");
	System.out.println("Reached Groups");
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediainGroup/Functional/EnableMediaInGroup05.png');");
		
	// click on a group named "test"

		wd.findElement(By.linkText("test")).click();
	/*wd.findElement(By.cssSelector("div.item-title")).click(); //click on the latest test group
*/	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediainGroup/Functional/EnableMediaInGroup06.png');");
	System.out.println("Clicked on a group named : test ");
	Thread.sleep(10000);
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediainGroup/Functional/EnableMediaInGroup07.png');");
		// click on Media inside test group

		wd.findElement(By.id("rtmedia-media-nav")).click();
		 
				

		// Upload Media  via PhantomJSDriver		
				
		// Upload Media in Group's Media  Gallery by clicking Upload button
			
	
			Thread.sleep(3000);
		
		wd.findElement(By.cssSelector(".rtmedia-upload-media-link")).click();
			
		System.out.println("rtMedia-upload-button Clicked");
			
			Thread.sleep(3000);
			
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediainGroup/Functional/EnableMediaInGroup08.png');");

		
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
			
		
	((PhantomJSDriver) wd).executePhantomJS("var page=this; "
						+ "var count=0;" + "page.uploadFile('input[type=file]','"
						+ Constants.MusicPhantom + "');"
						+"page.render('./screen/BuddyPress/Functional/EnableMediaInGroup09.png');");
				Thread.sleep(11000); // Increase sleep for Music and Video uploads

		// click Start Upload button

					
			 wd.findElement(By.cssSelector("input.start-media-upload")).click();
			
			System.out.println("Start Media  Upload button clicked");
			Thread.sleep(10000); // Increase sleep for Music and Video uploads
				
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediainGroup/Functional/EnableMediaInGroup10.png');");
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

	/*public static boolean isAlertPresent(FirefoxDriver wd) {
		try {
			wd.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}*/
}
