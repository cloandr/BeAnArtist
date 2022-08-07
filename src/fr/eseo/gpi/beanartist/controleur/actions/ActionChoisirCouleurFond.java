package fr.eseo.gpi.beanartist.controleur.actions;

import fr.eseo.gpi.beanartist.vue.ui.FenêtreBeAnArtist;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;

public class ActionChoisirCouleurFond extends AbstractAction {
  
  private static final long serialVersionUID = -827786002649498024L;

  FenêtreBeAnArtist fenêtre;
  
  public static final String NOM_ACTION_COULEUR_FOND = "Fond";
  
  public ActionChoisirCouleurFond(FenêtreBeAnArtist theFenêtre) {
    super(NOM_ACTION_COULEUR_FOND);
    this.fenêtre = theFenêtre;
  }
  
  public void actionPerformed(ActionEvent event) {
    Color couleur = JColorChooser.showDialog(null, "couleur du fond", Color.WHITE);
    this.fenêtre.getPanneauDessin().setCouleurFond(couleur);
  }
}
