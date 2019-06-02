package day04;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 修改user.dat文件中用户的密码
 * 
 * user.dat文件300字节，每100个字节为一个用户的信息。
 * 其中:
 * 	 name为字符串，长度为32个字节，编码为:UTF-8
 *   password为字符串，长度为32个字节，编码为UTF-8
 * 	 nickName为字符串，长度为32个字节，编码为:UTF-8  - 该字段为昵称
 * 	 age为int,长度为4个字节
 * 提示:
 * 	该文件中已有的用户信息有：
 * 		张三  123456  张小三   23
 * 		王丽  123456  小丽    24
 *  	李可   123455 小可   26
 * 从控制台输入用户名，判断该用户是否存在user.dat中，
 * 		若存在，输入新密码，修改文件中的密码,并展示修改后user.dat中的用户信息
 * 		若不存在，提示“该用户不存在！”
 * 
 * 
 * @author Admin
 */
public class Test02 {
	public static void main(String[] args) throws URISyntaxException, IOException {
		File file = new File(Test02.class.getClassLoader().getResource("day04/user.dat").toURI());
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		System.out.println("请输入要修改密码的用户名：");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		
		Test02 test02 = new Test02();
		boolean flag = test02.checkName(raf, name);
		
		if(!flag){
			System.out.println("该用户不存在！");
			sc.close();
			return;
		}
		
		System.out.println("请输入新密码：");
		String pwd = sc.nextLine();
		
		test02.updatePwd(raf, pwd);
		
		//输出user.dat中修改后的内容
		test02.showUsers(raf);
		
		sc.close();
		raf.close();
	}
	
	//查看user.dat中的所有用户信息
	public void showUsers(RandomAccessFile raf) throws IOException{
		int count = (int) (raf.length()/100);
		for(int i=0;i<count;i++){
			raf.seek(i*100);
			String name = readString(raf).trim();
			String pwd = readString(raf).trim();
			String nickName = readString(raf).trim();
			int age = raf.readInt();
			System.out.println(name+"-"+pwd+"-"+nickName+"-"+age);
		}
		
	}
	
	//修改密码
	public void updatePwd(RandomAccessFile raf,String pwd) throws IOException{
		byte[] newpwd = pwd.getBytes("UTF-8");
		newpwd = Arrays.copyOf(newpwd, 32);
		raf.write(newpwd);
	}
	
	//判断用户名是否存在
	public boolean checkName(RandomAccessFile raf,String name) throws IOException{
		int count = (int) (raf.length()/100);
		boolean flag = false;
		for(int i=0;i<count;i++){
			raf.seek(i*100);
			String str = readString(raf).trim();
			if(name.equals(str)){
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public String readString(RandomAccessFile raf) throws IOException{
		byte[] bys = new byte[32];
		raf.read(bys);
		return new String(bys,"UTF-8");
		
	}

}
