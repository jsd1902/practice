package day11.reflect;
/**
 * 定义私有属性
 * String studentId;
 * int age;
 * String name;
 * String gender;
 * 
 * 定义构造方法，以及属性的get,set方法
 * 
 * 定义toString方法，将学生对象的各个属性值拼接成字符串输出
 * 
 * 定义equals方法，要求studentId相同，则认为对象一致。
 * @author Admin
 *
 */
public class Student {
	private String studentId;
	private int age;
	private String name;
	private String gender;
	public Student() {
		super();
	}
	public Student(String studentId, int age, String name, String gender) {
		super();
		this.studentId = studentId;
		this.age = age;
		this.name = name;
		this.gender = gender;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", age=" + age + ", name=" + name + ", gender=" + gender + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		return true;
	}

}
