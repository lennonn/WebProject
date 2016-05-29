package com.zl.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChatSocketServer extends HttpServlet{
	/**
	 *
	 */
	private static final long serialVersionUID = 2457172103059943161L;
	ServerSocket serverSocket = null;
	Socket socket =null;
	String line="";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		if(serverSocket==null){
			try {
				serverSocket = new ServerSocket(8180);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this.chatSocket();
	}
	public static void main(String args[]) throws IOException {
		ServerSocket serverSocket = null;
		Socket socket =null;
		String line="";
		try {
			serverSocket = new ServerSocket(8180);
			System.out.println("waiting client to connect");
			socket = serverSocket.accept();
			System.out.println("client have connected");
			BufferedReader clientBufferedReader = new BufferedReader(
					new InputStreamReader(socket.getInputStream())
					);
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			BufferedReader serverBufferedReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Come from Client:"+ clientBufferedReader.readLine());
			line = serverBufferedReader.readLine();
			//boolean flag=true;
			while(!line.equals("byebye")){
				printWriter.println(line);//·¢ËÍ¸øClient
				printWriter.flush();
				System.out.println("Come from Client:"+ clientBufferedReader.readLine());
				line = serverBufferedReader.readLine();
			}
			clientBufferedReader.close();
			serverBufferedReader.close();
			printWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}finally{
			if(serverSocket!=null){
				try {
					serverSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if(socket!=null){
				socket.close();
			}
		}
	}
}
