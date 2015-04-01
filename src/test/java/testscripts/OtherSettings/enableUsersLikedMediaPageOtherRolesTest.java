/*@ Author Sumeet*/
// Work Required here
package testscripts.OtherSettings;

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
//  Run it after enableUsersLikedMediaPage.java
public class enableUsersLikedMediaPageOtherRolesTest {
@Test(groups={"OtherSettings"})

public static void OtherUserLikes() throws Exception {
	
	
	// // Admin login first.  Admin login done to switch on the setting if disabled
	
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
			
	// Open rtMedia Settings /OtherRoles
	Constants.openrtMediaSettings(wdAdmin);
		Thread.sleep(5000);
	
		// Click on rtMedia settings OtherSettings Tab

			wdAdmin.findElement(By.id("tab-rtmedia-general")).click();
					
			System.out.println("Other Settings  Tab Opened");
	
			//Enable users liked media page			
			// Check if the switch is on or off, if its off then switch on and  proceed

				
				List<WebElement> switchElement = wdAdmin.findElements(By
			.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-38\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

							if (switchElement.size() != 0) {

						switchElement.get(0).findElement(By.cssSelector("span.switch-right")).click();
						System.out.println("Enable users liked media page set to ON");
												} 
											else
				System.out.println("Enable users liked media page is already on");
			((PhantomJSDriver) wdAdmin).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/OtherRoles/Functional/Enable users liked media page 01.png');");					
							

				// save the Other settings
				wdAdmin.findElement(By.id("rtmedia-settings-submit")).click();
				
				// Check with Lightbox ON
				// Click on rtMedia settings Display  Tab

						wdAdmin.findElement(By.id("tab-rtmedia-display")).click();
						System.out.println("Display Settings opened ");

						// Check if the switch for Lightbox is on or off, if its off then switch on and  proceed
						
						List<WebElement> switchElement2 = wdAdmin.findElements(By
								.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-6\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

											if (switchElement2.size() != 0) {

											switchElement2.get(0).findElement(By.cssSelector("span.switch-right")).click();
											System.out.println("'Use lightbox to display media' set to ON");
									} 
										else
									System.out.println("The Switch for LightBox is already ON");
								
				// Make sure Allow user to comment on uploaded media  and Enable likes for media : ON							
				// Check if the switch is on or off, if its off then switch on and  proceed
				List<WebElement> switchElement3 = wdAdmin.findElements(By
						.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-0\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

									if (switchElement3.size() != 0) {

									switchElement3.get(0).findElement(By.cssSelector("span.switch-right")).click();
									System.out.println("'Allow user to comment on uploaded media' set to ON");
															} 
														else
							System.out.println("The Switch for  Allow user to comment on uploaded media  is already ON");
			((PhantomJSDriver) wdAdmin).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/OtherRoles/Functional/Enable users liked media page 04.png');");					
// Enable likes for Media			
			List<WebElement> switchElement4 = wdAdmin.findElements(By
					.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-1\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

													if (switchElement4.size() != 0) {

														switchElement4.get(0).findElement(By.cssSelector("span.switch-right")).click();
														System.out.println("'Enable likes for Media' set to ON");
																				} 
																			else
												System.out.println("The Switch for Enable likes for media  is already ON");
							((PhantomJSDriver) wdAdmin).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/OtherRoles/Functional/Enable users liked media page 05.png');");					
							// save the settings
							wdAdmin.findElement(By.id("rtmedia-settings-submit")).click();
							System.out.println("Settings saved");		
							
							
							
							Constants.logout(wdAdmin);
							
	// Log Out as Admin user
		
							
						  
						  // Phantom js : headless
	// Code to take screenshots
	Capabilities caps2 = new DesiredCapabilities();
	((DesiredCapabilities) caps2).setJavascriptEnabled(true);
	((DesiredCapabilities) caps2).setCapability("takesScreenshot", true);
	
	PhantomJSDriver wd = new PhantomJSDriver(caps);
	wd.manage().window().setSize(new Dimension(1920, 1080));
	wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	

	
	// Login to WordPress with other user roles :: Author , Editor , Contributor , Subscriber
	wd.get(Constants.WP_SERVER);
	Constants.login(wd, Constants.TestSubscriber, Constants.TestSubscriberPassword);
	 System.out.println("Correctly Logged In");
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/OtherRoles/Functional/Enable users liked media page Others 01.png');");
	// Go to Media Gallery

	//  Mouseover  on Profile (Howdy, admin) section , click on Media 

	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
	Thread.sleep(1000);
	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).click();
	wd.findElement(By.linkText("Media")).click();
	Thread.sleep(1000);
	
	// Upload Media  via PhantomJSDriver		
	// Upload Media in Gallery by clicking Upload button
		Thread.sleep(3000);
	
	
		wd.findElement(By.cssSelector(".rtmedia-upload-media-link")).click();
		
			
		System.out.println("rtMedia-upload-button Clicked");
		
		Thread.sleep(3000);
		
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/OtherRoles/Functional/Enable users liked media page Others 02.png');");
	
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
	
		
	System.out.println("Select Files Clicked");
		
	
((PhantomJSDriver) wd).executePhantomJS("var page=this; "
					+ "var count=0;" + "page.uploadFile('input[type=file]','"
					+ Constants.VideoPhantom + "');"					 
					+"page.render('./screen/OtherSettings/OtherRoles/Functional/Enable users liked media page Others 03.png');");

			Thread.sleep(5000); // Increase sleep for Music and Video uploads

	// click Start Upload button

				
		 wd.findElement(By.cssSelector("input.start-media-upload")).click();

		System.out.println("Start Media  Upload button clicked");
		Thread.sleep(10000); // Increase sleep for Music and Video uploads
			
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/OtherRoles/Functional/Enable users liked media page Others 04.png');");								
			

//Like the uploaded  Media
	
// Open a Media  to Like 

    wd.findElement(By.cssSelector("div.rtmedia-item-thumbnail > img")).click();
    System.out.println("Media Opened"); 
    ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/OtherRoles/Functional/Enable users liked media page Others 05.png');");	
// CLICK Like . Add a comment : Good Media  
    
new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.rtmedia-container.rtmedia-single-container"))).build().perform();
new Actions(wd).moveToElement(wd.findElement(By.cssSelector("button.rtmedia-like"))).build().perform();
  wd.findElement(By.cssSelector("button.rtmedia-like")).click();
  System.out.println("Like is present");
  Thread.sleep(4000);
  ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/OtherRoles/Functional/Enable users liked media page Others 06.png');");
    wd.findElement(By.id("comment_content")).click();
    wd.findElement(By.id("comment_content")).clear();
    wd.findElement(By.id("comment_content")).sendKeys("Good Media");
    wd.findElement(By.id("rt_media_comment_submit")).click();
    
    System.out.println("Good Media: Comment Added");   
    ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/OtherRoles/Functional/Enable users liked media page Others 07.png');");		    

//Check users Likes 	    

//Mouseover Profile ( Howdy , {username} section )
new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
Thread.sleep(4000);
// Mouseover and click on Media
new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).build().perform();

new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).click();
wd.findElement(By.linkText("Media")).click();
Thread.sleep(1000);


//Go to Likes Page

wd.findElement(By.id("rtmedia-nav-item-user-likes")).click();
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/OtherRoles/Functional/Enable users liked media page Others 08.png');");
Thread.sleep(1000);

//Check a liked Media 

wd.findElement(By.cssSelector("div.rtmedia-item-thumbnail > img")).click();

Thread.sleep(2000);


((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/OtherRoles/Functional/Enable users liked media page Others 09.png');");


// Log out

new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
wd.findElement(By.linkText("Log Out")).click();
wd.quit();
	
	
}
}
