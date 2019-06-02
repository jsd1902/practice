package day10.xml;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 解析emplist.xml文档，将所有的员工以Emp对象
 * 存入到一个Map中，key为该员工id。
 * 然后要求用户输入一个id，若该员工存在，打印出该员工的完整信息。
 * 若该员工不存在，则输出查无此人
 * @author Admin
 *
 */
public class Test04 {
	public static void main(String[] args) {
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new FileInputStream("emplist.xml"));
			Element root = doc.getRootElement();
			List<Element> list = root.elements();
			Map<Integer,Emp> emps = new HashMap<Integer,Emp>();
			for(Element empEle : list){
				int id = Integer.parseInt(empEle.attribute("id").getValue());
				String name = empEle.elementText("name");
				int age = Integer.parseInt(empEle.elementText("age"));
				String gender = empEle.elementText("gender");
				int salary = Integer.parseInt(empEle.elementText("salary"));
				String hiredate = empEle.elementText("hiredate");
				Emp e = new Emp(id, name, age, gender, salary, hiredate);
				emps.put(id,e);
			}

			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入员工id:");
			int id = Integer.parseInt(scanner.nextLine());
			if(emps.containsKey(id)){
				Emp emp = emps.get(id);
				System.out.println(emp);
			}else{
				System.out.println("查无此人！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
