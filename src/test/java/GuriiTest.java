import org.testng.annotations.Test;

public class GuriiTest extends BaseTest {

    @Test
    public void testFirstSelenium() throws InterruptedException {
        getDriver().get("https://google.com");
    }

}
