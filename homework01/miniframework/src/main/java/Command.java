import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * class that contain command that check command that it gets
 */
public class Command {
    /**
     * method that check link by name
     *
     * @param s      name of link
     * @param driver browser that opened
     * @return true if find link by name,opposite false
     */
    public boolean checkLinkByName(String s, WebDriver driver) {
        try {
            driver.findElement(By.linkText(s));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * method that check title
     *
     * @param s      name of title
     * @param driver browser that opened
     * @return true if find title,opposite false
     */
    public boolean checkTitle(String s, WebDriver driver) {
        try {
            return s.equals(driver.getTitle());
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }

    /**
     * method that check text on the page
     *
     * @param s      text fo check
     * @param driver browser that opened
     * @return true if find text,opposite false
     */
    public boolean checkPageContains(String s, WebDriver driver) {
        try {
            return s.equals(driver.findElement(By.tagName("body")).getText());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * method that link by href
     *
     * @param s      href for check
     * @param driver browser that opened
     * @return true if find href,opposite false
     */
    public boolean checkLinkHref(String s, WebDriver driver) {
        try {
            driver.findElement(By.xpath("//a[@href=" + s + "]"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
