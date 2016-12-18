package mozila;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static mozila.PageObject.*;


/**
 * login how contributer and search post cheese
 */
public class contributer {

    @BeforeMethod()
    public void setUp() {
        open("http://local.wordpress.dev/wp-login.php");
        $(LOGIN).setValue("borbut");//contributer
        $(PASSWORD).setValue("password");
        $(WP_SUBMIT).click();
    }

        @Test
        /**
         * login how contributer and search post cheese
         */
        public void logInAndSearchPost() throws InterruptedException {
          $(By.id("wp-admin-bar-top-secondary")).shouldHave(text("Howdy, Borbut"));
            open("http://local.wordpress.dev/");
            $(By.xpath(".//*[@id='adminbar-search']")).setValue("cheese");
            $(By.id("post-7")).shouldHave(text("cow->milk->cheese"));
        }

    @AfterMethod()
    public void tearDown(){
            close();
    }


}
