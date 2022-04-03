import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class getCustomer extends baseUrl{


    @Test
   public void getRequest() {
        Response response = given()
                .header("auth_key", "hello")
                .header("user-id", "c7460516-0bfb-48a3-8185-8231da4fb162")
                .header("Content-type", "application/json; charset=utf-8")
                .contentType(ContentType.JSON)
                .when()
                .get("/customer?id=3")
                .then()
                .log()
                .body()
                .extract()
                .response();

        Assertions.assertEquals(200, response.statusCode());

    }

}
