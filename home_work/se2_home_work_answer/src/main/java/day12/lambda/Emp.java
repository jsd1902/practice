package day12.lambda;
/**
 * 定义私有属性:
 * int id;
 * String name;
 * int age;
 * String gender;
 * int salary;
 * 
 * 定义构造方法，以及属性get,set方法.
 * 
 * 定义toString方法，格式如:
 *    id:1,姓名:张三,年龄:25,性别:男,薪资:5000
 * 
 * 定义equals方法，要求id相同，则认为内容一致。
 * 
 * 定义Emp之间的排序规则：按照id升序排列
 * @author Admin
 *
 */
public class Emp implements Comparable<Emp> {
	private int id;
	private String name;
	private int age;
	private String gender;
	private int salary;
	public Emp() {
		super();
	}
	public Emp(int id, String name, int age, String gender, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", salary=" + salary + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public int compareTo(Emp o) {
		return this.id-o.getId();
	}
}
