package com.Lone_soilder.AutomationExercise;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItems;

public class HarmcrestLearning {

    @Test
    public void containsMethod(){

        //Response response=
                given().
                baseUri("https://reqres.in/").
        when().
                get("api/unknown").
        then().
                //extract().response();
                assertThat().
                statusCode(200).
                body("data.id", contains(1,2,3,4,5,6));

//        assertThat(response.path("data.id"), contains(1,2,3,4,5,6));
//        assertThat(response.path("data.year"), hasItems(2000, 2002));
    }

}
