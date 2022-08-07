package fr.eseo.gpi.beanartist.controleur.actions;

import fr.eseo.gpi.beanartist.vue.ui.FenêtreBeAnArtist;
import fr.eseo.gpi.beanartist.xml.EnregistreurSVG;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ActionExporter extends AbstractAction {

  private static final long serialVersionUID = -4597482454919003186L;
  public static final String NOM_ACTION_EFFACER = "Exporter";
  FenêtreBeAnArtist fenêtreSave;

  /** Constructeur de la classe.*/
  public ActionExporter(FenêtreBeAnArtist fenêtre) {
    super(NOM_ACTION_EFFACER);
    fenêtreSave = fenêtre;
    addPropertyChangeListener(null);
  }
  
  public void actionPerformed(ActionEvent event) {
    try {
      this.saveDansUnFichier();
    } catch (FileNotFoundException ev) {
      ev.printStackTrace();
    }
  }
  
  void saveDansUnFichier() throws FileNotFoundException  {
    JFileChooser dialogue = new JFileChooser(new File("./export.svg"));
    FileNameExtensionFilter filter = new FileNameExtensionFilter("FICHIER SVG (*.svg)", "svg");
    dialogue.setFileFilter(filter);
    if (dialogue.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      String pathFichier = dialogue.getSelectedFile().getPath();
      if (!pathFichier.endsWith(".svg")) {
        pathFichier = pathFichier + ".svg";
      }
      EnregistreurSVG enregistreurSVG = new EnregistreurSVG();
      enregistreurSVG.enregistreDessin(pathFichier,
          fenêtreSave.getPanneauDessin().getVueFormes());
    }
  }
  
}