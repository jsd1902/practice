package day08;
/**
 * 编写计时线程，该线程每隔5秒钟输出当前时间的毫秒表示，主线程结束后计时完毕
 * 提示：将计时的线程设置为后台线程
 * @author Admin
 *
 */
public class Test04 {
	public static void main(String[] args) {
		//创建线程，实现每隔5秒输出当前时间的毫秒表示
		Thread thread = new Thread(){
			public void run() {
				while(true){
					System.out.println(System.currentTimeMillis());
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		//设置thread为守护线程
		thread.setDaemon(true);
		thread.start();
		
		//当前main线程开始之后休眠10000毫秒
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main线程结束了!");
	}

}
