package day05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用缓冲字节流复制myfile.txt文件为myfile_cp2.txt
 * @author Admin
 *
 */
public class Test02 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("myfile.txt");
		BufferedInputStream src = new BufferedInputStream(fis);
		
		FileOutputStream fos = new FileOutputStream("myfile_cp2.txt");
		BufferedOutputStream dest = new BufferedOutputStream(fos);
		int d = -1;
		while((d = src.read())!=-1){
			dest.write(d);
		}
		src.close();
		dest.close();
	}
}
