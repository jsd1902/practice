package day12.lambda;
/**
 * 用lambda表达式写一个线程任务，打印输出1-100的所有数字，并启动线程
 * @author Admin
 *
 */
public class Test01 {
	public static void main(String[] args) {
		Runnable task = ()->{
			for(int i=1;i<101;i++){
				System.out.println(i);
			}
		};
		new Thread(task).start();
	}

}
