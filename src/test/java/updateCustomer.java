import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class updateCustomer extends baseUrl {

    @Test
    public void putRequest() {

        File requestPut = new File("src/test/resources/putBody.json");

        Response response = given()
                .header("auth_key", "hello")
                .header("user-id", "c7460516-0bfb-48a3-8185-8231da4fb162")
                .header("Content-type", "application/json; charset=utf-8")
                .body(requestPut)
                .when()
                .put("/customer/4954")
                .then()
                .log()
                .body()
                .extract()
                .response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("You updated a customer! ✅", response.jsonPath().getString("tutorial.title"));
    }

}