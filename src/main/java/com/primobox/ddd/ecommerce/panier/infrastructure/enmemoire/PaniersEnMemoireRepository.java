package com.primobox.ddd.ecommerce.panier.infrastructure.enmemoire;

import com.primobox.ddd.ecommerce.panier.domaine.IdentifiantDuPanier;
import com.primobox.ddd.ecommerce.panier.domaine.Panier;
import com.primobox.ddd.ecommerce.panier.domaine.PaniersRepository;

import java.util.HashMap;
import java.util.Map;

public class PaniersEnMemoireRepository implements PaniersRepository {
    private final Map<IdentifiantDuPanier, Panier> paniers = new HashMap<>();

    public PaniersEnMemoireRepository() {
        var identifiantDuPanier = new IdentifiantDuPanier("PANIER");
        this.paniers.put(identifiantDuPanier, new Panier(identifiantDuPanier));
    }

    @Override
    public Panier parIdentifiant(IdentifiantDuPanier identifiantDuPanier) {
        return this.paniers.get(identifiantDuPanier);
    }

    @Override
    public void stocker(Panier panier) {
        this.paniers.put(panier.identifiant(), panier);
    }
}
