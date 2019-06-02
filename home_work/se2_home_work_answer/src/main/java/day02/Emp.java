package day02;

/**
 * 定义私有属性:
 * String name;
 * int age;
 * String gender;
 * double salary;
 * 
 * 定义构造方法，以及属性get,set方法.
 * 定义toString方法，格式如:
 *    张三,25,男,5000.0
 * 
 * 定义equals方法，要求名字以及年龄相同，则认为内容一致。
 * 
 * 定义Emp之间的排序规则：按照年龄进行排序
 * @author Admin
 *
 */
public class Emp implements Comparable<Emp> {
	private String name;
	private int age;
	private String gender;
	private double salary;
	public Emp(String name, int age, String gender, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public boolean equals(Object obj){
		if(obj==null){
			return false;
		}
		if(obj==this){
			return true;
		}
		if(obj instanceof Emp){
			Emp emp = (Emp)obj;
			return emp.name.equals(this.name)&&emp.age==this.age;
		}
		return false;
	}
	
	public String toString(){
		return name+","+age+","+gender+","+salary;
	}
	public int compareTo(Emp o) {
		return this.age-o.age;
	}
}
