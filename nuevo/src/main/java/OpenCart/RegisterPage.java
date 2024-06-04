package OpenCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {
    private By nombre = By.id("input-firstname");
    private By apellido = By.id("input-lastname");
    private By email = By.id("input-email");
    private By telefono = By.id("input-telephone");
    private By password = By.id("input-password");
    private By repassword = By.id("input-confirm");
    private By newsletter = By.xpath("//input[@value='0']");
    private By btnMyAccount = By.linkText("My Account");
    private By btnRegister = By.linkText("Register");
    private By btnConfirmRegister = By.xpath("(//input[@value='Continue'])[1]");
    private By acceptConditions = By.name("agree");
    private By exito = By.xpath("(//p[contains(text(),'Congratulations! Your new account has been success')])[1]");

    /**Constructor de la clase RegisterPage
     * @param driver la instancia de WebDriver utilizada para interactuar con la página web
     */
    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, null);
    }

    /** Hace click en el botón "My Account".
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickCrearCuenta() throws InterruptedException {
        this.click(btnMyAccount);
    }

    /** Hace click en el botón "Register".
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickRegistrarse() throws InterruptedException {
        this.click(btnRegister);
    }

    /** Hace click en el botón "Continue" del form de registro.
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickConfirmRegister() throws InterruptedException {
        this.click(btnConfirmRegister);
    }

    /** Ingresa el nombre proporcionado en el campo de nombre.
     * @param name el nombre a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirNombre(String name) throws InterruptedException {
        this.sendText(name, nombre);
    }

    /** Ingresa el apellido proporcionado en el campo de apellido.
     * @param name el apellido a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirApellido(String name) throws InterruptedException {
        this.sendText(name, apellido);
    }

    /** Ingresa el correo electrónico proporcionado en el campo de correo electrónico.
     * @param mail el correo electrónico a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirCorreo(String mail) throws InterruptedException {
        this.sendText(mail, email);
    }

    /** Ingresa el telefono proporcionado en el campo de telefono.
     * @param tel el telefono a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirTelefono(String tel) throws InterruptedException {
        this.sendText(tel, telefono);
    }

    /** Ingresa la contraseña proporcionada en el campo de contraseña.
     * @param pass la contraseña a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirContraseña(String pass) throws InterruptedException {
        this.sendText(pass, password);
    }

    /** Reingresa la contraseña proporcionada en el campo de confirmación de contraseña.
     * @param pass la contraseña a reingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void repetirContraseña(String pass) throws InterruptedException {
        this.sendText(pass, repassword);
    }

    /** Hace click en el botón "NO" del newsletter.
     *
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickRejectNewsletter() throws InterruptedException {
        this.click(newsletter);
    }

    /** Hace click en el checkbox de politicas.
     *
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickPoliciesCheckbox() throws InterruptedException {
        this.click(acceptConditions);
    }

    /** Hace click en el botón "Continue".
     *
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickFinalizarRegistro() throws InterruptedException {
        this.click(btnConfirmRegister);
    }

    /** Obtiene el texto del mensaje de éxito indicando la creación de la cuenta.
     * @return el texto del mensaje de éxito
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public String cuentaCreadaExito() throws InterruptedException {
        String res = this.getText(exito);
        System.out.println("Resultado Card value: " + res);
        return res;
    }


}
