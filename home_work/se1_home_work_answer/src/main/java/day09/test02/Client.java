package day09.test02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 重构聊天室案例，使服务器可以将客户端发送的消息转发给所有客户端，并在
 * 每个客户端控制台上显示，并解决多线程安全问题
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
			//先启动线程接收服务端发送的消息
			ServerHandler handler = new ServerHandler();
			Thread t = new Thread(handler);
			t.start();
			
			
			Scanner scanner = new Scanner(System.in);
			OutputStream out = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(
				new BufferedWriter(
					new OutputStreamWriter(
						out,"UTF-8"	
					)	
				),true	
			);				
			while(true){
				String line = scanner.nextLine();
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
	
	/**
	 * 该线程负责循环接收服务端发送过来的消息.
	 * 给服务端发送消息与接收服务端发过来的消息
	 * 要放在两个不同的线程运行,这样才能做到
	 * 互相不干扰.
	 * @author adminitartor
	 *
	 */
	private class ServerHandler implements Runnable{
		public void run(){
			try {
				BufferedReader br = new BufferedReader(
					new InputStreamReader(
						socket.getInputStream(),
						"UTF-8"
					)	
				);
				String message = null;
				while((message = br.readLine())!=null){
					System.out.println(message);
				}
			} catch (Exception e) {
				
			}
		}
	}
	
}








