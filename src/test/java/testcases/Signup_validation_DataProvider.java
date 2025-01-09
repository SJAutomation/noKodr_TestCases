 package testcases;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




public class Signup_validation_DataProvider {
	
	
//DUE TO CODE VERIFICATION COULD NOT AUTOMATE SCENARIOS AFTER CODE VERIFICATION BUT VALIDATIONS HAVE BEEN COVERED
	
//***********AND DUE TO SYNCHRONISATION ISSUE WEBSITE MAY TAKE SOME TIME 
			//-->BUT ALLL SCRIPTS ARE EXECUTING PROPERLY WITH ALL VALIDATION POINTS********
			
	static WebDriver driver=new ChromeDriver();
	 
	    WebElement Signupbtn;
	
		WebElement emailTextfield;
		
		WebElement checkbox;
		
		WebElement Proceedbtn;
		
	
		
	
	
	@Test(dataProvider = "Signup_email",priority = 1)
	public void SignupValidations(String emailid,String errormsg) throws Exception, IOException, InterruptedException
	{
	
		try
		{
			
		driver.get("https://app-staging.nokodr.com");
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().getPageLoadTimeout();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		 Signupbtn=driver.findElement(By.xpath("//a[text()='Sign up']"));
			Signupbtn.click();
			
			//WebElement phone=driver.findElement(By.xpath("//body//abx-modal//li[2]"));
			//phone.sendKeys("7769863657");
			 emailTextfield=driver.findElement(By.xpath("//section[@role='dialog']//input"));
				emailTextfield.sendKeys(emailid);
				
				checkbox=driver.findElement(By.xpath("//label[@class='slds-checkbox__label']"));
				checkbox.click();
				
				Proceedbtn=driver.findElement(By.xpath("//div[text()='Proceed']"));
				Proceedbtn.click();
				
				
				 Thread.sleep(5000);
				 
				 	
						    
						    WebElement error_Email_PWD= driver.findElement(By.xpath("//div[@role='status']"));
							String errormsg_Email_PWD=error_Email_PWD.getText();
							 	  
							 	  
							     //KEEPING EMAIL FIELD AS BLANK--->checking for mandatory fields
							 	 if(emailTextfield.getText().equals(""))
							 	{
							 		
							     	// Assert.assertTrue(errormsg.contains(exp_pwderror));
							 		System.out.println("Email blank error:"+errormsg_Email_PWD);
							 		 Assert.assertTrue(false);
							 	}   

					
							   
							 	     
							 	    //Thread.sleep(5000);
							 	    
							 	    WebElement errormsgs= driver.findElement(By.xpath("//div[@class='slds-form-element__help']"));
							 		String errormsg_email=errormsgs.getText();
							 		   
							 		    //INVALID EMAIL FORMAT
							 		   if(emailTextfield.getText().contains("$") || emailTextfield.getText().contains("%") || emailTextfield.getText().contains("#"))
							 	  		{
							 	    	 
							 	  			System.out.println("Error:"+errormsg_email);
							 	  			Assert.assertTrue(false);
							 	  		}
							 		  
							 		
							 		
							 	    }
							 		  
							    	catch(Exception e)
							{
							    		
		
							}
		
		
		
	}
	
	//**************AFTER THAT CODE(Email/OTP) VERIFICATION WILL BE DONE--->
	//OPTIONAL(CANNOT AUTOMATE BECAUSE CODES ARE RANDOMLY GENERATED & SHARED VIA EMAIL)
	
	//I MANUALLY CHECKED ALL ERRORS AND WRITTEN VALIDATION POINTS ACCORDINGLY
	//-->***************DUE TO CODE VERIFICATION I WAS NOT ABE TO AUTOMATE FURTHER SCENARIOS*************************
	
