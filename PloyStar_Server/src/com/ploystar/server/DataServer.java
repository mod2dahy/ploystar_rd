package com.ploystar.server;

public class DataServer {
	public static void main(String[] args)  {

		if (args.length != 2) {
			System.err.println("Usage: java DataServer <port number> <File Name>");
			System.exit(1);
		}
		System.err.println("Loading new Server using port"+args[0] +" loading this fileName"+args[1]);
		int portNumber = Integer.parseInt(args[0]);
	//	String fileName = "files//textfil1_lasse_solen_i_ogonen.txt"; for Testing propuse
		
		Server firstServer = new Server(portNumber, args[1]);
		firstServer.loadAndSendData();

	}
}
