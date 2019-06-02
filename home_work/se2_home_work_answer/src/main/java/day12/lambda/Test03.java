package day12.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 创建一个集合，其中保存多个EMP对象，使用lambda表达式对此集合按照员工的年龄进行升序排列
 * @author Admin
 *
 */
public class Test03 {
	public static void main(String[] args) {
		List<Emp> list = new ArrayList<>();
		Emp tom = new Emp(2, "tom", 23, "男", 4000);
		Emp jack = new Emp(1, "jack", 22, "男", 5000);
		Emp amy = new Emp(5, "amy", 26, "女", 8000);
		Emp linda = new Emp(6, "linda", 21, "女", 9000);
		
		list.add(linda);
		list.add(amy);
		list.add(jack);
		list.add(tom);
		
		//对集合进行按照年龄排序
		Collections.sort(list, 
				(e1,e2)->e1.getAge()-e2.getAge());
		//输出集合中排序后的元素
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}

}