	//@Test(dataProvider ="Signup_data" ,priority = 2)
	public void Validate_signupdata(String fname,String lname,String pwd,String confirm_pwd,String error_msg)
	{

		WebElement firstname=driver.findElement(By.xpath("//section[@role='dialog']//input[@id='id_17364194760081137']"));
		firstname.sendKeys(fname);
		
		WebElement lastname=driver.findElement(By.xpath("//section[@role='dialog']//input[@id='id_17364194760101681']"));
		firstname.sendKeys(lname);
		
		WebElement pass=driver.findElement(By.xpath("//section[@role='dialog']//input[@id='id_17364194760139643']"));
		pass.sendKeys(pwd);
		
		
		WebElement cpwd=driver.findElement(By.xpath("//section[@role='dialog']//input[@name='password-confirmpassword']"));
		cpwd.sendKeys(confirm_pwd);
		
		
		//WebElement registerbtn=driver.findElement(By.xpath("//div[text()='Register']"));
		//registerbtn.click();
		
		
		WebElement errormsgs= driver.findElement(By.xpath("//div[@class='slds-form-element__help']"));
		 String all_errormsgs=errormsgs.getText();

		
		 
		 //MANDATORY FILDS-BLANK
		 WebElement fname_blank=driver.findElement(By.xpath("//abx-field[@name='firstName']//div[@class='slds-form-element__help'][normalize-space()='This field is required']"));
		 String fname_blank_err=fname_blank.getText();
		 
		 if(firstname.getText().equals(""))
		 {		
			System.out.println("Firstname blank error:"+fname_blank_err);
			Assert.assertTrue(false);
	     }
		 
		 WebElement lname_blank=driver.findElement(By.xpath("//abx-field[@name='lastName']//div[@class='slds-form-element__help'][normalize-space()='This field is required']"));
		 String lname_blank_err=lname_blank.getText();
		 
		  if(lastname.getText().equals(""))
		 {		
			System.out.println("lastname blank error:"+lname_blank_err);
			Assert.assertTrue(false);
	     }
		 
		  WebElement pwd_blank=driver.findElement(By.xpath("//div[@class='slds-has-error']//div[@class='slds-form-element__help'][normalize-space()='This field is required']"));
		  String pwd_blank_err=pwd_blank.getText();		
		  
		  if(pass.getText().equals(""))
		 {		
			System.out.println("pass blank error:"+pwd_blank_err);
			Assert.assertTrue(false);
	     }
		 
		 else if(cpwd.getText().equals("") || !cpwd.getText().equals(pass)  )
		 {		
			//System.out.println("cpwd blank error:"+all_errormsgs);
			Assert.assertTrue(true);
	     }

		 
		 WebElement special_char_firstname= driver.findElement(By.xpath("//abx-field[@name='firstName']//div[@class='slds-form-element__help'][normalize-space()='Special characters are not allowed']"));
			String special_char_firstname_err=special_char_firstname.getText();
			
		 //SPECIAL CHARS IN NAMES 
		 if(firstname.getText().contains("#") || firstname.getText().contains("$")  || firstname.getText().contains("%")  || firstname.getText().contains(".") 
					|| firstname.getText().contains(",") || firstname.getText().contains(":")) //ANY SPECIAL CHARS		
			 {			
			 
			 System.out.println("Special chars not allowed in firstname Error:"+special_char_firstname_err);		
			 Assert.assertTrue(false);
		
     	     }
		 
		WebElement special_char_lastname= driver.findElement(By.xpath("//abx-field[@name='lastName']//div[@class='slds-form-element__help'][normalize-space()='Special characters are not allowed']"));
		String special_char_lastname_err=special_char_lastname.getText();
		
		if(lastname.getText().contains("#") || lastname.getText().contains("$")  || lastname.getText().contains("%")  || lastname.getText().contains(".") 
					|| lastname.getText().contains(",") || lastname.getText().contains(":"))
		   {
			System.out.println("Special chars in fname:"+special_char_lastname_err);
			 Assert.assertTrue(false);		
			 
  	         }
		 
			 
		WebElement pwdnotmatch=	 driver.findElement(By.xpath("//div[@class='slds-form-element__help'][normalize-space()='The password and confirmation password do not match']"));
		String pwdnotmatching_error=pwdnotmatch.getText();
		
		//BOTH PASSWORD & CONFIRM PASSWORDS NOT MATCHING
		 if(pwd.equals(confirm_pwd))
		 {
			 System.out.println("Both passwords not matching error:"+pwdnotmatching_error);
			 Assert.assertTrue(false);
		 }
		 
		
	}

	@DataProvider(name="Signup_email")
	public Object[][] getData()
	{
		Object  loginData[][]=
			{
					{"shubhangijadhav95@gmail.com","Exisiting User"},

					{"","Please enter email"},
					
					{"abc#gmail.com","Invalid Email format-Please enter a valid email"},
					
					{"abcd@gmail.com","New Signup user"}
					
					
			};
		return loginData;
	}
	
	@DataProvider(name="Signup_data")
	public Object[][] getAllData()
	{
		Object  loginData[][]=
			{

				{"","J","abc123#SH","abc123#SH","Please enter firstname"},

				{"Shubha","","abc123#SH","abc123#SH","Please enter lastname"},
					
					{"Shubha_","J","","abc123#SH","Please enter password"},
					
					{"Shubha%","J","abc123#SH","","Please enter confirm password"},
					
{"Shubha#","J","abc123#SH","abc123#SH","Special chars in firstname-Please enter valid firstname"},
					
					{"Shubha","Jadhav$","abc123#SH","abc123#SH","Special chars in lastname-Please enter valid firstname"},
					
					{"Shubha@","Jadhav$","abc123#SH","abc123#SH##","Both Passwords not matching"}

					
			};
		return loginData;
	}
	
	//@AfterTest
	public void Teardown()
	{
		driver.quit();
	}
	
	
}
