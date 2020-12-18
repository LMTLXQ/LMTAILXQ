package org.book.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Code {

	private static StringBuffer codesave = null;
	public static BufferedImage paintImage(int width,int height){
		BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics graphics = img.getGraphics();
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, width, height);
		graphics.setColor(Color.WHITE);
		graphics.fillRect(1, 1, width-2, height-2);
		
		String code = "23456789abcdefghijklmnpqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ";
		Random rd = new Random();
		codesave = new StringBuffer();
		
		graphics.setFont(new Font("楷体",Font.BOLD,height-4));
		for(int i = 0;i<4;i++){
			graphics.setColor(new Color(rd.nextInt(256), rd.nextInt(256),rd.nextInt(256)));
			int index = rd.nextInt(code.length());
			codesave.append(code.substring(index,index+1));
			graphics.drawString(code.substring(index,index+1),width/6*(i+1), height-4);
		}
		return img;
	}
	public static String getCode(){
		if (codesave==null){
			return "";
		}
		return codesave.toString();
	}
}
