package Step_definition;

import static org.testng.Assert.*;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Utilities.Get_Data_from_excel;
import Utilities.common_methods;
import io.cucumber.java.en.*;

public class Step_defination_1 extends base_class  {

	// @TC_No.01

	@Given("Fill the details present in registration_form.")
	public void Registration_details()
	{
	  driver=new ChromeDriver();
	  driver.get("file:///C:/Users/nisha/Downloads/Folder/ui_api_db.html");
	  driver.manage().window().maximize();
	  WebElement first_name=driver.findElement(By.xpath("//input[@id='firstName']"));
	  first_name.sendKeys("Nishu");
	  WebElement last_name=driver.findElement(By.xpath("//input[@id='lastName']"));
	  last_name.sendKeys("Fatima");
	  
	  WebElement mobile=driver.findElement(By.name("mobile"));
	  mobile.sendKeys("1234567890");
	  
	  WebElement dropdown1=driver.findElement(By.xpath("//select[@name='qualification']"));
	  Select slt= new Select(dropdown1);
	  slt.selectByIndex(1);
	  
	  WebElement dropdown2= driver.findElement(By.id("govt_id_type"));
	  
	  Select slt2= new Select(dropdown2);
	  slt2.selectByValue("PAN");
	  
	  WebElement govt_id_num=driver.findElement(By.id("govt_id_num"));
	  govt_id_num.sendKeys("AFNPF3467N");
	  
	  WebElement email=driver.findElement(By.id("email"));
	  email.sendKeys("nishu@gmail.com");
	  
	  WebElement dob= driver.findElement(By.id("dob"));
	  dob.sendKeys("12-03-98");
	  
	  WebElement rdio_btn_exp=driver.findElement(By.xpath("//input[@value='0-3']"));
	  rdio_btn_exp.click();
	  
	  WebElement dropdown3=driver.findElement(By.id("preferred_role"));
	  
	  Select slt3= new Select(dropdown3);
	  slt3.selectByIndex(1);
	
	JavascriptExecutor js =(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500)");
	}
	
	@When("Upload the file")
	public void File_upload() {
		String File_name="D:/On_The_Spot_Award.pdf";
		  WebElement upload_file=driver.findElement(By.xpath("//input[@name='file']"));
		  upload_file.sendKeys(File_name);
		//upload_file.click();
		//String file_path = "‪C:/Users/nisha/Downloads/On_The_Spot_Award.pdf";
		//upload_file.sendKeys("‪C:/Users/nisha/Downloads/On_The_Spot_Award.pdf");
		/*  if(upload_file.isDisplayed())
		{
			System.out.println("file uploaded successfully");
			}
			else {
				System.out.println("upload get failed");
			}*/
		  
		WebElement upload_btn = driver.findElement(By.xpath("//button[text()='Upload']"));
		upload_btn.click();
		String str=File_name.split("/")[File_name.split("/").length -1];  //important on basis of split.
		
		String  alert1=driver.switchTo().alert().getText();
		System.out.println(alert1);
		String Expected_text=str + " has been uploaded successfully!";
		
		Assert.assertEquals(alert1,Expected_text);
	driver.switchTo().alert().accept();
	}
	

