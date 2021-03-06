package pUniversite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContext;

import pRectorat.Accred;
import pRectorat.DecisionEtudiant;
import pRectorat.Diplome;
import pRectorat.Etat;
import pRectorat.Etudiant;
import pRectorat.EtudiantNonTrouve;
import pRectorat.IGestionVoeux;
import pRectorat.IGestionVoeuxHelper;
import pRectorat.NiveauEtude;
import pRectorat.Voeu;
import Applications.ApplicationUniversite;
import ClientsServeurs.ClientUniversiteGV;
import ClientsServeurs.ClientUniversiteUniv;

public class IUniversiteImpl extends IUniversitePOA{

	/**
	 * Nom de l'universit� (pour r�cup�ration des bons fichiers).
	 */
	private String nomUniversite;
	//pour un diplome, les diplomes accept�s pour postuler. Etabli par l'universitaire
	private static Hashtable<String, Diplome[]> preRequis;
	//nombre de places disponibles pour une formation dans l'universit�
	private static Hashtable<String, Integer> quotaDiplome;
	//le score minimum pour �tre potentiellement accept�. Etabli par l'universitaire
	private static Hashtable<String, Integer> seuilScoreDiplome;
	// liste des notes pour un �tudiant
	private Hashtable<String,Note[]> listeNotesEtudiants;
	private static Hashtable<String, String> listeUniversitaires;
	// liste de client d'universit�. key : intitule univ/ le client
	private static Hashtable<String, ClientUniversiteUniv> listeClientsUniv;

	private ArrayList<Voeu> listePrincipale;
	private ArrayList<Voeu> listeComplementaire;
	private ArrayList<Voeu> listeRefuse;
	private ArrayList<Voeu> listeCandidatures;

	private static org.omg.CORBA.ORB orb;
	private static NamingContext nameRoot;
	private static String nomObj;

	// accr�ditations de l'universit�
	private static Accred[] listeAccred;
	//key : libelle diplome, voeux demandant le diplome
	private Hashtable<String,ArrayList<Voeu>> listeVoeuxDiplome;

	//key idEtudiant, son score
	private Hashtable<String,Integer> scoreEtu;

	private static ClientUniversiteGV cugv;

