package ClientsServeurs;

import java.util.ArrayList;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextPackage.InvalidName;

import pRectorat.Etudiant;
import pRectorat.EtudiantNonTrouve;
import pRectorat.Voeu;
import pUniversite.IUniversite;
import pUniversite.IUniversiteHelper;
import pUniversite.Note;

public class ClientUniversiteUniv implements Runnable{

	public static IUniversite monUniversite;

	private org.omg.CORBA.ORB orb;
	private NamingContext nameRoot;
	private String nomObj;
	private static String idObj;
	private ArrayList<Voeu> listeDeVoeux;

	public ClientUniversiteUniv(ORB orb, NamingContext nameRoot, String nomObj,
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

			// Récupération du nom de l'objet distant
			ClientUniversiteUniv.monUniversite= IUniversiteHelper.narrow(distantObj);

		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		// Intialisation de l'orb
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

		// Saisie du nom de l'objet (si utilisation du service de nommage)
		String idObj="Midi-Pyrenees_GVS";

		try{
			// Recuperation du naming service
			org.omg.CosNaming.NamingContext nameRoot;
			nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

			// Construction du nom a enregistrer
			String nomObj = "Midi";
			ClientGestionVoeuxMinistere cu = new ClientGestionVoeuxMinistere(orb, nameRoot, nomObj, idObj);
			cu.travailler();
		} catch (org.omg.CORBA.ORBPackage.InvalidName e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void run() {
		travailler();
	}
	
	
	public Note[] getNotes(Etudiant idE) throws EtudiantNonTrouve{
		return (ClientUniversiteUniv.monUniversite.getNotes(idE));
	}



}
