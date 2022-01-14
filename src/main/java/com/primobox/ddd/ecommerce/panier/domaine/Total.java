package com.primobox.ddd.ecommerce.panier.domaine;

import java.math.BigDecimal;

record Total(BigDecimal valeur) {
    Total {
        if (valeur.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Le total du panier doit être supérieur ou égal à zéro");
        }
    }
}
