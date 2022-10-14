package com.restasure;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeletRequest {

	@Test

	void deleteData() {

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.DELETE, "/maps/api/place/delete/json?key=qaclick123");

	httpRequest.body("{\r\n"
			+ "\"place_id\":\"d359bfebc7a3e00ab842e9e06d62e41b\"\r\n"
			+ "}");
	
	System.out.println(response.statusCode());

	}

}
