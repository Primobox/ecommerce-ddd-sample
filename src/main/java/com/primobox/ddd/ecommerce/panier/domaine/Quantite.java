package com.primobox.ddd.ecommerce.panier.domaine;

record Quantite(int valeur) {

    Quantite {
        if (valeur < 0) {
            throw new IllegalArgumentException("Une quantité ne peut pas être négative");
        }
    }
}
