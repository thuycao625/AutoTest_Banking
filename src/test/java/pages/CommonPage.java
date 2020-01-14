package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CommonPage {
    @FindBy(xpath = "//div[2]/table")
    WebElement table;

    public String getDateTime(){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMM dd, yyyy h:mm");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }

    public void verifySuccessfullyAtTransaction(String dateTime, String numberAmount) throws InterruptedException {

        List<WebElement> listTr = table.findElements(By.tagName("tr"));
        for (int i = 1; i < listTr.size(); i++) {
            List<WebElement> listTd = listTr.get(i).findElements(By.tagName("td"));
            String tdDateTime = String.valueOf(listTd.get(0).getText());
            String tdAmount = String.valueOf(listTd.get(1).getText());
            String tdCheck = String.valueOf(listTd.get(2).getText());

            if (tdDateTime.contains(dateTime) && tdAmount.equalsIgnoreCase(numberAmount)) {
                System.out.println("verify data sucessfully !!!!!!!!");
                if(tdCheck.equalsIgnoreCase("Credit")){
                    System.out.println("Add Credit successfully !!!");
                }
                else
                    System.out.println("Add Debit successfully !!!");
            }
            else
                System.out.println("Verify data usucessfully !!!!!!!!");
        }
    }

    public String getAmount(String numberAmount){
        return numberAmount;
    }


}
