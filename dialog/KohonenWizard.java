/*     */ package org.neuroph.easyneurons.dialog;
/*     */ 
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class KohonenWizard extends javax.swing.JDialog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   org.neuroph.easyneurons.EasyNeuronsApplicationView mainFrame;
/*     */   private JPanel buttonPanel;
/*     */   private JButton cancelButton;
/*     */   private JButton createButton;
/*     */   private JTextField inputNeuronsField;
/*     */   private JLabel inputNeuronsLabel;
/*     */   private JPanel inputPanel;
/*     */   private JTextField mapNeuronsField;
/*     */   private JLabel mapNeuronsLabel;
/*     */   
/*     */   public KohonenWizard(java.awt.Frame parent, boolean modal)
/*     */   {
/*  23 */     super(parent, modal);
/*  24 */     initComponents();
/*  25 */     this.mainFrame = org.neuroph.easyneurons.EasyNeuronsApplicationView.getInstance();
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
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  39 */     this.inputPanel = new JPanel();
/*  40 */     this.inputNeuronsLabel = new JLabel();
/*  41 */     this.mapNeuronsLabel = new JLabel();
/*  42 */     this.inputNeuronsField = new JTextField();
/*  43 */     this.mapNeuronsField = new JTextField();
/*  44 */     this.buttonPanel = new JPanel();
/*  45 */     this.createButton = new JButton();
/*  46 */     this.cancelButton = new JButton();
/*     */     
/*  48 */     setDefaultCloseOperation(2);
/*  49 */     org.jdesktop.application.ResourceMap resourceMap = ((org.neuroph.easyneurons.EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(org.neuroph.easyneurons.EasyNeuronsApplication.class)).getContext().getResourceMap(KohonenWizard.class);
/*  50 */     setTitle(resourceMap.getString("Form.title", new Object[0]));
/*  51 */     setModal(true);
/*  52 */     setName("Form");
/*  53 */     setResizable(false);
/*  54 */     getContentPane().setLayout(new java.awt.GridBagLayout());
/*     */     
/*  56 */     this.inputPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
/*  57 */     this.inputPanel.setName("inputPanel");
/*  58 */     this.inputPanel.setLayout(new java.awt.GridBagLayout());
/*     */     
/*  60 */     this.inputNeuronsLabel.setText(resourceMap.getString("inputNeuronsLabel.text", new Object[0]));
/*  61 */     this.inputNeuronsLabel.setName("inputNeuronsLabel");
/*  62 */     java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
/*  63 */     gridBagConstraints.anchor = 17;
/*  64 */     gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 5);
/*  65 */     this.inputPanel.add(this.inputNeuronsLabel, gridBagConstraints);
/*     */     
/*  67 */     this.mapNeuronsLabel.setText(resourceMap.getString("mapNeuronsLabel.text", new Object[0]));
/*  68 */     this.mapNeuronsLabel.setName("mapNeuronsLabel");
/*  69 */     gridBagConstraints = new java.awt.GridBagConstraints();
/*  70 */     gridBagConstraints.gridx = 0;
/*  71 */     gridBagConstraints.gridy = 1;
/*  72 */     gridBagConstraints.anchor = 17;
/*  73 */     gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
/*  74 */     this.inputPanel.add(this.mapNeuronsLabel, gridBagConstraints);
/*     */     
/*  76 */     this.inputNeuronsField.setColumns(8);
/*  77 */     this.inputNeuronsField.setText(resourceMap.getString("inputNeuronsField.text", new Object[0]));
/*  78 */     this.inputNeuronsField.setName("inputNeuronsField");
/*  79 */     gridBagConstraints = new java.awt.GridBagConstraints();
/*  80 */     gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 11);
/*  81 */     this.inputPanel.add(this.inputNeuronsField, gridBagConstraints);
/*     */     
/*  83 */     this.mapNeuronsField.setColumns(8);
/*  84 */     this.mapNeuronsField.setText(resourceMap.getString("mapNeuronsField.text", new Object[0]));
/*  85 */     this.mapNeuronsField.setName("mapNeuronsField");
/*  86 */     gridBagConstraints = new java.awt.GridBagConstraints();
/*  87 */     gridBagConstraints.gridx = 1;
/*  88 */     gridBagConstraints.gridy = 1;
/*  89 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 10, 10);
/*  90 */     this.inputPanel.add(this.mapNeuronsField, gridBagConstraints);
/*     */     
/*  92 */     gridBagConstraints = new java.awt.GridBagConstraints();
/*  93 */     gridBagConstraints.fill = 1;
/*  94 */     gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
/*  95 */     getContentPane().add(this.inputPanel, gridBagConstraints);
/*     */     
/*  97 */     this.buttonPanel.setName("buttonPanel");
/*     */     
/*  99 */     javax.swing.ActionMap actionMap = ((org.neuroph.easyneurons.EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(org.neuroph.easyneurons.EasyNeuronsApplication.class)).getContext().getActionMap(KohonenWizard.class, this);
/* 100 */     this.createButton.setAction(actionMap.get("create"));
/* 101 */     this.createButton.setText(resourceMap.getString("createButton.text", new Object[0]));
/* 102 */     this.createButton.setName("createButton");
/* 103 */     this.buttonPanel.add(this.createButton);
/*     */     
/* 105 */     this.cancelButton.setAction(actionMap.get("cancelKohonenWizard"));
/* 106 */     this.cancelButton.setText(resourceMap.getString("cancelButton.text", new Object[0]));
/* 107 */     this.cancelButton.setName("cancelButton");
/* 108 */     this.buttonPanel.add(this.cancelButton);
/*     */     
/* 110 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 111 */     gridBagConstraints.gridx = 0;
/* 112 */     gridBagConstraints.gridy = 1;
/* 113 */     gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
/* 114 */     getContentPane().add(this.buttonPanel, gridBagConstraints);
/*     */     
/* 116 */     pack();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 124 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 126 */         KohonenWizard dialog = new KohonenWizard(new javax.swing.JFrame(), true);
/*     */         
/* 128 */         dialog.addWindowListener(new java.awt.event.WindowAdapter() {
/*     */           public void windowClosing(java.awt.event.WindowEvent e) {
/* 130 */             System.exit(0);
/*     */           }
/* 132 */         });
/* 133 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void cancelKohonenWizard() {
/* 140 */     setVisible(false);
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void create() {
/* 145 */     int inputNeurons = Integer.parseInt(this.inputNeuronsField.getText().trim());
/*     */     
/* 147 */     int mapNeurons = Integer.parseInt(this.mapNeuronsField.getText().trim());
/*     */     
/*     */ 
/* 150 */     this.mainFrame.newKohonenNetwork(inputNeurons, mapNeurons);
/* 151 */     setVisible(false);
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\dialog\KohonenWizard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */