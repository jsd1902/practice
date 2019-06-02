package day02;
/**
 * 简述自动装箱和拆箱的原理
 * @author Admin
 */
public class Test07 {
	public static void main(String[] args) {
		/*
		 * 原理描述：
		 * 从JDK1.5开始，编译器提供了自动装箱和自动拆箱机制，编译器在生成类的字节码时，插入必要的方法来完成。
		 * 自动装箱的原理为： Integer a = 100;
		 * 编译器在编译过程中的代码实现为：
		 * 	Integer a = Integer.valueOf(100);
		 * 自动装箱时，调用了Integer的valueOf方法将int类型的值100转换成了Integer类型。
		 * 
		 * 自动拆箱的原理为：int c = a;
		 * 编译器在编译过程中的代码实现为：
		 * 	int c = a.intValue();
		 * 自动拆箱时，调用了Integer的intValue方法，将Integer类型的变量转换成了int类型
		 * 
		 */
	}

}
