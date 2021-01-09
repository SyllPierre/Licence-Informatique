package UdpMulticast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ReceiveTchat implements Runnable{

	@Override
	public void run() {
		try {
			while(true) {
				InetAddress group = InetAddress.getByName("224.0.0.1"); //@IP du destinataire
				MulticastSocket s = new MulticastSocket(7654); //numéro du port
				s.joinGroup(group); //rejoindre le groupe
				byte[] buf = new byte[1024]; //taille
				DatagramPacket recv = new DatagramPacket(buf, buf.length);
				s.receive(recv);

				byte array[] = recv.getData();
				String res = new String(array);
				System.out.println("message de" + recv.getAddress().getHostName() + ": " + res); //pseudo + message
				s.close();
			}
		}
		catch(Exception e) {

		}
	}
}
