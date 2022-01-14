package com.primobox.ddd.ecommerce.panier.domaine;

class Article {

    private final ReferenceArticle referenceArticle;

    private final Prix prix;

    private Quantite quantite;

    Article(ReferenceArticle referenceArticle, Prix prix) {
        this.referenceArticle = referenceArticle;
        this.prix = prix;
        this.quantite = new Quantite(1);
    }

    void incrementerQuantite() {
        this.quantite = new Quantite(this.quantite.valeur() + 1);
    }

    void decrementerQuantite() {
        this.quantite = new Quantite(this.quantite.valeur() - 1);
    }

    Prix prix() {
        return prix;
    }

    Quantite quantite() {
        return quantite;
    }

    boolean quantiteNulle() {
        return this.quantite.valeur() == 0;
    }
}
