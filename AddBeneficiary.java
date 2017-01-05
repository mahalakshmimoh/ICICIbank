package icicibank;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import opentapsTestng.Dataproviderparam;

public class AddBeneficiary extends Login{
	@Test(dependsOnGroups={"Smoke", "Sanity"},dataProvider = "AddBene", dataProviderClass=Dataproviderparam.class)
	public void add(String a,String b, String c, String d, String e) {

		login();
		WebElement payments = driver.findElementByTagName("PAYMENTS");
		Actions builder = new Actions(driver);
		builder.moveToElement(payments).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		clickBytagname("Other Bank Accounts");
		clickByName("Action.ADD_NEW_BENEFICIARY");
		enterByName("CounterPartyCRUDFG.BNF_NAME", a);
		enterByName("CounterPartyCRUDFG.BNF_NICK_NAME", b);
		selectVisibileTextByClass("selectboxit-arrow-container", "Other Bank Accounts");
		enterByName("CounterPartyCRUDFG.BNF_ACCT_NUMBER", c);
		enterByName("CounterPartyCRUDFG.CONFIRM_ACCT_NUMBER",d);
		enterByName("CounterPartyCRUDFG.BANK_IDENTIFIER", e);
		clickByName("Action.CONTINUE");
		
		
	}
}
