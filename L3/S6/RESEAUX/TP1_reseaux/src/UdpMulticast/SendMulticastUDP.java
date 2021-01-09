package UdpMulticast;
import java.net.*;
import java.io.*;
import java.lang.String;

public class SendMulticastUDP {
	public static void main(String[] args) throws IOException{
		String msg = "Hello"; //pas utile
		InetAddress group = InetAddress.getByName("224.0.0.1"); //@IP du destinataire
		MulticastSocket s = new MulticastSocket(7654); //numéro du port
		s.joinGroup(group);
		DatagramPacket hi = new DatagramPacket(args[0].getBytes(), args[0].length(),group, 7654);
		s.send(hi);
		s.close();
	}
}
