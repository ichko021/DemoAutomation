import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;
    By addedProductImage = By.xpath("//table//tr//td[1]");
    By addedProcuctName = By.xpath("//table//tr//td[2]");
    By addedProductPrice = By.xpath("//table//tr//td[3]");
    By addedProductDeleteLink = By.xpath("//table//tr//td");
    By placeOrderBtn = By.xpath("//div[@class=\"col-lg-1\"]//button");
    By totalValueLabel = By.xpath("//div[@class=\"col-lg-1\"]//h3");
    By placeOrderNameInput = By.xpath("//div[@class=\"modal-dialog\"]//input[@id=\"name\"]");
    By placeOrderCountryInput = By.xpath("//div[@class=\"modal-dialog\"]//input[@id=\"country\"]");
    By placeOrderCityInput = By.xpath("//div[@class=\"modal-dialog\"]//input[@id=\"city\"]");
    By placeOrderCardInput = By.xpath("//div[@class=\"modal-dialog\"]//input[@id=\"card\"]");
    By placeOrderMonthInput = By.xpath("//div[@class=\"modal-dialog\"]//input[@id=\"month\"]");
    By placeOrderYearInput = By.xpath("//div[@class=\"modal-dialog\"]//input[@id=\"year\"]");
    By placeOrderCancelBtn = By.xpath("(//button[contains(text(), \"Close\")])[3]");
    By placeOrderPurchaseBtn = By.xpath("//button[contains(text(), \"Purchase\")]");
    By placeOrderTotalValueLabel = By.xpath("//div[@class=\"modal-dialog\"]//label[@id=\"totalm\"]");
    By successfulPurchasePopUp = By.xpath("//div[@class=\"sweet-alert  showSweetAlert visible\"]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }


}
