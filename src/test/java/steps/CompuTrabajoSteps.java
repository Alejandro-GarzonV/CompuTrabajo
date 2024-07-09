package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.PrincipalPage;
import pages.WithFilterPage;


public class CompuTrabajoSteps {

    PrincipalPage pp = new PrincipalPage();
    WithFilterPage fp = new WithFilterPage();

    @Given("un usuario navega a co.computrabajo.com")
    public void UserNavigateCT() {
        pp.navigateToComputrabajo();
    }
    @When ("busca todas las ofertas en {word}")
    public void searchJobByPlace(String lugar){
        pp.insertPlace(lugar);
        pp.clickButtonSearch();
    }
    @And("ingresa el cargo {word} y filtra el {word} por {string}")
    public void selectFilterPosition(String cargo ,String salario, String salV){
        pp.insertPosition(cargo);
        fp.closeModalNotifications();
        pp.clickButtonSearch();
        fp.selectionFilters(salario,salV);
        
    }
    @And("selecciona el filtro {word} por {string} y busca denuevo")
    public void selectFilter(String experiencia, String expV){
        fp.selectionFilters(experiencia,expV);
        pp.clickButtonSearch();
    }
    @Then("viusaliza la oferta {string} en {word}")
    public void offerConfirmation(String oferta,String lugar){
        fp.AssertionOffer(oferta);
        fp.AssertionPlace(lugar);
    }
    

}
