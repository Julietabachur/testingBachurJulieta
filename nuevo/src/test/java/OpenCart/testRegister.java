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

@Tag("REGISTER")
public class testRegister {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("reportes/Register-Test.html");
    static ExtentReports extent;

    @BeforeAll
    public static void createReport() {
        extent = ReportFactory.getInstance();
        extent.attachReporter(info);
        System.out.println("<<< COMIENZAN LOS TEST DE REGISTRO >>>");
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.setup();
        registerPage.getUrl("https://opencart.abstracta.us/index.php?route=common/home");
    }

    @Test
    @Tag("REGISTRO")
    @Tag("EXITOSO")
    public void RegistroExitoso() throws InterruptedException {
        ExtentTest test = extent.createTest("Registro Exitoso");
        test.log(Status.INFO, "Comienza el Test");
        test.log(Status.PASS, "Ingreso en el registro de Open Cart");
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.clickCrearCuenta();
        registerPage.clickRegistrarse();

        registerPage.escribirNombre("Juana");
        registerPage.escribirApellido("Perez");
        registerPage.escribirCorreo("perezjuan8@gmail.com");
        registerPage.escribirTelefono("1134567650");
        registerPage.escribirContraseña("123486");
        registerPage.repetirContraseña("123486");
        test.log(Status.PASS, "Ingreso todos los datos del registro");
        registerPage.clickRejectNewsletter();
        test.log(Status.PASS, "Rechazo suscripcion al newsletter");
        registerPage.clickPoliciesCheckbox();
        test.log(Status.PASS, "Acepto términos y condiciones");
        registerPage.clickFinalizarRegistro();
        registerPage.cuentaCreadaExito().equals("Congratulations! Your new account has been successfully created!");
        test.log(Status.PASS, "Validación de registro Exitoso");
        test.log(Status.INFO, "Finaliza el Test");
    }

    @AfterEach
    public void endTest() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.close();
    }

    @AfterAll
    public static void finish() {
        extent.flush();
        System.out.println("<<< FINALIZAN LOS TEST DE REGISTRO >>>");
    }
}
