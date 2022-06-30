import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainTest extends BaseUtils {


        WebDriver webDriver1 = new ChromeDriver();

        @BeforeMethod
        public void Base() {

            webDriver1.get("https://www.yandex.ru/");
            //webDriver1.manage().window().fullscreen();
            webDriver1.manage().deleteAllCookies();
        }
        @Test

        public void firstWebTest() {

            
            //webDriver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            webDriver1.findElement(By.name("text")).sendKeys("Samsung laptops");
            webDriver1.findElement(By.className("search2__button")).click();
        }
          /* @AfterMethod

                    void Close(){
                webDriver1.close();
            }*/


            @Test
        public void testAbbr () {

            Assert.assertEquals(Main.abbr("Rosmarine", 3), "Ros");
            }




}



