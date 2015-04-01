package testscripts;

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

public class SetupTest {
	@Test
	 	
	public static void setupThePrerequisites() throws Exception {

		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);

		PhantomJSDriver wd;
		wd = new PhantomJSDriver(caps);
		wd.manage().window().setSize(new Dimension(1920, 1080));
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  
		// Login to Wordpress with Administrator account
		wd.get(Constants.WP_SERVER);
		Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
		System.out.println("log in....");
		//Thread.sleep(2000);
		// Do a mouse over on the primary menu on top LHS
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();
		
		Thread.sleep(2000);
		// Click on Dashboard
		wd.findElement(By.linkText("Dashboard")).click();
	((PhantomJSDriver) wd).executePhantomJS("var page=this; "+ "page.render('./screen/setup/Dashboard.png'); ");
	Thread.sleep(2000);
	// Do a mouse over on the primary menu on top LHS
		new Actions(wd).moveToElement(wd.findElement(By.linkText("Posts"))).build().perform();
			Thread.sleep(2000);
		wd.findElement(By.linkText("Add New")).click();
	System.out.println("Reached Posts");
		// Enter the Post title for WordPress admin
		wd.findElement(By.id("title")).click();
		wd.findElement(By.id("title")).clear();
		wd.findElement(By.id("title")).sendKeys("Test Post");

		// Click on publish button
		wd.findElement(By.id("publish")).click();

		((PhantomJSDriver) wd).executePhantomJS("var page=this; "+ "page.render('./screen/setup/CreateTestPost.png'); ");
		String message = wd.findElement(By.cssSelector("div#message > p")).getText();
		System.out.println(message + ": message");
		if ("Post published. View post".equals(message))
			System.out.println("Post Created");
		else
			System.out.println("Post Not created");

		// Add New Post for anonymous user
		
	wd.findElement(By.linkText("Add New")).click();
		/*wd.findElement(By.id("add-new-h2")).click();*/
		// Enter the title
		wd.findElement(By.id("title")).click();
		wd.findElement(By.id("title")).clear();
		wd.findElement(By.id("title")).sendKeys("Test Post For Anonymous");

		// Click on publish button
		wd.findElement(By.id("publish")).click();

	((PhantomJSDriver) wd).executePhantomJS("var page=this; "+ "page.render('./screen/setup/CreateAnonymousPost.png'); ");
		message = wd.findElement(By.cssSelector("div#message > p")).getText();
		System.out.println(message + ": message");
		if ("Post published. View post".equals(message))
			System.out.println("Anonymous Post Created");
		else
			System.out.println("Anonymous Post Not created");

		// Add New for Author user
	/*	wd.findElement(By.id("add-new-h2")).click();*/
		wd.findElement(By.linkText("Add New")).click();
		// Enter the title
		wd.findElement(By.id("title")).click();
		wd.findElement(By.id("title")).clear();
		wd.findElement(By.id("title")).sendKeys("Test Post For Author");

