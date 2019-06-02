package webserver.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
private Socket socket;
private ServerSocket server;
public  WebServer(){
	System.out.println("启动服务器");
	try {
		server = new ServerSocket(8088);
	} catch (IOException e) {
		e.printStackTrace();
	}
	System.out.println("启动服务器成功");
}
public void start(){
	System.out.println("等待客户端连接");
	try {
		socket  = server.accept();
		System.out.println("客户段连接成功");
		ClientHandler handler = new ClientHandler(socket);
		Thread t = new Thread(handler);
		t.start();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
}
	public static void main(String[] args) {
		WebServer server = new WebServer();
		server.start();
	}

}









