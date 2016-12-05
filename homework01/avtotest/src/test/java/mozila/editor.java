package mozila;

import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.disappears;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;


/**
 * login how editor,create post and delete it
 */
public class editor {
    @Test
    /**
     *  login how editor,create post and delete it
     */
    public void logInMakePostDeletePost() throws InterruptedException {
        open("http://local.wordpress.dev/wp-login.php");
        $(By.id("user_login")).setValue("Mark");//editor
        $(By.id("user_pass")).setValue("password");
        $(By.id("wp-submit")).click();
        $(By.id("wp-admin-bar-top-secondary")).shouldHave(text("Howdy, MArk Gorbunov"));

        $(By.xpath(".//*[@id='menu-posts']/a/div[3]")).click();
        waitUntilPagesIsLoaded();
        $(By.xpath(".//*[@id='menu-posts']/ul/li[3]/a")).click();
        waitUntilPagesIsLoaded();

        $(By.name("post_title")).shouldBe(visible).setValue("test-post");
        $(By.id("content-html")).click();
        $(By.id("content")).setValue("text for checking");
        $(By.name("publish")).click();
        waitUntilPagesIsLoaded();
        $(By.xpath(".//*[@id='sample-permalink']")).click();
        $(By.className("post-edit-link")).click();
        waitUntilPagesIsLoaded();
        $(By.id("delete-action")).click();
        $(By.xpath(".//*[@id='menu-posts']/ul/li[3]/a")).click();
        waitUntilPagesIsLoaded();
        $(By.id("the-list")).shouldNotHave(text("test-post"));


    }

    protected static void waitUntilPagesIsLoaded() {
        $(byText("Loading")).waitUntil(disappears, 20000);
    }




}
