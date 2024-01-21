import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


public class HomeTests {

    WebDriver driver;
    HomePage home;
    ContactPopUp contactPopUp;
    HelperClass helper;


    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.edge.driver", "misc/msedgedriver.exe");
        driver = new EdgeDriver();

        home = new HomePage(driver);
        contactPopUp = new ContactPopUp(driver);
        helper = new HelperClass(driver);

        driver.manage().window().maximize();
    }

    @Test
    public void openDemoBlaze() {
        driver.get("https://www.demoblaze.com/index.html");
    }

    @Test
    public void verifyHeadingOfPage() {
        driver.get("https://www.demoblaze.com/index.html");

        helper.waitForElementToBeVisible(By.xpath("//a[contains(text(), (\"PRODUCT STORE\"))]"), 10);

        assertEquals("Text is the same as expected", driver.findElement(By.xpath("//a[contains(text(), (\"PRODUCT STORE\"))]")).getText(), "PRODUCT STORE");
    }

    @Test
    public void verifyAllFieldsInContactPopUp() {
        driver.get("https://www.demoblaze.com/index.html");

        home.clickOnContact();

        helper.waitForElementToBeVisible(contactPopUp.emailFieldLabel, 15);

        assertEquals("Assert First Field is Contact Email", "Contact Email: ", "Contact Email: ");

        Assert.assertTrue(driver.findElement(contactPopUp.emailFieldLabel).isDisplayed());
        Assert.assertTrue(driver.findElement(contactPopUp.nameFieldLabel).isDisplayed());
        Assert.assertTrue(driver.findElement(contactPopUp.messageFieldLabel).isDisplayed());
        Assert.assertTrue(driver.findElement(contactPopUp.emailFieldInput).isDisplayed());
        Assert.assertTrue(driver.findElement(contactPopUp.nameFieldInput).isDisplayed());
        Assert.assertTrue(driver.findElement(contactPopUp.mesageFieldInput).isDisplayed());
        Assert.assertTrue(driver.findElement(contactPopUp.sendButton).isDisplayed());
        Assert.assertTrue(driver.findElement(contactPopUp.cancelButton).isDisplayed());
    }

    @Test
    public void verifyHomePageElements() {
        driver.get("https://www.demoblaze.com/index.html");

        helper.waitForElementToBeVisible(home.categoriesLink, 15);

        Assert.assertTrue(driver.findElement(home.carouselImages).isDisplayed());
        Assert.assertTrue(driver.findElement(home.categoriesLink).isDisplayed());
        Assert.assertTrue(driver.findElement(home.phonesLink).isDisplayed());
        Assert.assertTrue(driver.findElement(home.laptopsLink).isDisplayed());
        Assert.assertTrue(driver.findElement(home.monitorsLink).isDisplayed());
        Assert.assertTrue(driver.findElement(home.nextPageButton).isDisplayed());
        Assert.assertTrue(driver.findElement(home.previousPageButton).isDisplayed());
        helper.waitForElementToBeVisible(home.allProducts, 15);
        Assert.assertEquals(home.returnNumberOfProductsOnPage(), 9);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
