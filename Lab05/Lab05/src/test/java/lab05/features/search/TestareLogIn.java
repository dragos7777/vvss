package lab05.features.search;

import net.serenitybdd.core.annotations.findby.By;
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import lab05.steps.serenity.EndUserSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/LoginData.csv")
public class TestareLogIn {

    @Managed(driver = "chrome")
    public WebDriver webdriver;

    public String email;
    public String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String name) {
        this.email = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String name) {
        this.password = name;
    }


    @Steps
    public EndUserSteps anna;

    @Issue("#WIKI-1")
    @Test
    public void test_log_in() {
        anna.is_the_home_page();
        anna.login(getEmail(),getPassword());
        if(getEmail().equals("test@bla.com"))
            anna.should_not_see_definition();

        else
            anna.should_see_definition("Invalid email address.");






       // anna.should_see_definition("A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates.");

    }

//    @Test
//    public void searching_by_keyword_banana_should_display_the_corresponding_article() {
//        anna.is_the_home_page();
//        anna.looks_for("pear");
//        anna.should_see_definition("An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.");
//    }
//
//    @Pending @Test
//    public void searching_by_ambiguious_keyword_should_display_the_disambiguation_page() {
//    }
} 