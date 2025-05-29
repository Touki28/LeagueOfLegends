package src.ihm;

import src.Controleur;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class FramePrc extends JFrame
{
	private static final int LONGUEUR = 1000;
	private static final int HAUTEUR  = 800;
	
	private Controleur  ctrl;

	private PanelJeu    panelJeu;
	private PanelChat   panelChat;
	private PanelOption panelOption;
	
	public FramePrc( Controleur ctrl )
	{
		JPanel panelTmp;
		
		this.ctrl = ctrl;
		
		this.setTitle( "League Of Legends" );
		this.setSize( FramePrc.LONGUEUR, FramePrc.HAUTEUR );
		this.setLocation( 25, 25 );

		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		this.panelJeu    = new PanelJeu   ( ctrl );
		this.panelChat   = new PanelChat  ( ctrl );
		this.panelOption = new PanelOption( ctrl );

		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/
		panelTmp = new JPanel( new GridLayout( 2, 1 ) );

		panelTmp.add( this.panelOption );
		panelTmp.add( this.panelChat   );

		this.add(      panelTmp, BorderLayout.EAST   );
		this.add( this.panelJeu, BorderLayout.CENTER );


		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible( true );
	}

	public static int getLongueur() { return FramePrc.LONGUEUR; }
	public static int getHauteur () { return FramePrc.HAUTEUR ; }

}
