package exo1;

import java.io.IOException;
import java.net.*;

public class ReceiveUDP {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
			DatagramSocket s = new DatagramSocket(Integer.parseInt(args[0]));
			DatagramPacket p = new DatagramPacket(new byte[512], 512);
			s.receive(p);
			System.out.println("paquet reçu de : "+ p.getAddress()+ "\nport : "+ p.getPort()+ "\ntaille : " + p.getLength());
			System.out.println("message recu : " + new String(p.getData()));
			s.close();
	}
	
}