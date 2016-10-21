package selenium.tests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class SeleniumTest
{
	private static WebDriver driver;
	private static WebDriverWait wait;
	
	public static final String USERNAME = "rahuja910";
	public static final String ACCESS_KEY = "83aafeba-7a95-48dd-9867-51d1fffcba68";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	
	@BeforeClass
	public static void setUp() throws Exception 
	{
		//driver = new HtmlUnitDriver();
		DesiredCapabilities caps = DesiredCapabilities.chrome();
	    caps.setCapability("platform", "Windows XP");
	    caps.setCapability("version", "43.0");
		caps.setCapability("idleTimeout", "360");
	 
	    driver = new RemoteWebDriver(new URL(URL), caps);
	    wait = new WebDriverWait(driver, 30);
		//ChromeDriverManager.getInstance().setup();
		//driver = new ChromeDriver();
	}
	
	@AfterClass
	public static void  tearDown() throws Exception
	{
		driver.close();
		driver.quit();
	}

	
	// Database - Happy Flow
	
	@Test
	public void DatabaseHF() throws InterruptedException
	{
		// Introductory message - Hi!
		/*WebElement messageBotIntro = driver.findElement(By.id("message-input"));
		messageBotIntro.sendKeys("@onboarding-bot Hi");
		messageBotIntro.sendKeys(Keys.RETURN); */
		
		TimeUnit.SECONDS.sleep(3);
		
		//WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,â€™msg_1476829038_000021â€™)]")));
		//String message = msg.getText();
		//System.out.println(message);
		
		// User selects the option - 'Database'
		
		WebElement messageBotDB = driver.findElement(By.id("message-input"));
		messageBotDB.sendKeys("database");
		messageBotDB.sendKeys(Keys.RETURN);
		
		TimeUnit.SECONDS.sleep(3);
		
		// User provides the Team Name
		
		WebElement messageBotTeamName = driver.findElement(By.id("message-input"));
		messageBotTeamName.sendKeys("CSC510");
		messageBotTeamName.sendKeys(Keys.RETURN);
		
		TimeUnit.SECONDS.sleep(3);
		
		// User provides the Database name
		
		WebElement messageBotDBName = driver.findElement(By.id("message-input"));
		messageBotDBName.sendKeys("oracle.csc510");
		messageBotDBName.sendKeys(Keys.RETURN);
		
		TimeUnit.SECONDS.sleep(3);
		
		// User confirms -'YES'; Bot provides access to the user & sends appropriate message.
		
		WebElement messageBotConfirm = driver.findElement(By.id("message-input"));
		messageBotConfirm.sendKeys("Yes");
		messageBotConfirm.sendKeys(Keys.RETURN);
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='message_body' and text() = 'You have been given access to the database oracle.csc510']")));
		WebElement msgFour = driver.findElement(
						By.xpath("//span[@class='message_body' and text() = 'You have been given access to the database oracle.csc510']"));
		String messageFour = msgFour.getText();
		System.out.println(messageFour);
		assertNotNull(messageFour);
		
		
	}
