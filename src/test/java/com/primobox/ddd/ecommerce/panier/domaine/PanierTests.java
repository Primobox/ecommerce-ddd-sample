package com.primobox.ddd.ecommerce.panier.domaine;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class PanierTests {

    @Test
    void doit_etre_initialise_avec_des_valeurs_coherentes() {
        assertThat(new Panier(new IdentifiantDuPanier("PANIER")).total()).isEqualTo("0");
    }

    @Nested
    class DoitRecalculerLeTotal {

        @Test
        void en_ajoutant_des_articles() {
            Panier panier = new Panier(new IdentifiantDuPanier("PANIER"));
            panier.ajouterArticle(new ReferenceArticle("PIZZA_REGINA_BUITONI"), new Prix(new BigDecimal("5.10")));
            panier.ajouterArticle(new ReferenceArticle("KNACKI_HERTA"), new Prix(new BigDecimal("2.38")));

            assertThat(panier.total()).isEqualTo("7.48");
        }

        @Test
        void en_ajoutant_et_supprimant_des_articles() {
            Panier panier = new Panier(new IdentifiantDuPanier("PANIER"));
            panier.ajouterArticle(new ReferenceArticle("PIZZA_REGINA_BUITONI"), new Prix(new BigDecimal("5.10")));
            panier.ajouterArticle(new ReferenceArticle("KNACKI_HERTA"), new Prix(new BigDecimal("2.38")));
            panier.enleverArticle(new ReferenceArticle("KNACKI_HERTA"));

            assertThat(panier.total()).isEqualTo("5.10");
        }

        @Test
        void en_ajoutant_et_supprimant_plusieurs_articles() {
            Panier panier = new Panier(new IdentifiantDuPanier("PANIER"));
            panier.ajouterArticle(new ReferenceArticle("PIZZA_REGINA_BUITONI"), new Prix(new BigDecimal("5.10")));
            panier.ajouterArticle(new ReferenceArticle("PIZZA_REGINA_BUITONI"), new Prix(new BigDecimal("5.10")));
            panier.ajouterArticle(new ReferenceArticle("PIZZA_REGINA_BUITONI"), new Prix(new BigDecimal("5.10")));
            panier.ajouterArticle(new ReferenceArticle("KNACKI_HERTA"), new Prix(new BigDecimal("2.38")));
            panier.enleverArticle(new ReferenceArticle("KNACKI_HERTA"));
            panier.enleverArticle(new ReferenceArticle("PIZZA_REGINA_BUITONI"));

            assertThat(panier.total()).isEqualTo("10.20");
        }

        @Test
        void en_ajoutant_et_supprimant_plusieurs_fois_des_articles() {
            Panier panier = new Panier(new IdentifiantDuPanier("PANIER"));
            panier.ajouterArticle(new ReferenceArticle("PIZZA_REGINA_BUITONI"), new Prix(new BigDecimal("5.10")));
            panier.enleverArticle(new ReferenceArticle("KNACKI_HERTA"));
            panier.enleverArticle(new ReferenceArticle("KNACKI_HERTA"));

            assertThat(panier.total()).isEqualTo("5.10");
        }

        @Test
        void en_vidant_le_panier() {
            Panier panier = new Panier(new IdentifiantDuPanier("PANIER"));
            panier.ajouterArticle(new ReferenceArticle("PIZZA_REGINA_BUITONI"), new Prix(new BigDecimal("5.10")));
            panier.ajouterArticle(new ReferenceArticle("PIZZA_REGINA_BUITONI"), new Prix(new BigDecimal("5.10")));
            panier.ajouterArticle(new ReferenceArticle("PIZZA_REGINA_BUITONI"), new Prix(new BigDecimal("5.10")));
            panier.ajouterArticle(new ReferenceArticle("KNACKI_HERTA"), new Prix(new BigDecimal("2.38")));
            panier.vider();

            assertThat(panier.total()).isEqualTo("0");
        }
    }
}
