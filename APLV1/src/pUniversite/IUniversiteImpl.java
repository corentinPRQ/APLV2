package pUniversite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;

import pRectorat.Diplome;
import pRectorat.Etat;
import pRectorat.Etudiant;
import pRectorat.EtudiantNonTrouve;
import pRectorat.NiveauEtude;
import pRectorat.Voeu;

public class IUniversiteImpl extends IUniversitePOA{

	private Hashtable<String, Diplome[]> preRequis;
	private Hashtable<String,Note[]> listeNotesEtudiants;
	private static Hashtable<String, String> listeUniversitaires;

	private ArrayList<Voeu> listePrincipale;
	private ArrayList<Voeu> listeComplementaire;
	private ArrayList<Voeu> listeRefuse;
	private ArrayList<Voeu> listeCandidatures;


	public IUniversiteImpl(Hashtable<String, String> listeU) {
		super();

		//initialisation des listes 
		this.listeCandidatures = new ArrayList<Voeu>();
		this.listePrincipale = new ArrayList<Voeu>();
		this.listeComplementaire = new ArrayList<Voeu>();
		this.listeRefuse = new ArrayList<Voeu>();
		
		// initialisation des fichiers
		this.preRequis = new Hashtable<String, Diplome[]>();
		initialiserPrerequis("src/universite_prerequisV2.csv");
		
		this.listeNotesEtudiants = new Hashtable<String, Note[]>();
		initialiserNotesEtudiant("src/notes.csv");

		this.listeUniversitaires = listeU;
	}


	public static boolean identifier(String login, String mdp) throws universitaireNonTrouve {
		if (!listeUniversitaires.containsKey(login)) {
			//mettre un code GUI pour notifier de l'erreur d'identification
			throw new universitaireNonTrouve();
		}
		else {
			if (listeUniversitaires.get(login).equals(mdp)==false){
				return false;
			}
		}
		return true;
	}

	public Voeu getCandidatures() { //changer le type de retour -> tab VOeu
		// m�thode appel�e par l'universitaire pour consulter les listes de voeux apr�s d�cisions des �tudiants
		// appel � la m�thode getVoeux de gestionVoeux
		// Appel � la m�thode majListe pour mettre � jour les listes en fonction des d�cisions des �tudiants
		// Retourne les listes mises � jour
		return null;
	}

	public void enregistrerEtatCandidature(Voeu c, Etat e) throws voeuNonTrouve {  //interne vu que appel�e par l'universitaire
		// M�thode appel�e par l'universitaire quand il a mis � jour le voeu
		// fait appel � setEtatVoeu de gestionVoeux
		// appel � ajouter liste principale ou secondaire
	}

	public void ajouterListePrincipale(Voeu c) throws voeuNonTrouve { // m�thode appel�e en interne donc � sortir de l'IDL
		if (!listeCandidatures.contains(c)){
			throw new voeuNonTrouve();
		}
		else{
			this.listePrincipale.add(c);
		}
	}

	public void ajouterListeComplementaire(Voeu c) throws voeuNonTrouve { // m�thode appel�e en interne donc � sortir de l'IDL
		if (!listeCandidatures.contains(c)){
			throw new voeuNonTrouve();
		}
		else{
			this.listeComplementaire.add(c);
		}
	}

	public void majListes() { //TODO � sortir de l'IDL
		//changement de p�riode. P3 me semble
		//on recharge les voeux et on regarde les d�cisions de l'�tudiant
		//si il y a un OUI, on vire les autres candidatures
		// OUI, mais : 
		// NON, mais : 
		//NON : on suppr sa candidature
	}

	public void enregistrerAnnuaire(String ior) { // sortir IDL
		// TODO Auto-generated method stub

	}

	public void ajouterListeRejet(Voeu c) throws voeuNonTrouve { // int�r�t d'avoir une liste refus ? pourquoi ne pas clore direct le voeu ? + interne
		if (!listeCandidatures.contains(c)){
			throw new voeuNonTrouve();
		}
		else{
			this.listeRefuse.add(c);
		}
	}

	@Override
	public Note[] getNotes(Etudiant idE) throws EtudiantNonTrouve{ // pour exam candidatures pour une autre univ
		if (listeNotesEtudiants.contains(idE.noEtu)){
			throw new EtudiantNonTrouve();
		}
		else {
			return listeNotesEtudiants.get(idE.noEtu);
		}
	}

	/**
	 * Renvoie les diplomes pr�-requis pour postuler � un diplome
	 */
	@Override
	public Diplome[] getListePrerequis(String diplome) {
		System.out.println("Taille de la hashtable : " + preRequis.size());
		if (preRequis.containsKey(diplome)){
			return preRequis.get(diplome);
		}
		else{
			System.err.println("Valeur non trouv�e");
			return null;
		}
	}
	
