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
		//����������
		pareRequestLine();
		//������Ϣͷ
		 pareheaders();
		 
		//������Ϣ����
		 pareConmnet();
	}
	private void pareRequestLine() {
		System.out.println("��ʼ����������");
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
		System.out.println("�����н������");
		
	}
	private void pareheaders(){
		System.out.println("��ʼ������Ϣͷ");
		String line = null;
		try {
			while(!(line=readLine()).equals("")){
				String[]lines = line.split(": ");
				headers.put(lines[0], lines[1]);
			}
			System.out.println("��Ϣͷ�������");
			System.out.println(headers);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void pareConmnet(){
		System.out.println("��ʼ������Ϣ����");
		System.out.println("��Ϣ���Ľ������");
	}
	//���÷���ÿ�ζ�ȡ��Ϣһ��
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
