package com.lti.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CaptchaServlet
 */
@WebServlet("/captcha.jpg")
public class CaptchaServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		response.setContentType("image/jpeg");//MIME
		ServletOutputStream out=response.getOutputStream();//
		
		String str="01234456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		String captcha="";
		
		for(int i=0;i<=5;i++){
			int rno=(int)(Math.random() * str.length());
			captcha+=str.charAt(rno);
		}
		
		//generating an image now
		
		BufferedImage img=new BufferedImage(150,50,BufferedImage.TYPE_INT_RGB);// BufferedImage is an image processing
	
		Graphics g=img.getGraphics();// graphics class is used for drawing in the image
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 200, 200);
		g.setColor(Color.YELLOW);
		g.setFont(new Font ("Harrington",Font.BOLD,30));
		g.drawString(captcha, 30, 30);
		
		ImageIO.write(img,  "jpeg", out);//write the image inside the server
		
	}

}
