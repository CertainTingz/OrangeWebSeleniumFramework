package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{


    // Constructor to initialize the
 public LoginPage(WebDriver driver) {
     super(driver);
 }

 // Saving Page Objects
 @FindBy(css = "input[placeholder='Username']")
 WebElement txtUsername;

 @FindBy(css = "input[placeholder='Password']")
    WebElement txtPassword;

@FindBy(css = "button[type='submit']")
    WebElement btnLogin;

@FindBy (css = ".oxd-text.oxd-text--p.orangehrm-login-forgot-header")
    WebElement lnkForgotPassword;


public void setUsername(String username){
    txtUsername.sendKeys(username);
}

public void setPassword(String password){
    txtPassword.sendKeys(password);
}

public void clickLoginButton(){
    btnLogin.click();
}
public void clickForgotPassword(){
    lnkForgotPassword.click();
}




    }
