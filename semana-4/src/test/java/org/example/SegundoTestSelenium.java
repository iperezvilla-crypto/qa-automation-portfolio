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


public class SegundoTestSelenium {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    void deberiaMostrarErrorConLoginInvalido() {
        driver.get("https://www.saucedemo.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Completar el formulario de login
        WebElement usuario = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        usuario.sendKeys("standard_user");

        WebElement campoPassword = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("password"))
        );
        campoPassword.sendKeys("wrong_password");

        WebElement botonLogin = driver.findElement(By.id("login-button"));
        botonLogin.click();

        // Ubicar el mensaje de error con espera explícita
        WebElement mensajeError = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']"))
        );
        System.out.println("Mensaje de error: " + mensajeError.getText());
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
