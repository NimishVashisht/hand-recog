/*     */ package org.neuroph.easyneurons.dialog;
/*     */ 
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class CompetitiveNetworkWizard extends javax.swing.JDialog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   org.neuroph.easyneurons.EasyNeuronsApplicationView mainFrame;
/*     */   private JPanel buttonPanel;
/*     */   private JButton cancelButton;
/*     */   private JButton createButton;
/*     */   private JPanel inputPanel;
/*     */   private JTextField inputsNumField;
/*     */   private JLabel inputsNumLabel;
/*     */   private JTextField outputsNumField;
/*     */   private JLabel outputsNumLabel;
/*     */   
/*     */   public CompetitiveNetworkWizard(java.awt.Frame parent, boolean modal)
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
/*  40 */     this.inputsNumLabel = new JLabel();
/*  41 */     this.outputsNumLabel = new JLabel();
/*  42 */     this.inputsNumField = new JTextField();
/*  43 */     this.outputsNumField = new JTextField();
/*  44 */     this.buttonPanel = new JPanel();
/*  45 */     this.createButton = new JButton();
/*  46 */     this.cancelButton = new JButton();
/*     */     
/*  48 */     setDefaultCloseOperation(2);
/*  49 */     org.jdesktop.application.ResourceMap resourceMap = ((org.neuroph.easyneurons.EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(org.neuroph.easyneurons.EasyNeuronsApplication.class)).getContext().getResourceMap(CompetitiveNetworkWizard.class);
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
/*  60 */     this.inputsNumLabel.setText(resourceMap.getString("inputsNumLabel.text", new Object[0]));
/*  61 */     this.inputsNumLabel.setName("inputsNumLabel");
/*  62 */     java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
/*  63 */     gridBagConstraints.anchor = 17;
/*  64 */     gridBagConstraints.insets = new java.awt.Insets(10, 15, 5, 5);
/*  65 */     this.inputPanel.add(this.inputsNumLabel, gridBagConstraints);
/*     */     
/*  67 */     this.outputsNumLabel.setText(resourceMap.getString("outputsNumLabel.text", new Object[0]));
/*  68 */     this.outputsNumLabel.setName("outputsNumLabel");
/*  69 */     gridBagConstraints = new java.awt.GridBagConstraints();
/*  70 */     gridBagConstraints.gridx = 0;
/*  71 */     gridBagConstraints.gridy = 1;
/*  72 */     gridBagConstraints.anchor = 17;
/*  73 */     gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
/*  74 */     this.inputPanel.add(this.outputsNumLabel, gridBagConstraints);
/*     */     
/*  76 */     this.inputsNumField.setColumns(8);
/*  77 */     this.inputsNumField.setName("inputsNumField");
/*  78 */     gridBagConstraints = new java.awt.GridBagConstraints();
/*  79 */     gridBagConstraints.fill = 2;
/*  80 */     gridBagConstraints.anchor = 17;
/*  81 */     gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 15);
/*  82 */     this.inputPanel.add(this.inputsNumField, gridBagConstraints);
/*     */     
/*  84 */     this.outputsNumField.setColumns(8);
/*  85 */     this.outputsNumField.setName("outputsNumField");
/*  86 */     gridBagConstraints = new java.awt.GridBagConstraints();
/*  87 */     gridBagConstraints.gridx = 1;
/*  88 */     gridBagConstraints.gridy = 1;
/*  89 */     gridBagConstraints.fill = 2;
/*  90 */     gridBagConstraints.anchor = 17;
/*  91 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 15);
/*  92 */     this.inputPanel.add(this.outputsNumField, gridBagConstraints);
/*     */     
/*  94 */     gridBagConstraints = new java.awt.GridBagConstraints();
/*  95 */     gridBagConstraints.fill = 1;
/*  96 */     gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
/*  97 */     getContentPane().add(this.inputPanel, gridBagConstraints);
/*     */     
/*  99 */     this.buttonPanel.setName("buttonPanel");
/*     */     
/* 101 */     javax.swing.ActionMap actionMap = ((org.neuroph.easyneurons.EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(org.neuroph.easyneurons.EasyNeuronsApplication.class)).getContext().getActionMap(CompetitiveNetworkWizard.class, this);
/* 102 */     this.createButton.setAction(actionMap.get("create"));
/* 103 */     this.createButton.setName("createButton");
/* 104 */     this.buttonPanel.add(this.createButton);
/*     */     
/* 106 */     this.cancelButton.setAction(actionMap.get("cancel"));
/* 107 */     this.cancelButton.setName("cancelButton");
/* 108 */     this.buttonPanel.add(this.cancelButton);
/*     */     
/* 110 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 111 */     gridBagConstraints.gridx = 0;
/* 112 */     gridBagConstraints.gridy = 1;
/* 113 */     gridBagConstraints.fill = 1;
/* 114 */     gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
/* 115 */     getContentPane().add(this.buttonPanel, gridBagConstraints);
/*     */     
/* 117 */     pack();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 125 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 127 */         CompetitiveNetworkWizard dialog = new CompetitiveNetworkWizard(new javax.swing.JFrame(), true);
/*     */         
/* 129 */         dialog.addWindowListener(new java.awt.event.WindowAdapter() {
/*     */           public void windowClosing(java.awt.event.WindowEvent e) {
/* 131 */             System.exit(0);
/*     */           }
/* 133 */         });
/* 134 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void create() {
/* 141 */     int inputNeuronsNum = Integer.parseInt(this.inputsNumField.getText().trim());
/*     */     
/* 143 */     int outputNeuronsNum = Integer.parseInt(this.outputsNumField.getText().trim());
/*     */     
/*     */ 
/* 146 */     this.mainFrame.newCompetitiveNetwork(inputNeuronsNum, outputNeuronsNum);
/* 147 */     dispose();
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void cancel() {
/* 152 */     setVisible(false);
/* 153 */     dispose();
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\dialog\CompetitiveNetworkWizard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */