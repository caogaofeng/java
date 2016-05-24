package socket_program;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {

	public static void main(String[] args) {
		// InetAddress类。
       // 该类的功能是代表一个IP地址，并且将IP地址和域名相关的操作方法包含在该类的内部
		
		try {
			// 使用域名创建对象
			InetAddress inet1 = InetAddress.getByName("www.baibu.com");
			System.out.println(inet1);
            // 使用IP创建对象
			InetAddress inet2 = InetAddress.getByName("127.0.0.1");
			System.out.println(inet2);
			// 获取本机地址
			InetAddress inet3 = InetAddress.getLocalHost();
			System.out.println(inet3);
			// 获得对象中存储的域名
			String host = inet3.getHostName();
			System.out.println("域名为： " + host);
			// 获得对象中存储的IP
			String ip = inet3.getHostAddress();
			System.out.println("ip： " + ip);
		
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