	/**
	 * Permet de charger les notes d'un �tudiant
	 * @param path
	 */
	private void initialiserNotesEtudiant(String path){
		String lineRead;
		String[] lineSplit;
		String numE="";
		String numEprecedent="";
		String numMat="";
		String nomMat="";
		float moy=0f;
		//variable comptant le nombre de lignes du fichier par �tudiant
		int cpteur = 0;
		
		Note[] notes = new Note[20];
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));	 
			lineRead = br.readLine();	
			while ((lineRead = br.readLine()) != null) {
				lineSplit = lineRead.split(";",4);
//				System.out.println("line split notes : "+ lineSplit[0] + " - " + lineSplit[1] + " - " + lineSplit[2] + " - " +lineSplit[3]);
				
				for (int i=0; i<lineSplit.length; i++){
					switch(i){  
					case 0: numE = lineSplit[0];
					break;
					case 1: numMat = lineSplit[1];
					break;
					case 2 : nomMat = lineSplit[2];
					break;
					case 3 : moy = Float.parseFloat(lineSplit[3]);
						break;
					default : 
						break;
					}
//					System.out.println("Etu : "+numE + " - matiere : "+numMat +"-"+nomMat + " - note : " + moy);
				}
				
				//si le num�ro etudiant est diff�rent du pr�c�dent c'est qu'on chang� d'�tudiant, donc on enregistre ses notes
//				System.out.println("NumE : " + numE + " - numEprecedent : " + numEprecedent);
				if (!numE.equals(numEprecedent)){
					listeNotesEtudiants.put(numEprecedent, notes);
					notes = new Note[20];
					cpteur = 0;
				}
				numEprecedent = numE;
//				System.out.println("Etu : "+numE + " - matiere : "+numMat +"-"+nomMat + " - note : " + moy);
				Note n = new Note(new Matiere(numMat, nomMat), moy);
				notes[cpteur] = n;
				cpteur++;
			}

		}catch (Exception e){
			e.printStackTrace();
		}
//		System.out.println("Affichage de la liste des notes : ");
//		
//		System.out.println(listeNotesEtudiants.values());
		
		
	}
	
	/**
	 * Permet de charger les formations pr�-requis
	 * @param path
	 */
	private void initialiserPrerequis(String path) {
		/*
		 * R�fl�chir � un moyen d'int�grer les notes pour les pr�requis! 
		 */
		
		String lineRead;
		String[] lineSplit;
		String numUniv="";
		String nomUniv="";
		String numDip="";
		String nomDip = "";
		String numDipPR="";
		String nomDipPR="";
		float moyFR = 0f;
		float moyMat = 0f;
		float moyEn= 0f;
		
		//variable comptant le nombre de lignes du fichier par diplome
		int cpteur = 0;
		String numDipPrecedent = "";
		String nomDipPrecedent = "";
		NiveauEtude ne = null;
		Diplome[] diplomes = new Diplome[10];
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));	 
			lineRead = br.readLine();

			while ((lineRead = br.readLine()) != null) {
				lineSplit = lineRead.split(";",9);
//				System.out.println("line split : "+ lineSplit[0] + " - " + lineSplit[1] + " - " + lineSplit[2] + " - " +lineSplit[3]);
				for (int i=0; i<lineSplit.length; i++){
					switch(i){  
					case 0 : numUniv = lineSplit[0];
					break;
					case 1 : nomUniv = lineSplit[1];
					break;
					case 2 : numDip = lineSplit[2];
					break;
					case 3 : nomDip = lineSplit[3];
					System.out.println(nomDip);
					break;
					case 4 : numDipPR = lineSplit[4];
					break;
					case 5 : nomDipPR = lineSplit[5];
					break;
					case 6 : moyFR = Float.parseFloat(lineSplit[6]);
					break;
					case 7 : moyMat = Float.parseFloat(lineSplit[7]);
					break;
					case 8 : moyEn = Float.parseFloat(lineSplit[8]);
					break;
					default : System.err.println("Erreur dans la lecture du fichier");
					break;
					}					
				}
				//si le num�ro etudiant est diff�rent du pr�c�dent c'est qu'on chang� d'�tudiant, donc on enregistre ses notes
//				System.out.println("NumDIP : " + numDip + " - numDipPrecedent : " + numDipPrecedent);
				if (!numDip.equals(numDipPrecedent)){
					System.out.println("Enregistrement de " +cpteur+ " diplomes prerequis pour le diplome : " + nomDipPrecedent +"\n\n");
					this.preRequis.put(nomDipPrecedent, diplomes);
					diplomes = new Diplome[10];
					cpteur = 0;
				}
				numDipPrecedent = numDip;
				nomDipPrecedent = nomDip;
//				System.out.println("Diplome : "+numDip+"-"+nomDip + " - Diplome Pr�par� : "+numDipPR+"-"+nomDipPR +" - " );
				if (nomDipPR.contains("L3")){
					ne = NiveauEtude.licence;
				}
				else{ 
					ne=NiveauEtude.master;
				}
				Diplome d = new Diplome(nomDipPR, ne);
				diplomes[cpteur] = d;
				cpteur++;
				
			}
			System.out.println("Enregistrement de " +cpteur+ " diplomes prerequis pour le diplome : " + nomDipPrecedent +"\n\n");
			this.preRequis.put(nomDip, diplomes);
			if (preRequis.containsKey("M1Miage")){
				System.out.println("COUCOU");
			}

		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public static void main (String [] args){
		IUniversiteImpl i = new IUniversiteImpl(listeUniversitaires);
		System.out.println(i.getListePrerequis("M1Miage"));
			
	}


	
	
}
