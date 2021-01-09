package UdpMulticast;
import java.net.*;
import java.io.*;
import java.lang.String;

public class SendUDP{
	public static void main(String[] args) throws IOException{
		DatagramPacket p;
		DatagramSocket s;

		InetAddress dst = InetAddress.getByName(args[0]); // Destinataire @IP
		int port = Integer.parseInt(args[1]); //Destinataire Port

		byte array[] = args[2].getBytes(); //Contenu
		p = new DatagramPacket(array, array.length, dst, port);
		s = new DatagramSocket(); //Emetteur @IP + Port
		s.send(p);
		s.close();
	}
}
