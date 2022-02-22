package com.primobox.ddd.ecommerce.panier.domaine.commandes;

import java.math.BigDecimal;

public record AjoutDUnArticle(String identifiantDuPanier, String reference, BigDecimal prix) {
}
