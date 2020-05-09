# Application Covid-19

## Présentation

Ce projet démontre l'utilisation du design pattern MVC, le tout codé en JAVA.

Covid-19 est une application affichant les nombres totaux de personnes ayant été confirmés comme nouveaux cas victimes du Coronavirus, les personnes décédées suite au virus et les personnes guéries. Aussi, on peut recueillir le détail par pays de ces nombres.

## Prérequis

* Installation d'Android Studio

## Consignes respectées

* Architecture MVC
* Singletons
* Principe SOLID
* 7 activités, 7 fragments
* Ecran affichant d'une liste dans un RecyclerView
* Ecran avec le détail d'un élément de la liste
* Appel Webservice à une API REST
* Stockage de données en cache
* Fonctions supplémentaires :
  * Barre de recherche
  * Menu disponible sur le coté de l'écran de chacun des écrans
  * utilisation de la librairie Picasso.

## Fonctionnalités

### Logo de l'application

![github-small](https://github.com/MarieDouguet/Android3A/blob/master/images/icone.jpg)

### Ecran d'accueil

Logo de l'application et bouton permettant d'accéder au menu principal

<img src="https://github.com/MarieDouguet/Android3A/blob/master/images/1%C3%A8re%20page.jpg" width="190" height="400" />

### Ecran menu principal

* Vidéo "gestes barrières"
* Spinner 
* 2 boutons :
   * Global : menant vers les totaux dans le monde
   * List of countries : menant vers la RecyclerView
 <div class = "images">
 
 <img src ="https://github.com/MarieDouguet/Android3A/blob/master/images/video_menu.jpg" width="190" height="400"> <img src ="https://github.com/MarieDouguet/Android3A/blob/master/images/spinner_menu.jpg" width="190" height="400">
 
 </div>
 
 ### Ecran liste des pays 
 
 Affiche la liste des pays avec barre de recherche
 
 <div class = "images">
 
 <img src ="https://github.com/MarieDouguet/Android3A/blob/master/images/list%20of%20countries.jpg" width="190" height="400"> <img src ="https://github.com/MarieDouguet/Android3A/blob/master/images/filtre%20liste.jpg" width="190" height="400">
 
 </div>
 
 ### Ecran détail d'un élément de la liste
 
 * Affiche les différents chiffres sur le Coronavirus dans le pays
 * Drapeau du pays changeant en fonction du pays affiché
 * Menu sur le côté permettant d'accéder à toutes les pages de l'application (toutes les pages en sont équipées et elle change à chaque fois en fonction de la page où l'on se trouve actuellement)
 
 <div class = "images">
 
 <img src ="https://github.com/MarieDouguet/Android3A/blob/master/images/d%C3%A9tail_liste%20France.jpg" width="190" height="400"> <img src ="https://github.com/MarieDouguet/Android3A/blob/master/images/d%C3%A9tail_liste%20Italie.jpg" width="190" height="400"> <img src ="https://github.com/MarieDouguet/Android3A/blob/master/images/navigation%20view%20detail%20country.jpg" width="190" height="400">
 
 </div>
 
 ### Ecran chiffres globaux
 
 Affiche avec une mise à jour régulière les chiffres sur le Coronavirus dans le monde
 
 <img src ="https://github.com/MarieDouguet/Android3A/blob/master/images/global_figures.jpg" width="190" height="400">
 
 ### Ecran liens utiles
 

Affiche des liens qui, en cliquant dessus, renvoient directement aux sites officiels sur le Covid-19.

 <img src ="https://github.com/MarieDouguet/Android3A/blob/master/images/liens%20utiles.jpg" width="190" height="400">
 
 ### Ecran memes sur le Covid-19
 
 Affiche des memes que l'on peut faire défiler (utilisation de Picasso)
 
  <img src ="https://github.com/MarieDouguet/Android3A/blob/master/images/memes_picasso.jpg" width="190" height="400">
 
 ### Ecran à propos de l'application

 <img src ="https://github.com/MarieDouguet/Android3A/blob/master/images/%C3%A0%20propos.jpg" width="190" height="400">
 
 
 
 
 

