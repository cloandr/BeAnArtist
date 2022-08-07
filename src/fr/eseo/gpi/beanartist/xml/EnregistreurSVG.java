package fr.eseo.gpi.beanartist.xml;

import fr.eseo.gpi.beanartist.modele.geom.Cercle;
import fr.eseo.gpi.beanartist.modele.geom.Ellipse;
import fr.eseo.gpi.beanartist.modele.geom.Ligne;
import fr.eseo.gpi.beanartist.modele.geom.Rectangle;
import fr.eseo.gpi.beanartist.modele.geom.Tracé;
import fr.eseo.gpi.beanartist.vue.geom.VueForme;

import org.w3c.dom.Element;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Un enregistreur SVG est un processeur DOM responsable de l'enregistrement
 * d'un dessin au format SVG standard.
 * 
 * Il suit exactement les mêmes principes que ceux de l'enregistreur XML (classe
 * EnregistreurXML). Les méthodes enregistreDessin et créeElémentXxxx devront
 * être complétées. Des méthodes utilitaires pourront venir compléter celles
 * définies par la classe ProcesseurDOM ; elles devront dans ce cas être
 * OBLIGATOIREMENT définies en "private" à la fin de la classe EnregistreurXML.
 *
 */
public class EnregistreurSVG extends ProcesseurDOM {

  /**
   * Lance le test d'enristrement (méthode teste) avec le fichier XML d'entrée
   * nommé "S30-Dessin-in.xml" et le fichier SVG de sortie nommé
   * "S30-Dessin-out.svg".
   * 
   * Vérifier la conformité du fichier de sortie en l'affichant avec un
   * navigateur Web et en comparant cet affichage avec celui fourni par la
   * méthode LecteurXML.main.
   * 
   */
  public static void main(String[] args) throws FileNotFoundException {
    teste("S30-Dessin-out.xml", "S30-Dessin-out.svg");
  }

  /**
   * Teste l'enregistrement du dessin dans un fichier SVG. Le fichier XML
   * d'entrée est préalablement lu, puis sauvagardé dans un fichier de sortie
   * au format SVG.
   * 
   * @param nomFichierEntrée le nom du fichier XML d'entrée lu
   * @param nomFichierSortie le nom du fichier SVG de sortie écrit
   * @throws FileNotFoundException si l'un des noms des fichiers n'est pas
   *             valide
   */
  public static void teste(String nomFichierEntrée, String nomFichierSortie) throws FileNotFoundException {
    LecteurXML lecteur = new LecteurXML();
    final List<VueForme> dessin = lecteur.lisDessin(nomFichierEntrée);
    EnregistreurSVG enregistreur = new EnregistreurSVG();
    enregistreur.enregistreDessin(nomFichierSortie, dessin);
  }

  /**
   * Enregistre le dessin donné dans un fichier SVG.
   * @param nomFichier le nom du fichier SVG de sauvegarde
   * @param dessin le dessin formé de la liste des vues des formes
   * @throws FileNotFoundException si le nom du fichier n'est pas valide
   */
  public void enregistreDessin(String nomFichier, List<VueForme> dessin) throws FileNotFoundException {
    créeDocumentSVG();
    Element racine = getDocument().getDocumentElement();
    for (int i = 0; i < dessin.size(); i++) {
      racine.appendChild(this.créeElémentVueForme(dessin.get(i)));
    }
    enregistreDocument(nomFichier);
  }

