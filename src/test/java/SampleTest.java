import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class SampleTest {

    @Test
    public void test1()  {
               WebDriver driver = new FirefoxDriver();
                driver.get("http://www.google.com/webhp?complete=1&hl=en");
        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("Cheese");
        long end = System.currentTimeMillis() + 5000;
        while (System.currentTimeMillis() < end) {
            WebElement resultsDiv = driver.findElement(By.className("gssb_e"));
            if (resultsDiv.isDisplayed()) {
                break;
            }
        }
        List<WebElement> allSuggestions = driver.findElements(By.xpath("//td[@class='gssb_a gbqfsf']"));

        for (WebElement suggestion : allSuggestions) {
            System.out.println(suggestion.getText());
        }
    }
}