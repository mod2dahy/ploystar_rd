package com.ploystar.client;

import java.util.Comparator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//// This Class Responsible to load the socket clients and collect data from Server then calculate the requried information
public class DataReceiverExecuter {
	static ConcurrentHashMap<String, Integer> totalWordsCounts = new ConcurrentHashMap<String, Integer>();// the
																							// main
	// shared //
	// variable

	public static void main(String[] args) {
		if (args.length != 4) {
			System.err.println(
					"Usage: java DataServer <First port number> <First HostName> <Second port number> <Second HostName>");
			System.exit(1);
		}
		ExecutorService executor = Executors.newFixedThreadPool(2);

		DataReceiver dataReceiver1 =getDataRecevier( args[0], args[1]);		//// building new DataReceiver object to connect to server 1
		DataReceiver dataReceiver2 =getDataRecevier( args[2], args[3]);// building new DataReceiver object to connect to server 2
		Future<?> threadInfo1 = executor.submit(dataReceiver1);		
		Future<?> threadInfo2 = executor.submit(dataReceiver2);
		
		while (!threadInfo1.isDone() || !threadInfo2.isDone())
			try {
				Thread.sleep(100);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		printBestFive(totalWordsCounts);
		executor.shutdown();
	}

	static private void printBestFive(ConcurrentHashMap<String, Integer> wordsCounts) {
		Object[] topFiveWords = new Object[5];

		topFiveWords = wordsCounts.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(5)
				.toArray();
		 int lengthOfPairs=topFiveWords.length;
		for (int i = 0; i <lengthOfPairs; i++) {
			Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>) topFiveWords[i];
			System.err.print(" " + pair.getKey() + " " + pair.getValue());

		}
		System.err.println();
	}

	static private DataReceiver  getDataRecevier(String port,String hostIp)
	{
		int portNumber = Integer.parseInt(port);
		DataReceiver dataReceiver= new DataReceiver(portNumber, totalWordsCounts, hostIp);
		return dataReceiver;
		
	}
}
