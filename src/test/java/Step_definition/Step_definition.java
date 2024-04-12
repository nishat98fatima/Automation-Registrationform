package Step_definition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;

public class Step_definition extends base_class {
	

	@Given("User Login the URL {string}")
	public void user_login_the_url(String url) {
		// Write code here that turns the phrase above into concrete actions
		 driver = new ChromeDriver();
		driver.get(url);

	}

	@When("URL open successfully.")
	public void url_open_successfully() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		driver.manage().window().maximize();
		//Thread.sleep(10);
	}

	@Then("Click on Register link.")
	public void click_on_register_link() {
		// Write code here that turns the phrase above into concrete actions
		WebElement registerlink = driver.findElement(By.xpath("//a[text()='Register']"));

		registerlink.click();
	}

	@Then("Provide Customer details.")
	public void provide_customer_details() {
		WebElement firstname = driver
				.findElement(By.xpath("//td/b[text()='First Name:']/parent::td/following-sibling::td/input"));
		firstname.sendKeys("Nisha");

		WebElement lastname = driver
				.findElement(By.xpath("//td/b[text()='Last Name:']/parent::td/following-sibling::td/input"));
		lastname.sendKeys("Kumari");

		WebElement Address = driver
				.findElement(By.xpath("//td/b[text()='Address:']/parent::td/following-sibling::td/input"));
		Address.sendKeys("Shapoorji");

		WebElement city = driver.findElement(By.xpath("//td/b[text()='City:']/parent::td/following-sibling::td/input"));
		city.sendKeys("Kolkata");

		WebElement state = driver
				.findElement(By.xpath("//td/b[text()='State:']/parent::td/following-sibling::td/input"));
		state.sendKeys("WestBengal");

		WebElement Zipcode = driver
				.findElement(By.xpath("//td/b[text()='Zip Code:']/parent::td/following-sibling::td/input"));
		Zipcode.sendKeys("700135");

		WebElement PHONE = driver
				.findElement(By.xpath("//td/b[text()='Phone #:']/parent::td/following-sibling::td/input"));
		PHONE.sendKeys("7870692863");

		WebElement SSN = driver.findElement(By.xpath("//td/b[text()='SSN:']/parent::td/following-sibling::td/input"));
		SSN.sendKeys("123496");

		WebElement username = driver
				.findElement(By.xpath("//td/b[text()='Username:']/parent::td/following-sibling::td/input"));
		username.sendKeys("Kumar");
		WebElement password = driver
				.findElement(By.xpath("//td/b[text()='Password:']/parent::td/following-sibling::td/input"));
		password.sendKeys("Nk321");
		WebElement CONFIRM = driver
				.findElement(By.xpath("//td/b[text()='Confirm:']/parent::td/following-sibling::td/input"));
		CONFIRM.sendKeys("Nk321");
	}
	@Then("Count the number of textfield.")

	public void number_of_textfield_present() {
     List <WebElement> total_textbox=driver.findElements(By.xpath("//input[@class='input']"));
    int Total_number =total_textbox.size();
    System.out.println(Total_number);
	}
	
	

	

	@Then("Click on RegisterButton.")
	public void Click_on_RegisterButton() {
		driver.findElement(By.xpath("//input[@value='Register' and @class='button']")).click();

	}
	@Then("Print Welcome message.")
	public void Print_Welcome_message() {
		WebElement Print=driver.findElement(By.xpath("//h1[@class='title']/following-sibling::p"));
		String Print_text=Print.getText();
		System.out.println(Print_text);
		
		}
	
	//@TC_No.03
	@Given("Click on Account_Overview Link.")
	public void Account_Overview_link() throws Throwable {
		WebElement AO_Link=driver.findElement(By.xpath("//a[text()='Accounts Overview']"));
		AO_Link.click();
		Thread.sleep(5000);
	}
	@When("Link get clicked successfully get account_details.")
	public void Account_details() {
		WebElement Account= driver.findElement(By.xpath("//a[@class='ng-binding']"));
		Account.getText();
		String Account_No=Account.getText();
		System.out.println("Account number is"+" " +Account_No);
		WebElement Balance=driver.findElement(By.xpath("//a[@class='ng-binding']//ancestor::tr//child::td[2]"));
		Balance.getText();
		String Print_Balance=Balance.getText();
		System.out.println("Toatal Balance is"+" " +Print_Balance);
		WebElement Available_Amount=driver.findElement(By.xpath("//a[@class='ng-binding']//ancestor::tr//child::td[3]"));
		Available_Amount.getText();
		String Print_Available_Amount=Available_Amount.getText();
		System.out.println("Available_amount is:" +Print_Available_Amount);
		WebElement Total=driver.findElement(By.xpath("//b[@class='ng-binding']"));
		Total.getText();
		String Print_Total=Total.getText();
		System.out.println("Total_Amount is"+" "+Print_Total);
		}
	@Then("Click on Account_Number.")
	public void Account_Number_click() {
		
		WebElement Account_Number=driver.findElement(By.xpath("//a[@class='ng-binding']"));
		Account_Number.click();
		
	}
	@Given("Provide User Name and Password.")
	  
	  public void Provide_User_Name_and_Password()
	  {
		
		  
	  WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
	  username.sendKeys("Kumar");
	  WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
	  password.sendKeys("Nk321");
	  
	}
	 @Then("click on login button.") 
	 public void click_on_login_button(){
		 WebElement login_button=driver.findElement(By.xpath("//input[@type='submit']"));
		 login_button.click();
		 
	 }
	 
	 //TC_No.03
	 
	 @Given("Select Dropdown.")
	 public void select_dropdown(){
		List<WebElement> options= driver.findElements(By.xpath("//select[@id=\"month\"]"));
		//Select objSelect=new Select(dropdown);
		//objSelect.selectByIndex(2);
		for (WebElement option : options) {
			//option.click();
			System.out.println(option.getText());
			
		}
		
		
		 
	 }
	 
	 
	 
	

}




	
  