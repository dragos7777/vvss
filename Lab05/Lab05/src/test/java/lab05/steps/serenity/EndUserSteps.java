package lab05.steps.serenity;

import lab05.pages.DictionaryPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebElement;
import org.yecht.Data;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    DictionaryPage dictionaryPage;

    @Step
    public void login(String email, String pass) {
        dictionaryPage.enter_email(email);
        dictionaryPage.enter_pass(pass);
        dictionaryPage.click_login();


    }

    @Step
    public void selecteaza_produs(){
        dictionaryPage.click_tricou();
        dictionaryPage.click_tricou();
        dictionaryPage.getSpan().click();
        dictionaryPage.click_tricou();



    }

    @Step
    public void click_confirm_order(){
        dictionaryPage.click_confirm_order();
    }

    @Step
    public void click_pay(){
        dictionaryPage.click_pay();
    }

    @Step
    public void accept_and_proceed(){
        dictionaryPage.click_accept();
    }

    @Step
    public void click_continue_checkout(){
        dictionaryPage.click_continue_checkout();
    }

    @Step
    public void click_save_address(){dictionaryPage.click_save_address();}

    @Step
    public void input_new_adress(String new_adress){dictionaryPage.input_new_adress(new_adress);}

    @Step
    public void click_update_adress(){
        dictionaryPage.click_update_adress();
    }

    @Step
    public void click_cart(){
        dictionaryPage.click_cart();
    }

    @Step
    public void click_plus(){dictionaryPage.click_plus();}

    @Step
    public void close_popup(){
        dictionaryPage.click_cruce();
    }

    @Step
    public void click_checkout(){
        dictionaryPage.click_checkout();
    }

    @Step
    public void starts_search() {
        dictionaryPage.lookup_terms();
    }


    @Step
    public WebElement getElementFromList(String name){
        return dictionaryPage.getListElemtByName(name);
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(dictionaryPage.getDefinitions(), hasItem(containsString(definition)));
    }
    @Step
    public void should_not_see_definition() {
        for (String el : dictionaryPage.getDefinitions() )
            System.out.println(el);
        assert(dictionaryPage.getDefinitions().isEmpty());

    }

    @Step
    public void logout(){
        dictionaryPage.logout();


    }


    @Step
    public void is_the_home_page() {
        dictionaryPage.open();

    }

//    @Step
//    public void looks_for(String term) {
//        enters(term);
//        starts_search();
//    }
}