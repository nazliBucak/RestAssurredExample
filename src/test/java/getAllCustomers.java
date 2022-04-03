import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class getAllCustomers extends baseUrl {

    @Test
    public void getRequest() {
        Response response = given()
                .header("auth_key", "hello")
                .header("user-id", "c7460516-0bfb-48a3-8185-8231da4fb162")
                .header("Content-Type","application/json; charset=utf-8")
                .when()
                .get("/customers")
                .then()
                .log()
                .body()
                .extract()
                .response();

        Assertions.assertEquals(200, response.statusCode());
    }

}
