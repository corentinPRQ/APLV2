/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import pRectorat.DecisionEtudiant;
import pRectorat.Etat;
import pRectorat.Voeu;
import ClientsServeurs.ClientEtudiantGV;

/**
 *
 * @author Pierre
 */
public class IHM_RepondreVoeu extends javax.swing.JFrame {

	private static ClientEtudiantGV clientEtuGV;
	/**
	 * tableau des voeux de l'�tudiant pour pouvoir afficher le "meilleur"
	 */
	public Voeu[] listeVoeux;
	/**
	 * Le voeu � afficher et pour lequel une d�cision doit �tre prise.
	 */
	private Voeu voeuAffiche=null;
	
    /**
     * Creates new form IHM_RepondreVoeu
     */
    public IHM_RepondreVoeu(ClientEtudiantGV pClientEtuGV, Voeu[] lesVoeux) {
    	clientEtuGV = pClientEtuGV;
    	listeVoeux = lesVoeux;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textFielMeilleurVoeu = new javax.swing.JTextField();
        btnOui = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        btnNon = new javax.swing.JButton();
        btnOuiMais = new javax.swing.JButton();
        btnNonMais = new javax.swing.JButton();
        btnRetour = new javax.swing.JButton();

        //D�finition du meilleur voeu.
        setMeilleurVoeu();
        textFielMeilleurVoeu.setEnabled(false);
        if(voeuAffiche!=null){
        	textFielMeilleurVoeu.setText(voeuAffiche.acreditation.libelleD + " � "+voeuAffiche.acreditation.libelleU);
        }else{
        	textFielMeilleurVoeu.setText("Aucun voeu n'est disponible pour vous.");
        }
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("R�ponse au meilleur voeu.");

        jLabel2.setText("Vous �tes accept�(e) pour : ");


        btnOui.setText("Oui");
        btnOui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOuiActionPerformed(evt);
            }
        });

        jLabel4.setText("Votre choix : ");
        
        btnOui.setText("Oui");
        if(voeuAffiche==null){
        	btnOui.setEnabled(false);
        }
        btnOui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOuiActionPerformed(evt);
            }
        });
        btnNon.setText("Non");
        if(voeuAffiche==null){
        	btnNon.setEnabled(false);
        }
        btnNon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNonActionPerformed(evt);
            }
        });
        btnOuiMais.setText("Oui Mais...");
        if(voeuAffiche==null){
        	btnOuiMais.setEnabled(false);
        }
        btnOuiMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOuiMaisActionPerformed(evt);
            }
        });
        btnNonMais.setText("Non Mais...");
        if(voeuAffiche==null){
        	btnNonMais.setEnabled(false);
        }
        btnNonMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNonMaisActionPerformed(evt);
            }
        });
        btnRetour.setText("Retour");
        btnRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRetour)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnOui)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnNon)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnOuiMais)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnNonMais))
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(textFielMeilleurVoeu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textFielMeilleurVoeu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOui)
                    .addComponent(btnNon)
                    .addComponent(btnOuiMais)
                    .addComponent(btnNonMais))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(btnRetour)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * D�cision oui d'un �tudiant pour le voeu affich�.
     * @param evt
     */
    private void btnOuiActionPerformed(java.awt.event.ActionEvent evt) {
    	IHM_RepondreVoeu.clientEtuGV.repondreProposition(DecisionEtudiant.oui, voeuAffiche);
    }
    
    /**
     * D�cision oui mais d'un �tudiant pour le voeu affich�.
     * @param evt
     */
    private void btnOuiMaisActionPerformed(java.awt.event.ActionEvent evt) {
    	IHM_RepondreVoeu.clientEtuGV.repondreProposition(DecisionEtudiant.oui_mais, voeuAffiche);
    }
    
    /**
     * D�cision non d'un �tudiant pour le voeu affich�.
     * @param evt
     */
    private void btnNonActionPerformed(java.awt.event.ActionEvent evt) {
        IHM_RepondreVoeu.clientEtuGV.repondreProposition(DecisionEtudiant.non, voeuAffiche);
    }
    
    /**
     * D�cision non mais d'un �tudiant pour le voeu affich�.
     * @param evt
     */
    private void btnNonMaisActionPerformed(java.awt.event.ActionEvent evt) {
    	IHM_RepondreVoeu.clientEtuGV.repondreProposition(DecisionEtudiant.non_mais, voeuAffiche);
    }
    
    private void btnRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOuiActionPerformed
        this.setVisible(false);
    	this.dispose();
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
            java.util.logging.Logger.getLogger(IHM_RepondreVoeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IHM_RepondreVoeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IHM_RepondreVoeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IHM_RepondreVoeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	//TODO changer le null, voir apr�s tests
                new IHM_RepondreVoeu(clientEtuGV, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNon;
    private javax.swing.JButton btnNonMais;
    private javax.swing.JButton btnOui;
    private javax.swing.JButton btnOuiMais;
    private javax.swing.JButton btnRetour;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField textFielMeilleurVoeu;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Donne le "meilleur" voeu pour l'�tudiant
     */
    private void setMeilleurVoeu(){
    	if(listeVoeux!=null){
    		for (Voeu voeu : listeVoeux) {
				if(voeu.etatVoeu.equals(Etat.liste_principale)){
					voeuAffiche = voeu;
				}
    		}
    	}
    }
}
