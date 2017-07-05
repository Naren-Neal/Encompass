package json;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ReadJsonObject {
	public void aptTesting() throws Exception {
	
		
		
		try {
		URL url = new URL(
		"http://restcountries.eu/rest/v1");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
		throw new RuntimeException("HTTP error code : "
		+ conn.getResponseCode());
		}

		Scanner scan = new Scanner(url.openStream());
		String entireResponse = new String();
		while (scan.hasNext())
		entireResponse += scan.nextLine();

		System.out.println("Response : "+entireResponse);

		scan.close();

		JSONObject obj = new JSONObject();
		String responseCode = obj.getString("status");
		System.out.println("status : " + responseCode);

		JSONArray arr = obj.getJSONArray("results");
		
		for (int i = 0; i < arr.size(); i++) {
		String placeid = arr.getJSONObject(i).getString("place_id");
		System.out.println("Place id : " + placeid);
		String formatAddress = arr.getJSONObject(i).getString(
		"formatted_address");
		System.out.println("Address : " + formatAddress);

		//validating Address as per the requirement
		if(formatAddress.equalsIgnoreCase("Chicago, IL, USA"))
		{
		System.out.println("Address is as Expected");
		}
		else
		{
		System.out.println("Address is not as Expected");
		}
		}

		conn.disconnect();
		} catch (MalformedURLException e) {
		e.printStackTrace();

		} catch (IOException e) {

		e.printStackTrace();

		}

		}
		

	}


