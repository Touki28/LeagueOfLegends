package src.ihm;

import src.Controleur;

import javax.swing.*;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.*;

public class PanelJeu extends JPanel implements KeyListener
{
	private Controleur ctrl;

	private Image      backgroundImage;
	
	private JLabel[][] tabLbl;
	private JLabel     lblJ1;
	private JLabel     lblJ2;


	public PanelJeu ( Controleur ctrl ) 
	{
		this.ctrl = ctrl;
		
		this.setLayout( new GridLayout( this.ctrl.getPlateau().length, this.ctrl.getPlateau()[0].length ) );

		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/
		this.backgroundImage = new ImageIcon( "./../images/map/" + Controleur.getMap()[0] ).getImage();
		this.lblJ1 = new JLabel( new ImageIcon("./../images/perso/mage1.png") );
		this.lblJ2 = new JLabel( new ImageIcon("./../images/perso/mage2.png") );

		this.tabLbl = new JLabel[this.ctrl.getPlateau().length][this.ctrl.getPlateau()[0].length];
		for ( int cptLig = 0; cptLig < this.tabLbl.length; cptLig++ )
			for ( int cptCol = 0; cptCol < this.tabLbl[cptLig].length; cptCol++ )
					this.tabLbl[cptLig][cptCol] = new JLabel();
		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/
		for ( int cptLig = 0; cptLig < this.tabLbl.length; cptLig++ )
			for ( int cptCol = 0; cptCol < this.tabLbl[cptLig].length; cptCol++ )
			{
				if ( this.ctrl.getPlateau()[cptLig][cptCol] == '1' )
					this.tabLbl[cptLig][cptCol] = this.lblJ1;

				if ( this.ctrl.getPlateau()[cptLig][cptCol] == '2' )
					this.tabLbl[cptLig][cptCol] = this.lblJ2;
			}
		
		
		for ( int cptLig = 0; cptLig < this.tabLbl.length; cptLig++ )
			for ( int cptCol = 0; cptCol < this.tabLbl[cptLig].length; cptCol++ )
				this.add( this.tabLbl[cptLig][cptCol] );
		

		/*-------------------------------*/
		/* Activation des composants     */
		/*-------------------------------*/
		this.addKeyListener(this);
		this.setFocusable(true);
	}

	public void keyPressed(KeyEvent e)
	{
		switch ( e.getKeyCode() )
		{
			case KeyEvent.VK_Z -> this.ctrl.deplacer( 'N' );
			case KeyEvent.VK_Q -> this.ctrl.deplacer( 'O' );
			case KeyEvent.VK_S -> this.ctrl.deplacer( 'S' );
			case KeyEvent.VK_D -> this.ctrl.deplacer( 'E' );
		}

		this.majImh();
	}
	public void keyReleased( KeyEvent e ){}
	public void keyTyped   ( KeyEvent e ){}

	public void majImh()
	{
		// 1. Vider toutes les cases (remettre un JLabel vide)
		for (int lig = 0; lig < this.tabLbl.length; lig++)
			for (int col = 0; col < this.tabLbl[lig].length; col++)
				this.tabLbl[lig][col] = new JLabel();

		// 2. Remettre les joueurs à leurs nouvelles positions
		for (int lig = 0; lig < this.ctrl.getPlateau().length; lig++)
		{
			for (int col = 0; col < this.ctrl.getPlateau()[0].length; col++)
			{
				char caseVal = this.ctrl.getPlateau()[lig][col];
				if (caseVal == '1')
					this.tabLbl[lig][col] = this.lblJ1;
				else if (caseVal == '2')
					this.tabLbl[lig][col] = this.lblJ2;
			}
		}

		// 3. Supprimer tous les composants visuels et les re-ajouter
		this.removeAll();
		for (int lig = 0; lig < this.tabLbl.length; lig++)
			for (int col = 0; col < this.tabLbl[lig].length; col++)
				this.add(this.tabLbl[lig][col]);

		// 4. Rafraîchir le panneau
		this.revalidate();
		this.repaint();
	}


	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(this.backgroundImage, 0, 0, getWidth(), getHeight(), this);
	}
}
