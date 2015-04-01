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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import testscripts.Constants;

public class enablePlaylistsTest {
	@Test(groups={"OtherSettings"})

public static void PlaylistAdmin() throws Exception {
	
	/*wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);*/
	
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
	 
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Playlist/Functional/Enable Playlists 01.png');");	

	// Open rtMedia Settings 
			
	Constants.openrtMediaSettings(wd);
	
	// Click on rtMedia settings OtherSettings Tab

	wd.findElement(By.id("tab-rtmedia-general")).click();
			
	System.out.println("Other Settings  Tab Opened");
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Playlist/Functional/Enable Playlists 02.png');");			
	// Check if the switch in on or off, if its off then switch on and proceed
	
List<WebElement> switchElement = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-36\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

							if (switchElement.size() != 0) {

						switchElement.get(0).findElement(By.cssSelector("span.switch-right")).click();
						System.out.println("Enable Playlists set to ON");
												} 
											else
				System.out.println("The Switch for Enable Playlists  is already ON");
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Playlist/Functional/Enable Playlists 03.png');");								
							
			// save the Other settings
			wd.findElement(By.id("rtmedia-settings-submit")).click();
					Thread.sleep(2000);
					((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Playlist/Functional/Enable Playlists 04.png');");								

					// Click on rtMedia settings Display  Tab
					wd.findElement(By.id("tab-rtmedia-display")).click();
					System.out.println("Display Settings opened ");
					// Check if the Lightbox  switch in on or off, if its on then switch it off 
							List<WebElement> switchElement2 = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-6\"] > div.rt-switch.has-switch > div.switch-animate.switch-on"));

							if (switchElement2.size() != 0) {

								switchElement2.get(0).findElement(By.cssSelector("span.switch-left")).click();

							} else
								System.out.println("'Lightbox' is already off");
							((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Playlist/Functional/Enable Playlists 05.png');");											

					// save the settings
					wd.findElement(By.id("rtmedia-settings-submit")).click();
					System.out.println("Settings saved");

								
					// Do a mouse over on the primary menu on top LHS
					new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
					// Click on Visit Site

					wd.findElement(By.linkText("Visit Site")).click();
((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Playlist/Functional/Enable Playlists 06.png');");					
		    
					// Mouseover Profile ( Howdy , {username} section )
					new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
					Thread.sleep(4000);
					// Mouseover Media
					new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).build().perform();
		// Click on Media
					
	wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item")).click();				
					
	// Upload Media  via PhantomJSDriver		
		// Upload Media in Gallery by clicking Upload button
			Thread.sleep(3000);
		
			// Mouseover Profile ( Howdy , {username} section )
			new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
			Thread.sleep(1000);
			// Mouseover Media
			new Actions(wd).moveToElement(wd.findElement(By.linkText("Media"))).build().perform();
		//	new Actions(wd).moveToElement(wd.findElement(By.linkText("Music"))).build().perform();

			wd.findElement(By.linkText("Music")).click();
			
					//wd.navigate().refresh();
					Thread.sleep(2000);
					wd.findElement(By.cssSelector("#bulk-edit-form > ul.rtmedia-list.rtmedia-list-media.context-id-1.rtm-pro-allow-act"
							+ "ion > li.rtmedia-list-item > a.rtmedia-list-item-a")).click();
									
					//wd.findElement(By.cssSelector("div.rtmedia-item-thumbnail > img")).click();
					Thread.sleep(2000);
					((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Playlist/Functional/Enable Playlists 8.png');");				
								
					System.out.println("clicked on Media");
						   
					wd.findElement(By.cssSelector("#rtm-media-options-list > span > button > i")).click();
					
					  System.out.println("Options Clicked");
					  
					    ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Playlist/Functional/Enable Playlists 9.2.png');");
						//wd.navigate().refresh();

					    if(wd.findElement(By.cssSelector("i.rtmicon-plus.rtmicon-fw")).isDisplayed())
					    {
					    	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("i.rtmicon-plus.rtmicon-fw"))).build().perform();
					    Thread.sleep(1000);
					    /*wd.findElement(By.cssSelector("button.clicker.rtmedia-media-options.rtmedia-action-buttons.button")).click();*/					    
					    wd.findElement(By.cssSelector("i.rtmicon-plus.rtmicon-fw")).click();
					    Thread.sleep(2000);
					    ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Playlist/Functional/Enable Playlists 10.png');");
					    
					    }
					    // Select and Add music file to the newly created Playlist : demo Music Playlist
					    String a="New demo Playlist";

					    if(wd.findElement(By.cssSelector("#playlist-list")).isDisplayed())
					    {
					    Select media1 = new Select(wd.findElement(By.cssSelector("#playlist-list")));
					    
					    media1.selectByVisibleText("Create New Playlist");
					    
				        wd.findElement(By.id("playlist_name")).click();
				        wd.findElement(By.id("playlist_name")).clear();
				       // Thread.sleep(2000);
				        wd.findElement(By.id("playlist_name")).sendKeys(a);
				        //Thread.sleep(2000);
				        wd.findElement(By.cssSelector("input.add-to-rtmp-playlist")).click();
				        Thread.sleep(2000);
					    }
					    
				       // wd.navigate().refresh();
				        
				        //Thread.sleep(5000);
				        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a"))).build().perform();
				        Thread.sleep(1500);
				        
				        new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a"))).build().perform();
				        Thread.sleep(500);
						wd.findElement(By.linkText("Music")).click();

				        
				        
				        Thread.sleep(2000);
				        
				        WebElement ele =wd.findElements(By.cssSelector("#bulk-edit-form > ul.rtmedia-list.rtmedia-list-media.context-id-1.rtm-pro-allow-act"
							+ "ion > li.rtmedia-list-item > a.rtmedia-list-item-a")).get(1);
				        ele.click();
				        Thread.sleep(2000);
				        
				        
				        
				        wd.findElement(By.cssSelector("#rtm-media-options-list > span > button > i")).click();
						
						  System.out.println("Options Clicked");
				
						    ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Playlist/Functional/Enable Playlists 9.3.png');");
							//wd.navigate().refresh();

						    new Actions(wd).moveToElement(wd.findElement(By.cssSelector("i.rtmicon-plus.rtmicon-fw"))).build().perform();
						    
						    Thread.sleep(1000);
						    /*wd.findElement(By.cssSelector("button.clicker.rtmedia-media-options.rtmedia-action-buttons.button")).click();*/					    
						    wd.findElement(By.cssSelector("i.rtmicon-plus.rtmicon-fw")).click();
						    Thread.sleep(2000);

				        Select media2 = new Select(wd.findElement(By.cssSelector("#playlist-list")));
				        
				        media2.selectByVisibleText(a);
				        
				        wd.findElement(By.cssSelector("#rtmp-playlist-form > form > input.add-to-rtmp-playlist")).click();
					// Then check the result in that Playlist :  demo Music Playlist
				       
				     // Go to Playlists
						// Mouseover Profile ( Howdy , {username} section )
						new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
						Thread.sleep(1000);
						// Mouseover Media
						new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).build().perform();
						// Click on Playlists
						wd.findElement(By.linkText("Playlists")).click();
						Thread.sleep(1000);
						((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Playlist/Functional/Enable Playlists 11.png');");	
			            // Click  demo Music Playlist
						
	wd.findElement(By.cssSelector("div.rtmedia-item-thumbnail > a > img")).click();		        
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Playlist/Functional/Enable Playlists 12.png');");				    
		// Having issue adding multiple music files to Playlist . This code needs to  be updated. 	Currently it successfully adds a music file to a playlist		    
					
					Thread.sleep(1000);
					// Log out
					
					new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
					wd.findElement(By.linkText("Log Out")).click();
				  wd.quit();
					
	
}


}
