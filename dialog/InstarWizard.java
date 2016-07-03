/*     */ package org.neuroph.easyneurons.dialog;
/*     */ 
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import org.jdesktop.application.ResourceMap;
/*     */ import org.neuroph.easyneurons.EasyNeuronsApplication;
/*     */ 
/*     */ public class InstarWizard extends javax.swing.JDialog
/*     */ {
/*     */   org.neuroph.easyneurons.EasyNeuronsApplicationView mainFrame;
/*     */   private JButton cancelButton;
/*     */   private JButton createButton;
/*     */   private JTextField inputsNumField;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   
/*     */   public InstarWizard(java.awt.Frame parent, boolean modal)
/*     */   {
/*  21 */     super(parent, modal);
/*  22 */     initComponents();
/*  23 */     this.mainFrame = org.neuroph.easyneurons.EasyNeuronsApplicationView.getInstance();
/*     */   }
/*     */   
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
/*  36 */     this.jPanel1 = new JPanel();
/*  37 */     this.jLabel1 = new javax.swing.JLabel();
/*  38 */     this.inputsNumField = new JTextField();
/*  39 */     this.jPanel2 = new JPanel();
/*  40 */     this.createButton = new JButton();
/*  41 */     this.cancelButton = new JButton();
/*     */     
/*  43 */     setDefaultCloseOperation(2);
/*  44 */     ResourceMap resourceMap = ((EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(EasyNeuronsApplication.class)).getContext().getResourceMap(InstarWizard.class);
/*  45 */     setTitle(resourceMap.getString("Form.title", new Object[0]));
/*  46 */     setName("Form");
/*  47 */     setResizable(false);
/*  48 */     getContentPane().setLayout(new java.awt.GridBagLayout());
/*     */     
/*  50 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
/*  51 */     this.jPanel1.setName("jPanel1");
/*  52 */     this.jPanel1.setLayout(new java.awt.GridBagLayout());
/*     */     
/*  54 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/*  55 */     this.jLabel1.setName("jLabel1");
/*  56 */     java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
/*  57 */     gridBagConstraints.anchor = 17;
/*  58 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/*  59 */     this.jPanel1.add(this.jLabel1, gridBagConstraints);
/*     */     
/*  61 */     this.inputsNumField.setColumns(8);
/*  62 */     this.inputsNumField.setText(resourceMap.getString("inputsNumField.text", new Object[0]));
/*  63 */     this.inputsNumField.setName("inputsNumField");
/*  64 */     gridBagConstraints = new java.awt.GridBagConstraints();
/*  65 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/*  66 */     this.jPanel1.add(this.inputsNumField, gridBagConstraints);
/*     */     
/*  68 */     gridBagConstraints = new java.awt.GridBagConstraints();
/*  69 */     gridBagConstraints.fill = 1;
/*  70 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
/*  71 */     getContentPane().add(this.jPanel1, gridBagConstraints);
/*     */     
/*  73 */     this.jPanel2.setName("jPanel2");
/*     */     
/*  75 */     javax.swing.ActionMap actionMap = ((EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(EasyNeuronsApplication.class)).getContext().getActionMap(InstarWizard.class, this);
/*  76 */     this.createButton.setAction(actionMap.get("create"));
/*  77 */     this.createButton.setText(resourceMap.getString("createButton.text", new Object[0]));
/*  78 */     this.createButton.setName("createButton");
/*  79 */     this.jPanel2.add(this.createButton);
/*     */     
/*  81 */     this.cancelButton.setAction(actionMap.get("cancel"));
/*  82 */     this.cancelButton.setText(resourceMap.getString("cancelButton.text", new Object[0]));
/*  83 */     this.cancelButton.setName("cancelButton");
/*  84 */     this.jPanel2.add(this.cancelButton);
/*     */     
/*  86 */     gridBagConstraints = new java.awt.GridBagConstraints();
/*  87 */     gridBagConstraints.gridx = 0;
/*  88 */     gridBagConstraints.gridy = 1;
/*  89 */     getContentPane().add(this.jPanel2, gridBagConstraints);
/*     */     
/*  91 */     pack();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*  98 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 100 */         InstarWizard dialog = new InstarWizard(new javax.swing.JFrame(), true);
/* 101 */         dialog.addWindowListener(new java.awt.event.WindowAdapter() {
/*     */           public void windowClosing(java.awt.event.WindowEvent e) {
/* 103 */             System.exit(0);
/*     */           }
/* 105 */         });
/* 106 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void cancel() {
/* 113 */     setVisible(false);
/* 114 */     dispose();
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void create() {
/* 119 */     int inputsNum = Integer.parseInt(this.inputsNumField.getText().trim());
/*     */     
/*     */ 
/* 122 */     this.mainFrame.newInstarNetwork(inputsNum);
/* 123 */     dispose();
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\dialog\InstarWizard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */