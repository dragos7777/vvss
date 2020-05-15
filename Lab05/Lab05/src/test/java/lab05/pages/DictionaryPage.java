package lab05.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.ArrayList;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("http://automationpractice.com/index.php?controller=authentication&back=my-account")
public class DictionaryPage extends PageObject {

    @FindBy(name="email")
    private WebElementFacade input_email;

    @FindBy(className="logout")
    private WebElementFacade logut_button;

    @FindBy(id="my-account-link")
    private WebElementFacade open_login_form_button;

    @FindBy(name="passwd")
    private WebElementFacade input_pass;

    @FindBy(name="SubmitLogin")
    private WebElementFacade login_button;

    @FindBy(className="product-container")
    private WebElementFacade imagine_tricou;


    @FindBy(className = "cross")
    private WebElementFacade cruce;

    @FindBy(xpath= "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/b")
    private WebElementFacade cart;

    @FindBy(xpath = "//*[@id=\"cart_quantity_up_1_1_0_320831\"]")
    private WebElementFacade button_plus;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
    private WebElementFacade checkout_button;

    @FindBy(xpath = "//*[@id=\"address_delivery\"]/li[7]/a")
    private WebElementFacade update_adress;

    @FindBy(id = "address1")
    private WebElementFacade input_adress;

    @FindBy(id="submitAddress")
    private WebElementFacade save_address;

    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button")
    private WebElementFacade button_continue_checkout;

    @FindBy(id = "uniform-cgv")
    private WebElementFacade accept_terms_button;

    @FindBy(xpath = "//*[@id=\"form\"]/p/button/span")
    private WebElementFacade proceed_button;

    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div")
    private WebElementFacade button_pay;

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
    private WebElementFacade button_confirm_oreder;

    public void click_confirm_order(){button_confirm_oreder.click();}
    public void click_pay(){button_pay.click();}
    public void click_accept(){accept_terms_button.click(); proceed_button.click();}
    public void click_continue_checkout(){button_continue_checkout.click(); }
    public  void click_save_address(){save_address.click();}
    public void input_new_adress(String new_adress){input_adress.clear(); input_adress.type(new_adress);}
    public void click_update_adress(){update_adress.click();}
    public void click_checkout(){checkout_button.click(); }
    public void click_plus(){button_plus.click(); }
    public void click_cart(){cart.click(); }
    public void click_cruce(){cruce.click();}
    public void logout(){ logut_button.click(); }
    public void click_tricou(){imagine_tricou.click();}
    public void enter_email(String email) {
        input_email.type(email);
    }

    public void enter_pass(String pass) {
        input_pass.type(pass);
    }

    public void lookup_terms() {
        open_login_form_button.click();
    }

    public void click_login() {
        login_button.click();
    }

    public List<String> getDefinitions() {
        List<String> l=new ArrayList<>();
        try{
        WebElementFacade definitionList = find(By.tagName("ol"));
        return definitionList.findElements(By.tagName("li")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());}
        catch (Exception e){
            return l;
        }
    }
    public WebElement getSpan() {
        List<String> l=new ArrayList<>();

            WebElementFacade definitionList = find(By.className("product-container"));
            List<WebElement> links  = definitionList.findElements(By.tagName("span"));
        for (int i = 1; i < links.size(); i++)
        {
            if(links.get(i).getText().equals("Add to cart"))
                return links.get(i);
        }
        return null;

    }




    public WebElement getListElemtByName(String name) {

        WebElementFacade definitionList = find(By.tagName("ul"));
        List<WebElement> links = definitionList.findElements(By.tagName("li"));
        for (int i = 1; i < links.size(); i++)
        {
            if(links.get(i).getText().equals(name))
                return links.get(i);
        }
      return null;
    }
}