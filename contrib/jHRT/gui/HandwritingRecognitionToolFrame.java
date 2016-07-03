/*     */ package org.neuroph.contrib.jHRT.gui;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.font.TextAttribute;
/*     */ import javax.swing.DefaultListModel;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JList;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JSplitPane;
/*     */ import javax.swing.JToggleButton;
/*     */ 
/*     */ public class HandwritingRecognitionToolFrame extends javax.swing.JInternalFrame
/*     */ {
/*     */   private javax.swing.JComboBox NeuralNetworkFunctionTypeComboBox;
/*     */   private JDialog aboutDialog;
/*     */   private javax.swing.JMenuItem aboutMenuItem;
/*     */   private JPanel botomPanel;
/*     */   private JPanel bottomPanelII;
/*     */   private JPanel centerAboutPanel;
/*     */   private javax.swing.JTabbedPane centerTabbedPane;
/*     */   private JButton closeAboutButton;
/*     */   private JButton createNetworkButton;
/*     */   private DrawingPanel drawingPanelRecognition;
/*     */   private DrawingPanel drawingPanelTrening;
/*     */   private javax.swing.JMenuItem exitMenuItem;
/*     */   private javax.swing.JMenu fileMenu;
/*     */   private javax.swing.JMenu helpMenu;
/*     */   private javax.swing.JTextField hiddenLayerNeuronsTextField;
/*     */   private JButton jButton4;
/*     */   private JButton jButton5;
/*     */   private JButton jButton6;
/*     */   private JButton jButton7;
/*     */   private JButton jButton8;
/*     */   private JButton jButton9;
/*     */   private javax.swing.JCheckBox jCheckBox1;
/*     */   private JImagePanel jImagePanel;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private javax.swing.JMenuBar jMenuBar1;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel10;
/*     */   private JPanel jPanel11;
/*     */   private JPanel jPanel2;
/*     */   private JPanel jPanel3;
/*     */   
/*     */   public HandwritingRecognitionToolFrame(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconable)
/*     */   {
/*  61 */     super(title, resizable, closable, maximizable, iconable);
/*  62 */     initComponents();
/*  63 */     this.centerTabbedPane.remove(this.networkPanel);
/*  64 */     this.centerTabbedPane.remove(this.trainingPanel);
/*  65 */     TreeManager.setLettersTreeModel(this.jTree1);
/*     */     
/*  67 */     this.recognition = new org.neuroph.contrib.jHRT.LetterRecognition();
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
/*  80 */     this.aboutDialog = new JDialog();
/*  81 */     this.westAboutPanel = new JPanel();
/*  82 */     this.northAboutPanel = new JPanel();
/*  83 */     this.jPanel9 = new JPanel();
/*  84 */     this.logoAbout = new JLabel();
/*  85 */     this.jPanel10 = new JPanel();
/*  86 */     this.titleAbout = new JLabel();
/*  87 */     this.jLabel3 = new JLabel();
/*  88 */     this.centerAboutPanel = new JPanel();
/*  89 */     this.jScrollPane4 = new JScrollPane();
/*  90 */     this.jTextPane1 = new javax.swing.JTextPane();
/*  91 */     this.jPanel11 = new JPanel();
/*  92 */     this.closeAboutButton = new JButton();
/*  93 */     this.southPanel = new JPanel();
/*  94 */     this.jLabel1 = new JLabel();
/*  95 */     this.centerTabbedPane = new javax.swing.JTabbedPane();
/*  96 */     this.trainingPanel = new JPanel();
/*  97 */     this.jPanel5 = new JPanel();
/*  98 */     this.jPanel7 = new JPanel();
/*  99 */     this.jButton8 = new JButton();
/* 100 */     this.jButton9 = new JButton();
/* 101 */     this.jPanel6 = new JPanel();
/* 102 */     this.drawingPanelTrening = new DrawingPanel();
/* 103 */     this.jPanel8 = new JPanel();
/* 104 */     this.jImagePanel = new JImagePanel();
/* 105 */     this.jScrollPane3 = new JScrollPane();
/* 106 */     this.jTree1 = new javax.swing.JTree();
/* 107 */     this.jLabel2 = new JLabel();
/* 108 */     this.trainingButton = new JButton();
/* 109 */     this.nextButton = new JButton();
/* 110 */     this.networkPanel = new JPanel();
/* 111 */     this.createNetworkButton = new JButton();
/* 112 */     this.jPanel4 = new JPanel();
/* 113 */     this.jLabel6 = new JLabel();
/* 114 */     this.neuralNetworkNameTextField = new javax.swing.JTextField();
/* 115 */     this.jLabel4 = new JLabel();
/* 116 */     this.NeuralNetworkFunctionTypeComboBox = new javax.swing.JComboBox();
/* 117 */     this.jLabel5 = new JLabel();
/* 118 */     this.hiddenLayerNeuronsTextField = new javax.swing.JTextField();
/* 119 */     this.recognitionPanel = new JPanel();
/* 120 */     this.jSplitPane1 = new JSplitPane();
/* 121 */     this.leftPanel = new JPanel();
/* 122 */     this.jSplitPane2 = new JSplitPane();
/* 123 */     this.upperPanel = new JPanel();
/* 124 */     this.jPanel1 = new JPanel();
/* 125 */     this.jButton6 = new JButton();
/* 126 */     this.jButton7 = new JButton();
/* 127 */     this.jCheckBox1 = new javax.swing.JCheckBox();
/* 128 */     this.jPanel2 = new JPanel();
/* 129 */     this.jScrollPane2 = new JScrollPane();
/* 130 */     this.probabilitiesList = new JList();
/* 131 */     this.botomPanel = new JPanel();
/* 132 */     this.bottomPanelII = new JPanel();
/* 133 */     this.jButton4 = new JButton();
/* 134 */     this.jButton5 = new JButton();
/* 135 */     this.jPanel3 = new JPanel();
/* 136 */     this.drawingPanelRecognition = new DrawingPanel();
/* 137 */     this.rightPanel = new JPanel();
/* 138 */     this.rightBotomPanel = new JPanel();
/* 139 */     this.jSpinner1 = new javax.swing.JSpinner();
/* 140 */     this.jToggleButton1 = new JToggleButton();
/* 141 */     this.jToggleButton2 = new JToggleButton();
/* 142 */     this.jToggleButton3 = new JToggleButton();
/* 143 */     this.jScrollPane1 = new JScrollPane();
/* 144 */     this.jTextArea1 = new javax.swing.JTextArea();
/* 145 */     this.jMenuBar1 = new javax.swing.JMenuBar();
/* 146 */     this.fileMenu = new javax.swing.JMenu();
/* 147 */     this.exitMenuItem = new javax.swing.JMenuItem();
/* 148 */     this.helpMenu = new javax.swing.JMenu();
/* 149 */     this.aboutMenuItem = new javax.swing.JMenuItem();
/*     */     
/* 151 */     this.aboutDialog.setTitle("About");
/* 152 */     this.aboutDialog.setAlwaysOnTop(true);
/* 153 */     this.aboutDialog.setMinimumSize(new Dimension(440, 350));
/* 154 */     this.aboutDialog.setResizable(false);
/*     */     
/* 156 */     GroupLayout westAboutPanelLayout = new GroupLayout(this.westAboutPanel);
/* 157 */     this.westAboutPanel.setLayout(westAboutPanelLayout);
/* 158 */     westAboutPanelLayout.setHorizontalGroup(westAboutPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
/*     */     
/*     */ 
/*     */ 
/* 162 */     westAboutPanelLayout.setVerticalGroup(westAboutPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 201, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 167 */     this.aboutDialog.getContentPane().add(this.westAboutPanel, "Before");
/*     */     
/* 169 */     this.northAboutPanel.setPreferredSize(new Dimension(426, 60));
/* 170 */     this.northAboutPanel.setLayout(new javax.swing.BoxLayout(this.northAboutPanel, 2));
/*     */     
/* 172 */     this.logoAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/neuroph/contrib/jHRT/resources/Neuroph_OCR_logo_about.jpg")));
/* 173 */     this.jPanel9.add(this.logoAbout);
/*     */     
/* 175 */     this.northAboutPanel.add(this.jPanel9);
/*     */     
/* 177 */     this.jPanel10.setLayout(new java.awt.GridLayout(2, 0));
/*     */     
/* 179 */     this.titleAbout.setFont(new java.awt.Font("Times New Roman", 1, 18));
/* 180 */     this.titleAbout.setText("Neuroph OCR - Handwriting Recognition");
/* 181 */     this.jPanel10.add(this.titleAbout);
/*     */     
/* 183 */     this.jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
/* 184 */     this.jLabel3.setText("Version: 0.1 alpha");
/* 185 */     this.jPanel10.add(this.jLabel3);
/*     */     
/* 187 */     this.northAboutPanel.add(this.jPanel10);
/*     */     
/* 189 */     this.aboutDialog.getContentPane().add(this.northAboutPanel, "First");
/*     */     
/* 191 */     this.centerAboutPanel.setLayout(new java.awt.BorderLayout());
/*     */     
/* 193 */     this.jTextPane1.setEditable(false);
/* 194 */     this.jTextPane1.setText("This software is part of Neuroph Project, and it\ndemonstrates how neural networks can be applied for\nhandwritting recognition.\n\nSee http://neuroph.sourceforge.net for more info\n\n-----------Developers-----------\nBoris Horvat\n email: horvat.z.boris@gmail.com\nNemanja Jovanovic\n email: nemanja.jovanovic.1987@gmail.com\nDamir Kocic\n email: kocicdamir87@gmail.com\n\n--------------Mentor--------------\nZoran Sevarac\n email: sevarac@gmail.com\n\n----------Project page---------- http://www.netbeans-serbia.org/projects/handwritingrecognition");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 210 */     this.jScrollPane4.setViewportView(this.jTextPane1);
/*     */     
/* 212 */     this.centerAboutPanel.add(this.jScrollPane4, "Center");
/*     */     
/* 214 */     this.aboutDialog.getContentPane().add(this.centerAboutPanel, "Center");
/*     */     
/* 216 */     this.jPanel11.setLayout(new java.awt.FlowLayout(2));
/*     */     
/* 218 */     this.closeAboutButton.setText("Close");
/* 219 */     this.closeAboutButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 221 */         HandwritingRecognitionToolFrame.this.closeAboutButtonActionPerformed(evt);
/*     */       }
/* 223 */     });
/* 224 */     this.jPanel11.add(this.closeAboutButton);
/*     */     
/* 226 */     this.aboutDialog.getContentPane().add(this.jPanel11, "Last");
/*     */     
/* 228 */     this.aboutDialog.getAccessibleContext().setAccessibleParent(this.centerTabbedPane);
/*     */     
/* 230 */     setDefaultCloseOperation(2);
/* 231 */     setTitle("Neuroph OCR - Handwriting Recognition");
/* 232 */     setCursor(new java.awt.Cursor(0));
/* 233 */     setMinimumSize(new Dimension(800, 600));
/*     */     
/* 235 */     this.southPanel.setLayout(new java.awt.FlowLayout(0, 0, 0));
/* 236 */     this.southPanel.add(this.jLabel1);
/*     */     
/* 238 */     getContentPane().add(this.southPanel, "Last");
/*     */     
/* 240 */     this.centerTabbedPane.setPreferredSize(new Dimension(300, 130));
/*     */     
/* 242 */     this.trainingPanel.setLayout(new java.awt.BorderLayout());
/*     */     
/* 244 */     this.jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Create picture"));
/* 245 */     this.jPanel5.setMinimumSize(new Dimension(200, 50));
/* 246 */     this.jPanel5.setPreferredSize(new Dimension(300, 200));
/*     */     
/* 248 */     this.jPanel7.setLayout(new java.awt.GridBagLayout());
/*     */     
/* 250 */     this.jButton8.setText("Save");
/* 251 */     this.jButton8.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 253 */         HandwritingRecognitionToolFrame.this.jButton8ActionPerformed(evt);
/*     */       }
/* 255 */     });
/* 256 */     java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
/* 257 */     gridBagConstraints.gridwidth = 4;
/* 258 */     gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
/* 259 */     this.jPanel7.add(this.jButton8, gridBagConstraints);
/*     */     
/* 261 */     this.jButton9.setText("Clear");
/* 262 */     this.jButton9.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 264 */         HandwritingRecognitionToolFrame.this.jButton9ActionPerformed(evt);
/*     */       }
/* 266 */     });
/* 267 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 268 */     gridBagConstraints.gridwidth = 4;
/* 269 */     gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 1);
/* 270 */     this.jPanel7.add(this.jButton9, gridBagConstraints);
/*     */     
/* 272 */     this.jPanel6.setPreferredSize(new Dimension(200, 250));
/* 273 */     this.jPanel6.setLayout(new java.awt.GridBagLayout());
/*     */     
/* 275 */     DrawingListener dl1 = new DrawingListener(this.drawingPanelTrening);
/* 276 */     this.drawingPanelTrening.addMouseMotionListener(dl1);
/* 277 */     this.drawingPanelTrening.addMouseListener(dl1);
/* 278 */     this.drawingPanelTrening.setPreferredSize(new Dimension(200, 250));
/* 279 */     this.jPanel6.add(this.drawingPanelTrening, new java.awt.GridBagConstraints());
/*     */     
/* 281 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 282 */     this.jPanel5.setLayout(jPanel5Layout);
/* 283 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel6, -1, 278, 32767).addComponent(this.jPanel7, -1, 278, 32767)).addGap(10, 10, 10)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 291 */     jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jPanel6, -2, 334, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel7, -2, 55, -2).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 300 */     this.trainingPanel.add(this.jPanel5, "Before");
/*     */     
/* 302 */     this.jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Training set pictures"));
/*     */     
/* 304 */     this.jImagePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
/* 305 */     this.jImagePanel.setPreferredSize(new Dimension(150, 150));
/*     */     
/* 307 */     GroupLayout jImagePanelLayout = new GroupLayout(this.jImagePanel);
/* 308 */     this.jImagePanel.setLayout(jImagePanelLayout);
/* 309 */     jImagePanelLayout.setHorizontalGroup(jImagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 146, 32767));
/*     */     
/*     */ 
/*     */ 
/* 313 */     jImagePanelLayout.setVerticalGroup(jImagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 146, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 318 */     this.jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
/*     */       public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
/* 320 */         javax.swing.tree.TreePath[] paths = evt.getPaths();
/* 321 */         for (int i = 0; i < paths.length; i++) {
/* 322 */           if (!paths[i].getLastPathComponent().toString().contains("Lette")) {
/* 323 */             if (!evt.isAddedPath(i)) break;
/* 324 */             String path = new String();
/* 325 */             String folder = TreeManager.getPath();
/* 326 */             String file = paths[i].getLastPathComponent().toString();
/* 327 */             path = folder + "/" + file;
/* 328 */             HandwritingRecognitionToolFrame.this.jLabel2.setText(paths[i].getLastPathComponent().toString());
/* 329 */             HandwritingRecognitionToolFrame.this.jImagePanel.setImage(path);
/* 330 */             if (HandwritingRecognitionToolFrame.this.jImagePanel.isVisible()) break;
/* 331 */             HandwritingRecognitionToolFrame.this.jImagePanel.setVisible(true); break;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 338 */           HandwritingRecognitionToolFrame.this.jImagePanel.setVisible(false);
/* 339 */           HandwritingRecognitionToolFrame.this.jLabel2.setText(new String());
/*     */         }
/*     */         
/*     */       }
/* 343 */     });
/* 344 */     this.jScrollPane3.setViewportView(this.jTree1);
/*     */     
/* 346 */     this.trainingButton.setText("Create Training set");
/* 347 */     this.trainingButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 349 */         HandwritingRecognitionToolFrame.this.trainingButtonActionPerformed(evt);
/*     */       }
/*     */       
/* 352 */     });
/* 353 */     this.nextButton.setText("Next > ");
/* 354 */     this.nextButton.setEnabled(false);
/* 355 */     this.nextButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 357 */         HandwritingRecognitionToolFrame.this.nextButtonActionPerformed(evt);
/*     */       }
/*     */       
/* 360 */     });
/* 361 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 362 */     this.jPanel8.setLayout(jPanel8Layout);
/* 363 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addComponent(this.jScrollPane3, -2, 190, -2).addGap(18, 18, 18).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jImagePanel, -2, -1, -2).addGroup(jPanel8Layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.jLabel2, -2, 71, -2)))).addGroup(jPanel8Layout.createSequentialGroup().addComponent(this.trainingButton).addGap(18, 18, 18).addComponent(this.nextButton))).addContainerGap(83, 32767)));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 382 */     jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3, -2, -1, -2).addGroup(jPanel8Layout.createSequentialGroup().addComponent(this.jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jImagePanel, -2, -1, -2))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, 32767).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.trainingButton).addComponent(this.nextButton)).addContainerGap()));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 399 */     this.trainingPanel.add(this.jPanel8, "Center");
/*     */     
/* 401 */     this.centerTabbedPane.addTab("Images & training set", this.trainingPanel);
/*     */     
/* 403 */     this.createNetworkButton.setText("Create Network");
/* 404 */     this.createNetworkButton.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 406 */         HandwritingRecognitionToolFrame.this.createNetworkButtonActionPerformed(evt);
/*     */       }
/*     */       
/* 409 */     });
/* 410 */     this.jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Neural Netowrk Settings"));
/* 411 */     this.jPanel4.setLayout(new java.awt.GridBagLayout());
/*     */     
/* 413 */     this.jLabel6.setText("Neural network label:");
/* 414 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 415 */     gridBagConstraints.gridwidth = -1;
/* 416 */     gridBagConstraints.ipadx = 5;
/* 417 */     gridBagConstraints.anchor = 21;
/* 418 */     gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
/* 419 */     this.jPanel4.add(this.jLabel6, gridBagConstraints);
/*     */     
/* 421 */     this.neuralNetworkNameTextField.setPreferredSize(new Dimension(100, 25));
/* 422 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 423 */     gridBagConstraints.gridx = 0;
/* 424 */     gridBagConstraints.gridy = 1;
/* 425 */     gridBagConstraints.fill = 2;
/* 426 */     gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
/* 427 */     this.jPanel4.add(this.neuralNetworkNameTextField, gridBagConstraints);
/*     */     
/* 429 */     this.jLabel4.setText("Function:");
/* 430 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 431 */     gridBagConstraints.gridx = 0;
/* 432 */     gridBagConstraints.gridy = 2;
/* 433 */     gridBagConstraints.anchor = 21;
/* 434 */     gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
/* 435 */     this.jPanel4.add(this.jLabel4, gridBagConstraints);
/*     */     
/* 437 */     this.NeuralNetworkFunctionTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { org.neuroph.util.TransferFunctionType.valueOf("SIGMOID").getTypeLabel(), org.neuroph.util.TransferFunctionType.valueOf("TANH").getTypeLabel() }));
/* 438 */     this.NeuralNetworkFunctionTypeComboBox.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 440 */         HandwritingRecognitionToolFrame.this.NeuralNetworkFunctionTypeComboBoxActionPerformed(evt);
/*     */       }
/* 442 */     });
/* 443 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 444 */     gridBagConstraints.gridx = 0;
/* 445 */     gridBagConstraints.gridy = 3;
/* 446 */     gridBagConstraints.anchor = 21;
/* 447 */     gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
/* 448 */     this.jPanel4.add(this.NeuralNetworkFunctionTypeComboBox, gridBagConstraints);
/*     */     
/* 450 */     this.jLabel5.setText("Hidden Layers Neurons Count:");
/* 451 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 452 */     gridBagConstraints.gridx = 0;
/* 453 */     gridBagConstraints.gridy = 4;
/* 454 */     gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
/* 455 */     this.jPanel4.add(this.jLabel5, gridBagConstraints);
/*     */     
/* 457 */     this.hiddenLayerNeuronsTextField.setPreferredSize(new Dimension(100, 25));
/* 458 */     gridBagConstraints = new java.awt.GridBagConstraints();
/* 459 */     gridBagConstraints.gridx = 0;
/* 460 */     gridBagConstraints.gridy = 5;
/* 461 */     gridBagConstraints.fill = 2;
/* 462 */     this.jPanel4.add(this.hiddenLayerNeuronsTextField, gridBagConstraints);
/*     */     
/* 464 */     GroupLayout networkPanelLayout = new GroupLayout(this.networkPanel);
/* 465 */     this.networkPanel.setLayout(networkPanelLayout);
/* 466 */     networkPanelLayout.setHorizontalGroup(networkPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(networkPanelLayout.createSequentialGroup().addGroup(networkPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(networkPanelLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel4, -2, 210, -2)).addGroup(networkPanelLayout.createSequentialGroup().addGap(59, 59, 59).addComponent(this.createNetworkButton))).addContainerGap(543, 32767)));
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
/* 478 */     networkPanelLayout.setVerticalGroup(networkPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(networkPanelLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel4, -2, 202, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.createNetworkButton).addContainerGap(210, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 488 */     this.centerTabbedPane.addTab("Neural Network", this.networkPanel);
/*     */     
/* 490 */     this.recognitionPanel.setLayout(new java.awt.BorderLayout());
/*     */     
/* 492 */     this.jSplitPane1.setDividerLocation(250);
/*     */     
/* 494 */     this.leftPanel.setLayout(new java.awt.BorderLayout());
/*     */     
/* 496 */     this.jSplitPane2.setDividerLocation(180);
/* 497 */     this.jSplitPane2.setDividerSize(3);
/* 498 */     this.jSplitPane2.setOrientation(0);
/* 499 */     this.jSplitPane2.setEnabled(false);
/*     */     
/* 501 */     this.upperPanel.setLayout(new java.awt.BorderLayout());
/*     */     
/* 503 */     this.jButton6.setText("accept");
/* 504 */     this.jButton6.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 506 */         HandwritingRecognitionToolFrame.this.jButton6ActionPerformed(evt);
/*     */       }
/* 508 */     });
/* 509 */     this.jPanel1.add(this.jButton6);
/*     */     
/* 511 */     this.jButton7.setText("discard");
/* 512 */     this.jButton7.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 514 */         HandwritingRecognitionToolFrame.this.jButton7ActionPerformed(evt);
/*     */       }
/* 516 */     });
/* 517 */     this.jPanel1.add(this.jButton7);
/*     */     
/* 519 */     this.jCheckBox1.setText("auto add");
/* 520 */     this.jCheckBox1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 522 */         HandwritingRecognitionToolFrame.this.jCheckBox1ActionPerformed(evt);
/*     */       }
/* 524 */     });
/* 525 */     this.jPanel1.add(this.jCheckBox1);
/*     */     
/* 527 */     this.upperPanel.add(this.jPanel1, "Last");
/*     */     
/* 529 */     this.jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Probabilites"));
/* 530 */     this.jPanel2.setLayout(new java.awt.BorderLayout());
/*     */     
/* 532 */     this.probabilitiesList.setModel(new DefaultListModel());
/* 533 */     this.probabilitiesList.setSelectionMode(0);
/* 534 */     this.jScrollPane2.setViewportView(this.probabilitiesList);
/*     */     
/* 536 */     this.jPanel2.add(this.jScrollPane2, "Center");
/*     */     
/* 538 */     this.upperPanel.add(this.jPanel2, "Center");
/*     */     
/* 540 */     this.jSplitPane2.setTopComponent(this.upperPanel);
/*     */     
/* 542 */     this.botomPanel.setLayout(new java.awt.BorderLayout());
/*     */     
/* 544 */     this.jButton4.setText("recognize");
/* 545 */     this.jButton4.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 547 */         HandwritingRecognitionToolFrame.this.jButton4ActionPerformed(evt);
/*     */       }
/* 549 */     });
/* 550 */     this.bottomPanelII.add(this.jButton4);
/*     */     
/* 552 */     this.jButton5.setText("clear");
/* 553 */     this.jButton5.setPreferredSize(new Dimension(79, 23));
/* 554 */     this.jButton5.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 556 */         HandwritingRecognitionToolFrame.this.jButton5ActionPerformed(evt);
/*     */       }
/* 558 */     });
/* 559 */     this.bottomPanelII.add(this.jButton5);
/*     */     
/* 561 */     this.botomPanel.add(this.bottomPanelII, "Last");
/*     */     
/* 563 */     this.jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Drawing area"));
/* 564 */     this.jPanel3.addComponentListener(new java.awt.event.ComponentAdapter() {
/*     */       public void componentResized(java.awt.event.ComponentEvent evt) {
/* 566 */         HandwritingRecognitionToolFrame.this.jPanel3ComponentResized(evt);
/*     */       }
/* 568 */     });
/* 569 */     this.jPanel3.setLayout(new java.awt.BorderLayout());
/*     */     
/* 571 */     DrawingListener dl = new DrawingListener(this.drawingPanelRecognition);
/* 572 */     this.drawingPanelRecognition.addMouseListener(dl);
/* 573 */     this.drawingPanelRecognition.addMouseMotionListener(dl);
/* 574 */     this.jPanel3.add(this.drawingPanelRecognition, "Center");
/*     */     
/* 576 */     this.botomPanel.add(this.jPanel3, "Center");
/*     */     
/* 578 */     this.jSplitPane2.setRightComponent(this.botomPanel);
/*     */     
/* 580 */     this.leftPanel.add(this.jSplitPane2, "Center");
/*     */     
/* 582 */     this.jSplitPane1.setLeftComponent(this.leftPanel);
/*     */     
/* 584 */     this.rightPanel.setLayout(new java.awt.BorderLayout());
/*     */     
/* 586 */     this.jSpinner1.setModel(new javax.swing.SpinnerListModel(new String[] { "20", "24", "28", "32", "36" }));
/* 587 */     this.jSpinner1.setEditor(new javax.swing.JSpinner.ListEditor(this.jSpinner1));
/* 588 */     this.jSpinner1.setFocusable(false);
/* 589 */     this.jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
/*     */       public void stateChanged(javax.swing.event.ChangeEvent evt) {
/* 591 */         HandwritingRecognitionToolFrame.this.jSpinner1StateChanged(evt);
/*     */       }
/* 593 */     });
/* 594 */     this.jSpinner1.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyReleased(java.awt.event.KeyEvent evt) {
/* 596 */         HandwritingRecognitionToolFrame.this.jSpinner1KeyReleased(evt);
/*     */       }
/* 598 */     });
/* 599 */     this.rightBotomPanel.add(this.jSpinner1);
/*     */     
/* 601 */     this.jToggleButton1.setText("B");
/* 602 */     this.jToggleButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 604 */         HandwritingRecognitionToolFrame.this.jToggleButton1ActionPerformed(evt);
/*     */       }
/* 606 */     });
/* 607 */     this.rightBotomPanel.add(this.jToggleButton1);
/*     */     
/* 609 */     this.jToggleButton2.setText("I");
/* 610 */     this.jToggleButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 612 */         HandwritingRecognitionToolFrame.this.jToggleButton2ActionPerformed(evt);
/*     */       }
/* 614 */     });
/* 615 */     this.rightBotomPanel.add(this.jToggleButton2);
/*     */     
/* 617 */     this.jToggleButton3.setText("U");
/* 618 */     this.jToggleButton3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 620 */         HandwritingRecognitionToolFrame.this.jToggleButton3ActionPerformed(evt);
/*     */       }
/* 622 */     });
/* 623 */     this.rightBotomPanel.add(this.jToggleButton3);
/*     */     
/* 625 */     this.rightPanel.add(this.rightBotomPanel, "Last");
/*     */     
/* 627 */     this.jTextArea1.setFont(new java.awt.Font("Serif", 0, 20));
/* 628 */     this.jScrollPane1.setViewportView(this.jTextArea1);
/*     */     
/* 630 */     this.rightPanel.add(this.jScrollPane1, "Center");
/*     */     
/* 632 */     this.jSplitPane1.setRightComponent(this.rightPanel);
/*     */     
/* 634 */     this.recognitionPanel.add(this.jSplitPane1, "Center");
/*     */     
/* 636 */     this.centerTabbedPane.addTab("Test", this.recognitionPanel);
/*     */     
/* 638 */     getContentPane().add(this.centerTabbedPane, "Center");
/*     */     
/* 640 */     this.fileMenu.setText("File");
/*     */     
/* 642 */     this.exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(88, 2));
/* 643 */     this.exitMenuItem.setText("Exit");
/* 644 */     this.exitMenuItem.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 646 */         HandwritingRecognitionToolFrame.this.exitMenuItemActionPerformed(evt);
/*     */       }
/* 648 */     });
/* 649 */     this.fileMenu.add(this.exitMenuItem);
/*     */     
/* 651 */     this.jMenuBar1.add(this.fileMenu);
/*     */     
/* 653 */     this.helpMenu.setText("Help");
/*     */     
/* 655 */     this.aboutMenuItem.setText("About");
/* 656 */     this.aboutMenuItem.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 658 */         HandwritingRecognitionToolFrame.this.aboutMenuItemActionPerformed(evt);
/*     */       }
/* 660 */     });
/* 661 */     this.helpMenu.add(this.aboutMenuItem);
/*     */     
/* 663 */     this.jMenuBar1.add(this.helpMenu);
/*     */     
/* 665 */     setJMenuBar(this.jMenuBar1);
/*     */     
/* 667 */     pack();
/*     */   }
/*     */   
/*     */   private void exitMenuItemActionPerformed(ActionEvent evt) {
/* 671 */     System.exit(0);
/*     */   }
/*     */   
/*     */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 675 */     DefaultListModel model = (DefaultListModel)this.probabilitiesList.getModel();
/* 676 */     model.clear();
/* 677 */     this.drawingPanelRecognition.clearDrawingArea();
/*     */   }
/*     */   
/*     */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 681 */     this.drawingPanelRecognition.clearDrawingArea();
/* 682 */     ((DefaultListModel)this.probabilitiesList.getModel()).clear();
/* 683 */     new java.io.File("letter.png").delete();
/*     */   }
/*     */   
/*     */   private void jPanel3ComponentResized(java.awt.event.ComponentEvent evt) {
/* 687 */     this.drawingPanelRecognition.setPreferredSize(new Dimension(this.jPanel3.getWidth(), this.jPanel3.getHeight()));
/*     */   }
/*     */   
/*     */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 691 */     ((DefaultListModel)this.probabilitiesList.getModel()).clear();
/* 692 */     this.drawingPanelRecognition.getDrawnLetter();
/* 693 */     this.recognition.recognize((DefaultListModel)this.probabilitiesList.getModel());
/* 694 */     this.probabilitiesList.setSelectedIndex(0);
/* 695 */     if (this.jCheckBox1.isSelected()) {
/* 696 */       DefaultListModel model = (DefaultListModel)this.probabilitiesList.getModel();
/* 697 */       String letter = model.getElementAt(0).toString().substring(0, 1);
/* 698 */       model.clear();
/* 699 */       this.jTextArea1.append(letter);
/* 700 */       this.drawingPanelRecognition.clearDrawingArea();
/*     */     }
/* 702 */     new java.io.File("letter.png").delete();
/*     */   }
/*     */   
/*     */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 706 */     this.drawingPanelTrening.clearDrawingArea();
/*     */   }
/*     */   
/*     */   private void jButton8ActionPerformed(ActionEvent evt)
/*     */   {
/* 711 */     org.neuroph.contrib.jHRT.SaveImage.createTrainingSetFolder();
/*     */     
/* 713 */     String letter = javax.swing.JOptionPane.showInputDialog("Enter the drawn letter!!!").toUpperCase();
/* 714 */     this.drawingPanelTrening.saveDrawnLetter(letter);
/* 715 */     javax.swing.JOptionPane.showMessageDialog(this, "Letter succesfully added!!!");
/* 716 */     this.drawingPanelTrening.clearDrawingArea();
/* 717 */     TreeManager.setLettersTreeModel(this.jTree1);
/*     */   }
/*     */   
/*     */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 721 */     if (this.probabilitiesList.getSelectedIndex() > -1) {
/* 722 */       DefaultListModel model = (DefaultListModel)this.probabilitiesList.getModel();
/* 723 */       String letter = model.getElementAt(this.probabilitiesList.getSelectedIndex()).toString().substring(0, 1);
/* 724 */       model.clear();
/* 725 */       this.jTextArea1.append(letter);
/* 726 */       this.drawingPanelRecognition.clearDrawingArea();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void jToggleButton1ActionPerformed(ActionEvent evt)
/*     */   {
/* 733 */     if (evt.getActionCommand().equals("B")) {
/* 734 */       this.styles.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
/* 735 */       this.jToggleButton1.setText(" B");
/*     */     } else {
/* 737 */       this.styles.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_REGULAR);
/* 738 */       this.jToggleButton1.setText("B");
/*     */     }
/* 740 */     this.font = this.font.deriveFont(this.styles);
/* 741 */     this.jTextArea1.setFont(this.font);
/*     */   }
/*     */   
/*     */   private void jToggleButton2ActionPerformed(ActionEvent evt) {
/* 745 */     if (evt.getActionCommand().equals("I")) {
/* 746 */       this.styles.put(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE);
/* 747 */       this.jToggleButton2.setText(" I");
/*     */     } else {
/* 749 */       this.styles.put(TextAttribute.POSTURE, TextAttribute.POSTURE_REGULAR);
/* 750 */       this.jToggleButton2.setText("I");
/*     */     }
/* 752 */     this.font = this.font.deriveFont(this.styles);
/* 753 */     this.jTextArea1.setFont(this.font);
/*     */   }
/*     */   
/*     */   private void jToggleButton3ActionPerformed(ActionEvent evt) {
/* 757 */     if (evt.getActionCommand().equals("U")) {
/* 758 */       this.styles.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
/* 759 */       this.jToggleButton3.setText(" U");
/*     */     } else {
/* 761 */       this.styles.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE);
/* 762 */       this.jToggleButton3.setText("U");
/*     */     }
/* 764 */     this.font = this.font.deriveFont(this.styles);
/* 765 */     this.jTextArea1.setFont(this.font);
/*     */   }
/*     */   
/*     */   private void jSpinner1KeyReleased(java.awt.event.KeyEvent evt) {
/* 769 */     this.jSpinner1.setValue(Integer.valueOf(20));
/*     */   }
/*     */   
/*     */   private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {
/* 773 */     int i = Integer.parseInt((String)this.jSpinner1.getValue());
/* 774 */     this.styles.put(TextAttribute.SIZE, Integer.valueOf(i));
/* 775 */     this.font = this.font.deriveFont(this.styles);
/* 776 */     this.jTextArea1.setFont(this.font);
/*     */   }
/*     */   
/*     */   private void aboutMenuItemActionPerformed(ActionEvent evt) {
/* 780 */     this.aboutDialog.setBounds(350, 200, 0, 0);
/* 781 */     this.aboutDialog.setVisible(true);
/*     */   }
/*     */   
/*     */   private void closeAboutButtonActionPerformed(ActionEvent evt) {
/* 785 */     this.aboutDialog.setVisible(false);
/*     */   }
/*     */   
/*     */ 
/*     */   private void jCheckBox1ActionPerformed(ActionEvent evt) {}
/*     */   
/*     */   private void trainingButtonActionPerformed(ActionEvent evt)
/*     */   {
/* 793 */     java.util.HashMap<String, org.neuroph.contrib.imgrec.FractionRgbData> rgbDataMap = new java.util.HashMap();
/* 794 */     String imageDir = "Letters/Training Set/";
/*     */     try {
/* 796 */       java.io.File labeledImagesDir = new java.io.File(imageDir);
/* 797 */       rgbDataMap.putAll(org.neuroph.easyneurons.imgrec.ImagesLoader.getFractionRgbDataForDirectory(labeledImagesDir, new Dimension(40, 40)));
/*     */       
/*     */ 
/* 800 */       for (String imgName : rgbDataMap.keySet()) {
/* 801 */         java.util.StringTokenizer st = new java.util.StringTokenizer(imgName, "._");
/* 802 */         String imageLabel = st.nextToken();
/* 803 */         if (!this.imageLabels.contains(imageLabel)) {
/* 804 */           this.imageLabels.add(imageLabel);
/*     */         }
/*     */       }
/* 807 */       java.util.Collections.sort(this.imageLabels);
/*     */     } catch (java.io.IOException ioe) {
/* 809 */       System.err.println("Unable to load images from labeled images dir: '" + imageDir + "'");
/* 810 */       System.err.println(ioe.toString());
/*     */     }
/*     */     
/* 813 */     this.activeTrainingSet = org.neuroph.contrib.imgrec.ImageRecognitionHelper.createTrainingSet(this.imageLabels, rgbDataMap);
/*     */     
/* 815 */     int neurons = 0;
/* 816 */     if (this.imageLabels.size() < 12) {
/* 817 */       neurons = 12;
/*     */     } else {
/* 819 */       neurons = this.imageLabels.size();
/*     */     }
/*     */     
/* 822 */     this.hiddenLayerNeuronsTextField.setText(Integer.toString(neurons));
/*     */     
/* 824 */     this.nextButton.setEnabled(true);
/*     */   }
/*     */   
/*     */   private void createNetworkButtonActionPerformed(ActionEvent evt) {
/* 828 */     org.neuroph.util.TransferFunctionType transferFunctionType = org.neuroph.util.TransferFunctionType.valueOf(this.NeuralNetworkFunctionTypeComboBox.getSelectedItem().toString().toUpperCase());
/* 829 */     String name = this.neuralNetworkNameTextField.getText();
/* 830 */     String hiddenLayersStr = this.hiddenLayerNeuronsTextField.getText();
/*     */     
/*     */     java.util.Vector<Integer> hiddenLayersNeuronsCount;
/*     */     try
/*     */     {
/* 835 */       hiddenLayersNeuronsCount = org.neuroph.util.VectorParser.parseInteger(hiddenLayersStr);
/*     */     } catch (Exception ex) {
/* 837 */       javax.swing.JOptionPane.showConfirmDialog(null, "Invalid input! Hidden Layers Neuron Counts must be entered as space separated integers.", "Error", -1);
/*     */       
/*     */ 
/* 840 */       return;
/*     */     }
/*     */     
/*     */ 
/* 844 */     org.neuroph.core.NeuralNetwork activeNeuralNetwork = org.neuroph.contrib.imgrec.ImageRecognitionHelper.createNewNeuralNetwork(name, new Dimension(40, 40), org.neuroph.contrib.imgrec.ColorMode.BLACK_AND_WHITE, this.imageLabels, hiddenLayersNeuronsCount, transferFunctionType);
/* 845 */     org.neuroph.nnet.learning.MomentumBackpropagation mbp = new org.neuroph.nnet.learning.MomentumBackpropagation();
/* 846 */     mbp.setLearningRate(0.1D);
/* 847 */     mbp.setMaxError(0.01D);
/* 848 */     mbp.setMomentum(0.0D);
/* 849 */     activeNeuralNetwork.learnInNewThread(this.activeTrainingSet, mbp);
/* 850 */     activeNeuralNetwork.save(name + ".nnet");
/* 851 */     this.centerTabbedPane.setSelectedIndex(2);
/*     */     
/* 853 */     this.recognition = new org.neuroph.contrib.jHRT.LetterRecognition(name + ".nnet");
/*     */   }
/*     */   
/*     */   private void nextButtonActionPerformed(ActionEvent evt)
/*     */   {
/* 858 */     this.centerTabbedPane.setSelectedIndex(1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private JPanel jPanel4;
/*     */   
/*     */ 
/*     */   private JPanel jPanel5;
/*     */   
/*     */ 
/*     */   private JPanel jPanel6;
/*     */   
/*     */ 
/*     */   private JPanel jPanel7;
/*     */   
/*     */   private JPanel jPanel8;
/*     */   
/*     */   private JPanel jPanel9;
/*     */   
/*     */   private JScrollPane jScrollPane1;
/*     */   
/*     */   private JScrollPane jScrollPane2;
/*     */   
/*     */   private JScrollPane jScrollPane3;
/*     */   
/*     */   private JScrollPane jScrollPane4;
/*     */   
/*     */   private javax.swing.JSpinner jSpinner1;
/*     */   
/*     */   private JSplitPane jSplitPane1;
/*     */   
/*     */   private JSplitPane jSplitPane2;
/*     */   
/*     */   private javax.swing.JTextArea jTextArea1;
/*     */   
/*     */   private javax.swing.JTextPane jTextPane1;
/*     */   
/*     */   private JToggleButton jToggleButton1;
/*     */   
/*     */   private JToggleButton jToggleButton2;
/*     */   
/*     */   private JToggleButton jToggleButton3;
/*     */   
/*     */   private javax.swing.JTree jTree1;
/*     */   
/*     */   private JPanel leftPanel;
/*     */   
/*     */   private JLabel logoAbout;
/*     */   
/*     */   private JPanel networkPanel;
/*     */   
/*     */   private javax.swing.JTextField neuralNetworkNameTextField;
/*     */   
/*     */   private JButton nextButton;
/*     */   
/*     */   private JPanel northAboutPanel;
/*     */   
/*     */   private JList probabilitiesList;
/*     */   
/*     */   private JPanel recognitionPanel;
/*     */   
/*     */   private JPanel rightBotomPanel;
/*     */   
/*     */   private JPanel rightPanel;
/*     */   
/*     */   private JPanel southPanel;
/*     */   
/*     */   private JLabel titleAbout;
/*     */   
/*     */   private JButton trainingButton;
/*     */   
/*     */   private JPanel trainingPanel;
/*     */   
/*     */   private JPanel upperPanel;
/*     */   
/*     */   private JPanel westAboutPanel;
/*     */   
/*     */   private org.neuroph.contrib.jHRT.LetterRecognition recognition;
/*     */   
/* 938 */   private java.util.Map<TextAttribute, Object> styles = new java.util.Hashtable();
/* 939 */   private java.awt.Font font = new java.awt.Font("Serif", 0, 20);
/*     */   org.neuroph.core.learning.TrainingSet activeTrainingSet;
/* 941 */   java.util.ArrayList<String> imageLabels = new java.util.ArrayList();
/*     */   
/*     */   private void NeuralNetworkFunctionTypeComboBoxActionPerformed(ActionEvent evt) {}
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\contrib\jHRT\gui\HandwritingRecognitionToolFrame.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */