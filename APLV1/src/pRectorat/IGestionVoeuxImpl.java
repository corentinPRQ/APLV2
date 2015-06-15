package pRectorat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContext;

import pUniversite.IUniversite;
import pUniversite.IUniversiteHelper;
import utilitaires.utils;
import Applications.PeriodeApplication;
import ClientsServeurs.ClientGestionVoeuGV;
import ClientsServeurs.ClientGestionVoeuxMinistere;

public class IGestionVoeuxImpl extends IGestionVoeuxPOA {
	public static org.omg.CORBA.ORB orb;
	public static NamingContext nameRoot;
	public static String nomObj;

	public static ArrayList<String> mesRectorats;
	// nom/ior
	public static Hashtable<String, String> mesUniversites;

	//Voeux en fonction du num�ro d'�tudiant

	//Voeux en fonction du num�ro d'�tudiant
	public static Hashtable<String, Voeu[]> listeVoeux;
	//Voeux qui sont fait dans d'autres rectorats
	public static Hashtable<String, Voeu[]> listeVoeuxExternes;


	public static Accred[] lesAccredIntern;
	//pour les rectorats ext, leurs accreds correspondantes
	public static Hashtable<String,Accred[]> lesAccredExternRect;
	private Hashtable<String,Etudiant> listeEtudiant;
	public static String idRectorat="";

	/**
	 * Constante nombre de voeux max pour gestion tableaux.
	 */

	private final static int NB_VOEUX_MAX = 5;
	//constructeur par d�faut
	public IGestionVoeuxImpl(ORB orb, NamingContext nameRoot, String nomObj,String pidRectorat){
		//Liste d'accr�ditation � charger avec un fichier
		this.orb = orb;
		this.nameRoot = nameRoot;
		this.nomObj = nomObj;
		System.out.println(pidRectorat);
		this.idRectorat=pidRectorat;

		mesRectorats = new ArrayList<String>();
		mesUniversites = new Hashtable<String, String>();
		listeVoeux = new Hashtable<String, Voeu[]>();
		listeEtudiant=new Hashtable<String, Etudiant>();
		lesAccredExternRect = new Hashtable<String, Accred[]>();
		listeVoeuxExternes = new Hashtable<String, Voeu[]>();

		mesRectorats = getLesRectorats();
		initialiserEtudiants("src/usersEtu"+pidRectorat+".csv");
		initialiserAccred("src/Accreditation"+pidRectorat+".csv");
	}

