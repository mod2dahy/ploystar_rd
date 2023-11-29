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
	private int totalLines;

	public Server(int port, String fileName) throws MissingFileException {
		this.fileName = fileName;
		this.port = port;

	}

	public void loadAndSendData() {
		totalLines = 0;
		System.err.println("Starting the server");
		try (ServerSocket serverSocket = new ServerSocket(port);
				Socket clientSocket = serverSocket.accept();
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				FileReader fileReader = new FileReader(fileName);
				BufferedReader bufferedReader = new BufferedReader(fileReader);

		) {

			// Initiate conversation with client
			String tempLine = "";
			while ((tempLine = bufferedReader.readLine()) != null) {
				if (!tempLine.isEmpty())
					out.println(tempLine);
				totalLines++;
			}

		} catch (IOException e) {
			System.out.println("Exception caught when trying to listen on port " + " or listening for a connection");
			System.out.println(e.getMessage());
		}
	}

	public class MissingFileException extends RuntimeException {

	}

	public int getTotalLines() {
		return totalLines;
	}
}
