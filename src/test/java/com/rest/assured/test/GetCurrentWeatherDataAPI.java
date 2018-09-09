package com.rest.assured.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rest.assured.common.BaseTest;
import com.rest.assured.common.Global;
import com.rest.assured.files.Resources;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class GetCurrentWeatherDataAPI extends BaseTest {
	
	static final Logger logger = Logger.getLogger(GetCurrentWeatherDataAPI.class.getName());
	
	@Test
	public void GetMainPressureByCityName() {
		
		IntializeBaseURL();
		Response res = given().
				param("q", lp.getData("cityName")).
			    param("appid", Global.appId).
		when().
				get(Resources.getWeatherAPI()).
		then().
				assertThat().statusCode(200).and().extract().response();
		
		assertTrue (rawToJson(res).get("main.pressure").equals(1017));
	}
	
	
//	@Test 
//	public void GetMainPressureByCityCode(){
//		
//		IntializeBaseURL();
//		given().
//				param("q", lp.getData("cityCode")).
//				param("appid", Global.appId).
//		when().
//				get(Resources.getWeatherAPI()).
//		then().
//				assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
//				body("main.pressure", equalTo(1017)).extract().response();
//	}
//	
//	@Test 
//	public void GetMainPressureByCityId(){
//		
//		IntializeBaseURL();
//		given().
//				param("q", 2643743).
//				param("appid", Global.appId).
//		when().
//				get(Resources.getWeatherAPI()).
//		then().
//				assertThat().statusCode(200).and().contentType(ContentType.JSON).
//				and().body("main.pressure", equalTo(1017)).extract().response();
//	}
//	
}
