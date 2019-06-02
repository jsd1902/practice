package com.webserver.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

/**
 * 随机验证码
 * 
 * @author adminitartor
 *
 */
public class RandomImageServlet extends HttpServlet {
	private static char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
	// 图片宽高
	private static int IMAGE_WIDTH = 65;
	private static int IMAGE_HEIGHT = 25;

	public void service(HttpRequest request, HttpResponse response) {
		System.out.println("RandomImageServlet:生成随机验证码图片...");

		// 创建画布 xxx.jpg
		BufferedImage image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
		// 获取对这张图的画笔，用于往这张图上画内容
		Graphics g = image.getGraphics();

		// 创建一个颜色
		Color coloer = new Color(200, 200, 255);
		// 设置画笔为这个颜色
		g.setColor(coloer);

		// 使用画笔填充一个矩形，颜色为当前画笔指定颜色
		g.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);

		Random random = new Random();
		g.setFont(new Font("Default", Font.BOLD, 20));
		for (int i = 0; i < 4; i++) {
			g.setColor(new Color(random.nextInt(100), random.nextInt(180), random.nextInt(160)));
			g.drawString(chars[random.nextInt(chars.length)] + "", i * 15 + 5, 18);
		}

		for (int i = 0; i < 6; i++) {
			g.setColor(new Color(random.nextInt(100), random.nextInt(180), random.nextInt(160)));
			g.drawLine(random.nextInt(IMAGE_WIDTH), random.nextInt(IMAGE_HEIGHT), random.nextInt(IMAGE_WIDTH), random.nextInt(IMAGE_HEIGHT));
		}

		try {
			/*
			 * ByteArrayOutputStream是一个低级流，通过
			 * 这个流写出的字节会保存到它内部的一个字节数组
			 * 中。
			 */
			ByteArrayOutputStream out 
				= new ByteArrayOutputStream();
			ImageIO.write(image, "jpg", out);
			//获取输出流里已经写出来的字节(图片的所有字节)
			byte[] data = out.toByteArray();
			
			//将图片数据作为正文设置到响应对象中
			response.setContentData(data);
			response.putHeader("Content-Type","image/jpeg");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("图片生成完毕!");

	}

}
