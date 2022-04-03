import io.restassured.RestAssured;

import org.junit.jupiter.api.BeforeAll;

public class baseUrl {


    @BeforeAll
    public static void setup() {

        RestAssured.baseURI = "https://api-101.glitch.me";
    }

}