package day04;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.util.Scanner;

import day03.Emp;

/**
 * 要求用户输入一个员工信息，格式为：
 * name,age,gender,salary
 * 例如:
 * 张三,25,男,5000
 * 然后将输入的员工信息解析成Emp对象。
 * 然后将该Emp对象的toString返回的字符串写入到文件中，该文件的
 * 名字为:name.emp,以上面的例子，那么该文件名为:张三.emp
 * 至少运行5次该程序，输入五个员工信息，并生成5个文件。
 * @author Admin
 *
 */
public class Test03 {
	public static void main(String[] args) throws ParseException,IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入员工信息:");
		String line = sc.nextLine();
		String[] infos = line.split(",");
		String name = infos[0];
		int age = Integer.parseInt(infos[1]);
		String gender = infos[2];
		double salary = Double.parseDouble(infos[3]);
		Emp emp = new Emp(name,age,gender,salary);
		
		RandomAccessFile raf = new RandomAccessFile(emp.getName()+".emp","rw");
		raf.write(emp.toString().getBytes());
		System.out.println("写出完毕!");
		raf.close();
		sc.close();
		
	}
}
