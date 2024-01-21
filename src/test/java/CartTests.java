import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTests {

    WebDriver driver;
    HomePage home;
    HelperClass helper;
    ProductPage productPage;
    CartPage cartPage;
    LoginPopUp loginPopup;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.edge.driver", "misc/msedgedriver.exe");
        driver = new EdgeDriver();

        home = new HomePage(driver);
        helper = new HelperClass(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
        loginPopup = new LoginPopUp(driver);

        driver.manage().window().maximize();
    }

    @Test
    public void addProductToCart() {
        driver.get("https://www.demoblaze.com/index.html");

        helper.waitForElementToBeVisible(home.firstProductLink, 15);
        helper.click(home.firstProductLink);
        helper.waitForElementToBeVisible(productPage.addToCartButton, 15);
        helper.click(productPage.addToCartButton);

        helper.waitForAlertToBeVisibleAndAccept(15);

        helper.click(home.cartPageButton);

        helper.waitForElementToBeVisible(cartPage.addedProcuctName, 15);

        Assert.assertTrue(driver.findElement(cartPage.addedProcuctName).isDisplayed());
        Assert.assertEquals("Samsung galaxy s6", driver.findElement(cartPage.addedProcuctName).getText());
        Assert.assertTrue(driver.findElement(cartPage.addedProductImage).isDisplayed());
        Assert.assertTrue(driver.findElement(cartPage.addedProductPrice).isDisplayed());
        Assert.assertTrue(driver.findElement(cartPage.addedProductDeleteLink).isDisplayed());
    }

    @Test
    public void logInAndAddProductToCart() throws InterruptedException {
        driver.get("https://www.demoblaze.com/index.html");

        helper.waitForElementToBeClickable(home.loginPopUpBtn, 15);
        helper.click(home.loginPopUpBtn);

        helper.waitForElementToBeVisible(loginPopup.usernameInputField, 15);
        helper.insertTextIntoField(loginPopup.usernameInputField, "test");
        helper.insertTextIntoField(loginPopup.passwordInputField, "test");
        helper.click(loginPopup.loginBtn);

        Thread.sleep(1000);

        helper.waitForElementToBeClickable(home.firstProductLink, 15);

        helper.click(home.firstProductLink);

        helper.waitForElementToBeClickable(productPage.addToCartButton, 15);

        helper.click(productPage.addToCartButton);

        helper.waitForAlertToBeVisibleAndAccept(15);

        helper.click(home.cartPageButton);

        helper.waitForElementToBeVisible(cartPage.addedProcuctName, 15);

        Assert.assertTrue(driver.findElement(cartPage.addedProcuctName).isDisplayed());
        Assert.assertEquals("Samsung galaxy s6", driver.findElement(cartPage.addedProcuctName).getText());
        Assert.assertTrue(driver.findElement(cartPage.addedProductImage).isDisplayed());
        Assert.assertTrue(driver.findElement(cartPage.addedProductPrice).isDisplayed());
        Assert.assertTrue(driver.findElement(cartPage.addedProductDeleteLink).isDisplayed());
    }

    @Test
    public void makeOrderAndCheckOut() throws InterruptedException {
        driver.get("https://www.demoblaze.com/index.html");

        helper.waitForElementToBeClickable(home.loginPopUpBtn, 15);
        helper.click(home.loginPopUpBtn);

        helper.waitForElementToBeVisible(loginPopup.usernameInputField, 15);
        helper.insertTextIntoField(loginPopup.usernameInputField, "test");
        helper.insertTextIntoField(loginPopup.passwordInputField, "test");
        helper.click(loginPopup.loginBtn);

        Thread.sleep(1000);

        helper.waitForElementToBeClickable(home.firstProductLink, 15);
        helper.click(home.firstProductLink);
        helper.waitForElementToBeClickable(productPage.addToCartButton, 15);
        helper.click(productPage.addToCartButton);
        helper.waitForAlertToBeVisibleAndAccept(15);

        helper.click(home.cartPageButton);
        helper.waitForElementToBeVisible(cartPage.placeOrderBtn, 15);
        helper.click(cartPage.placeOrderBtn);

        Thread.sleep(2000);

        Assert.assertTrue(helper.elementIsVisible(cartPage.placeOrderNameInput));
        Assert.assertTrue(helper.elementIsVisible(cartPage.placeOrderCountryInput));
        Assert.assertTrue(helper.elementIsVisible(cartPage.placeOrderCityInput));
        Assert.assertTrue(helper.elementIsVisible(cartPage.placeOrderCardInput));
        Assert.assertTrue(helper.elementIsVisible(cartPage.placeOrderMonthInput));
        Assert.assertTrue(helper.elementIsVisible(cartPage.placeOrderYearInput));
        Assert.assertTrue(helper.elementIsVisible(cartPage.placeOrderBtn));
        Assert.assertTrue(helper.elementIsVisible(cartPage.placeOrderCancelBtn));
        Assert.assertEquals("Total: " + helper.getTextOfElement(cartPage.totalValueLabel), helper.getTextOfElement(cartPage.placeOrderTotalValueLabel));

        helper.insertTextIntoField(cartPage.placeOrderNameInput, "Don Joan");
        helper.insertTextIntoField(cartPage.placeOrderCountryInput, "Mangaliya");
        helper.insertTextIntoField(cartPage.placeOrderCityInput, "Mars");
        helper.insertTextIntoField(cartPage.placeOrderCardInput, "1234567890");
        helper.insertTextIntoField(cartPage.placeOrderMonthInput, "March");
        helper.insertTextIntoField(cartPage.placeOrderYearInput, "6969");
        helper.click(cartPage.placeOrderPurchaseBtn);

        Thread.sleep(2000);

        Assert.assertTrue(helper.elementIsVisible(cartPage.successfulPurchasePopUp));
    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
