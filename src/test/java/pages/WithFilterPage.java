package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WithFilterPage extends BasePage{
    
    private String filter="//p[contains(text(),'%s')]";
    private String optionFilter="//span[contains(text(),'%s')]";
    private String nowNoButton="//button[contains(text(),'Ahora no')]";
    private String popup="//div[@id='pop-up-webpush-sub']";
    private String artoffer="//article[contains(@class, 'box_offer')]//a[contains(text(), '%s')]";
    private String artPlace="//article[contains(@class, 'box_offer')]//a[contains(text(), \'%s\')]/parent::h2/following-sibling::p/span[contains(text(),'%s')]";
    private String artMenu="//article[contains(@class,'box_offer')]//a[contains(text(),\'%s\')]/parent::h2/following-sibling::div[contains(@class,'opt_dots')]";
    private String artMenuOptions="//article[contains(@class, 'box_offer')]//a[contains(text(), \'%s\')]/parent::h2/following-sibling::p/span[contains(text(), '%s')]/ancestor::article//a[contains(text(), '%s')]";
    public WithFilterPage(){
        super(driver);
    }

    public void closeModalNotifications(){
        handleUnexpectedModal(popup,nowNoButton);
    }
    public void clickOnFilter(String vFilter) {
       clickOnFilterAndOption(vFilter,filter);
    }
    public void clickOnOptionFilter(String vOFilter) {
       clickOnFilterAndOption(vOFilter,optionFilter);
    }
   // usandolos de esta manera se pueden reutilizar cuantas veces sea necesario y con cuantos filtros sea necesario 
    public void selectionFilters(String vFilter,String vOFilter){
        closeModalNotifications();
        clickOnFilter(vFilter);
        clickOnOptionFilter(vOFilter);
    }
    public void AssertionOffer(String offer) {
        String xpathoffer = String.format(artoffer, offer);
        WebElement offerElement  = driver.findElement(By.xpath(xpathoffer));
        String actualOfferText = offerElement.getText().trim();
        Assert.assertEquals(actualOfferText,offer,"las ofertas son distintas en el listado"); 
    }
    public void AssertionPlace(String offer, String place) {
        String xpathplace = String.format(artPlace,offer, place);
        WebElement placeElement = driver.findElement(By.xpath(xpathplace));
        String actualplaceText = placeElement.getText().trim();
        Assert.assertTrue(actualplaceText.contains(place),"los lugares son distintos en el listado");
    }
    public void clickMenuOffer(String offer) {
       clickOnFilterAndOption(offer,artMenu);
    }
    public void clickMenuOfferOption(String offer,String place,String menuOption) {
       clickOnFilterAndOptions(offer,place,menuOption,artMenuOptions);
    }
    

}
