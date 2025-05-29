package src.ihm;

import java.awt.BorderLayout;

import javax.swing.*;

import src.Controleur;

public class PanelOption extends JPanel
{
	private Controleur ctrl;

	private JComboBox  ddlstMap;

	public PanelOption( Controleur ctrl )
	{
		String[] tabMap = Controleur.getMap();
		for ( int cpt = 0; cpt < tabMap.length; cpt++ )
			tabMap[cpt] = tabMap[cpt].substring( 0 , tabMap[cpt].length()-4 );

		
		JPanel panelTheme, panelStats;

		this.setLayout( new BorderLayout() );
		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		panelTheme = new JPanel();
		panelStats = new JPanel();

		this.ddlstMap = new JComboBox<>( tabMap );

		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/
		panelTheme.add( this.ddlstMap );

		this.add( panelTheme, BorderLayout.NORTH );
		this.add( panelStats, BorderLayout.SOUTH );

		/*-------------------------------*/
		/* Activation des composants     */
		/*-------------------------------*/

	}
}
