/*@ Author Sumeet*/
/*done assertion by akash*/
package testscripts.OtherSettings;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import testscripts.Constants;

public class enableFavListOtherRolesTest {
	@Test(groups={"OtherSettings"})
//  Pro only feature 

	public static void FavListOtherRoles() throws Exception {

// Phantom js : headless
				// Code to take screenshots
				Capabilities caps = new DesiredCapabilities();
				((DesiredCapabilities) caps).setJavascriptEnabled(true);
				((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
				
				PhantomJSDriver wd = new PhantomJSDriver(caps);
				wd.manage().window().setSize(new Dimension(1920, 1080));
				//wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
				
				// Login to wordpress by admin account
				wd.get(Constants.WP_SERVER);
				Constants.login(wd, Constants.TestSubscriber, Constants.TestSubscriberPassword);
				 System.out.println("Correctly Logged In");	
				((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Fav/other/Functional/FavListOtherRoles 01.png');");		
//  Mouseover  on Profile (Howdy, admin) section 

	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
	Thread.sleep(2000);
	
// Mouseover Media
	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).build().perform();
// Click Media 
	wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item")).click();
	
	Thread.sleep(2000);
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Fav/other/Functional/FavListOtherRoles 02.png');");
	
	// Upload Media  via PhantomJSDriver		
	// Upload Media in Gallery by clicking Upload button
		Thread.sleep(3000);
	
	
		wd.findElement(By.cssSelector(".rtmedia-upload-media-link")).click();
		
			
		System.out.println("rtMedia-upload-button Clicked");
		
		Thread.sleep(3000);
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Fav/other/Functional/FavList 01 .png');");			
	
	
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
					+"page.render('./screen/OtherSettings/Fav/Functional/FavListOtherRoles 03.png');");
			Thread.sleep(5000); // Increase sleep for Music and Video uploads
			
	// click Start Upload button

				
		 wd.findElement(By.cssSelector("input.start-media-upload")).click();

		System.out.println("Start Media  Upload button clicked");
		Thread.sleep(8000); // Increase sleep for Music and Video uploads
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Fav/other/Functional/FavListOtherRoles 04.png');");				
				
		
	
     //Open uploaded Media :  Trying with Css classes. Better than id 

    wd.findElement(By.cssSelector("div.rtmedia-item-thumbnail > img")).click();
    Thread.sleep(4000);
   ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Fav/other/Functional/FavListOtherRoles 05.png');");
  // Thread.sleep(4000);
   System.out.println("Uploaded Media Opened");
   ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Fav/other/Functional/FavListOtherRoles 06.png');");  
    //check for id of media file         
    /*new Actions(wd).moveToElement(wd.findElement(By.id("rtmedia-media-604"))).build().perform();*/
    new Actions(wd).moveToElement(wd.findElement(By.xpath("//span[@id='rtm-media-options-list']//button[.='Options']"))).build().perform();
    wd.findElement(By.xpath("//span[@id='rtm-media-options-list']//button[.='Options']")).click();
    
    new Actions(wd).moveToElement(wd.findElement(By.cssSelector("button.rtmedia-add-to-favlist"))).build().perform();
    
    wd.findElement(By.cssSelector("button.rtmedia-add-to-favlist")).click();
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
    wd.findElement(By.id("rtm_favlist_name")).sendKeys("Test Favlist for other");
    Thread.sleep(4000);
   ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Fav/other/Functional/FavListOtherRoles 07.png');"); 
    wd.findElement(By.cssSelector("input.add-to-rtmp-favlist")).click();
    Thread.sleep(4000);
          
         
	// Then check the result in that Favlist
    //  Mouseover  on Profile (Howdy, admin) section 

		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
		Thread.sleep(2000);
		
	// Mouseover Media
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).build().perform();
			
	Thread.sleep(1000);
		
//click on  FavList
wd.findElement(By.linkText("FavList")).click();
System .out.println("FavList Clicked");
Thread.sleep(4000);
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Fav/other/Functional/FavListOtherRoles 08.png');");
//Open created FavList 

wd.findElement(By.cssSelector("div.rtmedia-item-thumbnail > a > img")).click();

System.out.println(wd.findElement(By.cssSelector("#rtm-gallery-title-container > h2")).getText());
Assert.assertEquals("Test Favlist for other", wd.findElement(By.cssSelector("#rtm-gallery-title-container > h2")).getText());

//((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Fav/other/Functional/FavListOtherRoles 09.png');");
Thread.sleep(6000);
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Fav/other/Functional/FavListOtherRoles 09.png');");
		
		// Log out

		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
		wd.findElement(By.linkText("Log Out")).click();
		wd.quit();
	}

}