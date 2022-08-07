package fr.eseo.gpi.beanartist.controleur.actions;

import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class ActionModeRemplissage extends AbstractAction {
  
  private static final long serialVersionUID = -1969420159839509891L;
  
  public static final String NOM_ACTION_REMPLI = "Remplir";
  public static final String NOM_ACTION_CONTOUR = "Contour";
  
  PanneauDessin panneauSave;

  public ActionModeRemplissage(PanneauDessin panneau) {
    super();
    this.panneauSave = panneau;
  }
  
  public void actionPerformed(ActionEvent event) {
    if (event.getActionCommand() == NOM_ACTION_REMPLI) {
      panneauSave.setModeRemplissage(true);
    }
    
    if (event.getActionCommand() == NOM_ACTION_CONTOUR) {
      panneauSave.setModeRemplissage(false);
    }
  }
}
