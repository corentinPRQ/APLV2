package Applications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContext;

import ClientsServeurs.ServeurGestionVoeux;

public class ApplicationGestionVoeux {
	public static int noGV= 0;
	private static int idGV;
	
	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			// Intialisation de l'ORB
			//************************
			//Il faut le faire qu'une fois!!!!!!
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

			// Enregistrement dans le service de nommage
			//*******************************************
			// Recuperation du naming service
			NamingContext nameRoot=org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

			
//			System.out.println("Quel est le nom du Rectorat ?");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//			String nomObj;
//
//			String nomRectorat = in.readLine();
			System.out.println(args[0]);
			String nomObj = args[0]+"_GestionVoeux";

			ServeurGestionVoeux serv = new ServeurGestionVoeux(orb, nameRoot, nomObj,args[0]);

			Thread tserv = new Thread(serv);
			tserv.start();
			
			// Saisie du nom de l'objet (si utilisation du service de nommage)
			System.out.println("Quel objet Corba voulez-vous contacter ?");
			String idObj = "PS_Gestion";

			// Construction du nom a enregistrer
//			System.out.println("Sous quel nom voulez-vous enregistrer l'objet Corba Client ?");
			String nomOb = args[0]+"_GVC";

//			ClientGestionVoeuxUniversite cge = new ClientGestionVoeuxUniversite(orb, nameRoot, nomOb, idObj);
//			ClientGestionVoeuxMinistere cgm = new ClientGestionVoeuxMinistere(orb, nameRoot, nomOb, idObj);

//			Thread tcli = new Thread(cge);
//			tcli.start();

		} catch (InvalidName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
