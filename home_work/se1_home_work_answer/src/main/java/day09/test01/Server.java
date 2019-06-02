package day09.test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 练习课堂案例：
 * 使用线程实现多个客户端向服务器发送消息，
 * 服务器接受多个客户端发送的消息并打印到控制台
 * @author Admin
 *
 */
public class Server {
	private ServerSocket server;
	
	public Server(){
		try {
			server = new ServerSocket(8088);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start(){
		try {
			while(true){
				System.out.println("等待客户端连接...");
				Socket socket = server.accept();
				System.out.println("一个客户端连接了!");
				//启动一个线程,处理该客户端交互工作
				ClientHandler handler = new ClientHandler(socket);
				Thread t = new Thread(handler);
				t.start();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
	
	
	private class ClientHandler implements Runnable{
		//当前线程通过这个Socket与对应客户端交互
		private Socket socket;
		/**
		 * 实例化时将对应客户端的Socket传入
		 * @param socket
		 */
		public ClientHandler(Socket socket){
			this.socket = socket;
		}
		
		public void run(){
			try {
				InputStream in = socket.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(in,"UTF-8"));
				String message = null;
				while((message = br.readLine())!=null){
					System.out.println("客户端说:"+message);
				}
			} catch (Exception e) {
				
			}
		}
	}

}
