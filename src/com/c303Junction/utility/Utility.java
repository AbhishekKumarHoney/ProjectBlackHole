package com.c303Junction.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Utility {

	public static String readFile(String fileLocation) {

		StringBuilder builder = new StringBuilder();

		File file = new File(fileLocation);

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String st;
		try {
			while ((st = br.readLine()) != null) {
				System.out.println(st);
				builder.append(st);
				builder.append("\n");

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return builder.toString();

	}
}