package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Basic_Script {

	
	@Test
	public void launchURL()
	{
		
		WebDriver driver=new ChromeDriver();
		
		
		driver.get("https://app-staging.nokodr.com");
		
		driver.manage().window().maximize();
		

	}

}
