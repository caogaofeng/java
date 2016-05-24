package socket_program;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Administrator
 *1.一个接收方，一个发送方

　 2.当接收方收到发送方发送的消息后，打印发送的消息及发送方的地址和端口号，之后向发送反馈一条信息“接受方：我收到了！”

　 3.发送方打印出接收方反馈的消息
 */
public class UDP_Sender {

	public static void main(String[] args) {
		
		try {
			// 创建发送方的套接字，IP默认为本地，端口号随机
			DatagramSocket sendSocket = new DatagramSocket();
			
			// 确定要发的信息：
			String mes = "你好！ 接收方！";
			
			// 由于数据包的数据是以字符数组传的形式储存的，所以传转数据
			byte[] buf = mes.getBytes();
			
			// 确定发送方的IP地址以及端口号，地址为本机地址
			int port = 8888;
			InetAddress ip = InetAddress.getLocalHost();
			
			// 创建发送类型的数据报
			DatagramPacket sendPacket = new DatagramPacket(buf, buf.length, ip, port); 
			
			// 通过套接字发送数据：
			sendSocket.send(sendPacket);
			
			// 确定接收反馈数据的缓冲存储器，即存储数据的字节数组
			byte[] getbuf = new byte[1024];
			
			// 创建接受类型的数据报
			DatagramPacket getPacket = new DatagramPacket(getbuf, getbuf.length);
			
			// 通过套接字接受数据
			sendSocket.receive(getPacket);
			
			//  解析反馈的消息，并打印
			String backMes = new String(getbuf, 0, getPacket.getLength());
			System.out.println("接受方返回的消息： " + backMes);
			
			// 关闭套接字
			sendSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
