import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPopUp {


    WebDriver driver;
    By emailFieldLabel = By.xpath("//div[@class=\"modal-content\"]//label[contains(text(), \"Contact Email:\")]");
    By nameFieldLabel = By.xpath("//div[@class=\"modal-content\"]//label[contains(text(), \"Contact Name:\")]");
    By messageFieldLabel = By.xpath("//div[@class=\"modal-content\"]//label[contains(text(), \"Message\")]");
    By emailFieldInput = By.xpath("//div[@class=\"modal-content\"]//input[@id=\"recipient-email\"]");
    By mesageFieldInput = By.xpath("//div[@class=\"modal-content\"]//textarea[@id=\"message-text\"]");
    By nameFieldInput = By.xpath("//div[@class=\"modal-content\"]//input[@id=\"recipient-name\"]");
    By sendButton = By.xpath("//div[@class=\"modal-content\"]//button[@onclick=\"send()\"]");
    By cancelButton = By.xpath("(//div[@class=\"modal-dialog\"]//div[@class=\"modal-footer\"]//button[@data-dismiss=\"modal\"])[1]");

    public ContactPopUp(WebDriver driver) {
        this.driver = driver;
    }

    public String returnStringFirstFieldText(WebDriver driver) {
        return driver.findElement(emailFieldLabel).getText();
    }
}
