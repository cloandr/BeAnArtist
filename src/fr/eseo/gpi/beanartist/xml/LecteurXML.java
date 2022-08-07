package fr.eseo.gpi.beanartist.xml;

import fr.eseo.gpi.beanartist.modele.geom.Carré;
import fr.eseo.gpi.beanartist.modele.geom.Cercle;
import fr.eseo.gpi.beanartist.modele.geom.Ellipse;
import fr.eseo.gpi.beanartist.modele.geom.Ligne;
import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.modele.geom.Rectangle;
import fr.eseo.gpi.beanartist.modele.geom.Tracé;
import fr.eseo.gpi.beanartist.vue.geom.VueCarré;
import fr.eseo.gpi.beanartist.vue.geom.VueCercle;
import fr.eseo.gpi.beanartist.vue.geom.VueEllipse;
import fr.eseo.gpi.beanartist.vue.geom.VueForme;
import fr.eseo.gpi.beanartist.vue.geom.VueLigne;
import fr.eseo.gpi.beanartist.vue.geom.VueRectangle;
import fr.eseo.gpi.beanartist.vue.geom.VueTracé;
import fr.eseo.gpi.beanartist.vue.ui.FenêtreBeAnArtist;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

/**
 * Un lecteur XML est un processeur DOM responsable du chargement d'un dessin au
 * format XML défini par l'application.
 * 
 * Il utilise les méthodes héritées de la classe ProcesseurDOM pour charger le
 * fichier XML dans un document DOM, ainsi que les méthodes de lecture des
 * entiers.
 * 
 * Les méthodes lisDessin et créeXxxx devront être complétées. Des méthodes
 * utilitaires pourront venir compléter celles définies par la classe
 * ProcesseurDOM ; elles devront dans ce cas être OBLIGATOIREMENT définies en
 * "private" à la fin de la classe LecteurXML.
 * 
 */
public class LecteurXML extends ProcesseurDOM {

  /**
   * Lance le test de chargement (méthode teste) avec le fichier XML nommé
   * "S30-Dessin-in.xml".
   * 
   * Vous aurez pris soin de le copier prélablablement dans le ficher
   * "S30-Dessin-in.xml".
   * 
   * Ce test MANUEL doit OBLIGATOIREMENT passer avant de commencer la gestion
   * de l'enregistrement en XML (classe EnregistreurXML).
   */
  public static void main(String[] args) throws FileNotFoundException {
    teste("S30-Dessin-in.xml");
  }

