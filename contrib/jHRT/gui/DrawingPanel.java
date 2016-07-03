/*     */ package org.neuroph.contrib.jHRT.gui;
/*     */ 
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Point;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.geom.Line2D.Double;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.JPanel;
/*     */ import org.neuroph.contrib.imgrec.ImageSampler;
/*     */ import org.neuroph.contrib.jHRT.Cleaner;
/*     */ import org.neuroph.contrib.jHRT.SaveImage;
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
/*     */ public class DrawingPanel
/*     */   extends JPanel
/*     */ {
/*     */   public static final int FIXED_WIDTH = 40;
/*     */   public static final int FIXED_HIGHT = 40;
/*     */   private BufferedImage image;
/*     */   
/*     */   public DrawingPanel()
/*     */   {
/*  62 */     setBackground(Color.WHITE);
/*     */   }
/*     */   
/*     */   protected void paintComponent(Graphics g)
/*     */   {
/*  67 */     super.paintComponent(g);
/*  68 */     if (this.image == null) {
/*  69 */       createDrawingArea();
/*     */     } else {
/*  71 */       recreateDrawingArea(this.image, getWidth(), getHeight());
/*     */     }
/*  73 */     g.drawImage(this.image, 0, 0, this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void draw(Point start, Point end)
/*     */   {
/*  83 */     Graphics2D g2 = this.image.createGraphics();
/*  84 */     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*     */     
/*     */ 
/*  87 */     g2.setPaint(Color.BLACK);
/*  88 */     g2.setStroke(new BasicStroke(10.0F, 1, 0));
/*     */     
/*  90 */     g2.draw(new Line2D.Double(start, end));
/*  91 */     g2.dispose();
/*     */     
/*  93 */     repaint();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void clearDrawingArea()
/*     */   {
/* 100 */     Graphics g = this.image.getGraphics();
/*     */     
/* 102 */     g.setColor(getBackground());
/* 103 */     g.fillRect(0, 0, this.image.getWidth(), this.image.getHeight());
/* 104 */     g.dispose();
/*     */     
/* 106 */     repaint();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void getDrawnLetter()
/*     */   {
/* 115 */     prepareImage();
/*     */     
/* 117 */     int upperCoordinate = getUpperCoordinate();
/* 118 */     int bottomCoordinate = getBottomCoordinate(upperCoordinate);
/* 119 */     int leftCoordinate = getLeftCoordinate(upperCoordinate, bottomCoordinate);
/* 120 */     int rightCoordinate = getRightCoordinate(upperCoordinate, bottomCoordinate, leftCoordinate);
/*     */     
/* 122 */     BufferedImage subImage = reSizingImage(this.image.getSubimage(leftCoordinate, upperCoordinate, rightCoordinate - leftCoordinate, bottomCoordinate - upperCoordinate));
/*     */     
/* 124 */     subImage = Cleaner.blackAndLightGrayCleaning(subImage);
/*     */     try {
/* 126 */       ImageIO.write(subImage, "PNG", new File("letter.png"));
/*     */     } catch (IOException ex) {
/* 128 */       throw new RuntimeException("No drawing could be founded, try writing again");
/*     */     }
/*     */   }
/*     */   
/*     */   public void saveDrawnLetter(String letter)
/*     */   {
/* 134 */     prepareImage();
/*     */     
/* 136 */     int upperCoordinate = getUpperCoordinate();
/* 137 */     int bottomCoordinate = getBottomCoordinate(upperCoordinate);
/* 138 */     int leftCoordinate = getLeftCoordinate(upperCoordinate, bottomCoordinate);
/* 139 */     int rightCoordinate = getRightCoordinate(upperCoordinate, bottomCoordinate, leftCoordinate);
/*     */     
/* 141 */     BufferedImage subImage = reSizingImage(this.image.getSubimage(leftCoordinate, upperCoordinate, rightCoordinate - leftCoordinate, bottomCoordinate - upperCoordinate));
/*     */     
/* 143 */     subImage = Cleaner.blackAndLightGrayCleaning(subImage);
/* 144 */     int fileNumber = SaveImage.numberOfFiles(letter) + 1;
/*     */     try {
/* 146 */       ImageIO.write(subImage, "PNG", new File("Letters/Training Set/" + letter.toUpperCase() + "_" + fileNumber + ".png"));
/*     */     } catch (IOException ex) {
/* 148 */       throw new RuntimeException("No drawing could be founded, try writing again");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void createDrawingArea()
/*     */   {
/* 157 */     this.image = new BufferedImage(getWidth(), getHeight(), 1);
/*     */     
/* 159 */     Graphics2D g2 = this.image.createGraphics();
/* 160 */     g2.setPaint(getBackground());
/* 161 */     g2.fillRect(0, 0, getWidth(), getHeight());
/* 162 */     g2.dispose();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void recreateDrawingArea(BufferedImage bufferedImage, int width, int height)
/*     */   {
/* 174 */     BufferedImage newImage = new BufferedImage(width, height, bufferedImage.getType());
/* 175 */     Graphics2D g = newImage.createGraphics();
/*     */     
/* 177 */     g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
/*     */     
/*     */ 
/* 180 */     g.setColor(Color.WHITE);
/* 181 */     g.fillRect(0, 0, width, height);
/* 182 */     g.drawImage(bufferedImage, 0, 0, width, height, 0, 0, width, height, null);
/* 183 */     g.dispose();
/*     */     
/* 185 */     this.image = newImage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private BufferedImage reSizingImage(BufferedImage bufferedImage)
/*     */   {
/* 197 */     BufferedImage newImage = new BufferedImage(40, 40, bufferedImage.getType());
/* 198 */     Graphics2D g = newImage.createGraphics();
/*     */     
/* 200 */     g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
/*     */     
/*     */ 
/* 203 */     g.setColor(Color.WHITE);
/* 204 */     g.fillRect(0, 0, 40, 40);
/* 205 */     g.drawImage(bufferedImage, 0, 0, 40, 40, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null);
/*     */     
/* 207 */     g.dispose();
/*     */     
/* 209 */     return ImageSampler.downSampleImage(new Dimension(40, 40), newImage);
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
/*     */   private int getUpperCoordinate()
/*     */   {
/* 223 */     for (int i = 0; i < this.image.getHeight(); i++) {
/* 224 */       for (int j = 0; j < this.image.getWidth(); j++) {
/* 225 */         if (this.image.getRGB(j, i) != -1) {
/* 226 */           return i - 1;
/*     */         }
/*     */       }
/*     */     }
/* 230 */     throw new RuntimeException("No drawing could be founded, try writing again");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getBottomCoordinate(int upperCoordinate)
/*     */   {
/* 249 */     for (int i = upperCoordinate + 1; i < this.image.getHeight(); i++) {
/* 250 */       int counter = 0;
/* 251 */       for (int j = 0; j < this.image.getWidth(); j++) {
/* 252 */         if (this.image.getRGB(j, i) == -1) {
/* 253 */           counter++;
/*     */         }
/*     */       }
/* 256 */       if (counter == this.image.getWidth()) {
/* 257 */         return i;
/*     */       }
/*     */     }
/* 260 */     throw new RuntimeException("No drawing could be founded, try writing again");
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
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getLeftCoordinate(int upperCoordinate, int bottomCoordinate)
/*     */   {
/* 278 */     for (int i = 0; i < this.image.getWidth(); i++) {
/* 279 */       for (int j = upperCoordinate + 1; j < bottomCoordinate; j++) {
/* 280 */         if (this.image.getRGB(i, j) != -1) {
/* 281 */           return i - 1;
/*     */         }
/*     */       }
/*     */     }
/* 285 */     throw new RuntimeException("No drawing could be founded, try writing again");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getRightCoordinate(int upperCoordinate, int bottomCoordinate, int leftCoordinate)
/*     */   {
/* 306 */     for (int i = leftCoordinate + 1; i < this.image.getWidth(); i++) {
/* 307 */       int counter = 0;
/* 308 */       for (int j = upperCoordinate + 1; j < bottomCoordinate; j++) {
/* 309 */         if (this.image.getRGB(i, j) == -1) {
/* 310 */           counter++;
/*     */         }
/*     */       }
/*     */       
/* 314 */       if (counter == bottomCoordinate - upperCoordinate - 1) {
/* 315 */         return i;
/*     */       }
/*     */     }
/* 318 */     throw new RuntimeException("No drawing could be founded, try writing again");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void prepareImage()
/*     */   {
/* 326 */     int height = this.image.getHeight();
/* 327 */     int width = this.image.getWidth();
/*     */     
/* 329 */     for (int i = 0; i < height; i++) {
/* 330 */       this.image.setRGB(0, i, -1);
/* 331 */       this.image.setRGB(width - 1, i, -1);
/*     */     }
/*     */     
/* 334 */     for (int i = 0; i < width; i++) {
/* 335 */       this.image.setRGB(i, 0, -1);
/* 336 */       this.image.setRGB(i, height - 1, -1);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\contrib\jHRT\gui\DrawingPanel.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */