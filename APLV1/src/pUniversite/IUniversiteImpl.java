package pUniversite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContext;

import pRectorat.Accred;
import pRectorat.DecisionEtudiant;
import pRectorat.Diplome;
import pRectorat.Etat;
import pRectorat.Etudiant;
import pRectorat.EtudiantNonTrouve;
import pRectorat.NiveauEtude;
import pRectorat.Voeu;
import Applications.ApplicationUniversite;
import ClientsServeurs.ClientUniversiteGV;
import ClientsServeurs.ClientUniversiteUniv;

public class IUniversiteImpl extends IUniversitePOA{

	/**
	 * Nom de l'université (pour récupération des bons fichiers).
	 */
	private String nomUniversite;
	//pour un diplome, les diplomes acceptés pour postuler. Etabli par l'universitaire
	private static Hashtable<String, Diplome[]> preRequis;
	//nombre de places disponibles pour une formation dans l'université
	private static Hashtable<String, Integer> quotaDiplome;
	//le score minimum pour être potentiellement accepté. Etabli par l'universitaire
	private static Hashtable<String, Integer> seuilScoreDiplome;
	// liste des notes pour un étudiant
	private Hashtable<String,Note[]> listeNotesEtudiants;
<<<<<<< HEAD
	private static Hashtable<String, String> listeUniversitaires;
=======
	private static Hashtable<String, String> listeUniversitaires;  
>>>>>>> branch 'master' of https://github.com/corentinPRQ/APLV2

	private ArrayList<Voeu> listePrincipale;
	private ArrayList<Voeu> listeComplementaire;
	private ArrayList<Voeu> listeRefuse;
	private ArrayList<Voeu> listeCandidatures;

	/*private static org.omg.CORBA.ORB orb;
	private static NamingContext nameRoot;
	private static String nomObj;*/

	// accréditations de l'université
	private static Accred[] listeAccred;
	//key : libelle diplome, voeux demandant le diplome
	private Hashtable<String,ArrayList<Voeu>> listeVoeuxDiplome;

	//key idEtudiant, son score
	private Hashtable<String,Integer> scoreEtu;
<<<<<<< HEAD

	private String idObj = ApplicationUniversite.getIdentiteUniversite() + "_Gestion";
	private ClientUniversiteGV cugv;
	private ClientUniversiteUniv cuu;
=======
>>>>>>> branch 'master' of https://github.com/corentinPRQ/APLV2

