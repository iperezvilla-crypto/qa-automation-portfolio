package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.support.ui.Select;

public class PrimerTestSelenium {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    void deberiaAbrirSauceDemoYEncontrarElLogo() {
        driver.get("https://www.saucedemo.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locator por id, con espera explícita
        WebElement usuario = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))
        );
        System.out.println("Campo usuario encontrado: " + usuario.isDisplayed());

        // Locator por CSS selector, con espera explícita
        WebElement logo = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".login_logo"))
        );
        System.out.println("Texto del logo: " + logo.getText());
    }
    @Test
    void deberiaHacerLoginYOrdenarProductosPorPrecio() {
        driver.get("https://www.saucedemo.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Completar el formulario de login
        WebElement usuario = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        usuario.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement botonLogin = driver.findElement(By.id("login-button"));
        botonLogin.click();

        // Confirmar que el login funcionó
        WebElement tituloProductos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
        System.out.println("Título tras login: " + tituloProductos.getText());

        // Interactuar con el dropdown de orden de productos
        WebElement dropdownOrden = driver.findElement(By.className("product_sort_container"));
        Select selectOrden = new Select(dropdownOrden);
        selectOrden.selectByVisibleText("Price (low to high)");

        WebElement dropdownActualizado = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("product_sort_container"))
        );
        Select selectActualizado = new Select(dropdownActualizado);
        System.out.println("Opción seleccionada: " + selectActualizado.getFirstSelectedOption().getText());
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}