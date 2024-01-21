import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTests {

    WebDriver driver;
    HelperClass helper;
    HomePage home;
    ProductPage productPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.edge.driver", "misc/msedgedriver.exe");
        driver = new EdgeDriver();

        home = new HomePage(driver);
        productPage = new ProductPage(driver);
        helper = new HelperClass(driver);

        driver.manage().window().maximize();
    }

    @Test
    public void productLinkTakesUserToProductPage() throws InterruptedException {
        driver.get("https://www.demoblaze.com/index.html");

        helper.waitForElementToBeVisible(home.firstProductLink, 15);

        helper.click(home.firstProductLink);

        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(productPage.productHeading).isDisplayed());
        Assert.assertEquals(driver.findElement(productPage.productHeading).getText(), "Samsung galaxy s6");
        Assert.assertTrue(driver.findElement(productPage.productImage).isDisplayed());
        Assert.assertTrue(driver.findElement(productPage.productPrice).isDisplayed());
        Assert.assertEquals(driver.findElement(productPage.productPrice).getText(), "$360 *includes tax");
        Assert.assertTrue(driver.findElement(productPage.productDescription).isDisplayed());
        Assert.assertTrue(driver.findElement(productPage.addToCartButton).isDisplayed());
    }

    @Test
    public void selectFirstResultFromLaptopCategory() throws InterruptedException {
        driver.get("https://www.demoblaze.com/index.html");

        helper.waitForElementToBeVisible(home.laptopsLink, 15);

        helper.click(home.laptopsLink);

        Thread.sleep(2000);

        helper.click(home.firstProductLink);

        helper.waitForElementToBeVisible(productPage.productHeading, 15);
        Assert.assertTrue(driver.findElement(productPage.productHeading).isDisplayed());
        Assert.assertEquals(driver.findElement(productPage.productHeading).getText(), "Sony vaio i5");
        Assert.assertTrue(driver.findElement(productPage.productImage).isDisplayed());
        Assert.assertTrue(driver.findElement(productPage.productPrice).isDisplayed());
        Assert.assertEquals(driver.findElement(productPage.productPrice).getText(), "$790 *includes tax");
        Assert.assertTrue(driver.findElement(productPage.productDescription).isDisplayed());
        Assert.assertTrue(driver.findElement(productPage.addToCartButton).isDisplayed());
    }

    @Test
    public void selectFirstResultFromMonitorsCategory() throws InterruptedException {
        driver.get("https://www.demoblaze.com/index.html");

        helper.waitForElementToBeClickable(home.monitorsLink, 15);

        helper.click(home.monitorsLink);

        Thread.sleep(2000);

        helper.click(home.firstProductLink);

        helper.waitForElementToBeVisible(productPage.productHeading, 15);
        Assert.assertTrue(driver.findElement(productPage.productHeading).isDisplayed());
        Assert.assertEquals(driver.findElement(productPage.productHeading).getText(), "Apple monitor 24");
        Assert.assertTrue(driver.findElement(productPage.productImage).isDisplayed());
        Assert.assertTrue(driver.findElement(productPage.productPrice).isDisplayed());
        Assert.assertEquals(driver.findElement(productPage.productPrice).getText(), "$400 *includes tax");
        Assert.assertTrue(driver.findElement(productPage.productDescription).isDisplayed());
        Assert.assertTrue(driver.findElement(productPage.addToCartButton).isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
