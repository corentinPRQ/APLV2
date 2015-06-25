package ClientsServeurs;

import java.util.ArrayList;
import java.util.HashMap;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContext;

import pRectorat.EtudiantNonTrouve;
import pRectorat.IGestionVoeux;
import pRectorat.IGestionVoeuxHelper;
import pRectorat.Voeu;
import pRectorat.VoeuNonTrouve;

public class ClientMinistereGV implements Runnable{

public static IGestionVoeux monGestionVoeu;
	
	private org.omg.CORBA.ORB orb;
	private NamingContext nameRoot;
	private String nomObj;
	private String idObj;
	private HashMap<String, ArrayList<Voeu>> listeDeVoeux;

	public ClientMinistereGV(ORB orb, NamingContext nameRoot, String nomObj,
			String idObj) {
		super();
		this.orb = orb;
		this.nameRoot = nameRoot;
		this.nomObj = nomObj;
		this.idObj = idObj;
		travailler();
	}
	
	public void travailler(){
		try{
			// Construction du nom a rechercher
			org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
			nameToFind[0] = new org.omg.CosNaming.NameComponent(this.idObj,"");
	
			// Recherche aupres du naming service
			org.omg.CORBA.Object distantObj = nameRoot.resolve(nameToFind);
			System.out.println("Objet '" + this.idObj + "' trouve aupres du service de noms. IOR de l'objet :");
			System.out.println(orb.object_to_string(distantObj));
	
			// Construction du nom a enregistrer
			org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
			nameToRegister[0] = new org.omg.CosNaming.NameComponent(this.nomObj,"");
			
			// Récupération du nom de l'objet distant
			ClientMinistereGV.monGestionVoeu = IGestionVoeuxHelper.narrow(distantObj);
			System.out.println("");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Changement de période dans rectorat.
	 * @param v
	 */
	public void changerPeriode(){
			ClientMinistereGV.monGestionVoeu.changerPeriode();
	}

	@Override
	public void run() {
		travailler();
	}
	
}