		// Click on publish button
		wd.findElement(By.id("publish")).click();

		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "page.render('./screen/setup/CreateAuhtorPost.png'); ");
		message = wd.findElement(By.cssSelector("div#message > p")).getText();
		System.out.println(message + ": message");
		if ("Post published. View post".equals(message))
			System.out.println("Author Post Created");
		else
			System.out.println("Author Post Not created");

		// Add New for Contributor user
		/*wd.findElement(By.id("add-new-h2")).click();*/
		wd.findElement(By.linkText("Add New")).click();
		// Enter the title
		wd.findElement(By.id("title")).click();
		wd.findElement(By.id("title")).clear();
		wd.findElement(By.id("title")).sendKeys("Test Post For Contributor");

		// Click on publish button
		wd.findElement(By.id("publish")).click();

		((PhantomJSDriver) wd).executePhantomJS("var page=this; "+ "page.render('./screen/setup/CreateContributorPost.png'); ");
		message = wd.findElement(By.cssSelector("div#message > p")).getText();
		System.out.println(message + ": message");
		if ("Post published. View post".equals(message))
			System.out.println("Contributor Post Created");
		else
			System.out.println("Contributor Post Not created");

		// Add New for Editor user
		/*wd.findElement(By.id("add-new-h2")).click();*/
		wd.findElement(By.linkText("Add New")).click();
		// Enter the title
		wd.findElement(By.id("title")).click();
		wd.findElement(By.id("title")).clear();
		wd.findElement(By.id("title")).sendKeys("Test Post For Editor");

		// Click on publish button
		wd.findElement(By.id("publish")).click();

		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "page.render('./screen/setup/CreateEditorPost.png'); ");
		message = wd.findElement(By.cssSelector("div#message > p")).getText();
		System.out.println(message + ": message");
		if ("Post published. View post".equals(message))
			System.out.println("Editor Post Created");
		else
			System.out.println("Editor Post Not created");

		// Add New for Subscriber user
		/*wd.findElement(By.id("add-new-h2")).click();*/
		wd.findElement(By.linkText("Add New")).click();
		// Enter the title
		wd.findElement(By.id("title")).click();
		wd.findElement(By.id("title")).clear();
		wd.findElement(By.id("title")).sendKeys("Test Post For Subscriber");

		// Click on publish button
		wd.findElement(By.id("publish")).click();

		((PhantomJSDriver) wd).executePhantomJS("var page=this; "
				+ "page.render('./screen/setup/CreateSubscriberPost.png'); ");
		message = wd.findElement(By.cssSelector("div#message > p")).getText();
		System.out.println(message + ": message");
		if ("Post published. View post".equals(message))
		{
			System.out.println("Subscriber Post Created");
		}
		else
			System.out.println("Subscriber Post Not created");

	// Creating a Group Named test
		 // Make sure Enable Media in Group is turned on
	  	// Open rtMedia Settings 
			Constants.openrtMediaSettings(wd);
	((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/setup/EnableMediaInGroup01.png');");			
			Thread.sleep(5000);
			
			// Click on rtMedia settings BuddyPress Tab

			wd.findElement(By.id("tab-rtmedia-bp")).click();

			System.out.println("BuddyPress Tab Opened");
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/setup/EnableMediaInGroup02.png');");
			// Check if the switch is on or off, if its off then switch on and  proceed
			List<WebElement> switchElement = wd.findElements(By
		.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-16\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));

		if (switchElement.size() != 0) {

		switchElement.get(0).findElement(By.cssSelector("span.switch-right")).click();
		System.out.println("'Enable Media in Group' is switched  on");
			} else
				System.out.println("'Enable Media in Group' is already on");
		// Save rtMedia Settings
		
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		System.out.println("rtMedia Settings Saved");
		Thread.sleep(1000);		
		
// Make sure user groups is enabled from BuddyPress Settings
	
		wd.findElement(By.xpath("//*[@id='menu-settings']/a/div[3]")).click();
		Thread.sleep(1000);
		 wd.findElement(By.xpath("//*[@id='menu-settings']/ul/li[8]/a")).click();
		 Thread.sleep(1000);
		 // click on  User Groups checkbox if not selected 
		 
		 if (!wd.findElement(By.id("bp_components[groups]")).isSelected()) {
	            wd.findElement(By.id("bp_components[groups]")).click();
	          
	        }
		 
		 wd.findElement(By.id("bp-admin-component-submit")).click();
		Thread.sleep(3000);
		
	/*try{*/ 
		wd.findElement(By.linkText("Groups")).click();
		 wd.findElement(By.cssSelector("a.add-new-h2")).click();
	        wd.findElement(By.id("group-name")).click();
	        wd.findElement(By.id("group-name")).clear();
	        wd.findElement(By.id("group-name")).sendKeys("test");
	        wd.findElement(By.id("group-desc")).click();
	        wd.findElement(By.id("group-desc")).clear();
	        wd.findElement(By.id("group-desc")).sendKeys("test");
	        wd.findElement(By.id("group-creation-create")).click();
	        wd.findElement(By.id("group-creation-next")).click();
	        wd.findElement(By.id("group-creation-next")).click();
	       // wd.findElement(By.id("group-creation-next")).click();
	        wd.findElement(By.id("group-creation-finish")).click(); 
  ((PhantomJSDriver) wd).executePhantomJS("var page=this; "+ "page.render('./screen/setup/test Group.png'); ");	 
	      System.out.println("A group named test is created") ;

		
	// CREATE USERS via code :  TestEditor  Test Subscriber , Test Author , TestContributor  etc
	      
	   // Test Admin
	      new Actions(wd).moveToElement(wd.findElement(By.linkText("New"))).build().perform();
	      new Actions(wd).moveToElement(wd.findElement(By.linkText("User"))).build().perform();
	        wd.findElement(By.linkText("User")).click();
	        wd.findElement(By.id("user_login")).click();
	        wd.findElement(By.id("user_login")).clear();
	        wd.findElement(By.id("user_login")).sendKeys("TestAdmin");
	        wd.findElement(By.id("email")).click();
	        wd.findElement(By.id("email")).clear();
	        wd.findElement(By.id("email")).sendKeys("akash.chavan@rtcamp.com");
	        wd.findElement(By.id("first_name")).click();
	        wd.findElement(By.id("first_name")).clear();
	        wd.findElement(By.id("first_name")).sendKeys("TestAdmin");
	        
	        wd.findElement(By.id("pass1")).click();
	        wd.findElement(By.id("pass1")).clear();
	        wd.findElement(By.id("pass1")).sendKeys("1234567890");
	        wd.findElement(By.id("pass2")).click();
	        wd.findElement(By.id("pass2")).clear();
	        wd.findElement(By.id("pass2")).sendKeys("1234567890");
	        Select dropdown5 = new Select(wd.findElement(By.id("role")));
	        dropdown5.selectByValue("administrator");
	        wd.findElement(By.id("createusersub")).click();
	        
	      System.out.println("Test Admin user Created");
	      
	      // TestEditor
	      new Actions(wd).moveToElement(wd.findElement(By.linkText("New"))).build().perform();
	      new Actions(wd).moveToElement(wd.findElement(By.linkText("User"))).build().perform();
	        wd.findElement(By.linkText("User")).click();
	        wd.findElement(By.id("user_login")).click();
	        wd.findElement(By.id("user_login")).clear();
	        wd.findElement(By.id("user_login")).sendKeys("TestEditor");
	        wd.findElement(By.id("email")).click();
	        wd.findElement(By.id("email")).clear();
	        wd.findElement(By.id("email")).sendKeys("sumeet.sarna+testeditor@rtcamp.com");
	        wd.findElement(By.id("first_name")).click();
	        wd.findElement(By.id("first_name")).clear();
	        wd.findElement(By.id("first_name")).sendKeys("TestEditor");
	        wd.findElement(By.id("last_name")).click();
	        wd.findElement(By.id("last_name")).clear();
	        wd.findElement(By.id("last_name")).sendKeys("TestEditor");
	        wd.findElement(By.id("pass1")).click();
	        wd.findElement(By.id("pass1")).clear();
	        wd.findElement(By.id("pass1")).sendKeys("1234567890");
	        wd.findElement(By.id("pass2")).click();
	        wd.findElement(By.id("pass2")).clear();
	        wd.findElement(By.id("pass2")).sendKeys("1234567890");
	        /*if (!wd.findElement(By.xpath("//table[@class='form-table']/tbody/tr[9]/td/select//option[8]")).isSelected()) {
	            wd.findElement(By.xpath("//table[@class='form-table']/tbody/tr[9]/td/select//option[8]")).click();
	        }
	        wd.findElement(By.xpath("//table[@class='form-table']/tbody/tr[8]/td")).click();*/
	       
	        Select dropdown = new Select(wd.findElement(By.id("role")));
	        dropdown.selectByValue("editor");    
	        wd.findElement(By.id("createusersub")).click();
	  System.out.println("Test Editor Created");    
	        // Test Author
	  new Actions(wd).moveToElement(wd.findElement(By.linkText("New"))).build().perform();
      new Actions(wd).moveToElement(wd.findElement(By.linkText("User"))).build().perform();
        wd.findElement(By.linkText("User")).click();
        wd.findElement(By.id("user_login")).click();
        wd.findElement(By.id("user_login")).clear();
        wd.findElement(By.id("user_login")).sendKeys("TestAuthor");
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).clear();
        wd.findElement(By.id("email")).sendKeys("sumeet.sarna+testauthor@rtcamp.com");
        wd.findElement(By.id("first_name")).click();
        wd.findElement(By.id("first_name")).clear();
        wd.findElement(By.id("first_name")).sendKeys("TestAuthor");
        
        wd.findElement(By.id("pass1")).click();
        wd.findElement(By.id("pass1")).clear();
        wd.findElement(By.id("pass1")).sendKeys("1234567890");
        wd.findElement(By.id("pass2")).click();
        wd.findElement(By.id("pass2")).clear();
        wd.findElement(By.id("pass2")).sendKeys("1234567890");
        Select dropdown2 = new Select(wd.findElement(By.id("role")));
       dropdown2.selectByValue("author");
       wd.findElement(By.id("createusersub")).click();
  System.out.println("Test Author Created");     
	        
	        //Test Subscriber
  new Actions(wd).moveToElement(wd.findElement(By.linkText("New"))).build().perform();
  new Actions(wd).moveToElement(wd.findElement(By.linkText("User"))).build().perform();
    wd.findElement(By.linkText("User")).click();
    wd.findElement(By.id("user_login")).click();
    wd.findElement(By.id("user_login")).clear();
    wd.findElement(By.id("user_login")).sendKeys("TestSubscriber");
    wd.findElement(By.id("email")).click();
    wd.findElement(By.id("email")).clear();
    wd.findElement(By.id("email")).sendKeys("sumeet.sarna+testsubscriber@rtcamp.com");
    wd.findElement(By.id("first_name")).click();
    wd.findElement(By.id("first_name")).clear();
    wd.findElement(By.id("first_name")).sendKeys("TestSubscriber");
    
    wd.findElement(By.id("pass1")).click();
    wd.findElement(By.id("pass1")).clear();
    wd.findElement(By.id("pass1")).sendKeys("1234567890");
    wd.findElement(By.id("pass2")).click();
    wd.findElement(By.id("pass2")).clear();
    wd.findElement(By.id("pass2")).sendKeys("1234567890");
    Select dropdown3 = new Select(wd.findElement(By.id("role")));
    dropdown3.selectByValue("subscriber");
    wd.findElement(By.id("createusersub")).click();
