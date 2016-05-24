package socket_program;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;

public class UDP_Receive {

	public static void main(String[] args) {
		
		try {
			// 确定接受方的IP和端口，IP地址是本机地址
			InetAddress ip = InetAddress.getLocalHost();
			int port = 8888;
			
			// 创建接收方的套接字，并制定端口号和IP地址
			// (套接字指的是源IP地址和目的IP地址以及源端口号和目的端口号的结合)
			DatagramSocket getSocket = new DatagramSocket(port, ip);
			
			// 确定数据报接受的数据的数字大小
			byte[] buf = new byte[1024];
			
			// 创建接受类型的数据报，数据将存储在buf中
			DatagramPacket getPacket = new DatagramPacket(buf, buf.length);
			
			// 通过套接字接受数据
			getSocket.receive(getPacket);

			// 解析发送方传递的消息，并打印
			String getMes = new String(buf, 0, getPacket.getLength());
			System.out.println("对方发送的消息是： " + getMes);
			
			// 通过数据报的到发送方的IP和端口号，并打印
			InetAddress sendIP = getPacket.getAddress();
			int sendPort = getPacket.getPort();
			System.out.println("对方的IP地址是： " + sendIP.getHostAddress());
			System.out.println("对方的端口号是： " + sendPort);
			
			// 通过数据报的到发送方的套接字地址
			SocketAddress sendAddress = getPacket.getSocketAddress();
			
			// 确定要反馈发送方的消息内容，并转换为字节数组
			String feedback = "接受方说：我收到了！ ";
			byte[] backbuf = feedback.getBytes();
			
			// 创建发送类型的数据报
			DatagramPacket sendPacket = new DatagramPacket(backbuf, backbuf.length, sendAddress);
			
			// 通过套接字发送数据
			getSocket.send(sendPacket);
			
			// 关闭套接字
			getSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
