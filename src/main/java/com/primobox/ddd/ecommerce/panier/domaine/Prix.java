package com.primobox.ddd.ecommerce.panier.domaine;

import java.math.BigDecimal;

public record Prix(BigDecimal valeur) {
    public Prix {
        if (valeur.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Le prix d'un article ne peut pas être inférieur ou égal à zéro");
        }
    }
}
