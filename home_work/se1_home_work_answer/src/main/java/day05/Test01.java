package day05;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件流复制myfile.txt文件为myfile_cp.txt
 * @author Admin
 *
 */
public class Test01 {
	public static void main(String[] args) throws IOException {
		FileInputStream src = new FileInputStream("myfile.txt");
		FileOutputStream dest = new FileOutputStream("myfile_cp.txt");
		int len = -1;
		byte[] data = new byte[1024*10];
		while((len = src.read(data))!=-1){
			dest.write(data,0,len);
		}
		src.close();
		dest.close();
	}
}





