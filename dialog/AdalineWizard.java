/*     */ package org.neuroph.easyneurons.dialog;
/*     */ 
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.Insets;
/*     */ import java.awt.event.KeyEvent;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import org.jdesktop.application.ResourceMap;
/*     */ import org.neuroph.easyneurons.EasyNeuronsApplication;
/*     */ 
/*     */ public class AdalineWizard extends javax.swing.JDialog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   org.neuroph.easyneurons.EasyNeuronsApplicationView mainFrame;
/*     */   private JPanel buttonPanel;
/*     */   private JButton cancelButton;
/*     */   private JButton createButton;
/*     */   private JPanel inputPanel;
/*     */   private JTextField inputsNumField;
/*     */   private JLabel inputsNumLabel;
/*     */   
/*     */   public AdalineWizard(java.awt.Frame parent, boolean modal)
/*     */   {
/*  26 */     super(parent, modal);
/*  27 */     initComponents();
/*  28 */     this.mainFrame = org.neuroph.easyneurons.EasyNeuronsApplicationView.getInstance();
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
/*  42 */     this.inputPanel = new JPanel();
/*  43 */     this.inputsNumLabel = new JLabel();
/*  44 */     this.inputsNumField = new JTextField();
/*  45 */     this.buttonPanel = new JPanel();
/*  46 */     this.createButton = new JButton();
/*  47 */     this.cancelButton = new JButton();
/*     */     
/*  49 */     setDefaultCloseOperation(2);
/*  50 */     ResourceMap resourceMap = ((EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(EasyNeuronsApplication.class)).getContext().getResourceMap(AdalineWizard.class);
/*  51 */     setTitle(resourceMap.getString("Form.title", new Object[0]));
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
/*  62 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/*  63 */     gridBagConstraints.insets = new Insets(10, 10, 10, 5);
/*  64 */     this.inputPanel.add(this.inputsNumLabel, gridBagConstraints);
/*     */     
/*  66 */     this.inputsNumField.setColumns(8);
/*  67 */     this.inputsNumField.setText(resourceMap.getString("inputsNumField.text", new Object[0]));
/*  68 */     this.inputsNumField.setName("inputsNumField");
/*  69 */     this.inputsNumField.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyPressed(KeyEvent evt) {
/*  71 */         AdalineWizard.this.inputsNumFieldKeyPressed(evt);
/*     */       }
/*  73 */     });
/*  74 */     gridBagConstraints = new GridBagConstraints();
/*  75 */     gridBagConstraints.insets = new Insets(10, 5, 10, 10);
/*  76 */     this.inputPanel.add(this.inputsNumField, gridBagConstraints);
/*     */     
/*  78 */     gridBagConstraints = new GridBagConstraints();
/*  79 */     gridBagConstraints.fill = 1;
/*  80 */     gridBagConstraints.insets = new Insets(10, 10, 0, 10);
/*  81 */     getContentPane().add(this.inputPanel, gridBagConstraints);
/*     */     
/*  83 */     this.buttonPanel.setName("buttonPanel");
/*     */     
/*  85 */     javax.swing.ActionMap actionMap = ((EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(EasyNeuronsApplication.class)).getContext().getActionMap(AdalineWizard.class, this);
/*  86 */     this.createButton.setAction(actionMap.get("create"));
/*  87 */     this.createButton.setText(resourceMap.getString("createButton.text", new Object[0]));
/*  88 */     this.createButton.setName("createButton");
/*  89 */     this.buttonPanel.add(this.createButton);
/*     */     
/*  91 */     this.cancelButton.setAction(actionMap.get("cancel"));
/*  92 */     this.cancelButton.setText(resourceMap.getString("cancelButton.text", new Object[0]));
/*  93 */     this.cancelButton.setName("cancelButton");
/*  94 */     this.buttonPanel.add(this.cancelButton);
/*     */     
/*  96 */     gridBagConstraints = new GridBagConstraints();
/*  97 */     gridBagConstraints.gridx = 0;
/*  98 */     gridBagConstraints.gridy = 1;
/*  99 */     gridBagConstraints.fill = 1;
/* 100 */     gridBagConstraints.insets = new Insets(0, 5, 0, 5);
/* 101 */     getContentPane().add(this.buttonPanel, gridBagConstraints);
/*     */     
/* 103 */     pack();
/*     */   }
/*     */   
/*     */   private void inputsNumFieldKeyPressed(KeyEvent evt)
/*     */   {
/* 108 */     int key = evt.getKeyCode();
/* 109 */     if (key == 10) {
/* 110 */       create();
/* 111 */     } else if (key == 27) {
/* 112 */       cancel();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 121 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 123 */         AdalineWizard dialog = new AdalineWizard(new javax.swing.JFrame(), true);
/*     */         
/* 125 */         dialog.addWindowListener(new java.awt.event.WindowAdapter() {
/*     */           public void windowClosing(java.awt.event.WindowEvent e) {
/* 127 */             System.exit(0);
/*     */           }
/* 129 */         });
/* 130 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void cancel() {
/* 137 */     dispose();
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void create() {
/*     */     try {
/* 143 */       int neuronNum = Integer.parseInt(this.inputsNumField.getText().trim());
/*     */       
/* 145 */       this.mainFrame.newAdalineNetwork(neuronNum);
/* 146 */       dispose();
/*     */     } catch (NumberFormatException e) {
/* 148 */       javax.swing.JOptionPane.showConfirmDialog(null, "Invalid number format!\nPlease enter number of inputs for adaline as non-zero whole numbers.", "Error", -1);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\dialog\AdalineWizard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */