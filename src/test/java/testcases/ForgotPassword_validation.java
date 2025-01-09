package testcases;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class ForgotPassword_validation_dataProvider 
{


	//***********DUE TO SYNCHRONISATION ISSUE WEBSITE MAY TAKE SOME TIME 
			//-->BUT ALLL SCRIPTS ARE EXECUTING PROPERLY WITH ALL VALIDATION POINTS********
			

	String exp_msg="Verification code sent succesfully";
	//WebElement Verification_code=driver.findElement(By.xpath("//div[text()='Verification Code']"));
	
	
	WebDriver driver=new ChromeDriver();
	
	
	
	@Test(dataProvider="ForgotpasswordData")
	public void loginTest(String email,String errormsg) throws Exception
	{
		 try
		 {
		driver.get("https://app-staging.nokodr.com");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement forgotlink=driver.findElement(By.xpath("//a[text()='Forgot Password?']"));
		forgotlink.click();
		

		 WebElement emailTxtField;
		
		 emailTxtField=driver.findElement(By.xpath("//section[@role='dialog']//input"));
		 emailTxtField.sendKeys(email);
			
			WebElement Proceedbtn=driver.findElement(By.xpath("//div[text()='Proceed']"));
		    Proceedbtn.click();
		
 Thread.sleep(5000);
		    
		    WebElement error_Email_PWD= driver.findElement(By.xpath("//div[@role='status']"));
			String errormsg_Email_PWD=error_Email_PWD.getText();
			 	  
			 	  
			     //KEEPING EMAIL FIELD AS BLANK--->checking for mandatory fields
			 	 if(emailTxtField.getText().equals(""))
			 	{
			 		
			     	// Assert.assertTrue(errormsg.contains(exp_pwderror));
			 		System.out.println("Email blank error:"+errormsg_Email_PWD);
			 		 Assert.assertTrue(false);
			 	}   

				//USER DOES NOT EXISTS-->NON REGISTERED EMAIL
			     else if(!emailTxtField.getText().equals("shubhangijadhav95@gmail.com") || !emailTxtField.getText().equals("shubhangijadhav865@gmail.com"))
			        {
			     	
			     	System.out.println("Error:"+errormsg_Email_PWD);
			     	Assert.assertTrue(false);
			     	}
			     
			   
			 	     
			 	    //Thread.sleep(5000);
			 	    
			 	    WebElement errormsgs= driver.findElement(By.xpath("//div[@class='slds-form-element__help']"));
			 		String errormsg_email=errormsgs.getText();
			 		   
			 		    //*****Special chars in email--->INVALID EMAIL FORMAT
			 		   if(emailTxtField.getText().contains("$") ||!emailTxtField.getText().contains("%") || !emailTxtField.getText().contains("#"))
			 	  		{
			 	    	 
			 	  			System.out.println("Error:"+errormsg_email);
			 	  			Assert.assertTrue(false);
			 	  		}
			 		  
			 		
			 		
			 	    }
			 		  
			    	catch(Exception e)
			{
			    		
			}
		
		 	//SUCCESS MESSAGE FOR ALREADY EXISTING USER
		 		  if(driver.getPageSource().equalsIgnoreCase("Verification code sent successfullly"))
		          {
					  try
						 {
					 
					 System.out.println("Reset link sent Successfully!!!!!");
					 
					// Assert.assertTrue(true);
					
					 
					// driver.findElement(By.xpath("//img[@src='https://assets.nokodr.com/system/images/username.png']")).click();
					// driver.findElement(By.xpath("//a[text()='Log Out']")).click();
					    }
					 catch(Exception e)
						{
						  
							
					    }
		          
		          }
		 		
		
		}
		    	
		
			
			  
			 
  @DataProvider(name="ForgotpasswordData")
	public Object[][] getData()
	{
		Object  loginData[][]=
			{

					
					{"shubhangijadhav@gmail.com","User does not exists"},
					{"abc#gmail.com","Invalid Email format-Please enter a valid email"},
					{"","Please enter email"},
					{"shubhangijadhav95@gmail.com","Already Registered User"}
					
					
			};
		return loginData;
	}





}
