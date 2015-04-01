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
import org.testng.Assert;
import org.testng.annotations.Test;

import testscripts.Constants;

public class enablePlaylistsOtherRolesTest {
	@Test(groups={"OtherSettings"})

public static void PlaylistNonAdminRoles() throws Exception {


	// Phantom js : headless
	// Code to take screenshots
	Capabilities caps = new DesiredCapabilities();
	((DesiredCapabilities) caps).setJavascriptEnabled(true);
	((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
	
	PhantomJSDriver wd = new PhantomJSDriver(caps);
	wd.manage().window().setSize(new Dimension(1920, 1080));
	wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	

	// Login to wordpress
	wd.get(Constants.WP_SERVER);
	Constants.login(wd, Constants.TestSubscriber, Constants.TestSubscriberPassword);
	 System.out.println("Correctly Logged In");	
			
		 // Go to Playlists
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
                        						
						wd.findElement(By.cssSelector(".rtmedia-upload-media-link")).click();
							
								
							System.out.println("rtMedia-upload-button Clicked");
							
							Thread.sleep(3000);
							
						
						
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
							
						// Multiple Music files
						((PhantomJSDriver) wd).executePhantomJS("var page=this; "
						        + "var count=0;" + "page.uploadFile('input[type=file]',['"
						        + Constants.Music2+"']);");
								Thread.sleep(5000); // Increase sleep for Music and Video uploads
								((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Functional/Enable Playlists 7.png');");
					//	Thread.sleep(3000); // Increase sleep for Music and Video uploads

						// click Start Upload button

									
							 wd.findElement(By.cssSelector("input.start-media-upload")).click();

							System.out.println("Start Media  Upload button clicked");
							Thread.sleep(5000); // Increase sleep for Music and Video uploads
												
									
							/*					
											
										// Multiple Music files
									((PhantomJSDriver) wd).executePhantomJS("var page=this; "
									        + "var count=0;" + "page.uploadFile('input[type=file]',['"
									        + Constants.MusicPhantom +"','"+Constants.Music2+"']);");
											Thread.sleep(11000); // Increase sleep for Music and Video uploads
											((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Functional/Enable Playlists 10.png');");
												
				*/							
					    		// click on a music file 
									wd.navigate().refresh();
									
									new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
									Thread.sleep(4000);
									// Mouseover Media
									new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).build().perform();
									// Click on Media
									
									wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item")).click();				
									
									//wd.findElement(By.linkText("Music")).click();
									
									
									
								//	Thread.sleep(4000);
									wd.findElement(By.cssSelector("div.rtmedia-item-thumbnail > img")).click();
									Thread.sleep(4000);
									((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Functional/Enable Playlists 8.png');");				
									//Thread.sleep(4000);
									// click Options-> Add to Playlist
																			
									// new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#rtm-media-options-list > span > button > i"))).build().perform();
									    wd.findElement(By.cssSelector("#rtm-media-options-list > span > button")).click();
				/*wd.findElement(By.cssSelector("button.clicker.rtmedia-media-options.rtmedia-action-buttons.button")).click();*/
									
									/*wd.findElement(By.id("rtm-media-options-list")).click();*/
									
									  System.out.println("Options Clicked");
									  ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Functional/Enable Playlists 9.png');");		  
									  Thread.sleep(2000);
									  ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Functional/Enable Playlists 9.1.png');");					    
									    Thread.sleep(4000);
									    ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Functional/Enable Playlists 9.2.png');");		    
									    new Actions(wd).moveToElement(wd.findElement(By.cssSelector("button.rtmedia-add-to-playlist"))).build().perform();
									    
									    Thread.sleep(4000);
									    /*wd.findElement(By.cssSelector("button.clicker.rtmedia-media-options.rtmedia-action-buttons.button")).click();*/					    
									    wd.findElement(By.cssSelector("button.rtmedia-add-to-playlist")).click();
									    Thread.sleep(2000);
									    ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Functional/Enable Playlists 10.png');");			    
									    // Select and Add music file to the newly created Playlist : demo Music Playlist

									    if (!wd.findElement(By.xpath("//span[@id='playlist-select']/select//option[2]")).isSelected()) {
								            wd.findElement(By.xpath("//span[@id='playlist-select']/select//option[2]")).click();
								        }
								        wd.findElement(By.id("playlist_name")).click();
								        wd.findElement(By.id("playlist_name")).clear();
								        Thread.sleep(2000);
								        wd.findElement(By.id("playlist_name")).sendKeys("New demo Playlist");
								        Thread.sleep(2000);
								        wd.findElement(By.cssSelector("input.add-to-rtmp-playlist")).click();
								        Thread.sleep(2000);
								        
								    
								        
								    	

								        
									// Then check the result in that Playlist :  demo Music Playlist
								        
								     // Go to Playlists
										// Mouseover Profile ( Howdy , {username} section )
										new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
										Thread.sleep(4000);
										// Mouseover Media
										new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).build().perform();
										// Click on Playlists
										wd.findElement(By.linkText("Playlists")).click();
										Thread.sleep(1000);
										((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Functional/Enable Playlists 11.png');");	
							// Click  demo Music Playlist
									//String text=wd.findElement(By.cssSelector("div.rtmedia-item-thumbnail > a > img")).getText();
									//Assert.assertEquals("New demo Playlist",text);
									//System.out.println(text);
					wd.findElement(By.cssSelector("div.rtmedia-item-thumbnail > a > img")).click();		
					
					((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/OtherSettings/Functional/Enable Playlists 12.png');");				    
						// Having issue adding multiple music files to Playlist . This code needs to  be updated. 	Currently it successfully adds a music file to a playlist		    
									
									Thread.sleep(1000);
					// Log out
					
					new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
					wd.findElement(By.linkText("Log Out")).click();
				  wd.quit();
					
	
}


}
