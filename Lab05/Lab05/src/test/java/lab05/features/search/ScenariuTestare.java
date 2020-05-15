package lab05.features.search;


import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;


import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.annotations.Qualifier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import lab05.steps.serenity.EndUserSteps;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(SerenityRunner.class)

public class ScenariuTestare {

    @Managed(uniqueSession= true)
    WebDriver webdriver;



    @Steps
    public EndUserSteps anna;


    @Test
    public void scenariu_testare() {

        webdriver.manage().window().maximize();
        anna.is_the_home_page();
        JavascriptExecutor jse = (JavascriptExecutor)webdriver;

        //login
        anna.login("test@bla.com", "test1");
        //check logged in, fsdfsd fdsfds is the username
        assertEquals(webdriver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")).getText(),"fsdfsd fdsfds");

        //select item
        anna.getElementFromList("T-SHIRTS").click();
        jse.executeScript("window.scrollBy(0,550)"); //scroll down
        anna.selecteaza_produs(); //selcet product
        anna.close_popup(); //close pop-up
        //check added to cart
        assertEquals(webdriver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[1]")).getText(),"1");


        //checkout product
        jse.executeScript("window.scrollBy(0,-550)");
        anna.click_cart();
        jse.executeScript("window.scrollBy(0,550)");
        //anna.click_plus();
        jse.executeScript("window.scrollBy(0,550)");
        anna.click_checkout();
        anna.click_update_adress();
        anna.input_new_adress("adresa noua");
        jse.executeScript("window.scrollBy(0,650)");
        anna.click_save_address();
        jse.executeScript("window.scrollBy(0,550)");
        anna.click_continue_checkout();
        jse.executeScript("window.scrollBy(0,550)");
        anna.accept_and_proceed();
        jse.executeScript("window.scrollBy(0,650)");
        anna.click_pay();
        jse.executeScript("window.scrollBy(0,650)");
        anna.click_confirm_order();
        //check empty cart
        assertEquals(webdriver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[5]")).getText(),"(empty)");


        //logout
        anna.logout();
        //check logged out
        assertEquals(webdriver.findElement(By.className("login")).getText(),"Sign in");

    }
}