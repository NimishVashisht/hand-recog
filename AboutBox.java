/*     */ package org.neuroph.easyneurons;
/*     */ 
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class AboutBox extends javax.swing.JDialog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private javax.swing.JButton closeButton;
/*     */   
/*     */   public AboutBox(java.awt.Frame parent)
/*     */   {
/*  14 */     super(parent);
/*  15 */     initComponents();
/*  16 */     getRootPane().setDefaultButton(this.closeButton);
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void closeAboutBox() {
/*  21 */     setVisible(false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  33 */     this.closeButton = new javax.swing.JButton();
/*  34 */     JLabel appTitleLabel = new JLabel();
/*  35 */     JLabel versionLabel = new JLabel();
/*  36 */     JLabel appVersionLabel = new JLabel();
/*  37 */     JLabel vendorLabel = new JLabel();
/*  38 */     JLabel appVendorLabel = new JLabel();
/*  39 */     JLabel homepageLabel = new JLabel();
/*  40 */     JLabel appHomepageLabel = new JLabel();
/*  41 */     JLabel appDescLabel = new JLabel();
/*  42 */     JLabel imageLabel = new JLabel();
/*     */     
/*  44 */     setDefaultCloseOperation(2);
/*  45 */     org.jdesktop.application.ResourceMap resourceMap = ((EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(EasyNeuronsApplication.class)).getContext().getResourceMap(AboutBox.class);
/*  46 */     setTitle(resourceMap.getString("title", new Object[0]));
/*  47 */     setModal(true);
/*  48 */     setName("aboutBox");
/*  49 */     setResizable(false);
/*     */     
/*  51 */     javax.swing.ActionMap actionMap = ((EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(EasyNeuronsApplication.class)).getContext().getActionMap(AboutBox.class, this);
/*  52 */     this.closeButton.setAction(actionMap.get("closeAboutBox"));
/*  53 */     this.closeButton.setName("closeButton");
/*     */     
/*  55 */     appTitleLabel.setFont(appTitleLabel.getFont().deriveFont(appTitleLabel.getFont().getStyle() | 0x1, appTitleLabel.getFont().getSize() + 4));
/*  56 */     appTitleLabel.setText(resourceMap.getString("Application.title", new Object[0]));
/*  57 */     appTitleLabel.setName("appTitleLabel");
/*     */     
/*  59 */     versionLabel.setFont(versionLabel.getFont().deriveFont(versionLabel.getFont().getStyle() | 0x1));
/*  60 */     versionLabel.setText(resourceMap.getString("versionLabel.text", new Object[0]));
/*  61 */     versionLabel.setName("versionLabel");
/*     */     
/*  63 */     appVersionLabel.setText(resourceMap.getString("Application.version", new Object[0]));
/*  64 */     appVersionLabel.setName("appVersionLabel");
/*     */     
/*  66 */     vendorLabel.setFont(vendorLabel.getFont().deriveFont(vendorLabel.getFont().getStyle() | 0x1));
/*  67 */     vendorLabel.setText(resourceMap.getString("vendorLabel.text", new Object[0]));
/*  68 */     vendorLabel.setName("vendorLabel");
/*     */     
/*  70 */     appVendorLabel.setText(resourceMap.getString("Application.vendor", new Object[0]));
/*  71 */     appVendorLabel.setName("appVendorLabel");
/*     */     
/*  73 */     homepageLabel.setFont(homepageLabel.getFont().deriveFont(homepageLabel.getFont().getStyle() | 0x1));
/*  74 */     homepageLabel.setText(resourceMap.getString("homepageLabel.text", new Object[0]));
/*  75 */     homepageLabel.setName("homepageLabel");
/*     */     
/*  77 */     appHomepageLabel.setText(resourceMap.getString("Application.homepage", new Object[0]));
/*  78 */     appHomepageLabel.setName("appHomepageLabel");
/*     */     
/*  80 */     appDescLabel.setText(resourceMap.getString("appDescLabel.text", new Object[0]));
/*  81 */     appDescLabel.setName("appDescLabel");
/*     */     
/*  83 */     imageLabel.setIcon(resourceMap.getIcon("imageLabel.icon"));
/*  84 */     imageLabel.setName("imageLabel");
/*     */     
/*  86 */     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
/*  87 */     getContentPane().setLayout(layout);
/*  88 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addComponent(imageLabel, -2, 211, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(versionLabel).addComponent(vendorLabel).addComponent(homepageLabel)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(appVersionLabel).addComponent(appVendorLabel).addComponent(appHomepageLabel))).addComponent(appTitleLabel, javax.swing.GroupLayout.Alignment.LEADING).addComponent(appDescLabel, javax.swing.GroupLayout.Alignment.LEADING, -1, 273, 32767).addComponent(this.closeButton, -2, 80, -2)).addContainerGap()));
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
/* 110 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(imageLabel, -2, 127, -2).addGroup(layout.createSequentialGroup().addComponent(appTitleLabel).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(appDescLabel).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(versionLabel).addComponent(appVersionLabel)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(vendorLabel).addComponent(appVendorLabel)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(homepageLabel).addComponent(appHomepageLabel)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.closeButton))).addContainerGap(24, 32767)));
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
/* 137 */     pack();
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\AboutBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */