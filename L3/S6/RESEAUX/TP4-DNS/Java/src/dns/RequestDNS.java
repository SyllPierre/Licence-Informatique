package dns;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class RequestDNS {

    /**
     * send a DNS request
     */
    public static void sendRequestReceiveResponse(){
        System.out.println("-------------------------------------");
        System.out.println("Envoi d'une requête au seveur DNS...");
        String address = "127.0.0.53";
        int port = 53;
        byte[] message = {(byte) 0x08, (byte) 0xbb,  (byte) 0x01, (byte) 0x00,
                          (byte) 0x00, (byte) 0x01,  (byte) 0x00, (byte) 0x00,
                          (byte) 0x00, (byte) 0x00,  (byte) 0x00, (byte) 0x00,
                          (byte) 0x03, (byte) 0x77,  (byte) 0x77, (byte) 0x77,
                          (byte) 0x04, (byte) 0x6c,  (byte) 0x69, (byte) 0x66,
                          (byte) 0x6c, (byte) 0x02,  (byte) 0x66, (byte) 0x72,
                          (byte) 0x00,
                          (byte) 0x00, (byte) 0x01,
                          (byte) 0x00, (byte) 0x01 };
        
        System.out.println("Adress : " + address);
        System.out.println("Port : " + port);
        System.out.print("Message : ");
        for (byte b : message) {
            System.out.format("%02X ", b);
        }

        System.out.println();

        InetAddress inetAddr;
        DatagramPacket packet;
        DatagramSocket socket;

        // envoi
        try {
            inetAddr = InetAddress.getByName(address);
            socket = new DatagramSocket();
            packet = new DatagramPacket(message, message.length, inetAddr, port);
            socket.send(packet);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        System.out.println("Requête envoyée.");

        System.out.println("-------------------------------------");

        // réponse
        System.out.println("Réception de la réponse...");
        packet = new DatagramPacket(new byte[512], 512);
        try {
            socket.receive(packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Réponse reçue.");
        System.out.println("Longueur de la réponse : " + packet.getLength());
        
        System.out.print("\nContenu : ");
        byte[] recu = packet.getData();
        for(int i = 0; i < packet.getLength(); i++) {
            System.out.format("%02X ", recu[i]);
        }

        System.out.print("\n\nContenu (decimal) : ");
        for(int i = 0; i < packet.getLength(); i++) {
            System.out.print((recu[i] & 0xff) + ".");
        }

        System.out.println();
        System.out.println("-------------------------------------");
    }

    public static void main(String[] args) {
        sendRequestReceiveResponse();
    }

}