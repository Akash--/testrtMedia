/*@ Author Sumeet*/

/* Done Assertion by AKASH*/
package testscripts.OtherSettings;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.Assert;
import org.testng.annotations.Test;

import testscripts.Constants;

public class enableFavListTest {
	@Test(groups={"OtherSettings"})
	// //  Pro only feature 
	// FavList is only for profiles
	  	
public static void FavList() throws Exception {
	
		// Phantom js : headless
				// Code to take screenshots
				Capabilities caps = new DesiredCapabilities();
				((DesiredCapabilities) caps).setJavascriptEnabled(true);
				((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
				
				PhantomJSDriver wd = new PhantomJSDriver(caps);
				wd.manage().window().setSize(new Dimension(1920, 1080));
				wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Fav/admin/Functional/FavList 01 .png');");

// Login to wordpress by admin account
wd.get(Constants.WP_SERVER);
Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
 System.out.println("Correctly Logged In");
 
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Fav/admin/Functional/FavList 02 .png');");				
		// Open rtMedia Settings 
		
		Constants.openrtMediaSettings(wd);
				
		// Click on rtMedia settings OtherSettings Tab

		wd.findElement(By.id("tab-rtmedia-general")).click();
		System.out.println("Other Settings  Tab Opened");

		// Check if the switch for FavList is on or off, if its off then switch on and  proceed

List<WebElement> switchElement = wd.findElements(By
.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-37\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

					if (switchElement.size() != 0) {

				switchElement.get(0).findElement(By.cssSelector("span.switch-right")).click();
				System.out.println("'Enable FavList ' is switched  on");
										} 
									else
				System.out.println("'The Switch for enable FavList is already ON'");
				
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
									
		// save the Other settings
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		System.out.println("Settings saved");
		Thread.sleep(2000);
	/*	//Check with  Lightbox ON
				// Click on rtMedia settings Display  Tab

						wd.findElement(By.id("tab-rtmedia-display")).click();
						System.out.println("Display Settings opened ");

						// Check if the switch for Lightbox is on or off, if its off then switch on and  proceed

						boolean checkBox2 = wd.findElement(By.id("rt-form-checkbox-6")).isSelected();
						if (checkBox2 == false)
							wd.findElement(By.id("rt-form-checkbox-6")).click();
						else
							System.out.println("The Switch for LightBox is already ON");

						// save the settings
						wd.findElement(By.id("rtmedia-settings-submit")).click();
						System.out.println("Settings saved");
						Thread.sleep(2000);
						Thread.sleep(5000);*/
		
		
		//Check with  Lightbox Off
		// Click on rtMedia settings Display  Tab
		wd.findElement(By.id("tab-rtmedia-display")).click();
		System.out.println("Display Settings opened ");
		// Check if the Lightbox  switch in on or off, if its on then switch it off 
				List<WebElement> switchElement3 = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-6\"] > div.rt-switch.has-switch > div.switch-animate.switch-on"));

				if (switchElement3.size() != 0) {

					switchElement3.get(0).findElement(By.cssSelector("span.switch-left")).click();

				} else
					System.out.println("'Lightbox' is already off");
				
		
		// save the settings
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		System.out.println("Settings saved");

		
		// Add Media to FavList 

		// Go to Media section
		System.out.println(" Add any Media Type  to any FavList . Then check the result in that Favlist");
		
		//  Mouseover  on Profile (Howdy, admin) section 

		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
		Thread.sleep(2000);
		
	// Mouseover Media
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).build().perform();
		// Click Media 
		wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item")).click();
		
		Thread.sleep(2000);
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Fav/admin/Functional/FavList 03 .png');");
	/*	// Upload Media (Photo) in Gallery by clicking Upload button
		
		
		wd.findElement(By.id("rtm_show_upload_ui")).click();

		wd.findElement(By.id("rtMedia-upload-button")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec(Constants.FavList);

		Thread.sleep(4000);
		try{
		// click on Terms and Conditions .
		
		if (!wd.findElement(By.id("rtmedia_upload_terms_conditions")).isSelected()) {
			wd.findElement(By.id("rtmedia_upload_terms_conditions")).click();
		} 
}catch(Throwable t) {
	System.out.println("rtMedia Pro only feature.");
}
		// click Start Upload button
		wd.findElement(By.cssSelector("input.start-media-upload")).click();
Thread.sleep(8000); 
			System.out.println("Media Uploaded. Now put that in FavList");
		wd.navigate().refresh();
				
	*/
		
		// Upload Media  via PhantomJSDriver		
		// Upload Media in Gallery by clicking Upload button
			Thread.sleep(3000);
		
		
			wd.findElement(By.cssSelector(".rtmedia-upload-media-link")).click();
			
				
			System.out.println("rtMedia-upload-button Clicked");
			
			Thread.sleep(3000);
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Fav/admin/Functional/FavList 01 .png');");			
		
		
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
						+ Constants.Photo2+ "');"					 
						+"page.render('./screen/OtherSettings/Functional/FavList 04.png');");
				Thread.sleep(4000); // Increase sleep for Music and Video uploads

