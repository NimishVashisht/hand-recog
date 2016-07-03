/*     */ package org.neuroph.easyneurons.dialog;
/*     */ 
/*     */ import java.awt.GridBagConstraints;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import org.neuroph.easyneurons.EasyNeuronsApplication;
/*     */ 
/*     */ public class OutstarWizard extends javax.swing.JDialog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   org.neuroph.easyneurons.EasyNeuronsApplicationView mainFrame;
/*     */   private JButton cancelButton;
/*     */   private JButton createButton;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JTextField outputsNumField;
/*     */   private javax.swing.JLabel outputsNumLabel;
/*     */   
/*     */   public OutstarWizard(java.awt.Frame parent, boolean modal)
/*     */   {
/*  22 */     super(parent, modal);
/*  23 */     initComponents();
/*  24 */     this.mainFrame = org.neuroph.easyneurons.EasyNeuronsApplicationView.getInstance();
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
/*  37 */     this.jPanel1 = new JPanel();
/*  38 */     this.outputsNumLabel = new javax.swing.JLabel();
/*  39 */     this.outputsNumField = new JTextField();
/*  40 */     this.jPanel2 = new JPanel();
/*  41 */     this.createButton = new JButton();
/*  42 */     this.cancelButton = new JButton();
/*     */     
/*  44 */     setDefaultCloseOperation(2);
/*  45 */     org.jdesktop.application.ResourceMap resourceMap = ((EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(EasyNeuronsApplication.class)).getContext().getResourceMap(OutstarWizard.class);
/*  46 */     setTitle(resourceMap.getString("Form.title", new Object[0]));
/*  47 */     setName("Form");
/*  48 */     setResizable(false);
/*  49 */     getContentPane().setLayout(new java.awt.GridBagLayout());
/*     */     
/*  51 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
/*  52 */     this.jPanel1.setName("jPanel1");
/*  53 */     this.jPanel1.setLayout(new java.awt.GridBagLayout());
/*     */     
/*  55 */     this.outputsNumLabel.setText(resourceMap.getString("outputsNumLabel.text", new Object[0]));
/*  56 */     this.outputsNumLabel.setName("outputsNumLabel");
/*  57 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/*  58 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/*  59 */     this.jPanel1.add(this.outputsNumLabel, gridBagConstraints);
/*     */     
/*  61 */     this.outputsNumField.setColumns(8);
/*  62 */     this.outputsNumField.setText(resourceMap.getString("outputsNumField.text", new Object[0]));
/*  63 */     this.outputsNumField.setName("outputsNumField");
/*  64 */     gridBagConstraints = new GridBagConstraints();
/*  65 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
/*  66 */     this.jPanel1.add(this.outputsNumField, gridBagConstraints);
/*     */     
/*  68 */     gridBagConstraints = new GridBagConstraints();
/*  69 */     gridBagConstraints.gridx = 0;
/*  70 */     gridBagConstraints.gridy = 0;
/*  71 */     gridBagConstraints.fill = 2;
/*  72 */     gridBagConstraints.anchor = 17;
/*  73 */     gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
/*  74 */     getContentPane().add(this.jPanel1, gridBagConstraints);
/*     */     
/*  76 */     this.jPanel2.setName("jPanel2");
/*     */     
/*  78 */     javax.swing.ActionMap actionMap = ((EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(EasyNeuronsApplication.class)).getContext().getActionMap(OutstarWizard.class, this);
/*  79 */     this.createButton.setAction(actionMap.get("create"));
/*  80 */     this.createButton.setName("createButton");
/*  81 */     this.jPanel2.add(this.createButton);
/*     */     
/*  83 */     this.cancelButton.setAction(actionMap.get("cancel"));
/*  84 */     this.cancelButton.setName("cancelButton");
/*  85 */     this.jPanel2.add(this.cancelButton);
/*     */     
/*  87 */     gridBagConstraints = new GridBagConstraints();
/*  88 */     gridBagConstraints.gridx = 0;
/*  89 */     gridBagConstraints.gridy = 1;
/*  90 */     gridBagConstraints.fill = 2;
/*  91 */     getContentPane().add(this.jPanel2, gridBagConstraints);
/*     */     
/*  93 */     pack();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 100 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 102 */         OutstarWizard dialog = new OutstarWizard(new javax.swing.JFrame(), true);
/* 103 */         dialog.addWindowListener(new java.awt.event.WindowAdapter() {
/*     */           public void windowClosing(java.awt.event.WindowEvent e) {
/* 105 */             System.exit(0);
/*     */           }
/* 107 */         });
/* 108 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void cancel() {
/* 115 */     setVisible(false);
/* 116 */     dispose();
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void create() {
/* 121 */     int outputsNum = Integer.parseInt(this.outputsNumField.getText().trim());
/*     */     
/*     */ 
/* 124 */     this.mainFrame.newOutstarNetwork(outputsNum);
/* 125 */     dispose();
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\dialog\OutstarWizard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */