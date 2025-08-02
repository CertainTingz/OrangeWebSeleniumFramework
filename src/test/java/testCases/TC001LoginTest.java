package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class  TC001LoginTest extends BaseTestCase {

 @Test
     public void verifyLogin() throws InterruptedException {

     logger.info("********* Starting TC001LoginTest ********* ");

     try {
         LoginPage loginPage = new LoginPage(driver);
         DashboardPage dashboardPage = new DashboardPage(driver);


         //Enter credentials
         loginPage.setUsername(prop.getProperty("username"));
         loginPage.setPassword(prop.getProperty("password"));
         // Submit credentials
         loginPage.clickLoginButton();

         logger.info("Submitted Login Credentials");

         System.out.println("Login Success");

         // Verifying LogIn

         String confirmationMessage = dashboardPage.getConfirmationTxt();

         System.out.println(" Extracted confirmation Message: " + confirmationMessage);

         Assert.assertEquals(confirmationMessage, "Dashboard");
         logger.info("Verified Login");
     }
     catch(Exception e) {
         logger.error("Error Occurred while verifying Login Credentials");
         logger.debug("Debug logs..");
         Assert.fail();
     }
     logger.info("********* Finishing TC001LoginTest ********* ");

 }


}
