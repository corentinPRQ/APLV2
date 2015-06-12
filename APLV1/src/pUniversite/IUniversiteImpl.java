package pUniversite;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Collections;
import java.util.Properties;

import org.apache.xerces.utils.Hash2intTable;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContext;

import pRectorat.Accred;
import pRectorat.DecisionEtudiant;
import pRectorat.Diplome;
import pRectorat.Etat;
import pRectorat.Etudiant;
import pRectorat.EtudiantNonTrouve;
import pRectorat.IGestionVoeuxImpl;
import pRectorat.NiveauEtude;
import pRectorat.Voeu;
import utilitaires.utils;
import Applications.ApplicationUniversite;
import Applications.PeriodeApplication;
import ClientsServeurs.ClientUniversiteGV;

public class IUniversiteImpl extends IUniversitePOA{

	/**
	 * Nom de l'université (pour récupération des bons fichiers).
	 */
	private String nomUniversité;
	private static Hashtable<String, Diplome[]> preRequis;
	private static Hashtable<String, Integer> quotaDiplome;

	private Hashtable<String,Note[]> listeNotesEtudiants;
	private static Hashtable<String, String> listeUniversitaires;

	private ArrayList<Voeu> listePrincipale;
	private ArrayList<Voeu> listeComplementaire;
	private ArrayList<Voeu> listeRefuse;
	private ArrayList<Voeu> listeCandidatures;

	private static org.omg.CORBA.ORB orb;
	private static NamingContext nameRoot;
	private static String nomObj;

	// pour les pré-requisV2
	private static Accred[] listeAccred;
	//key : libelle diplome, voeux demandant un diplome
	private Hashtable<String,ArrayList<Voeu>> listeVoeuxDiplome;

	//key idEtudiant, son score
	private Hashtable<String,Integer> scoreEtu;

