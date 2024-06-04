package OpenCart;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reportes.ReportFactory;

import java.time.Duration;

@Tag("SHOP")
public class testShop {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("reportes/Shop-Test.html");
    static ExtentReports extent;

    @BeforeAll
    public static void createReport() {
        extent = ReportFactory.getInstance();
        extent.attachReporter(info);
        System.out.println("<<< COMIENZAN LOS TEST DE AGREGADO DE PRODCUTOS AL CARRITO >>>");
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        ShopPage shopPage = new ShopPage(driver, wait);
        shopPage.setup();
        shopPage.getUrl("https://opencart.abstracta.us/index.php?route=common/home");
    }


    @Test
    @Tag("SHOP")
    @Tag("EXITOSO")
    public void AgregadoExitoso() throws InterruptedException {
        ExtentTest test = extent.createTest("Agregado al carrito Exitoso");
        test.log(Status.INFO, "Comienza el Test");
        test.log(Status.PASS, "Ingreso busqueda");
        ShopPage shopPage = new ShopPage(driver, wait);
        shopPage.escribirProducto("iphone");
        shopPage.clickBuscar();
        test.log(Status.PASS, "Hago click en boton de busqueda");
        shopPage.clickAgregar();
        test.log(Status.PASS, "Agrego el producto encontrado al carrito");
        shopPage.productoAgregadoConExito().equals("Success");
        test.log(Status.PASS, "Validación de resgistro Exitoso");
        test.log(Status.INFO, "Finaliza el Test");
    }

    @AfterEach
    public void endTest() throws InterruptedException {
        ShopPage shopPage = new ShopPage(driver, wait);
        shopPage.close();
    }

    @AfterAll
    public static void finish() {
        extent.flush();
        System.out.println("<<< FINALIZAN LOS TEST DE AGREGADO DE PRODCUTOS AL CARRITO >>>");
    }
}
