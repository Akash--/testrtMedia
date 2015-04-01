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
import org.testng.Reporter;
import org.testng.annotations.Test;

import testscripts.Constants;
// For this test to run successfully have a group named : test
public class enableMediaInGroupNGTest {
	@Test(groups = { "buddypressnegative" })
	public static void enablemediagroupNG() throws Exception {
	
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
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediainGroup/Negative/EnableMediaInGroupNG01.png');");				
		Thread.sleep(5000);
		
		// Click on rtMedia settings BuddyPress Tab

		wd.findElement(By.id("tab-rtmedia-bp")).click();

		System.out.println("BuddyPress Tab Opened");
		
		// Check if the switch is on or off, IF ON  then SWITCH  OFF
		
List<WebElement> switchElement = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-16\"] > div.rt-switch.has-switch > div.switch-animate.switch-on"));

				if (switchElement.size() != 0) {

					switchElement.get(0).findElement(By.cssSelector("span.switch-left")).click();
					
					System.out.println("Enable Media in Group' is correctly switched  OFF");

				} else
					System.out.println("Enable Media in Group is already off");
				
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediainGroup/Negative/EnableMediaInGroupNG02.png');");			
				
	
	
				
		// save the settings Form
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		System.out.println("Settings saved");
		Thread.sleep(2000);
		// Do a mouse over on the primary menu on top LHS
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
		// Click on Visit Site

		wd.findElement(By.linkText("Visit Site")).click();
		// Click on Profile (Howdy, admin) section

		wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item")).click();
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediainGroup/Negative/EnableMediaInGroupNG03.png');");
		// Click on Groups

		wd.findElement(By.id("user-groups")).click();
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediainGroup/Negative/EnableMediaInGroupNG04.png');");
		// click on a group named "test"

		wd.findElement(By.linkText("test")).click();
		/*wd.findElement(By.cssSelector("div.item-title")).click();*/  //click on the latest test group	
		System.out.println("Clicked on a group named : test ");
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediainGroup/Negative/EnableMediaInGroupNG05.png');");
		
		//Check for Media  Negative Case . Should not work
		
		boolean flag=false;
		if(wd.findElements(By.id("rtmedia-media-nav")).size() == 0){
					System.out.println("Enable Media in Group  is correctly disabled");
					Reporter.log("Enable Media in Group is correctly disabled");
					flag=true;
				} else {
					System.out.println("Enable Media in Group is still  enabled");
					Reporter.log("Enable Media in Group is still  enabled");
					flag=false;
				}
				Assert.assertEquals(flag, true,"Enable Media in Group is still  enabled");
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/EnableMediainGroup/Negative/EnableMediaInGroupNG06.png');");		
			/*	// click on Media inside test group

		wd.findElement(By.id("rtmedia-media-nav")).click();
		*/
		
	/*	// Upload Media in Gallery by clicking Upload button
		wd.findElement(By.id("rtm_show_upload_ui")).click();
		wd.findElement(By.id("rtMedia-upload-button")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec(Constants.Photo);
		
		Thread.sleep(5000);
		// click on Terms and Conditions. Comment the IF statement if Terms and Conditions is not enabled from Settings 
		try{
		if (!wd.findElement(By.id("rtmedia_upload_terms_conditions")).isSelected()) {
			wd.findElement(By.id("rtmedia_upload_terms_conditions")).click();
		}  }catch(Throwable t){System.out.println("Terms and Conditions is Pro only");}*/

	/*	// click Start Upload button
		wd.findElement(By.cssSelector("input.start-media-upload")).click();*/
		
		
		//Thread.sleep(5000);

		// log out
		Constants.logout(wd);
		
		
	}

	
}
