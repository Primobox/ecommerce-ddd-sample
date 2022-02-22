package com.primobox.ddd.ecommerce.panier;

import com.primobox.ddd.ecommerce.panier.domaine.IdentifiantDuPanier;
import com.primobox.ddd.ecommerce.panier.domaine.commandes.AjoutDUnArticle;
import com.primobox.ddd.ecommerce.panier.infrastructure.enmemoire.PaniersEnMemoireRepository;
import com.primobox.ddd.ecommerce.panier.usecases.AjouterUnArticleAuPanier;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.primobox.ddd.ecommerce.panier.assertions.PanierAssert.assertThat;


public class TestDAcceptationDAjoutDArticleAuPanier {

    @Test
    void doit_recalculer_le_total_apres_avoir_ajoute_un_article() {
        var paniersRepository = new PaniersEnMemoireRepository();
        var ajouterUnArticleAuPanier = new AjouterUnArticleAuPanier(paniersRepository);

        ajouterUnArticleAuPanier.executer(new AjoutDUnArticle("PANIER", "reference", new BigDecimal("2.50")));

        assertThat(paniersRepository.parIdentifiant(new IdentifiantDuPanier("PANIER"))).hasTotal("2.50");
    }

    @Test
    void doit_recalculer_le_total_apres_avoir_ajoute_plusieurs_articles() {
        var paniersRepository = new PaniersEnMemoireRepository();
        var ajouterUnArticleAuPanier = new AjouterUnArticleAuPanier(paniersRepository);

        ajouterUnArticleAuPanier.executer(new AjoutDUnArticle("PANIER", "reference", new BigDecimal("2.50")));
        ajouterUnArticleAuPanier.executer(new AjoutDUnArticle("PANIER", "reference2", new BigDecimal("3.37")));
        ajouterUnArticleAuPanier.executer(new AjoutDUnArticle("PANIER", "reference3", new BigDecimal("18.6")));
        ajouterUnArticleAuPanier.executer(new AjoutDUnArticle("PANIER", "reference", new BigDecimal("2.50")));

        assertThat(paniersRepository.parIdentifiant(new IdentifiantDuPanier("PANIER"))).hasTotal("26.97");
    }
}
