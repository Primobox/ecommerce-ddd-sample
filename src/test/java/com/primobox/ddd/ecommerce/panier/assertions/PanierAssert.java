package com.primobox.ddd.ecommerce.panier.assertions;

import com.primobox.ddd.ecommerce.panier.domaine.Panier;
import org.assertj.core.api.AbstractAssert;

public class PanierAssert extends AbstractAssert<PanierAssert, Panier> {
    private PanierAssert(Panier panier) {
        super(panier, PanierAssert.class);
    }

    public static PanierAssert assertThat(Panier panier) {
        return new PanierAssert(panier);
    }

    public PanierAssert hasTotal(String expected) {
        if (!actual.total().equals(expected)) {
            failWithMessage("Expected total to be " + expected + ", but was " + actual.total());
        }
        return this;
    }
}
