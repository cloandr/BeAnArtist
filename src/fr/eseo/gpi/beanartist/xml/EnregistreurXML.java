package fr.eseo.gpi.beanartist.xml;

import fr.eseo.gpi.beanartist.modele.geom.Carré;
import fr.eseo.gpi.beanartist.modele.geom.Cercle;
import fr.eseo.gpi.beanartist.modele.geom.Ellipse;
import fr.eseo.gpi.beanartist.modele.geom.Ligne;
import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.modele.geom.Rectangle;
import fr.eseo.gpi.beanartist.modele.geom.Tracé;
import fr.eseo.gpi.beanartist.vue.geom.VueForme;

import org.w3c.dom.Element;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Un enregistreur XML est un processeur DOM responsable de l'enregistrement
 * d'un dessin au format XML défini par l'application.
 * 
 * Il utilise les méthodes héritées de la classe ProcesseurDOM pour créer un
 * document DOM et l'enregistrer dans un fichier XML, ainsi que les méthodes
 * d'écriture des entiers.
 * 
 * Les méthodes enregistreDessin et créeElémentXxxx devront être complétées. Des
 * méthodes utilitaires pourront venir compléter celles définies par la classe
 * ProcesseurDOM ; elles devront dans ce cas être OBLIGATOIREMENT définies en
 * "private" à la fin de la classe EnregistreurXML.
 *
 */
public class EnregistreurXML extends ProcesseurDOM {

  /**
   * Lance le test d'enristrement (méthode teste) avec le fichier XML d'entrée
   * nommé "S30-Dessin-in.xml" et le fichier XML de sortie nommé
   * "S30-Dessin-out.xml".
   * 
   * Ce test MANUEL doit OBLIGATOIREMENT passer avant de commencer la gestion
   * de l'enregistrement en SVG (classe EnregistreurSVG). Il est INDISPENSABLE
   * de vérifier la conformité entre les fichiers d'entrée et de sortie. Il
   * peut subsister des différentces normales entre ces deux fichiers (par
   * exemple pour les valeurs par défaut telles que la couleur de remplissage
   * des vues). De plus, l'affichage du fichier de sortie doit être conforme à
   * ce qui est attendu.
   */
  public static void main(String[] args) throws FileNotFoundException {
    teste("S30-Dessin-in.xml", "S30-Dessin-out.xml");
  }

  /**
   * Teste l'enregistrement du dessin dans un fichier XML. Le fichier XML
   * d'entrée est préalablement lu, puis sauvagardé dans un fichier de sortie.
   * Le fichier de sortie est ensuite chargé et visualisé par l'application.
   * 
   * @param nomFichierEntrée le nom du fichier XML d'entrée lu
   * @param nomFichierSortie le nom du fichier XML de sortie écrit puis
   *            affiché
   * @throws FileNotFoundException si l'un des noms des fichiers n'est pas
   *             valide
   */
  public static void teste(String nomFichierEntrée, String nomFichierSortie) throws FileNotFoundException {
    LecteurXML lecteur = new LecteurXML();
    final List<VueForme> dessin = lecteur.lisDessin(nomFichierEntrée);
    EnregistreurXML enregistreur = new EnregistreurXML();
    enregistreur.enregistreDessin(nomFichierSortie, dessin);
    LecteurXML.teste(nomFichierSortie);
  }

  /**
   * Enregistre le dessin donné dans un fichier.
   * @param nomFichier le nom du fichier de sauvegarde
   * @param dessin le dessin formé de la liste des vues des formes
   * @throws FileNotFoundException si le nom du fichier n'est pas valide
   */
  public void enregistreDessin(String nomFichier, List<VueForme> dessin) throws FileNotFoundException {
    créeDocumentXML("dessin");
    Element racine = getDocument().getDocumentElement();
    for (int i = 0; i < dessin.size(); i++) {
      racine.appendChild(this.créeElémentVueForme(dessin.get(i)));
    }
    enregistreDocument(nomFichier);
  }

