package Applications;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContext;

import ClientsServeurs.ClientGestionVoeuxMinistere;
import ClientsServeurs.ServeurGestionVoeux;
import GUI.IHM_Rectorat;

public class ApplicationGestionVoeux {	
	
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

			
			ClientGestionVoeuxMinistere cvm = new ClientGestionVoeuxMinistere(orb, nameRoot, nomObj, "Ministere");
			Thread tclgv = new Thread(cvm);
			IHM_Rectorat ihmR = new IHM_Rectorat(cvm);
			ihmR.setVisible(true);

		} catch (InvalidName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
