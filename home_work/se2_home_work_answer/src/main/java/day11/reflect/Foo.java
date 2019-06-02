package day11.reflect;
/**
 * 在本类中定义getName(),getAge(),getGender()方法，每个方法中返回对应类型的值，
 * 再定义test方法，方法体中输出“测试方法”
 * 定义demo方法，方法体中输出“demo方法”
 * @author Admin
 *
 */
public class Foo {
	
	public String getName(){
		return "tom";
	}
	
	public int getAge(){
		return 23;
	}

	public String getGender(){
		return "男";
	}
	
	public void test(){
		System.out.println("测试方法");
	}
	
	public void demo(){
		System.out.println("demo方法");
	}

}
