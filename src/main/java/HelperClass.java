import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperClass {

    WebDriver driver;

    public HelperClass(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeVisible(By e, int s) {
        Wait<WebDriver> wait = new WebDriverWait(this.driver, Duration.ofSeconds(s));

        wait.until(ExpectedConditions.visibilityOfElementLocated(e));
    }

    public void click(By firstProductLink) {
        driver.findElement(firstProductLink).click();
    }

    public void waitForAlertToBeVisibleAndAccept(int s) {
        Wait<WebDriver> wait = new WebDriverWait(this.driver, Duration.ofSeconds(s));

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        alert.accept();
    }

    public void waitForElementToBeClickable(By e, int s) {
        Wait<WebDriver> wait = new WebDriverWait(this.driver, Duration.ofSeconds(s));

        wait.until(ExpectedConditions.elementToBeClickable(e));
    }

    public void insertTextIntoField(By e, String text) {
        driver.findElement(e).sendKeys(text);
    }

    public String getTextOfElement(By e) {
        return driver.findElement(e).getText();
    }

    public boolean elementIsVisible(By e) {
        return driver.findElement(e).isDisplayed();
    }
}
