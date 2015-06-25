package pMinistere;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContext;

import Applications.PeriodeApplication;
import ClientsServeurs.ClientGestionVoeuGV;
import ClientsServeurs.ClientMinistereGV;
import pRectorat.Diplome;
import pRectorat.NiveauEtude;
import pUniversite.IUniversite;
import pUniversite.IUniversiteHelper;
import utilitaires.utils;

public class IMinistereImpl extends IMinisterePOA {
	private static ArrayList<Diplome> referenciel;
	private static ArrayList<String> rectorats;

	/**
	 * Stockage période en cours au sein du ministère.
	 */
	public static String periode_en_cours;
	public static org.omg.CORBA.ORB orb;
	public static NamingContext nameRoot;
	public static String nomObj;

	public IMinistereImpl(ORB orb, NamingContext nameRoot, String nomObj) {

		this.orb = orb;
		this.nameRoot = nameRoot;
		this.nomObj = nomObj;

		this.periode_en_cours = getPeriodeEnCours();

		referenciel = new ArrayList<Diplome>();
		rectorats = new ArrayList<String>();

		// initialiserReferenciel("C:/Users/"+System.getProperty("user.name"
		// )+"/git/APLV3/APLV1/src/formations.csv");
		// initialiserRectorats("C:/Users/"+System.getProperty("user.name"
		// )+"/git/APLV3/APLV1/src/rectoratsTest.csv");
		initialiserReferenciel("src/formations.csv");
		initialiserRectorats("src/rectoratsTest.csv");
	}

	/**
	 * Renvoie le référentiel de tous les diplomes.
	 */
	@Override
	public Diplome[] getReferenciel() {
		Diplome[] ref = new Diplome[referenciel.size()];
		for (int i = 0; i < referenciel.size(); i++) {
			ref[i] = referenciel.get(i);
			System.out.println(ref[i].libelle);
		}

		System.out.println("taille : " + ref.length);
		return ref;
	}

	/**
	 * Renvoie l'ensemble des rectorats.
	 */
	@Override
	public String[] getRectorats() {
		System.out.println("GET LES RECTORATS");
		String[] rect = new String[rectorats.size()];
		for (int i = 0; i < rectorats.size(); i++) {
			rect[i] = rectorats.get(i);
			System.out.println("Académie : " + rect[i]);
		}
		return (rect);
	}

	/**
	 * Initialisation du référentiel des diplome par lecture de fichier.
	 * 
	 * @param path
	 */
	private void initialiserReferenciel(String path) {
		String lineRead;
		String[] lineSplit;
		String idD = "";
		String libelle = "";
		String niveauEtude = "";
		NiveauEtude ne = null;

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			lineRead = br.readLine();

			while ((lineRead = br.readLine()) != null) {
				lineSplit = lineRead.split(";", 3);
				for (int i = 0; i < lineSplit.length; i++) {
					switch (i) {
					case 0:
						idD = lineSplit[0];
						break;
					case 1:
						libelle = lineSplit[1];
						break;
					case 2:
						niveauEtude = lineSplit[2];
						if (niveauEtude == "L") {
							ne = NiveauEtude.licence;
						} else
							ne = NiveauEtude.master;
					default:
						break;
					}
				}
				Diplome d = new Diplome(libelle, ne);
				referenciel.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialisation de la liste des rectorats par lectude de fichier.
	 * 
	 * @param path
	 */
	private void initialiserRectorats(String path) {
		String lineRead;
		String[] lineSplit;
		String idRectorat = "";

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			lineRead = br.readLine();

			while ((lineRead = br.readLine()) != null) {
				idRectorat = lineRead;
				rectorats.add(idRectorat);
			}
			System.out.println("Taille de la liste de rectorats : "
					+ rectorats.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Changement de période pour tous les rectorats. L'appel aux méthodes de
	 * chaque rectorat permet de rester flexible en cas d'ajout de nouveaux
	 * rectorats.
	 */
	public static void changerPeriodeGlobal() {
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
					periode_en_cours = PeriodeApplication.PERIODE_2.toString();
				} else if (p.getProperty("periode").equals(
						PeriodeApplication.PERIODE_2.toString())) {
					p.setProperty("periode",
							PeriodeApplication.PERIODE_3.toString());
					periode_en_cours = PeriodeApplication.PERIODE_3.toString();


				} else if (p.getProperty("periode").equals(
						PeriodeApplication.PERIODE_3.toString())) {
					p.setProperty("periode",
							PeriodeApplication.PERIODE_4.toString());
					periode_en_cours = PeriodeApplication.PERIODE_4.toString();
				}
				// Enregistrement
				p.store(fos, null);
				fos.close();
			} catch (FileNotFoundException e1) {
				System.out.println("Echec écriture properties");
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Parcours des rectorats pour appeler leurs méthodes changerPériode
		System.out.println("Changement de période =>");
		// Changement de période en distant aux rectorats
		for (String rectorat : rectorats) {
			System.out.println("=> effectué dans : " + rectorat);
			ClientMinistereGV cgv = new ClientMinistereGV(orb, nameRoot,
					nomObj, rectorat+"_GestionVoeux");
			cgv.changerPeriode();
		}

	}

	public static void main(String[] args) {
		IMinistereImpl im = new IMinistereImpl(orb, nameRoot, nomObj);
		System.out.println(im.getRectorats().length);
	}

	@Override
	/**
	 * Renvoie la période de l'application.
	 * Celle-ci est contenue dans un properties.
	 * @return la période en cours
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
			periode_en_cours = p.getProperty("periode");
			return p.getProperty("periode");
		} else {
			return "Erreur lors de la récupération de la période.";
		}
	}

}
