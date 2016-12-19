package mozila;


import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import static mozila.PageObject.*;

/**
 * check incorrect login
 */
public class IncorectDataForLogIn {

    @BeforeMethod()
    public void setUp(){
        open("http://local.wordpress.dev/wp-login.php");
    }

    /**
     * check incorrect login without password
     * @throws InterruptedException
     */
    @Test
    public void withoutPassWordlogIn() throws InterruptedException {
        $(LOGIN).setValue("Mark");
        $(PASSWORD).setValue("");
        $(WP_SUBMIT).click();
        $(LOGIN_ERROR).shouldHave(text("The password field is empty."));
    }

    /**
     *  check incorrect login with incorrect password
     * @throws InterruptedException
     */
    @Test
    public void withIncorrectPassWordlogIn() throws InterruptedException {
        $(LOGIN).setValue("borbut");
        $(PASSWORD).setValue("qwerty");
        $(WP_SUBMIT).click();
        $(LOGIN_ERROR).shouldHave(text("The password you entered for the username borbut is incorrect."));
    }

    /**
     * check incorrect login with not exist name
     * @throws InterruptedException
     */
    @Test
    public void withIncorrectNamelogIn() throws InterruptedException {
        $(LOGIN).setValue("qwerty");
        $(PASSWORD).setValue("qwerty");
        $(WP_SUBMIT).click();
        $(LOGIN_ERROR).shouldHave(text("Invalid username. "));
}
    @AfterMethod()
    public void tearDown(){
        close();
    }


}
