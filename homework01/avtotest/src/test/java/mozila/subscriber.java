package mozila;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * login how subscriber and leave comments
 */
public class subscriber {
    /**
     * login how subscriber and leave comments
     * @throws InterruptedException
     */
    @Test
    public void logInWriteComment() throws InterruptedException {
        open("http://local.wordpress.dev/wp-login.php");
        $(By.id("user_login")).setValue("Subscriber");//subscriber
        $(By.id("user_pass")).setValue("password");
        $(By.id("wp-submit")).click();
        $(By.id("wp-admin-bar-top-secondary")).shouldHave(text("Howdy, Subscriber Subscriber"));

        open("http://local.wordpress.dev/");
        $(By.xpath(".//*[@id='post-7']/footer/span[2]/a")).click();
        $(By.id("comment")).setValue("comment for check");
        $(By.id("submit")).click();
    }

}
