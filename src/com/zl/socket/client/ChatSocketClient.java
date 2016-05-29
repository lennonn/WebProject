package com.zl.socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatSocketClient {


	//public void chatSocketClient() {
	public static void main(String args[]) {
		Socket socket = null;
		try {
			String line = "";
			socket = new Socket("127.0.0.1", 8180);
			BufferedReader clientBufferedReader = new BufferedReader(
					new InputStreamReader(System.in));
			PrintWriter clientPrintWriter = new PrintWriter(
					socket.getOutputStream());
			BufferedReader serverBufferedReader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			//System.out.println("Come from Server:"+ serverBufferedReader.readLine());
			line = clientBufferedReader.readLine();
				while (!line.equals("serverStop")) {
					clientPrintWriter.println(line);//·¢ËÍ¸øServer
					//clientPrintWriter.write(line);;
					clientPrintWriter.flush();
					System.out.println("Come from Server:"+serverBufferedReader.readLine());
					line = clientBufferedReader.readLine();
				}
			clientBufferedReader.close();
			serverBufferedReader.close();
			clientPrintWriter.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
