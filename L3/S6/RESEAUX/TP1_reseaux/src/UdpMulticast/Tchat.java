package UdpMulticast;

import java.util.Scanner;

public class Tchat {
	public static void main(String[] args) {
		System.out.println("Choix du pseudo :");
		Scanner sc = new Scanner(System.in); // mémorise le pseudo choisi
		String id = sc.nextLine(); //lire toutes les lignes de la discussion
		System.out.println("Vous avez rejoint le tchat");
		Thread t1 = new Thread(new ReceiveTchat()); //thread pour permettre la réception et l'émission
		Thread t2 = new Thread(new SendTchat(id));

		t1.start(); //lancement en simultané
		t2.start();
	}
}
