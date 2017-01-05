package icicibank;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GenericWrappers implements Wrappers {

	RemoteWebDriver driver;
	int i=1;
	String parentHandle="";


	public void invokeApp(String browser, String url) {

		if(browser.equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
		driver = new FirefoxDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		takeSnap();
	}

	
	public void enterById(String idValue, String data) {
		
		driver.findElementById(idValue).clear();
		driver.findElementById(idValue).sendKeys(data);
		System.out.println("The Text "+data+" entered successfully");
		takeSnap();
	}

	
	public void enterByName(String nameValue, String data) {
		
		driver.findElementByName(nameValue).clear();
		driver.findElementByName(nameValue).sendKeys(data);
		System.out.println("The Text "+data+" entered successfully");
		takeSnap();

	}

	
	public void enterByXpath(String xpathValue, String data) {
	
		driver.findElementByXPath(xpathValue).clear();
		driver.findElementByXPath(xpathValue).sendKeys(data);
		System.out.println("The Text "+data+" entered successfully");
		takeSnap();

	}

	
	public boolean verifyTitle(String title) {
		String sampletitle = driver.getTitle();
		if(title.equals(sampletitle))
		{
			System.out.println("The verified title is "+title);
			return true;
	
		}
		else
		{
			System.out.println("title does not match");	
			takeSnap();
			return false;
			
		}
		
	}

	
	public void verifyTextById(String id, String text) {
		String sampletext = driver.findElementById(id).getText();
		if(text.equals(sampletext))
		{
			System.out.println("The text "+text+" is successfully verified");
		}
		else 
			System.out.println("The text " +text+ " does not match" );
		takeSnap();
	}

	
	public void verifyTextByXpath(String xpath, String text) {
		String samplexpath = driver.findElementByXPath(xpath).getText();
		if(text==samplexpath)
		{
			System.out.println("The text "+text+" is successfully verified");
		}
		else 
			System.out.println("The text " +text+ " does not match" );
		takeSnap();
	}

	
	public void verifyTextContainsByXpath(String xpath, String text) {
		String samplexpath = driver.findElementByXPath(xpath).getText();
		
		if(samplexpath.contains(text))
		{
			System.out.println("The text: "+text+" contains the xpath "+samplexpath);
		}
		else
			System.out.println("The text: "+text+" does not contains the xpath "+samplexpath);
		takeSnap();
	}

	
	public void verifyTextContainsById(String id, String text) {
String sampleid = driver.findElementById(id).getText();
		
		if(sampleid.contains(text))
		{
			System.out.println("The text: "+text+" contains the xpath "+sampleid);
		}
		else
			System.out.println("The text: "+text+" does not contains the xpath "+sampleid);
		takeSnap();
	}

	
	public void clickById(String id) {
		
		driver.findElementById(id).click();
		System.out.println("The Button "+id+" is clicked successfully");
		takeSnap();
	}

	
	public void clickByClassName(String classVal) {
		
		driver.findElementByClassName(classVal).click();
		System.out.println("The Button "+classVal+" is clicked successfully");
		takeSnap();

	}

	public void clickBytagname(String id)
	{
		driver.findElementByTagName(id).click();
		System.out.println("The button "+id+" is clicked successfully");
		takeSnap();
	
	}
	public void clickByName(String name) {
		
		driver.findElementByName(name).click();
		System.out.println("The Button "+name+" is clicked successfully");
		takeSnap();

	}

	
	public void clickByLink(String name) {
		driver.findElementByLinkText(name).click();
		System.out.println("The Button "+name+" is clicked successfully");
		takeSnap();


	}

	
	public void clickByXpath(String xpathVal) {
		driver.findElementByXPath(xpathVal).click();
		System.out.println("The xpath "+xpathVal+" is clicked successfully");
		takeSnap();	
	}

	public void clickandwaitByXpath(String name){
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(name)));
		takeSnap();
		
	}
	public String getTextById(String idVal) {
		String text = driver.findElementById(idVal).getText();
		System.out.println(text);
		takeSnap();
		return text;
	}

	
	public String getTextByXpath(String xpathVal) {
		String text = driver.findElementByXPath(xpathVal).getText();
		System.out.println(text);
		takeSnap();
		return text;
	}

	
	public void selectVisibileTextByClass(String id, String value) {
	
		WebElement vtext = driver.findElementByClassName(id);

		Select vtext1 = new Select(vtext);
		
		vtext1.selectByVisibleText(value);

		System.out.println(vtext1);
		
		takeSnap();
	}

	
	public void selectIndexById(String id, int value) {
		WebElement index = driver.findElementById(id);

		Select index1 = new Select(index);
		
		index1.selectByIndex(value);

		System.out.println(index1);
		
		takeSnap();
	
	}

	
	public void getParentWindowHandle() {
		parentHandle = driver.getWindowHandle();

	}

	
	public String switchToParentWindow() {
		driver.switchTo().window(parentHandle);
		//takeSnap();
		return parentHandle;

	}
	
	
	public void switchToLastWindow() {
		
		Set<String> allwindow = driver.getWindowHandles();
		int windowsize = allwindow.size();
		System.out.println("size of windows: "+windowsize);
		for (String eachwind : allwindow) {
			
			driver.switchTo().window(eachwind);
					
		}
		//takeSnap();
	}

	
	public void acceptAlert() {
		driver.switchTo().alert().accept();
		takeSnap();
	}

	
	public void quitBrowser() {
		driver.close();

	}

	
	public void takeSnap() {
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./snaps/snap"+i+".jpg");
		try {
			FileUtils.copyFile(src, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;

	}
}
	
