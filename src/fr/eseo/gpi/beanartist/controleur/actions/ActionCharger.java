package fr.eseo.gpi.beanartist.controleur.actions;

import fr.eseo.gpi.beanartist.vue.geom.VueForme;
import fr.eseo.gpi.beanartist.vue.ui.FenêtreBeAnArtist;
import fr.eseo.gpi.beanartist.xml.LecteurXML;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ActionCharger extends AbstractAction {

  private static final long serialVersionUID = -4597482454919003186L;
  public static final String NOM_ACTION_EFFACER = "Charger";
  FenêtreBeAnArtist fenêtreSave;

  /** Constructeur de la classe.*/
  public ActionCharger(FenêtreBeAnArtist fenêtre) {
    super(NOM_ACTION_EFFACER);
    fenêtreSave = fenêtre;
    addPropertyChangeListener(null);
  }
  
  /** Permet l'effacement de toutes les formes présentes dans le PanneauDessin.*/
  public void actionPerformed(ActionEvent event) {
    try {
      this.loadDansUnFichier();
    } catch (FileNotFoundException ev) {
      ev.printStackTrace();
    }
  }
  
  void loadDansUnFichier() throws FileNotFoundException  {
    LecteurXML lecteurXML = new LecteurXML();
    JFileChooser dialogue = new JFileChooser(new File("."));
    FileNameExtensionFilter filter = new FileNameExtensionFilter("FICHIER XML (*.xml)", "xml");
    dialogue.setFileFilter(filter);
    if (dialogue.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      fenêtreSave.getPanneauDessin().getVueFormes().clear();
      fenêtreSave.repaint();
      String pathFichier = dialogue.getSelectedFile().getPath();
      List<VueForme> dessin = lecteurXML.lisDessin(pathFichier);
      for (VueForme vueForme : dessin) {
        System.out.println(vueForme.getForme());
        fenêtreSave.getPanneauDessin().ajouterVueForme(vueForme);
      }
    }
  }
  
}