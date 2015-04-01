package testscripts.mediaTypes;

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
// check this with rtcamp.net sites or .com . Preview of docs won't be available at xampp local installations, could be viewed by clicking view original while using lightbox
public class DocumentTest {
	@Test(groups = {"MediaTypes"})
	public static void document() throws Exception {
		
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
	
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/MediaTypes/Document/Functional/Document 01.png');");		
/*		// Login to WordPress with user role : Administrator
		wd.get(Constants.WP_SERVER); 
		Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
		Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);*/
		
		// Open rtMedia Settings 
		Constants.openrtMediaSettings(wd);
		
		
		// Allow upload from Activity Stream must be ON
		// Click on rtMedia settings BuddyPress Tab

				wd.findElement(By.id("tab-rtmedia-bp")).click();

				System.out.println("BuddyPress Tab Opened");
		
				// Check if the switch is on or off, if its off then switch on and  proceed
			
List<WebElement> switchElement = wd.findElements(By
.cssSelector("span.rt-form-checkbox> label[for=\"rtmedia-bp-enable-activity\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

			if (switchElement.size() != 0) {

			switchElement.get(0).findElement(By.cssSelector("span.switch-right")).click();
			System.out.println("'Allow Upload From Activity Stream' is switched  on");
				} 
			else
				System.out.println("'Allow Upload From Activity Stream' is already on");
					
			
			wd.findElement(By.id("rtmedia-settings-submit")).click();
			System.out.println("Settings saved");			
		// click on Types 
				
				wd.findElement(By.id("tab-rtmedia-types")).click();

				System.out.println("Types  Tab Opened");
				
			
				// Documents  (txt, doc, docx, xls, xlsx, ppt, pptx, pdf, xps, pages)
				
// Check if the switch for Allow Documents Upload is on or off, if its off then switch it to on and proceed
				
List<WebElement> switchElement2 = wd.findElements(By
.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-24\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

			if (switchElement2.size() != 0) {

			switchElement2.get(0).findElement(By.cssSelector("span.switch-right")).click();
			System.out.println("'The setting for enabling Documents' is switched  on");
				} 
			else
				System.out.println("The Switch for enabling Documents  is already ON");
			
				
				// save the settings Form
				wd.findElement(By.id("rtmedia-settings-submit")).click();
				System.out.println("Settings saved");
				Thread.sleep(2000);		
		
				// Do a mouse over on the primary menu on top LHS
				new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
				
				// Click on Visit Site

				wd.findElement(By.linkText("Visit Site")).click();
				
				// Click on ACTIVITY
				wd.navigate().to(Constants.WP_SERVER + "/activity");
				/*wd.get(Constants.WP_SERVER_ACTIVITY);*/
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/MediaTypes/Document/Functional/Document 1.png');");		
							
				wd.findElement(By.id("whats-new")).click();
			
				Thread.sleep(2000);
				System.out.println(" Clicked Activity");
					
				
				// Upload Media : Document
				
				// Click Attach Files
				
				wd.findElement (By.cssSelector("button.rtmedia-add-media-button")).click();
				
				Thread.sleep(3000);
				System.out.println("Attach Files Clicked");
						
			/*	((PhantomJSDriver) wd).executePhantomJS("var page=this; "
						+ "var count=0;" + "page.uploadFile('input[type=file]','"
						+ Constants.DocumentPhantom + "');"					 
						+"page.render('./screen/MediaTypes/Functional/Document.png');");
				 	*/

/*((PhantomJSDriver) wd).executePhantomJS("var page=this; "
                + "var count=0;" + "page.uploadFile('input[type=file]',['"
                + Constants.DocumentPhantom +"','"+Constants.PhotoPhantom+"']);");*/
// Multiple Documents
((PhantomJSDriver) wd).executePhantomJS("var page=this; "
        + "var count=0;" + "page.uploadFile('input[type=file]',['"
        + Constants.DocumentPhantom +"','"+Constants.Document+"']);");

/*	((PhantomJSDriver) wd).executePhantomJS("var page=this; "
+ "var count=0;" + "page.uploadFile('input[type=file]','"
+ Constants.PhotoPhantom2 + "');");		*/			 

// Testing multiple paths in one string
	/* ((PhantomJSDriver) wd).executePhantomJS("var page=this; "
			 + "var count=0;" + "page.uploadFile('input[type=file]',["
			 + Constants.PhotoPhantom2 + "]');");
*/
				Thread.sleep(4000); // Increase sleep for Music and Video uploads
				
				// Enter some content

				wd.findElement(By.id("whats-new")).click();
				wd.findElement(By.id("whats-new")).clear();
				wd.findElement(By.id("whats-new")).sendKeys("Check Documents ");				
				System.out.println("Check Documents  text entered");	
				Thread.sleep(4000);
				
				// Click  Post Update
				
				wd.findElement (By.cssSelector("input#aw-whats-new-submit")).click();
				System.out.println("Post Update button clicked");	
				Thread.sleep(6000);
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/MediaTypes/Document/Functional/Document2.png');");

				
/*				
				// Click on ACTIVITY
				wd.findElement(By.linkText("ACTIVITY")).click();
				wd.findElement(By.id("whats-new")).click();
				wd.findElement(By.id("whats-new")).clear();
				wd.findElement(By.id("whats-new")).sendKeys("Check  Media Type : Document");
				
				// Upload Media

				wd.findElement(By.id("rtmedia-add-media-button-post-update")).click();
				Thread.sleep(3000);
				
				Runtime.getRuntime().exec(Constants.Documents);

				Thread.sleep(5000);

				wd.findElement(By.id("aw-whats-new-submit")).click();
*/				Thread.sleep(5000);
				/*wd.navigate().refresh();*/
				Thread.sleep(10000);
				
	// Verify Documents added
				
				  if (!wd.findElement(By.tagName("html")).getText().contains("document1")) {
			            System.out.println("verifyTextPresent failed");
			        }
			        /*wd.navigate().back();*/
			        if (!wd.findElement(By.tagName("html")).getText().contains("testdoc")) {
			            System.out.println("verifyTextPresent failed"); }
				// log out
				Constants.logout(wd);
			
				
	}
}
