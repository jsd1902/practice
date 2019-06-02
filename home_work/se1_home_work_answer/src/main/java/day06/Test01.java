package day06;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 记事本功能，首先要求用户输入一个文件名，并将该文件创建出来，
 * 然后通过控制台输入的每一行字符串都按行写入到该文件中，并
 * 使用GBK编码保存。当输入的字符串为"exit"时退出程序。
 * @author Admin
 *
 */
public class Test01 {
	public static void main(String[] args) throws IOException{
		 Scanner sc = new Scanner(System.in);
		 System.out.println("请输入文件名:");
		 String fileName = sc.nextLine();
		 PrintWriter pw = new PrintWriter(
			new OutputStreamWriter(
				new FileOutputStream(fileName),"GBK"	
			)	 
		 );
		 System.out.println("请输入内容，输入exit则退出程序");
		 while(true){
			 String line = sc.nextLine();
			 if("exit".equals(line)){
				 break;
			 }
			 pw.println(line);
		 }
		 System.out.println("再见!");
		 pw.close();
		 sc.close();
	}
	
}
