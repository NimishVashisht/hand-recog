/*     */ package org.neuroph.easyneurons.dialog;
/*     */ 
/*     */ import java.awt.Frame;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.Insets;
/*     */ import java.awt.event.KeyEvent;
/*     */ import javax.swing.ActionMap;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextField;
/*     */ import org.neuroph.core.NeuralNetwork;
/*     */ import org.neuroph.core.learning.TrainingSet;
/*     */ import org.neuroph.easyneurons.EasyNeuronsApplication;
/*     */ import org.neuroph.easyneurons.EasyNeuronsApplicationView;
/*     */ 
/*     */ public class RenameNodeDialog extends JDialog
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   EasyNeuronsApplicationView mainFrame;
/*     */   Object selectedNode;
/*     */   private JButton cancelButton;
/*     */   private JPanel jPanel1;
/*     */   private JTextField nameTextField;
/*     */   private JButton okButton;
/*     */   
/*     */   public RenameNodeDialog(Frame parent, boolean modal)
/*     */   {
/*  29 */     super(parent, modal);
/*  30 */     initComponents();
/*     */   }
/*     */   
/*     */   public RenameNodeDialog(Frame parent, boolean modal, Object selectedNode) {
/*  34 */     super(parent, modal);
/*  35 */     initComponents();
/*  36 */     this.mainFrame = EasyNeuronsApplicationView.getInstance();
/*  37 */     this.selectedNode = selectedNode;
/*  38 */     this.nameTextField.setText(selectedNode.toString());
/*  39 */     this.nameTextField.setSelectionStart(0);
/*  40 */     this.nameTextField.setSelectionEnd(this.nameTextField.getText().length());
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
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  55 */     this.jPanel1 = new JPanel();
/*  56 */     this.nameTextField = new JTextField();
/*  57 */     this.okButton = new JButton();
/*  58 */     this.cancelButton = new JButton();
/*     */     
/*  60 */     setDefaultCloseOperation(2);
/*  61 */     org.jdesktop.application.ResourceMap resourceMap = ((EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(EasyNeuronsApplication.class)).getContext().getResourceMap(RenameNodeDialog.class);
/*     */     
/*     */ 
/*     */ 
/*  65 */     setTitle(resourceMap.getString("Form.title", new Object[0]));
/*  66 */     setMinimumSize(new java.awt.Dimension(308, 43));
/*  67 */     setModal(true);
/*  68 */     setName("Form");
/*  69 */     setResizable(false);
/*  70 */     getContentPane().setLayout(new java.awt.FlowLayout());
/*     */     
/*  72 */     this.jPanel1.setName("jPanel1");
/*  73 */     this.jPanel1.setLayout(new java.awt.GridBagLayout());
/*     */     
/*  75 */     this.nameTextField.setColumns(20);
/*  76 */     this.nameTextField.setText(resourceMap.getString("nameTextField.text", new Object[0]));
/*  77 */     this.nameTextField.setFocusCycleRoot(true);
/*  78 */     this.nameTextField.setName("nameTextField");
/*  79 */     this.nameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyReleased(KeyEvent evt) {
/*  81 */         RenameNodeDialog.this.nameTextFieldKeyReleased(evt);
/*     */       }
/*  83 */     });
/*  84 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/*  85 */     gridBagConstraints.gridx = 0;
/*  86 */     gridBagConstraints.gridy = 0;
/*  87 */     gridBagConstraints.fill = 2;
/*  88 */     gridBagConstraints.weightx = 100.0D;
/*  89 */     gridBagConstraints.insets = new Insets(5, 5, 5, 5);
/*  90 */     this.jPanel1.add(this.nameTextField, gridBagConstraints);
/*     */     
/*  92 */     ActionMap actionMap = ((EasyNeuronsApplication)org.jdesktop.application.Application.getInstance(EasyNeuronsApplication.class)).getContext().getActionMap(RenameNodeDialog.class, this);
/*     */     
/*     */ 
/*     */ 
/*  96 */     this.okButton.setAction(actionMap.get("ok"));
/*  97 */     this.okButton.setName("okButton");
/*  98 */     gridBagConstraints = new GridBagConstraints();
/*  99 */     gridBagConstraints.insets = new Insets(5, 0, 5, 5);
/* 100 */     this.jPanel1.add(this.okButton, gridBagConstraints);
/*     */     
/* 102 */     this.cancelButton.setAction(actionMap.get("cancel"));
/* 103 */     this.cancelButton.setName("cancelButton");
/* 104 */     gridBagConstraints = new GridBagConstraints();
/* 105 */     gridBagConstraints.insets = new Insets(5, 0, 5, 5);
/* 106 */     this.jPanel1.add(this.cancelButton, gridBagConstraints);
/*     */     
/* 108 */     getContentPane().add(this.jPanel1);
/*     */     
/* 110 */     pack();
/*     */   }
/*     */   
/*     */   private void nameTextFieldKeyReleased(KeyEvent evt) {
/* 114 */     int key = evt.getKeyCode();
/* 115 */     if (key == 10) {
/* 116 */       ok();
/* 117 */     } else if (key == 27) {
/* 118 */       cancel();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 127 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 129 */         RenameNodeDialog dialog = new RenameNodeDialog(new javax.swing.JFrame(), true);
/*     */         
/* 131 */         dialog.addWindowListener(new java.awt.event.WindowAdapter() {
/*     */           public void windowClosing(java.awt.event.WindowEvent e) {
/* 133 */             System.exit(0);
/*     */           }
/* 135 */         });
/* 136 */         dialog.setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void cancel() {
/* 143 */     dispose();
/*     */   }
/*     */   
/*     */   @org.jdesktop.application.Action
/*     */   public void ok()
/*     */   {
/* 149 */     String newLabel = this.nameTextField.getText().trim();
/*     */     
/* 151 */     if ((this.selectedNode instanceof NeuralNetwork)) {
/* 152 */       NeuralNetwork nnet = (NeuralNetwork)this.selectedNode;
/* 153 */       ((org.neuroph.util.plugins.LabelsPlugin)nnet.getPlugin("LabelsPlugin")).setLabel(nnet, newLabel);
/* 154 */       this.mainFrame.updateProjectTree();
/*     */     }
/* 156 */     else if ((this.selectedNode instanceof TrainingSet)) {
/* 157 */       TrainingSet trainingSet = (TrainingSet)this.selectedNode;
/* 158 */       trainingSet.setLabel(newLabel);
/* 159 */       this.mainFrame.updateProjectTree();
/*     */     }
/*     */     
/* 162 */     this.mainFrame.updateFrameTitles();
/*     */     
/* 164 */     dispose();
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\easyneurons\dialog\RenameNodeDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */