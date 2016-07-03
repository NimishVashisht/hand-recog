/*     */ package org.neuroph.easyneurons.dialog;
/*     */ 
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.Insets;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import org.neuroph.easyneurons.EasyNeuronsApplication;
/*     */ 
/*     */ public class MaxnetWizard extends javax.swing.JDialog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   org.neuroph.easyneurons.EasyNeuronsApplicationView mainFrame;
/*     */   private JPanel buttonPanel;
/*     */   private JButton cancelButton;
/*     */   private JButton createButton;
/*     */   private JPanel inputPanel;
/*     */   private JTextField neuronsNumField;
/*     */   private javax.swing.JLabel neuronsNumLabel;
/*     */   
/*     */   public MaxnetWizard(java.awt.Frame parent, boolean modal)
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
/*  40 */     this.neuronsNumLabel = new javax.swing.JLabel();
/*  41 */     this.neuronsNumField = new JTextField();
/*  42 */     this.buttonPanel = new JPanel();
/*  43 */     this.createButton = new JButton();
/*  44 */     this.cancelButton = new JButton();
/*     */     
/*  46 */     setDefaultCloseOperation(2);
/*  47 */     org.jdesktop.application.ResourceMap resourceMap = ((EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(EasyNeuronsApplication.class)).getContext().getResourceMap(MaxnetWizard.class);
/*  48 */     setTitle(resourceMap.getString("Form.title", new Object[0]));
/*  49 */     setModal(true);
/*  50 */     setName("Form");
/*  51 */     setResizable(false);
/*  52 */     getContentPane().setLayout(new java.awt.GridBagLayout());
/*     */     
/*  54 */     this.inputPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
/*  55 */     this.inputPanel.setName("inputPanel");
/*  56 */     this.inputPanel.setLayout(new java.awt.GridBagLayout());
/*     */     
/*  58 */     this.neuronsNumLabel.setText(resourceMap.getString("neuronsNumLabel.text", new Object[0]));
/*  59 */     this.neuronsNumLabel.setName("neuronsNumLabel");
/*  60 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/*  61 */     gridBagConstraints.anchor = 17;
/*  62 */     gridBagConstraints.insets = new Insets(5, 15, 5, 5);
/*  63 */     this.inputPanel.add(this.neuronsNumLabel, gridBagConstraints);
/*     */     
/*  65 */     this.neuronsNumField.setColumns(8);
/*  66 */     this.neuronsNumField.setName("neuronsNumField");
/*  67 */     gridBagConstraints = new GridBagConstraints();
/*  68 */     gridBagConstraints.fill = 2;
/*  69 */     gridBagConstraints.anchor = 17;
/*  70 */     gridBagConstraints.insets = new Insets(5, 5, 5, 15);
/*  71 */     this.inputPanel.add(this.neuronsNumField, gridBagConstraints);
/*     */     
/*  73 */     gridBagConstraints = new GridBagConstraints();
/*  74 */     gridBagConstraints.fill = 1;
/*  75 */     gridBagConstraints.insets = new Insets(10, 10, 0, 10);
/*  76 */     getContentPane().add(this.inputPanel, gridBagConstraints);
/*     */     
/*  78 */     this.buttonPanel.setName("buttonPanel");
/*     */     
/*  80 */     javax.swing.ActionMap actionMap = ((EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(EasyNeuronsApplication.class)).getContext().getActionMap(MaxnetWizard.class, this);
/*  81 */     this.createButton.setAction(actionMap.get("create"));
/*  82 */     this.createButton.setName("createButton");
/*  83 */     this.buttonPanel.add(this.createButton);
/*     */     
/*  85 */     this.cancelButton.setAction(actionMap.get("cancel"));
/*  86 */     this.cancelButton.setName("cancelButton");
/*  87 */     this.buttonPanel.add(this.cancelButton);
/*     */     
/*  89 */     gridBagConstraints = new GridBagConstraints();
/*  90 */     gridBagConstraints.gridx = 0;
/*  91 */     gridBagConstraints.gridy = 1;
/*  92 */     gridBagConstraints.fill = 1;
/*  93 */     gridBagConstraints.insets = new Insets(0, 5, 0, 5);
/*  94 */     getContentPane().add(this.buttonPanel, gridBagConstraints);
/*     */     
/*  96 */     pack();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 104 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 106 */         MaxnetWizard dialog = new MaxnetWizard(new javax.swing.JFrame(), true);
/*     */         
/* 108 */         dialog.addWindowListener(new java.awt.event.WindowAdapter() {
/*     */           public void windowClosing(java.awt.event.WindowEvent e) {
/* 110 */             System.exit(0);
/*     */           }
/* 112 */         });
/* 113 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void create() {
/* 120 */     int neuronsNum = Integer.parseInt(this.neuronsNumField.getText().trim());
/*     */     
/*     */ 
/* 123 */     this.mainFrame.newMaxnetNetwork(neuronsNum);
/* 124 */     dispose();
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void cancel() {
/* 129 */     setVisible(false);
/* 130 */     dispose();
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\dialog\MaxnetWizard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */