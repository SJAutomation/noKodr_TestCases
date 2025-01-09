package testcases;


	import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

	public class Login_vaidationThroughDataprovider
	{
//***********DUE TO SYNCHRONISATION ISSUE WEBSITE MAY TAKE SOME TIME 
		//-->BUT ALLL SCRIPTS ARE EXECUTING PROPERLY WITH ALL VALIDATION POINTS********
		
		WebDriver driver=new ChromeDriver();
		WebElement email;
		WebElement password;
		WebElement loginbtn;
		
		@Test(dataProvider = "LoginData")
		public void Login(String emailid,String pwd) throws InterruptedException
		{
			 String expURL="https://app-staging.nokodr.com/super/apps/user-profile/v1/index.html#/";
			
			 driver.get("https://app-staging.nokodr.com");
				
				
				String exp_email="shubhangijadhav865@gmail.com";
				String exp_password="abcb%%$$9A";
			
			try
			{
			
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

			
			    
			email=driver.findElement(By.xpath("//input[@type='email']"));
		    email.sendKeys(emailid);
		    

	    	 password=driver.findElement(By.xpath("//input[@type='password']"));
		    password.sendKeys(pwd);
		 
		    

		    
		  
		     loginbtn=driver.findElement(By.xpath("//div[text()='Log In']"));
		    loginbtn.click();
		    
		    Thread.sleep(2000);
		    
		    WebElement error_Email_PWD= driver.findElement(By.xpath("//div[@role='status']"));
			String errormsg_Email_PWD=error_Email_PWD.getText();
			 	  
			 	  
			     //KEEPING EMAIL FIELD AS BLANK--->checking for mandatory fields
			 	 if(email.getText().equals(""))
			 	{
			     	// Assert.assertTrue(errormsg.contains(exp_pwderror));
			 		System.out.println("Email blank error:"+errormsg_Email_PWD);
			 	}   

				//KEEPING PASSWORD FIELD AS BLANK--->checking for mandatory fields
			     else if(password.getText().contains(""))
			        {
			     	
			     	System.out.println("Error:"+errormsg_Email_PWD);
			     	}
			     
			   
			 	     
			 	    //Thread.sleep(5000);
			 	    
			 	    WebElement errormsgs= driver.findElement(By.xpath("//div[@class='slds-form-element__help']"));
			 		String errormsg_email=errormsgs.getText();
			 		   
			 		    //*************Special chars in email
			 		   if(email.getText().contains("$") ||!email.getText().contains("%") || !email.getText().contains("#"))
			 	  		{
			 	    	 
			 	  			System.out.println("Error:"+errormsg_email);
			 	  		}
			 		  
			 		
			 		
			 	    }
			 		  
			    	catch(Exception e)
			{
			    		
			}
			
			//LOGIN SUCESS
			  if(driver.getCurrentUrl().equals(expURL))
	          {
				  try
					 {
				  //Assert.assertTrue(true);
				 System.out.println("Login Successfully!!!!!");
				 
				 
				
				 
				 driver.findElement(By.xpath("//img[@src='https://assets.nokodr.com/system/images/username.png']")).click();
				 driver.findElement(By.xpath("//a[text()='Log Out']")).click();
				 }
				 catch(Exception e)
					{
					  
						
				 }
					
				// Thread.sleep(5000);
				 
				
				
				  
				 
	          }
			  //INVALID USERNAME OR PASSWORD
			  else if(!email.equals(exp_email) && !password.equals(exp_password))
				{
					System.out.println("Invalid email or password"); //INVALID USERNAME OR PASSWORD
					Assert.assertTrue(false);
					
				}
					 
			
			 
			
			

		}
			
//	       else if(password.getText().length()<pass_len)
//				{
//					System.out.println("Password length should be minimum 8 chars error:"+errormsg);
//				}
			
		
	
		
		  @DataProvider(name="LoginData")
			public Object[][] getData()
			{
				Object  loginData[][]=
					{
						
						{"shubhangijadhav#gmail.com","abc123"},
						
						{"shubhangijadhav@gmail.com",""},
						
						{"shubhangijadhav865@gmail.com","abcb%%$$9A"},
						
						 
						 {"","abc123#"},
						 
						
						 
						 
						 
						
						
						
						
						
							
							
							
					};
				return loginData;
			}
	}
		
		 		
		 
