package com.restasure;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetRequest {

	@Test

	void test1() {

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET,
				"/maps/api/place/get/json?place_id=041510b674976903a0eb6aa8b002b0e8&key=qaclick123");
		String responseBody = response.getBody().jsonPath().prettify();
		System.out.println(responseBody);

		int statusCode = response.getStatusCode();

		System.out.println("Status code is :" + statusCode);
		Assert.assertEquals(statusCode, 200);

		String contentLength = response.header("Content-Length");

		System.out.println("The ContentLength is :" + contentLength);

		Assert.assertEquals(contentLength, "257");
	}

}
