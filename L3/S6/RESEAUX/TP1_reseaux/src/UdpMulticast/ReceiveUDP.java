package UdpMulticast;
import java.net.*;
import java.io.*;
import java.lang.String;

public class ReceiveUDP{
	public static void main(String[] args) throws IOException{

		int port = Integer.parseInt(args[0]); //prend en argument le premier argument

		DatagramSocket s; //sending or receiving point for a packet delivery service
		DatagramPacket p; //used to implement a connectionless packet delivery service

		s = new DatagramSocket(port); //Recepteur Port
		p = new DatagramPacket(new byte[512],512); //Contenu
		s.receive(p);

		System.out.println("paquet reçu de :"+p.getAddress()+"port"+p.getPort()+"taille"+p.getLength()); //Affichage et Emetteur @IP + Port
		byte array[] = p.getData();
		String string = new String(array);
		System.out.println(string);
    
		s.close();
	}
}
