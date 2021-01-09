package UdpMulticast;
import java.net.*;
import java.io.*;
import java.lang.String;

public class ReceiveMulticastUDP {
	public static void main(String[] args) throws IOException{

		while(true) {
			InetAddress group = InetAddress.getByName("224.0.0.1"); //@IP du destinataire
			MulticastSocket s = new MulticastSocket(7654); //numéro du port
			s.joinGroup(group);
			byte[] buf = new byte[1024];
			DatagramPacket recv = new DatagramPacket(buf, buf.length);
			s.receive(recv);
			byte array[] = recv.getData();
			String res = new String(array);
			System.out.println(res);
			s.close();
		}
	}
}