  /**
   * Crée un élément DOM représentant la vue donnée d'une forme et retourne
   * cet élément. Cette méthode invoque les méthodes créeElément<Forme> en
   * fonction du type de la vue.
   * @param vueForme la vue d'une forme
   * @return l'élément DOM représentant la vue d'une forme
   */
  public Element créeElémentVueForme(VueForme vueForme) {
    String nom = vueForme.getClass().getSimpleName();
    Element élément;
    String red;
    String green;
    String blue;
    if (nom.equals("VueRectangle")) {
      Rectangle forme = (Rectangle) vueForme.getForme();
      élément = créeElémentRectangle(forme);
      red = String.valueOf(vueForme.getCouleurLigne().getRed());
      green = String.valueOf(vueForme.getCouleurLigne().getGreen());
      blue = String.valueOf(vueForme.getCouleurLigne().getBlue());
      élément.setAttribute("couleur", red+","+green+","+blue);
      élément.setAttribute("remplissage", String.valueOf(vueForme.estRempli()));
      System.out.println(vueForme.getCouleurLigne().getRGB());
    } else if (nom.equals("VueCarré")) {
      Carré forme = (Carré) vueForme.getForme();
      élément = créeElémentCarré(forme);
      red = String.valueOf(vueForme.getCouleurLigne().getRed());
      green = String.valueOf(vueForme.getCouleurLigne().getGreen());
      blue = String.valueOf(vueForme.getCouleurLigne().getBlue());
      élément.setAttribute("couleur", red+","+green+","+blue);
      élément.setAttribute("remplissage", String.valueOf(vueForme.estRempli()));
    } else if (nom.equals("VueEllipse")) {
      Ellipse forme = (Ellipse) vueForme.getForme();
      élément = créeElémentEllipse(forme);
      red = String.valueOf(vueForme.getCouleurLigne().getRed());
      green = String.valueOf(vueForme.getCouleurLigne().getGreen());
      blue = String.valueOf(vueForme.getCouleurLigne().getBlue());
      élément.setAttribute("couleur", red+","+green+","+blue);
      élément.setAttribute("remplissage", String.valueOf(vueForme.estRempli()));
    } else if (nom.equals("VueCercle")) {
      Cercle forme = (Cercle) vueForme.getForme();
      élément = créeElémentCercle(forme);
      red = String.valueOf(vueForme.getCouleurLigne().getRed());
      green = String.valueOf(vueForme.getCouleurLigne().getGreen());
      blue = String.valueOf(vueForme.getCouleurLigne().getBlue());
      élément.setAttribute("couleur", red+","+green+","+blue);
      élément.setAttribute("remplissage", String.valueOf(vueForme.estRempli()));
    }  else if (nom.equals("VueLigne")) {
      Ligne forme = (Ligne) vueForme.getForme();
      élément = créeElémentLigne(forme);
      red = String.valueOf(vueForme.getCouleurLigne().getRed());
      green = String.valueOf(vueForme.getCouleurLigne().getGreen());
      blue = String.valueOf(vueForme.getCouleurLigne().getBlue());
      élément.setAttribute("couleur", red+","+green+","+blue);
      élément.setAttribute("remplissage", String.valueOf(false));
    } else if (nom.equals("VueTracé")) {
      Tracé forme = (Tracé) vueForme.getForme();
      élément = créeElémentTracé(forme);
      red = String.valueOf(vueForme.getCouleurLigne().getRed());
      green = String.valueOf(vueForme.getCouleurLigne().getGreen());
      blue = String.valueOf(vueForme.getCouleurLigne().getBlue());
      élément.setAttribute("couleur", red+","+green+","+blue);
      élément.setAttribute("remplissage", String.valueOf(vueForme.estRempli()));
    } else {
      throw new Error("Vue non gérée");
    }
    return élément;
  }

