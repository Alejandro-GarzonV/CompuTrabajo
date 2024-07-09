package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.PrincipalPage;
import pages.WithFilterPage;
import pages.PopUpLoginPage;

public class CompuTrabajoSteps {

    PrincipalPage pp = new PrincipalPage();
    WithFilterPage fp = new WithFilterPage();
    PopUpLoginPage plp= new PopUpLoginPage();

    @Given("un usuario navega a co.computrabajo.com")
    public void UserNavigateCT() {
        pp.navigateToComputrabajo();
    }
    @When ("busca todas las ofertas en {word}")
    public void searchJobByPlace(String lugar){
        pp.insertPlace(lugar);
        pp.clickButtonSearch();
    }
    @When ("el usuario opciona {word} a la vacante, en el menu de la oferta {string} en {word}")
    public void postulationOffer(String subMenu,String oferta,String lugar) throws InterruptedException{
        fp.clickMenuOffer(oferta);
        fp.clickMenuOfferOption(oferta,lugar,subMenu);
       // Thread.sleep(2000);
    }
    @And("ingresa el cargo {word} y filtra el {word} por {string}")
    public void selectFilterPosition(String cargo ,String salario, String salV){
        pp.insertPosition(cargo);
        fp.closeModalNotifications();
        pp.clickButtonSearch();
        fp.selectionFilters(salario,salV);
    }
    @And("selecciona el filtro {word} por {string} y busca de nuevo")
    public void selectFilter(String experiencia, String expV){
        fp.selectionFilters(experiencia,expV);
        pp.clickButtonSearch();
    }
    @And ("inserta el correo {word} ,continua el proceso") 
    public void loginEmail(String correo){
        plp.insertEmail(correo);
        plp.clickButtonContinueLogin();
    }
    //@And ("diligencia los datos de inscripcion y continua")
    
    
    @Then("visualiza la oferta {string} en {word}")
    public void offerConfirmation(String oferta,String lugar) {
        fp.AssertionOffer(oferta);
        fp.AssertionPlace(oferta,lugar);
    }
    //@Then ("visualiza error de codigo captcha")

}
