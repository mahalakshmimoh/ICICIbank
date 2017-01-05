package icicibank;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import icicibank.Dataproviderparam;

public class Login extends GenericWrappers{
	@BeforeMethod(groups={"common"})
	public void login() {

		invokeApp("chrome", "https://retail.axisbank.co.in/");
		enterById("loginId", "836524647");
		enterById("newPassword", "Asmitha1*");
		clickByName("ABCustomLoginPortletFormSubmit");

}
}
