package fr.eseo.gpi.beanartist.vue.ui;

import fr.eseo.gpi.beanartist.controleur.actions.ActionChoisirCouleur;
import fr.eseo.gpi.beanartist.controleur.actions.ActionChoisirCouleurFond;
import fr.eseo.gpi.beanartist.controleur.actions.ActionEffacer;
import fr.eseo.gpi.beanartist.controleur.actions.ActionForme;
import fr.eseo.gpi.beanartist.controleur.actions.ActionModeRemplissage;
import fr.eseo.gpi.beanartist.controleur.actions.ActionSélectionner;
import fr.eseo.gpi.beanartist.controleur.actions.ActionCharger;
import fr.eseo.gpi.beanartist.controleur.actions.ActionSauvegarder;
import fr.eseo.gpi.beanartist.controleur.actions.ActionExporter;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanneauBarreOutil extends JPanel {
  
  private static final long serialVersionUID = 1131669615618482517L;
  
  private FenêtreBeAnArtist fenêtreBeAnArtist;
  
  public PanneauBarreOutil(FenêtreBeAnArtist fenêtre) {
    super();
    this.fenêtreBeAnArtist = fenêtre;
    this.setPreferredSize(new Dimension(220, this.fenêtreBeAnArtist.getHeight()));
    this.setLayout(new FlowLayout(FlowLayout.CENTER));
    this.fenêtreBeAnArtist.getContentPane().add(this, BorderLayout.EAST);
    this.fenêtreBeAnArtist.pack();
    initComponents();
  }
  
  public FenêtreBeAnArtist getFenêtreBeAnArtist() {
    return this.fenêtreBeAnArtist;
  }
  
  
  /** Initialise les composantes de la barre d'outil.*/
  private void initComponents() {
    
    /* Panneau Action */
    JPanel pAction = new JPanel();
    pAction.setBorder(BorderFactory.createTitledBorder("Action"));
    pAction.setPreferredSize(new Dimension(125, 175));
    JButton boutonEffacer = new JButton(new ActionEffacer(this.fenêtreBeAnArtist));
    JButton boutonSelect = new JButton(new ActionSélectionner(this.fenêtreBeAnArtist));
    JButton boutonCharger = new JButton(new ActionCharger(this.fenêtreBeAnArtist));
    JButton boutonSauvegarder = new JButton(new ActionSauvegarder(this.fenêtreBeAnArtist));
    JButton boutonExporter = new JButton(new ActionExporter(this.fenêtreBeAnArtist));
    boutonCharger.setPreferredSize(new Dimension(110, 25));
    boutonSauvegarder.setPreferredSize(new Dimension(110, 25));
    boutonExporter.setPreferredSize(new Dimension(110, 25));
    boutonEffacer.setPreferredSize(new Dimension(110, 25));
    boutonSelect.setPreferredSize(new Dimension(110, 25));
    pAction.add(boutonEffacer); 
    pAction.add(boutonSelect);
    pAction.add(boutonCharger); 
    pAction.add(boutonSauvegarder);
    pAction.add(boutonExporter);
    pAction.setLayout(new FlowLayout(FlowLayout.CENTER));
    this.add(pAction);
    
    setFormeJpanel();
    
    /* Panneau Fond */
    JPanel pFond = new JPanel();
    pFond.setBorder(BorderFactory.createTitledBorder("Fond"));
    pFond.setLayout(new FlowLayout(FlowLayout.CENTER));
    
    ButtonGroup groupeRemplir = new ButtonGroup();
    
    JRadioButton boutonRemplir = new JRadioButton(new ActionModeRemplissage(
        this.fenêtreBeAnArtist.getPanneauDessin()));
    boutonRemplir.setActionCommand("Remplir");
    boutonRemplir.setText("Oui");
    groupeRemplir.add(boutonRemplir);
    pFond.add(boutonRemplir);
    
    JRadioButton boutonContour = new JRadioButton(new ActionModeRemplissage(
        this.fenêtreBeAnArtist.getPanneauDessin()));
    boutonContour.setActionCommand("Contour");
    boutonContour.setText("Non");
    boutonContour.setSelected(true);
    groupeRemplir.add(boutonContour);
    pFond.add(boutonContour);
    
    this.add(pFond);
    
    /* Panneau Couleur */
    JPanel pCouleur = new JPanel();
    pCouleur.setBorder(BorderFactory.createTitledBorder("Couleur"));
    pCouleur.setLayout(new FlowLayout(FlowLayout.CENTER));
    pCouleur.add(new JButton(new ActionChoisirCouleur(this.fenêtreBeAnArtist.getPanneauDessin())));
    JButton boutonFond = new JButton(new ActionChoisirCouleurFond(this.fenêtreBeAnArtist));
    pCouleur.add(boutonFond);
    
    this.add(pCouleur);

  }
  
  private void setFormeJpanel(){
    /* Panneau Forme */
    JPanel pForme = new JPanel();
    pForme.setPreferredSize(new Dimension(210, 115));
    pForme.setBorder(BorderFactory.createTitledBorder("Forme"));
    pForme.setLayout(new FlowLayout(FlowLayout.CENTER));
    
    JButton boutonLigne = new JButton(new ActionForme(this.fenêtreBeAnArtist));
    boutonLigne.setActionCommand("Tracer Ligne");
    boutonLigne.setText("Ligne");
    boutonLigne.setPreferredSize(new Dimension(95, 25));
    pForme.add(boutonLigne);
    
    JButton boutonRectangle = new JButton(new ActionForme(this.fenêtreBeAnArtist));
    boutonRectangle.setActionCommand("Tracer Rectangle");
    boutonRectangle.setText("Rectangle");
    boutonRectangle.setPreferredSize(new Dimension(95, 25));
    boutonRectangle.setPreferredSize(new Dimension(95, 25));
    pForme.add(boutonRectangle);
    
    JButton boutonCarré = new JButton(new ActionForme(this.fenêtreBeAnArtist));
    boutonCarré.setActionCommand("Tracer Carré");
    boutonCarré.setText("Carré");
    boutonCarré.setPreferredSize(new Dimension(95, 25));
    pForme.add(boutonCarré);
    
    JButton boutonCercle = new JButton(new ActionForme(this.fenêtreBeAnArtist));
    boutonCercle.setActionCommand("Tracer Cercle");
    boutonCercle.setText("Cercle");
    boutonCercle.setPreferredSize(new Dimension(95, 25));
    pForme.add(boutonCercle);
    
    JButton boutonEllipse = new JButton(new ActionForme(this.fenêtreBeAnArtist));
    boutonEllipse.setActionCommand("Tracer Ellipse");
    boutonEllipse.setText("Ellipse");
    boutonEllipse.setPreferredSize(new Dimension(95, 25));
    pForme.add(boutonEllipse);
    
    JButton boutonLibre = new JButton(new ActionForme(this.fenêtreBeAnArtist));
    boutonLibre.setActionCommand("Tracer Libre");
    boutonLibre.setText("Liberté");
    boutonLibre.setPreferredSize(new Dimension(95, 25));
    pForme.add(boutonLibre);
    
    this.add(pForme);
  }
}
