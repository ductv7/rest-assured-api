package com.rest.assured.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.rest.assured.common.BaseTest;
import com.rest.assured.common.Global;
import com.rest.assured.files.Resources;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;


public class GetMethod_002_json extends BaseTest {

	@Test
	public void getNearByGoogleMapAPI() {
		
		IntializeBaseURL();
		Response res =  given().
				param("key", "AIzaSyDrzH05ZO1m0HuRN3uN6LhcmnkKEycEoT8").
				param("location","-33.8670522,151.1957362").
				param("radius","1500").
				param("type","restaurant").
				param("keyword","cruise").log().all().	//show all logs of request
		when().
				get(Resources.getPathMapAPI()).
		then().
				assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
				body("results[1].name", equalTo("Sydney Showboats")).and().
				body("results[1].place_id", equalTo("ChIJjRuIiTiuEmsRCHhYnrWiSok")).and().
				extract().response();
				
		int count = rawToJson(res).get("results.size()");
		
		for (int i=0;i < count;i++){
			
			rawToJson(res).get("results["+i+"].name");
		}
		
		System.out.println(count);
		
		
		//System.out.println(xml.get("PlaceSearchResponse.result.name"));//di vao tung node trong file xml
		
		
		
	}
}
