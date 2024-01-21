import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;
    By header = By.xpath("//a[contains(text(), (\"PRODUCT STORE\"))]");
    By homeNavButton = By.xpath("//li//a[@href=\"index.html\"]");
    By firstProductLink = By.xpath("(//div[@class=\"card h-100\"])[1]");
    By carouselImages = By.xpath("//div[@id=\"carouselExampleIndicators\"]");
    By contactNavButton = By.xpath("//a[@data-target=\"#exampleModal\"]");
    By categoriesLink = By.xpath("//a[@id=\"cat\"]");
    By phonesLink = By.xpath("//a[@onclick=\"byCat('phone')\"]");
    By laptopsLink = By.xpath("//div[@class=\"list-group\"]//a[contains(text(), \"Laptops\")]");
    By monitorsLink = By.xpath("//div[@class=\"list-group\"]//a[contains(text(), \"Monitors\")]");
    By allProducts = By.xpath("//div[@id=\"tbodyid\"]//div[@class=\"card h-100\"]");
    By previousPageButton = By.xpath("//ul[@class=\"pagination\"]//button[@id=\"prev2\"]");
    By nextPageButton = By.xpath("//ul[@class=\"pagination\"]//button[@id=\"prev2\"]");
    By cartPageButton = By.xpath("//ul[@class=\"navbar-nav ml-auto\"]//a[contains(text(), \"Cart\")]");
    By loginPopUpBtn = By.xpath("//a[@id=\"login2\"]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnContact() {
        this.driver.findElement(contactNavButton).click();
    }

    public int returnNumberOfProductsOnPage() {
        return driver.findElements(allProducts).size();
    }
}
