package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.lang.Thread.sleep;

public class CustomerLoginPage {

    @FindBy(id = "userSelect")
    WebElement usernameSelector;

    @FindBy(css = "button.btn:nth-child(2)")
    WebElement loginButton;

    @FindBy(css = ".logout")
    WebElement logoutButton;

    @FindBy(css = ".home")
    WebElement homeButton;

    @FindBy(css = ".fontBig")
    WebElement welcomeName;

    public void selectUserName(String usernameSelected) throws InterruptedException {
        sleep(5000);
        usernameSelector.click();

        List<WebElement> listCustomerName = usernameSelector.findElements(By.tagName("option"));
        for (WebElement customerName : listCustomerName) {
            if (customerName.getText().toLowerCase().equalsIgnoreCase(usernameSelected)) {
                customerName.click();
                sleep(3000);
                break;
            }
        }
    }

    public boolean checkLoginButtonIsShown() {
        if(loginButton.isDisplayed()){
            System.out.println("Login button is appeared");
            return true;
        }
        else{
            System.out.println("The name is not selected and login button is not appeared");
            return false;
        }
    }

    public void clickLoginButton() {
        if(checkLoginButtonIsShown()){
            loginButton.click();
        }
        else{
            System.out.println("Element not present");
        }
    }

    public void verifyNavigateToDetailPage(String customerNameSelected) {
        System.out.println(customerNameSelected+"ten");
        if (logoutButton.isDisplayed() && homeButton.isDisplayed() && welcomeName.isDisplayed()){
            if (welcomeName.getText().toLowerCase().equalsIgnoreCase(customerNameSelected))
                System.out.println("user loggined and is navigated to details information page");
        }
        else System.out.println("user not loggined");
    }
}
