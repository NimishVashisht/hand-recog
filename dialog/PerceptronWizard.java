/*     */ package org.neuroph.easyneurons.dialog;
/*     */ 
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.Insets;
/*     */ import java.awt.event.KeyEvent;
/*     */ import javax.swing.ActionMap;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import org.jdesktop.application.ResourceMap;
/*     */ import org.neuroph.easyneurons.EasyNeuronsApplication;
/*     */ 
/*     */ public class PerceptronWizard extends javax.swing.JDialog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   org.neuroph.easyneurons.EasyNeuronsApplicationView mainFrame;
/*     */   private JPanel buttonPanel;
/*     */   private JButton cancelButton;
/*     */   private JButton createButton;
/*     */   private JPanel inputPanel;
/*     */   private JTextField inputsNumField;
/*     */   private JLabel inputsNumLabel;
/*     */   private JLabel jLabel1;
/*     */   private JComboBox learningRuleCombo;
/*     */   private JTextField outputsNumField;
/*     */   private JLabel outputsNumLabel;
/*     */   
/*     */   public PerceptronWizard(java.awt.Frame parent, boolean modal)
/*     */   {
/*  32 */     super(parent, modal);
/*  33 */     initComponents();
/*  34 */     fillLearningRuleCombo();
/*  35 */     this.mainFrame = org.neuroph.easyneurons.EasyNeuronsApplicationView.getInstance();
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
/*  49 */     this.inputPanel = new JPanel();
/*  50 */     this.inputsNumLabel = new JLabel();
/*  51 */     this.outputsNumLabel = new JLabel();
/*  52 */     this.inputsNumField = new JTextField();
/*  53 */     this.outputsNumField = new JTextField();
/*  54 */     this.jLabel1 = new JLabel();
/*  55 */     this.learningRuleCombo = new JComboBox();
/*  56 */     this.buttonPanel = new JPanel();
/*  57 */     this.createButton = new JButton();
/*  58 */     this.cancelButton = new JButton();
/*     */     
/*  60 */     setDefaultCloseOperation(2);
/*  61 */     ResourceMap resourceMap = ((EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(EasyNeuronsApplication.class)).getContext().getResourceMap(PerceptronWizard.class);
/*  62 */     setTitle(resourceMap.getString("Form.title", new Object[0]));
/*  63 */     setModal(true);
/*  64 */     setName("Form");
/*  65 */     setResizable(false);
/*  66 */     getContentPane().setLayout(new java.awt.GridBagLayout());
/*     */     
/*  68 */     this.inputPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
/*  69 */     this.inputPanel.setName("inputPanel");
/*  70 */     this.inputPanel.setLayout(new java.awt.GridBagLayout());
/*     */     
/*  72 */     this.inputsNumLabel.setText(resourceMap.getString("inputsNumLabel.text", new Object[0]));
/*  73 */     this.inputsNumLabel.setName("inputsNumLabel");
/*  74 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/*  75 */     gridBagConstraints.anchor = 17;
/*  76 */     gridBagConstraints.insets = new Insets(10, 15, 5, 5);
/*  77 */     this.inputPanel.add(this.inputsNumLabel, gridBagConstraints);
/*     */     
/*  79 */     this.outputsNumLabel.setText(resourceMap.getString("outputsNumLabel.text", new Object[0]));
/*  80 */     this.outputsNumLabel.setName("outputsNumLabel");
/*  81 */     gridBagConstraints = new GridBagConstraints();
/*  82 */     gridBagConstraints.gridx = 0;
/*  83 */     gridBagConstraints.gridy = 1;
/*  84 */     gridBagConstraints.anchor = 17;
/*  85 */     gridBagConstraints.insets = new Insets(5, 15, 5, 5);
/*  86 */     this.inputPanel.add(this.outputsNumLabel, gridBagConstraints);
/*     */     
/*  88 */     this.inputsNumField.setColumns(8);
/*  89 */     this.inputsNumField.setText(resourceMap.getString("inputsNumField.text", new Object[0]));
/*  90 */     this.inputsNumField.setName("inputsNumField");
/*  91 */     this.inputsNumField.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyPressed(KeyEvent evt) {
/*  93 */         PerceptronWizard.this.inputsNumFieldKeyPressed(evt);
/*     */       }
/*  95 */     });
/*  96 */     gridBagConstraints = new GridBagConstraints();
/*  97 */     gridBagConstraints.anchor = 17;
/*  98 */     gridBagConstraints.insets = new Insets(10, 5, 5, 15);
/*  99 */     this.inputPanel.add(this.inputsNumField, gridBagConstraints);
/*     */     
/* 101 */     this.outputsNumField.setColumns(8);
/* 102 */     this.outputsNumField.setText(resourceMap.getString("outputsNumField.text", new Object[0]));
/* 103 */     this.outputsNumField.setName("outputsNumField");
/* 104 */     this.outputsNumField.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyPressed(KeyEvent evt) {
/* 106 */         PerceptronWizard.this.outputsNumFieldKeyPressed(evt);
/*     */       }
/* 108 */     });
/* 109 */     gridBagConstraints = new GridBagConstraints();
/* 110 */     gridBagConstraints.gridx = 1;
/* 111 */     gridBagConstraints.gridy = 1;
/* 112 */     gridBagConstraints.anchor = 17;
/* 113 */     gridBagConstraints.insets = new Insets(5, 5, 5, 15);
/* 114 */     this.inputPanel.add(this.outputsNumField, gridBagConstraints);
/*     */     
/* 116 */     this.jLabel1.setText(resourceMap.getString("jLabel1.text", new Object[0]));
/* 117 */     this.jLabel1.setName("jLabel1");
/* 118 */     gridBagConstraints = new GridBagConstraints();
/* 119 */     gridBagConstraints.gridx = 0;
/* 120 */     gridBagConstraints.gridy = 2;
/* 121 */     gridBagConstraints.anchor = 17;
/* 122 */     gridBagConstraints.insets = new Insets(5, 15, 10, 5);
/* 123 */     this.inputPanel.add(this.jLabel1, gridBagConstraints);
/*     */     
/* 125 */     this.learningRuleCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Perceptron Learning", "Delta Rule" }));
/* 126 */     this.learningRuleCombo.setName("learningRuleCombo");
/* 127 */     gridBagConstraints = new GridBagConstraints();
/* 128 */     gridBagConstraints.gridx = 1;
/* 129 */     gridBagConstraints.gridy = 2;
/* 130 */     gridBagConstraints.fill = 2;
/* 131 */     gridBagConstraints.anchor = 17;
/* 132 */     gridBagConstraints.insets = new Insets(5, 5, 10, 15);
/* 133 */     this.inputPanel.add(this.learningRuleCombo, gridBagConstraints);
/*     */     
/* 135 */     gridBagConstraints = new GridBagConstraints();
/* 136 */     gridBagConstraints.fill = 1;
/* 137 */     gridBagConstraints.insets = new Insets(10, 10, 0, 10);
/* 138 */     getContentPane().add(this.inputPanel, gridBagConstraints);
/*     */     
/* 140 */     this.buttonPanel.setName("buttonPanel");
/*     */     
/* 142 */     ActionMap actionMap = ((EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(EasyNeuronsApplication.class)).getContext().getActionMap(PerceptronWizard.class, this);
/* 143 */     this.createButton.setAction(actionMap.get("create"));
/* 144 */     this.createButton.setText(resourceMap.getString("createButton.text", new Object[0]));
/* 145 */     this.createButton.setName("createButton");
/* 146 */     this.buttonPanel.add(this.createButton);
/*     */     
/* 148 */     this.cancelButton.setAction(actionMap.get("cancel"));
/* 149 */     this.cancelButton.setText(resourceMap.getString("cancelButton.text", new Object[0]));
/* 150 */     this.cancelButton.setName("cancelButton");
/* 151 */     this.buttonPanel.add(this.cancelButton);
/*     */     
/* 153 */     gridBagConstraints = new GridBagConstraints();
/* 154 */     gridBagConstraints.gridx = 0;
/* 155 */     gridBagConstraints.gridy = 1;
/* 156 */     gridBagConstraints.fill = 1;
/* 157 */     gridBagConstraints.insets = new Insets(0, 5, 0, 5);
/* 158 */     getContentPane().add(this.buttonPanel, gridBagConstraints);
/*     */     
/* 160 */     pack();
/*     */   }
/*     */   
/*     */   private void inputsNumFieldKeyPressed(KeyEvent evt)
/*     */   {
/* 165 */     keyPressed(evt);
/*     */   }
/*     */   
/*     */   private void outputsNumFieldKeyPressed(KeyEvent evt)
/*     */   {
/* 170 */     keyPressed(evt);
/*     */   }
/*     */   
/*     */   private void keyPressed(KeyEvent evt) {
/* 174 */     int key = evt.getKeyCode();
/* 175 */     if (key == 10) {
/* 176 */       create();
/* 177 */     } else if (key == 27) {
/* 178 */       cancel();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 187 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 189 */         PerceptronWizard dialog = new PerceptronWizard(new javax.swing.JFrame(), true);
/*     */         
/* 191 */         dialog.addWindowListener(new java.awt.event.WindowAdapter() {
/*     */           public void windowClosing(java.awt.event.WindowEvent e) {
/* 193 */             System.exit(0);
/*     */           }
/* 195 */         });
/* 196 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private void fillLearningRuleCombo() {
/* 202 */     this.learningRuleCombo.removeAllItems();
/* 203 */     this.learningRuleCombo.addItem(new ComboItem("Perceptron Learning", org.neuroph.nnet.learning.PerceptronLearning.class));
/* 204 */     this.learningRuleCombo.addItem(new ComboItem("Binary Delta Rule", org.neuroph.nnet.learning.BinaryDeltaRule.class));
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void cancel() {
/* 209 */     setVisible(false);
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void create() {
/*     */     try {
/* 215 */       int inputNeurons = Integer.parseInt(this.inputsNumField.getText().trim());
/*     */       
/* 217 */       int outputNeurons = Integer.parseInt(this.outputsNumField.getText().trim());
/*     */       
/*     */ 
/* 220 */       Class learningRule = (Class)((ComboItem)this.learningRuleCombo.getSelectedItem()).getValue();
/*     */       
/* 222 */       this.mainFrame.newPerceptronNetwork(inputNeurons, outputNeurons, org.neuroph.util.TransferFunctionType.STEP, learningRule);
/*     */       
/* 224 */       setVisible(false);
/*     */     } catch (NumberFormatException e) {
/* 226 */       javax.swing.JOptionPane.showConfirmDialog(null, "Invalid number format!\nPlease enter number of inputs and ouputs for perceptron as non-zero whole numbers.", "Error", -1);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\dialog\PerceptronWizard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */