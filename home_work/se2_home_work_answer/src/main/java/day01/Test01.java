package day01;

import java.util.ArrayList;
import java.util.Collection;
/**
 * 创建一个集合，存放字符串"one","two"，"three"
 * 实现一下要求：
 * 		输出该集合的元素个数。
 * 		输出该集合是否包含字符串"four"
 * 		输出集合是否不含有任何元素
 * 		清空集合
 * 		输出该集合的元素个数
 * 		输出集合是否不含有任何元素
 * @author Admin
 *
 */
public class Test01 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("two");
		c.add("three");
		System.out.println("元素数量:"+c.size());
		System.out.println("是否包含four:"+c.contains("four"));
		System.out.println("是否是空集:"+c.isEmpty());
		c.clear();
		System.out.println("集合已清空");
		System.out.println("元素数量:"+c.size());
		System.out.println("是否是空集:"+c.isEmpty());
	}
}
