package com.primobox.ddd.ecommerce.panier.usecases;

import com.primobox.ddd.ecommerce.panier.domaine.IdentifiantDuPanier;
import com.primobox.ddd.ecommerce.panier.domaine.PaniersRepository;
import com.primobox.ddd.ecommerce.panier.domaine.Prix;
import com.primobox.ddd.ecommerce.panier.domaine.ReferenceArticle;
import com.primobox.ddd.ecommerce.panier.domaine.commandes.AjoutDUnArticle;

public class AjouterUnArticleAuPanier {

    private final PaniersRepository paniersRepository;

    public AjouterUnArticleAuPanier(PaniersRepository paniersRepository) {
        this.paniersRepository = paniersRepository;
    }

    public void executer(AjoutDUnArticle ajoutDUnArticle) {
        var panier = paniersRepository.parIdentifiant(new IdentifiantDuPanier(ajoutDUnArticle.identifiantDuPanier()));
        panier.ajouterArticle(new ReferenceArticle(ajoutDUnArticle.reference()), new Prix(ajoutDUnArticle.prix()));

        paniersRepository.stocker(panier);
    }
}
