# Projet-Menu

Projet réalisé par : COURTIAL Julien, GROS-DAILLON Hugo et TERRIER Bastien

Ce projet est réalisé en JAVA 10 avec la librairie SWING. Nous avons mis en place un JAR exécutable dans le dossier du projet : **BubbleMenu.jar**.

Un compte rendu en PDF est aussi disponible : **[INFO5][IHM-Avancee][Bubbling-Menu]COURTIAL-TERRIER-GROS-DAILLON.pdf**.

## Fonctionnalités


Notre bubbling est en permanence actif. Il est symbolisé par un cercle gris centré sur la souris. Le menu est affiché en transparence, nous pouvons donc voir en toutes circonstances les items sous la bulle. L’item favori le plus proche sera l’item sélectionné par défaut, il sera mis en surbrillance pour assurer un retour visuel à l’utilisateur. 
Notre menu comporte deux types d'interactions, le bubbling et l’interaction standard dans les menus. Pour passer d’une interaction à l’autre, nous n’avons pas besoin d’utiliser une touche supplémentaire (clavier ou souris). L’interaction standard est possible lorsque la souris est située dans le menu. l'interaction avancée, quant à elle, est active lorsque que la souris n’est pas dans un menu. Par conséquent, si nous voulons sélectionner un item (ou sous menu) avec le bubble menu, il faut sortir la souris du menu. Comme le bubbling menu permet de faire des gestes grossier, l’utilisateur ne perd pas en efficacité.

## Choix d’implémentation

Nous avons fait le choix d’afficher en permanence le bubbling menu pour ne pas avoir à devoir l’activer et le désactiver ce qui serait une perte de temps (niveau efficacité) pour ce type de menu et nous aurait nécessité l’utilisation d’un bouton en plus (clavier, souris, etc.).

Lorsque l’on clique avec le bouton gauche de la souris en dehors d’un menu, cela va cliquer automatiquement sur le menu “favori” qui minimise la distance entre le centre de l’item et du curseur de la souris. (le bubble menu est en transparence pour ne pas cacher l’écran et est relié entre le curseur de la souris au centre du menu ainsi que le menu favori le plus proche.) Nous avons fait ce choix pour avoir une rapidité d’exécution permanente. Si l’on veut sélectionner un item favori dans un menu favori, il suffit de se rapprocher du menu et de cliquer (n’importe où tant qu’on est assez proche) et de cliquer aussi proche de l’item. Cela nous permet de gagner énormément en rapidité de sélection et ce que nous avons recherché dans notre implémentation.

Nous avons implémentés le Bubbling menu en Java (Version 10) avec la librairie Swing car c’est ce que nous avions fait pour les précédents menu réalisés en TP d’IHM et qui nous paraissait donc le plus pertinent.