	public IUniversiteImpl(Hashtable<String, String> listeU, ORB orb, NamingContext nameRoot, String nomObj ) {
		super();

		//initialisation des listes 
		this.listeCandidatures = new ArrayList<Voeu>();
		this.listePrincipale = new ArrayList<Voeu>();
		this.listeComplementaire = new ArrayList<Voeu>();
		this.listeRefuse = new ArrayList<Voeu>();

		IUniversiteImpl.quotaDiplome = new Hashtable<String, Integer>();
		IUniversiteImpl.seuilScoreDiplome = new Hashtable<String, Integer>();
		this.listeVoeuxDiplome = new Hashtable<String, ArrayList<Voeu>>();
		this.scoreEtu=new Hashtable<String, Integer>();
		IUniversiteImpl.listeClientsUniv = new Hashtable<String, ClientUniversiteUniv>();

		// initialisation des fichiers
		IUniversiteImpl.preRequis = new Hashtable<String, Diplome[]>();
		this.nomUniversite = ApplicationUniversite.getIdentiteUniversite().nomUniv;
		//initialiserPrerequis(""C:/Users/"+System.getProperty("user.name" )+"/git/APLV3/APLV1/src/prerequis"+nomUniversite.trim()+".csv");
		initialiserPrerequis("src/prerequis"+nomUniversite.trim()+".csv");

		this.listeNotesEtudiants = new Hashtable<String, Note[]>();
		//initialiserPrerequis("C:/Users/"+System.getProperty("user.name")+"/git/APLV3/APLV1/src/prerequis.csv");
		initialiserNotesEtudiant("src/notes.csv");
		
		IUniversiteImpl.listeUniversitaires = listeU;

		this.orb = orb;
		this.nameRoot = nameRoot;
		this.nomObj = nomObj;

		// m�thode appel�e par l'universitaire pour consulter les voeux
		String idObj = ApplicationUniversite.getIdentiteUniversite().idR.nomAcademie + "_GestionVoeux";

		System.out.println("\n\n\ninitialisation du client GV depuis l'IMPL \n");

		IUniversiteImpl.cugv = new ClientUniversiteGV(orb, nameRoot, nomObj, idObj);
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
		//changement de p�riode. P4
		//TODO on recharge les voeux et on regarde les d�cisions de l'�tudiant
		for(int i=0; i<listeCandidatures.size(); i++){
			Voeu vTmp = listeCandidatures.get(i);
			if(vTmp.decEtudiant == DecisionEtudiant.oui){
				//on suppr les autres candidatures de l'�tudiant
				i++;
				Voeu vTmp2 = listeCandidatures.get(i);
				//tant que le voeu suivant est du m�me �tudiant
				while(vTmp2.noE.equals(vTmp.noE)){
					//on supprime le voeu suivant des listes
					if(listePrincipale.contains(vTmp2)){
						listePrincipale.remove(vTmp2);
					}else if(listeComplementaire.contains(vTmp2)){
						listeComplementaire.remove(vTmp2);
					}
					i++;
					vTmp2 = listeCandidatures.get(i);
				}
				//on sort quand le voeu est d'un autre �tudiant
				//Pour que le voeu soit analyser dans la prochaine it�ration du for, on fait un i--
				i--;

			}else if(vTmp.decEtudiant == DecisionEtudiant.oui_mais){
				//TODO
			}else if(vTmp.decEtudiant == DecisionEtudiant.non_mais){
				//TODO
			}else if(vTmp.decEtudiant == DecisionEtudiant.non){
				// si l'�tudiant a refus� le voeu, on le supprime des listes
				if(listePrincipale.contains(vTmp)){
					listePrincipale.remove(vTmp);
				}else if(listeComplementaire.contains(vTmp)){
					listeComplementaire.remove(vTmp);
				}
			}
		}
	}

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
	 * Renvoie les diplomes pr�-requis pour postuler � un diplome
	 */
	@Override
	public Diplome[] getListePrerequis(String diplome) {
		System.out.println("Taille de la hashtable : " + preRequis.size());
		if (preRequis.containsKey(diplome)){
			Diplome[] dipPRTmp = preRequis.get(diplome);
			return dipPRTmp;
		}
		else{
			System.err.println("Valeur non trouv�e");
			return null;
		}
	}


