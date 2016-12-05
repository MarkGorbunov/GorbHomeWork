package mozila;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * check incorrect login
 */
public class IncorectDataForLogIn {
    /**
     * check incorrect login without password
     * @throws InterruptedException
     */
    @Test
    public void withoutPassWordlogIn() throws InterruptedException {
        open("http://local.wordpress.dev/wp-login.php");
        $(By.id("user_login")).setValue("Mark");
        $(By.id("user_pass")).setValue("");
        $(By.id("wp-submit")).click();
        $(By.id("login_error")).shouldHave(text("The password field is empty."));
    }

    /**
     *  check incorrect login with incorrect password
     * @throws InterruptedException
     */
    @Test
    public void withIncorrectPassWordlogIn() throws InterruptedException {
        open("http://local.wordpress.dev/wp-login.php");
        $(By.id("user_login")).setValue("borbut");
        $(By.id("user_pass")).setValue("qwerty");
        $(By.id("wp-submit")).click();
        $(By.id("login_error")).shouldHave(text("The password you entered for the username borbut is incorrect."));
    }

    /**
     * check incorrect login with not exist name
     * @throws InterruptedException
     */
    @Test
    public void withIncorrectNamelogIn() throws InterruptedException {
        open("http://local.wordpress.dev/wp-login.php");
        $(By.id("user_login")).setValue("qwerty");
        $(By.id("user_pass")).setValue("qwerty");
        $(By.id("wp-submit")).click();
        $(By.id("login_error")).shouldHave(text("Invalid username. "));
}


}
