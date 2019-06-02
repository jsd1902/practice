package day05;
/**
 * 简要描述Serializable接口和transient关键字
 * @author Admin
 *
 */
public class Test05 {
	public static void main(String[] args) {
		/*
		 * 1）ObjectOutputStream在对对象进行序列化时有一个要求，就是需要序列化的对象所属的类必须实现Serializable接口。
		 * 实现该接口不需要重写任何方法。其只是作为可序列化的标志。
		 * 
		 * 2）对象在序列化后得到的字节序列往往比较大，有时我们在对一个对象进行序列化时可以忽略某些不必要的属性，
		 * 从而对序列化后得到的字节序列”瘦身”。关键字 transient表示被该关键字修饰的属性在序列化时其值将被忽略。
		 */
	}
}
