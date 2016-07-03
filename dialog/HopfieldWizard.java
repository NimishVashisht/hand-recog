/*     */ package org.neuroph.easyneurons.dialog;
/*     */ 
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.Insets;
/*     */ import java.awt.event.KeyEvent;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import org.jdesktop.application.ResourceMap;
/*     */ import org.neuroph.easyneurons.EasyNeuronsApplication;
/*     */ 
/*     */ public class HopfieldWizard extends javax.swing.JDialog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   org.neuroph.easyneurons.EasyNeuronsApplicationView mainFrame;
/*     */   private JPanel buttonPanel;
/*     */   private JButton cancelButton;
/*     */   private JButton createButton;
/*     */   private JPanel inputPanel;
/*     */   private JTextField neuronNumField;
/*     */   private javax.swing.JLabel neuronNumLabel;
/*     */   
/*     */   public HopfieldWizard(java.awt.Frame parent, boolean modal)
/*     */   {
/*  25 */     super(parent, modal);
/*  26 */     initComponents();
/*  27 */     this.mainFrame = org.neuroph.easyneurons.EasyNeuronsApplicationView.getInstance();
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
/*  41 */     this.inputPanel = new JPanel();
/*  42 */     this.neuronNumLabel = new javax.swing.JLabel();
/*  43 */     this.neuronNumField = new JTextField();
/*  44 */     this.buttonPanel = new JPanel();
/*  45 */     this.createButton = new JButton();
/*  46 */     this.cancelButton = new JButton();
/*     */     
/*  48 */     setDefaultCloseOperation(2);
/*  49 */     ResourceMap resourceMap = ((EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(EasyNeuronsApplication.class)).getContext().getResourceMap(HopfieldWizard.class);
/*  50 */     setTitle(resourceMap.getString("Form.title", new Object[0]));
/*  51 */     setName("Form");
/*  52 */     setResizable(false);
/*  53 */     getContentPane().setLayout(new java.awt.GridBagLayout());
/*     */     
/*  55 */     this.inputPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
/*  56 */     this.inputPanel.setName("inputPanel");
/*  57 */     this.inputPanel.setLayout(new java.awt.GridBagLayout());
/*     */     
/*  59 */     this.neuronNumLabel.setText(resourceMap.getString("neuronNumLabel.text", new Object[0]));
/*  60 */     this.neuronNumLabel.setName("neuronNumLabel");
/*  61 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/*  62 */     gridBagConstraints.insets = new Insets(10, 10, 10, 5);
/*  63 */     this.inputPanel.add(this.neuronNumLabel, gridBagConstraints);
/*     */     
/*  65 */     this.neuronNumField.setColumns(8);
/*  66 */     this.neuronNumField.setText(resourceMap.getString("neuronNumField.text", new Object[0]));
/*  67 */     this.neuronNumField.setName("neuronNumField");
/*  68 */     this.neuronNumField.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyPressed(KeyEvent evt) {
/*  70 */         HopfieldWizard.this.neuronNumFieldKeyPressed(evt);
/*     */       }
/*  72 */     });
/*  73 */     gridBagConstraints = new GridBagConstraints();
/*  74 */     gridBagConstraints.insets = new Insets(10, 5, 10, 10);
/*  75 */     this.inputPanel.add(this.neuronNumField, gridBagConstraints);
/*     */     
/*  77 */     gridBagConstraints = new GridBagConstraints();
/*  78 */     gridBagConstraints.fill = 1;
/*  79 */     gridBagConstraints.insets = new Insets(10, 10, 0, 10);
/*  80 */     getContentPane().add(this.inputPanel, gridBagConstraints);
/*     */     
/*  82 */     this.buttonPanel.setName("buttonPanel");
/*     */     
/*  84 */     javax.swing.ActionMap actionMap = ((EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(EasyNeuronsApplication.class)).getContext().getActionMap(HopfieldWizard.class, this);
/*  85 */     this.createButton.setAction(actionMap.get("create"));
/*  86 */     this.createButton.setText(resourceMap.getString("createButton.text", new Object[0]));
/*  87 */     this.createButton.setName("createButton");
/*  88 */     this.buttonPanel.add(this.createButton);
/*     */     
/*  90 */     this.cancelButton.setAction(actionMap.get("cancel"));
/*  91 */     this.cancelButton.setText(resourceMap.getString("cancelButton.text", new Object[0]));
/*  92 */     this.cancelButton.setName("cancelButton");
/*  93 */     this.buttonPanel.add(this.cancelButton);
/*     */     
/*  95 */     gridBagConstraints = new GridBagConstraints();
/*  96 */     gridBagConstraints.gridx = 0;
/*  97 */     gridBagConstraints.gridy = 1;
/*  98 */     gridBagConstraints.fill = 1;
/*  99 */     gridBagConstraints.insets = new Insets(0, 5, 0, 5);
/* 100 */     getContentPane().add(this.buttonPanel, gridBagConstraints);
/*     */     
/* 102 */     pack();
/*     */   }
/*     */   
/*     */   private void neuronNumFieldKeyPressed(KeyEvent evt) {
/* 106 */     int key = evt.getKeyCode();
/* 107 */     if (key == 10) {
/* 108 */       create();
/* 109 */     } else if (key == 27) {
/* 110 */       cancel();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 119 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 121 */         HopfieldWizard dialog = new HopfieldWizard(new javax.swing.JFrame(), true);
/*     */         
/* 123 */         dialog.addWindowListener(new java.awt.event.WindowAdapter() {
/*     */           public void windowClosing(java.awt.event.WindowEvent e) {
/* 125 */             System.exit(0);
/*     */           }
/* 127 */         });
/* 128 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void cancel() {
/* 135 */     dispose();
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void create() {
/* 140 */     int neuronNum = Integer.parseInt(this.neuronNumField.getText().trim());
/*     */     
/* 142 */     this.mainFrame.newHopfieldNetwork(neuronNum);
/* 143 */     setVisible(false);
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\dialog\HopfieldWizard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */