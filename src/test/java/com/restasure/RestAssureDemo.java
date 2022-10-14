package com.restasure;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.PayLoad;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class RestAssureDemo {
	
	
	
	@Test
	
	
	public void tc1() {
		
		
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		
		String res=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(PayLoad.inputdata()).when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
			.header("server","Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		
		JsonPath jsp=new JsonPath(res);
		
		Assert.assertEquals(jsp.getString("scope"),"APP","The Scope is not matched");
		
		
		
			
		
		
		
		
	}

	

}
