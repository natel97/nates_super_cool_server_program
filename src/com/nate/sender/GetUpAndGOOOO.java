package com.nate.sender;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.net.Socket;
import java.util.Scanner;

public class GetUpAndGOOOO {

	public static void main(String[] args) {
		
		//client side program

		Socket thisIsWhatISend = null;
		Scanner sc = new Scanner(System.in);
		FileReader in = null;
		try {
			in = new FileReader("C:\\Users\\ftd-16\\Desktop\\MyFile.txt");
			int c;
			String myFile = "";
			while ((c = in.read()) != -1)
				myFile += (char) c;

			thisIsWhatISend = new Socket("localhost", 3000);
			DataOutputStream str = new DataOutputStream(thisIsWhatISend.getOutputStream());
			str.writeUTF(myFile);
			str.writeUTF(myFile);
			
			while(true) {
				//if(sc.hasNext()) {
				//	str.writeUTF(sc.nextLine());
				//}
				System.out.println(new DataInputStream(thisIsWhatISend.getInputStream()).readUTF());
				str.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
