package icicibank;

import org.testng.annotations.DataProvider;

public class Dataproviderparam {
	   @DataProvider(name="AddBene")
		  public static Object[][]create() {
		    return new Object[][] {
		   	new Object[] {"maha","mohna", "1468098425","1468098425","code"}
		      	    };
	}
}