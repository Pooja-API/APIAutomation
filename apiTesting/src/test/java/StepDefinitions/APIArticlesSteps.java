package StepDefinitions;

import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APIArticlesSteps {
    @Given("^I perform GET article request$")
    public void iPerformGETArticleRequest() {
        RestAssured.baseURI = "https://5f99522350d84900163b8737.mockapi.io";
        given().
                when().
                get("/tech-test/articles/2").
                then().assertThat().statusCode(200).
                and().
                contentType(ContentType.JSON).and().
                body("id", equalTo("2"));
        System.out.println("GET Request is executed successfully");
    }

    @Given("^I perform POST article request$")
    public void iPerformPOSTArticleRequest() {
        RestAssured.baseURI = "https://5f99522350d84900163b8737.mockapi.io";
        given().body("{"+
                "\"id\": \"6\","+
                "\"title\": \"title 6\","+
                "\"priority\": [\"100\"],"+
                "}").
                when().
                post("/tech-test/articles").
                then().assertThat().statusCode(404);
        System.out.println("POST Request is executed successfully");
    }

    @Given("^I perform DELETE article request$")
    public void iPerformDELETEArticleRequest() {
        RestAssured.baseURI = "https://5f99522350d84900163b8737.mockapi.io";
        given().pathParam("id","2").
                when().delete("/tech-test/articles/{id}").
                then().assertThat().statusCode(404);
        System.out.println("Delete Request is executed successfully");
    }
}
