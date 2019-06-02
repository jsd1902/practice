package day09.test02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * 重构聊天室案例，使服务器可以将客户端发送的消息转发给所有客户端，并在
 * 每个客户端控制台上显示，并解决多线程安全问题
 * @author Admin
 *
 */
public class Server {
	private ServerSocket server;
	/*
	 * 该数组用于存放所有客户端的输出流
	 */
	private PrintWriter[] allOut = new PrintWriter[0];
	
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
	
	/**
	 * 该线程任务负责与指定Socket所对应的客户端
	 * 进行交互.
	 * @author Admin
	 *
	 */
	private class ClientHandler implements Runnable{
		private Socket socket;
		/**
		 * 实例化时将对应客户端的Socket传入
		 * @param socket
		 */
		public ClientHandler(Socket socket){
			this.socket = socket;
		}
		
		public void run(){
			PrintWriter pw = null;
			try {
				InputStream in = socket.getInputStream();
				BufferedReader br = new BufferedReader(
					new InputStreamReader(
						in,"UTF-8"	
					)	
				);
				/*
				 * 获取输出流,用于给当前客户端回复消息
				 */
				pw = new PrintWriter(
					new BufferedWriter(
						new OutputStreamWriter(
							socket.getOutputStream(),
							"UTF-8"
						)	
					),true	
				);
				//将当前客户端对应的输出流存入共享数组	
				synchronized (allOut) {		
					//1扩容数组
					allOut = Arrays.copyOf(allOut, allOut.length+1);
					//2将输出流存入数组
					allOut[allOut.length-1] = pw;
					System.out.println("当前在线人数："+allOut.length);
				}
				
				
				String message = null;
				while((message = br.readLine())!=null){
					System.out.println("客户端说:"+message);
					//发送给所有客户端
					synchronized (allOut) {
						for(int i=0;i<allOut.length;i++){
							allOut[i].println("客户端说:"+message);
						}
					}
				}
			} catch (Exception e) {
				
			} finally{
				//处理客户端断开连接后的操作
				System.out.println("某客户端下线了！");
				//将该客户端的输出流从共享数组中删除
				synchronized (allOut) {
					for(int i=0;i<allOut.length;i++){
						if(allOut[i]==pw){
							//将最后一个元素放入当前位置
							allOut[i] = allOut[allOut.length-1];
							//缩容
							allOut = Arrays.copyOf(allOut, allOut.length-1);
							break;
						}
					}
					System.out.println("当前在线人数："+allOut.length);
				}
				/*
				 * 客户端断开连接后,服务端关闭
				 * 该客户端Socket,释放资源
				 */
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}











