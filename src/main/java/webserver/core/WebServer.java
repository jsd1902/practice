package webserver.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
private Socket socket;
private ServerSocket server;
public  WebServer(){
	System.out.println("����������");
	try {
		server = new ServerSocket(8088);
	} catch (IOException e) {
		e.printStackTrace();
	}
	System.out.println("�����������ɹ�");
}
public void start(){
	System.out.println("�ȴ��ͻ�������");
	try {
		socket  = server.accept();
		System.out.println("�ͻ������ӳɹ�");
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









