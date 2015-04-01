package testscripts.defaultAlbums;


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
// Enable Media in Profile Must be ON
public class defaultAlbumsSettingsTest {
	@Test
	public static void defaultAlbumsSetting() throws Exception {
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
		
		// Click on rtMedia settings Default Album Tab
		
		wd.findElement(By.id("tab-rtmedia-global-albums")).click();
		// Enter a new album name
		wd.findElement(By.name("rtmedia-options[new_global_album]")).sendKeys(Constants.AlbumName);
		//Thread.sleep(2000);
/*		// Click on Add button for creating the album
		wd.findElement(By.name("rtmedia-options[add_new_global_album]")).click();
		Thread.sleep(4000);
		System.out.println("A new album added");*/
		// Select Radio Button
// Failing 
	/*	wd.findElement(
	By.xpath("//div[1]/div[3]/div[2]/div[1]/div[3]/div[3]/div[1]/form/div/div[1]/div[1]/div/div[5]/div/div[3]/div/table/tbody/tr[1]/td[4]/input"))
				.click();*/
	
		/*// Store all the elements of same category in the list of WebLements	
 
 List<WebElement>  oRadioButton = wd.findElements(By.name("rtmedia-options[default_global]"));
 
 // Create a boolean variable which will hold the value (True/False)
 
 boolean bValue = false;
 
 // This statement will return True, in case of first Radio button is selected
 
 bValue = oRadioButton.get(0).isSelected();
 
 // This will check that if the bValue is True means if the first radio button is selected
 
 if(bValue = true){
 
	// This will select Second radio button, if the first radio button is selected by default
 
	oRadioButton.get(1).click();
 
 }else{
 
	// If the first radio button is not selected by default, the first will be selected
 
	oRadioButton.get(0).click();
 
 }
		
*/	
// Choose an existing default ALbum
 // WallPosts in this case 
 wd.findElement(By.id("default_album_radio_1")).click();
 
 
		
	
		// Click on save setting button
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		
//Thread.sleep(2000);

// Enable Media in Profile too
wd.findElement(By.id("tab-rtmedia-bp")).click();

System.out.println("BuddyPress Tab Opened");


List<WebElement> switchElement = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-15\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

/*System.out.println("switch size:"+switchElement.size());*/
if (switchElement.size() != 0) {

	switchElement.get(0).findElement(By.cssSelector("span.switch-right")).click();
			System.out.println("'Enable Media in Profile ' is switched  on");
				} else
					System.out.println("'Enable Media in Profile' is already on");
//Enable Terms and Conditions 

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



//Click on save setting button
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		
//Do a mouse over on the primary menu on top LHS
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
Thread.sleep(1000);

		// Click on Visit Site

		wd.findElement(By.linkText("Visit Site")).click();
		
		
		// Navigate to Media gallery
		
	//  Mouseover  on Profile (Howdy, admin) section , click on Media 

					new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
					//Thread.sleep(1000);
					new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).click();
					wd.findElement(By.linkText("Media")).click();
					
					System.out.println("Reached Media Gallery ");			
					Thread.sleep(1500);
					
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/defaultAlbumsSettings/Functional/EnableMediaInProfile01.png');");
		
		
		// Upload Media  via PhantomJSDriver		
		// Upload Media in Gallery by clicking Upload button
	//		Thread.sleep(3000);
		
		
			wd.findElement(By.cssSelector(".rtmedia-upload-media-link")).click();
			
				
			System.out.println("rtMedia-upload-button Clicked");
			
			Thread.sleep(1000);
			
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/defaultAlbumsSettings/Functional/EnableMediaInProfile02.png');");
		
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
						+"page.render('./screen/BuddyPress/Functional/EnableMediaInProfile06.png');");
				Thread.sleep(11000); // Increase sleep for Music and Video uploads

		// click Start Upload button

					
			 wd.findElement(By.cssSelector("input.start-media-upload")).click();

			System.out.println("Start Media  Upload button clicked");
			Thread.sleep(10000); // Increase sleep for Music and Video uploads
				
					
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/defaultAlbumsSettings/Functional/EnableMediaInProfile03.png');");
	Thread.sleep(5000);

	// Verify Media : test.jpg uploaded in default album : Wall Posts
		
	// Go to ALbums 
	
	 /*wd.findElement(By.linkText("Albums")).click();*/
	// Mouseover on Media 
	
	/*new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).build().perform();
	Thread.sleep(2000);
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Functional/Allow User to Create Albums06.png');");				
// Mouseover and click  Albums 
	new Actions(wd).moveToElement(wd.findElement(By.linkText("Albums"))).build().perform();
    wd.findElement(By.linkText("Albums")).click();				
System.out.println("Albums opened") ; 

Thread.sleep(6000);*/
	// Click on Profile (Howdy, admin) section

			wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item")).click();

			// click on Media
			wd.findElement(By.id("user-media")).click();

			// click on Albums. You will find Albums List
			wd.findElement(By.id("rtmedia-nav-item-albums")).click();
			//Thread.sleep(3000);

// Click on default Album : Wall Posts selected during settings

