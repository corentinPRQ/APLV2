package ClientsServeurs;

import java.util.ArrayList;
import java.util.HashMap;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContext;

import pRectorat.Accred;
import pRectorat.DecisionEtudiant;
import pRectorat.Etat;
import pRectorat.EtudiantNonTrouve;
import pRectorat.IGestionVoeux;
import pRectorat.IGestionVoeuxHelper;
import pRectorat.Voeu;
import pRectorat.VoeuNonTrouve;

public class ClientGestionVoeuGV implements Runnable{


//	public static IGestionVoeux monGV;
	public static IGestionVoeux monGV;
	
	private org.omg.CORBA.ORB orb;
	private NamingContext nameRoot;
	private String nomObj;
	private String idObj;
	
	private HashMap<String, ArrayList<Voeu>> listeDeVoeux;
	
	public ClientGestionVoeuGV(ORB orb, NamingContext nameRoot, String nomObj,
			String idObj) {
		super();
		this.orb = orb;
		this.nameRoot = nameRoot;
		this.nomObj = nomObj;
		this.idObj = idObj;
		this.listeDeVoeux = new HashMap<String, ArrayList<Voeu>>();
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
	
			this.monGV = IGestionVoeuxHelper.narrow(distantObj);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Etat faireVoeu(Voeu v) throws VoeuNonTrouve, EtudiantNonTrouve {
		//Par d�faut le voeux est initialis� � lancien etat du voeu
		Etat et=v.etatVoeu; 
		try {
			et=ClientGestionVoeuGV.monGV.faireVoeu(v);
		} catch (VoeuNonTrouve e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EtudiantNonTrouve e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (et);
	}
	
	public void setEtatVoeu(Voeu v, Etat e){
		ClientGestionVoeuGV.monGV.setEtatVoeu(v, e);
	}
	
	public Accred[] getListeAccreditation(){
		return ClientGestionVoeuGV.monGV.getListeAccreditations();
	}

	public DecisionEtudiant repondreVoeu (DecisionEtudiant d, Voeu v) {
		DecisionEtudiant dc = v.decEtudiant;
		try {
			return ClientGestionVoeuGV.monGV.repondreVoeu(d, v);
		} catch (VoeuNonTrouve e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dc;
	}
	
	public static void main(String args[]) {
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

			// Saisie du nom de l'objet (si utilisation du service de nommage)
			String idObj="Midi-Pyrenees_GVS";

			// Recuperation du naming service
			org.omg.CosNaming.NamingContext nameRoot =
					org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

			// Construction du nom a enregistrer
			String nomObj = "Midi-Pyrenees_GVGV";
			ClientGestionVoeuxMinistere cu = new ClientGestionVoeuxMinistere(orb, nameRoot, nomObj, idObj);
			cu.travailler();
			
		} catch (InvalidName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void run() {
		travailler();
	}

}
