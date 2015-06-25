package utilitaires;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class utils {
	public static Properties load(String filename) throws IOException, FileNotFoundException{
		Properties properties = new Properties();

		FileInputStream input = new FileInputStream(filename); 
		try{

			properties.load(input);
			input.close();

		}catch(Exception e){
			System.out.println("Problème ouverture de fichier.");
		}
		return properties;

		
	}

}
