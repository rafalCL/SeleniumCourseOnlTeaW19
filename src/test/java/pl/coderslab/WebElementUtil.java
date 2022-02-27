package pl.coderslab;

import org.openqa.selenium.WebElement;

public class WebElementUtil {
    public static void setText(String text, WebElement targetElement) {
        targetElement.clear();
        targetElement.sendKeys(text);
    }
}
