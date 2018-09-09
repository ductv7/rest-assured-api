package com.rest.assured.files;

public class PayLoad {

	public static String postBodyUpdateIdByCity(){
		//Update pressure from 1012 to 1013
		String data = "{\r\n" + 
				"  \"coord\": {\r\n" + 
				"    \"lon\": -0.13,\r\n" + 
				"    \"lat\": 51.51\r\n" + 
				"  },\r\n" + 
				"  \"weather\": [\r\n" + 
				"    {\r\n" + 
				"      \"id\": 300,\r\n" + 
				"      \"main\": \"Drizzle\",\r\n" + 
				"      \"description\": \"light intensity drizzle\",\r\n" + 
				"      \"icon\": \"09d\"\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  \"base\": \"stations\",\r\n" + 
				"  \"main\": {\r\n" + 
				"    \"temp\": 280.32,\r\n" + 
				"    \"pressure\": 1012,\r\n" + 
				"    \"humidity\": 81,\r\n" + 
				"    \"temp_min\": 279.15,\r\n" + 
				"    \"temp_max\": 281.15\r\n" + 
				"  },\r\n" + 
				"  \"visibility\": 10000,\r\n" + 
				"  \"wind\": {\r\n" + 
				"    \"speed\": 4.1,\r\n" + 
				"    \"deg\": 80\r\n" + 
				"  },\r\n" + 
				"  \"clouds\": {\r\n" + 
				"    \"all\": 90\r\n" + 
				"  },\r\n" + 
				"  \"dt\": 1485789600,\r\n" + 
				"  \"sys\": {\r\n" + 
				"    \"type\": 1,\r\n" + 
				"    \"id\": 5091,\r\n" + 
				"    \"message\": 0.0103,\r\n" + 
				"    \"country\": \"GB\",\r\n" + 
				"    \"sunrise\": 1485762037,\r\n" + 
				"    \"sunset\": 1485794875\r\n" + 
				"  },\r\n" + 
				"  \"id\": 2643743,\r\n" + 
				"  \"name\": \"London\",\r\n" + 
				"  \"cod\": 200\r\n" + 
				"}";
		
		return data;
	}
}
