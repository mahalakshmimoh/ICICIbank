package icicibank;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import opentapsTestng.Dataproviderparam;

public class Beneficiary extends Login{
	@Test(groups={"Sanity"},dependsOnGroups={"Smoke"})
	public void beneficiary() {
		login();
				WebElement payments = driver.findElementByTagName("PAYMENTS");
		Actions builder = new Actions(driver);
		builder.moveToElement(payments).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		clickBytagname("Other Bank Accounts");
		
		String name = "Rajesh C G";
		String exp1= driver.findElementByXPath("//span[@class='tableoverflowwrapper']").getText();
		Assert.assertEquals(name, exp1);
		if(true)
		{
			System.out.println("present");
		}
		else
		{
			System.out.println("not present");
		}

}
}

