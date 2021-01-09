/*
 * Original de Laurent NOE ~ 2009
 * Mise à jour des noms/adresses des serveurs DNS de la fac, affichage et commentaires - Laurent NOE - Janvier 2019
 * Ajout de quelques commentaires pour autres serveurs fac et exterieurs               - Laurent NOE - Janvier 2020
 */

import java.io.*;
import java.net.*;
import java.util.*;

/*
 * envoi question DNS / reception reponse et affichage hexa rapide ...
 */

public class DNSsimple
{
    public static void main(String[] args)
    {
        /* NOM/ADRESSE-IP + PORT  du Serveur DNS qui recevra notre requete */
        String HOSTDESTNAME = "reserv1.univ-lille1.fr";
        /* utiliser "1.1.1.1" / "9.9.9.9", ou celui déclaré dans le fichier /etc/resolv.conf de chez vous, si les suivants ne sont pas joignables.
         * utiliser "reserv1.univ-lille1.fr" (sinon "reserv2.univ-lille1.fr") à l'université pour avoir les autorites/additionels sur "www.lifl.fr".
         * utiliser "dns1.unv-lille.fr" (sinon "dns2.univ-lille.fr") sur l'université (mais sans autorite/additionel)
         */
        int PORT = 53;



        
        byte[] message = {(byte) 0x08, (byte) 0xbb,  (byte) 0x01, (byte) 0x00, /* a) 12 octets d'entete : identifiant de requete/parametres [RFC1035, 4.1.1] */
                          (byte) 0x00, (byte) 0x01,  (byte) 0x00, (byte) 0x00,
                          (byte) 0x00, (byte) 0x00,  (byte) 0x00, (byte) 0x00,
                          (byte) 0x03, (byte) 0x77,  (byte) 0x77, (byte) 0x77, /* b) QUESTION                     [RFC1035, partie 4.1.2] */
                          (byte) 0x04, (byte) 0x6c,  (byte) 0x69, (byte) 0x66, /* b.1) QNAME : "3www4lifl2fr0"    [RFC1035, partie 3.1] */
                          (byte) 0x6c, (byte) 0x02,  (byte) 0x66, (byte) 0x72,
                          (byte) 0x00,
                          (byte) 0x00, (byte) 0x01,                            /* b.2) QTYPE : A (a host address) [RFC1035, partie 3.2.3] */
                          (byte) 0x00, (byte) 0x01 };                          /* b.3) QCLASS : IN (the Internet) [RFC1035, partie 3.2.4] */


        /* 1) obtenir l'adresse IP du serveur DNS ... en utilisant une requete DNS ??! */
        System.err.print(" recherche de l'IP, pour le nom de l'hote de destination \""+HOSTDESTNAME+"\" ... ");
        InetAddress destination;
        try {
            destination = InetAddress.getByName(HOSTDESTNAME);
        } catch (Exception e) {
            System.err.println("[error] :" +  e.getMessage());
            return;
        }
        System.err.println("[ok]");

        /* 2) creation d'un DatagramPacket pour l'envoi de la question DNS */
        System.err.println(" creation du Datagrampacket, taille du message : "+message.length  );
        DatagramPacket dp = new DatagramPacket(message,message.length,destination,PORT);

        /* 3) creation d'un DatragramSocket (port au choix ) */
        System.err.print(" creation du Datagramsocket  ... ");
        DatagramSocket ds ;
        try {
            ds = new DatagramSocket() ;
        } catch (Exception e) {
            System.err.println("[error] :" +  e.getMessage());
            return;
        }
        System.err.println("[ok]");

        /* 4) et envoi du packet */
        System.err.print(" envoi du message ... ");
        try {
            ds.send(dp);
        } catch (Exception e) {
            System.err.println("[error] :" +  e.getMessage());
            return;
        }
        System.err.println("[ok]");

        /* 5) reception du packet */
        dp = new DatagramPacket(new byte[512],512);
        System.err.print(" reception du message ... ");
        try {
            ds.receive(dp);
        } catch (Exception e) {
            System.err.println("[error] :" +  e.getMessage());
            return;
        }
        System.err.println("[ok]");

        /* affichage complet du packet recu (pas tres lisible ...) */
        byte[] rec = dp.getData();
        System.out.println(" longueur du message recu : " + dp.getLength());

        /* affichage des bytes (et ascii associes) */
        for(int i = 0; i < dp.getLength(); i++) {
            /* NOTE :
             *   utiliser au besoin l'expression "rec[i] & 0xff" pour obtenir une valeur
             *   entre 0 et 255 (et pas entre -128 et +127).
             */

            System.out.print(" "+String.format("%02X",rec[i]));
    
            if (((i+1)%16 == 0) || (i+1 == dp.getLength())) {

                /* ceci pour afficher les caracteres ascii aprec l'hexa */
                /* >>> */
                System.out.print("\t");

                for (int j = 0 ; j < ((i+1) & 15); j++) {
                    System.out.print("     ");
                }
                for (int j = i & ~15; j <= i; j++) {
                    if (rec[j] > 31) {
                        System.out.print((char)rec[j]);
                    } else {
                        System.out.print(".");
                    }
                }
                /* <<< */

                System.out.println("");
            }
        }
    }
}



