import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver;

//Initializing server
System.setProperty("webdriver.chrome.driver", "C:/Users/vitalii.bashta/IdeaProjects/psd2/lib/chromedriver.exe");
ChromeDriver wd = new ChromeDriver();
wd.manage().window().maximize();
wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//login
System.out.println("*** login ***");
wd.get("https://www.squarespace.com/");
wd.findElement(By.xpath("//form[@id='form']/div[1]/paper-input/paper-input-container/div[2]/div/input")).click();
wd.findElement(By.xpath("//form[@id='form']/div[1]/paper-input/paper-input-container/div[2]/div/input")).clear();
wd.findElement(By.xpath("//form[@id='form']/div[1]/paper-input/paper-input-container/div[2]/div/input")).sendKeys("<USERNAME>");
wd.findElement(By.xpath("//form[@id='form']/div[2]/paper-input/paper-input-container/div[2]/div/input")).click();
wd.findElement(By.xpath("//form[@id='form']/div[2]/paper-input/paper-input-container/div[2]/div/input")).clear();
wd.findElement(By.xpath("//form[@id='form']/div[2]/paper-input/paper-input-container/div[2]/div/input")).sendKeys("<PASSWORD>");
wd.findElement(By.xpath("//form[@id='form']//paper-button[.='login']")).click();
try { Thread.sleep(3000l); } catch (Exception e) { throw new RuntimeException(e); }
if(wd.findElement(By.tagName("html")).getText().contains("please login")){
	System.out.println("Login failed");
throw ioe;
}//End of login
System.out.println("Login was executed successfully!");
System.out.println("Testcase finished successfully!");
wd.quit();