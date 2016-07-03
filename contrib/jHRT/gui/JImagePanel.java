/*    */ package org.neuroph.contrib.jHRT.gui;
/*    */ 
/*    */ import java.awt.Graphics;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.RenderingHints;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import javax.imageio.ImageIO;
/*    */ import javax.swing.JPanel;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JImagePanel
/*    */   extends JPanel
/*    */ {
/*    */   private BufferedImage image;
/* 43 */   private final int X = 150;
/*    */   
/* 45 */   private final int Y = 150;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void paintComponent(Graphics g)
/*    */   {
/* 56 */     super.paintComponent(g);
/*    */     try {
/* 58 */       g.drawImage(resize(this.image, 150, 150), (getWidth() - 150) / 2, (getHeight() - 150) / 2, null);
/*    */     }
/*    */     catch (NullPointerException e) {}
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setImage(String imagePath)
/*    */   {
/*    */     try
/*    */     {
/* 70 */       BufferedImage img = ImageIO.read(new File(imagePath));
/* 71 */       this.image = img;
/* 72 */       repaint();
/*    */     }
/*    */     catch (IOException ex) {}
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private BufferedImage resize(BufferedImage img, int newW, int newH)
/*    */   {
/* 86 */     int w = img.getWidth();
/* 87 */     int h = img.getHeight();
/* 88 */     BufferedImage dimg = new BufferedImage(newW, newH, img.getType());
/* 89 */     Graphics2D g = dimg.createGraphics();
/* 90 */     g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
/* 91 */     g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
/* 92 */     g.dispose();
/* 93 */     return dimg;
/*    */   }
/*    */ }


/* Location:              C:\Users\Nimish\Downloads\Neuroph OCR - jHRT alpha 0.2\Neuroph OCR - Handwriting Recognition alpha 0.2.jar!\org\neuroph\contrib\jHRT\gui\JImagePanel.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */