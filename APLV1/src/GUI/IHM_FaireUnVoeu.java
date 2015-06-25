/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import pRectorat.Accred;
import pRectorat.DecisionEtudiant;
import pRectorat.Etat;
import pRectorat.Rectorat;
import pRectorat.Voeu;
import ClientsServeurs.ClientEtudiantGV;

/**
 *
 */
public class IHM_FaireUnVoeu extends javax.swing.JFrame {

	private static ClientEtudiantGV clientEtuGV;
	public static IHM_Etudiant parent;
	private Accred[] lesAccred;
	private Accred [] lesAccredExternes;
	private Hashtable<String, ArrayList<String>> regroupementAccred ;
	private String idRectorat;

	/**
	 * Creates new form IHM_FaireUnVoeu
	 */
	public IHM_FaireUnVoeu(IHM_Etudiant pParent, ClientEtudiantGV pClientEtuGV) {
		parent = pParent;
		clientEtuGV = pClientEtuGV;
		lesAccred = IHM_FaireUnVoeu.clientEtuGV.getListeAccreditation();
		lesAccredExternes= IHM_FaireUnVoeu.clientEtuGV.getListeAccreditationExternes();
		idRectorat=IHM_FaireUnVoeu.clientEtuGV.getIdRectorat();
		regroupementAccred=new Hashtable<String,ArrayList<String>>();
		initComponents();
		this.regrouperAccred();
		this.chargerLesDiplomes();
		
	}
	
	//Fonction permettant de scinder les deux listes d'accreditations dans une hashtable en vue du remplissage des listes 
	private void regrouperAccred(){
		//Premier Element de la liste : On instancie l'arraylist des université et on put le premier diplome avec son université
		
		ArrayList<String> lesUniv = new ArrayList<String>();
		lesUniv.add(lesAccred[0].libelleU);
		regroupementAccred.put(lesAccred[0].libelleD,lesUniv);
		
		//La boucle va maintenant parcourir l'ensemble des accreditations internes dans la hashtable
		for(int i=1;i<lesAccred.length;i++){
			// Verification que l'accredition concerne un master 1
			if(lesAccred[i].libelleD.contains("M1")){
				//On verifie si dans l'accredition que l'on analyse si le diplome est deja dans la hashtable
				if(regroupementAccred.containsKey(lesAccred[i].libelleD)){
					regroupementAccred.get(lesAccred[i].libelleD).add(lesAccred[i].libelleU);
				}else{
					//Si le diplome n'existe pas en clé de la hashtable on crée une nouvelle clé diplome et on instancie une nouvelle liste d'université 
					lesUniv = new ArrayList<String>();
					lesUniv.add(lesAccred[i].libelleU);
					regroupementAccred.put(lesAccred[i].libelleD,lesUniv);
				}
			}
		}
		
		for(int i=0;i<lesAccredExternes.length;i++){
		// Verification que l'accredition concerne un master 1
	      if(lesAccredExternes[i].libelleD.contains("M1")){
				//On verifie si dans l'accredition que l'on analyse si le diplome est deja dans la hashtable
				if(regroupementAccred.containsKey(lesAccredExternes[i].libelleD)){
					regroupementAccred.get(lesAccredExternes[i].libelleD).add(lesAccredExternes[i].libelleU);
				}else{
					//Si le diplome n'existe pas en clé de la hashtable on crée une nouvelle clé diplome et on instancie une nouvelle liste d'université 
					lesUniv = new ArrayList<String>();
					lesUniv.add(lesAccredExternes[i].libelleU);
					regroupementAccred.put(lesAccredExternes[i].libelleD,lesUniv);
				}
	      }
		}
		
	
	}
		
	
	private void chargerLesDiplomes() {
		// TODO Auto-generated method stub
		int itemCount = cb_diplome.getItemCount();

	    for(int i=0;i<itemCount;i++){
	        cb_diplome.removeItemAt(0);
	     }
	    
	    /*
	    Obtenir les valeurs dans un énumérateur
	    */
	  Enumeration e = regroupementAccred.keys();
	   
	  //Parourir et afficher les valeurs
	  while(e.hasMoreElements())
		  cb_diplome.addItem(e.nextElement().toString());
	  
	 }
	   /*
	    //Remplissage de la jcombobox avec la premiere liste d'accreditation (les internes au rectorat)
		cb_diplome.addItem(lesAccred[0].libelleD);
		for (int i = 1; i < lesAccred.length-1; i++) {
			if(!lesAccred[i-1].libelleD.equals(lesAccred[i].libelleD)){
				cb_diplome.addItem(lesAccred[i].libelleD);
			}
		}*/
		
		
	private String getNoAccred(){
		boolean trouve =false;
		String noAccred="";
		int i=0;
		
		while(i<lesAccred.length||trouve!=false){
			if(cb_diplome.getSelectedItem().toString().equals(lesAccred[i].libelleD)
					&&cb_universite.getSelectedItem().toString().equals(lesAccred[i].libelleD)){
				trouve=true;
				noAccred=lesAccred[i].noAccred;
				return noAccred;
			}
			i++;
		}
		return "problème Accreditation non trouvée";
		
	}
	
