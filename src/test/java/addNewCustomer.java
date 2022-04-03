import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.File;

import static io.restassured.RestAssured.given;

public class addNewCustomer extends baseUrl {

    @Test
    public void postRequest() {

        File requestPost = new File("src/test/resources/postBody.json");

        Response response = given()
                .header("auth_key", "hello")
                .header("user-id", "c7460516-0bfb-48a3-8185-8231da4fb162")
                .header("Content-Type","application/json; charset=utf-8")
                .body(requestPost)
                .when()
                .post("/customer")
                .then()
                .log()
                .body()
                .extract()
                .response();

        Assertions.assertEquals(201, response.statusCode());
        Assertions.assertEquals("You added a new customer! \uD83C\uDFC5", response.jsonPath().getString("tutorial.title"));

    }

}