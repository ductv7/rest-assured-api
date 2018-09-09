package com.rest.assured.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.rest.assured.common.BaseTest;
import com.rest.assured.common.Global;
import com.rest.assured.files.Resources;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;


public class GetMethod_002_xml extends BaseTest {

	@Test
	public void getNearByGoogleMapAPI() {
		//GoogleMapAPI baseURL
		IntializeBaseURL();
		Response res = given().
				param("key", "AIzaSyDrzH05ZO1m0HuRN3uN6LhcmnkKEycEoT8").
				param("location","-33.8670522,151.1957362").
				param("radius","1500").
				param("type","restaurant").
				param("keyword","cruise").
		when().
				get(Resources.getPathMapAPI()).
		then().
				assertThat().statusCode(200).and().contentType(ContentType.XML).extract().response();
		
		rawToXml(res).get("PlaceSearchResponse.result.name");
		
		//System.out.println(xml.get("PlaceSearchResponse.result.name"));//di vao tung node trong file xml
	}
}
