package Ville;

import java.util.ArrayList;
import java.util.List;

public class Chaussee {
	
	private int 					nbPositionRoute;
	private List <PositionBloc> 	listePositionBloc;

	public Chaussee(int nbPositionRoute) 
	{
		this.setNbPositionRoute(nbPositionRoute);
		
		listePositionBloc 			= new ArrayList<PositionBloc>(nbPositionRoute);
		
		this.initListePosition(nbPositionRoute);	
	}
	
	/** 
	 * TODO			: Mettre � jour les PositionsBloc avec le PositionBloc suivant
	 * @function 	: rempli la chauss�e de position Bloc   
	 * @param 		: nbPositionRoute
	 */
	private void initListePosition(int nbPositionRoute) 
	{
		
		for(int i = 0 ; i< nbPositionRoute; i++)
		{
			PositionBloc b = new PositionBloc (i);
			this.listePositionBloc.add(b);
		}
		
	}

	
	/**
	 * @Function 	: Getter / Setter
	 */
	
	public int getNbPositionRoute() 
	{
		return nbPositionRoute;
	}

	public void setNbPositionRoute(int nbPositionRoute) 
	{
		this.nbPositionRoute = nbPositionRoute;
	}

	
	
	

}