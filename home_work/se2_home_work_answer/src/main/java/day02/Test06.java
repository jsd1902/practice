package day02;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 * 要求用户输入若干员工信息，格式为：
 * name,age,gender,salary;name,age,gender,salary;....
 * 例如:
 * 张三,25,男,5000;李四,26,女,6000;...
 * 然后将每个员工信息解析成Emp对象。并存入到一个集合中。
 * 然后循环集合，输出每一个员工信息(输出使用toString返回的字符串)
 * 然后对集合中的员工按照年龄升序排列并输出
 * @author Admin
 *
 */
public class Test06 {
	public static void main(String[] args) throws ParseException {
		List<Emp> list = new ArrayList<Emp>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入员工信息:");
		String info = scanner.nextLine();
		String[] empArr = info.split(";");
		for(String data:empArr){
			String[] empInfo = data.split(",");
			String name = empInfo[0];
			int age = Integer.parseInt(empInfo[1]);
			String gender = empInfo[2];
			double salary = Double.parseDouble(empInfo[3]);
			Emp e = new Emp(name, age, gender, salary);
			list.add(e);
		}
		//输出员工信息
		for(Emp e : list){
			System.out.println(e);
		}
		//对List集合按照年龄排序
		Collections.sort(list);
		
		System.out.println("排序后的员工信息是：");
		//输出排序后的员工信息
		for(Emp e : list){
			System.out.println(e);
		}
		scanner.close();
	}
}





