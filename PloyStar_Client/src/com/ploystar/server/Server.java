package com.ploystar.server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private String fileName;
	private int port;

	public Server(int port, String fileName) {
		this.fileName = fileName;
		this.port = port;
	}

	public void loadAndSendData() {
		try (ServerSocket serverSocket = new ServerSocket(port);
				Socket clientSocket = serverSocket.accept();
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				FileReader fileReader = new FileReader(fileName);
				BufferedReader bufferedReader = new BufferedReader(fileReader);

		) {
			System.err.println("Connected and start Sending Data");
			// Initiate conversation with client
			String tempLine = "";
			while ((tempLine = bufferedReader.readLine()) != null)
				{if(!tempLine.isEmpty())
					out.println(tempLine);
				}

		} catch (IOException e) {
			System.out.println("Exception caught when trying to listen on port " + " or listening for a connection");
			System.out.println(e.getMessage());
		}
	}
}
