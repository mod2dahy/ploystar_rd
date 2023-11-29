package com.ploystar.draft;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DraftSol {
	static HashMap<String, Integer> wordsCounts = new HashMap<>();
	static HashMap<String, Integer> wordsCounts1 = new HashMap<>();

	public static void main(String[] args) {
		try {
			useBuffer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	wordsCounts=new HashMap<>();
		useScanner();
	}

	static void useBuffer() throws IOException {

		//System.err.println(new Date().getTime());
		Long start=new Date().getTime();
		String fileName = "files//textfil1_lasse_solen_i_ogonen.txt";
		String fileName1 = "files//textfil2_lasse_varning_for_ras.txt";
		BufferedReader br = null;
		FileReader fr = null;
		try {
			// read file into stream, try-with-resources
			
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			loadToMap(br);

			fr = new FileReader(fileName1);
			br = new BufferedReader(fr);
			loadToMap(br);
		//	printing();

			System.err.println("  useBuffer"+( new Date().getTime()-start));
			fr.close();
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			fr.close();
			br.close();
		}

	}

	static void useScanner() {
		FileInputStream inputStream = null;
		Scanner sc = null;
		Long start=new Date().getTime();
		String fileName = "files//textfil1_lasse_solen_i_ogonen.txt";
		String fileName1 = "files//textfil2_lasse_varning_for_ras.txt";
		String f = "files//testing";
		try {
			// read file into stream, try-with-resources
			inputStream = new FileInputStream(fileName);
			sc = new Scanner(inputStream);
			loadToMap(sc);
			inputStream = new FileInputStream(fileName1);
			sc = new Scanner(inputStream);
			loadToMap(sc);
			System.err.println(wordsCounts.size());


			//printing();



			System.err.println(" use Scanner"+( new Date().getTime()-start));

			// note that Scanner suppresses exceptions
			if (sc.ioException() != null) {
				throw sc.ioException();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (inputStream != null) {

			}
			if (sc != null) {
				sc.close();
			}
		}

	}

	static void printing() {
		System.err.println("Printing");
		Object[] strs = new Object[5];
		ArrayList<String> strList = new ArrayList<>();
		HashMap<String, Integer> result = new HashMap<>();
		strs = wordsCounts.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(5)
				.toArray();

		wordsCounts.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(5)
				.forEach(System.out::println);
		// forEach(System.out::println);

		for (int i = 0; i < strs.length; i++) {
			Map.Entry<String, Integer> f = (Map.Entry<String, Integer>) strs[i];
			System.err.println(f.getKey() + " " + f.getValue());

		}
	}

	static void loadToMap(Scanner sc) {
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			// System.out.println(line);
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
	}

	static void loadToMap(BufferedReader br) throws IOException {
		String line = "";
		while ((line = br.readLine()) != null) {
			if (line.isEmpty())
				continue;
			// System.out.println(line);
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
	}
}
