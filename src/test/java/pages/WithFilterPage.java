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
    private String artPlace="//article[contains(@class, 'box_offer')]//span[contains(text(), '%s')]";
   // private String artPlace="//article[contains(@class, 'box_offer')]//a[contains(text(), '%s')]/parent::h2/following-sibling::p/span[contains(text(),'%s)]";
    private String artMenu="//article[contains(@class,'box_offer')]//a[contains(text(),%s)]/parent::h2/following-sibling::div[contains(@class,'opt_dots')]";
   
  
    public WithFilterPage(){
        super(driver);
    }

    public void closeModalNotifications(){
        handleUnexpectedModal(popup,nowNoButton);
    }

    public void clickOnFilter(String vFilter) {
        // Reemplaza el marcador de posición en los filtros con el nombre
        String xpathFilter = String.format(filter, vFilter);
        clickElement(xpathFilter);
    }
    public void clickOnOptionFilter(String vOFilter) {
        // Reemplaza el marcador de posición en las opciones de los filtros con el valor de la opcion
        String xpathOption = String.format(optionFilter, vOFilter);
        clickElement(xpathOption);
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

    public void AssertionPlace(String place) {
        String xpathplace = String.format(artPlace, place);
        WebElement placeElement = driver.findElement(By.xpath(xpathplace));
        String actualplaceText = placeElement.getText().trim();
        Assert.assertTrue(actualplaceText.contains(place),"los lugares son distintos en el listado");
    }

    


}