	/**
	 * Permet de charger les formations pr�-requis	 
	 * @param path
	 */
	private static void initialiserPrerequis(String path) {
		/*
		 * R�fl�chir � un moyen d'int�grer les notes pour les pr�requis! 
		 */

		String lineRead;
		String[] lineSplit;
		String nomUniv="";
		String nomDip = "";
		String numDipPR="";
		String nomDipPR="";
		int quota =0;
		int seuilScore=0;

		//variable comptant le nombre de lignes du fichier par diplome
		int cpteur = 0;
		NiveauEtude ne = null;
		Diplome[] diplomes = new Diplome[1];

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));	 
			lineRead = br.readLine();

			while ((lineRead = br.readLine()) != null) {
				lineSplit = lineRead.split(";",5);
				//				System.out.println("line split : "+ lineSplit[0] + " - " + lineSplit[1] + " - " + lineSplit[2] + " - " +lineSplit[3]);
				for (int i=0; i<lineSplit.length; i++){
					switch(i){  
					case 0 : nomUniv = lineSplit[0];
					break;
					case 1 : nomDip = lineSplit[1];
					break;
					case 2 : nomDipPR = lineSplit[2];
					break;
					case 3 : quota = Integer.parseInt(lineSplit[3]);
					break;
					case 4 : seuilScore = Integer.parseInt(lineSplit[4]);
					break;
					default : System.err.println("Erreur dans la lecture du fichier");
					break;
					}					
				}
				//				System.out.println("NumDIP : " + numDip + " - numDipPrecedent : " + numDipPrecedent);
				//Si le num�ro diplome est diff�rent du pr�c�dent c'est qu'on chang� de diplome, donc on enregistre ses notes
				if (preRequis.containsKey(nomDip)){
					System.out.println("1 - Diplome "+ nomDip + " trouv� dans la hashtable - nombre des prerequis : " + preRequis.get(nomDip).length);
					//cr�ation d'un tableau de diplome temporaraire qui a une taille + 1 pour l'insertion du nouveau diplome
					cpteur = preRequis.get(nomDip).length;
					Diplome[] aInserer = new Diplome[cpteur+1];
					//r�cup�ration des diplomes de la hashTable du master
					Diplome[] lesDiplomesDuMaster = preRequis.get(nomDip);

					//Cr�ation du diplome a ins�rer
					if (nomDipPR.contains("L3")){
						ne = NiveauEtude.licence;
					}
					else{ 
						ne=NiveauEtude.master;
					}
					Diplome d = new Diplome(nomDipPR, ne);

					//recopie des �l�ments du tableaux de dimplomes dans le nouveau tableau (taille+1) 
					for (int i=0; i<preRequis.get(nomDip).length; i++){
						aInserer[i] = lesDiplomesDuMaster[i];
						System.out.println("nombre de prerequis : " + i+1);
						cpteur = i+1 ;
					}

					//Insertion du nouveau diplome pr�requis dans le tableau de diplme
					//						System.out.println("Insertion - Compteur : " + cpteur);
					aInserer[cpteur]= d;
					//System.out.println("Enregistrement du diplome prerequi\n\n");
					//Ajout du nouveau tableau avec le nouveau diplome prerequis dans la hashtable + ajout du score et du quota
					lesDiplomesDuMaster = aInserer;
					preRequis.put(nomDip, lesDiplomesDuMaster);

					//Gestion des quotas et des scores
					if(!quotaDiplome.containsKey(nomDip)){
						quotaDiplome.put(nomDip, quota);
					}
					if (!seuilScoreDiplome.containsKey(nomDip)){
						seuilScoreDiplome.put(nomDip, seuilScore);
					}

					//						System.out.println("2 - Diplome ins�r� dans la hashtable - nombre des prerequis : " + preRequis.get(nomDip).length);
					//raz des variables.
					diplomes = new Diplome[1];
					cpteur = 0;
				}else {
					//						System.out.println("Diplome pas encore trouv� dans la hashtable!");
					//						System.out.println("Compteur du else : " + cpteur);
					Diplome[] aInserer = new Diplome[cpteur+1];
					if (nomDipPR.contains("L3")){
						ne = NiveauEtude.licence;
					}
					else{ 
						ne=NiveauEtude.master;
					}

					Diplome d = new Diplome(nomDipPR, ne);
					//						System.out.println("NOm dip PR = " + nomDipPR + " Nom ne = " + ne);
					for (int i=0; i<diplomes.length; i++){
						aInserer[i] = diplomes[i];
						cpteur = i;
					}

					aInserer[cpteur]= d;
					cpteur=0;
					diplomes = aInserer;

					//insertion du nouveau diplome
					preRequis.put(nomDip, diplomes);

					//Gestion des quotas et des scores
					if(!quotaDiplome.containsKey(nomDip)){
						quotaDiplome.put(nomDip, quota);
					}
					if (!seuilScoreDiplome.containsKey(nomDip)){
						seuilScoreDiplome.put(nomDip, seuilScore);
					}
				}
			}
			//			System.out.println("Enregistrement de " +cpteur+ " diplomes prerequis pour le diplome : " + nomDipPrecedent +"\n\n");
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Permet de charger les notes d'un �tudiant
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

		//variable comptant le nombre de lignes du fichier par �tudiant
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

	public static void initialiserAccred(){
		listeAccred=cugv.getListeAccredUniversite(ApplicationUniversite.getIdentiteUniversite().nomUniv);
	}

	/**
	 * m�thode appel�e automatiquement par gestionVoeu (rectorat) en d�but de P3 pour faire la v�rif des pr�requis
	 * les pr�requis se basent en fonction d'un score calcul� gr�ce � la position de l'�tudiant et sa session de r�ussite
	 */
	@Override
	public void verifCandidature(Voeu[] tabVoeux) {
		System.out.println("V�rification de la candidature - UNIVERSITE - remplir liste Voeu");
		this.remplirVoeuxDip(tabVoeux);
		System.out.println("V�rification de la candidature - UNIVERSITE - ordonner voeu dip");
		this.ordonnerVoeuxDip();
		try {
			System.out.println("V�rification de la candidature - UNIVERSITE - Etablir les liste");
			this.etablirListe();
		} catch (voeuNonTrouve e) {
			System.err.println("Le voeu ne peut pas �tre ajout� � une liste car il n'est pas dans la liste des candidatures");
			e.printStackTrace();
		}
		System.out.println("Fin verifCandidature - UNIVERSITE");
	}

	/**
	 * permet de remplir la hashtable diplome/liste voeux pour ce diplome
	 * @param tabVoeux
	 */
	private void remplirVoeuxDip(Voeu[] tabVoeux){

		System.out.println("METHODE REMPLIR VOEUX DIP - Universite");
		ArrayList<Voeu> tabVoeuxDip = new ArrayList<Voeu>();
		//on charge les voeux dans le tableau des candidatures
		for (int i=0;i<tabVoeux.length; i++){
			listeCandidatures.add(tabVoeux[i]);
			try {
				//on charge les notes de l'�tudiants s'il n'est pas de cette univ
				this.chargerNotesEtuExt(tabVoeux[i].noE);
			} catch (EtudiantNonTrouve e) {
				System.err.println("V�rification des voeux : Etudiant non trouv�");
			}
		}
		// pour charque accreditation, on construit une hashtable avec un tableau des voeux demandant chaque formation
		System.out.println("Cr�ation de la hashTable Univ-Voeu[]");
		for (int i=0; i<listeAccred.length; i++){
			// on parcours les voeux pour ajouter les voeux par diplome
			
			for(int j=0; j<listeCandidatures.size(); j++){
				if(listeAccred[i]!=null){
					System.out.println(listeCandidatures.get(j).acredVoeu.libelleD);
					System.out.println(listeAccred[i].libelleD);
					if(listeCandidatures.get(j).acredVoeu.libelleD.equals(listeAccred[i].libelleD)){
						tabVoeuxDip.add(listeCandidatures.get(j));
					}
				}
			}
			if (tabVoeuxDip.size()!=0){
				listeVoeuxDiplome.put(listeAccred[i].libelleD, tabVoeuxDip);
			}
			tabVoeuxDip.clear();
		}
		System.out.println("Sortie du remplirVoeuxDIP");
	}

	/**
	 * Permet d'�tablir le score des �tudiants pour trier les voeux par pertinance
	 */
	private void ordonnerVoeuxDip(){
		System.out.println("EtablirScore");
		this.etablirScore();
		
		//classe les voeux par diplome et par score dans listeVoeuxDiplome
		//On parcourt les diplomes dans la hashT de diplome/liste voeux
		Enumeration <String> enumVoeu= listeVoeuxDiplome.keys();
		while(enumVoeu.hasMoreElements()){
			//pour le premier diplome
			String dip = enumVoeu.nextElement();
			//on r�cup�re tous les voeux
			ArrayList<Voeu> tabVoeuxTmp = listeVoeuxDiplome.get(dip);
			//on tri ces voeux en fonction du score
			tabVoeuxTmp = triBulle(tabVoeuxTmp);
			//On remplace l'ancien tableau par le tableau tri�
			listeVoeuxDiplome.put(dip, tabVoeuxTmp);

		}
		System.out.println("Fin de ordonnerVoeuDip");
	}

	/**
	 * Etablie le score de l'�tudiant en fonction de sa position et de sa p�riode de validit� du semestre
	 * Remplie la hashtable numEtu, son score
	 */
	private void etablirScore(){
		System.out.println("Etablir score : ");
		//ATTENTION boucle infinie!!! 
		Enumeration <String> enumNotes= listeNotesEtudiants.keys();
		while(enumNotes.hasMoreElements()){
			String numEtuTmp = enumNotes.nextElement();
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
		System.out.println("Fin du etablir score");
	}

	/**
	 * Donne un nombre de point pour �tablir le score en fonction de la position de l'�tudiant par rappor � sa promo
	 * @param n
	 * @return
	 */
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

	/**
	 * Donne un nombre de points en fonction de la p�riode de validation du semestre (session1, 2 ou redoublement)
	 * @param n
	 * @return
	 */
	private static int testValid(Note n){
		int score = 0;
		String valid = n.validation;
		if(valid.equals("1S")){
			score = 3;
		}else if(valid.equals("2S")){
			score = 2;
		}else if(valid.equals("R")){
			score = 1;
		}
		return score;
	}

	/**
	 * effectue un tri des voeux par diplome en fonction du score
	 * @param tabV
	 * @return
	 */
	public ArrayList<Voeu> triBulle(ArrayList<Voeu> tabV){
		int longueur=tabV.size();
		boolean permut;

		do
		{
			// hypoth�se : le tableau est tri�
			permut=false;
			for (int i=0 ; i<longueur-1 ; i++)
			{
				// Teste si 2 �l�ments successifs sont dans le bon ordre ou non
				// En fonction du score de l'�tudiant qui a fait le voeu
				if (scoreEtu.get(tabV.get(i).noE)  > scoreEtu.get(tabV.get(i+1).noE))
				{
					// s'ils ne le sont pas on �change leurs positions
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
	 * Permet d'�tablir les premi�res listes en fonction des quotas et score
	 * @throws voeuNonTrouve 
	 */
	private void etablirListe() throws voeuNonTrouve{
		Enumeration <String> enumDip = listeVoeuxDiplome.keys();
		//On parcourt la hashtable diplome/voeux
		while(enumDip.hasMoreElements()){
			String dipTmp = enumDip.nextElement();
			//On r�cup�re les voeux sur ce diplome
			ArrayList<Voeu> listeVoeuxTmp = listeVoeuxDiplome.get(dipTmp);
			//On r�cup�re le quota d�fini par l'universitaire concernant le diplome
			int quota = quotaDiplome.get(dipTmp);
			//Tant qu'il y a de la place pour la promo ET que le score de l'�tudiant est conforme au pr�-requis,
			// on rempli la liste principale, sachant que le voeux sont d�j� tri�s par ordre de pertinance
			int i=0;
			while ( i<quota && i<listeVoeuxTmp.size() && scoreEtu.get(listeVoeuxTmp.get(i).noE)>seuilScoreDiplome.get(dipTmp)){
				listeVoeuxTmp.get(i).etatVoeu = Etat.liste_principale;
				ajouterListePrincipale(listeVoeuxTmp.get(i));
				IUniversiteImpl.cugv.setEtatVoeu(listeVoeuxTmp.get(i), Etat.liste_principale);
				i++;
			}
			//S'il y a plus de places disponible ou que les scores ne respectent pas les pr�-requis, on met en liste secondaire ou refus
			if(listeVoeuxTmp.size()>=quota){
				int cptV=quota;
				//tant qu'il reste des voeux donc le score de l'�tudiant est supp�rieur au score pr�-requis pour le diplome
				while (cptV<listeVoeuxTmp.size() && scoreEtu.get(listeVoeuxTmp.get(cptV).noE)>seuilScoreDiplome.get(dipTmp)){
					listeVoeuxTmp.get(cptV).etatVoeu = Etat.liste_secondaire;
					ajouterListeComplementaire(listeVoeuxTmp.get(cptV));
					IUniversiteImpl.cugv.setEtatVoeu(listeVoeuxTmp.get(cptV), Etat.liste_secondaire);
					cptV++;
				}
				//s'il reste encore des voeux, c'est qu'ils n'ont pas le bon score donc on les refuse
				if(cptV<listeVoeuxTmp.size()){
					for(int cptRefus=cptV;cptRefus<listeVoeuxTmp.size(); cptRefus++){
						listeVoeuxTmp.get(cptRefus).etatVoeu = Etat.refus;
						ajouterListeRejet(listeVoeuxTmp.get(cptRefus));
						IUniversiteImpl.cugv.setEtatVoeu(listeVoeuxTmp.get(cptRefus), Etat.refus);
					}
				}
			}else{ //le quota n'est pas remplis mais les �tudiants suivants ont un score qui ne respecte pas les pr�-requis
				while(i<listeVoeuxTmp.size()){
					listeVoeuxTmp.get(i).etatVoeu = Etat.refus;
					ajouterListeRejet(listeVoeuxTmp.get(i));
					IUniversiteImpl.cugv.setEtatVoeu(listeVoeuxTmp.get(i), Etat.refus);
					i++;
				}
			}

			/*******************************************************************************
			 * REGLE METIER : on ne tient pas compte du nombre d'�l�ves dans le promotion  *
			 * s'il n'y a qu'un �l�ve qui a le bon score, il sera le premier de la classe  *
			 *******************************************************************************/
		}
	}

	/**
	 * @return the quotaDiplome
	 */
	public static Hashtable<String, Integer> getQuotaDiplome() {
		return quotaDiplome;
	}


	/**
	 * @param quotaDiplome the quotaDiplome to set
	 */
	public static void setQuotaDiplome(Hashtable<String, Integer> quotaDiplome) {
		IUniversiteImpl.quotaDiplome = quotaDiplome;
	}


	/**
	 * @return the seuilScoreDiplome
	 */
	public static Hashtable<String, Integer> getSeuilScoreDiplome() {
		return seuilScoreDiplome;
	}


	/**
	 * @param seuilScoreDiplome the seuilScoreDiplome to set
	 */
	public static void setSeuilScoreDiplome(
			Hashtable<String, Integer> seuilScoreDiplome) {
		IUniversiteImpl.seuilScoreDiplome = seuilScoreDiplome;
	}

	/**
	 * Permet de charger
	 * @throws EtudiantNonTrouve 
	 */
	private void chargerNotesEtuExt(String noEtu) throws EtudiantNonTrouve{
		System.out.println("M�tode : Charger note Etu Ext - Universite");
		ClientUniversiteUniv cuu = null;
		//On r�cup�re l'objet �tudiant correspondant � son num�ro
		System.out.println("GET ETUDIANT DISTANT : " + cugv);
		Etudiant etuTmp = cugv.getEtudiant(noEtu);

		//On regarde si l'�tudiant est de cette universit� ou d'une autre
		System.out.println("On sort du getEtudiant avec Etu = " + etuTmp.nom);
		if(etuTmp.formation.libelleU.replace(" ", "").toLowerCase().equals(nomUniversite.replace(" ", "").toLowerCase())){
			
			//s'il n'est pas cette universit�, il faut demander ses notes � la sienne
			//On regarde si on a d�j� un client pour cette universit� sinon on en cr�e un
			if(listeClientsUniv.containsKey(etuTmp.formation.libelleU)){
			
				//Corentin : ici jsais pas pourquoi mais il manque le nom de l'universite "NomUniv_Gestion" dans cuu... 
				//On se retrouve a faire un appel qui n'est donc pas bon!
				
				cuu = listeClientsUniv.get(etuTmp.formation.libelleU);
			}else{
				cuu = new ClientUniversiteUniv(orb, nameRoot, noEtu, etuTmp.formation.libelleU.replace(" ","")+"_Gestion");
				listeClientsUniv.put(etuTmp.formation.libelleU, cuu);
			}
			listeNotesEtudiants.put(noEtu, cuu.getNotes(etuTmp));
		}
	}


}