System.out.println("Test Subscriber Created");  
	        //TestContributor

new Actions(wd).moveToElement(wd.findElement(By.linkText("New"))).build().perform();
new Actions(wd).moveToElement(wd.findElement(By.linkText("User"))).build().perform();
  wd.findElement(By.linkText("User")).click();
  wd.findElement(By.id("user_login")).click();
  wd.findElement(By.id("user_login")).clear();
  wd.findElement(By.id("user_login")).sendKeys("TestContributor");
  wd.findElement(By.id("email")).click();
  wd.findElement(By.id("email")).clear();
  wd.findElement(By.id("email")).sendKeys("sumeet.sarna+testcontributor@rtcamp.com");
  wd.findElement(By.id("first_name")).click();
  wd.findElement(By.id("first_name")).clear();
  wd.findElement(By.id("first_name")).sendKeys("TestContributor");
  
  wd.findElement(By.id("pass1")).click();
  wd.findElement(By.id("pass1")).clear();
  wd.findElement(By.id("pass1")).sendKeys("1234567890");
  wd.findElement(By.id("pass2")).click();
  wd.findElement(By.id("pass2")).clear();
  wd.findElement(By.id("pass2")).sendKeys("1234567890");
  Select dropdown4 = new Select(wd.findElement(By.id("role")));
  dropdown4.selectByValue("contributor");
  wd.findElement(By.id("createusersub")).click();
  
