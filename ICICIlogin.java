package icicibank;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ICICIlogin extends Login{


	@Test
	public void account() {
		login();
		String account_number = "910010041247405";
		String exp1= driver.findElementByXPath("//span[@class='sticker-text'][2]").getText();
		Assert.assertEquals(account_number, exp1);
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
