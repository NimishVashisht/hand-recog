/*     */ package org.neuroph.easyneurons.dialog;
/*     */ 
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class BamWizard extends javax.swing.JDialog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   org.neuroph.easyneurons.EasyNeuronsApplicationView mainFrame;
/*     */   private JPanel buttonPanel;
/*     */   private JButton cancelButton;
/*     */   private JButton createButton;
/*     */   private JPanel fieldPanel;
/*     */   private JTextField inputsField;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JTextField outputsField;
/*     */   
/*     */   public BamWizard(java.awt.Frame parent, boolean modal)
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
/*     */   private void initComponents()
/*     */   {
/*  38 */     this.fieldPanel = new JPanel();
/*  39 */     this.jLabel1 = new JLabel();
/*  40 */     this.jLabel2 = new JLabel();
/*  41 */     this.inputsField = new JTextField();
/*  42 */     this.outputsField = new JTextField();
/*  43 */     this.buttonPanel = new JPanel();
/*  44 */     this.createButton = new JButton();
/*  45 */     this.cancelButton = new JButton();
/*     */     
/*  47 */     setDefaultCloseOperation(2);
/*  48 */     org.jdesktop.application.ResourceMap resourceMap = ((org.neuroph.easyneurons.EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(org.neuroph.easyneurons.EasyNeuronsApplication.class)).getContext().getResourceMap(BamWizard.class);
/*  49 */     setTitle(resourceMap.getString("Form.title", new Object[0]));
/*  50 */     setName("Form");
/*  51 */     setResizable(false);
/*  52 */     getContentPane().setLayout(new java.awt.GridBagLayout());
/*     */     
/*  54 */     this.fieldPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
/*  55 */     this.fieldPanel.setName("fieldPanel");
/*  56 */     this.fieldPanel.setLayout(new java.awt.GridBagLayout());
/*     */     
/*  58 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/*  59 */     this.jLabel1.setName("jLabel1");
/*  60 */     java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
/*  61 */     gridBagConstraints.anchor = 17;
/*  62 */     gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
/*  63 */     this.fieldPanel.add(this.jLabel1, gridBagConstraints);
/*     */     
/*  65 */     this.jLabel2.setText(resourceMap.getString("jLabel2.text", new Object[0]));
/*  66 */     this.jLabel2.setName("jLabel2");
/*  67 */     gridBagConstraints = new java.awt.GridBagConstraints();
/*  68 */     gridBagConstraints.gridx = 0;
/*  69 */     gridBagConstraints.gridy = 1;
/*  70 */     gridBagConstraints.anchor = 17;
/*  71 */     gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
/*  72 */     this.fieldPanel.add(this.jLabel2, gridBagConstraints);
/*     */     
/*  74 */     this.inputsField.setColumns(8);
/*  75 */     this.inputsField.setText(resourceMap.getString("inputsField.text", new Object[0]));
/*  76 */     this.inputsField.setName("inputsField");
/*  77 */     gridBagConstraints = new java.awt.GridBagConstraints();
/*  78 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
/*  79 */     this.fieldPanel.add(this.inputsField, gridBagConstraints);
/*     */     
/*  81 */     this.outputsField.setColumns(8);
/*  82 */     this.outputsField.setText(resourceMap.getString("outputsField.text", new Object[0]));
/*  83 */     this.outputsField.setName("outputsField");
/*  84 */     gridBagConstraints = new java.awt.GridBagConstraints();
/*  85 */     gridBagConstraints.gridx = 1;
/*  86 */     gridBagConstraints.gridy = 1;
/*  87 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
/*  88 */     this.fieldPanel.add(this.outputsField, gridBagConstraints);
/*     */     
/*  90 */     gridBagConstraints = new java.awt.GridBagConstraints();
/*  91 */     gridBagConstraints.fill = 1;
/*  92 */     gridBagConstraints.insets = new java.awt.Insets(4, 6, 0, 4);
/*  93 */     getContentPane().add(this.fieldPanel, gridBagConstraints);
/*     */     
/*  95 */     this.buttonPanel.setName("buttonPanel");
/*     */     
/*  97 */     javax.swing.ActionMap actionMap = ((org.neuroph.easyneurons.EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(org.neuroph.easyneurons.EasyNeuronsApplication.class)).getContext().getActionMap(BamWizard.class, this);
/*  98 */     this.createButton.setAction(actionMap.get("create"));
/*  99 */     this.createButton.setName("createButton");
/* 100 */     this.buttonPanel.add(this.createButton);
/*     */     
/* 102 */     this.cancelButton.setAction(actionMap.get("cancel"));
/* 103 */     this.cancelButton.setName("cancelButton");
/* 104 */     this.buttonPanel.add(this.cancelButton);
/*     */     
/* 106 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 107 */     gridBagConstraints.gridx = 0;
/* 108 */     gridBagConstraints.gridy = 1;
/* 109 */     gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
/* 110 */     getContentPane().add(this.buttonPanel, gridBagConstraints);
/*     */     
/* 112 */     pack();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 119 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 121 */         BamWizard dialog = new BamWizard(new javax.swing.JFrame(), true);
/* 122 */         dialog.addWindowListener(new java.awt.event.WindowAdapter() {
/*     */           public void windowClosing(java.awt.event.WindowEvent e) {
/* 124 */             System.exit(0);
/*     */           }
/* 126 */         });
/* 127 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void create() {
/* 134 */     int inputNeuronsCount = Integer.parseInt(this.inputsField.getText().trim());
/* 135 */     int outputNeuronsCount = Integer.parseInt(this.outputsField.getText().trim());
/*     */     
/* 137 */     this.mainFrame.newBamNetwork(inputNeuronsCount, outputNeuronsCount);
/* 138 */     setVisible(false);
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void cancel() {
/* 143 */     dispose();
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\dialog\BamWizard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */