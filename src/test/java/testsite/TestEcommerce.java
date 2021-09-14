package testsite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestEcommerce {

    private WebDriver driver;

    @Before
    public void inicializarNavegador (){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @After
    public void finalizarNavegador(){
        driver.quit();
    }

    @Test
    public void verificarPaginaInicial(){
        WebElement elementoPaginaInicial = driver.findElement(By.xpath("//*[@id=\"editorial_block_center\"]/h1"));
        Assert.assertEquals("Automation Practice Website", elementoPaginaInicial.getText());
    }

    @Test
    public void verificarContactUsESignInNaPaginaInicial(){
        WebElement contactUs = driver.findElement(By.xpath("//*[@id=\"contact-link\"]/a"));
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));
        Assert.assertEquals("Contact us", contactUs.getText());
        Assert.assertEquals("Sign in", signIn.getText());
    }

    @Test
    public void verificarTelefonePaginaInicial(){
        WebElement telefone = driver.findElement(By.xpath("//*[@id=\"block_contact_infos\"]/div/ul/li[2]/span"));
        Assert.assertEquals("(347) 466-7432", telefone.getText());
    }

}
