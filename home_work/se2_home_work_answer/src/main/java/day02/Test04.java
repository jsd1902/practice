package day02;

import java.util.Arrays;
import java.util.List;

/**
 * 创建一个字符串数组:{"one","two","three"}
 * 然后将该数组转换为一个List集合
 * @author Admin
 *
 */
public class Test04 {
	public static void main(String[] args) {
		String[] arr = {"one","two","three"};
		List<String> list = Arrays.asList(arr);
		System.out.println(list);
 	}
}