  /**
   * Renvoie un nouvel élément DOM représentant le rectangle donné.
   * @param forme le rectangle
   * @return élément DOM représentant le rectangle
   */
  public Element créeElémentRectangle(Rectangle forme) {
    Element élément = getDocument().createElement("rectangle");
    élément.setAttribute("x", String.valueOf(forme.getX()));
    élément.setAttribute("y", String.valueOf(forme.getY()));
    élément.setAttribute("largeur", String.valueOf(forme.getLargeur()));
    élément.setAttribute("hauteur", String.valueOf(forme.getHauteur()));
    return élément;
  }

  /**
   * Renvoie un nouvel élément DOM représentant le carré donné.
   * @param forme le carré
   * @return élément DOM représentant le carré
   */
  public Element créeElémentCarré(Rectangle forme) {
    Element élément = getDocument().createElement("carre");
    élément.setAttribute("x", String.valueOf(forme.getX()));
    élément.setAttribute("y", String.valueOf(forme.getY()));
    élément.setAttribute("largeur", String.valueOf(forme.getLargeur()));
    return élément;
  }

  /**
   * Renvoie un nouvel élément DOM représentant l'ellipse donnée.
   * @param forme l'ellipse
   * @return élément DOM représentant l'ellipse
   */
  public Element créeElémentEllipse(Ellipse forme) {
    Element élément = getDocument().createElement("ellipse");
    élément.setAttribute("x", String.valueOf(forme.getX()));
    élément.setAttribute("y", String.valueOf(forme.getY()));
    élément.setAttribute("largeur", String.valueOf(forme.getLargeur()));
    élément.setAttribute("hauteur", String.valueOf(forme.getHauteur()));
    return élément;
  }

  /**
   * Renvoie un nouvel élément DOM représentant le cercle donné.
   * @param forme le cercle
   * @return élément DOM représentant le cercle
   */
  public Element créeElémentCercle(Cercle forme) {
    Element élément = getDocument().createElement("cercle");
    élément.setAttribute("x", String.valueOf(forme.getX()));
    élément.setAttribute("y", String.valueOf(forme.getY()));
    élément.setAttribute("largeur", String.valueOf(forme.getLargeur()));
    return élément;
  }

  /**
   * Renvoie un nouvel élément DOM représentant la ligne donnée.
   * @param forme la ligne
   * @return élément DOM représentant la ligne
   */
  public Element créeElémentLigne(Ligne forme) {
    Element élément = getDocument().createElement("ligne");
    élément.setAttribute("x", String.valueOf(forme.getX()));
    élément.setAttribute("y", String.valueOf(forme.getY()));
    élément.setAttribute("largeur", String.valueOf(forme.getLargeur()));
    élément.setAttribute("hauteur", String.valueOf(forme.getHauteur()));
    return élément;
  }

  /**
   * Renvoie un nouvel élément DOM représentant le tracé donné.
   * @param forme le tracé
   * @return élément DOM représentant le tracé
   */
  public Element créeElémentTracé(Tracé forme) {
    Element élémentPrincipal = getDocument().createElement("trace");
    élémentPrincipal.setAttribute("x", String.valueOf(forme.getLignes().get(0).getX()));
    élémentPrincipal.setAttribute("y", String.valueOf(forme.getLignes().get(0).getY()));
    élémentPrincipal.setAttribute("hauteur", String.valueOf(forme.getHauteur()));
    élémentPrincipal.setAttribute("largeur", String.valueOf(forme.getLargeur()));
    Element élément;
    for (int i = 1; i < forme.getLignes().size(); i++) {
      élément = getDocument().createElement("point");
      élément.setAttribute("x", String.valueOf(forme.getLignes().get(i).getX()));
      élément.setAttribute("y", String.valueOf(forme.getLignes().get(i).getY()));
      élémentPrincipal.appendChild(élément);
    }
    return élémentPrincipal;
  }

}
