package socket_program;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class tcp_service {

	public static void main(String[] args) {
		/* echo服务器 功能：将客户端发送的内容反馈给客户端 */
		
		ServerSocket serversocket = null;
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		
		// 监听端口号
		int port = 10000;
		
		try {
			// 建立连接
			serversocket = new ServerSocket(port);
			// 获得连接
			socket = serversocket.accept();
			// 接收客户端发送的内容
			is = socket.getInputStream();
			byte[] b = new byte[1024];
			int n = is.read(b);
			// 输出
			System.out.println("客户端发送的信息为: " + new String(b,0,n));
			// 向客户端发送反馈内容
			
			os = socket.getOutputStream();
			os.write(b,0,n);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			// 关闭连接
			
			try {
				os.close();
				is.close();
				socket.close();
				serversocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
