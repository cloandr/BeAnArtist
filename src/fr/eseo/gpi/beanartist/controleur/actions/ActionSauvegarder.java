package fr.eseo.gpi.beanartist.controleur.actions;

import fr.eseo.gpi.beanartist.vue.ui.FenêtreBeAnArtist;
import fr.eseo.gpi.beanartist.xml.EnregistreurXML;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ActionSauvegarder extends AbstractAction {

  private static final long serialVersionUID = -4597482454919003186L;
  public static final String NOM_ACTION_EFFACER = "Sauvegarder";
  FenêtreBeAnArtist fenêtreSave;

  /** Constructeur de la classe.*/
  public ActionSauvegarder(FenêtreBeAnArtist fenêtre) {
    super(NOM_ACTION_EFFACER);
    fenêtreSave = fenêtre;
    addPropertyChangeListener(null);
  }
  
  /** Permet l'effacement de toutes les formes présentes dans le PanneauDessin.*/
  public void actionPerformed(ActionEvent event) {
    try {
      this.saveDansUnFichier();
    } catch (FileNotFoundException ev) {
      ev.printStackTrace();
    }
  }
  
  void saveDansUnFichier() throws FileNotFoundException  {
    JFileChooser dialogue = new JFileChooser(new File("."));
    FileNameExtensionFilter filter = new FileNameExtensionFilter("FICHIER XML (*.xml)", "xml");
    dialogue.setFileFilter(filter);
    if (dialogue.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      String pathFichier = dialogue.getSelectedFile().getPath();
      if (!pathFichier.endsWith(".xml")) {
        pathFichier = pathFichier + ".xml";
      }
      EnregistreurXML enregistreurXML = new EnregistreurXML();
      enregistreurXML.enregistreDessin(pathFichier,
          fenêtreSave.getPanneauDessin().getVueFormes());
    }
  }
  
}