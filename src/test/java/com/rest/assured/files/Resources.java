package com.rest.assured.files;

public class Resources {

	public static String getWeatherAPI(){
		
		String getWeather = "data/2.5/weather";
		
		return getWeather;
	}
	
	public static String getForecaseAPI(){
		
		String getForecast = "data/2.5/forecast";
		
		return getForecast;
	}
	
	//use only for google map API -- return xml or json, you need to update path
	
	public static String getPathMapAPI(){
		
		String getPath = "maps/api/place/nearbysearch/json"; //with xml,it should be "maps/api/place/nearbysearch/xml" 
		
		return getPath;
	}
}