	private void chargerUniversité() {
		int itemCount = cb_universite.getItemCount();

	    for(int i=0;i<itemCount;i++){
	        cb_universite.removeItemAt(0);
	     }
	    
		for(int i=0;i< regroupementAccred.get(cb_diplome.getSelectedItem().toString()).size();i++){
				cb_universite.addItem(regroupementAccred.get(cb_diplome.getSelectedItem().toString()).get(i));
		}
		
	}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lb_diplome = new javax.swing.JLabel();
        cb_diplome = new javax.swing.JComboBox();
        bt_Valider = new javax.swing.JButton();
        bt_Annuler = new javax.swing.JButton();
        lb_Univ = new javax.swing.JLabel();
        cb_universite = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Faire un voeu");

        lb_diplome.setText("Diplome");

        cb_diplome.setModel(new javax.swing.DefaultComboBoxModel());
        cb_diplome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_diplomeActionPerformed(evt);
            }
        });

        bt_Valider.setText("Valider");
        bt_Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ValiderActionPerformed(evt);
            }
        });

        bt_Annuler.setText("Retour");
        bt_Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_AnnulerActionPerformed(evt);
            }
        });

        lb_Univ.setText("Université");

        cb_universite.setModel(new javax.swing.DefaultComboBoxModel());
        cb_universite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_universiteActionPerformed(evt);
            }
        });
        
        
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(lb_diplome, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_diplome, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_Valider)))
                .addGap(51, 51, 51)
                .addComponent(lb_Univ)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_Annuler)
                    .addComponent(cb_universite, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_diplome)
                    .addComponent(cb_diplome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_Univ)
                    .addComponent(cb_universite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Valider)
                    .addComponent(bt_Annuler))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void bt_ValiderActionPerformed(java.awt.event.ActionEvent evt) { 
    	Accred accredVoeu= new Accred(getNoAccred(),cb_diplome.getSelectedItem().toString(),cb_universite.getSelectedItem().toString());
    	String nomRectDest = IHM_FaireUnVoeu.clientEtuGV.getRectoratUniversite(accredVoeu.libelleU);
    	Boolean trouve=false;
    	int i=0;
    	
    	Voeu voeu = new Voeu(parent.utilisateur.noEtu, parent.utilisateur.formation ,accredVoeu, new Rectorat(idRectorat), new Rectorat(nomRectDest),DecisionEtudiant.cree,Etat.cree);
    	//Avant de faire le voeu on va vérifier qu'il n'existe pas déja

    	while(i<IHM_Etudiant.listeVoeux.length && trouve!=true)
    	{    		if(IHM_Etudiant.listeVoeux[i].acredVoeu.libelleD.equals(voeu.acredVoeu.libelleD) 
    				&& IHM_Etudiant.listeVoeux[i].acredVoeu.libelleU.equals(voeu.acredVoeu.libelleU)){

    	while(i<parent.listeVoeux.length && !trouve)
    	{
    		if(parent.listeVoeux[i].acredFormation.libelleD.equals(voeu.acredFormation.libelleD) 
    				&& parent.listeVoeux[i].acredFormation.libelleU.equals(voeu.acredFormation.libelleU)){S
    			trouve=true;
    		}
    		i++;
    	}
    	
    	//Dans le cas ou le voeu n'existe pas le voeu va être enregistré

    	if(!trouve){
    		clientEtuGV.faireVoeu(voeu);
         	
        	//On ne renvoi pas les voeux des autres académies là...
        	parent.remplirTableVoeu();
         	
         	
         	parent.repaint();
         	SwingUtilities.updateComponentTreeUI(parent);
         	
         	JOptionPane.showMessageDialog(this, "Voeu bien Enregistré");
    	}else{
    		JOptionPane.showMessageDialog(this, "Ce voeu existe deja, validation impossible");
    	}
    	 
    }                                          

    private void bt_AnnulerActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    	this.dispose();
    	this.setVisible(false);
    }                                          

    private void cb_universiteActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void cb_diplomeActionPerformed(java.awt.event.ActionEvent evt) {                                           
       this.chargerUniversité();
    }  
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IHM_FaireUnVoeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IHM_FaireUnVoeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IHM_FaireUnVoeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IHM_FaireUnVoeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IHM_FaireUnVoeu(parent,clientEtuGV).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton bt_Annuler;
    private javax.swing.JButton bt_Valider;
    private javax.swing.JComboBox<String> cb_diplome;
    private javax.swing.JComboBox cb_universite;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lb_Univ;
    private javax.swing.JLabel lb_diplome;
    // End of variables declaration                   
}
