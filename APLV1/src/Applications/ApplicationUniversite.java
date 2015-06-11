package Applications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContext;

import pRectorat.Universite;
import ClientsServeurs.ClientGestionVoeuxMinistere;
import ClientsServeurs.ClientUniversiteGV;
import ClientsServeurs.ServeurUniversite;
import GUI.IHM_Universitaire;

public class ApplicationUniversite {
	public static int noUniv = 0;
	private static int idUniv;

	public static void main(String[] args) {
		try {
			noUniv++;
			idUniv = noUniv; 
			// TODO Auto-generated method stub
			// Intialisation de l'ORB
			//************************
			//Il faut le faire qu'une fois!!!!!!
			System.out.println("init de l'orb");
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

			// Enregistrement dans le service de nommage
			//*******************************************
			// Recuperation du naming service
			System.out.println("Recuperation du naming service");
			NamingContext nameRoot=org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

//			System.out.println("Sous quel nom voulez-vous enregistrer l'objet Corba Serveur ?");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String nomObj=args[0]+"_Gestion";

			//nomObj = in.readLine();

			ServeurUniversite serv = new ServeurUniversite(orb, nameRoot, nomObj);
			Thread tserv = new Thread(serv);
			tserv.start();

			// Saisie du nom de l'objet
			System.out.println("Quel objet Corba voulez-vous contacter ?");
			//Cas d'une connexion avec un GestionVoeux : 
			String idObj = "Midi_Pyrenees_Gestion";
			// Construction du Client spécifique à l'action à faire
			System.out.println("Sous quel nom voulez-vous enregistrer l'objet Corba Client ?");
			String nomOb = "Client_PS_Gestion";
			System.out.println("lancement du client Université");
			ClientUniversiteGV cu = new ClientUniversiteGV(orb, nameRoot, nomOb, idObj);
//			Thread tcli = new Thread(cu);
//			tcli.start();

			IHM_Universitaire ihmU = new IHM_Universitaire(cu);
			ihmU.setVisible(true);
		} catch (InvalidName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void setIdUniv(int i){
		idUniv = i;
	}

	/**
	 * @return the idUniv
	 */
	public static int getIdUniv() {
		return idUniv;
	}
}
