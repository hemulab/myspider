package com.ksyche.tools.util.QR;  
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

import javax.imageio.ImageIO;

import com.google.zxing.common.BitMatrix;
   
   
 public final class MatrixToImageWriter {  
   
   private static final int BLACK = 0xFF000000;  
   private static final int WHITE = 0xFFFFFFFF;  
   
   private MatrixToImageWriter() {}  
   
     
   public static BufferedImage toBufferedImage(BitMatrix matrix) {  
     int width = matrix.getWidth();  
     int height = matrix.getHeight();  
     BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
     for (int x = 0; x < width; x++) {  
       for (int y = 0; y < height; y++) {  
         image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);  
       }  
     }  
     return image;  
   }  
   
     
   public static void writeToFile(BitMatrix matrix, String format, File file)  
       throws IOException {  
     BufferedImage image = toBufferedImage(matrix);  
     if (!ImageIO.write(image, format, file)) {  
       throw new IOException("Could not write an image of format " + format + " to " + file);  
     }  
   }  
   
     
   public static void writeToStream(BitMatrix matrix, String format, OutputStream stream)  
       throws IOException {  
     BufferedImage image = toBufferedImage(matrix);  
     if (!ImageIO.write(image, format, stream)) {  
       throw new IOException("Could not write an image of format " + format);  
     }  
   }

   /**
    * 个人头像在中间的二维码
    * @param matrix
    * @param userheadUrl
    * @return
    * @throws IOException
    */
	public static BufferedImage toBufferedImage(BitMatrix matrix,URL userheadUrl) throws IOException {  
	    int width = matrix.getWidth();  
	    int height = matrix.getHeight();  
	    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_USHORT_555_RGB);  
	    for (int x = 0; x < width; x++) {  
	      for (int y = 0; y < height; y++) {  
	        image.setRGB(x, y, matrix.get(x, y)? BLACK : WHITE);  
	      }  
	      
	    }  
	    BufferedImage read = ImageIO.read(userheadUrl);
	   
	    Graphics graphics = image.getGraphics();
	   // 绘制个人头像
	    graphics.drawImage(read, width/2-(width/10), height/2-(height/10), width/5, height/5, null);
	    
	    //绘制外边框
	    graphics.drawRoundRect(width/2-(width/10), height/2-(height/10), width/5,  height/5, width/60, width/60);
	    return image;  
	 }  
	
	
	public static BufferedImage toBufferedImage(BitMatrix matrix,File userheadUrl) throws IOException {  
	    int width = matrix.getWidth();  
	    int height = matrix.getHeight();  
	    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
	    for (int x = 0; x < width; x++) {  
	      for (int y = 0; y < height; y++) {  
	        image.setRGB(x, y, matrix.get(x, y)? BLACK : WHITE);  
	      }  
	      
	    }  
	    BufferedImage read = ImageIO.read(userheadUrl);
	   
	    Graphics graphics = image.getGraphics();
	   // 绘制个人头像
	    graphics.drawImage(read, width/2-(width/10), height/2-(height/10), width/5, height/5, null);
	    
	    //绘制外边框
	    graphics.drawRoundRect(width/2-(width/10), height/2-(height/10), width/5,  height/5, width/60, width/60);
	    return image;  
	 }  
	
	
	  public static void writeToFile(BitMatrix matrix,URL userheadUrl, String format, File file)  
		       throws IOException {  
		     BufferedImage image = toBufferedImage(matrix,userheadUrl);  
		     if (!ImageIO.write(image, format, file)) {  
		       throw new IOException("Could not write an image of format " + format + " to " + file);  
		     }  
		   }  
		   
	  public static void writeToFile(BitMatrix matrix,File userheadUrl, String format, File file)  
		       throws IOException {  
		     BufferedImage image = toBufferedImage(matrix,userheadUrl);  
		     if (!ImageIO.write(image, format, file)) {  
		       throw new IOException("Could not write an image of format " + format + " to " + file);  
		     }  
		   }  	
	  
	  
	   public static void writeToStream(BitMatrix matrix ,URL userheadUrl, String format, OutputStream stream)  
	       throws IOException {  
	     BufferedImage image = toBufferedImage(matrix,userheadUrl);  
	     if (!ImageIO.write(image, format, stream)) {  
	       throw new IOException("Could not write an image of format " + format);  
	     }  
	   }

	

	   public static void writeToStream(BitMatrix matrix ,File userheadUrl, String format, OutputStream stream)  
	       throws IOException {  
	     BufferedImage image = toBufferedImage(matrix,userheadUrl);  
	     if (!ImageIO.write(image, format, stream)) {  
	       throw new IOException("Could not write an image of format " + format);  
	     }  
	   }

	   

 }  