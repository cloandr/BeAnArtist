package fr.eseo.gpi.beanartist.controleur.actions;

import fr.eseo.gpi.beanartist.controleur.outils.OutilSélection;
import fr.eseo.gpi.beanartist.vue.ui.FenêtreBeAnArtist;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;



public class ActionSélectionner extends AbstractAction {

  private static final long serialVersionUID = 948712831953756052L;
  
  public static final String NOM_ACTION_SELECTIONNER = "Sélectionner";
  FenêtreBeAnArtist fenêtreSave;

  public ActionSélectionner(FenêtreBeAnArtist fenêtre) {
    super(NOM_ACTION_SELECTIONNER);
    fenêtreSave = fenêtre;
  }
  
  public void actionPerformed(ActionEvent event) {
    OutilSélection monOutil = new OutilSélection(fenêtreSave.getPanneauDessin());
    monOutil.associer(fenêtreSave.getPanneauDessin());
    fenêtreSave.getPanneauDessin().setOutilCourant(monOutil);
  }

}
