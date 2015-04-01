/*@ Author Sumeet*/
package testscripts.buddyPress;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
/*import org.openqa.selenium.firefox.FirefoxDriver;*/
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import testscripts.Constants;

public class enableMediaInProfileTest {
	@Test(groups = {"buddypress"})
	public static void enablemediaadmin() throws Exception {

	
		// Phantom js : headless
		// Code to take screenshots
		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
		
		PhantomJSDriver wd = new PhantomJSDriver(caps);
		
		
		/*Original 1920 w and 1000 H*/ 
		wd.manage().window().setSize(new Dimension(1024, 1024));
		wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// Login to wordpress by admin account
				wd.get(Constants.WP_SERVER);
				Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
				 System.out.println("Correctly Logged In");

		// Open rtMedia Settings 
		Constants.openrtMediaSettings(wd);
		
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediaInProfile/Functional/EnableMediaInProfile01.png');"); 
				
	//	Thread.sleep(5000);
		// Click on rtMedia settings BuddyPress Tab 
		wd.findElement(By.id("tab-rtmedia-bp")).click();

		System.out.println("BuddyPress Tab Opened");

		
		// Check if the switch is on or off, if its off then switch on and Proceed
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediaInProfile/Functional/EnableMediaInProfile02.png');");
		
List<WebElement> switchElement = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-15\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

System.out.println("switch size:"+switchElement.size());
	if (switchElement.size() != 0) {

			switchElement.get(0).findElement(By.cssSelector("span.switch-right")).click();
					System.out.println("'Enable Media in Profile ' is switched  on");
						} else
							System.out.println("'Enable Media in Profile' is already on");
	
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediaInProfile/Functional/EnableMediaInProfile03.png');");	
	
	
		//  Enable Terms and Conditions 
		
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
					wd.findElement(By.id("rt-form-text-15")).click();
				    wd.findElement(By.id("rt-form-text-15")).clear();
				    wd.findElement(By.id("rt-form-text-15")).sendKeys("https://rtcamp.com/refund-policy/");    	
				}catch (Throwable t){
					System.out.println("Move on if rtMedia Core is installed. T & C is only available in rtMedia Pro");
				}	
	
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		System.out.println("Settings saved");
		Thread.sleep(2000);
	
		// Do a mouse over on the primary menu on top LHS
new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();

// Click on Visit Site

	wd.findElement(By.linkText("Visit Site")).click();
	
	// Click on Profile (Howdy, admin) section to check Media is present in
		// BuddyPress profile or not

		/*	wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item")).click();

		// click on Media to open Media Gallery

		wd.findElement(By.id("user-media")).click();*/
		
	//  Mouseover  on Profile (Howdy, admin) section , click on Media 

				new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
				Thread.sleep(1000);
				new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).click();
				wd.findElement(By.linkText("Media")).click();
				
	System.out.println("Media Clicked");			
		//		Thread.sleep(5000);
				
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediaInProfile/Functional/EnableMediaInProfile04.png');");
	
	
	// Upload Media  via PhantomJSDriver		
	// Upload Media in Gallery by clicking Upload button
		//Thread.sleep(3000);
	
	
		wd.findElement(By.cssSelector(".rtmedia-upload-media-link")).click();
		
			
		System.out.println("rtMedia-upload-button Clicked");
		
		//Thread.sleep(3000);
		
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediaInProfile/Functional/EnableMediaInProfile05.png');");
	
	try{
		// click on Terms and Conditions .
		
		if (!wd.findElement(By.cssSelector("input#rtmedia_upload_terms_conditions")).isSelected()) {
			wd.findElement(By.cssSelector("input#rtmedia_upload_terms_conditions")).click();
			System.out.println("Terms and Conditions Enabled");
		} 
}catch(Throwable t) {
	System.out.println("Terms and Conditions is rtMedia Pro only feature.  ");
}
		
		
// Click Select Files
				
	wd.findElement(By.cssSelector(".rtm-select-files")).click() ;
	
		
	System.out.println("Select Files Clicked");
		
	
((PhantomJSDriver) wd).executePhantomJS("var page=this; "
					+ "var count=0;" + "page.uploadFile('input[type=file]','"
					+ Constants.PhotoPhantom + "');"					 
					+"page.render('./screen/BuddyPress/EnableMediaInProfile/Functional/EnableMediaInProfile06.png');");
			/*Thread.sleep(11000); // Increase sleep for Music and Video uploads */

	// click Start Upload button

				
		 wd.findElement(By.cssSelector("input.start-media-upload")).click();

		System.out.println("Start Media  Upload button clicked");
		// Use of Explicit Wait 
		WebDriverWait wait = new WebDriverWait(wd, 10);
	/*WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("someid")));*/
WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.start-media-upload")));			
	 wd.findElement(By.cssSelector("input.start-media-upload")).click();
			
				
		
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediaInProfile/Functional/EnableMediaInProfile07.png');");
Thread.sleep(5000);

// Verify Media : test.jpg upload

if (!wd.findElement(By.tagName("html")).getText().contains("test")) {
    System.out.println("verifyTextPresent failed");
}
else {
	System.out.println("verifyMediaNamePresent Passed");
}

		// Log out
	Constants.logout(wd);	
	/*	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
		wd.findElement(By.linkText("Log Out")).click();*/

	}


}
