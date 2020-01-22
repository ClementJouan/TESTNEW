import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class testInitial {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        String s = System.setProperty("webdriver.gecko.driver", "C:\\firefoxDriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testInitial() throws Exception {
        driver.get("http://10.131.1.32/dolibarr-10.0.6/dolibarr-10.0.6/htdocs/index.php");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("test");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("test");
        driver.findElement(By.xpath("//input[@class='button']")).click();
        driver.findElement(By.linkText("Utilisateurs & Groupes")).click();
        driver.findElement(By.linkText("Nouvel utilisateur")).click();
        driver.findElement(By.id("lastname")).clear();
        driver.findElement(By.id("lastname")).sendKeys("new");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys("new");
        driver.findElement(By.name("password")).click();

        // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | name=password | ]]
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("new");
        driver.findElement(By.id("admin")).click();
        driver.findElement(By.id("admin")).click();
        driver.findElement(By.name("create")).click();
        driver.findElement(By.linkText("Liste des utilisateurs")).click();
        driver.findElement(By.xpath("//a[@id='mainmenua_commercial']/span")).click();
        driver.findElement(By.linkText("Nouvelle commande")).click();
        driver.findElement(By.xpath("//div[@id='id-right']/div/form/div[2]/table/tbody/tr[3]/td[2]/a/span")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("Nike");
        driver.findElement(By.id("customerprospect")).click();
        new Select(driver.findElement(By.id("customerprospect"))).selectByVisibleText("Client");
        driver.findElement(By.id("customerprospect")).click();
        driver.findElement(By.name("create")).click();
        driver.findElement(By.xpath("//div[@id='id-right']/div/form/div[2]/table/tbody/tr[4]/td[2]/span/span/span/span[2]/b")).click();
        driver.findElement(By.xpath("//div[@id='id-right']/div/form/div[2]/table/tbody/tr[4]/td[2]/span/span/span/span[2]/b")).click();
        driver.findElement(By.name("bouton")).click();
        driver.findElement(By.linkText("Liste")).click();
        try {
            assertEquals(driver.findElement(By.xpath("//tr[3]//td[3]//a[1]")).getText(), "Nike");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
