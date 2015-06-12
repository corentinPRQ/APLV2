package pMinistere;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import pRectorat.Diplome;
import pRectorat.NiveauEtude;

public class IMinistereImpl extends IMinisterePOA {
	private ArrayList<Diplome> referenciel;
	private ArrayList<String> rectorats;

	public IMinistereImpl() {
		referenciel = new ArrayList<Diplome>();
		rectorats = new ArrayList<String>();
		initialiserReferenciel("src/formations.csv");
		initialiserRectorats("src/rectorats.csv");
	}

	@Override
	public Diplome[] getReferenciel() {
		Diplome[] ref = new Diplome[referenciel.size()];
		for (int i=0; i<referenciel.size(); i++){
			ref[i]=referenciel.get(i);
			System.out.println(ref[i].libelle);
		}
	
		System.out.println("taille : "+ ref.length);
		return ref;			
	}
	

	@Override
	public String[] getRectorats() {
		System.out.println("GET LES RECTORATS");
		String[] rect = new String[rectorats.size()];
		for (int i=0; i<rectorats.size(); i++){
			rect[i] = rectorats.get(i);
			System.out.println("Académie : " + rect[i]);
		}
		return (rect);
	}
	
	private void initialiserReferenciel(String path){
		String lineRead;
		String[] lineSplit;
		String idD="";
		String libelle="";
		String niveauEtude="";
		NiveauEtude ne=null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));	 
			lineRead = br.readLine();

			while ((lineRead = br.readLine()) != null) {
				lineSplit = lineRead.split(";",3);
				for (int i=0; i<lineSplit.length; i++){
					switch(i){  
					case 0: idD = lineSplit[0];
					break;
					case 1: libelle = lineSplit[1];
					break;
					case 2 : niveauEtude = lineSplit[2];
						if (niveauEtude == "L"){
							ne=NiveauEtude.licence;
						}
						else ne = NiveauEtude.master;
					default : 
						break;
					}
				}
				Diplome d = new Diplome(libelle, ne);
				referenciel.add(d);
			}

		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	private void initialiserRectorats(String path){
		String lineRead;
		String[] lineSplit;
		String idRectorat="";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));	 
			lineRead = br.readLine();

			while ((lineRead = br.readLine()) != null) {
				idRectorat = lineRead;
				rectorats.add(idRectorat);
			}
			System.out.println("Taille de la liste de rectorats : " + rectorats.size());
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args){
		IMinistereImpl im = new IMinistereImpl();
		System.out.println(im.getRectorats().length);
	}
	
}
