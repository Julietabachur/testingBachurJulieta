package OpenCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ShopPage extends BasePage{

    private By searchBar = By.xpath("(//input[@placeholder='Search'])[1]");
    private By btnSearch = By.cssSelector(".fa.fa-search");
    private By btnAddProduct = By.xpath("(//i[@class='fa fa-shopping-cart'])[3]");
    private By success = By.xpath("(//div[@class='alert alert-success alert-dismissible'])[1]");


    /**Constructor de la clase ShopPage
     * @param driver la instancia de WebDriver utilizada para interactuar con la página web
     */
    public ShopPage(WebDriver driver, WebDriverWait wait) {
        super(driver, null);
    }

    /** Ingresa el producto proporcionado en el campo de search.
     * @param producto el producto a ingresar en el campo
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void escribirProducto(String producto) throws InterruptedException {
        this.sendText(producto, searchBar);
    }

    /** Hace click en el botón "Buscar".
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickBuscar() throws InterruptedException {
        this.click(btnSearch);
    }

    /** Hace click en el botón "Add to cart".
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public void clickAgregar() throws InterruptedException {
        this.click(btnAddProduct);
    }

    /** Obtiene el texto del mensaje de éxito indicando que el producto fue agregado al carrito.
     * @return el texto del mensaje de éxito
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     */
    public String productoAgregadoConExito() throws InterruptedException {
        String res = this.getText(success);
        System.out.println("Resultado Card value: " + res);
        return res;
    }
}
