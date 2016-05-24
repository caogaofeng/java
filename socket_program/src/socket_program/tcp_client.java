package socket_program;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
/*
 * 简单的Socket客户端 功能为：发送字符串“Hello”到服务器端，并打印出服务器端的反馈
 */
public class tcp_client {

	public static void main(String[] args) {
		
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		
		// 服务器端的IP地址
		String serviceIP = "127.0.0.1";
		
		// 服务器端的端口
		int port = 10000;
		
		// 发送的数据
		String data = "Hello";
		
		try {
			// 建立连接
			socket = new Socket(serviceIP,port);
			
			// 发送数据
			os = socket.getOutputStream();
			os.write(data.getBytes());
			
			// 接受数据
//			is = socket.getInputStream();
//			byte[] b = new byte[1024];
//			int n = is.read(b);			
//			// 输出反馈信息
//			System.out.println("服务器反馈： " + new String(b, 0, n));// b是byte类型的数组，0是起始位置，n指的是结束位置。也就是说，每次读取一定字节数的数据，然后写入到一个新字符串中。n就是新字符串的长度，也就是结束位置。
//			
//			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally{
			
			try {
				
				// 关闭流和连接
				is.close();
				os.close();
				socket.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
}
