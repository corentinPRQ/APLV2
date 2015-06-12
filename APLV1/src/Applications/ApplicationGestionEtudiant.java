package Applications;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContext;

import pRectorat.Etudiant;
import pRectorat.Voeu;
import pUniversite.Matiere;
import pUniversite.Note;
import ClientsServeurs.ClientEtudiantGV;
import GUI.IHM_Etudiant;

public class ApplicationGestionEtudiant {
	public static int noEtu = 0;
	private static int idEtdu;
	private static ArrayList<Voeu> listeVoeux;
	//liste d'étudiants pour l'identification (nom, mdp)
	private static Hashtable<String, String> listeEtudiants;

	//	public ApplicationGestionEtudiant(String login){
	//		String[] arguments = new String[2];
	//		arguments[0]=login;
	//		main(arguments);
	//	}


	public static void main(String[] args) {
		try {
			noEtu++;
			idEtdu = noEtu; 
			listeEtudiants = new Hashtable<String, String>();
			listeVoeux = new ArrayList<Voeu>();
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

			// Saisie du nom de l'objet (si utilisation du service de nommage)
			System.out.println("Connexion avec le rectorat Midi-Pyrenees_GestionVoeu");
			//Cas d'une connexion avec un GestionVoeux : 
			String idObj = "Midi-Pyrenees_GestionVoeux";
			// Construction du nom a enregistrer
			String nomObj = "ClientEtudiantGV";

			System.out.println("lancement du client Etudiant");
			ClientEtudiantGV ce = new ClientEtudiantGV(orb, nameRoot, nomObj, idObj);
			
			/*Voeu[] lesVoeux = ce.consulterListeVoeux(new Etudiant("1", "Melet"));

			for (int i = 0; i<lesVoeux.length; i++){
				if (Integer.parseInt(lesVoeux[i].noE) == idEtdu){
					listeVoeux.add(lesVoeux[i]);
				}
			}*/

			
			
			/*initialiserEtudiant("src/usersEtu.csv");
			IHM_Etudiant ihmE = new IHM_Etudiant(listeVoeux, listeEtudiants);*/

			
        	Thread tcli = new Thread(ce);
			
			IHM_Etudiant ihmEtu = new IHM_Etudiant(ce);
			
		} catch (InvalidName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/*private static void initialiserEtudiant(String path){
		String lineRead;
		String[] lineSplit;
		String login="";
		String mdp="";
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));	 
			lineRead = br.readLine();

			while ((lineRead = br.readLine()) != null) {
				lineSplit = lineRead.split(";",4);
//				System.out.println("line split users : "+ lineSplit[0] + " - " + lineSplit[1] + " - " + lineSplit[2] + " - " +lineSplit[3]);
				for (int i=0; i<lineSplit.length; i++){
					switch(i){  
					case 0: login = lineSplit[0];
					break;
					case 1: mdp = lineSplit[1];
					break;
					case 2 : 
						break;
					case 3 : 
						break;
					default : 
						break;
					}
				}
				System.out.println("Login : "+login + " - mdp : "+mdp);
				listeEtudiants.put(login, mdp);
			}

		}catch (Exception e){
			e.printStackTrace();
		}
	}*/


}
//	System.out.println("1 : Faire un voeux");
//	System.out.println("2 : Consulter liste de voeux");
//	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//	choix = in.read();
//	String idEtu = "123";
//	
//	switch(choix){
//	case 1:
//		Voeu voeu = new Voeu(new idVoeu("1", new idEtudiant("123", "Roig"),  new Accred("1", new idDiplome("1", "MasterMIAGE"), new idUniversite("1", "PS"))), new idRectorat("1", "MP"), DecisionEtudiant.oui, Etat.cree);
//		ClientGestionVoeux.monGV.faireVoeu(idEtu, new Accred("1", new idDiplome("1", "MasterMIAGE"), new idUniversite("1", "PS")), voeu);
//		if (!listeDeVoeux.containsKey(idEtu)){
//			listeDeVoeux.put(idEtu, new ArrayList<Voeu>());
//		}				
//		listeDeVoeux.get(idEtu).add(voeu);
//		System.out.println("Liste de voeu : " + listeDeVoeux.get(idEtu));
//		break;
//	case 2: 
//		System.out.println(listeDeVoeux.get(idEtu));
//		break;
//	case 9 : 
//		break;
//
//		
//	}
//}
