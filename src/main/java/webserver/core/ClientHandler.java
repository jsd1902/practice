package webserver.core;

import java.net.Socket;

import webserver.http.HttpRequest;

public class ClientHandler implements Runnable{
	private Socket socket;
	public  ClientHandler(Socket socket){
		this.socket = socket;
	}
	@Override
	public void run() {
		System.out.println("��ʼ��������");
		HttpRequest request = new HttpRequest(socket);
		System.out.println("��ʼ��������");
		System.out.println("��Ӧ��Ӧ");
	}
}
