package com.ploystar.server.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Socket clientSocket = new Socket("localhost", 9595);

				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
			String incomingLine;
			while ((incomingLine = in.readLine()) != null) {
		
			}
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host ");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to ");
			System.exit(1);
		}

	}

}