	public IUniversiteImpl(Hashtable<String, String> listeU, ORB orb, NamingContext nameRoot, String nomObj ) {
		super();

		//initialisation des listes 
		this.listeCandidatures = new ArrayList<Voeu>();
		this.listePrincipale = new ArrayList<Voeu>();
		this.listeComplementaire = new ArrayList<Voeu>();
		this.listeRefuse = new ArrayList<Voeu>();

<<<<<<< HEAD
		IUniversiteImpl.quotaDiplome = new Hashtable<String, Integer>();
		IUniversiteImpl.seuilScoreDiplome = new Hashtable<String, Integer>();
=======
		quotaDiplome = new Hashtable<String, Integer>();
		seuilScoreDiplome = new Hashtable<String, Integer>();
>>>>>>> branch 'master' of https://github.com/corentinPRQ/APLV2
		this.listeVoeuxDiplome = new Hashtable<String, ArrayList<Voeu>>();
		this.scoreEtu=new Hashtable<String, Integer>();
		
		// initialisation des fichiers
		IUniversiteImpl.preRequis = new Hashtable<String, Diplome[]>();
		this.nomUniversite = ApplicationUniversite.getIdentiteUniversite().nomUniv;
		initialiserPrerequis("src/prerequis"+nomUniversite+".csv");

		this.listeNotesEtudiants = new Hashtable<String, Note[]>();
		initialiserNotesEtudiant("src/notes.csv");

		IUniversiteImpl.listeUniversitaires = listeU;

		/*this.orb = orb;
		this.nameRoot = nameRoot;
<<<<<<< HEAD
		this.nomObj = nomObj;*/

		// méthode appelée par l'universitaire pour consulter les voeux
		cugv = new ClientUniversiteGV(orb, nameRoot, nomObj, idObj);

		// méthode appelée par l'universitaire pour récupérer les notes d'un étudiant
		cuu = new ClientUniversiteUniv(orb, nameRoot, nomObj, idObj);


=======
		this.nomObj = nomObj;
		
		
>>>>>>> branch 'master' of https://github.com/corentinPRQ/APLV2
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
		int seuilScore=0;

		//variable comptant le nombre de lignes du fichier par diplome
		int cpteur = 0;
		String numDipPrecedent = "";
		String nomDipPrecedent = "";
		NiveauEtude ne = null;
		Diplome[] diplomes = new Diplome[10];

		//Hasthable pour les quotas des masters
	
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));	 
			lineRead = br.readLine();

			while ((lineRead = br.readLine()) != null) {
				lineSplit = lineRead.split(";",8);
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
					case 7 : seuilScore = Integer.parseInt(lineSplit[7]);
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
				if(!quotaDiplome.containsKey(nomDip)){
					quotaDiplome.put(nomDip, quota);
				}
				if (!seuilScoreDiplome.containsKey(nomDip)){
					seuilScoreDiplome.put(nomDip, seuilScore);
				}
				Diplome d = new Diplome(nomDipPR, ne);
				diplomes[cpteur] = d;
				cpteur++;

			}
			System.out.println("Enregistrement de " +cpteur+ " diplomes prerequis pour le diplome : " + nomDipPrecedent +"\n\n");
			preRequis.put(nomDip, diplomes);
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
		try {
			this.etablirListe();
		} catch (voeuNonTrouve e) {
			System.err.println("Le voeu ne peut pas être ajouté à une liste car il n'est pas dans la liste des candidatures");
			e.printStackTrace();
		}

	}

	/**
	 * permet de remplir la hashtable diplome/liste voeux pour ce diplome
	 * @param tabVoeux
	 */
	private void remplirVoeuxDip(Voeu[] tabVoeux){
		ArrayList<Voeu> tabVoeuxDip = new ArrayList<Voeu>();
		//on charge les voeux dans le tableau des candidatures
		for (int i=0;i<tabVoeux.length; i++){
			listeCandidatures.add(tabVoeux[i]);
			try {
				//on charge les notes de l'étudiants s'il n'est pas de cette univ
				this.chargerNotesEtuExt(tabVoeux[i].noE);
			} catch (EtudiantNonTrouve e) {
				System.err.println("Vérification des voeux : Etudiant non trouvé");
			}
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
<<<<<<< HEAD
=======
		//TODO récupérer l'université de l'étudiant
		//TODO Récupérer ses notes avec un appel distant de son université
>>>>>>> branch 'master' of https://github.com/corentinPRQ/APLV2
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

	/**
	 * Donne un nombre de point pour établir le score en fonction de la position de l'étudiant par rappor à sa promo
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
	 * Donne un nombre de points en fonction de la période de validation du semestre (session1, 2 ou redoublement)
	 * @param n
	 * @return
	 */
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
	 * @throws voeuNonTrouve 
	 */
	private void etablirListe() throws voeuNonTrouve{
		//On parcourt la hashtable diplome/voeux
		while(listeVoeuxDiplome.keys().hasMoreElements()){
			String dipTmp = listeVoeuxDiplome.keys().nextElement();
			//On récupère les voeux sur ce diplome
			ArrayList<Voeu> listeVoeuxTmp = listeVoeuxDiplome.get(dipTmp);
			//On récupère le quota défini par l'universitaire concernant le diplome
			int quota = quotaDiplome.get(dipTmp);
			//Tant qu'il y a de la place pour la promo ET que le score de l'étudiant est conforme au pré-requis,
			// on rempli la liste principale, sachant que le voeux sont déjà triés par ordre de pertinance
			int i=0;
			while ( i<quota && i<listeVoeuxTmp.size() && scoreEtu.get(listeVoeuxTmp.get(i).noE)>seuilScoreDiplome.get(dipTmp)){
				listeVoeuxTmp.get(i).etatVoeu = Etat.liste_principale;
				ajouterListePrincipale(listeVoeuxTmp.get(i));
				cugv.setEtatVoeu(listeVoeuxTmp.get(i), Etat.liste_principale);
				i++;
			}
			//S'il y a plus de places disponible ou que les scores ne respectent pas les pré-requis, on met en liste secondaire ou refus
			if(listeVoeuxTmp.size()>=quota){
				int cptV=quota;
				//tant qu'il reste des voeux donc le score de l'étudiant est suppérieur au score pré-requis pour le diplome
				while (cptV<listeVoeuxTmp.size() && scoreEtu.get(listeVoeuxTmp.get(cptV).noE)>seuilScoreDiplome.get(dipTmp)){
					listeVoeuxTmp.get(cptV).etatVoeu = Etat.liste_secondaire;
					ajouterListeComplementaire(listeVoeuxTmp.get(cptV));
					cugv.setEtatVoeu(listeVoeuxTmp.get(cptV), Etat.liste_secondaire);
					cptV++;
				}
				//s'il reste encore des voeux, c'est qu'ils n'ont pas le bon score donc on les refuse
				if(cptV<listeVoeuxTmp.size()){
					for(int cptRefus=cptV;cptRefus<listeVoeuxTmp.size(); cptRefus++){
						listeVoeuxTmp.get(cptRefus).etatVoeu = Etat.refus;
						ajouterListeRejet(listeVoeuxTmp.get(cptRefus));
						cugv.setEtatVoeu(listeVoeuxTmp.get(cptRefus), Etat.refus);
					}
				}
			}else{ //le quota n'est pas remplis mais les étudiants suivants ont un score qui ne respecte pas les pré-requis
				while(i<listeVoeuxTmp.size()){
					listeVoeuxTmp.get(i).etatVoeu = Etat.refus;
					ajouterListeRejet(listeVoeuxTmp.get(i));
					cugv.setEtatVoeu(listeVoeuxTmp.get(i), Etat.refus);
					i++;
				}
			}
			
			/*******************************************************************************
			 * REGLE METIER : on ne tient pas compte du nombre d'élèves dans le promotion  *
			 * s'il n'y a qu'un élève qui a le bon score, il sera le premier de la classe  *
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
<<<<<<< HEAD

	/**
	 * Permet de charger
	 * @throws EtudiantNonTrouve 
	 */
	private void chargerNotesEtuExt(String noEtu) throws EtudiantNonTrouve{
		//On récupère l'objet étudiant correspondant à son numéro
		Etudiant etuTmp = cugv.getEtudiant(noEtu);
		//On regarde si l'étudiant est de cette université ou d'une autre
		if(etuTmp.formation.libelleU.replace(" ", "").toLowerCase().equals(nomUniversite.replace(" ", "").toLowerCase())){
			//s'il n'est pas cette université, il faut demander ses notes à la sienne
			listeNotesEtudiants.put(noEtu, cuu.getNotes(etuTmp));
		}
	}


=======
	
	
>>>>>>> branch 'master' of https://github.com/corentinPRQ/APLV2
}
