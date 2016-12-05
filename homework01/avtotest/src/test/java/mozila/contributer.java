package mozila;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.hasText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

/**
 * login how contributer and search post cheese
 */
public class contributer {
        @Test
        /**
         * login how contributer and search post cheese
         */
        public void logInAndSearchPost() throws InterruptedException {
            open("http://local.wordpress.dev/wp-login.php");
            $(By.id("user_login")).setValue("borbut");//contributer
            $(By.id("user_pass")).setValue("password");
            $(By.id("wp-submit")).click();
          $(By.id("wp-admin-bar-top-secondary")).shouldHave(text("Howdy, Borbut"));

            open("http://local.wordpress.dev/");
            $(By.xpath(".//*[@id='adminbar-search']")).setValue("cheese");
            $(By.id("post-7")).shouldHave(text("cow->milk->cheese"));
        }



}
