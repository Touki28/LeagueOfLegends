package src.metier;

import src.Controleur;

public class Plateau
{
	private Controleur ctrl;
	
	private char[][]   plateau;

	private Joueur     j1;
	private Joueur     j2;

	public Plateau( Controleur ctrl )
	{
		this.ctrl = ctrl;

		this.plateau = new char[13][9];
		for ( int cptLig = 0; cptLig < this.plateau.length; cptLig++ )
			for ( int cptCol = 0; cptCol < this.plateau[cptLig].length; cptCol++ )
			{
				if ( cptCol > 1 && cptCol < this.plateau[cptLig].length - 2 )
					this.plateau[cptLig][cptCol] = ' ';
				else
					this.plateau[cptLig][cptCol] = '=';
			}

		this.j1 = new Joueur( 12, 4 );
		this.j2 = new Joueur(  0, 4 );

		this.plateau[ this.j1.getX() ][ this.j1.getY() ] = '1';
		this.plateau[ this.j2.getX() ][ this.j2.getY() ] = '2';

	}

	public boolean deplacer( char dir )
	{
		if ( ! this.deplacementPossible( dir ) ) return false;

		this.plateau[ this.j1.getX() ][ this.j1.getY() ] = ' ';
		
		switch ( dir )
		{
			case 'N' ->{ this.j1.addX( -1 ); }
			case 'O' ->{ this.j1.addY( -1 ); }
			case 'S' ->{ this.j1.addX(  1 ); }
			case 'E' ->{ this.j1.addY(  1 ); }
		}

		this.plateau[ this.j1.getX() ][ this.j1.getY() ] = '1';

		return true;
	}

	public boolean deplacementPossible( char dir )
	{
		switch ( dir )
		{
			case 'N' ->{if ( this.j1.getX()-1 < 0                       ||
				             this.plateau[this.j1.getX()-1][this.j1.getY()] != ' ' ) return false;}
			case 'O' ->{if ( this.j1.getY()-1 < 0                       ||
				             this.plateau[this.j1.getX()][this.j1.getY()-1] != ' ' ) return false;}
			case 'S' ->{if ( this.j1.getX()+1 >= this.plateau.length    ||
				             this.plateau[this.j1.getX()+1][this.j1.getY()] != ' ' ) return false;}
			case 'E' ->{if ( this.j1.getY()+1 >= this.plateau[0].length ||
				             this.plateau[this.j1.getX()][this.j1.getY()+1] != ' ' ) return false;}
		}

		return true;
	}

	public char[][] getPlateau() { return this.plateau; }
}