	public IUniversiteImpl(Hashtable<String, String> listeU, ORB orb, NamingContext nameRoot, String nomObj ) {
		super();

		//initialisation des listes 
		this.listeCandidatures = new ArrayList<Voeu>();
		this.listePrincipale = new ArrayList<Voeu>();
		this.listeComplementaire = new ArrayList<Voeu>();
		this.listeRefuse = new ArrayList<Voeu>();

		// initialisation des fichiers
		this.preRequis = new Hashtable<String, Diplome[]>();
		initialiserPrerequis("src/PS_prerequis.csv");

		this.listeNotesEtudiants = new Hashtable<String, Note[]>();
		initialiserNotesEtudiant("src/notes.csv");

		this.listeUniversitaires = listeU;

		this.orb = orb;
		this.nameRoot = nameRoot;
		this.nomObj = nomObj;
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

	/**
	 * Permet de renvoyer les voeux à l'universitaire
	 * Si on est en P3, on met à jour automatiquement la liste en fonction des décisions de l'étudiant
	 * @return les voeux à jour
	 */
	/*public ArrayList<Voeu> getCandidatures() { 

		// méthode appelée par l'universitaire pour consulter les voeux
		String idObj = ApplicationUniversite.getIdentiteUniversite() + "_Gestion";
		ClientUniversiteGV cugv = new ClientUniversiteGV(orb,
				nameRoot, nomObj, idObj);

		ArrayList<Voeu> lesVoeux = cugv.getVoeux();

		listeCandidatures = lesVoeux;

		// si P4
		if(p3()){
			// Permet de mettre à jour la liste en fonction des décisions des étudiants
			this.majListes();
		}

		return lesVoeux; //renvoyer que les voeux qui ont de l'intérêt. A définir les états des voeux aux différentes étapes
	}*/

	/*private boolean p3(){
		boolean P3=false;
		Properties p;
		p = null;
		try {
			p = utils.load("parametres.properties");
		} catch (FileNotFoundException e) {
			System.out.println("Echec ouverture properties");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Echec ouverture properties");
			e.printStackTrace();
		}
		if (p != null) {
			FileOutputStream fos;
			try {
				fos = new FileOutputStream("parametres.properties");
				if (p.getProperty("periode").equals(PeriodeApplication.PERIODE_3.toString())) {
					P3=true;
				}
			} catch (FileNotFoundException e1) {
				System.out.println("Echec écriture properties");
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return P3;
	}*/

	/**
	 * Permet d'enregistrer la décision de l'universitaire concernant un Voeu
	 * @param v
	 * @param e
	 * @throws voeuNonTrouve
	 */
	/*public void enregistrerEtatCandidature(Voeu v, Etat e) throws voeuNonTrouve {  
		IGestionVoeuxImpl IGVI = new IGestionVoeuxImpl(orb, nameRoot, nomObj);
		IGVI.setEtatVoeu(v, e);

		if(e.equals(Etat.liste_principale)){
			this.ajouterListePrincipale(v);
		}else if (e.equals(Etat.liste_secondaire)){
			this.ajouterListeComplementaire(v);
		}else if (e.equals(Etat.refus)){
			this.ajouterListeRejet(v);
		}
		//appel à relayer voeu dans la conception. WTF ?
	}*/

	public void ajouterListePrincipale(Voeu v) throws voeuNonTrouve { 
		if (!listeCandidatures.contains(v)){ 
			throw new voeuNonTrouve();
		}
		else{
			this.listePrincipale.add(v);
		}
	}

	public void ajouterListeComplementaire(Voeu v) throws voeuNonTrouve { 
		if (!listeCandidatures.contains(v)){
			throw new voeuNonTrouve();
		}
		else{
			this.listeComplementaire.add(v);
		}
	}

	public void majListes() { 
		//changement de période. P4
		//on recharge les voeux et on regarde les décisions de l'étudiant

		for(int i=0; i<listeCandidatures.size(); i++){
			Voeu vTmp = listeCandidatures.get(i);
			if(vTmp.decEtudiant == DecisionEtudiant.oui){
				//on suppr les autres candidatures de l'étudiant
				i++;
				Voeu vTmp2 = listeCandidatures.get(i);
				while(vTmp2.noE.equals(vTmp.noE)){
					if(listePrincipale.contains(vTmp2)){
						listePrincipale.remove(vTmp2);
					}else if(listeComplementaire.contains(vTmp2)){
						listeComplementaire.remove(vTmp2);
					}
					i++;
					vTmp2 = listeCandidatures.get(i);
				}
				//on sort quand le voeux est d'un autre étudiant
				//Pour que le voeu soit analyser dans la prochaine itération du for, on fait un i--
				i--;

			}else if(vTmp.decEtudiant == DecisionEtudiant.oui_mais){
				//TODO
			}else if(vTmp.decEtudiant == DecisionEtudiant.non_mais){
				//TODO
			}else if(vTmp.decEtudiant == DecisionEtudiant.non){
				if(listePrincipale.contains(vTmp)){
					listePrincipale.remove(vTmp);
				}else if(listeComplementaire.contains(vTmp)){
					listeComplementaire.remove(vTmp);
				}
			}
		}
	}

	/*public void enregistrerAnnuaire(String ior) { 
	// TODO Auto-generated method stub

	}*/

	public void ajouterListeRejet(Voeu v) throws voeuNonTrouve {
		if (!listeCandidatures.contains(v)){
			throw new voeuNonTrouve();
		}
		else{
			this.listeRefuse.add(v);
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
		int quota =0;

		//variable comptant le nombre de lignes du fichier par diplome
		int cpteur = 0;
		String numDipPrecedent = "";
		String nomDipPrecedent = "";
		NiveauEtude ne = null;
		Diplome[] diplomes = new Diplome[10];
		//Hasthable pour les quotas des masters
		Hashtable<String, Integer> lesQuotas = new Hashtable<String, Integer>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));	 
			lineRead = br.readLine();

			while ((lineRead = br.readLine()) != null) {
				lineSplit = lineRead.split(";",7);
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
					case 6 : quota = Integer.parseInt(lineSplit[6]);
					break;
					default : System.err.println("Erreur dans la lecture du fichier");
					break;
					}					
				}
				//si le numéro diplome est différent du précédent c'est qu'on changé de diplome, donc on enregistre ses notes
				//				System.out.println("NumDIP : " + numDip + " - numDipPrecedent : " + numDipPrecedent);
				if (!numDip.equals(numDipPrecedent)){
					System.out.println("Enregistrement de " +cpteur+ " diplomes prerequis pour le diplome : " + nomDipPrecedent +"\n\n");
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
				//Gestion des quotas
				if(!lesQuotas.containsKey(numDip)){
					lesQuotas.put(numDip, quota);
				}
				Diplome d = new Diplome(nomDipPR, ne);
				diplomes[cpteur] = d;
				cpteur++;

			}
			System.out.println("Enregistrement de " +cpteur+ " diplomes prerequis pour le diplome : " + nomDipPrecedent +"\n\n");
			preRequis.put(nomDip, diplomes);
			quotaDiplome = lesQuotas;
		}catch (Exception e){
			e.printStackTrace();
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






	//	public static void main (String [] args){
	//		IUniversiteImpl i = new IUniversiteImpl(listeUniversitaires);
	//		System.out.println(i.getListePrerequis("M1Miage"));
	//			
	//	}

	/**
	 * @return the preRequis
	 */
	public static Hashtable<String, Diplome[]> getPreRequis() {
		return preRequis;
	}


	/**
	 * méthode appelée automatiquement par gestionVoeu (rectorat) en début de P3 pour faire la vérif des prérequis
	 * les prérequis se basent en fonction d'un score calculé grâce à la position de l'étudiant et sa session de réussite
	 */
	@Override
	public void verifCandidature(Voeu[] tabVoeux) {
		this.remplirVoeuxDip(tabVoeux);
		this.ordonnerVoeuxDip();
		this.etablirListe();

	}

	private void remplirVoeuxDip(Voeu[] tabVoeux){
		ArrayList<Voeu> tabVoeuxDip = new ArrayList<Voeu>();
		listeVoeuxDiplome = new Hashtable<String, ArrayList<Voeu>>();
		//on charge les voeux dans le tableau des candidatures
		for (int i=0;i<tabVoeux.length; i++){
			listeCandidatures.add(tabVoeux[i]);
		}
		// pour charque accreditation, on construit une hashtable avec un tableau des voeux demandant chaque formation
		for (int i=0; i<listeAccred.length; i++){
			// on parcours les voeux pour ajouter les voeux par diplome
			for(int j=0; j<listeCandidatures.size(); j++){
				if(listeCandidatures.get(j).acreditation.equals(listeAccred[i])){
					tabVoeuxDip.add(listeCandidatures.get(j));
				}
			}
			listeVoeuxDiplome.put(listeAccred[i].libelleD, tabVoeuxDip);
			tabVoeuxDip.clear();
		}
	}
	/**
	 * Permet d'établir le score des étudiants pour trier les voeux par pertinance
	 */
	private void ordonnerVoeuxDip(){
		this.etablirScore();
		//classer les voeux par diplome et par score dans listeVoeuxDiplome
		//classe les voeux par diplome et par score dans listeVoeuxDiplome
		//On parcourt les diplomes dans la hashT de diplome/liste voeux
		while(listeVoeuxDiplome.keys().hasMoreElements()){
			//pour le premier diplome
			String dip = listeVoeuxDiplome.keys().nextElement();
			//on récupère tous les voeux
			ArrayList<Voeu> tabVoeuxTmp = listeVoeuxDiplome.get(dip);
			//on tri ces voeux en fonction du score
			tabVoeuxTmp = triBulle(tabVoeuxTmp);
			//On remplace l'ancien tableau par le tableau trié
			listeVoeuxDiplome.put(dip, tabVoeuxTmp);

		}
	}

	/**
	 * Etablie le score de l'étudiant en fonction de sa position et de sa période de validité du semestre
	 * Remplie la hashtable numEtu, son score
	 */
	private void etablirScore(){
		//TODO récupérer l'université de l'étudiant
		//TODO Récupérer ses notes avec un appel distant de son université
		scoreEtu=new Hashtable<String, Integer>();
		while(listeNotesEtudiants.keys().hasMoreElements()){
			String numEtuTmp = listeNotesEtudiants.keys().nextElement();
			Note[] noteEtuTmp = listeNotesEtudiants.get(numEtuTmp);
			Integer score = new Integer(0);
			int moyPos = 0;
			int moyValid = 0;
			for(int i=0; i<noteEtuTmp.length; i++){
				int pos = IUniversiteImpl.testPos(noteEtuTmp[i]);
				int valid = IUniversiteImpl.testValid(noteEtuTmp[i]);
				moyPos += pos;
				moyValid +=valid;
			}
			score = (moyPos+moyValid)/6;
			scoreEtu.put(numEtuTmp, score);
		}

	}

	private static int testPos(Note n){
		int pos = n.position;
		int score = 0;
		if (pos == 1){
			score = 4;
		}else if (pos == 2){
			score = 3;
		}else if (pos == 3){
			score = 2;
		}else if (pos == 4){
			score = 1;
		}

		return score;
	}

	private static int testValid(Note n){
		int score = 0;
		String valid = n.validation;
		if(valid.equals("s1")){
			score = 3;
		}else if(valid.equals("s2")){
			score = 2;
		}else if(valid.equals("R")){
			score = 1;
		}
		return score;
	}

	public ArrayList<Voeu> triBulle(ArrayList<Voeu> tabV){
		int longueur=tabV.size();
		boolean permut;

		do
		{
			// hypothèse : le tableau est trié
			permut=false;
			for (int i=0 ; i<longueur-1 ; i++)
			{
				// Teste si 2 éléments successifs sont dans le bon ordre ou non
				// En fonction du score de l'étudiant qui a fait le voeu
				if (scoreEtu.get(tabV.get(i).noE)  > scoreEtu.get(tabV.get(i+1).noE))
				{
					// s'ils ne le sont pas on échange leurs positions
					Voeu voeuPermut = tabV.get(i);
					tabV.add(i, tabV.get(i+1));
					tabV.add(i+1, voeuPermut);
					permut=true;
				}
			}
		}
		while(permut);

		return tabV;
	}

	/**
	 * Permet d'établir les premières listes en fonction des quotas et score
	 */
	private void etablirListe(){
		while(listeVoeuxDiplome.keys().hasMoreElements()){
			//pour le premier diplome
			String dipTmp = listeVoeuxDiplome.keys().nextElement();
			ArrayList<Voeu> listeVoeuxTmp = listeVoeuxDiplome.get(dipTmp);
			int quota = quotaDiplome.get(dipTmp);
			for (int i=0; i <quota && i<listeVoeuxTmp.size(); i++){
				try {
					ajouterListePrincipale(listeVoeuxTmp.get(i));
				} catch (voeuNonTrouve e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(listeVoeuxTmp.size()>=quota){
				for (int j=quota; j<listeVoeuxTmp.size(); j++){
					
				}
			}

		}
	}
}
