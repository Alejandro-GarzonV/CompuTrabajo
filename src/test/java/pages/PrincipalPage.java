package pages;

public class PrincipalPage extends BasePage{

    private String positionSearcher="//input[@id='prof-cat-search-input']";
    private String placeSearcher ="//input[@id='place-search-input']";
    private String SearchButton="//button[@id='search-button']";
    private String country="//a[@id='Colombialink']";

    public PrincipalPage(){
        super(driver);
    }
    public void navigateToComputrabajo () { 
        driver.manage().window().maximize();      
        driver.get("https://www.computrabajo.com/");
        clickElement(country);
    }
    public void insertPlace(String place){
         write(placeSearcher, place);
    }

    public void insertPosition(String position){
        write(positionSearcher, position);
    }

    public void clickButtonSearch(){
       clickElement(SearchButton);
    }
    
}
