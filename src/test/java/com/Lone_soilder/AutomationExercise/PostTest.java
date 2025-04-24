package com.Lone_soilder.AutomationExercise;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class PostTest {

    @BeforeClass
    public void beforeTest(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().setBaseUri("https://reqres.in/")
                .log(LogDetail.ALL);

        RequestSpecification requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON)
                .log(LogDetail.ALL);
        ResponseSpecification responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void postTestBDDStyle(){
        String payload = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        given().
                body(payload).
        when().
                post("/api/users").
                then().
                assertThat();


    }

}
