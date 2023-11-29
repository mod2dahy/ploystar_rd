package com.ploystar.client;

//// Data Receiver Class responsible to open connection to Specific Server and load data into shared WordsCounts
//// Variable 
import java.io.*;
import java.net.*;


import java.util.concurrent.ConcurrentHashMap;

public class DataReceiver implements Runnable {
	private ConcurrentHashMap<String, Integer> wordsCounts;
	private String ServerhostName;
	private int port;

	/// Construct the object using the passed port and shared wordsCount
	public DataReceiver(int port, ConcurrentHashMap<String, Integer> word,String hostName) {
		this.ServerhostName=hostName;
		this.wordsCounts = word;
		this.port = port;

	}
	public int getWordsTotal() {
		return wordsCounts.size();
	}
	/// process incoming line form the server
	synchronized public void processLine(String line) {
		
		String[] result = line.split(" ");
		int resLenght = result.length;
		for (int i = 0; i < resLenght; i++) {
			String tmpStr = result[i];
			if (wordsCounts.containsKey(tmpStr)) {
				int tmpCount = wordsCounts.get(tmpStr);
				tmpCount++;
				wordsCounts.put(tmpStr, tmpCount);
			} else
				wordsCounts.put(tmpStr, 1);
		}
	}

	//// the Main thread function keep receiving data from the server
	@Override
	public void run() {

		try (Socket clientSocket = new Socket(ServerhostName, port);

				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
			String incomingLine;
			while ((incomingLine = in.readLine()) != null) {
				synchronized (incomingLine) {
					processLine(incomingLine);
				}
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