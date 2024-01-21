import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    WebDriver driver;
    By productHeading = By.xpath("//div[@id=\"tbodyid\"]//h2");
    By productImage = By.xpath("//div[@class=\"product-image\"]");
    By productPrice = By.xpath("//div[@id=\"tbodyid\"]//h3[@class=\"price-container\"]");
    By productDescription = By.xpath("//div[@class=\"description description-tabs\"]//p");
    By addToCartButton = By.xpath("//a[contains(text(), \"Add to cart\")]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
}
