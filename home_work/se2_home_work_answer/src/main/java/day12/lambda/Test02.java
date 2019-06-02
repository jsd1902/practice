package day12.lambda;

import java.io.File;
import java.net.URISyntaxException;

/**
 * 使用lambda表达式实现查找当前项目下所有以.jpg结尾的文件并打印到控制台
 * @author Admin
 *
 */
public class Test02 {
	public static void main(String[] args) throws URISyntaxException {
		File file = new File(Test02.class.getClassLoader().getResource("day12/lambda").toURI());
		
		File[] files = file.listFiles(
				destFile->destFile.isFile()&&destFile.getName().endsWith(".jpg"));
		for (File file2 : files) {
			System.out.println(file2);
		}
	}

}