System.out.println("Test Contributor Created");   /*}catch(Throwable T){System.out.println("Already created");}*/
((PhantomJSDriver) wd).executePhantomJS("var page=this; "+ "page.render('./screen/setup/Test Imp 1.png'); ");
Thread.sleep(6000);
// Create a TESTFORUM and a discussion named : discussion1 for bbPressSettingsTest.java
// Click on Forums

wd.navigate().to(Constants.WP_SERVER +"/wp-admin");
System.out.println("Reached dashboard");

((PhantomJSDriver) wd).executePhantomJS("var page=this; "+ "page.render('./screen/setup/Test Imp 2.png'); ");
Thread.sleep(4000);
new Actions(wd)
.moveToElement(wd.findElement(By.linkText("Forums"))).build().perform();
	Thread.sleep(2000);
		
wd.findElement(By.linkText("New Forum")).click();
System.out.println("New Forum Clicked");
Thread.sleep(2000);

((PhantomJSDriver) wd).executePhantomJS("var page=this; "+ "page.render('./screen/setup/Test Imp 3.png'); ");

/*new Actions(wd).moveToElement(wd.findElement(By.linkText("Forums"))).build().perform();
wd.findElement(By.linkText("Forums")).click();
Thread.sleep(2000);     
wd.findElement(By.linkText("New Forum")).click();*/
/*
new Actions(wd).moveToElement(wd.findElement(By.linkText("New"))).build().perform();
Thread.sleep(1000);
new Actions(wd).moveToElement(wd.findElement(By.linkText("Forum"))).build().perform();
Thread.sleep(1000);
  wd.findElement(By.linkText("Forum")).click();*/
