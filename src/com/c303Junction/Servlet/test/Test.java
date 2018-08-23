package com.c303Junction.Servlet.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.c303Junction.init.Credentials;

public class Test {

	public static void main(String args[]) {

		Credentials credentials = Credentials.getInstance();
		
		
		
		String clientId = credentials.getClientId(); // Replace with your client ID
		String clientSecret = credentials.getClientKey(); // Replace with your client Secret
		String script = "public class HelloWorld {\\r\\n   public static void main(String[] args) {\\r\\n      System.out.println(\\\"Hello, World\\\");\\r\\n   }\\r\\n}";
		String language = "java";
		String versionIndex = "0";

		try {
			URL url = new URL("https://api.jdoodle.com/v1/execute");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");

			String input = "{\"clientId\": \"" + clientId
							+ "\",\"clientSecret\":\""
							+ clientSecret
							+ "\",\"script\":\""
							+ script
							+ "\",\"language\":\""
							+ language
							+ "\",\"versionIndex\":\""
							+ versionIndex
							+ "\"} ";

			System.out.println(input);

			OutputStream outputStream = connection.getOutputStream();
			outputStream.write(input.getBytes());
			outputStream.flush();

			if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Please check your inputs : HTTP error code : "
											+ connection.getResponseCode());
			}

			BufferedReader bufferedReader;
			bufferedReader = new BufferedReader(new InputStreamReader((connection.getInputStream())));

			String output;
			System.out.println("Output from JDoodle .... \n");
			while ((output = bufferedReader.readLine()) != null) {
				System.out.println(output);
			}

			connection.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
