package com.nate.reciever;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class GettrDone {

	public static void main(String[] args) {
		//server side program
		
		ServerSocket sock = null;
		Scanner sc = new Scanner(System.in);
		Socket topSecretInformation = null;

		try {
			sock = new ServerSocket(3000);
			System.out.println("Waiting for connection...");
			topSecretInformation = sock.accept();
			topSecretInformation.setKeepAlive(true);
			System.out.println("Connection acquired!");
			DataOutputStream str = new DataOutputStream(topSecretInformation.getOutputStream());
			while (true) {
				if(sc.hasNext()) {
					str.writeUTF(sc.nextLine());
				}
				System.out.println(new DataInputStream(topSecretInformation.getInputStream()).readUTF());
				str.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
