package day11.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 在main方法中创建一个Student对象，将此对象作为参数传递给analyze方法解析该对象
 * 要求：
 * 	analyze方法对参数对象进行解析，解析出对象所属的类型，对象中的所有属性，对象中的所有成员方法，并打印到控制台
 * @author Admin
 *
 */
public class Test01 {
	
	public static void main(String[] args) {
		Student student = new Student("stu1001",23, "张三","男");
		Test01 test01 = new Test01();
		test01.analyze(student);
		
	}
	/**
	 * 解析Object对象
	 * @param obj
	 */
	public void analyze(Object obj){
		Class cls = obj.getClass();
		System.out.println("该对象所属类型："+cls);
		
		//获取该类中所有属性
		Field[]  fields = cls.getDeclaredFields();
		System.out.println("对象中的属性有：");
		for (Field field : fields) {
			System.out.println(field);
		}
		
		//获取该类中所有的成员方法
		Method[] methods = cls.getDeclaredMethods();
		System.out.println("对象中的成员方法有：");
		for (Method method : methods) {
			System.out.println(method);
		}
		
	}

}
