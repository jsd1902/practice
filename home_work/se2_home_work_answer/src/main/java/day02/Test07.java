package day02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 要求用户输入若干员工信息，格式为：
 * name,age,gender,salary;name,age,gender,salary;....
 * 例如:
 * 张三,25,男,5000;李四,26,女,6000;...
 * 然后将每个员工信息解析成Emp对象。并存入到一个集合中。
 * 然后循环集合，输出每一个员工信息(输出使用toString返回的字符串)
 * 已知员工见进行排序的默认比较规则为按照年龄排序，
 * 现要求对此集合中的员工按照工资进行升序排列并打印输出排序后的集合中的员工信息
 * @author Admin
 *
 */
public class Test07 {
	public static void main(String[] args) {
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
		//对List集合按照工资进行排序
		Collections.sort(list, new BySalary());
		
		System.out.println("排序后的员工信息是：");
		for (Emp emp : list) {
			System.out.println(emp);
		}
		scanner.close();
	}

}

class BySalary implements Comparator<Emp>{

	public int compare(Emp o1, Emp o2) {
		Double d1 = o1.getSalary();
		Double d2 = o2.getSalary();
		return d1.compareTo(d2);
	}
	
}
