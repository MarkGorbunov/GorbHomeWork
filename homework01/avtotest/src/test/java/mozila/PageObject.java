package mozila;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.disappears;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by Gorbunov on 17.12.2016.
 */
public class PageObject {
    public static final By LOGIN = By.id("user_login");
    public static final By PASSWORD = By.id("user_pass");
    public static final By WP_SUBMIT= By.id("wp_submit");
    public static final By LOGIN_ERROR= By.id("login_error");



    protected static void waitUntilPagesIsLoaded() {
        $(byText("Loading")).waitUntil(disappears, 20000);
    }
}
