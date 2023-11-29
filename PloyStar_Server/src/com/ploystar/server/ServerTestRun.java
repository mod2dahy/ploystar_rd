package com.ploystar.server;

public class ServerTestRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName1 = "files//textfil1_lasse_solen_i_ogonen.txt";
		String fileName2 = "files//textfil1_lasse_varning_for_ras.txt";
		Server firstServer = new Server(9595,fileName1);
		firstServer.loadAndSendData();
		Server seondServer = new Server(9999,fileName2);
		seondServer.loadAndSendData();
		
	}

}
