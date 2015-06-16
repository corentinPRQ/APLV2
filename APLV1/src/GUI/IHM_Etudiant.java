/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.SwingUtilities;

import pRectorat.Etudiant;
import pRectorat.Voeu;
import Applications.ApplicationGestionEtudiant;
import Applications.PeriodeApplication;
import ClientsServeurs.ClientEtudiantGV;

/**
 *
 * @author guilhem
 */
public class IHM_Etudiant extends javax.swing.JFrame {

	private static ClientEtudiantGV clientEtuGV;
	private static Etudiant etu; // l'�tudiant connect�.

	//private ApplicationGestionEtudiant applicationGE;
	public static Voeu[] listeVoeux;
	private static Hashtable<String, String> listeEtudiants;
	public Etudiant utilisateur;

    public javax.swing.JLabel getLb_nomEtud() {
		return lb_nomEtud;
	}

	public void setLb_nomEtud(String nomEtud) {
		this.lb_nomEtud.setText(nomEtud);
	}

	/**
     * Creates new form IHM_Etudiant
     */

    public IHM_Etudiant(ClientEtudiantGV pCliEtGV) {
    	IHM_Etudiant.clientEtuGV = pCliEtGV;
    	ConnexionEtudiant coE = new ConnexionEtudiant(this,pCliEtGV);
    	coE.setVisible(true);
    	setVisible(false);
    	initComponents();
    }
    


  /* public IHM_Etudiant(ArrayList<Voeu> lesVoeux, Hashtable<String, String> lesEtus) {

        initComponents();

        
    	ConnexionEtudiant coE = new ConnexionEtudiant(this, listeEtudiants);
    	listeVoeux = lesVoeux;
    	System.out.println("Taille de la liste de Voeux de l'ihm : " + listeVoeux.size());
    	listeEtudiants = lesEtus;
        coE.setVisible(true);
    	this.setVisible(false);
        applicationGE = new ApplicationGestionEtudiant();
        
        //il faut tester si l'id du premier voeu = 0 pour savoir s'il y a des voeux � afficher.
        if(listeVoeux.size()>=1 && !listeVoeux.get(0).idV.equals("listeVide")){
        	//afficher les voeux dans le tableau
        	
        }

    }*/

    public static Etudiant getEtu() {
		return etu;
	}

	public static void setEtu(Etudiant etu) {
		IHM_Etudiant.etu = etu;
	}

	public static ClientEtudiantGV getClientEtuGV() {
		return clientEtuGV;
	}

	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tab_voeux = new javax.swing.JScrollPane();
        tab_VoeuxEtudiant = new javax.swing.JTable();
        lb_titreTableau = new javax.swing.JLabel();
        lb_titre = new javax.swing.JLabel();
        lb_connecteEnTantQue = new javax.swing.JLabel();
        lb_nomEtud = new javax.swing.JLabel();
        bt_ajouterVoeux = new javax.swing.JButton();
        bt_repondreVoeu = new javax.swing.JButton();
        bt_modifAdress = new javax.swing.JButton();
        bt_quitter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tab_VoeuxEtudiant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Voeu", "Etat", "Reponse Universit�", "R�ponse etudiant"
            }
        ));
        tab_voeux.setViewportView(tab_VoeuxEtudiant);

        lb_titreTableau.setText("Voeux de l'�tudiant");

        lb_titre.setText("Interface �tudiant");

        lb_connecteEnTantQue.setText("Connect� en tant que :");

        lb_nomEtud.setText("Nom de l'�tudiant");

        bt_ajouterVoeux.setText("Ajouter un voeu");
        
        bt_ajouterVoeux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ajouterVoeuxActionPerformed(evt);
            }
        });

        bt_repondreVoeu.setText("R�pondre � un voeu");
        if(!clientEtuGV.getPeriodeEnCours().equals(PeriodeApplication.PERIODE_3.toString())){
        	bt_repondreVoeu.setEnabled(false);
        }
        bt_repondreVoeu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_repondreVoeuActionPerformed(evt);
            }
        });

        bt_modifAdress.setText("Modifier profil (adresse)");
        bt_modifAdress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_modifAdressActionPerformed(evt);
            }
        });

        bt_quitter.setText("Quitter");
        bt_quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_quitterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lb_connecteEnTantQue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_nomEtud, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_titre)
                .addGap(360, 360, 360))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(bt_modifAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(373, 373, 373)
                        .addComponent(bt_quitter))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_titreTableau)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tab_voeux, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bt_repondreVoeu, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bt_ajouterVoeux, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_titre)
                    .addComponent(lb_connecteEnTantQue)
                    .addComponent(lb_nomEtud))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_modifAdress)
                .addGap(18, 18, 18)
                .addComponent(lb_titreTableau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tab_voeux, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(bt_ajouterVoeux)
                        .addGap(18, 18, 18)
                        .addComponent(bt_repondreVoeu)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(bt_quitter)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_modifAdressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_modifAdressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_modifAdressActionPerformed

    private void bt_quitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_quitterActionPerformed
    	this.dispose();
    }

    private void bt_ajouterVoeuxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ajouterVoeuxActionPerformed
    		IHM_FaireUnVoeu ihm_fv = new IHM_FaireUnVoeu(this,clientEtuGV);
    		ihm_fv.setVisible(true);
    }//GEN-LAST:event_bt_ajouterVoeuxActionPerformed

    private void bt_repondreVoeuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_repondreVoeuActionPerformed
        IHM_RepondreVoeu IHM_Rep = new IHM_RepondreVoeu(clientEtuGV, listeVoeux);
        IHM_Rep.setVisible(true);
    }
    
    public void remplirTableVoeu(){
    	IHM_Etudiant.listeVoeux=IHM_Etudiant.clientEtuGV.consulterListeVoeux(etu);
    	for(int i=0;i<listeVoeux.length;i++){
    		//mettre la formation en cours de l'�tudiant ainsi que l'universit� dans laquelle il postule
//    		sysout;
    		tab_VoeuxEtudiant.setValueAt(listeVoeux[i].acredVoeu.libelleD,i, 0);
    		tab_VoeuxEtudiant.setValueAt(listeVoeux[i].etatVoeu.toString(),i, 1);
    		tab_VoeuxEtudiant.setValueAt("nexiste pas dans le voeu",i, 2);
    		tab_VoeuxEtudiant.setValueAt(listeVoeux[i].decEtudiant,i, 3);
    	}
    	//refres
    	SwingUtilities.updateComponentTreeUI(this.tab_voeux);
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
            java.util.logging.Logger.getLogger(IHM_Etudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IHM_Etudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IHM_Etudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IHM_Etudiant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new IHM_Etudiant(clientEtuGV).setVisible(false);

                //new IHM_Etudiant(listeVoeux, listeEtudiants).setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ajouterVoeux;
    private javax.swing.JButton bt_modifAdress;
    private javax.swing.JButton bt_quitter;
    private javax.swing.JButton bt_repondreVoeu;
    private javax.swing.JLabel lb_connecteEnTantQue;
    private javax.swing.JLabel lb_nomEtud;
    private javax.swing.JLabel lb_titre;
    private javax.swing.JLabel lb_titreTableau;
    private javax.swing.JTable tab_VoeuxEtudiant;
    private javax.swing.JScrollPane tab_voeux;
    // End of variables declaration//GEN-END:variables
}
