package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 使用异常捕获机制完成下述读取操作
 * 读取emp.txt文件，并将每个员工信息读取出来，以一个Emp实例保存，然后将
 * 这些Emp实例存入到数组中。
 * 存入后，要求用户输入一个员工的名字,如:张三
 * 若该员工存在则输出该员工所有信息(Emp的toString方法返回的字符串)
 * 输入的员工名若是英文，不要求区分大小写。
 * 若输入的员工名字不存在，则显示"查无此人"
 * 
 * @author Admin
 *
 */
public class Test06 {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(
				new InputStreamReader(
					Test06.class.getClassLoader().getResourceAsStream("day06/emp.txt")
				)	
			);
			Emp[] ary = {};
			String line = null;
			//读取文件每一行并解析为一个Emp对象数组
			while((line = br.readLine())!=null){
				Emp emp = parseEmp(line);
				ary = Arrays.copyOf(ary, ary.length+1);
				ary[ary.length-1] = emp;
			}
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入员工姓名:");
			String name = scanner.nextLine().toLowerCase();
			boolean flag = false;
			for (Emp emp : ary) {
				if(emp.getName().toLowerCase().equals(name)){
					System.out.println(emp);
					flag = true;
					break;
				}
			}
			if(!flag){
				System.out.println("查无此人");
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 将一行字符串解析为一个Emp对象
	 * @param info
	 * @return
	 * @throws ParseException 
	 */
	public static Emp parseEmp(String info) throws ParseException{
		String[] infos = info.split(",");
		String name = infos[0];
		int age = Integer.parseInt(infos[1]);
		String gender = infos[2];
		double salary = Double.parseDouble(infos[3]);
		Emp emp = new Emp(name, age, gender, salary);
		return emp;
	}
}
