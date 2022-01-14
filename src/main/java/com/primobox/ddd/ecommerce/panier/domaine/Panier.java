package com.primobox.ddd.ecommerce.panier.domaine;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Panier {

    private final Map<ReferenceArticle, Article> articles;

    private Total total;

    public Panier() {
        this.articles = new HashMap<>();
        this.total = new Total(new BigDecimal(0));
    }

    public void vider() {
        this.articles.clear();
        this.calculerTotal();
    }

    public void ajouterArticle(ReferenceArticle referenceArticle, Prix prix) {
        final Article article;
        if (this.articles.containsKey(referenceArticle)) {
            article = this.articles.get(referenceArticle);
            article.incrementerQuantite();
        } else {
            article = new Article(referenceArticle, prix);
            this.articles.put(referenceArticle, article);
        }
        this.calculerTotal();
    }

    public void enleverArticle(ReferenceArticle referenceArticle) {
        if (this.articles.containsKey(referenceArticle)) {
            Article article = this.articles.get(referenceArticle);
            article.decrementerQuantite();
            if (article.quantiteNulle()) {
                this.articles.remove(referenceArticle);
            }
        }
        this.calculerTotal();
    }

    private void calculerTotal() {
        Total total = new Total(new BigDecimal(0));
        for (Article article : this.articles.values()) {
            total = new Total(total.valeur().add(
                article.prix().valeur().multiply(new BigDecimal(article.quantite().valeur()))
            ));
        }
        this.total = total;
    }

    public String total() {
        return this.total.valeur().toString();
    }
}
