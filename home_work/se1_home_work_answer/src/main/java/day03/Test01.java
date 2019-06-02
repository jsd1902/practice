package day03;

import java.io.File;

/**
 * 通过File输出当前项目目录下的文件"myfile.txt"的名字，大小(若没有，自己先创建)。
 * @author Admin
 *
 */
public class Test01 {
	public static void main(String[] args) {
		File file = new File("myfile.txt");
		String name = file.getName();
		System.out.println("名字:"+name);
		
		long length = file.length();
		System.out.println("大小:"+length+"字节");
		
	}
}
