package com.bdd.step;

import com.bdd.view.CatalogView;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Karla Ccallo
 */
public class CatalogStep {

    private CatalogView catalogSauceView() {
        return new CatalogView();
    }

    @Step
    public boolean validarPantalla(String sTitulo) {
        return catalogSauceView().validarPantalla(sTitulo);
    }

    @Step
    public boolean validarGaleria() {
        return CatalogView.validarGaleria();
    }

    @Step
    public void agregarProducto(int unidades, String producto) {
        catalogSauceView().seleccionarProducto(producto);
        catalogSauceView().agregarUnidades(unidades);

    }

    @Step
    public void validarCarrito(String cantidadEsperada) {
        catalogSauceView().abrirCarrito();
        String cantidadActual = catalogSauceView().obtenerCantidadCarrito();
        Assert.assertEquals("La cantidad en el icono no coincide", cantidadEsperada, cantidadActual);

    }
}