	/**
	 * Identification d'un �tudiant
	 * (Car les �tudiants sont contenus dans leur rectorat).
	 * @param login
	 * @param mdp
	 * @return
	 * @throws EtudiantNonTrouve
	 */
	public boolean identifier(String login, String mdp)
			throws EtudiantNonTrouve {
		System.out.println("Identification depuis le rectorat");
		if (!listeEtudiant.containsKey(login)) {
			// mettre un code GUI pour notifier de l'erreur d'identification
			throw new EtudiantNonTrouve();
		} else {
			System.out.println(listeEtudiant.get(login).mdp);
			if (!listeEtudiant.get(login).mdp.equals(mdp)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Accred[] getListeAccreditations() {
		return lesAccredIntern;
	}

	public static Hashtable<String,Accred[]> getLesAccredExterne(){
		ArrayList<Accred> tempAccred=new ArrayList<Accred>();
		Accred[] tempAccredRecupExterieur;
		for(int i=0;i<mesRectorats.size();i++){
			//Verifie que le rectorat que l'on va appeller n'est pas celui dans lequel on est
			if(!mesRectorats.get(i).equals(IGestionVoeuxImpl.idRectorat)){
				// nom de l'objet 
				System.out.println("Connexion avec le rectorat "+mesRectorats.get(i)+"_GestionVoeux");
				//Cas d'une connexion avec un GestionVoeux : 
				String idObj = mesRectorats.get(i)+"_GestionVoeux";
				// Construction du nom a enregistrer
				String nomObj = "ClientGVGV";

				System.out.println("lancement du client GV");
				ClientGestionVoeuGV ce = new ClientGestionVoeuGV(orb, nameRoot, nomObj, idObj);

				//Recup�ration des Accreditation d'un autre rectorat et stockage dans un tableau temporaire
				tempAccredRecupExterieur=ce.getListeAccreditation();
				int tailleArrayAccred = tempAccred.size();

				int iterateurAccredRecup=0;
				//Boucle permettant de remplir l'arraylistTemporaire qui recense l'ensemble des accreditation r�cup�r�es
				for(int y=tailleArrayAccred;y<tailleArrayAccred+tempAccredRecupExterieur.length;y++){
					tempAccred.add(tempAccredRecupExterieur[iterateurAccredRecup]);
					iterateurAccredRecup++;
				}

				lesAccredExternRect.put(mesRectorats.get(i), tempAccredRecupExterieur);
			}

		}

		/*Accred[] tabARetourner= new Accred[tempAccred.size()];
		for(int i=0;i<tempAccred.size();i++){
			tabARetourner[i]=tempAccred.get(i);
		}*/
		return lesAccredExternRect;

	}

	/**
	 * Renvoie tous les voeux le return est un tableau de voeux qui peut
	 * contenir des valeurs null � la fin
	 */
	@Override
	public Voeu[] getVoeux() {


		Collection<Voeu[]> colV = this.listeVoeux.values();
		int taille = colV.size();
		// on cr�e un tableau de voeux en fonction de la taille max potentielle
		Voeu[] tabV = new Voeu[5 * taille];
		int i = 0;
		Iterator<Voeu[]> itV = colV.iterator();
		// On parcourt la collection de Voeu[5] de la HM
		while (itV.hasNext()) {
			Voeu[] tabVTmp = new Voeu[5];
			tabVTmp = itV.next();
			// on parcourt les 5 voeux potentiel
			for (int j = 0; tabVTmp[j] != null && j < tabVTmp.length; j++) {
				tabV[i] = tabVTmp[j];
				i++;
			}
		}

		if (tabV.length != 0) {
			System.out.println(tabV.length);
			return tabV;
		} else {
			Voeu v = new Voeu("0", new Accred(), new Rectorat(),new Rectorat(),null,
					null);
			Voeu[] lesV = new Voeu[1];
			lesV[0] = v;
			return (lesV);
		}

	}

	/**
	 * Permet de modifier la d�cision de l'�tudiant sur un voeu
	 * 
	 * @param pDecision
	 * @param v
	 * @throws VoeuNonTrouve
	 */
	@Override
	public void repondreVoeu(DecisionEtudiant pDecision, Voeu v)
			throws VoeuNonTrouve {
		v.decEtudiant = pDecision;
	}

	/**
	 * Validation des voeux en fonction des pr�queris
	 * @param v
	 * @throws VoeuNonTrouve
	 * @throws EtudiantNonTrouve 
	 */
	private void validerVoeu(Voeu v) throws VoeuNonTrouve, EtudiantNonTrouve {
		String idObj = v.acreditation.libelleU + "_Gestion";
		String iorTmp = mesUniversites.get(v.acreditation.libelleU.replace(" ", ""));
		org.omg.CORBA.Object distantObj = orb.string_to_object(iorTmp);
		IUniversite monUniv = IUniversiteHelper.narrow(distantObj);

		boolean prerequisOK = false;
		//On r�cup�re les accred pour un diplome
		String dipV = v.acreditation.libelleD;
		Diplome[] pr = monUniv.getListePrerequis(dipV);
		//On r�cup�re le diplome de l'�tudiant qui a fait le voeu
		String formaEtu = getUtilisateur(v.noE).formation.libelleD;
		for (int i = 0; i < pr.length; i++) {
			if (pr[i].libelle.equals(formaEtu)) {
				prerequisOK = true;
				break;
			}
		}

		if (prerequisOK) {
			this.setEtatVoeu(v, Etat.valide_encours);
		} else {
			this.setEtatVoeu(v, Etat.non_valide);
		}
	}

	@Override
	/**
	 * Changer l'�tat d'un voeu
	 * @param v : le voeu
	 * @param e : nouvel �tat
	 */
	public void setEtatVoeu(Voeu v, Etat e) {

		switch (v.etatVoeu.value()) {
		// Le voeu est cr�e il peut passer "Valide en cours" ou "Non Valide"
		case Etat._cree:
			if (e == Etat.valide_encours || e == Etat.non_valide)
				v.etatVoeu = e;
			break;
			// Le voeu est "Valide en cours" il peut passer "liste principale"
			// "liste secondaire" "refus"
		case Etat._valide_encours:
			if (e == Etat.liste_principale || e == Etat.liste_secondaire
			|| e == Etat.refus)
				v.etatVoeu = e;
			break;
			// Le voeu est en liste secondaire il peut passer en refus
		case Etat._liste_secondaire:
			if (e == Etat.refus)
				v.etatVoeu = e;
			break;
		default:
			System.err
			.println("Le voeu est dans un �tat dans lequel il ne peux pas changer d'�tat : "
					+ v.etatVoeu.toString());
			break;

		}
	}

	/**
	 * CHangement de p�riode de l'application
	 */
	public static void changerPeriode() {
		// La m�thode consiste en une MAJ du properties
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
				if (p.getProperty("periode").equals(
						PeriodeApplication.PERIODE_1.toString())) {
					p.setProperty("periode",
							PeriodeApplication.PERIODE_2.toString());
				} else if (p.getProperty("periode").equals(
						PeriodeApplication.PERIODE_2.toString())) {
					p.setProperty("periode",
							PeriodeApplication.PERIODE_3.toString());
				} else if (p.getProperty("periode").equals(
						PeriodeApplication.PERIODE_3.toString())) {
					p.setProperty("periode",
							PeriodeApplication.PERIODE_4.toString());
				}
				// Enregistrement
				p.store(fos, null);
			} catch (FileNotFoundException e1) {
				System.out.println("Echec �criture properties");
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Renvoie la liste des voeux pour alimentation des IHM
	 * @param etu
	 * @return
	 */
	@Override
	public Voeu[] consulterListeVoeu(Etudiant etu) {
		System.out.println("consulterListeVoeu "+etu.noEtu);
		//S'il n'y a pas de voeux internes
		if (!listeVoeux.containsKey(etu.noEtu)){
			//S'il n'y a pas de voeux externes
			if(!listeVoeuxExternes.containsKey(etu.noEtu)){
				//Bouchon pour ne pas renvoyer NULL et satisfaire CORBA.
				Voeu v = new Voeu( "0", new Accred("1", "d1", "PS"), new Rectorat("Midi-Pyrenees"),new Rectorat("Midi-Pyrenees"), DecisionEtudiant.non,
						Etat.cree);
				Voeu[] lesV = new Voeu[1];
				lesV[0] = v;
				System.out.println("return liste Vide");
				return (lesV);
			}
			else{
				//Sinon on n'a que des voeux externes et on renvoi les voeux externe
				return listeVoeuxExternes.get(etu.noEtu);
			}
		}
		else{
			//Sinon on a des voeux internes, et on regarde s'il y a des voeux externes
			System.out.println("return les voeux");
			if(listeVoeuxExternes.containsKey(etu.noEtu)){
				Voeu[] lesV = new Voeu[listeVoeux.get(etu.noEtu).length+listeVoeuxExternes.get(etu.noEtu).length];

				for (int i=0; i<listeVoeux.get(etu.noEtu).length; i++){
					lesV[i] = listeVoeux.get(etu.noEtu)[i];
				}
				for (int i=listeVoeux.get(etu.noEtu).length, j=0; i<lesV.length; i++, j++){
					lesV[i] = listeVoeuxExternes.get(etu.noEtu)[j];
				}
				return lesV;
			}
			else{
				return listeVoeux.get(etu.noEtu);
			}
		}
	}

	/**
	 * Permet d'enregistrer un voeu dans la liste des voeux
	 */
	@Override
	public void faireVoeu(Voeu v) throws VoeuNonTrouve, EtudiantNonTrouve {
		//Tester si on est dans le bon rectorat ou pas
		System.out.println("on rentre dans faire voeux");
		System.out.println(v.idRDest.nomAcademie+ " ET "+ idRectorat);
		if(v.idRDest.nomAcademie.equals(idRectorat)){
			//Cr�ation d'un voeu dans ce rectorat
			System.out.println("on est dans le if");
			enregistrerVoeu(v);
			//			validerVoeu(v);
		}else{
			//trouver le bon rectorat pour y cr�er le voeu
			System.out.println("je suis dans le else");
			String nomRect = v.idRDest.nomAcademie+"_GestionVoeux"; 
			ClientGestionVoeuGV cgv = new ClientGestionVoeuGV(orb, nameRoot, nomObj, nomRect);
			cgv.faireVoeu(v);
			enregistrerVoeuxExterne(v);
		}

	}


	/**
	 * 
	 * Enregistrement du voeu qui est fait dans un rectorat externe
	 * @param v
	 */
	public void enregistrerVoeuxExterne(Voeu v){
		if(listeVoeuxExternes.containsKey(v.noE)){

			Voeu[] lesVoeux = listeVoeuxExternes.get(v.noE);
			Voeu[] listeVoeu = new Voeu[lesVoeux.length+1];

			int nbV=0;
			for (int i=0; i<lesVoeux.length; i++){
				listeVoeu[i]=lesVoeux[i];
				nbV=i;
			}
			listeVoeu[nbV] = v;
			listeVoeuxExternes.put(v.noE, listeVoeu);
		}
		else{
			Voeu[] leVoeu = new Voeu[1];
			leVoeu[0] = v;
			listeVoeuxExternes.put(v.noE,  leVoeu);
		}
	}

	/**
	 * Enregistrement du voeu � proprement dit : dans la liste contenu dans le rectorat.
	 * @param v
	 */
	private void enregistrerVoeu(Voeu v) {
		System.out.println(">Enregistrement dun voeu.");
		//Si l'�tudiant a d�j� des voeux, on les r�cup�re.
		if(listeVoeux.containsKey(v.noE)){
			Voeu[] tabV = IGestionVoeuxImpl.listeVoeux.get(v.noE);
			//Combien l'�tudiant a de voeux ? 
			//Indice dans lequel on va ins�rer.
			int insertion = tabV.length;
			if (insertion<NB_VOEUX_MAX) {
				//On r�cup�re les anciens voeux pour y ajouter les nouveaux.
				Voeu[] aInserer = new Voeu[insertion+1];
				for(int i=0; i<insertion; i++){
					aInserer[i]=tabV[i];
				}
				aInserer[insertion] = v;
				//On r�percute les modifications su la liste.
				IGestionVoeuxImpl.listeVoeux.put(v.noE, aInserer);
				System.out.println(">Le voeu est enregistr�.");
			} else {
				System.err.println("D�j� 5 voeux ont �t� faits.");
			}
		}else{
			//Cas o� l'�tudiant n'a pas de voeux.
			//Cr�ation d'un tableau de 1 voeu.
			Voeu[] tabV = new Voeu[1];
			tabV[0] = v;
			listeVoeux.put(v.noE, tabV);
			System.out.println(">On a put un premier voeu pour l'�tuiant "+v.noE);
		}

	}



	private void initialiserEtudiants(String path) {
		String lineRead;
		String[] lineSplit;
		String login = "";
		String mdp = "";
		String nom="";
		String univ="";
		String diplome="";



		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			lineRead = br.readLine();

			while ((lineRead = br.readLine()) != null) {
				lineSplit = lineRead.split(";", 5);
				// System.out.println("line split users : "+ lineSplit[0] +
				// " - " + lineSplit[1] + " - " + lineSplit[2] + " - "
				// +lineSplit[3]);
				for (int i = 0; i < lineSplit.length; i++) {
					switch (i) {
					case 0:
						login = lineSplit[0];
						break;
					case 1:
						mdp = lineSplit[1];
						break;
					case 2:
						nom=lineSplit[2];
						break;
					case 3 : 
						diplome = lineSplit[3];
						break;
					case 4 : 
						univ = lineSplit[4];
						break;
					default:
						break;
					}
				}
				// System.out.println("Login : "+login + " - mdp : "+mdp);
				this.listeEtudiant.put(login, new Etudiant(login,nom,mdp,new Accred("1", diplome, univ)));

			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void initialiserAccred(String path) {
		/*
		 * R�fl�chir � un moyen d'int�grer les notes pour les pr�requis! 
		 */
		System.out.println("INITIALISATION DES LES ACCREDS DE LUNIVERSITE");
		String lineRead;
		String[] lineSplit;
		String universite="";
		String diplome="";
		String noAccred="";


		//variable comptant le nombre de lignes du fichier par diplome
		int cpteur = 0;
		String DipPrecedent = "";
		ArrayList<Accred> listAccred = new ArrayList<Accred>();



		try {
			BufferedReader br = new BufferedReader(new FileReader(path));	 
			lineRead = br.readLine();

			while ((lineRead = br.readLine()) != null) {
				lineSplit = lineRead.split(";",3);
				//				System.out.println("line split : "+ lineSplit[0] + " - " + lineSplit[1] + " - " + lineSplit[2] + " - " +lineSplit[3]);
				for (int i=0; i<lineSplit.length; i++){
					switch(i){ 
					case 0 : noAccred= lineSplit[0];
					break;
					case 1 : diplome= lineSplit[1];
					break;
					case 2 : universite = lineSplit[2];
					break;
					default : System.err.println("Erreur dans la lecture du fichier");
					break;
					}					
				}
				listAccred.add(new Accred(noAccred,diplome,universite));

				/*//si le num�ro etudiant est diff�rent du pr�c�dent c'est qu'on chang� d'�tudiant, donc on enregistre ses notes
//				System.out.println("NumDIP : " + numDip + " - numDipPrecedent : " + numDipPrecedent);
				if (!Diplome.equals(DipPrecedent)){
					lesUniv = new String[list.size()];
					for(int i=0;i<list.size();i++){
						lesUniv[i]=list.get(i);
					}
					this.listeAccreditation.put(DipPrecedent,lesUniv);
					list=new ArrayList<String>();
				}

				DipPrecedent = Diplome;

				list.add(Universite);
				 */

			}
			br.close();
			/*lesUniv = new String[list.size()];
			for(int i=0;i<list.size();i++){
				lesUniv[i]=list.get(i);*/

			//} this.listeAccreditation.put(Diplome, lesUniv);
			lesAccredIntern=new Accred[listAccred.size()];
			for(int i=0;i<listAccred.size();i++){
				lesAccredIntern[i]=listAccred.get(i);
			}		
			noAccred="";
			listAccred = new ArrayList<Accred>();

			//			lesUniv = new String[list.size()];

		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public void afficherAccred(){
		for(int i = 0;i<lesAccredIntern.length;i++){
			System.out.println(lesAccredIntern[i].toString());
		}
	}

	public void afficherLesEtu(){
		Enumeration nb=listeEtudiant.elements();
		Object key;
		while(nb.hasMoreElements()) {
			key=nb.nextElement();
			Etudiant value=(Etudiant) key;
			System.out.println("cle = "+ key + "" + value.toString() );
		}
	}

	@Override
	public Etudiant getUtilisateur(String numeroEtudiant)
			throws EtudiantNonTrouve {

		System.out.println(listeEtudiant.get(numeroEtudiant));
		return(listeEtudiant.get(numeroEtudiant));
	}



	@Override
	public String getIdRectorat() {
		return this.idRectorat;
	}


	@Override
	/**
	 * Renvoie la p�riode de l'application.
	 * Celle-ci est contenue dans un properties.
	 * @return la p�riode en cours
	 */
	public String getPeriodeEnCours() {
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
			return p.getProperty("periode");
		}else{
			return "Erreur lors de la r�cup�ration de la p�riode.";
		}
	}




	public ArrayList<String> getLesRectorats(){
		ClientGestionVoeuxMinistere cgm = new ClientGestionVoeuxMinistere(orb, nameRoot, nomObj, "Ministere");
		return (cgm.recupererRectorat());
	}
	//
	//	/**
	//	 * @return the mesRectorats
	//	 */
	//	public static ArrayList<String> getMesRectorats() {
	//		return mesRectorats;
	//	}
	//
	//	/**
	//	 * @param mesRectorats the mesRectorats to set
	//	 */
	//	public static void setMesRectorats(ArrayList<String> mesRectorats) {
	//		IGestionVoeuxImpl.mesRectorats = mesRectorats;
	//	}
	//
	//	public static void setMesAccredExternes(Accred[] pLesAccredExternes){
	//		IGestionVoeuxImpl.lesAccredExternRect=pLesAccredExternes;
	//	}

	@Override
	public void enregistrerUniversite(String ior, String nom) {
		System.out.println("\n\n\nEnregistrement de l'universit�s" + nom+"\n\n\n");
		mesUniversites.put(nom, ior);
		System.out.println("enregistrement r�alis� - taille = " + mesUniversites.size());

	}

	/**
	 * Main pour test.
	 * @param args
	 * @throws EtudiantNonTrouve
	 * @throws InterruptedException 
	 * @throws InvalidName 
	 */

	public static void main (String [] args) throws EtudiantNonTrouve, InterruptedException, InvalidName{
		System.out.println("Debut du test");

		/*//Il faut le faire qu'une fois!!!!!!
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

		System.out.println("lancement du client Etudiant");*/


		IGestionVoeuxImpl igV=new IGestionVoeuxImpl(orb, nameRoot, nomObj,idRectorat);
		System.out.println("Les Accred Internes");
		for(int i=0;i<lesAccredIntern.length;i++){
			System.out.println(lesAccredIntern[i].noAccred+" "+lesAccredIntern[i].libelleD+" "+lesAccredIntern[i].libelleU);
		}


		//Thread.sleep(50000); // suspendu pendant 5 seconde (chiffre en millisecondes)

		System.out.println("Les rectorats");
		for(int i=0;i<mesRectorats.size();i++){
			System.out.println(mesRectorats.get(i));
		}



		//	 igV.afficherLesEtu();
		//	 System.out.println(igV.identifier("21001324", "hugo"));
		//	 
		//	 System.out.println(igV.getUtilisateur("21001324").nom);
		//	 
		//	 for(int i=0;i<lesAccredIntern.length;i++){
		//		 System.out.println(lesAccredIntern[i].toString());
		//	 }


		// try {
		// igV.validerVoeu(new Voeu("v1", "e1", new Accred("a1", "dip1", "lib1"),
		// new Rectorat("midi-pyrenees"), DecisionEtudiant.oui,
		// Etat.liste_principale));
		// } catch (VoeuNonTrouve e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// }
	}

	@Override
	public Accred[] getListeAccreditationExternes() {
		ArrayList<Accred> listeAccredExt = new ArrayList<Accred>();
		//pour tous les rectorats de la liste
		for(int i=0; i<mesRectorats.size(); i++){
			System.out.println("Taille de la hashtable : " + lesAccredExternRect.size());
			// si le rectorat courant est different du rectorat actuel
			if(!mesRectorats.get(i).equals(idRectorat)){
				//Pour chaque accreditation du rectorat courant 
				for (int j=0; j<lesAccredExternRect.get(mesRectorats.get(i)).length; j++){
					System.out.println("Taille de la liste de la HT : " + lesAccredExternRect.get(mesRectorats.get(i)).length);
					//on ajout l'accreditation dans la liste globale
					listeAccredExt.add(lesAccredExternRect.get(mesRectorats.get(i))[j]);	
				}	
			}
		}

		Accred[] lesAccredsExt =new Accred[listeAccredExt.size()];
		for (int i=0; i< listeAccredExt.size(); i++) {
			lesAccredsExt[i] = listeAccredExt.get(i);
		}

		return lesAccredsExt;
	}

	@Override
	public String getRectoratUniversite(String nomUniv){
		String rect = new String();
		System.out.println("Nom de l'universit� � contacter : " + nomUniv);
		if(mesUniversites.containsKey(nomUniv.replace(" ", ""))){
			return idRectorat;
		} 
		else{

			for(int i=0; i<mesRectorats.size(); i++){
				System.out.println("Taille de la hashtable : " + lesAccredExternRect.size());
				// si le rectorat courant est different du rectorat actuel
				if(!mesRectorats.get(i).equals(idRectorat)){
					//Pour chaque accreditation du rectorat courant 
					for (int j=0; j<lesAccredExternRect.get(mesRectorats.get(i)).length; j++){
						System.out.println("Taille de la liste de la HT : " + lesAccredExternRect.get(mesRectorats.get(i)).length);
						//on ajout l'accreditation dans la liste globale
						if(lesAccredExternRect.get(mesRectorats.get(i))[j].libelleU.equals(nomUniv)){
							return mesRectorats.get(i);
						}
						//listeAccredExt.add(lesAccredExternRect.get(mesRectorats.get(i))[j]);	
					}	
				}
			}
		}
		return ("Pas Trouv�");

	}

}