@Test
public void SoftwareHF() throws InterruptedException
{
	// Introductory message - Hi!
	/*WebElement messageBotIntro = driver.findElement(By.id("message-input"));
	messageBotIntro.sendKeys("@onboarding-bot Hi");
	messageBotIntro.sendKeys(Keys.RETURN);*/
	
	TimeUnit.SECONDS.sleep(3);
	
	//WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,â€™msg_1476829038_000021â€™)]")));
	//String message = msg.getText();
	//System.out.println(message);
	
	// User selects the option - 'Github'
	
	WebElement messageBotDB = driver.findElement(By.id("message-input"));
	messageBotDB.sendKeys("Software");
	messageBotDB.sendKeys(Keys.RETURN);
	
	TimeUnit.SECONDS.sleep(3);
	
	// User provides the Team Name
	
	WebElement messageBotTeamName = driver.findElement(By.id("message-input"));
	messageBotTeamName.sendKeys("CSC540");
	messageBotTeamName.sendKeys(Keys.RETURN);
	
	TimeUnit.SECONDS.sleep(3);
	
	// User provides the Repo name
	
	WebElement messageBotDBName = driver.findElement(By.id("message-input"));
	messageBotDBName.sendKeys("MySQL");
	messageBotDBName.sendKeys(Keys.RETURN);
	
	TimeUnit.SECONDS.sleep(3);
	
	// User confirms -'YES'; Bot provides access to the user & sends appropriate message.
	
	WebElement messageBotConfirm = driver.findElement(By.id("message-input"));
	messageBotConfirm.sendKeys("Yes");
	messageBotConfirm.sendKeys(Keys.RETURN);
			
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='message_body' and text() = 'You have been added as an collaborator for the repository designpatterns']")));
	WebElement msgFour = driver.findElement(
					By.xpath("//span[@class='message_body' and text() = 'You have been added as an collaborator for the repository designpatterns']"));
	String messageFour = msgFour.getText();
	System.out.println(messageFour);
	assertNotNull(messageFour);
	
	
}

//Github - Alternate Flow
@Test
public void SoftwareAF() throws InterruptedException
{
	driver.get("https://csc510-seproject.slack.com");

	// Wait until page loads and we can see a sign in button.
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signin_btn")));

	// Find email and password fields.
	WebElement email = driver.findElement(By.id("email"));
	WebElement pw = driver.findElement(By.id("password"));

	// Type in our test user login info.
	email.sendKeys("kaushi@ncsu.edu");
	pw.sendKeys("K@ushik01");

	// Click
	WebElement signin = driver.findElement(By.id("signin_btn"));
	signin.click();

	// Wait until we go to general channel.
	wait.until(ExpectedConditions.titleContains("general"));

	// Switch to #bots channel and wait for it to load.
	driver.get("https://csc510-seproject.slack.com/messages/@onboarding-bot/");
	wait.until(ExpectedConditions.titleContains("onboarding-bot"));

	// Introductory message - Hi!
	WebElement messageBotIntro = driver.findElement(By.id("message-input"));
	messageBotIntro.sendKeys("@onboarding-bot Hi");
	messageBotIntro.sendKeys(Keys.RETURN);
	
	TimeUnit.SECONDS.sleep(3);
	
	//WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,â€™msg_1476829038_000021â€™)]")));
	//String message = msg.getText();
	//System.out.println(message);
	
	// User selects the option - 'Github'
	
	WebElement messageBotDB = driver.findElement(By.id("message-input"));
	messageBotDB.sendKeys("Software");
	messageBotDB.sendKeys(Keys.RETURN);
	
	TimeUnit.SECONDS.sleep(3);
	
	// User provides the Team Name
	
	WebElement messageBotTeamName = driver.findElement(By.id("message-input"));
	messageBotTeamName.sendKeys("CSC540");
	messageBotTeamName.sendKeys(Keys.RETURN);
	
	TimeUnit.SECONDS.sleep(3);
	
	// User provides the Repo name
	
	WebElement messageBotDBName = driver.findElement(By.id("message-input"));
	messageBotDBName.sendKeys("MySQL");
	messageBotDBName.sendKeys(Keys.RETURN);
	
	TimeUnit.SECONDS.sleep(3);
	
	// User says 'No'; Bot cancels the request.
	
	WebElement messageBotConfirm = driver.findElement(By.id("message-input"));
	messageBotConfirm.sendKeys("No");
	messageBotConfirm.sendKeys(Keys.RETURN);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='message_body' and text() = 'I am canceling the current request']")));
	WebElement msgFour = driver.findElement(
					By.xpath("//span[@class='message_body' and text() = 'I am canceling the current request']"));
	String messageFour = msgFour.getText();
	System.out.println(messageFour);
	assertNotNull(messageFour);
	
	TimeUnit.SECONDS.sleep(3);

}

}