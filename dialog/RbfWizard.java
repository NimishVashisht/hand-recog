/*     */ package org.neuroph.easyneurons.dialog;
/*     */ 
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class RbfWizard extends javax.swing.JDialog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   org.neuroph.easyneurons.EasyNeuronsApplicationView mainFrame;
/*     */   private JPanel buttonPanel;
/*     */   private javax.swing.JButton cancelButton;
/*     */   private javax.swing.JButton createButton;
/*     */   private JPanel inputPanel;
/*     */   private JTextField inputsNumField;
/*     */   private javax.swing.JLabel inputsNumLabel;
/*     */   private JTextField outputsNumField;
/*     */   private javax.swing.JLabel outputsNumLabel;
/*     */   private javax.swing.JLabel rbfLabel;
/*     */   private JTextField rbfNumField;
/*     */   
/*     */   public RbfWizard(java.awt.Frame parent, boolean modal)
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
/*  40 */     this.inputsNumLabel = new javax.swing.JLabel();
/*  41 */     this.outputsNumLabel = new javax.swing.JLabel();
/*  42 */     this.inputsNumField = new JTextField();
/*  43 */     this.outputsNumField = new JTextField();
/*  44 */     this.rbfLabel = new javax.swing.JLabel();
/*  45 */     this.rbfNumField = new JTextField();
/*  46 */     this.buttonPanel = new JPanel();
/*  47 */     this.createButton = new javax.swing.JButton();
/*  48 */     this.cancelButton = new javax.swing.JButton();
/*     */     
/*  50 */     setDefaultCloseOperation(2);
/*  51 */     org.jdesktop.application.ResourceMap resourceMap = ((org.neuroph.easyneurons.EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(org.neuroph.easyneurons.EasyNeuronsApplication.class)).getContext().getResourceMap(RbfWizard.class);
/*  52 */     setTitle(resourceMap.getString("Form.title", new Object[0]));
/*  53 */     setModal(true);
/*  54 */     setName("Form");
/*  55 */     setResizable(false);
/*  56 */     getContentPane().setLayout(new java.awt.GridBagLayout());
/*     */     
/*  58 */     this.inputPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
/*  59 */     this.inputPanel.setName("inputPanel");
/*  60 */     this.inputPanel.setLayout(new java.awt.GridBagLayout());
/*     */     
/*  62 */     this.inputsNumLabel.setText(resourceMap.getString("inputsNumLabel.text", new Object[0]));
/*  63 */     this.inputsNumLabel.setName("inputsNumLabel");
/*  64 */     java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
/*  65 */     gridBagConstraints.anchor = 17;
/*  66 */     gridBagConstraints.insets = new java.awt.Insets(10, 15, 5, 5);
/*  67 */     this.inputPanel.add(this.inputsNumLabel, gridBagConstraints);
/*     */     
/*  69 */     this.outputsNumLabel.setText(resourceMap.getString("outputsNumLabel.text", new Object[0]));
/*  70 */     this.outputsNumLabel.setName("outputsNumLabel");
/*  71 */     gridBagConstraints = new java.awt.GridBagConstraints();
/*  72 */     gridBagConstraints.gridx = 0;
/*  73 */     gridBagConstraints.gridy = 2;
/*  74 */     gridBagConstraints.anchor = 17;
/*  75 */     gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
/*  76 */     this.inputPanel.add(this.outputsNumLabel, gridBagConstraints);
/*     */     
/*  78 */     this.inputsNumField.setColumns(8);
/*  79 */     this.inputsNumField.setName("inputsNumField");
/*  80 */     gridBagConstraints = new java.awt.GridBagConstraints();
/*  81 */     gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 15);
/*  82 */     this.inputPanel.add(this.inputsNumField, gridBagConstraints);
/*     */     
/*  84 */     this.outputsNumField.setColumns(8);
/*  85 */     this.outputsNumField.setName("outputsNumField");
/*  86 */     gridBagConstraints = new java.awt.GridBagConstraints();
/*  87 */     gridBagConstraints.gridx = 1;
/*  88 */     gridBagConstraints.gridy = 2;
/*  89 */     gridBagConstraints.anchor = 17;
/*  90 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 15);
/*  91 */     this.inputPanel.add(this.outputsNumField, gridBagConstraints);
/*     */     
/*  93 */     this.rbfLabel.setText(resourceMap.getString("rbfLabel.text", new Object[0]));
/*  94 */     this.rbfLabel.setName("rbfLabel");
/*  95 */     gridBagConstraints = new java.awt.GridBagConstraints();
/*  96 */     gridBagConstraints.gridx = 0;
/*  97 */     gridBagConstraints.gridy = 1;
/*  98 */     gridBagConstraints.anchor = 17;
/*  99 */     gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
/* 100 */     this.inputPanel.add(this.rbfLabel, gridBagConstraints);
/*     */     
/* 102 */     this.rbfNumField.setColumns(8);
/* 103 */     this.rbfNumField.setText(resourceMap.getString("rbfNumField.text", new Object[0]));
/* 104 */     this.rbfNumField.setName("rbfNumField");
/* 105 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 106 */     gridBagConstraints.gridx = 1;
/* 107 */     gridBagConstraints.gridy = 1;
/* 108 */     gridBagConstraints.anchor = 17;
/* 109 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 15);
/* 110 */     this.inputPanel.add(this.rbfNumField, gridBagConstraints);
/*     */     
/* 112 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 113 */     gridBagConstraints.fill = 1;
/* 114 */     gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
/* 115 */     getContentPane().add(this.inputPanel, gridBagConstraints);
/*     */     
/* 117 */     this.buttonPanel.setName("buttonPanel");
/*     */     
/* 119 */     javax.swing.ActionMap actionMap = ((org.neuroph.easyneurons.EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(org.neuroph.easyneurons.EasyNeuronsApplication.class)).getContext().getActionMap(RbfWizard.class, this);
/* 120 */     this.createButton.setAction(actionMap.get("create"));
/* 121 */     this.createButton.setName("createButton");
/* 122 */     this.buttonPanel.add(this.createButton);
/*     */     
/* 124 */     this.cancelButton.setAction(actionMap.get("cancel"));
/* 125 */     this.cancelButton.setName("cancelButton");
/* 126 */     this.buttonPanel.add(this.cancelButton);
/*     */     
/* 128 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 129 */     gridBagConstraints.gridx = 0;
/* 130 */     gridBagConstraints.gridy = 1;
/* 131 */     gridBagConstraints.fill = 1;
/* 132 */     gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
/* 133 */     getContentPane().add(this.buttonPanel, gridBagConstraints);
/*     */     
/* 135 */     pack();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 143 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 145 */         RbfWizard dialog = new RbfWizard(new javax.swing.JFrame(), true);
/* 146 */         dialog.addWindowListener(new java.awt.event.WindowAdapter() {
/*     */           public void windowClosing(java.awt.event.WindowEvent e) {
/* 148 */             System.exit(0);
/*     */           }
/* 150 */         });
/* 151 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void cancel() {
/* 158 */     dispose();
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void create() {
/* 163 */     int inputNeuronsNum = Integer.parseInt(this.inputsNumField.getText().trim());
/*     */     
/* 165 */     int rbfNeuronsNum = Integer.parseInt(this.rbfNumField.getText().trim());
/* 166 */     int outputNeuronsNum = Integer.parseInt(this.outputsNumField.getText().trim());
/*     */     
/*     */ 
/* 169 */     this.mainFrame.newRbfNetwork(inputNeuronsNum, rbfNeuronsNum, outputNeuronsNum);
/*     */     
/* 171 */     setVisible(false);
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\dialog\RbfWizard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */