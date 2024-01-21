import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPopUp {

    WebDriver driver;
    By usernameInputField = By.xpath("//input[@id=\"loginusername\"]");
    By passwordInputField = By.xpath("//input[@id=\"loginpassword\"]");
    By loginBtn = By.xpath("//div[@class=\"modal-footer\"]//button[@onclick=\"logIn()\"]");

    public LoginPopUp(WebDriver driver) {
        this.driver = driver;
    }


}
