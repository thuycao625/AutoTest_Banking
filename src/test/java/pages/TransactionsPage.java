package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.lang.Thread.sleep;

public class TransactionsPage {

    @FindBy(css = "button.btn-lg:nth-child(1)")
    WebElement transactionTab;
    @FindBy(xpath = "//div[2]/table")
    WebElement table;
    @FindBy(xpath = "//div[2]/div/div[1]/button[1]")
    WebElement buttonBack;
    @FindBy(xpath = "//div[2]/div/div[1]/button[2]")
    WebElement buttonReset;

    @FindBy(css = ".logout")
    WebElement logoutButton;

    @FindBy(css = ".home")
    WebElement homeButton;

    @FindBy(css = ".fontBig")
    WebElement welcomeName;

    public void navigateTransactionTab() throws InterruptedException {
        transactionTab.click();
        sleep(5000);
    }

    public void resetTableTransaction() throws InterruptedException {
        buttonReset.click();
        sleep(3000);
    }

    public void verifyBackButtonSuccess(){
        if (logoutButton.isDisplayed() && homeButton.isDisplayed() && welcomeName.isDisplayed()){
            System.out.println("Back button navigate correct");
            System.out.println("Navigate Home Page Successfully!!!");
        }
        else {
            System.out.println("Back button navigate incorrect");
            System.out.println("Navigate Home Page inSuccessfully!!!");
        }
    }

    public void backButtonAtTransaction() throws InterruptedException {
        buttonBack.click();
        sleep(3000);
    }

    public void verifyResetButtonSuccess(){
        List<WebElement> listTr = table.findElements(By.tagName("tr"));
        if(listTr.size() > 1){
            System.out.println("Reset table unSuccessfully!!!!!!!!!");
        }
        else
            System.out.println("Reset table Successfully!!!!!!!!!");
    }


}
