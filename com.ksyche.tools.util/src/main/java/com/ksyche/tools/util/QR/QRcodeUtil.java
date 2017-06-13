package com.ksyche.tools.util.QR;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.Dimension;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.GlobalHistogramBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRcodeUtil {

	public static void qrcode2Stream(OutputStream out ,
									String userHeadUrl,
									String contents,
									int width,
									int height ,
									String format){
		Hashtable<EncodeHintType,Object> hints = new Hashtable<EncodeHintType,Object>();
    	hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
    	hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
    	hints.put(EncodeHintType.MAX_SIZE, new Dimension(width,height));
		try {
			
			BitMatrix matrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height, hints);
			if(userHeadUrl.startsWith("http")){
				MatrixToImageWriter.writeToStream(matrix,new URL( userHeadUrl), format, out);
			} else {
				MatrixToImageWriter.writeToStream(matrix,new File( userHeadUrl), format, out);

			}	
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void qrcode2Stream(OutputStream out ,
									String contents,
									int width,
									int height ,
									String format){
		Hashtable<EncodeHintType,Object> hints = new Hashtable<EncodeHintType,Object>();
    	hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
    	hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
    	hints.put(EncodeHintType.MAX_SIZE, new Dimension(width,height));
		try {
		
			BitMatrix matrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height, hints);
			MatrixToImageWriter.writeToStream(matrix, format, out);
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String Decode(String path){
		BufferedImage image = null;
		Result result = null;
		try{
			image = ImageIO.read(new File(path));
			if(image == null){
				System.err.println("the decode iamge not exit.");
				return null;
			}
			
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			Binarizer binarizer = new GlobalHistogramBinarizer(source).createBinarizer(source);
			BinaryBitmap bitmap = new BinaryBitmap(binarizer);
			   
			Hashtable<DecodeHintType,String> hints = new Hashtable<DecodeHintType,String>();
		    hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
				   
			result = new MultiFormatReader().decode(bitmap,hints);
				   
		    return result.getText();
			   
		}catch(IOException e){
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
