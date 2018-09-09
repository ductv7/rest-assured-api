package com.rest.assured.common;

import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.rest.assured.properties.LoadProperties;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class BaseTest extends LoadProperties{
	
	public LoadProperties lp = new LoadProperties();
	
	@BeforeTest
	public void IntializeBaseURL(){
		
		RestAssured.baseURI = lp.getProp("baseURL"); 
	
	}
	
	@AfterTest
	public void resetBaseURL(){
		
		RestAssured.baseURI = null;
	}
	
	public static XmlPath rawToXml(Response r){
		
		String resp = r.asString();
		
		XmlPath xml = new XmlPath (resp);
		
		return xml;
	}
	
	public static JsonPath rawToJson (Response r){
		
		String resp = r.asString();
		
		JsonPath js = new JsonPath (resp);
		
		return js;
	}
	
	
	public String getDate (Date date){
		
		return date.toString();
	}
}
