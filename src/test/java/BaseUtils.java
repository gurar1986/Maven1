

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.http.HttpConnection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseUtils {

    private static final String HUB_URL = "http://localhost:4444/wd/hub";
    private static boolean remoteWebDriver = false;
    //ChromeOptions = new ChromeOptions;
    static {

        try {
            HttpURLConnection con = (HttpURLConnection) new URL(HUB_URL + "/status").openConnection();
            try {
                con.setRequestMethod("GET");
                remoteWebDriver = con.getResponseCode() == HttpURLConnection.HTTP_OK;
            } finally {
                con.disconnect();
            }
        } catch (IOException ignore) {}

        if (!remoteWebDriver) {
            WebDriverManager.chromedriver().setup();
        }
    }


    public static WebDriver createDriver() {
        ChromeOptions ChromeOptions = null;
        WebDriver driver = new ChromeDriver(ChromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
