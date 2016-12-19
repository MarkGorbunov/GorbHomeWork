package mozila;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static mozila.PageObject.*;

/**
 * login how subscriber and leave comments
 */
public class subscriber {
    @BeforeMethod()
    public void setUp(){
        open("http://local.wordpress.dev/wp-login.php");
        $(LOGIN).setValue("Subscriber");//subscriber
        $(PASSWORD).setValue("password");
        $(WP_SUBMIT).click();
    }
    /**
     * login how subscriber and leave comments
     * @throws InterruptedException
     */
    @Test
    public void logInWriteComment() throws InterruptedException {
        $(By.id("wp-admin-bar-top-secondary")).shouldHave(text("Howdy, Subscriber Subscriber"));
        open("http://local.wordpress.dev/");
        $(By.xpath(".//*[@id='post-7']/footer/span[2]/a")).click();
        $(By.id("comment")).setValue("comment for check");
        $(By.id("submit")).click();
    }

    @AfterMethod()
    public void tearDown(){
        close();
    }

}
