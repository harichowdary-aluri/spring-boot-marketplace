package com.Login;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class Testing {
	public static void main(String [] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\s546945\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		driver.get("https://sso.nwmissouri.edu/adfs/ls/?client-request-id=86d24bad-8be1-4e2b-af4f-8a70a9d4ee17&username=&wa=wsignin1.0&wtrealm=urn%3afederation%3aMicrosoftOnline&wctx=estsredirect%3d2%26estsrequest%3drQQIARAA42KwUs8oKSmw0tfPK8_NLC7OLy3K1MvMKy4pKk0uKS1K1UvOz9UvTszNMSoS4hJY632p7WG3tt96_66ClVfeic9i5EPSlppSuopRF2RcMX7zcvLTM_PAph5iVI03SzZNM0tOM9I1MrM00TVJTTHQtUwyMddNNDNKM062sDSxTDS8wMj4gpHxFhNrMMgpv5hMS4vyrPITizOLrfISc1OLrUqSrYIdfX2sDPUMwSKZKbpp-UW5iSVWpXnFBanJmWmZqSmbmFXMjY1NDQwN03QNzU0sdE0sDYx0LVJSU3XN0kxSEpMNjM0sTC0vsPC8YuExYLbi4OASYJBgUGD4wcK4iBXof7Xo_VvvTS7zXeUzb87lRBGGU6z6ZSGVPsVO5VlmmfmW2UkeppEV7iHOTiWJKeHh_ul-JSX5xgE5KeEVoU4mBrbmVoYT2HhPsTF8YGPsYGeYxc6wi5O08DrAy_CD7_Xzj6dXPVn-1gMA0#");
		
		driver.findElement(By.id("userNameInput")).sendKeys("s546945@nwmissouri.edu");
		Thread.sleep(1000);
		
	  driver.findElement(By.id("passwordInput")).sendKeys("Reddy@123");
	  Thread.sleep(1000);
	  driver.findElement(By.id("submitButton")).click();
	  Thread.sleep(1000);
	  

	  
	 driver.close();
	  
	}
}
