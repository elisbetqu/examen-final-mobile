package com.bdd.glue;


import com.bdd.step.CatalogStep;
import io.cucumber.java.PendingException;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

/**
 * @author Karla Ccallo
 */
public class CatalogGlue {

    private String unidadesEsperadas;

    @Steps
    private CatalogStep catalogStep= new CatalogStep();;


    @Y("deberia mostrarme la pantalla de catalogo de productos {string}")
    public void meMuestraLaPantallaDe(String sTitulo) {
        Assert.assertTrue("No mostro pantalla: "+sTitulo, catalogStep.validarPantalla(sTitulo));
    }

    @Y("valido que carguen correctamente los productos en la galeria")
    public void validarGaleria() {
        Assert.assertTrue(catalogStep.validarGaleria());
    }

    @Cuando("agrego {int} del siguiente producto {string}")
    public void agregoProducto(int unidades, String producto) {
        this.unidadesEsperadas = String.valueOf(unidades);
        catalogStep.agregarProducto(unidades, producto);
    }

    @Entonces("valido el carrito de compra actualice correctamente")
    public void validoCarrito() {
        catalogStep.validarCarrito(this.unidadesEsperadas);
    }
}
