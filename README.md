# Exemple de code utilisant certains patterns tactiques de Domain Driven Design

## Sujet choisi

Le sujet choisi est volontairement simple et compréhensible par tous : une gestion de panier pour un site de e-commerce.

## Patterns tactiques mis en oeuvre

Les trois patterns tactiques choisis sont :

* Value object (pour résoudre la problématique de [primitive obsession](https://refactoring.guru/fr/smells/primitive-obsession))
* Entity
* Aggregate (pour maintenir la stabilité des données du modèle)

Les objets du domaine créé correspondant à ces patterns sont :

* Value objects : IdentifiantDuPanier, Prix, Quantite, ReferenceArticle, Total
* Entity : Article
* Aggregate : Panier