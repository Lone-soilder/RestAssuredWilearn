package com.Lone_soilder.AutomationExercise;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Test {

    @org.testng.annotations.Test
    public void demo(){
        given().
                baseUri("https://reqres.in/api").
        when().
                get("/users?page=2").
        then().
                log().all().
                statusCode(200);

    }

    @org.testng.annotations.Test
    public void getRequest(){
        given().
                baseUri("https://reqres.in/api/").
        when().
                get("users/2").
        then().log().all().
                assertThat().statusCode(200).
                body("data.first_name",equalTo("Janet")).
                body("data.id", equalTo(2));

    }

    @org.testng.annotations.Test
    public void getResponse(){
        Response response=
                given().
                        baseUri("https://reqres.in/api").
                when().
                        get("/users/2").
                then().
                        extract().response();


        // how to print the response body- System.out.println(response.asString());

        // first option to print a data from json
        System.out.println("email - "+ response.path("data.email"));

        // second option (initiate from JsonPath)
        JsonPath jsonPath = new JsonPath(response.asString());
        System.out.println("first name - "+ jsonPath.getString("data.first_name"));

        // third option (using from method of jsonpath)
        String lastName = JsonPath.from(response.asString()).getString("data.last_name");
        System.out.println("last name = "+ lastName);

        // assert the value using hamcrest matcher
        assertThat(lastName , equalTo("Weaver"));

        // assert the last name using testNG
        Assert.assertEquals(lastName, "Weaver");
    }
}