  /**
   * Teste le chargement du fichier XML. Le contenu du fichier est ensuite
   * affiché dans la fenêtre de l'application (classe FenêtreBeAnArtist).
   * @param nomFichier le fichier d'entrée à lire
   * @throws FileNotFoundException si le fichier n'existe pas
   */
  public static void teste(String nomFichier) throws FileNotFoundException {
    LecteurXML lecteur = new LecteurXML();
    final List<VueForme> dessin = lecteur.lisDessin(nomFichier);
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        FenêtreBeAnArtist fenêtre = new FenêtreBeAnArtist();
        for (VueForme vueForme : dessin) {
          System.out.println(vueForme.getForme());
          fenêtre.getPanneauDessin().ajouterVueForme(vueForme);
        }
      }
    });
  }

  /**
   * Charge le fichier XML donné dans un document DOM puis renvoie
   * l'intégralité du dessin sous la forme d'une liste de vues représentant
   * les formes stockées dans le fichier.
   * 
   * @param nomFichier le nom du fichier XML
   * @return l'intégralité du dessin sous la forme d'une liste de vues
   * @throws FileNotFoundException si le fichier n'est pas trouvé ou
   *             accessible
   */
  public List<VueForme> lisDessin(String nomFichier) throws FileNotFoundException {
    List<VueForme> dessin = new ArrayList<>();
    chargeDocument(nomFichier);
    Element racine = getDocument().getDocumentElement();
    NodeList listeNode = racine.getChildNodes();
    for (int index = 0; index < listeNode.getLength(); index++) {
      if (listeNode.item(index).getNodeType() == Node.ELEMENT_NODE) {
        Element element = (Element) listeNode.item(index);
        dessin.add(créeVueForme(element));
      }
    }
    
    return dessin;
  }

  /**
   * Crée une forme et sa vue associée réprésentées par l'élément DOM donné,
   * puis renvoie cette vue. Cette méthode invoque les méthodes crée<Forme>
   * définies pour chacune des <Forme> considérée.
   * @param element l'élément représentant la vue et sa forme
   * @return la vue stockée dans l'élément considéré
   */
  public VueForme créeVueForme(Element element) {
    VueForme vue = new VueRectangle(new Rectangle(0,0,0,0), false);
    String nom = element.getNodeName();
    if (nom.equals("rectangle")) {
      Rectangle forme = créeRectangle(element);
      boolean rempli = Boolean.valueOf(element.getAttribute("remplissage"));
      int[] rgb = lisMotifs(element.getAttribute("couleur"), ",");
      Color couleur = new Color(rgb[0],rgb[1],rgb[2]);
      vue = new VueRectangle(forme, couleur, rempli);
    } else if (nom.equals("carre")) {
      Carré forme = créeCarré(element);
      boolean rempli = Boolean.valueOf(element.getAttribute("remplissage"));
      int[] rgb = lisMotifs(element.getAttribute("couleur"), ",");
      Color couleur = new Color(rgb[0],rgb[1],rgb[2]);
      vue = new VueCarré(forme, couleur, rempli);
    } else if (nom.equals("ellipse")) {
      Ellipse forme = créeEllipse(element);
      boolean rempli = Boolean.valueOf(element.getAttribute("remplissage"));
      int[] rgb = lisMotifs(element.getAttribute("couleur"), ",");
      Color couleur = new Color(rgb[0],rgb[1],rgb[2]);
      vue = new VueEllipse(forme, couleur, rempli);
    } else if (nom.equals("cercle")) {
      Cercle forme = créeCercle(element);
      boolean rempli = Boolean.valueOf(element.getAttribute("remplissage"));
      int[] rgb = lisMotifs(element.getAttribute("couleur"), ",");
      Color couleur = new Color(rgb[0],rgb[1],rgb[2]);
      vue = new VueCercle(forme, couleur, rempli);
    } else if (nom.equals("ligne")) {
      Ligne forme = créeLigne(element);
      int[] rgb = lisMotifs(element.getAttribute("couleur"), ",");
      Color couleur = new Color(rgb[0],rgb[1],rgb[2]);
      vue = new VueLigne(forme, couleur);
    } else if (nom.equals("trace")) {
      Tracé forme = créeTracé(element);
      int[] rgb = lisMotifs(element.getAttribute("couleur"), ",");
      Color couleur = new Color(rgb[0],rgb[1],rgb[2]);
      vue = new VueTracé(forme, couleur);
    }
    System.out.println(nom);
    return vue;
  }

  /**
   * Renvoie un nouveau rectangle représenté par l'élément DOM donné.
   * @param element l'élément représentant le rectangle
   * @return le rectangle stocké dans l'élément considéré
   */
  public Rectangle créeRectangle(Element element) {
    int coordX = lisAttribut(element, "x");
    int coordY = lisAttribut(element, "y");
    int largeur = lisAttribut(element, "largeur");
    int hauteur = lisAttribut(element, "hauteur");
    return new Rectangle(coordX,coordY,largeur,hauteur);
  }

  /**
   * Renvoie un nouveau carré représenté par l'élément DOM donné.
   * @param element l'élément représentant le carré
   * @return le carré stocké dans l'élément considéré
   */
  public Carré créeCarré(Element element) {
    int coordX = lisAttribut(element, "x");
    int coordY = lisAttribut(element, "y");
    int largeur = lisAttribut(element, "largeur");
    return new Carré(coordX,coordY,largeur);
  }

  /**
   * Renvoie une nouvelle ellipse représentée par l'élément DOM donné.
   * @param element l'élément représentant l'ellipse
   * @return l'ellipse stockée dans l'élément considéré
   */
  public Ellipse créeEllipse(Element element) {
    int coordX = lisAttribut(element, "x");
    int coordY = lisAttribut(element, "y");
    int largeur = lisAttribut(element, "largeur");
    int hauteur = lisAttribut(element, "hauteur");
    return new Ellipse(coordX,coordY,largeur,hauteur);
  }

  /**
   * Renvoie un nouveau cercle représenté par l'élément DOM donné.
   * @param element l'élément représentant le cercle
   * @return le cercle stocké dans l'élément considéré
   */
  public Cercle créeCercle(Element element) {
    int coordX = lisAttribut(element, "x");
    int coordY = lisAttribut(element, "y");
    int largeur = lisAttribut(element, "largeur");
    return new Cercle(coordX,coordY,largeur);
  }

  /**
   * Renvoie la nouvelle ligne représentée par l'élément DOM donné.
   * @param element l'élément représentant la ligne
   * @return la ligne stockée dans l'élément considéré
   */
  public Ligne créeLigne(Element element) {
    int coordX = lisAttribut(element, "x");
    int coordY = lisAttribut(element, "y");
    int largeur = lisAttribut(element, "largeur");
    int hauteur = lisAttribut(element, "hauteur");
    return new Ligne(coordX,coordY,largeur,hauteur);
  }

  /**
   * Renvoie un nouveau tracé représenté par l'élément DOM donné.
   * @param element l'élément représentant le tracé
   * @return le tracé stocké dans l'élément considéré
   */
  public Tracé créeTracé(Element element) {
    int coordX = lisAttribut(element, "x");
    int coordY = lisAttribut(element, "y");
    NodeList listeNode = element.getChildNodes();
    Tracé trace = new Tracé(new Point(coordX, coordY), new Point(coordX, coordY));
    for (int index = 0; index < listeNode.getLength(); index++) {
      if (listeNode.item(index).getNodeType() == Node.ELEMENT_NODE) {
        Element pointSuivant = (Element) listeNode.item(index);
        coordX = lisAttribut(pointSuivant, "x");
        coordY = lisAttribut(pointSuivant, "y");
        trace.ajouterLigneVers(new Point(coordX, coordY));
      }
    }
    return trace;
  }

}
