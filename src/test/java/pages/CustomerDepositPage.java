package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.Thread.sleep;

public class CustomerDepositPage {

    @FindBy(css = "button.btn-lg:nth-child(2)")
    WebElement depositTab;
    @FindBy(css = ".form-control")
    WebElement depositNumber;
    @FindBy(css = ".btn-default")
    WebElement depositButton;
    @FindBy(xpath = "//div[4]/div/span")
    WebElement message;

    @FindBy(xpath = "//div[2]/strong[2]")
    WebElement checkBalance;


    public void navigateToDepositTab() throws InterruptedException {
        depositTab.click();
    }

    public void typeDepositAmount(String depositAmount) throws InterruptedException {
        sleep(5000);
        depositNumber.clear();
        depositNumber.sendKeys(depositAmount);

    }


    public void submitDeposit() throws InterruptedException {
        depositButton.click();
        sleep(2000);
    }


    public void verifyMessageSuccessfully() throws InterruptedException {
        if (message.isDisplayed()) {
            System.out.println("Input Deposit Successful");
           verifyBanlance(2000);
        } else System.out.println("Input Deposit unSuccessful");
    }


    public void verifyMessageunSuccessfully() throws InterruptedException {
        verifyBanlance(0);
    }

    public void verifyBanlance(int num){
        int balanceNum = Integer.parseInt(checkBalance.getText());
        if (balanceNum == num) {
            System.out.println("verify Deposit successfully corrrect");
        } else {
            System.out.println("verify Deposit successfully incorrrect");
        }
    }


}



