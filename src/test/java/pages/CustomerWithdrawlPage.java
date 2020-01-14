package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomerWithdrawlPage {

    @FindBy(css = "button.btn-lg:nth-child(3)")
    WebElement withdrawlTab;
    @FindBy(css = ".form-control")
    WebElement withdrawlNumber;
    @FindBy(css = ".btn-default")
    WebElement withdrawlButton;
    @FindBy(xpath = "//div[4]/div/span")
    WebElement message;
    @FindBy(xpath = "//div[2]/strong[2]")
    WebElement checkBalance;


    public void navigateToWithdrawlTab() throws InterruptedException {
        this.withdrawlTab.click();
    }

    public void typeWithdrawlAmount(String withdrawlAmount) throws InterruptedException {
        this.withdrawlNumber.clear();
        this.withdrawlNumber.sendKeys(withdrawlAmount);
    }



    public void submitWithdrawl() throws InterruptedException {
        withdrawlButton.click();
    }



    public void verifyMessageSuccessfully() throws InterruptedException {
        if (message.isDisplayed()){
            System.out.println(" Input Withdrawl Successful");
            verifyBanlance(2000,1000);
        }
        else System.out.println("Input Withdrawl unSuccessful");
    }


    public void verifyMessageunSuccessfully() throws InterruptedException {
        verifyBanlance(1000, 2000);
    }

    public void verifyBanlance(int deposit , int withdrawl){
        int balanceNum = Integer.parseInt(checkBalance.getText());
        if(deposit < withdrawl){
            System.out.println("The deposit more than the withdrawal");
            if (balanceNum == deposit - withdrawl) {
                System.out.println("verify withdrwawl successfully corrrect");
            } else {
                System.out.println("verify withdrwawl successfully incorrrect");
            }
        }
        else
            System.out.println("The withdrawal more than the deposit");

    }




}
