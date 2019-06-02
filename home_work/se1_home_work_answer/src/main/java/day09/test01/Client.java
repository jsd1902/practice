package day09.test01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 练习课堂案例：
 * 使用线程实现多个客户端向服务器发送消息，
 * 服务器接受多个客户端发送的消息并打印到控制台
 * @author Admin
 *
 */
public class Client {
	
	private Socket socket;
	/**
	 * 构造方法,用来初始化客户端
	 */
	public Client(){
		try {
			socket = new Socket("localhost",8088);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 客户端开始工作的方法
	 */
	public void start(){
		try {
			Scanner sc = new Scanner(System.in);
			
			OutputStream out = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(
					new BufferedWriter(
							new OutputStreamWriter(
									out,"UTF-8")	
							),true	
						);	
			while(true){
				String line = sc.nextLine();
				pw.println(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		client.start();
	}

}
