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

	private static Hashtable<String, Diplome[]> preRequis;

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
		
		/******* initialisation des fichiers ***********/
		this.preRequis = new Hashtable<String, Diplome[]>();
		initialiserPrerequis("src/PS_prerequis.csv");
		
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
		// méthode appelée par l'universitaire pour consulter les listes de voeux après décisions des étudiants
		// appel à la méthode getVoeux de gestionVoeux
		// Appel à la méthode majListe pour mettre à jour les listes en fonction des décisions des étudiants
		// Retourne les listes mises à jour
		return null;
	}

	public void enregistrerEtatCandidature(Voeu c, Etat e) throws voeuNonTrouve {  //interne vu que appelée par l'universitaire
		// Méthode appelée par l'universitaire quand il a mis à jour le voeu
		// fait appel à setEtatVoeu de gestionVoeux
		// appel à ajouter liste principale ou secondaire
	}

	public void ajouterListePrincipale(Voeu c) throws voeuNonTrouve { // méthode appelée en interne donc à sortir de l'IDL
		if (!listeCandidatures.contains(c)){
			throw new voeuNonTrouve();
		}
		else{
			this.listePrincipale.add(c);
		}
	}

	public void ajouterListeComplementaire(Voeu c) throws voeuNonTrouve { // méthode appelée en interne donc à sortir de l'IDL
		if (!listeCandidatures.contains(c)){
			throw new voeuNonTrouve();
		}
		else{
			this.listeComplementaire.add(c);
		}
	}

	public void majListes() { //TODO à sortir de l'IDL
		//changement de période. P3 me semble
		//on recharge les voeux et on regarde les décisions de l'étudiant
		//si il y a un OUI, on vire les autres candidatures
		// OUI, mais : 
		// NON, mais : 
		//NON : on suppr sa candidature
	}

	public void enregistrerAnnuaire(String ior) { // sortir IDL
		// TODO Auto-generated method stub

	}

	public void ajouterListeRejet(Voeu c) throws voeuNonTrouve { // intérêt d'avoir une liste refus ? pourquoi ne pas clore direct le voeu ? + interne
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
	 * Renvoie les diplomes pré-requis pour postuler à un diplome
	 */
	@Override
	public Diplome[] getListePrerequis(String diplome) {
		System.out.println("Taille de la hashtable : " + preRequis.size());
		if (preRequis.containsKey(diplome)){
			return preRequis.get(diplome);
		}
		else{
			System.err.println("Valeur non trouvée");
			return null;
		}
	}
	
	/**
	 * Permet de charger les notes d'un étudiant
	 * @param path
	 */
	private void initialiserNotesEtudiant(String path){
		String lineRead;
		String[] lineSplit;
		String nomUniv="";
		String numE="";
		float moyenne=0f;
		String code="";
		int position=0;
		
		//variable comptant le nombre de lignes du fichier par étudiant
		int cpt=0;
		Note[] notes = new Note[6];	
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));	 
			lineRead = br.readLine();	
			while ((lineRead = br.readLine()) != null) {
				lineSplit = lineRead.split(";",20);
//				System.out.println("line split notes : "+ lineSplit[0] + " - " + lineSplit[1] + " - " + lineSplit[2] + " - " +lineSplit[3]);
				nomUniv = lineSplit[0];
				numE = lineSplit[1];
				notes = new Note[6];
				cpt = 0;
					
				for (int i=2; i<lineSplit.length; i++)	{
					switch(i%3){  
						case 0: code = lineSplit[i];
						break;
						case 1: position = Integer.parseInt(lineSplit[i]);
							notes[cpt] = new Note("s"+cpt+1, moyenne, position, code);
//							System.out.println(cpt + " - Univ : "+ nomUniv + " - Etu : "+numE + " - Moyenne : " + moyenne + " -  Position : " + position + " - Etat de validation : " + code);
							cpt++;
						break;
						case 2 : moyenne = Float.parseFloat(lineSplit[i]);
						break;
						default : 
						break;
					}					
					listeNotesEtudiants.put(numE, notes);
				}
//				System.out.println("Taille de la hashtable : "+ listeNotesEtudiants.size());
			}
		}catch (Exception e){
			e.printStackTrace();
		}		
	}
	
	/**
	 * Permet de charger les formations pré-requis
	 * @param path
	 */
	private static void initialiserPrerequis(String path) {
		/*
		 * Réfléchir à un moyen d'intégrer les notes pour les prérequis! 
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
//				System.out.println("NumDIP : " + numDip + " - numDipPrecedent : " + numDipPrecedent);
				if (!numDip.equals(numDipPrecedent)){
//					System.out.println("Enregistrement de " +cpteur+ " diplomes prerequis pour le diplome : " + nomDipPrecedent +"\n\n");
					preRequis.put(nomDipPrecedent, diplomes);
					diplomes = new Diplome[10];
					cpteur = 0;
				}
				numDipPrecedent = numDip;
				nomDipPrecedent = nomDip;
//				System.out.println("Diplome : "+numDip+"-"+nomDip + " - Diplome Préparé : "+numDipPR+"-"+nomDipPR +" - " );
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
//			System.out.println("Enregistrement de " +cpteur+ " diplomes prerequis pour le diplome : " + nomDipPrecedent +"\n\n");
			preRequis.put(nomDip, diplomes);

		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private void elaborerScoreEtudiant (Etudiant etu){
		Note[] lesNotes = listeNotesEtudiants.get(etu);
		int somme = 0;
		for (int i =0; i< lesNotes.length; i++){
			//1234=4321 pour les classement
			//1S = 3; 2S=2; R=1
			switch(lesNotes[i].position){
			case 1: somme += 4;
				break;
			case 2: somme += 3;
				break;
			case 3: somme += 2;
				break;
			case 4 : somme += 1;
				break;
			}
			
			if (lesNotes[i].validation.equals("1S")){
				somme+=3;
			}else{
				if (lesNotes[i].validation.equals("2S")){
					somme+=3;
				}
				else {
					somme+=1;
				}
			}
		}
		
		etu.score = somme;
	}
//
//	public static void main (String [] args){
//		IUniversiteImpl i = new IUniversiteImpl(listeUniversitaires);
//		System.out.println("Taille du tableau du notes : " + i.getNotesEtudiants().size());
//			
//	}

	/**
	 * @return the preRequis
	 */
	public static Hashtable<String, Diplome[]> getPreRequis() {
		return preRequis;
	}	
	
//	/**
//	 * 
//	 * @return the note arrayList
//	 */
//	public Hashtable<String, Note[]> getNotesEtudiants() {
//		return listeNotesEtudiants;
//	}
}
