//@ author akash
package testscripts.display;

import java.awt.Button;
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
import org.testng.annotations.Test;

import testscripts.Constants;

public class EnableMusicPlaylistTest {
	
	@Test
	public static void checkEnableMusicPlaylist() throws Exception
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
	/*	 
		 Constants.openrtMediaSettings(wd);

		wd.findElement(By.id("tab-rtmedia-display")).click();
		System.out.println("display clicked");
		
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/BuddyPress/Functional/EnableMusicPlaylistTest0.png');");	
		 
		Thread.sleep(2000);
		
		
		List<WebElement> likes = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-8\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));
		
		if (likes.size() != 0){

			likes.get(0).findElement(By.cssSelector("span.switch-right")).click();
			Thread.sleep(1000);
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Functional/EnableMusictabTest1.png');");	

				
		}
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		
		System.out.println("rtMedia Settings Saved");
	*/	
		 Constants.logout(wd);
		
		
		//log in with another user.
		Capabilities caps2 = new DesiredCapabilities();
		((DesiredCapabilities) caps2).setJavascriptEnabled(true);
		((DesiredCapabilities) caps2).setCapability("takesScreenshot", true);

		PhantomJSDriver wd1 = new PhantomJSDriver(caps2);
		wd1.manage().window().setSize(new Dimension(1920, 1080));
		wd1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


		// Login to WordPress with other user roles :: Author , Editor , Contributor , Subscriber
		// Login to wordpress by as a TestEditor
				wd.get(Constants.WP_SERVER);
				Constants.login(wd, Constants.TestEditor, Constants.TestEditorPassword);
				 System.out.println("Correctly Logged In from another user");
				 

				// ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Functional/another user like test.png');");		
				
				 new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
					//Thread.sleep(1000);
					new Actions(wd).moveToElement(wd.findElement(By.linkText("Media"))).build().perform();
					//wd.findElement(By.linkText("Media")).click();
														
					System.out.println("Media Gallery ");			
					//Thread.sleep(5000);
					wd.findElement(By.linkText("Music")).click();
					//wd.findElement(By.id("rtmedia-nav-item-music")).click();
				 System.out.println("music clicked");
				 Thread.sleep(2000);
//				wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//	 wd.findElement(By.linkText("Download File")).click();
				 
				 
			/*	WebElement myDynamicElement = (new WebDriverWait(wd, 10))
						  .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#mep_0 > div > div.mejs-controls > div.mejs-button.mejs-playpause-button.mejs-play > button")));
				 //Thread.sleep(20000);
*/				wd.navigate().refresh();
				Thread.sleep(3000);
				
		        wd.findElement(By.cssSelector("#bulk-edit-form > ul.rtmedia-list.rtmedia-list-media.context-id-3.rtm-pro-allow-act"
				+ "ion > li.rtmedia-list-item > a.rtmedia-list-item-a")).click();
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Music/Functional/another user Play test.png');");		
                 
				 wd.findElement(By.cssSelector("div.mejs-button.mejs-playpause-button.mejs-play > button >")).click();
				 
					
				 System.out.println(" play button clicked");
				 

		
		
	}
}
