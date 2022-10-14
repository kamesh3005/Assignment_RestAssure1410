package com.restasure;

import org.testng.annotations.Test;

import com.base.PayLoad;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class PostRequest {
	RequestSpecification httprequest;

	@Test

	void tc1() {

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		httprequest = RestAssured.given();

		httprequest.log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(PayLoad.inputdata()).when().post("/maps/api/place/add/json").then().log().all();
		
		
	}

	

}
