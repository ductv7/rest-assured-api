package com.rest.assured.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rest.assured.common.BaseTest;
import com.rest.assured.common.Global;
import com.rest.assured.files.PayLoad;
import com.rest.assured.files.Resources;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostCurrentWeatherDataAPI extends BaseTest{
	
	static final Logger log = LogManager.getLogger(PostCurrentWeatherDataAPI.class.getName());
	
	@DataProvider (name = "cityName")
	public static Object[] cityName(){
		
		return new Object[] {"London"};
	}
	
	@Test (dataProvider = "cityName")
	public void UpdateCityId (String cityName){
		
		Response res = given().
			queryParam("q", cityName ).
			queryParam("appid", Global.appId).
			body(PayLoad.postBodyUpdateIdByCity()).
			when().
				post(Resources.getWeatherAPI()).
			then().
				assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
			//body("main.pressure",equalTo(1017)).
			extract().response(); //number does not need to put on "", string does have
		
			//Grab place ID on response
			//int number = rawToJson(res).get("main.pressure");
			try {
			
				assertEquals(rawToJson(res).get("main.pressure"), "1017");
				
			}catch (Exception e){
				
				log.error("The result is not matched");
			}
	}
}