import io.restassured.RestAssured;

import io.restassured.specification.Argument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class ApiTest {

    public static String urlStore = "https://restful-booker.herokuapp.com/booking";


    @DisplayName("Добавить книгу")
    @Test
    public void testAddBookPost() throws IOException {

        byte[] bytes = Files.readAllBytes(Paths.get("src/test/resources/create.json"));
        String jsonBody = new String(bytes, StandardCharsets.UTF_8);

         RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .when().post(urlStore)
                .then()
                .statusCode(200)
                .body("booking.firstname", equalTo("Jimsss"))
                .body("booking.lastname", equalTo("Brownsss"))
                .body("booking.depositpaid", equalTo(true))
                .body("booking.bookingdates.checkin", notNullValue());

    }



    @DisplayName("Провереть описание книг")
    @Test
    public void testShowBooksGet(){

        RestAssured
                .given()
                .header("Content-Type", "application/json")
                .when().get(urlStore + "/1585")
                .then()
                .statusCode(200)
                .body("firstname", equalTo("Jimsss"))
                .body("lastname", equalTo("Brownsss"));



    }

    @DisplayName("Добавить книгу")
    @Test
    public void testNootsAuth() throws IOException {

        byte[] bytes = Files.readAllBytes(Paths.get("src/test/resources/create.json"));
        String jsonBody = new String(bytes, StandardCharsets.UTF_8);

        RestAssured
                .given()
                //.auth().basic("username", "password")
                //.auth().oauth2("1b906f2c0463848")
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .when().post(urlStore)
                .then()
                .statusCode(200);


    }
}
