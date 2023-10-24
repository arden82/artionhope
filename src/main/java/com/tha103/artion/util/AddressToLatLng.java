package com.tha103.artion.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class AddressToLatLng {
	private static final String API_KEY = "AIzaSyBMvmNl9HJ9NkBAsw68E5NfRuZ4g2rIFz4";
	private static  double[] addressToLatLng(String address) {
		String apiUrl="https://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&key=" + API_KEY;
		try {
			   HttpClient httpClient = HttpClients.createDefault();
			   HttpGet httpGet = new HttpGet(apiUrl);
			   org.apache.http.HttpResponse httpResponse = httpClient.execute(httpGet);
	            String jsonResult = EntityUtils.toString(httpResponse.getEntity());
	            
	            JsonObject data = JsonParser.parseString(jsonResult).getAsJsonObject();
	            if (data.get("status").getAsString().equals("OK")) {
	                JsonObject location = data.getAsJsonArray("results").get(0)
	                        .getAsJsonObject().getAsJsonObject("geometry").getAsJsonObject("location");
	                double latitude = location.get("lat").getAsDouble();
	                double longitude = location.get("lng").getAsDouble();

	                double[] coordinates = {latitude,longitude};
	                return coordinates;
	            }
		} catch (Exception e) {
            e.printStackTrace();
        }
		return null; //轉換失敗
	}
}
