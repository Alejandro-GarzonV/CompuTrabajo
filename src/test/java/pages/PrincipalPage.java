package pages;

public class PrincipalPage extends BasePage{
   
    private String placeSearcher ="//input[@id='place-search-input']";
    private String SearchButton="//button[@id='search-button']";

    public PrincipalPage(){
        super(driver);
    }
    public void navegaSauceDemo () { 
        driver.manage().window().maximize();      
        driver.get("https://co.computrabajo.com/");
    }
    public void insertPlace(String place){
        write(placeSearcher, place);
    }
    public void clickButtonSearch(){
        clickElement(SearchButton);
    }

}
