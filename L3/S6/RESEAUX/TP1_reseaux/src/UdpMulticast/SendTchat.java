package UdpMulticast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class SendTchat implements Runnable{
	private String id;

	public SendTchat(String id) {
		this.id = id;
	}
	@Override
	public void run() {
		try {
		String msg = "Hello";
		InetAddress group = InetAddress.getByName("224.0.0.1"); //@IP du destinataire
		MulticastSocket s = new MulticastSocket(7654); //numéro du port
		s.joinGroup(group);
		Scanner sc = new Scanner(System.in);
		DatagramPacket hi;
		while(true) {
			String idd = sc.nextLine();
			String res = this.id + " : " + idd;
			byte array[] = res.getBytes();
			hi = new DatagramPacket(array,array.length,group,7654);
			s.send(hi);
		}
		}
		catch(Exception e){

		}
	}

}
