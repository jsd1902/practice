package day01;

/**
 * 生成一个 包含所有汉字的字符串,且每生成50个汉字进行换行输出。
 * 提示：java字符类型采用Unicode字符集编码，所有汉字的Unicode范围是：\u4e00-\u9fa5
 * @author Admin
 */
public class Test07 {
	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();
		for(char c='\u4e00',i=1;c<='\u9fa5';c++,i++){
			builder.append(c);
			if(i%50==0){
				builder.append("\n");
			}
		}
		System.out.println(builder.length());
		System.out.println(builder.toString());
	}
}