		// click Start Upload button

					
			 wd.findElement(By.cssSelector("input.start-media-upload")).click();

			System.out.println("Start Media  Upload button clicked");
			Thread.sleep(5000); // Increase sleep for Music and Video uploads
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Fav/admin/Functional/FavList 05.png');");				
					
			
	/*	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("img[alt=\"testimage\"]"))).build().perform();
        wd.findElement(By.cssSelector("img[alt=\"testimage\"]")).click();*/
		
       
	   //Open uploaded Media   

	    wd.findElement(By.cssSelector("div.rtmedia-item-thumbnail > img")).click();
	    Thread.sleep(4000);
 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Fav/admin/Functional/FavList 06.png');");    
 //Thread.sleep(4000);
 System.out.println("Uploaded Media Opened");
 
 //
	new Actions(wd).moveToElement(wd.findElement(By.xpath("//span[@id='rtm-media-options-list']//button[.='Options']"))).build().perform();
	wd.findElement(By.xpath("//span[@id='rtm-media-options-list']//button[.='Options']")).click();
	    ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Fav/admin/Functional/FavList 07.png');");	    
	    new Actions(wd).moveToElement(wd.findElement(By.cssSelector("button.rtmedia-add-to-favlist"))).build().perform();
	    
	    wd.findElement(By.cssSelector("button.rtmedia-add-to-favlist")).click();
  ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Fav/admin/Functional/FavList 08.png');");   
	    /*new Actions(wd).moveToElement(wd.findElement(By.id("rtmedia-add-to-favlist-button-604"))).build().perform();*/
	    
	 // id of the testimage.jpg file will be used for Add to Favlist  too
	    /*wd.findElement(By.id("rtmedia-add-to-favlist-button-604")).click();   */
	    Thread.sleep(4000);

	      if (!wd.findElement(By.xpath("//span[@id='rtm-favlist-select']/select//option[2]")).isSelected()) {
	        wd.findElement(By.xpath("//span[@id='rtm-favlist-select']/select//option[2]")).click();
	    }
	    Thread.sleep(2000);
	    wd.findElement(By.id("rtm_favlist_name")).click();
	    wd.findElement(By.id("rtm_favlist_name")).clear();
	    wd.findElement(By.id("rtm_favlist_name")).sendKeys("Test Favlist");
	    ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Fav/admin/Functional/FavList 09.png');");    
	    Thread.sleep(4000);
	    wd.findElement(By.cssSelector("input.add-to-rtmp-favlist")).click();
	    Thread.sleep(4000);
                
		// Then check the result in that Favlist
	    //  Mouseover  on Profile (Howdy, admin) section 

			new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
			Thread.sleep(2000);
			
		// Mouseover Media
			new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).build().perform();
				
		Thread.sleep(1000);
			
// click on  FavList
wd.findElement(By.linkText("FavList")).click();
System .out.println("FavList Clicked");
Thread.sleep(4000);


// Open created FavList
//Assert.assertEquals("New Year Test Favlist",wd.findElement(By.cssSelector("div.rtmedia-item-thumbnail > a > img")).getText());
//String q=wd.findElement(By.cssSelector("div.rtmedia-item-thumbnail > a > img")).getText();
//System.out.println(q);
wd.findElement(By.cssSelector("div.rtmedia-item-thumbnail > a > img")).click();

System.out.println(wd.findElement(By.cssSelector("#rtm-gallery-title-container > h2")).getText());
Assert.assertEquals("Test Favlist", wd.findElement(By.cssSelector("#rtm-gallery-title-container > h2")).getText());
Thread.sleep(2000);
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Fav/admin/Functional/FavList 10.png');");
 Thread.sleep(1000);
 
		// Log out
		
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
		wd.findElement(By.linkText("Log Out")).click();
	  wd.quit();
	}

}