package com.primobox.ddd.ecommerce.panier.domaine;

public interface PaniersRepository {
    Panier parIdentifiant(IdentifiantDuPanier identifiantDuPanier);
    void stocker(Panier panier);
}