if (!wd.findElement(By.tagName("html")).getText().contains("Wall Posts")) {
    System.out.println("verifyTextPresent failed");
}

wd.findElement(By.cssSelector("#item-body > div.rtmedia-container > ul > li:nth-child(1) > div.rtmedia-item-thumbnail > a > img")).click();


// Verify presence of Uploaded Media 
	if (!wd.findElement(By.tagName("html")).getText().contains("test")) {
	    System.out.println("verifyTextPresent failed");
	}
	else {
		System.out.println("verifyMediaNamePresent Passed");
	}
			
	// log out
	Constants.logout(wd);
	}
}


/*package testscripts.defaultAlbums;

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

public class defaultAlbumsSettings {
	@Test
	public static void defaultAlbumsSetting() throws Exception {
		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
		
		PhantomJSDriver wd = new PhantomJSDriver(caps);
		wd.manage().window().setSize(new Dimension(1920, 1080));
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	

		// Login to Wordpress
		wd.get(Constants.WP_SERVER);
		wd.findElement(By.linkText("Log in")).click();
		wd.findElement(By.id("user_login")).click();
		wd.findElement(By.id("user_login")).clear();
		wd.findElement(By.id("user_login")).sendKeys(Constants.USERNAME1);
		wd.findElement(By.id("user_pass")).click();
		wd.findElement(By.id("user_pass")).clear();
		wd.findElement(By.id("user_pass")).sendKeys(Constants.UPASSWORD1);
		wd.findElement(By.id("wp-submit")).click();
		System.out.println("Logged in");
		Thread.sleep(2000);
	
		// Open rtMedia Settings 
		Constants.openrtMediaSettings(wd);
		
		// Click on rtMedia settings Default Album Tab
		
		wd.findElement(By.id("tab-rtmedia-global-albums")).click();
		// Enter a new album name
		wd.findElement(By.name("rtmedia-options[new_global_album]")).sendKeys(Constants.AlbumName);
		Thread.sleep(2000);
		// Click on Add button for creating the album
		wd.findElement(By.name("rtmedia-options[add_new_global_album]")).click();
		Thread.sleep(2000);
		System.out.println("A new album added");
		// Select Radio Button
// Failing 
		wd.findElement(
	By.xpath("//div[1]/div[3]/div[2]/div[1]/div[3]/div[3]/div[1]/form/div/div[1]/div[1]/div/div[5]/div/div[3]/div/table/tbody/tr[1]/td[4]/input"))
				.click();
		
				wd.findElement(
		By.xpath("/html/body/div/div[3]/div[2]/div[1]/div[2]/div[3]/div[1]/form/div/div[1]/div[1]/div/div[5]/div/div[3]/div/table/tbody/tr[1]/td[4]/input"))
					.click();
					
		
		// Try this
		
		List<WebElement> RadButtonList = wd.findElements(By.name("rtmedia-options[default_global]"));

		// select first radio button
		RadButtonList.get(0).click();	
		
	
		
		// Click on save setting button
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		

		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item")))
		.build().perform();
		Thread.sleep(1000);
		
		wd.findElementByLinkText("Visit Site").click();
		Thread.sleep(2000);
		
		wd.navigate().to(Constants.WP_SERVER +"/activity");

			System.out.println("Reached Activity");
		// Click Attach Files
		
		wd.findElement (By.cssSelector("button.rtmedia-add-media-button")).click();
		
		Thread.sleep(3000);
		System.out.println("Attach Files Clicked");
				
		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "var count=0;" + "page.uploadFile('input[type=file]','"
				+ Constants.PhotoPhantom + "');"					 
				+"page.render('./screen/BuddyPress/Functional/Default Albums.png');");
		Thread.sleep(4000); // Increase sleep for Music and Video uploads
		
		// Enter some content

		wd.findElement(By.id("whats-new")).click();
		wd.findElement(By.id("whats-new")).clear();
		wd.findElement(By.id("whats-new")).sendKeys("Media Upload");				
		System.out.println("Media upload");	
		Thread.sleep(4000);
		
		// Click  Post Update
		
		
		wd.findElement (By.cssSelector("input#aw-whats-new-submit")).click();
		System.out.println("Post Update button clicked");	
		Thread.sleep(6000);
		
		
		
		
	 new Actions(wd) .moveToElement( wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item")))
		 .build().perform(); 
	 Thread.sleep(1000);
	 new Actions(wd).moveToElement( wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item")))
		 .build().perform();
	 Thread.sleep(1000); 
	 
		 new Actions(wd).moveToElement(wd.findElement(By.cssSelector(
		 "#wp-admin-bar-my-account-media-album > a.ab-item"))).click();
		 
		 wd.findElement(By.linkText("Albums")).click();
		 
		 wd.findElement(By.cssSelector("img[alt=\"My New Album\"]")).click();
		 wd.findElement(By.cssSelector("img[alt=\"test\"]")).click();
		 
		 
		 List imageElements=wd.findElements(By.cssSelector("img[alt=\"test\"]"));
		 
		if(imageElements.size()!=0)
			System.out.println("Image available");
		else
			System.out.println("Image not available");
		
		
	}
}
*/