package day05;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 读取当前项目根目录下所有后缀为.obj的文件，将这些Emp对象读取出来
 * 并存入到一个数组中，然后遍历输出员工信息
 * @author Admin
 *
 */
public class Test04 {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Test04 t = new Test04();
		File dir = new File(".");
		Emp[] ary = t.loadEmps(dir);
		
		//输出员工信息
		for(Emp e : ary){
			System.out.println(e);
		}
	}
	/**
	 * 从指定目录中读取所有.obj结尾的文件，并反序列化所有员工信息
	 * 然后以一个数组返回
	 * @param dir
	 * @return
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public Emp[] loadEmps(File dir) throws ClassNotFoundException, IOException{
		//获取所有.obj文件
		File[] emps = dir.listFiles(new FileFilter(){
			public boolean accept(File file) {
				return file.isFile()&&file.getName().endsWith(".obj");
			}
		});
		//将每个obj文件反序列化为Emp对象后存入数组
		Emp[] ary = new Emp[emps.length];
		for(int i=0;i<emps.length;i++){
			Emp emp = loadEmp(emps[i]);
			ary[i] = emp;
		}
		return ary;
	}
	/**
	 * 从指定文件中反序列化Emp并返回
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Emp loadEmp(File file) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Emp e = (Emp)ois.readObject();
		ois.close();
		return e;
	}
}
