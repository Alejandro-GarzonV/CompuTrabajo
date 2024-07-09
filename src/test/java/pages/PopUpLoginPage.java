package pages;

public class PopUpLoginPage extends BasePage{

    private String popUpEmail="//input[@id='LoginModel_Email']";
    private String popUpEmailButton="//a[@id='continueWithMailButton']";

    public PopUpLoginPage(){
        super(driver);
    }
    
    public void insertEmail(String email){
        write(popUpEmail, email);
   }
   public void clickButtonContinueLogin(){
    clickElement(popUpEmailButton);
   } 
}
