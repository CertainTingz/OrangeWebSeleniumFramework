package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    public DashboardPage(WebDriver driver){
        super(driver);
    }


    @FindBy( css = "a[class='oxd-main-menu-item active'] span[class='oxd-text oxd-text--span oxd-main-menu-item--name']")
    WebElement menuDashboard;

    @FindBy(css = "a[class='oxd-main-menu-item active'] svg")
    WebElement menuAdmin;


    @FindBy(css = ".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module")
    WebElement lblDashboardTitle;


    public String getConfirmationTxt(){
            return lblDashboardTitle.getText();

    }







}
