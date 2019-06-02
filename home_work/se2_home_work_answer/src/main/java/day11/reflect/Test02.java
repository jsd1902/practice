package day11.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 用户从控制台输入Foo类的类名，根据类名创建对象，执行此对象中所有以get开头的方法并将返回值打印到控制台
 * @author Admin
 *
 */
public class Test02 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入类名：");
		String clsName = sc.nextLine();
		//根据类名创建对象
		Class cls = Class.forName(clsName);
		//创建该类的对象
		Object obj = cls.newInstance();
		//获取该对象下的所有方法，判断是否以get开头，如果是，执行该方法
		Method[] methods = cls.getDeclaredMethods();
		for (Method method : methods) {
			//判断方法是否以get开头
			String name = method.getName();
			if(name.startsWith("get")){
				Object returnVal = method.invoke(obj);
				System.out.println(returnVal);
			}
		}
		
		sc.close();
		
	}

}
