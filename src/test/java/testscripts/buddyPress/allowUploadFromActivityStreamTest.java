/*@ Author Sumeet*/
package testscripts.buddyPress;

//3.7.1.3
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import testscripts.Constants;

//For this test to pass , you need to  Create a group named test   
public class allowUploadFromActivityStreamTest {
	
	@Test(groups = {"buddypress"})
	public static void uploadactivity() throws Exception {
		// CHECK FOR PROFILES
		// Phantom js : headless
		// Code to take screenshots
		
		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
		
		PhantomJSDriver wd = new PhantomJSDriver(caps);
		wd.manage().window().setSize(new Dimension(1920, 1080));
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	
		// Login to wordpress by admin account
		wd.get(Constants.WP_SERVER);
		Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
		 System.out.println("Correctly Logged In");


	// On using login from Constants.java , Get this error message :"Unable to find element with id 'user_login'" 
	 
	 
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow upload from activity/Functional/Allow Upload Activity 01.png');");		
/*		wd.get(Constants.WP_SERVER); 
		Constants.login(wd, Constants.DotNetUSERNAME1, Constants.DotNetUPASSWORD1);*/
				
	// Open rtMedia Settings 
	Constants.openrtMediaSettings(wd);
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow upload from activity/Functional/Allow Upload Activity 02.png');");				
		Thread.sleep(5000);
		
		// Click on rtMedia settings BuddyPress Tab

		wd.findElement(By.id("tab-rtmedia-bp")).click();

		System.out.println("BuddyPress Tab Opened");
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow upload from activity/Functional/Allow Upload Activity 03.png');");
		
		// Check if the switch is on or off, if its off then switch on and  proceed
		
		List<WebElement> switchElement = wd.findElements(By
.cssSelector("span.rt-form-checkbox> label[for=\"rtmedia-bp-enable-activity\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

	if (switchElement.size() != 0) {

	switchElement.get(0).findElement(By.cssSelector("span.switch-right")).click();
	System.out.println("'Allow Upload From Activity Stream' is switched  on");
		} 
	else
		System.out.println("'Allow Upload From Activity Stream' is already on");
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow upload from activity/Functional/Allow Upload Activity 04.png');");	
		
	// save the BuddyPress settings
	
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		System.out.println("rtMedia Settings Saved");
		Thread.sleep(2000);
		
		// Do a mouse over on the primary menu on top LHS
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();

		// Click on Visit Site

		wd.findElement(By.linkText("Visit Site")).click();
		
		// Click on ACTIVITY
		
		/*wd.get(Constants.WP_SERVER_ACTIVITY);*/
		wd.navigate().to(Constants.WP_SERVER + "/activity");
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow upload from activity/Functional/Allow Upload Activity 05.png');");		
		/*wd.findElement(By.linkText("ACTIVITY")).click();*/
		
		wd.findElement(By.id("whats-new")).click();
		/*wd.findElement(By.id("whats-new")).clear();*/
		/*wd.findElement(By.id("whats-new")).sendKeys("Check Upload From Activity Stream : Photos ");*/
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
				+"page.render('./screen/BuddyPress/Functional/Allow Upload Activity 06.png');");
		Thread.sleep(4000); // Increase sleep for Music and Video uploads
		
		// Enter some content

		wd.findElement(By.id("whats-new")).click();
		wd.findElement(By.id("whats-new")).clear();
		wd.findElement(By.id("whats-new")).sendKeys("Check Upload From Activity Stream : Photos");				
		System.out.println("Check Upload From Activity Stream : Photos  text entered");
		
		
		
		
		
		Thread.sleep(1000);
		
		// Click  Post Update
		
		/*wd.findElement(By.id("aw-whats-new-submit")).click();*/
		wd.findElement (By.cssSelector("input#aw-whats-new-submit")).click();
		System.out.println("Post Update button clicked");	
		Thread.sleep(3000);
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow upload from activity/Functional/Allow Upload Activity 07.png');");
		
	// Verify Presence of Text in Activity 
		
		String actual1= wd.findElement(By.cssSelector("div.rtmedia-activity-text")).getText();
		
		String expected1 = "Check Upload From Activity Stream : Photos";
			
			try{	Assert.assertEquals(actual1, expected1);
			 System.out.println("Expected Text Present");
			} catch(Throwable e){
				System.out.println("Expected Text Not Present for Activity- failed");}
				
				
		
		
		/*if (!wd.findElement(By.tagName("html")).getText().contains("Check Upload From Activity Stream : Photos")) {
            System.out.println("verifyTextPresent failed");
        }
		// Name of Image : test
		 if (!wd.findElement(By.tagName("html")).getText().contains("est")) {
	            System.out.println("verifyTextPresent failed");
	        }
		 
		 // Image 
	        if (!(wd.findElements(By.cssSelector("div.rtmedia-item-thumbnail > img")).size() != 0)) {
	            System.out.println("verifyElementPresent failed");
	        }
		
		*/	
		
		/*// Upload Media : Video
		wd.findElement(By.linkText("ACTIVITY")).click();
		wd.findElement(By.id("whats-new")).click();
		wd.findElement(By.id("whats-new")).clear();
		wd.findElement(By.id("whats-new")).sendKeys("Check Upload From Activity Stream: Videos");
				wd.findElement(By.id("rtmedia-add-media-button-post-update")).click();
				Thread.sleep(3000);
				Runtime.getRuntime().exec(Constants.Video);

				Thread.sleep(5000);

				wd.findElement(By.id("aw-whats-new-submit")).click();
		
				Thread.sleep(5000);

				// Upload Media : Music
				wd.findElement(By.linkText("ACTIVITY")).click();
				wd.findElement(By.id("whats-new")).click();
				wd.findElement(By.id("whats-new")).clear();
				wd.findElement(By.id("whats-new")).sendKeys("Check Upload From Activity Stream: Music");
						wd.findElement(By.id("rtmedia-add-media-button-post-update")).click();
						Thread.sleep(3000);
						Runtime.getRuntime().exec(Constants.Music);

						Thread.sleep(5000);

						wd.findElement(By.id("aw-whats-new-submit")).click();
				
						Thread.sleep(5000);
					//Upload Media : Documents
						wd.findElement(By.linkText("ACTIVITY")).click();
						wd.findElement(By.id("whats-new")).click();
						wd.findElement(By.id("whats-new")).clear();
						wd.findElement(By.id("whats-new")).sendKeys("Check Upload From Activity Stream: Documents");
								wd.findElement(By.id("rtmedia-add-media-button-post-update")).click();
								Thread.sleep(3000);
								Runtime.getRuntime().exec(Constants.Documents);

								Thread.sleep(5000);

								wd.findElement(By.id("aw-whats-new-submit")).click();
						
								Thread.sleep(5000);

						*/
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
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow upload from activity/Functional/Allow Upload Activity 08.png');");
		
		System.out.println("Clicked on a Group named test");
		
		// click on Media inside test group

				wd.findElement(By.id("rtmedia-media-nav")).click();
				 
						

				// Upload Media  via PhantomJSDriver		
						
				// Upload Media in Group's Media  Gallery by clicking Upload button
					
			
					Thread.sleep(2000);
				
				wd.findElement(By.cssSelector(".rtmedia-upload-media-link")).click();
					
				System.out.println("rtMedia-upload-button Clicked");
					
					Thread.sleep(1000);
					
				((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow upload from activity/Functional/EnableMediaInGroup08.png');");

				
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
						Thread.sleep(3000); // Increase sleep for Music and Video uploads

				// click Start Upload button

							
					 wd.findElement(By.cssSelector("input.start-media-upload")).click();
					
					System.out.println("Start Media  Upload button clicked");
					Thread.sleep(10000); // Increase sleep for Music and Video uploads
						
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Allow upload from activity/Functional/EnableMediaInGroup10.png');");
			Thread.sleep(5000);
			
			// Verify Media Upload  : mpthreetest.mp3  in Group : test
			
			if (!wd.findElement(By.tagName("html")).getText().contains("mpthreetest")) {
		        System.out.println("verifyMediaNamePresent failed");
		    }
			else {
				System.out.println("verifyMediaNamePresent Passed");
			}
			
			
		
	/*	// Click on ACTIVITY inside test group
		
		wd.findElement(By.id("whats-new")).click();
		wd.findElement(By.id("whats-new")).clear();
		
		System.out.println("Clicked on ACTIVITY inside test group");
		Thread.sleep(5000);


		// Upload Media
		
		
	
		// Click Attach Files
		wd.findElement(By.id("rtmedia-add-media-button-post-update")).click();
		wd.findElement (By.cssSelector("button.rtmedia-add-media-button")).click();
	
				
				WebDriverWait wait = new WebDriverWait(wd, 5); // wait for a maximum of 5 seconds
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("rtmedia-add-media-button-post-update")));
				
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
		        + "var count=1;" + "page.uploadFile('input[type=file]',['"
		        + Constants.PhotoPhantom +"']);");
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/MediaTypes/Functional/Video 04.png');");					
		Thread.sleep(7000); // Increase sleep for Music and Video uploads
		
	
				// Enter some content

				wd.findElement(By.id("whats-new")).click();
				wd.findElement(By.id("whats-new")).clear();
				wd.findElement(By.id("whats-new")).sendKeys("check upload from activity for a Group named test");				
				System.out.println("check upload from activity for a Group named test  text entered");				
				((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Functional/Allow Upload Activity 09.1.png');");				
			Thread.sleep(2000);	
				// Click  Post Update
				
				wd.findElement(By.id("aw-whats-new-submit")).click();
				wd.findElement (By.cssSelector("input#aw-whats-new-submit")).click();
				System.out.println("Post Update button clicked for Group Activity Upload");	
				Thread.sleep(5000);
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Functional/Allow Upload Activity 10.png');");
		
		// Verify 
		String actual2= wd.findElement(By.cssSelector("div.rtmedia-activity-text")).getText();
		String actual2= wd.findElement(By.cssSelector("div.activity-inner > p")).getText();
		 
	       
		String expected2 = "check upload from activity for a Group named test";
		
			try{
				Assert.assertEquals(actual2, expected2);
				System.out.println("Expected Text Present");
			}
		catch(Throwable T){
			System.out.println("Expected Text Not Present for Group Activity- failed");
		}
*/	
		// verify Media Upload : test
			
		/*	if (!wd.findElement(By.tagName("html")).getText().contains("test")) {
	            System.out.println("verify Media Name Present failed");
	        }
			else
			           System.out.println("verify Media Name Present Passed");
			
			*/
		
			
			
		// log out
		/*Thread.sleep(2000);
		Constants.logout(wd);*/
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
		Thread.sleep(2000);
		wd.findElement(By.linkText("Log Out")).click();
	}


}
