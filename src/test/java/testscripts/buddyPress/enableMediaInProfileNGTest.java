/*@ Author Sumeet*/
package testscripts.buddyPress;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
/*import org.openqa.selenium.firefox.FirefoxDriver;*/
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import testscripts.Constants;

public class enableMediaInProfileNGTest {
	@Test(groups = { "buddypressnegative" })
// Negative test cases 	
	public static void enablemediaadminNG() throws Exception {

		// Phantom js : headless
				// Code to take screenshots
				Capabilities caps = new DesiredCapabilities();
				((DesiredCapabilities) caps).setJavascriptEnabled(true);
				((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
				
				PhantomJSDriver wd = new PhantomJSDriver(caps);
				wd.manage().window().setSize(new Dimension(1920, 1080));
		//		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				// Login to wordpress by admin account
				wd.get(Constants.WP_SERVER);
				Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
				 System.out.println("Correctly Logged In");

((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediaInProfile/Negative/EnableMediaInProfileNG01.png');");		
Thread.sleep(2000);
				
// Open rtMedia Settings 
						
Constants.openrtMediaSettings(wd);

((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediaInProfile/Negative/EnableMediaInProfileNG02.png');");
/*
// Do a mouse over on the primary menu on top LHS				
new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
								Thread.sleep(2000);
								// Click on Dashboard
								wd.findElement(By.linkText("Dashboard")).click();
								System.out.println("Dashboard Clicked");
								// Click on rtMedia
								wd.findElement(By.linkText("rtMedia")).click();
								System.out.println("rtMedia Clicked");
				*/
	/*Thread.sleep(5000);*/
	
// Click on rtMedia settings BuddyPress Tab 
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediaInProfile/Negative/EnableMediaInProfileNG03.png');");
wd.findElement(By.id("tab-rtmedia-bp")).click();

System.out.println("BuddyPress Tab Opened");
		
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediaInProfile/Negative/EnableMediaInProfileNG03.png');");
		// Check if the switch is on or off, IF ON  then SWITCH  OFF
		List<WebElement> switchElement = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-15\"] > div.rt-switch.has-switch > div.switch-animate.switch-on"));

		if (switchElement.size() != 0) {

			switchElement.get(0).findElement(By.cssSelector("span.switch-left")).click();
			
			System.out.println("Enable Media in profile is switched off");

		} else
			System.out.println("Enable Media in profile is already off");
		
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediaInProfile/Negative/EnableMediaInProfileNG04.png');");		
		

/*		//  Enable Terms and Conditions 
		//Click on rtMedia settings OtherSettings Tab

				wd.findElement(By.id("tab-rtmedia-general")).click();
				
						
						boolean checkBox2 = wd.findElement(By.id("rt-form-checkbox-39")).isSelected();
						if (checkBox2 == false)
							wd.findElement(By.id("rt-form-checkbox-39")).click();
						else
							System.out.println("Terms and Conditions  is already enabled");
						
						wd.findElement(By.id("rt-form-text-16")).click();
				        wd.findElement(By.id("rt-form-text-16")).clear();
				        wd.findElement(By.id("rt-form-text-16")).sendKeys("https://rtcamp.com/refund-policy/");
*/				
// save the settings Form
	
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		System.out.println("Settings saved");
		//Thread.sleep(2000);
		
		// Do a mouse over on the primary menu on top LHS
	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();

		// Click on Visit Site

		wd.findElement(By.linkText("Visit Site")).click();
		
	// Click on Profile (Howdy, admin) section to check Media is present in BuddyPress profile or not

		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();	
		wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item")).click();

		// click on Media to open Media Gallery
		
		//Check for Media  Negative Case . Should not work
		
		boolean flag=false;
		/*if(wd.findElements(By.cssSelector("div.ab-item")).size() == 0){*/
		/*You should not be using findElement to determine element non-presence; use findElements() and check for zero-length responses.*/
		/*driver.findElements( By.id("...") ).size() != 0*  To  check if element exists. 0 Means Not there   */
		if(wd.findElements(By.id("user-media")).size() == 0){
			System.out.println("Enable Media in Profile  is correctly disabled");
			Reporter.log("Enable Media in Profile is correctly disabled");
			flag=true;
		} else {
			System.out.println("Enable Media in Profile is still  enabled");
			Reporter.log("Enable Media in Profile is still  enabled");
			flag=false;
		}
				Assert.assertEquals(flag, true,"Enable Media in Profile is still  enabled");
		
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediaInProfile/Negative/EnableMediaInProfileNG05.png');");		
/*boolean flag = false;

		if(wd.findElement(By.id("user-media")).click();*/
		
/*	//  Mouseover  on Profile (Howdy, admin) section , click on Media 

	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
		Thread.sleep(1000);
		
		//Check for Media  Negative Case . Should not work
		
		boolean flag=false;
		if(wd.findElements(By.cssSelector("div.ab-item")).size() == 0){
			System.out.println("Enable Media in Profile  is correctly disabled");
			Reporter.log("Enable Media in Profile is correctly disabled");
			flag=true;
		} else {
			System.out.println("Enable Media in Profile is still  enabled");
			Reporter.log("Enable Media in Profile is still  enabled");
			flag=false;
		}
		Assert.assertEquals(flag, true,"Enable Media in Profile is still  enabled");
		
		
	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).click();
	wd.findElement(By.linkText("Media")).click();
	Thread.sleep(1000);

		// Upload Media in Gallery by clicking Upload button
				
		wd.findElement(By.id("rtm_show_upload_ui")).click();

		wd.findElement(By.id("rtMedia-upload-button")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec(Constants.Photo);

		Thread.sleep(5000);
		try{
		// click on Terms and Conditions .
		
		if (!wd.findElement(By.id("rtmedia_upload_terms_conditions")).isSelected()) {
			wd.findElement(By.id("rtmedia_upload_terms_conditions")).click();
		} 
}catch(Throwable t) {
	System.out.println("rtMedia Pro only feature.  ");
}
		// click Start Upload button
		wd.findElement(By.cssSelector("input.start-media-upload")).click();

		wd.navigate().refresh();
		Thread.sleep(5000);
	
*/		// Log out
		Constants.logout(wd);		
		/*new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
		wd.findElement(By.linkText("Log Out")).click();*/
		

	}


	/*public static boolean isAlertPresent(FirefoxDriver wd) {
		try {
			wd.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	} */
}
