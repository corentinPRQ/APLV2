package ClientsServeurs;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContext;

import pRectorat.Accred;
import pRectorat.DecisionEtudiant;
import pRectorat.Etat;
import pRectorat.Etudiant;
import pRectorat.EtudiantNonTrouve;
import pRectorat.IGestionVoeux;
import pRectorat.IGestionVoeuxHelper;
import pRectorat.Rectorat;
import pRectorat.Voeu;
import pRectorat.VoeuNonTrouve;

public class ClientEtudiantGV implements Runnable{
	
	public static IGestionVoeux monGestionVoeu;
	
	private org.omg.CORBA.ORB orb;
	private NamingContext nameRoot;
	private String nomObj;
	private String idObj;
	private HashMap<String, ArrayList<Voeu>> listeDeVoeux;

	public ClientEtudiantGV(ORB orb, NamingContext nameRoot, String nomObj,
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
			
			// Récupération du nom de l'objet distant
			ClientEtudiantGV.monGestionVoeu = IGestionVoeuxHelper.narrow(distantObj);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void faireVoeu(Voeu v){
		try {
			ClientEtudiantGV.monGestionVoeu.faireVoeu(v);
		} catch (VoeuNonTrouve e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EtudiantNonTrouve e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void repondreProposition(DecisionEtudiant pDecision, Voeu v){
		try {
			ClientEtudiantGV.monGestionVoeu.repondreVoeu(pDecision, v);
		} catch (VoeuNonTrouve e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Voeu[] consulterListeVoeux(Etudiant etu){
		//ClientEtudiantGV.monGestionVoeu.consulterListeVoeu(etu);
		System.out.println("getVoeux du clientEtudiantGV");
		return (ClientEtudiantGV.monGestionVoeu.consulterListeVoeu(etu));
	}
	
	/**
	 * Renvoie la période en cours pour l'application
	 * @return période
	 */
	public String getPeriodeEnCours(){
		return ClientEtudiantGV.monGestionVoeu.getPeriodeEnCours();
	}
	
	public Accred[] getListeAccreditation(){
		return ClientEtudiantGV.monGestionVoeu.getListeAccreditations();
	}
	
	public boolean identifier(String login, String mdp) throws EtudiantNonTrouve{
		System.out.println(login + " - " +mdp );
		
		return ClientEtudiantGV.monGestionVoeu.identifier(login, mdp);
		
	}
	
	public String getIdRectorat(){
		return ClientEtudiantGV.monGestionVoeu.getIdRectorat();
	}
	
	public Voeu[] getVoeux(){
		System.out.println("getVoeux du clientEtudiantGV");
		return (ClientEtudiantGV.monGestionVoeu.getVoeux());
	
	}
	
	public Etudiant getEtudiant (String numEtudiant) throws EtudiantNonTrouve{
		return (ClientEtudiantGV.monGestionVoeu.getUtilisateur(numEtudiant));
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
			String nomObj = "Midi-Pyrenees_GVC";
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
