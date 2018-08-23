package com.c303Junction.init;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Credentials {

	private String clientId;
	private String clientKey;

	private static Credentials credentials;

	private Credentials(String clientId, String clientKey) {
		super();
		this.clientId = clientId;
		this.clientKey = clientKey;
	}

	public String getClientId() {
		return clientId;
	}

	public String getClientKey() {
		return clientKey;
	}

	public static synchronized Credentials getInstance() {

		String clientid = null;
		String clientkey = null;

		String[] arr = readCredentialsFromFile();
		
		clientid = arr[0];
		clientkey = arr[1];

		credentials = new Credentials(clientid, clientkey);

		return credentials;
	}

	private static String[] readCredentialsFromFile() {

		String[] ret = new String[2];

		File file = new File("/Users/apple/eclipse-workspace/ProjectBlackHole/Do not commit/Credit.txt");

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

				if (st.contains("<")) {
					ret[0] = st.substring(1, st.length()-1);
				}
				if (st.contains("(")) {
					ret[1] = st.substring(1, st.length()-1);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
	}

	@Override
	public String toString() {
		return "Credentials [clientId=" + clientId
				+ ", clientKey="
				+ clientKey
				+ "]";
	}

	public static void main(String[] args) throws IOException {
		Credentials credentials = Credentials.getInstance();
		
		System.out.println(credentials);
	}

}
