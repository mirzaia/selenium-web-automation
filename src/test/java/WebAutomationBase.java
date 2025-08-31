import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebAutomationBase {
  WebDriver driver = new ChromeDriver();

  ChromeOptions chromeOptions = new ChromeOptions();
  String browserName = chromeOptions.getBrowserName();
  String browserVersion = chromeOptions.getBrowserVersion();

  public void setChromeOptions(ChromeOptions chromeOptions) {
    this.chromeOptions = chromeOptions;
  }

  public ChromeOptions getChromeOptions() {
    return chromeOptions;
  }

  public void sampleAutomation() {
    driver.get("https://www-qa.ninjavan.co/en-sg");
    String webHeader = driver.findElement(By.xpath("//div[@data-testid='hero-banner-title']/h1")).getText();

    // Using Assertions method
    Assertions.assertEquals("Ninja Van: Singapore's leading courier & logistics partner", webHeader);

    // Try other verification method
    if (webHeader.equalsIgnoreCase("Ninja Van: Singapore's leading courier & logistics partner")) {
      System.out.println("Web Header is found");
    }

    driver.quit();
  }

  public static void main(String[] args) {
    WebAutomationBase webAutomation = new WebAutomationBase();
    webAutomation.sampleAutomation();
  }
}
