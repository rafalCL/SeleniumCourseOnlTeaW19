package pl.coderslab.pageobject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotelTest {
    private WebDriver driver;

    @Test
    public void shouldSubscribeToNotifications() {
        this.driver.get("https://hotel-testlab.coderslab.pl/en/");
        HotelMainPage mainPage = new HotelMainPage(driver);
        String randomEmail = UUID.randomUUID().toString() + "@email.pl";
        mainPage.subscribeToNotifications(randomEmail);
        String successText = mainPage.getSuccessText();
        assertEquals("Newsletter : You have successfully subscribed to this newsletter.", successText);
    }

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
    }

//    @AfterEach
//    public void afterEach() {
//        this.driver.quit();
//    }
}
