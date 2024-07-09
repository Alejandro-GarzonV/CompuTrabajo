package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CreateAcountPage extends BasePage{
     
    private String name ="//input[@id='Name']";
    private String lastName ="//input[@id='SurName']";
    private String password ="//input[@id='Password']";
    private String position ="//input[@id='Cargo']";
    private String department ="//select[@id='LocationId']";
    private String dropdownDepartment="//div[contains(@class, 'field_select w100 js_field_select')]//div[@class='nice-select cm-12']";
    private String captcha ="//input[@id='CaptchaInputText']";
    private String continueButton="//input[@id='continueButton']";
    private String answerCaptcha="//span[contains(text(),'Captcha incorrecto')]";

    public CreateAcountPage(){
        super(driver);
    }

    public void insertDataCreateAcount(String names,String lastNames,String passwords,String positions,String place,String captchas){ 
        switchToNewTab();
        write(name, names);
        write(lastName, lastNames);
        write(password, passwords);
        returnPlaceDropdownValues(department,place);
        write(position, positions);
        write(captcha, captchas);
   }
   public void clickButtonContinueCreateAcount(){
    clickElement(continueButton);
   } 
   public void returnPlaceDropdownValues(String xpathDeparment, String value) {
     clickElement(dropdownDepartment);
     clickDropdownValue(xpathDeparment,value);
   }
   public void assertMessageCaptcha(String msj){
        WebElement mssg = driver.findElement(By.xpath(answerCaptcha));
        String actualText = mssg.getText().trim();
        Assert.assertEquals(actualText,msj,"las mensajes son distintas en la respuesta"); 
   }
}
