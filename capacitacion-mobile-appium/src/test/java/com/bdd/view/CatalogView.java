package com.bdd.view;

import com.mobile.MobileBase;
import com.mobile.Util;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;




public class CatalogView extends MobileBase {

    @AndroidFindBy(accessibility = "cart badge")
    @iOSXCUITFindBy(accessibility = "cart badge")
    private MobileElement btnCarrito;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='cart badge']/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//")
    private static MobileElement txtCantidadCarrito;


    public boolean validarPantalla(String sTitulo) {
        String sXPath = "//android.widget.TextView[@text='%s']";
        Util.takeScreenShoot();
        return isObjectVisibleBySeconds(getMobileElementByXPath(String.format(sXPath, sTitulo)), 2);

    }

    public static boolean validarGaleria() {
        explicitWaiting(4000, driver -> ExpectedConditions.visibilityOf(getMobileElementByXPath("//android.widget.TextView[contains(@text,'Sauce Labs')]")));
        Util.takeScreenShoot();
        return isObjectVisibleBySeconds(getMobileElementByXPath("//android.widget.TextView[contains(@text,'Sauce Labs')]"), 20);

    }
    public void seleccionarProducto(String producto) {
        String sXPath = "//android.widget.TextView[@content-desc='store item text' and contains(@text,'%s')]";
        clickElement(getMobileElementByXPath(String.format(sXPath, producto)));
    }

    public void agregarUnidades(int unidades) {
        for (int i = 0; i < unidades; i++) {
            clickElement(getMobileElementByXPath("//android.view.ViewGroup[@content-desc='Add To Cart button']"));
        }

    }

    public void abrirCarrito() {
        clickElement(btnCarrito);
        explicitWaiting(4000, driver -> ExpectedConditions.visibilityOf(getMobileElementByXPath("//android.widget.TextView[@text='My Cart']")));
        Util.takeScreenShoot();
    }


    public static String obtenerCantidadCarrito() {
        if (isObjectVisibleBySeconds(txtCantidadCarrito, 10)) {
            return txtCantidadCarrito.getText();
        }
        return "0";
    }
}



