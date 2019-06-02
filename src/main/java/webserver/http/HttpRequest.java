package webserver.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
	private Socket socket;
	private InputStream in;
	private String method;
	private String url;
	private String protocal;
	private Map<String,String>headers = new HashMap<>();
	public HttpRequest(Socket socket){
		this.socket=socket;
		try {
			this.in = socket.getInputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//解析请求行
		pareRequestLine();
		//解析消息头
		 pareheaders();
		 
		//解析消息正文
		 pareConmnet();
	}
	private void pareRequestLine() {
		System.out.println("开始解析请求行");
		try {
			String line  = readLine();
			String[] lines  = line.split(" ");
			for(int i = 0;i<lines.length;i++){
				method = lines[0];
				url = lines[1];
				protocal = lines[2];
			}
			System.out.println(line);
			System.out.println("method:"+method);
			System.out.println("url:"+url);
			System.out.println("protocal:"+protocal);
			System.out.println(line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("请求行解析完毕");
		
	}
	private void pareheaders(){
		System.out.println("开始解析消息头");
		String line = null;
		try {
			while(!(line=readLine()).equals("")){
				String[]lines = line.split(": ");
				headers.put(lines[0], lines[1]);
			}
			System.out.println("消息头解析完毕");
			System.out.println(headers);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void pareConmnet(){
		System.out.println("开始解析消息正文");
		System.out.println("消息正文解析完毕");
	}
	//设置方法每次读取消息一行
	private String readLine() throws IOException{
		StringBuilder builder = new StringBuilder();
		int c1 = -1;int c2=-1;
		while((c2=in.read())!=-1){
			if(c1==13&c2==10){
				break;
			}
			c1 = c2;
			builder.append((char)c2);
		}
		return builder.toString().trim();
		
	}

}
