/*     */ package org.neuroph.easyneurons.dialog;
/*     */ 
/*     */ import javax.swing.GroupLayout;
/*     */ 
/*     */ public class NewNFRStudentDemo extends javax.swing.JInternalFrame
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private javax.swing.JButton jButton1;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JLabel jLabel3;
/*     */   private javax.swing.JLabel jLabel4;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JPanel jPanel2;
/*     */   
/*     */   public NewNFRStudentDemo()
/*     */   {
/*  18 */     initComponents();
/*     */   }
/*     */   
/*     */ 
/*     */   private javax.swing.JPanel jPanel3;
/*     */   private javax.swing.JPanel jPanel4;
/*     */   private javax.swing.JPanel jPanel5;
/*     */   private javax.swing.JPanel jPanel6;
/*     */   private javax.swing.JSlider jSlider1;
/*     */   private javax.swing.JSlider jSlider2;
/*     */   private javax.swing.JTextField jTextField1;
/*     */   private javax.swing.JTextField jTextField2;
/*     */   private void initComponents()
/*     */   {
/*  32 */     this.jPanel1 = new javax.swing.JPanel();
/*  33 */     this.jSlider1 = new javax.swing.JSlider();
/*  34 */     this.jSlider2 = new javax.swing.JSlider();
/*  35 */     this.jTextField1 = new javax.swing.JTextField();
/*  36 */     this.jTextField2 = new javax.swing.JTextField();
/*  37 */     this.jButton1 = new javax.swing.JButton();
/*  38 */     this.jPanel2 = new javax.swing.JPanel();
/*  39 */     this.jPanel3 = new javax.swing.JPanel();
/*  40 */     this.jPanel4 = new javax.swing.JPanel();
/*  41 */     this.jPanel5 = new javax.swing.JPanel();
/*  42 */     this.jPanel6 = new javax.swing.JPanel();
/*  43 */     this.jLabel1 = new javax.swing.JLabel();
/*  44 */     this.jLabel2 = new javax.swing.JLabel();
/*  45 */     this.jLabel3 = new javax.swing.JLabel();
/*  46 */     this.jLabel4 = new javax.swing.JLabel();
/*     */     
/*  48 */     setName("Form");
/*     */     
/*  50 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
/*  51 */     this.jPanel1.setName("jPanel1");
/*  52 */     this.jPanel1.setLayout(new java.awt.GridBagLayout());
/*     */     
/*  54 */     this.jSlider1.setName("jSlider1");
/*  55 */     java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
/*  56 */     gridBagConstraints.fill = 2;
/*  57 */     gridBagConstraints.anchor = 17;
/*  58 */     this.jPanel1.add(this.jSlider1, gridBagConstraints);
/*     */     
/*  60 */     this.jSlider2.setName("jSlider2");
/*  61 */     gridBagConstraints = new java.awt.GridBagConstraints();
/*  62 */     gridBagConstraints.gridx = 0;
/*  63 */     gridBagConstraints.gridy = 1;
/*  64 */     gridBagConstraints.fill = 2;
/*  65 */     gridBagConstraints.anchor = 17;
/*  66 */     this.jPanel1.add(this.jSlider2, gridBagConstraints);
/*     */     
/*  68 */     this.jTextField1.setColumns(7);
/*  69 */     org.jdesktop.application.ResourceMap resourceMap = ((org.neuroph.easyneurons.EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(org.neuroph.easyneurons.EasyNeuronsApplication.class)).getContext().getResourceMap(NewNFRStudentDemo.class);
/*     */     
/*     */ 
/*     */ 
/*  73 */     this.jTextField1.setText(resourceMap.getString("jTextField1.text", new Object[0]));
/*  74 */     this.jTextField1.setName("jTextField1");
/*  75 */     this.jPanel1.add(this.jTextField1, new java.awt.GridBagConstraints());
/*     */     
/*  77 */     this.jTextField2.setColumns(7);
/*  78 */     this.jTextField2.setText(resourceMap.getString("jTextField2.text", new Object[0]));
/*  79 */     this.jTextField2.setName("jTextField2");
/*  80 */     gridBagConstraints = new java.awt.GridBagConstraints();
/*  81 */     gridBagConstraints.gridx = 1;
/*  82 */     gridBagConstraints.gridy = 1;
/*  83 */     this.jPanel1.add(this.jTextField2, gridBagConstraints);
/*     */     
/*  85 */     this.jButton1.setText(resourceMap.getString("jButton1.text", new Object[0]));
/*  86 */     this.jButton1.setName("jButton1");
/*  87 */     gridBagConstraints = new java.awt.GridBagConstraints();
/*  88 */     gridBagConstraints.gridx = 1;
/*  89 */     gridBagConstraints.gridy = 2;
/*  90 */     this.jPanel1.add(this.jButton1, gridBagConstraints);
/*     */     
/*  92 */     this.jPanel2.setName("jPanel2");
/*     */     
/*  94 */     this.jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/*  96 */     this.jPanel3.setName("jPanel3");
/*     */     
/*  98 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*     */     
/* 100 */     this.jPanel3.setLayout(jPanel3Layout);
/* 101 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
/*     */     
/*     */ 
/* 104 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
/*     */     
/*     */ 
/*     */ 
/* 108 */     this.jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 110 */     this.jPanel4.setName("jPanel4");
/*     */     
/* 112 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*     */     
/* 114 */     this.jPanel4.setLayout(jPanel4Layout);
/* 115 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
/*     */     
/*     */ 
/* 118 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
/*     */     
/*     */ 
/*     */ 
/* 122 */     this.jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 124 */     this.jPanel5.setName("jPanel5");
/*     */     
/* 126 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/*     */     
/* 128 */     this.jPanel5.setLayout(jPanel5Layout);
/* 129 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
/*     */     
/*     */ 
/* 132 */     jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
/*     */     
/*     */ 
/*     */ 
/* 136 */     this.jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 138 */     this.jPanel6.setName("jPanel6");
/*     */     
/* 140 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*     */     
/* 142 */     this.jPanel6.setLayout(jPanel6Layout);
/* 143 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
/*     */     
/*     */ 
/* 146 */     jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
/*     */     
/*     */ 
/*     */ 
/* 150 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/* 151 */     this.jLabel1.setName("jLabel1");
/*     */     
/* 153 */     this.jLabel2.setText(resourceMap.getString("jLabel2.text", new Object[0]));
/* 154 */     this.jLabel2.setName("jLabel2");
/*     */     
/* 156 */     this.jLabel3.setText(resourceMap.getString("jLabel3.text", new Object[0]));
/* 157 */     this.jLabel3.setName("jLabel3");
/*     */     
/* 159 */     this.jLabel4.setText(resourceMap.getString("jLabel4.text", new Object[0]));
/* 160 */     this.jLabel4.setName("jLabel4");
/*     */     
/* 162 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*     */     
/* 164 */     this.jPanel2.setLayout(jPanel2Layout);
/* 165 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(30, 30, 30).addComponent(this.jPanel3, -2, -1, -2).addGap(26, 26, 26).addComponent(this.jPanel4, -2, -1, -2).addGap(31, 31, 31).addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, 32767).addComponent(this.jPanel6, -2, -1, -2).addGap(47, 47, 47)).addGroup(jPanel2Layout.createSequentialGroup().addGap(56, 56, 56).addComponent(this.jLabel1).addGap(100, 100, 100).addComponent(this.jLabel2).addGap(103, 103, 103).addComponent(this.jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, 32767).addComponent(this.jLabel4).addGap(82, 82, 82)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 213 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jPanel5, -2, -1, -2).addComponent(this.jPanel4, -2, -1, -2).addComponent(this.jPanel6, -2, -1, -2).addComponent(this.jPanel3, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.jLabel2).addComponent(this.jLabel3).addComponent(this.jLabel4)).addContainerGap(-1, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 258 */     GroupLayout layout = new GroupLayout(getContentPane());
/*     */     
/* 260 */     getContentPane().setLayout(layout);
/* 261 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel2, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel1, javax.swing.GroupLayout.Alignment.LEADING, -1, 545, 32767)).addContainerGap(-1, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 289 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, 220, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -1, -1, 32767).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 311 */     pack();
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\dialog\NewNFRStudentDemo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */