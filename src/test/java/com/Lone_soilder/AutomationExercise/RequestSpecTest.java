package com.Lone_soilder.AutomationExercise;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class RequestSpecTest {

    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in")
            .setContentType("application/json")
            .addHeader("dummyHeader", "dummyValue")
            .log(LogDetail.ALL)
            .build();

    @BeforeClass
    public void beforeClass(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .log(LogDetail.ALL);

        RestAssured.requestSpecification = requestSpecBuilder.build();
    }
//    @BeforeClass
//    public void beforeClass() {
//         requestSpecification =
//                 with().
//                         baseUri("https://reqres.in").
//                         log().all();
//    }

    @Test
    public void setRequestSpecificationInBDD() {
        // this is a BDD style definition of function , when we call given, when, then
        given().
                spec(requestSpecification).
        when().
                get("/api/unknown").
        then().
                assertThat().
                log().all().
                statusCode(200);
    }

    @Test
    public void setRequestSpecificationNonBDD(){
        // the below definition is non-BDD (we will exclude then() also in future)

        //we are returning the response by calling extract()
        Response response =  requestSpecification.get("/api/unknown").
                                                    then().log().all().extract().response();
        // now assert the response using hamcrest
        assertThat(response.path("data[1].id"), is(equalTo(2)));
        assertThat(response.statusCode(), equalTo((200)));
    }

    @Test
    public void myReqestSpecTest(){
        RequestSpecification myReq = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setContentType("application/json")
                .build();

        //now using the reqestSpec to call an api

        given().spec(myReq).
                 when()
                    .get("/api/users/2")
                .then()
                    .statusCode(200);
    }
}
