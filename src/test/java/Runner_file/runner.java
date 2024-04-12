package Runner_file;


import org.testng.annotations.*;
import org.testng.annotations.Test;

import Step_definition.base_class;
//import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.*;

//@RunWith(Cucumber.class)
@CucumberOptions(
	features={"src/test/java/features_file"},
	glue={"Step_definition"},
	plugin = {"json:results/cucumberjson/cucumber.json"},	
	tags = "@TC_No_02"
	 
	
)

public class runner{
private TestNGCucumberRunner testng_cucumber_runner;
	
	@BeforeClass(alwaysRun = true)
	public void set_up_class() throws Throwable{
		testng_cucumber_runner = new TestNGCucumberRunner(this.getClass());
	}
	
	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void scenario(PickleWrapper pickle, FeatureWrapper cucumber_feature) {
		testng_cucumber_runner.runScenario(pickle.getPickle());
	}
	
	@DataProvider(name = "features")
	public Object[][] scenarios(){
		if(testng_cucumber_runner == null) {
			System.out.println("Runnner is returning null: dataprovider");
			testng_cucumber_runner = new TestNGCucumberRunner(this.getClass());
		}
		else {
			System.out.println("Runner is not null: dataprovider");
		}
		return testng_cucumber_runner.provideScenarios();
	}
	
	@AfterClass(alwaysRun = true)
	public void tear_down_class() throws Throwable{
		try {
			testng_cucumber_runner.finish();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterSuite(alwaysRun = true)
	public void terminate_driver() throws Throwable{
		try {
			System.out.println("Inside terminate_driver --->");
//			String[] cmd_commands = ("cmd /c start cmd.exe /K taskkill /im chromedriver.exe -f").split(" ");
//			Process p = Runtime.getRuntime().exec(cmd_commands);
//			p.waitFor();
//			p.exitValue();
			if(base_class.driver != null) {
				base_class.driver.quit();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
