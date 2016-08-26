package com.chuangyejia.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;


public class IdentifyCode {
      
	/**
	 * 此为验证码的数字结果
	 */
	private Integer result = 0;
	
    public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	public IdentifyCode() {
        super();
    }
    
    /**
     * 这是将数字转换为汉字的函数
     * @param number (0123456789)
     * @return String (零壹贰叁肆伍陆柒捌玖)
     */
    private String changeNumber(int number) {
    	final String chineseNum = "零壹贰叁肆伍陆柒捌玖";
    	switch(number) {
    	case 0:
    		return String.valueOf(chineseNum.charAt(0));
    	case 1:
    		return String.valueOf(chineseNum.charAt(1));
    	case 2:
    		return String.valueOf(chineseNum.charAt(2));
    	case 3:
    		return String.valueOf(chineseNum.charAt(3));
    	case 4:
    		return String.valueOf(chineseNum.charAt(4));
    	case 5:
    		return String.valueOf(chineseNum.charAt(5));
    	case 6:
    		return String.valueOf(chineseNum.charAt(6));
    	case 7:
    		return String.valueOf(chineseNum.charAt(7));
    	case 8:
    		return String.valueOf(chineseNum.charAt(8));
    	case 9:
    		return String.valueOf(chineseNum.charAt(9));
    		default:
    			return null;
    	}
    }
    
    /**
     * 
     * 这是将运算符号转换为汉字的函数
     * @param sign (+-*)
     * @return String (加减乘)
     */
    private String changeSign(String sign) {
    	final String chineseSign = "加减乘";
    	switch(sign) {
    	case "+":
    		return String.valueOf(chineseSign.charAt(0));
    	case "-":
    		return String.valueOf(chineseSign.charAt(1));
    	case "*":
    		return String.valueOf(chineseSign.charAt(2));
    		default:
    			return null;
    	}
    }
    
	public ByteArrayInputStream createCode() {
	
		Random random = new Random();
		
		BufferedImage bi = new BufferedImage(110, 30, BufferedImage.TYPE_INT_RGB);
		
		Graphics g = bi.getGraphics();
		Color c = g.getColor();
		
		/**
		 * 设定要使用的数组
		 */
		String[] arr1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
		String[] arr2 = {"+", "-", "*"};
		String[] arr3 = {"-", "+"};
		
		String s1 = arr1[random.nextInt(10)];
		String s2 = arr2[random.nextInt(3)];//运算符
		String s3 = arr1[random.nextInt(10)];
		String s4 = arr3[random.nextInt(2)];//运算符(第二个运算符只给+-，防止因为运算符的优先级问题，导致前台答案混淆)
		String s5 = arr1[random.nextInt(10)];
		/**
		 * 计算数字结果
		 */
		result = 0;
		switch(s2+s4) {
		case "+-":
			result = Integer.valueOf(s1) + Integer.valueOf(s3) - Integer.valueOf(s5);
			break;
		case "++":
			result = Integer.valueOf(s1) + Integer.valueOf(s3) + Integer.valueOf(s5);
			break;
		case "-+":
			result = Integer.valueOf(s1) - Integer.valueOf(s3) + Integer.valueOf(s5);
			break;
		case "--":
			result = Integer.valueOf(s1) - Integer.valueOf(s3) - Integer.valueOf(s5);
			break;
		case "*+":
			result = Integer.valueOf(s1) * Integer.valueOf(s3) + Integer.valueOf(s5);
			break;
		case "*-":
			result = Integer.valueOf(s1) * Integer.valueOf(s3) - Integer.valueOf(s5);
			break;
		}

		/**
		 * 将数字和运算符转换为汉字
		 */
		String code = changeNumber(Integer.valueOf(s1)) + changeSign(s2) + changeNumber(Integer.valueOf(s3)) + changeSign(s4) + changeNumber(Integer.valueOf(s5));
		
		/**
		 * 进行绘画处理
		 */
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font(code, Font.ITALIC, 19));
		g.drawString(code, 0, 20);
	
		g.setColor(c);
		
		ByteArrayInputStream inputStream = null;  
	    ByteArrayOutputStream bos = new ByteArrayOutputStream();  
	    JPEGImageEncoder jpeg = JPEGCodec.createJPEGEncoder(bos);  
	    try {  
	        jpeg.encode(bi);  
	        byte[] bts = bos.toByteArray();  
	        inputStream = new ByteArrayInputStream(bts);  
		} catch (ImageFormatException e) {  
			e.printStackTrace();  
		} catch (IOException e) {  
			e.printStackTrace();  
		} 
		return inputStream;
	}
}