	@Then("Action on Submit button.")
	public void action_on_submit_button() {
		// Write code here that turns the phrase above into concrete actions

		WebElement submit = driver.findElement(By.xpath("//input[@value='Submit']"));

		submit.click();
		Alert alert=driver.switchTo().alert();
		String alert_msg=alert.getText();
		System.out.println(alert_msg);
		driver.switchTo().alert().accept();
	}


//TC_NO.02

@Given("Fill the details with required values {string}")
 public void fill_the_details_with_required_field_missing(String keyword) throws Throwable

 
 {
	driver=new ChromeDriver();
	  driver.get("file:///C:/Users/nisha/Downloads/Folder/ui_api_db.html");
	  driver.manage().window().maximize();
	  WebElement first_name=driver.findElement(By.xpath("//input[@id='firstName']"));
	  common_methods.send_keys(first_name,Get_Data_from_excel.Readexcelfile(keyword,"First Name"));
	  //first_name.sendKeys(Get_Data_from_excel.Readexcelfile(keyword,"First Name"));
	  WebElement last_name=driver.findElement(By.xpath("//input[@id='lastName']"));
	  last_name.sendKeys(Get_Data_from_excel.Readexcelfile(keyword,"Last Name"));
	  WebElement mobile=driver.findElement(By.name("mobile"));
	  mobile.sendKeys(Get_Data_from_excel.Readexcelfile(keyword,"Mobile"));
	  
	  WebElement dropdown1=driver.findElement(By.xpath("//select[@name='qualification']"));
	  Select slt= new Select(dropdown1);
	  slt.selectByIndex(1);
	  
	  WebElement dropdown2= driver.findElement(By.id("govt_id_type"));
	  
	  Select slt2= new Select(dropdown2);
	  //System.out.println(Government_ID);
	  slt2.selectByVisibleText(Get_Data_from_excel.Readexcelfile(keyword,"Government ID"));
	  
	  
	  WebElement govt_id_num=driver.findElement(By.id("govt_id_num"));
	  govt_id_num.sendKeys(Get_Data_from_excel.Readexcelfile(keyword,"Govt.ID number"));
	  
	  WebElement email=driver.findElement(By.id("email"));
	  email.sendKeys(Get_Data_from_excel.Readexcelfile(keyword,"Email"));
	  
	  WebElement dob= driver.findElement(By.id("dob"));
	  dob.sendKeys(Get_Data_from_excel.Readexcelfile(keyword,"Date of Birth"));
	  
	  //WebElement rdio_btn_exp=driver.findElement(By.xpath("//input[@value='0-3']"));
	  //rdio_btn_exp.click();
	  List<WebElement> radio_btn_list=driver.findElements(By.xpath("//input[@id='exp']"));
	  for(WebElement radio_btn:radio_btn_list) {
		  System.out.println(radio_btn.getText());
		  if(radio_btn.getText().equals(Get_Data_from_excel.Readexcelfile(keyword,"Experience Range"))) {
			  System.out.println("Selected");
			  radio_btn.click();
		  }
		  
		  
		  
		  
	  }
	  
	  WebElement dropdown3=driver.findElement(By.id("preferred_role"));
	  
	  Select slt3= new Select(dropdown3);
	  slt3.selectByIndex(1);
	
	JavascriptExecutor js =(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500)");
	
	
		String File_name=Get_Data_from_excel.Readexcelfile(keyword,"Upload Resume Path");
		  WebElement upload_file=driver.findElement(By.xpath("//input[@name='file']"));
		  upload_file.sendKeys(File_name);
		//upload_file.click();
		//String file_path = "‪C:/Users/nisha/Downloads/On_The_Spot_Award.pdf";
		//upload_file.sendKeys("‪C:/Users/nisha/Downloads/On_The_Spot_Award.pdf");
		/*  if(upload_file.isDisplayed())
		{
			System.out.println("file uploaded successfully");
			}
			else {
				System.out.println("upload get failed");
			}*/
		  
		WebElement upload_btn = driver.findElement(By.xpath("//button[text()='Upload']"));
		upload_btn.click();
		String str=File_name.split("/")[File_name.split("/").length -1];  //important on basis of split.
		
		String  alert1=driver.switchTo().alert().getText();
		System.out.println(alert1);
		String Expected_text=str + " has been uploaded successfully!";
		
		Assert.assertEquals(alert1,Expected_text);
	driver.switchTo().alert().accept();
 }
	
@And("Click on Submit button")

public void submit_button() {
	
		WebElement submit = driver.findElement(By.xpath("//input[@value='Submit']"));

		submit.click();
		Alert alert=driver.switchTo().alert();
		String alert_msg=alert.getText();
		System.out.println(alert_msg);
		driver.switchTo().alert().accept();
	

}
@Then("Verify the result {string}")
public void validate_result(String result) {
	

	WebElement Error_msg=driver.findElement(By.xpath("//span[@class='error-message' and @style='display: inline;']"));
	String msg_disp=Error_msg.getText();
	System.out.println(msg_disp);
	Assert.assertEquals(msg_disp ,"Please enter your first name");
 }
}


