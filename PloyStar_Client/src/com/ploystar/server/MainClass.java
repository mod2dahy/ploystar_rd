package com.ploystar.server;

public class MainClass {

	public static  void executeMain(String args[])
	{
		if (args.length != 2) {
			System.err.println("Usage: java DataServer <port number> <File Name>");
			System.exit(1);
		}

		int portNumber = Integer.parseInt(args[0]);
	//	String fileName = "files//textfil1_lasse_solen_i_ogonen.txt"; for Testing propuse
		
		Server firstServer = new Server(portNumber, args[1]);
		firstServer.loadAndSendData();
	}
}
