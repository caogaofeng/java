package socket_program;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MulSocketClient {

	/**
	 * 复用连接的Socket
	 * 客户端功能为：发送字符串“Hello”到服务器端，并打印出服务器端的反
	 */
	public static void main(String[] args) {
		

		Socket socket = null;
		InputStream is = null;
		OutputStream os =null;
		
		// 服务器地址
		String serverIP = "127.0.0.1";
		//  服务器端口
		int port = 10000;
		// 发送内容
		String data[] = {"First", "Second", "Third"};
		
		try {
			// 建立连接
			socket = new Socket(serverIP,port);
			// 初始化流
			os = socket.getOutputStream();
			is = socket.getInputStream();
			byte[] b = new byte[1024];
			for(int i = 0; i < data.length; i++){
				// 发送内容
				os.write(data[i].getBytes());
				// 接收数据
				int n = is.read(b);
				// 输出反馈数据
				System.out.println("服务器反馈： " + new String(b,0,n));
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			// 关闭连接
			try {
				is.close();
				os.close();
				socket.close();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		
		
	}

}