//  /Thread.sleep(4000);
  wd.findElement(By.id("title")).click();
  wd.findElement(By.id("title")).clear();
  wd.findElement(By.id("title")).sendKeys("TestForum");
  
  if (!wd.findElement(By.id("title")).getAttribute("value").equals("TestForum")) {
      System.out.println("verifyElementValue failed");
  }
    wd.findElement(By.xpath("//html")).click();
  wd.findElement(By.id("publish")).click();
  
  /*wd.findElement(By.id("title")).click();
  wd.findElement(By.id("title")).clear();
  wd.findElement(By.id("title")).sendKeys("TestForum");
  wd.findElement(By.id("content")).click();
  wd.findElement(By.id("content")).clear();
  wd.findElement(By.id("content")).sendKeys("TestForum");
  Thread.sleep(4000);
  wd.findElement(By.id("publish")).click();*/
  
  System.out.println("TestForum published");
  Thread.sleep(2000);
  /*new Actions(wd).moveToElement(wd.findElement(By.linkText("View forum"))).build().perform();
  wd.findElement(By.linkText("View forum")).click();*/
  new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#view-post-btn > a.button.button-small"))).build().perform();
  Thread.sleep(1000);
  wd.findElement(By.cssSelector("#view-post-btn > a.button.button-small")).click();
  Thread.sleep(4000);
  wd.findElement(By.id("bbp_topic_title")).click();
  wd.findElement(By.id("bbp_topic_title")).clear();
  wd.findElement(By.id("bbp_topic_title")).sendKeys("discussion1");
  wd.findElement(By.id("bbp_topic_content")).click();
  wd.findElement(By.id("bbp_topic_content")).clear();
  wd.findElement(By.id("bbp_topic_content")).sendKeys("discussion1");
  wd.findElement(By.id("bbp_topic_submit")).click();
  wd.quit();
  
}

}


