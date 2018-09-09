package com.rest.assured.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

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
			body("main.pressure",equalTo(1017)).
			extract().response(); //number does not need to put on "", string does have
		
		//Grab place ID on response
		rawToJson(res).get("name");
	}
}