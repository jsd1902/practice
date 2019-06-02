package day01;

import java.util.Scanner;

/**
 * 用户从控制台输入一个字符串，须至少包含一个“/”，如果没有，给出错误提示；
 * 如果有，获取最后一个“/”后的字符串。
 * @author Admin
 */
public class Test06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入字符串：");
		String input = sc.nextLine();
		
		if(input.indexOf("/")<0){
			System.out.println("输入错误！");
		}else{
			String sub = subStr(input);
			System.out.println(sub);
		}
		sc.close();
	}
	
	public static String subStr(String str){
		return str.substring(str.lastIndexOf("/")+1);
	}

}
