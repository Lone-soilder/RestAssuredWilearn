package com.Lone_soilder.AutomationExercise;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestApi {

    @Test
    public void getAllProductList(){

        Response response =
        given().
                baseUri("https://automationexercise.com/api").
        when().
                get("/productsList").
        then().
                assertThat().statusCode(200).extract().response();

        System.out.println("we got the response after this we request for all product list are " +response.asString());

        //extract the single field
        System.out.println("product 1 id is " + response.path("products[0].id")); // will not give expected result since it is in xml format.

        //extract and validate a single field from the json using jsonpath
        JsonPath jsonPath = new JsonPath(response.asString());
        System.out.println("product one id is "+ jsonPath.getInt("products[0].id")); // getint method for int value of id
        System.out.println("product one name is "+ jsonPath.getString("products[0].name")); // getString method for int value of id


    }

}
