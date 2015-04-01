package testscripts.OtherSettings;

import org.testng.annotations.Test;

import java.util.List;

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

public class enablePlaylists1Test {
	
	@Test	

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
		
	List<WebElement> switchElement = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-41\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

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

						wd.findElement(By.id("tab-rtmedia-display")).click();
						System.out.println("Display Settings opened ");
						// Check if the Lightbox  switch in on or off, if its on then switch it off 
								List<WebElement> switchElement2 = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-5\"] > div.rt-switch.has-switch > div.switch-animate.switch-on"));

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
						new Actions(wd).moveToElement(wd.findElement(By.linkText("Media"))).build().perform();
						
						new Actions(wd).moveToElement(wd.findElement(By.linkText("Music"))).build().perform();
						wd.findElement(By.linkText("Music")).click();
						
						
						wd.findElement(By.cssSelector("#bulk-edit-form > ul.rtmedia-list.rtmedia-list-media.context-id-1.rtm-pro-allow-act"
							+ "ion > li.rtmedia-list-item > a.rtmedia-list-item-a")).click();
						
						
						Thread.sleep(4000);
						((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Playlist/Functional/Enable Playlists 8.png');");				
					

						wd.findElement(By.cssSelector("#rtm-media-options-list > span > button")).click();
						Thread.sleep(2000);
						((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Playlist/Functional/Enable Playlists 9.png');");				
                      //  wd.findElement(By.xpath("//*[@id="rtmedia-action-button-459"]")).click();
					    wd.findElement(By.cssSelector("#rtmedia-action-button-433")).click();
					    System.out.println("creating new playlist");
						Thread.sleep(2000);
						((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Playlist/Functional/Enable Playlists 9.1.png');");				

						Select createnew=new Select(wd.findElement(By.cssSelector("#playlist-list")));
						
						createnew.selectByVisibleText("Create New Playlist");
						
				        wd.findElement(By.id("playlist_name")).click();
				        wd.findElement(By.id("playlist_name")).clear();
				        Thread.sleep(2000);
				    int a2=1;
				    a2++;
				    String a=String.valueOf(a2);
				       
				       
				       
				      
				        wd.findElement(By.id("playlist_name")).sendKeys("New demo Playlist By Akash"+a);
				        wd.findElement(By.cssSelector("#rtmp-playlist-form > form > input.add-to-rtmp-playlist")).click();
				        Thread.sleep(2000);
				        System.out.println("created new playlist ");
				        
				        
				       wd.navigate().refresh();
				       
				   	new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
					Thread.sleep(4000);
					// Mouseover Media
					new Actions(wd).moveToElement(wd.findElement(By.linkText("Media"))).build().perform();
					
				       
					wd.findElement(By.cssSelector("#\34 20 > a > div.rtmedia-item-title")).click();
					System.out.println("Music clicked");
					
					((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Playlist/Functional/Enable Playlists 8.1.png');");				

				       Thread.sleep(5000);
				     
				      
				      
				    	//wd.findElement(By.linkText("mpthreetest")).click();
							System.out.println("clicked on another music to add playlisit");
							
							Thread.sleep(4000);
							((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Playlist/Functional/Enable Playlists 8.1.png');");				


							wd.findElement(By.cssSelector("#rtm-media-options-list > span > button")).click();
							Thread.sleep(2000);
							((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Playlist/Functional/Enable Playlists 9.2.png');");				
	                      //  wd.findElement(By.xpath("//*[@id="rtmedia-action-button-459"]")).click();
						    wd.findElement(By.cssSelector("#rtmedia-action-button-420")).click();
						    //System.out.println("creating new playlist");
							Thread.sleep(2000);
							((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Playlist/Functional/Enable Playlists 9.3.png');");				

							Select createnew1=new Select(wd.findElement(By.cssSelector("#playlist-list")));
							
							createnew1.selectByVisibleText("New demo Playlist By Akash"+a);
							

				       // wd.findElement(By.cssSelector("input.add-to-rtmp-playlist")).click();
				        //Thread.sleep(2000);

				/*		WebElement ele = wd.findElement(By.cssSelector("#playlist-list"));
						Select a1=new Select(ele);
						a1.selectByVisibleText("Create New Playlist");
						
						wd.findElement(By.id("playlist_name")).clear();
						wd.findElement(By.id("playlist_name")).click();
						
						wd.findElement(By.id("playlist_name")).sendKeys("Demo playlist for testing");
				*/		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Playlist/Functional/Enable Playlists 9.png');");				

						
						//clicked add button
						//wd.findElement(By.cssSelector("#rtmp-playlist-form > form > input.add-to-rtmp-playlist")).click();
						Thread.sleep(2000);
						wd.findElement(By.linkText("Playlists")).click();
						Thread.sleep(2000);
						
						String a1= wd.findElement(By.cssSelector("#bulk-edit-form > ul.rtmedia-list.rtmedia-list-media.context-id-1.rtm-pro-allow-act"
								+ "ion > li.rtmedia-list-item > a.rtmedia-list-item-a")).getText();
							System.out.println("Created Playlist Name is"+a1);
					

						
	}
	

}