  /**
   * Crée un élément DOM au format SVG représentant la vue donnée d'une forme
   * et retourne cet élément. Cette méthode invoque les méthodes
   * créeElément<Forme> en fonction du type de la vue.
   * @param vueForme la vue d'une forme
   * @return l'élément DOM représentant la vue d'une forme
   */
  public Element créeElémentVueForme(VueForme vueForme) {
    Element élément;
    String red;
    String green;
    String blue;
    String nom = vueForme.getClass().getSimpleName();
    if (nom.equals("VueRectangle") || nom.equals("VueCarré")) {
      Rectangle forme = (Rectangle) vueForme.getForme();
      élément = créeElémentRectangle(forme);
      red = String.valueOf(vueForme.getCouleurLigne().getRed());
      green = String.valueOf(vueForme.getCouleurLigne().getGreen());
      blue = String.valueOf(vueForme.getCouleurLigne().getBlue());
      if (vueForme.estRempli()) {
        élément.setAttribute("fill", "rgb(" + red + "," + green + "," + blue + ")");
      } else {
        élément.setAttribute("style", "stroke:" + "rgb(" + red + "," + green+"," + blue + ")" + ";stroke-width:1");
        élément.setAttribute("fill", "none");
      }
    } else if (nom.equals("VueEllipse")) {
      Ellipse forme = (Ellipse) vueForme.getForme();
      élément = créeElémentEllipse(forme);
      red = String.valueOf(vueForme.getCouleurLigne().getRed());
      green = String.valueOf(vueForme.getCouleurLigne().getGreen());
      blue = String.valueOf(vueForme.getCouleurLigne().getBlue());
      if (vueForme.estRempli()) {
        élément.setAttribute("fill", "rgb(" + red + "," + green + "," + blue + ")");
      } else {
        élément.setAttribute("style", "stroke:" + "rgb(" + red + "," + green+"," + blue + ")" + ";stroke-width:1");
        élément.setAttribute("fill", "none");
      }
    } else if (nom.equals("VueCercle")) {
      Cercle forme = (Cercle) vueForme.getForme();
      élément = créeElémentCercle(forme);
      red = String.valueOf(vueForme.getCouleurLigne().getRed());
      green = String.valueOf(vueForme.getCouleurLigne().getGreen());
      blue = String.valueOf(vueForme.getCouleurLigne().getBlue());
      if (vueForme.estRempli()) {
        élément.setAttribute("fill", "rgb(" + red + "," + green + "," + blue + ")");
      } else {
        élément.setAttribute("style", "stroke:" + "rgb(" + red + "," + green+"," + blue + ")" + ";stroke-width:1");
        élément.setAttribute("fill", "none");
      }
    } else if (nom.equals("VueLigne")) {
      Ligne forme = (Ligne) vueForme.getForme();
      élément = créeElémentLigne(forme);
      red = String.valueOf(vueForme.getCouleurLigne().getRed());
      green = String.valueOf(vueForme.getCouleurLigne().getGreen());
      blue = String.valueOf(vueForme.getCouleurLigne().getBlue());
      élément.setAttribute("style", "stroke:" + "rgb(" + red + "," + green+"," + blue + ")" + ";stroke-width:1");
      élément.setAttribute("fill", "none");
    } else if (nom.equals("VueTracé")) {
      Tracé forme = (Tracé) vueForme.getForme();
      élément = créeElémentTracé(forme);
      red = String.valueOf(vueForme.getCouleurLigne().getRed());
      green = String.valueOf(vueForme.getCouleurLigne().getGreen());
      blue = String.valueOf(vueForme.getCouleurLigne().getBlue());
      élément.setAttribute("style", "stroke:" + "rgb(" + red + "," + green+"," + blue + ")" + ";stroke-width:1");
      élément.setAttribute("fill", "none");
    } else {
      throw new Error("Vue non gérée");
    }
    getDocument().getDocumentElement().appendChild(élément);
    return élément;
  }

  /**
   * Renvoie un nouvel élément DOM au format SVG représentant le rectangle
   * donné.
   * @param forme le rectangle
   * @return élément DOM représentant le rectangle
   */
  public Element créeElémentRectangle(Rectangle forme) {
    Element élément = getDocument().createElement("rect");
    élément.setAttribute("x", String.valueOf(forme.getX()));
    élément.setAttribute("y", String.valueOf(forme.getY()));
    élément.setAttribute("width", String.valueOf(forme.getLargeur()));
    élément.setAttribute("height", String.valueOf(forme.getHauteur()));
    return élément;
  }

  /**
   * Renvoie un nouvel élément DOM au format SVG représentant l'ellipse
   * donnée.
   * @param forme l'ellipse
   * @return élément DOM représentant l'ellipse
   */
  public Element créeElémentEllipse(Ellipse forme) {
    Element élément = getDocument().createElement("ellipse");
    int cx = forme.getX() + forme.getLargeur() / 2;
    int cy = forme.getY() + forme.getHauteur() / 2;
    int rx = forme.getLargeur() / 2;
    int ry = forme.getHauteur() / 2;
    élément.setAttribute("cx", String.valueOf(cx));
    élément.setAttribute("cy", String.valueOf(cy));
    élément.setAttribute("rx", String.valueOf(rx));
    élément.setAttribute("ry", String.valueOf(ry));
    return élément;
  }

  /**
   * Renvoie un nouvel élément DOM au format SVG représentant le cercle donné.
   * @param forme le cercle
   * @return élément DOM représentant le cercle
   */
  public Element créeElémentCercle(Cercle forme) {
    Element élément = getDocument().createElement("circle");
    int cx = forme.getX() + forme.getLargeur() / 2;
    int cy = forme.getY() + forme.getHauteur() / 2;
    int rayon = forme.getLargeur() / 2;
    élément.setAttribute("cx", String.valueOf(cx));
    élément.setAttribute("cy", String.valueOf(cy));
    élément.setAttribute("r", String.valueOf(rayon));
    return élément;
  }

  /**
   * Renvoie un nouvel élément DOM au format SVG représentant la ligne donnée.
   * @param forme la ligne
   * @return élément DOM représentant la ligne
   */
  public Element créeElémentLigne(Ligne forme) {
    Element élément = getDocument().createElement("line");
    int x1 = forme.getP1().getX();
    int y1 = forme.getP1().getY();
    int x2 = forme.getP2().getX();
    int y2 = forme.getP2().getY();
    élément.setAttribute("x1", String.valueOf(x1));
    élément.setAttribute("y1", String.valueOf(y1));
    élément.setAttribute("x2", String.valueOf(x2));
    élément.setAttribute("y2", String.valueOf(y2));
    return élément;
  }

  /**
   * Renvoie un nouvel élément DOM au format SVG représentant le tracé donné.
   * @param forme le tracé
   * @return élément DOM représentant le tracé
   */
  public Element créeElémentTracé(Tracé forme) {
    Element élément = getDocument().createElement("polyline");
    String points = "";
    for (int i = 0; i < forme.getLignes().size(); i++) {
      points = points + String.valueOf(forme.getLignes().get(i).getX()) + "," + String.valueOf(forme.getLignes().get(i).getY()) + " ";
    }
    élément.setAttribute("points", points);
    return élément;
  }

}
