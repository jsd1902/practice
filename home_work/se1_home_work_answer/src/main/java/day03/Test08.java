package day03;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * 创建一个文件"note.txt",然后通过控制台输入的每一行字符串都按行写入到
 * note.txt中。当输入的字符串为"exit"时退出程序。 - 使用RandomAccessFile
 * @author Admin
 *
 */
public class Test08 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入内容,exit为退出");
		RandomAccessFile raf = new RandomAccessFile("note.txt","rw");
		while(true){
			String line = sc.nextLine();
			if("exit".equals(line)){
				break;
			}
			raf.write((line+"\n").getBytes());
		}
		System.out.println("再见!");
		raf.close();
		sc.close();
	}
}
