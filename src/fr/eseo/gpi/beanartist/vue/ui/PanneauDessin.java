package fr.eseo.gpi.beanartist.vue.ui;

import fr.eseo.gpi.beanartist.controleur.outils.Outil;
import fr.eseo.gpi.beanartist.vue.geom.VueForme; 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class PanneauDessin extends JPanel {
  
  private static final long serialVersionUID = 5036799555546689548L;
  
  public static final int LARGEUR_PAR_DÉFAUT = 900;
  public static final int HAUTEUR_PAR_DÉFAUT = 900;
  public static final Color COULEUR_FOND_PAR_DÉFAUT = Color.WHITE;
  public static final Color COULEUR_LIGNE_PAR_DÉFAUT = Color.BLACK;
  
  private List<VueForme> vueFormes = new ArrayList<VueForme>();
  
  private Outil outilCourant;
  
  private VueForme vueFormeCourante;
  private VueForme selectionVueForme;
  
  private boolean modeRemplissage = false;
  
  private Color couleurLigne = COULEUR_LIGNE_PAR_DÉFAUT;
  private Color couleurFond = COULEUR_LIGNE_PAR_DÉFAUT;
  
  private FenêtreBeAnArtist fenêtre;
  
  public PanneauDessin(int largeurZone, int hauteurZone) {
    this(largeurZone, hauteurZone, COULEUR_FOND_PAR_DÉFAUT);
  }
  
  public PanneauDessin(int largeurZone, int hauteurZone, Color newCouleurFond) {
    couleurFond = newCouleurFond;
    setBackground(couleurFond);
    setSize(largeurZone, hauteurZone);
  }
  
  public void setFenêtre(FenêtreBeAnArtist fen) {
    this.fenêtre = fen;
  }
  
  public void ajouterVueForme(VueForme vueForme) {
    vueFormes.add(vueForme);
    repaint();
  }
  
  public void supprimerVueForme(VueForme vueForme) {
    vueFormes.remove(vueForme);
    repaint();
  }
  
  public List<VueForme> getVueFormes() {
    return vueFormes;
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D)g.create();
    for (int i = 0; i < vueFormes.size(); i++) {
      vueFormes.get(i).affiche(g2d);
    }
    if (selectionVueForme != null) {
      selectionVueForme.affiche(g2d);
    }
    g2d.dispose();
  }
  
  public Outil getOutilCourant() {
    return this.outilCourant;
  }
  
  public void setOutilCourant(Outil newOutil) {
    this.outilCourant = newOutil;
  }
  
  public VueForme getVueFormeCourante() {
    return this.vueFormeCourante;
  }
  
  public void setVueFormeCourante(VueForme newVueForme) {
    this.vueFormeCourante = newVueForme;
  }
  
  public VueForme getSelectionVueForme() {
    return this.selectionVueForme;
  }
  
  public void setSelectionVueForme(VueForme newVueForme) {
    this.selectionVueForme = newVueForme;
  }
  
  public boolean getModeRemplissage() {
    return this.modeRemplissage;
  }
  
  public boolean estModeRemplissage() {
    return this.modeRemplissage;
  }
  
  public void setModeRemplissage(boolean newModeremplissage) {
    this.modeRemplissage = newModeremplissage;
  }
  
  public Color getCouleurLigne() {
    return this.couleurLigne;
  }
  
  public void setCouleurLigne(Color newCouleurLigne) {
    this.couleurLigne = newCouleurLigne;
  }
  
  public Color getCouleurFond() {
    return this.couleurFond;
  }
  
  public void setCouleurFond(Color newCouleurFond) {
    this.couleurFond = newCouleurFond;
    this.setBackground(couleurFond);
  }
  
}
