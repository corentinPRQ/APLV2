/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.util.Hashtable;

import pRectorat.Diplome;
import pUniversite.IUniversiteImpl;

/**
 *
 * @author Corentin
 */
public class IHM_FairePrerequis extends javax.swing.JFrame {

	private Hashtable<String, Diplome[]> preRequis;

	/**
	 * Creates new form IHM_FairePrerequis
	 */
	public IHM_FairePrerequis() {
		initComponents();
		preRequis=IUniversiteImpl.getPreRequis();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jl_Titre = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		jcb_Master = new javax.swing.JComboBox();
		jl_MAster = new javax.swing.JLabel();
		jcb_Licence = new javax.swing.JComboBox();
		jl_Licence = new javax.swing.JLabel();
		jb_Ajouter = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jt_Prerequis = new javax.swing.JTable();
		jb_Enregistrer = new javax.swing.JButton();
		jb_Supprimer = new javax.swing.JButton();
		btn_Annuler = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jl_Titre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		jl_Titre.setText("Etablir des prerequis");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap(64, Short.MAX_VALUE)
						.addComponent(jl_Titre)
						.addGap(35, 35, 35))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jl_Titre)
						.addContainerGap())
				);

		jcb_Master.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
		jcb_Master.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jcb_MasterActionPerformed(evt);
			}
		});

		jl_MAster.setText("Diplome Presente : ");

		jcb_Licence.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
		jcb_Licence.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jcb_LicenceActionPerformed(evt);
			}
		});

		jl_Licence.setText("Diplome Requis : ");

		jb_Ajouter.setText("Ajouter");
		jb_Ajouter.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_AjouterActionPerformed(evt);
			}
		});

		jt_Prerequis.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null},
						{null, null, null, null, null}
				},
				new String [] {
						"Master", "Licence", "Moyenne Fran�ais", "Moyenne Maths", "Moyenne Anglais"
				}
				) {
			boolean[] canEdit = new boolean [] {
					false, false, false, false, false
			};

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit [columnIndex];
			}
		});
		jScrollPane1.setViewportView(jt_Prerequis);

		jb_Enregistrer.setText("Enregistrer");
		jb_Enregistrer.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_EnregistrerActionPerformed(evt);
			}
		});

		jb_Supprimer.setText("Supprimer");
		jb_Supprimer.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jb_SupprimerActionPerformed(evt);
			}
		});

		btn_Annuler.setText("Annuler");
		btn_Annuler.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_AnnulerActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
						.addContainerGap())
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel2Layout.createSequentialGroup()
												.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jb_Ajouter)
														.addGroup(jPanel2Layout.createSequentialGroup()
																.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																		.addComponent(jl_Licence, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addComponent(jl_MAster, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
																		.addGap(21, 21, 21)
																		.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																				.addComponent(jcb_Master, 0, 184, Short.MAX_VALUE)
																				.addComponent(jcb_Licence, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
																				.addGap(0, 0, Short.MAX_VALUE))
																				.addGroup(jPanel2Layout.createSequentialGroup()
																						.addComponent(jb_Enregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGap(18, 18, 18)
																						.addComponent(jb_Supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGap(18, 18, 18)
																						.addComponent(btn_Annuler, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
				);
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jcb_Master, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jl_MAster))
								.addGap(9, 9, 9)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jcb_Licence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jl_Licence))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jb_Ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(24, 24, 24)
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, Short.MAX_VALUE)
										.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jb_Enregistrer)
												.addComponent(jb_Supprimer)
												.addComponent(btn_Annuler)))
				);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(110, 110, 110)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap())
				);

		pack();
	}// </editor-fold>                        

	private void jb_AjouterActionPerformed(java.awt.event.ActionEvent evt) {                                           
		// TODO add your handling code here:
	}                                          

	private void jcb_LicenceActionPerformed(java.awt.event.ActionEvent evt) {                                            
		// TODO add your handling code here:
	}                                           

	private void jcb_MasterActionPerformed(java.awt.event.ActionEvent evt) {                                           
		// TODO add your handling code here:
	}                                          

	private void jb_EnregistrerActionPerformed(java.awt.event.ActionEvent evt) {                                               
		// TODO add your handling code here:
	}                                              

	private void btn_AnnulerActionPerformed(java.awt.event.ActionEvent evt) {                                            
		// TODO add your handling code here:
	}                                           

	private void jb_SupprimerActionPerformed(java.awt.event.ActionEvent evt) {                                             
		// TODO add your handling code here:
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
			java.util.logging.Logger.getLogger(IHM_FairePrerequis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(IHM_FairePrerequis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(IHM_FairePrerequis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(IHM_FairePrerequis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new IHM_FairePrerequis().setVisible(true);
			}
		});
	}

	private void chargerPrerequisTable(){
		for (int i=0; i<preRequis.size();i++){
			jt_Prerequis.setValueAt(preRequis.get(i)[0], i, 0);
			jt_Prerequis.setValueAt(arg0, i, 1);
			jt_Prerequis.setValueAt(arg0, i, 2);
			jt_Prerequis.setValueAt(arg0, i, 3);
			jt_Prerequis.setValueAt(arg0, i, 4);
			jt_Prerequis.setValueAt(arg0, i, 5);
			jt_Prerequis.setValueAt(arg0, i, 6);
			jt_Prerequis.setValueAt(arg0, i, 7);
			jt_Prerequis.setValueAt(arg0, i, 8);
			
		}
		
		
		
	}

	// Variables declaration - do not modify                     
	private javax.swing.JButton btn_Annuler;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton jb_Ajouter;
	private javax.swing.JButton jb_Enregistrer;
	private javax.swing.JButton jb_Supprimer;
	private javax.swing.JComboBox jcb_Licence;
	private javax.swing.JComboBox jcb_Master;
	private javax.swing.JLabel jl_Licence;
	private javax.swing.JLabel jl_MAster;
	private javax.swing.JLabel jl_Titre;
	private javax.swing.JTable jt_Prerequis;
	// End of variables declaration                   
}
