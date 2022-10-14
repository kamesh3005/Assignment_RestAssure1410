package com.jiraproject;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Authentication {
	
	
	SessionFilter session = new SessionFilter();

	@Test(enabled = false)

	void tc1() {

		JSONObject js = new JSONObject();
		js.put("username", "kameshck");
		js.put("password", "Kamesh@30");

		Response resp = RestAssured.given().header("Content-Type", "application/json").body(js)
				.post("http://localhost:8001/rest/auth/1/session");

		System.out.println(resp.getStatusCode());
		System.out.println(resp.getBody().jsonPath().prettify());
		String sessionID = resp.getCookies().get("JSESSIONID");

		Response response = RestAssured.given().contentType(ContentType.JSON).cookie("JSESSIONID", sessionID)
				.body("{\r\n" + "    \"fields\": {\r\n" + "       \"project\":\r\n" + "       {\r\n"
						+ "          \"key\": \"MYN\"\r\n" + "       },\r\n"
						+ "       \"summary\": \"This is my second Issue.\",\r\n"
						+ "       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n"
						+ "       \"issuetype\": {\r\n" + "          \"name\": \"Task\"\r\n" + "       }\r\n"
						+ "   }\r\n" + "} ")
				.post("http://localhost:8001/rest/api/2/issue/");

		System.out.println(response.getBody().jsonPath().prettify());

	}
	
	
	@Test
	
	void tc2() {
		
		
		RestAssured.baseURI="http://localhost:8001";
		
		
	String addcommand= given().log().all().pathParam("id","MYN-2").header("Content-Type","application/json")
		 .body("{\r\n"
		 		+ "    \"body\": \"This is a comment regarding the quality of the response.\"\r\n"
		 		+ "}").filter(session).when().post("/rest/api/2/issue/MYN-2/comment")
		 .then().log().all().statusCode(201).extract().response().asString();
	
	JsonPath js1=new JsonPath(addcommand);
	String commandID = js1.get("id");
	System.out.println("The Command ID is :"+commandID);
	
		 
		 
	}

}
