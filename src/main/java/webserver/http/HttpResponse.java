package webserver.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HttpResponse {
	private Socket socket;
	private OutputStream out;
	
	public HttpResponse(Socket socket){
		try {
			this.socket = socket;
			this.out = socket.getOutputStream();
		} catch (Exception e) {
		}
	}
	private void sendLine(){
		
	}
	private void sendHeaders(){
		
	}
	private void sendContend(){
		
	}
	private void println(String line){
		try {
			out.write(line.getBytes("ISO8859-1"));
			out.write(13);
			out.write(10);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
