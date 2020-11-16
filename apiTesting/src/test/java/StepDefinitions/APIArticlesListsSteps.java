package StepDefinitions;

import cucumber.api.java.en.Given;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class APIArticlesListsSteps {

    @Given("^I perform GET articles request$")
    public void iPerformGetArticleRequest() {
        RestAssured.baseURI = "https://5f99522350d84900163b8737.mockapi.io";
        given().
                when().
                get("/tech-test/articles").
                then().assertThat().statusCode(200).
                and().
                contentType(ContentType.JSON).and().
                body("[0].id", equalTo("1")).and().
                        body("[1].id", equalTo("2")).and().
                                body("[2].id", equalTo("3")).and().
                                        body("[3].id", equalTo("4656364867443")).and().
                                                body("[4].id", equalTo("5"));
        System.out.println("GET Request is executed successfully");
    }

    @Given("^I perform POST articles request$")
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

    @Given("^I perform PUT articles request$")
    public void iPerformPUTArticlesRequest() {
        RestAssured.baseURI = "https://5f99522350d84900163b8737.mockapi.io";
        given().pathParam("id","5").
                when().delete("/tech-test/articles").
                then().assertThat().statusCode(404);
        System.out.println("PUT Request is executed successfully");
    }

    @Given("^I perform DELETE articles request$")
    public void iPerformDELETEArticleRequest() {
        RestAssured.baseURI = "https://5f99522350d84900163b8737.mockapi.io";
        given().pathParam("id","5").
                when().delete("/tech-test/articles/{id}").
                then().assertThat().statusCode(404);
        System.out.println("Delete Request is executed successfully");
    }
}
