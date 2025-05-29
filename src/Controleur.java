package src;

import src.ihm.FramePrc;
import src.metier.Plateau;

import java.io.File;

public class Controleur
{
	private FramePrc ihm;

	private Plateau  metier;

	public Controleur()
	{
		this.metier = new Plateau ( this );
		this.ihm    = new FramePrc( this );
	}

	public static String[] getMap     () { return new File( "./../images/map" ).list(); }
	public static int      getLongueur() { return FramePrc.getLongueur()              ; }
	public static int      getHauteur () { return FramePrc.getHauteur ()              ; }

	public char[][] getPlateau() { return this.metier.getPlateau(); }

	public boolean deplacer( char dir ) { return this.metier.deplacer( dir ); }
	public static void main(String[] args) { new Controleur(); }
}