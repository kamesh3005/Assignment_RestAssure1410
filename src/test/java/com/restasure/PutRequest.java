package com.restasure;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class PutRequest {

	@Test

	public void addDetials() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// Response Object
		Response responce = httpRequest.request(Method.PUT, "/maps/api/place/get/json?place_id=a3f53cb6244e6152cb0d401e88ff00e4&key=qaclick123");
		
		
		
		httpRequest.log().all().body("{\r\n"
				+ "\"place_id\":\"a3f53cb6244e6152cb0d401e88ff00e4\",\r\n"
				+ "\"address\":\"kamesh, pallikonda vellore\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "}");
		httpRequest.when().put("/maps/api/place/update/json").then().log().all();
		
		String responceBody = responce.body().asString();
		
		System.out.println("Response Body : "+responceBody);
		

	}

}
