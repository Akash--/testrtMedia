package testscripts.display;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import testscripts.Constants;

public class DisplayTagsForAudioFilesTest {
	
	
	@Test(groups = { "Display" })
	public static void checkDisplayTagsForAudio() throws Exception 
	{
		
		
		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);

		PhantomJSDriver wd;
		wd = new PhantomJSDriver(caps);
		wd.manage().window().setSize(new Dimension(1920, 1080));

		//wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Login to wordpress by admin account
		wd.get(Constants.WP_SERVER);
		Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
		 System.out.println("Correctly Logged In");
		 
		 Constants.openrtMediaSettings(wd);

		wd.findElement(By.id("tab-rtmedia-display")).click();
		System.out.println("display clicked");
		
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Tags/Functional/displayfilesTest1.png');");	
		 
		Thread.sleep(1000);

		List<WebElement> table = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-10\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));
	///	System.out.println("Views size:" + table.size());
		if (table.size() != 0){

			table.get(0).findElement(By.cssSelector("span.switch-right")).click();
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Tags/Functional/displayfilesTest2.png');");	

				
		}
		
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		
		System.out.println("rtMedia Settings Saved");
		
	
		//Do a mouse over on the primary menu on top LHS
				new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
		Thread.sleep(1000);

				// Click on Visit Site

				wd.findElement(By.linkText("Visit Site")).click();
				
				
				// Navigate to Media gallery
				
			//  Mouseover  on Profile (Howdy, admin) section , click on Media 

							new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
							Thread.sleep(1000);
							new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).build().perform();
							wd.findElement(By.linkText("Music")).click();
							
							System.out.println("Reached Music Gallery ");			
							Thread.sleep(1500);
							// directly going to clicked in mp3 
							//wd.findElement(By.cssSelector("#\37 12 > a > div.rtmedia-item-title > h4")).click();
							
								wd.findElement(By.cssSelector("#rtm_show_upload_ui")).click();
								Thread.sleep(2000);
								wd.findElement(By.cssSelector("#rtMedia-upload-button")).click();
								
								
								((PhantomJSDriver) wd).executePhantomJS("var page=this; "
										+ "var count=0;" + "page.uploadFile('input[type=file]','"
										+ Constants.LargeMusic+ "');"					 
										+"page.render('./screen/Display/Tags/Functional/displayfilesintablestyleTest3.png');");	
								Thread.sleep(2000);
								
								
							//	wd.findElement(By.cssSelector("#rtmedia_upload_terms_conditions")).click();
								
								wd.findElement(By.cssSelector("#drag-drop-area > input")).click();
								System.out.println("uploading");
								Thread.sleep(95000);
								wd.navigate().refresh();
								Thread.sleep(2000);
								((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Tags/Functional/uploadMediaTest2.png');");	
							
             
							
	                         Thread.sleep(2000);
	                         wd.findElement(By.partialLinkText("SukoonMila")).click();
							    System.out.println("clicked on mp3 Media");
							    
	                         Thread.sleep(2000);
	                         
	                         
	             			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Tags/Functional/displayfilesintablestyleTest4.png');");	
	             	if(	wd.findElement(By.cssSelector("#item-body > div.rtmedia-container.rtmedia-single-container > div > div.rtmedia-single-meta.columns.large-12 >"
	             				+ " div.rtmedia-actions-before-description.rt-clear > div.rtmedia-media-tags-head")).isDisplayed())
	             	{
	             		System.out.println("Audio Tag is present");
	             		System.out.println("info about media");
	             		System.out.println("-------------------------------------------");
	             		System.out.println(wd.findElement(By.cssSelector("#item-body > div.rtmedia-container.rtmedia-single-container > div > div.rtmedia-single-meta.columns.large-12 > div.rtmedia-actions-before-description.rt-clear > div.rtmedia-media-tags")).getText());
	             		System.out.println("-------------------------------------------");
	             		System.out.println("Test Pass");
	             	}
	
         			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Tags/Functional/displayfilesintablestyleTest5.png');");	

         			Constants.logout(wd);
	
	}
}
