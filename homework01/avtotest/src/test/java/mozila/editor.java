package mozila;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static mozila.PageObject.*;


/**
 * login how editor,create post and delete it
 */
public class editor {

    @BeforeMethod()
    public void setUp(){
        open("http://local.wordpress.dev/wp-login.php");
        $(LOGIN).setValue("Mark");//editor
        $(PASSWORD).setValue("password");
        $(WP_SUBMIT).click();
    }

    @Test
    /**
     *  login how editor,create post and delete it
     */
    public void logInMakePostDeletePost() throws InterruptedException {
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

    @AfterMethod()
    public void tearDown(){
        close();
    }






}
