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
		System.out.println("开始解析请求");
		HttpRequest request = new HttpRequest(socket);
		System.out.println("开始分析请求");
		System.out.println("回应相应");
	}
}
