package day04;

/**
 * 修改user.dat文件中用户的密码
 * user.dat文件300字节，每100个字节为一个用户的信息。
 * 其中:
 * 	 name为字符串，长度为32个字节，编码为:UTF-8
 *   password为字符串，长度为32个字节，编码为UTF-8
 * 	 nickName为字符串，长度为32个字节，编码为:UTF-8  - 该字段为昵称
 * 	 age为int,长度为4个字节
 * 提示:
 * 	该文件中已有的用户信息有：
 * 		张三  123456  张小三   23
 * 		王丽  123456  小丽    24
 *  	李可   123455 小可   26
 * 从控制台输入用户名，判断该用户是否存在user.dat中，
 * 		若存在，输入新密码，修改文件中的密码,并展示修改后user.dat中的用户信息
 * 		若不存在，提示“该用户不存在！”
 * 
 * 
 * @author Admin
 */
public class Test02 {
	public static void main(String[] args) {
	}
}
