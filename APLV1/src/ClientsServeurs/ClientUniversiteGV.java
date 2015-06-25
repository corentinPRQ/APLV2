package ClientsServeurs;

import java.util.ArrayList;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContext;

import pRectorat.Accred;
import pRectorat.Etat;
import pRectorat.Etudiant;
import pRectorat.EtudiantNonTrouve;
import pRectorat.IGestionVoeux;
import pRectorat.IGestionVoeuxHelper;
import pRectorat.Voeu;

public class ClientUniversiteGV implements Runnable{
	
	public static IGestionVoeux monGestionVoeu;
	
	private org.omg.CORBA.ORB orb;
	private NamingContext nameRoot;
	private String nomObj;
	private String idObj;
	private ArrayList<Voeu> listeDeVoeux;

	public ClientUniversiteGV(ORB orb, NamingContext nameRoot, String nomObj,
			String idObj) {
		super();
		this.orb = orb;
		this.nameRoot = nameRoot;
		this.nomObj = nomObj;
		this.idObj = idObj;
		this.listeDeVoeux = new ArrayList<Voeu>();
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
//			org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
//			nameToRegister[0] = new org.omg.CosNaming.NameComponent(this.nomObj,"");
			
			// Récupération du nom de l'objet distant
			ClientUniversiteGV.monGestionVoeu = IGestionVoeuxHelper.narrow(distantObj);
			System.out.println("fin travailler");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Voeu> getVoeux(){
		Voeu[] lesVoeux = ClientUniversiteGV.monGestionVoeu.getVoeux();
		//On stock les voeux (Voeu[]) dans une arraylist (plus simple à utiliser)
		for (int i =0; i<lesVoeux.length; i++){
			listeDeVoeux.add(lesVoeux[i]);
		}
		return listeDeVoeux;
	}
	
	public Voeu[] getVoeuxUniv(String nomUniv){
		return ClientUniversiteGV.monGestionVoeu.getVoeuxUniv(nomUniv);
	}
	
	public void enregistrerUniversite (String nom, String ior){
		String nomUniv = nom.replace("Client_", "");
		nomUniv = nomUniv.replace("_Gestion", "");
		nomUniv = nomUniv.replace("_", "");
		ClientUniversiteGV.monGestionVoeu.enregistrerUniversite(ior, nomUniv);
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
			ClientUniversiteGV cu = new ClientUniversiteGV(orb, nameRoot, nomObj, idObj);
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
	
	/**
	 * Renvoie les accréditations pour une université donnée
	 * @param nomUniv
	 * @return
	 */
	public Accred[] getListeAccredUniversite(String nomUniv){
		int cpteur= 0;
		Accred[] toutesAccreds =  ClientUniversiteGV.monGestionVoeu.getListeAccreditations();
		Accred[] monUniversite = new Accred[toutesAccreds.length];
		for (int i=0; i<toutesAccreds.length; i++) {
			if(toutesAccreds[i].libelleU.replace(" ", "").equals(nomUniv.trim())){
				monUniversite[cpteur] = toutesAccreds[i];
				cpteur++;
			}
		}
		return (monUniversite);
	}
	
	/**
	 * Renvoi un objet etudiant via un numéro etudiant
	 * @param numEtudiant
	 * @return
	 */
	public Etudiant getEtudiant (String numEtudiant){
		System.out.println("METHODE GetEtudiant - ClientUniversite --> monGV = " + monGestionVoeu);
		try {
			Etudiant e = ClientUniversiteGV.monGestionVoeu.getEtudiant(numEtudiant);
			return (e);
		} catch (EtudiantNonTrouve e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (null);
	}
	
	public void setEtatVoeu(Voeu v, Etat e) {
		ClientUniversiteGV.monGestionVoeu.setEtatVoeu(v, e);
	}
	

}
