package src.ihm;

import java.awt.BorderLayout;

import javax.swing.*;

import src.Controleur;

public class PanelChat extends JPanel
{
	private Controleur ctrl;

	private JTextArea  txtArlog;
	private JTextField txtChat;

	public PanelChat ( Controleur ctrl )
	{
		this.setLayout( new BorderLayout() );

		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		this.txtArlog = new JTextArea( 20, 50 );
		this.txtChat  = new JTextField( 50 );

		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/
		this.add( txtArlog, BorderLayout.CENTER );
		this.add( txtChat , BorderLayout.SOUTH  );


		/*-------------------------------*/
		/* Activation des composants     */
		/*-------------------------------*/

	}
}
