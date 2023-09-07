package base;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import methods.InsercaoMethods;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.screenshot;

public abstract class BaseTest  extends InsercaoMethods {

    @BeforeMethod
    public void before() {
        configuracao();
    }

    @AfterMethod
    public void after() {
        try {
            byte[] screenshot = Selenide.screenshot("print").getBytes();
            Allure.addAttachment("Screenshot", "image/png", new ByteArrayInputStream(screenshot), "png");
        } catch (Exception e) {
            System.out.println("Erro ao capturar a imagem! Trace => " + e.getMessage());
            closeWindow();
        }
    }
}

