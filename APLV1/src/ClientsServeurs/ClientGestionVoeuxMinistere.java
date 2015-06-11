package ClientsServeurs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContext;

import pMinistere.IMinistere;
import pMinistere.IMinistereHelper;
import pRectorat.Diplome;
import pRectorat.IGestionVoeux;
import pUniversite.IUniversite;


public class ClientGestionVoeuxMinistere implements Runnable{

	public static IMinistere monM;
	
	private org.omg.CORBA.ORB orb;
	private NamingContext nameRoot;
	private String nomObj;
	private String idObj;

	public ClientGestionVoeuxMinistere(ORB orb, NamingContext nameRoot, String nomObj,
			String idObj) {
		super();
		this.orb = orb;
		this.nameRoot = nameRoot;
		this.nomObj = nomObj;
		this.idObj = idObj;
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
	
			//this.monUniv = IUniversiteHelper.narrow(distantObj);
			//this.monGV = IGestionVoeuxHelper.narrow(distantObj);
			this.monM = IMinistereHelper.narrow(distantObj);
			
			recupererReferenciel();
			/* ici il faut mettre les trucs de l'interface graphique manière que 
			 * l'utilisateur puisse interagir */
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void recupererReferenciel (){
		Diplome[] referenciel = new Diplome[100]; 
		referenciel = ClientGestionVoeuxMinistere.monM.getReferenciel();
		System.out.println("Taille du tableau : " + referenciel.length);
		for (int i = 0; i<referenciel.length; i++){
			System.out.println(referenciel[i].libelle);
		}
	}

	public static void main(String args[]) {
		try {
			// Intialisation de l'orb
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

			// Saisie du nom de l'objet (si utilisation du service de nommage)
//			System.out.println("Quel objet Corba voulez-vous contacter ?");
//			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//			String idObj = in.readLine();
			String idObj="Ministere";

			// Recuperation du naming service
			org.omg.CosNaming.NamingContext nameRoot =
					org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

			// Construction du nom a enregistrer
//			System.out.println("Sous quel nom voulez-vous enregistrer l'objet Corba ?");
//			BufferedReader in1 = new BufferedReader(new InputStreamReader(System.in));
//			String nomObj = in1.readLine();
			String nomObj = "GVClient";
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
