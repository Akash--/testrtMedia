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

public class enableUsersLikedMediaPageTest {
	@Test(groups={"OtherSettings"})
//  Pro only feature 
public static void AdminUserLikes() throws Exception {
	// Login to WordPress
	
	// Phantom js : headless
		// Code to take screenshots
		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
		
		PhantomJSDriver wd = new PhantomJSDriver(caps);
		wd.manage().window().setSize(new Dimension(1920, 1080));
	//	wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		
		// Login to wordpress by admin account
		wd.get(Constants.WP_SERVER);
		Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
		 System.out.println("Correctly Logged In");
		 
	// Open rtMedia Settings 

  Constants.openrtMediaSettings(wd);
	
			
	// Click on rtMedia settings OtherSettings Tab

	wd.findElement(By.id("tab-rtmedia-general")).click();
			
	System.out.println("Other Settings  Tab Opened");
//Enable users liked media page			
	// Check if the switch is on or off, if its off then switch on and  proceed

	
	List<WebElement> switchElement = wd.findElements(By
.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-38\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

				if (switchElement.size() != 0) {

			switchElement.get(0).findElement(By.cssSelector("span.switch-right")).click();
			System.out.println("Enable users liked media page set to ON");
									} 
								else
	System.out.println("Enable users liked media page is already on");
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/LikesForadmin/Functional/Enable users liked media page 01.png');");					
				

	// save the Other settings
	wd.findElement(By.id("rtmedia-settings-submit")).click();
	
	// Check with Lightbox ON
	// Click on rtMedia settings Display  Tab

			wd.findElement(By.id("tab-rtmedia-display")).click();
			System.out.println("Display Settings opened ");

			// Check if the switch for Lightbox is on or off, if its off then switch on and  proceed
			
			List<WebElement> switchElement2 = wd.findElements(By
					.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-6\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

								if (switchElement2.size() != 0) {

								switchElement2.get(0).findElement(By.cssSelector("span.switch-right")).click();
								System.out.println("'Use lightbox to display media' set to ON");
														} 
													else
						System.out.println("The Switch for LightBox is already ON");
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/LikesForadmin/Functional/Enable users liked media page 02.png');");					
		
			
			/*//Check with  Lightbox Off
			// Click on rtMedia settings Display  Tab
			wd.findElement(By.id("tab-rtmedia-display")).click();
			System.out.println("Display Settings opened ");
			// Check if the Lightbox  switch in on or off, if its on then switch it off 
					List<WebElement> switchElement = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-6\"] > div.rt-switch.has-switch > div.switch-animate.switch-on"));

					if (switchElement.size() != 0) {

						switchElement.get(0).findElement(By.cssSelector("span.switch-left")).click();

					} else
						System.out.println("'Lightbox' is already off");
									
*/
			// save the settings
			wd.findElement(By.id("rtmedia-settings-submit")).click();
			System.out.println("Settings saved");
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/LikesForadmin/Functional/Enable users liked media page 03.png');");			
	// Make sure Allow user to comment on uploaded media  and Enable likes for media : ON  		
	
			// Go to display
			
			wd.findElement(By.id("tab-rtmedia-display")).click();
			System.out.println("Display Tab Opened");
			
			// Check if the switch is on or off, if its off then switch on and  proceed

			/*		boolean checkBox3 = wd.findElement(By.id("rt-form-checkbox-0")).isSelected();
			if (checkBox3 == false)
				wd.findElement(By.id("rt-form-checkbox-0")).click();
			else
				System.out.println("The Switch for  Allow user to comment on uploaded media  is already ON");*/
			
			List<WebElement> switchElement3 = wd.findElements(By
					.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-0\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

								if (switchElement3.size() != 0) {

								switchElement3.get(0).findElement(By.cssSelector("span.switch-right")).click();
								System.out.println("'Allow user to comment on uploaded media' set to ON");
														} 
													else
						System.out.println("The Switch for  Allow user to comment on uploaded media  is already ON");
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/LikesForadmin/Functional/Enable users liked media page 04.png');");					
			
			
/*			boolean checkBox4 = wd.findElement(By.id("rt-form-checkbox-1")).isSelected();
			if (checkBox4 == false)
				wd.findElement(By.id("rt-form-checkbox-1")).click();
			else
				System.out.println("The Switch for Enable likes for media  is already ON");*/
	
		//	Enable likes for Media						
	List<WebElement> switchElement4 = wd.findElements(By
	.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-1\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

									if (switchElement4.size() != 0) {

										switchElement4.get(0).findElement(By.cssSelector("span.switch-right")).click();
										System.out.println("'Enable likes for Media' set to ON");
																} 
															else
								System.out.println("The Switch for Enable likes for media  is already ON");
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/LikesForadmin/Functional/Enable users liked media page 05.png');");					
		
			
	/*// Negative Settings		
			//Allow user to comment on uploaded media  and Enable likes for media : OFF 
			List<WebElement> switchElement = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-0\"] > div.rt-switch.has-switch > div.switch-animate.switch-on"));

			if (switchElement.size() != 0) {

				switchElement.get(0).findElement(By.cssSelector("span.switch-left")).click();

			} else
				System.out.println("'Allow user to comment on uploaded media' is already off");
			
			//Disable Likes for Media
			List<WebElement> likesElement = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-1\"] > div.rt-switch.has-switch > div.switch-animate.switch-on"));

			if (likesElement.size() != 0) {

				likesElement.get(0).findElement(By.cssSelector("span.switch-left")).click();

			} else System.out.println("'Enable likes for media ' is already off");
*/					
			// save the settings
						wd.findElement(By.id("rtmedia-settings-submit")).click();
						System.out.println("Settings saved");
			// Do a mouse over on the primary menu on top LHS
			new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/LikesForadmin/Functional/Enable users liked media page 06.png');");
			Thread.sleep(1000);
			// Click on Visit Site

			wd.findElement(By.linkText("Visit Site")).click();
			Thread.sleep(1000);
			
		//  Mouseover  on Profile (Howdy, admin) section , click on Media 

			new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
			Thread.sleep(1000);
			new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).click();
			wd.findElement(By.linkText("Media")).click();
			Thread.sleep(1000);
			
	// Upload Media
	
			// Upload Media (Photo) in Gallery by clicking Upload button

			/*		
			wd.findElement(By.id("rtm_show_upload_ui")).click();

			wd.findElement(By.id("rtMedia-upload-button")).click();
			Thread.sleep(3000);
			Runtime.getRuntime().exec(Constants.Photo);

			Thread.sleep(4000);
			try{
			// click on Terms and Conditions .
			
			if (!wd.findElement(By.id("rtmedia_upload_terms_conditions")).isSelected()) {
				wd.findElement(By.id("rtmedia_upload_terms_conditions")).click();
			} 
	}catch(Throwable t) {
		System.out.println("T and C is rtMedia Pro only feature.");
	}
			// click Start Upload button
			wd.findElement(By.cssSelector("input.start-media-upload")).click();
	Thread.sleep(8000); 
				System.out.println("Media Uploaded.");
			wd.navigate().refresh();*/
			
			
			// Upload Media  via PhantomJSDriver		
			// Upload Media in Gallery by clicking Upload button
				Thread.sleep(3000);
			
			
				wd.findElement(By.cssSelector(".rtmedia-upload-media-link")).click();
				
					
				System.out.println("rtMedia-upload-button Clicked");
				
				Thread.sleep(3000);
				
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/LikesForadmin/Functional/Enable users liked media page 06.png');");
			
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
							+ Constants.PhotoPhantom + "');"					 
							+"page.render('./screen/OtherSettings/LikesForadmin/Functional/EnableMediaInProfile06.png');");
					Thread.sleep(6000); // Increase sleep for Music and Video uploads

			// click Start Upload button

						
				 wd.findElement(By.cssSelector("input.start-media-upload")).click();

				System.out.println("Start Media  Upload button clicked");
				Thread.sleep(10000); // Increase sleep for Music and Video uploads
					
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/LikesForadmin/Functional/Enable users liked media page 07.png');");								
					

    //Like the uploaded  Media
			
	 // Open a Media  to Like 
	
		    wd.findElement(By.cssSelector("div.rtmedia-item-thumbnail > img")).click();
		    System.out.println("Media Opened"); 
		    ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/LikesForadmin/Functional/Enable users liked media page 08.png');");	
		// CLICK Like . Add a comment : Good Media  
		    
new Actions(wd).moveToElement(wd.findElement(By.cssSelector("div.rtmedia-container.rtmedia-single-container"))).build().perform();
  new Actions(wd).moveToElement(wd.findElement(By.cssSelector("button.rtmedia-like"))).build().perform();
		  wd.findElement(By.cssSelector("button.rtmedia-like")).click();
		  Thread.sleep(4000);
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/LikesForadmin/Functional/Enable users liked media page 09.png');");
	        wd.findElement(By.id("comment_content")).click();
	        wd.findElement(By.id("comment_content")).clear();
	        wd.findElement(By.id("comment_content")).sendKeys("Good Media");
	        wd.findElement(By.id("rt_media_comment_submit")).click();
		    
	        System.out.println("Good Media: Comment Added");   
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/LikesForadmin/Functional/Enable users liked media page 10.png');");		    

// Check users Likes 	    

// Mouseover Profile ( Howdy , {username} section )
	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
	 Thread.sleep(4000);
	// Mouseover and click on Media
	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).build().perform();
	
	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).click();
	wd.findElement(By.linkText("Media")).click();
	Thread.sleep(1000);
	
	
// Go to Likes Page
	
wd.findElement(By.id("rtmedia-nav-item-user-likes")).click();
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/LikesForadmin/Functional/Enable users liked media page 11.png');");
Thread.sleep(6000);

// Check a liked Media 

wd.findElement(By.cssSelector("div.rtmedia-item-thumbnail > img")).click();

Thread.sleep(7000);
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/LikesForadmin/Functional/Enable users liked media page 12.png');");

	
 // Log out
	
	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
	wd.findElement(By.linkText("Log Out")).click();
  wd.quit();
}


}
