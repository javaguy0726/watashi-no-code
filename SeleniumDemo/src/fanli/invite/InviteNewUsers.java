package fanli.invite;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InviteNewUsers {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"F:\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver",
				"F:\\IEDriverServer.exe");
		WebDriver driver = null;
		try {

			driver = new FirefoxDriver();
			driver.get("http://passport.51fanli.com/login");
			
			(new WebDriverWait(driver, 20))
			.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
					return d.findElement(By.id("codeimg"))
							.isDisplayed();
				}
			});
			
			WebElement username = driver.findElement(By.id("username"));
			WebElement password = driver.findElement(By.id("psw"));
			WebElement code = driver.findElement(By.id("passcode"));
			WebElement cooklogin = driver.findElement(By.id("cooklogin"));
			WebElement btnlogin = driver.findElement(By.id("btn-login"));
			System.out.println("Please input the code:");
			 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			 String user_code = br.readLine();
			 
			 username.sendKeys("javaguy");
			password.sendKeys("selenium2013");
			
		
			 code.sendKeys(user_code);
			
			 cooklogin.click();
			 btnlogin.click();
			 
			 (new WebDriverWait(driver, 20))
				.until(new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver d) {
						return d.findElement(By.id("menu-cs-hd"))
								.isDisplayed();
					}
				});
			 
			 WebElement invite_friend = driver.findElement(By.xpath("//*[@id='side-menu']/div[5]/ul/li[4]/a"));
			 
			 invite_friend.click();
			 
			 (new WebDriverWait(driver, 20))
				.until(new ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver d) {
						return d.findElement(By.id("btn-invite-link"))
								.isDisplayed();
					}
				});
			 (new WebDriverWait(driver, 20))
			 .until(new ExpectedCondition<Boolean>() {
				 public Boolean apply(WebDriver d) {
					 return d.findElement(By.id("btn-invite-mail"))
							 .isDisplayed();
				 }
			 });
			 
			 WebElement invite_url = driver.findElement(By.id("btn-invite-link"));
			 invite_url.click();
			 
			 (new WebDriverWait(driver, 20))
			 .until(new ExpectedCondition<Boolean>() {
				 public Boolean apply(WebDriver d) {
					 return d.findElement(By.id("popup-link"))
							 .isDisplayed();
				 }
			 });
			 
			 WebElement green_link = driver.findElement(By.id("btn-link-green"));
			 WebElement red_link = driver.findElement(By.id("btn-link-red"));
			 WebElement p_link = driver.findElement(By.id("plink"));
			
			 String red_link_text = red_link.getText();
			 int begin_bracket_index = red_link_text.lastIndexOf("(");
			 int end_bracket_index = red_link_text.lastIndexOf(")");
			 
			int redbag_number = Integer.valueOf(red_link_text.substring(begin_bracket_index+1, end_bracket_index)).intValue();
			 System.out.println(redbag_number);
			 
			 String link_origin_value  =  p_link.getAttribute("value");
			 	 for(int i=0;i< redbag_number;i++){
				  red_link.click();
				  while (p_link.getAttribute("value") == link_origin_value){
					  Thread.sleep(200);
				  }
				  Thread.sleep(2000);
				  link_origin_value = p_link.getAttribute("value");
				  BufferedWriter writer = new BufferedWriter(new FileWriter("c:\\results"));
			 }
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}
