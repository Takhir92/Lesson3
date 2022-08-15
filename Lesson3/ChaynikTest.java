package Lesson3;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ChaynikTest {
    @Test
    void getChaynikTest() {

        given()
                .queryParam("apiKey", "2d04372f8d2d4b36a03e05b84c73b895")
                .queryParam("includeNutrition", "false")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?minProtein=5&maxCholine=66")
                .then()
                .statusCode(200);
        given()
                .queryParam("apiKey", "2d04372f8d2d4b36a03e05b84c73b895")
                .queryParam("includeNutrition", "false")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?maxSaturatedFat=256&maxVitaminB5=78")
                .then()
                .statusLine("HTTP/1.1 200 OK");
        given()
                .queryParam("apiKey", "2d04372f8d2d4b36a03e05b84c73b895")
                .queryParam("includeNutrition", "false")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?minCalories=478")
                .then()
                .statusLine("HTTP/1.1 200 OK");
        given()
                .queryParam("apiKey", "2d04372f8d2d4b36a03e05b84c73b895")
                .queryParam("includeNutrition", "false")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?sortDirection=vuga")
                .then()
                .contentType(ContentType.JSON);
        given()
                .queryParam("apiKey", "2d04372f8d2d4b36a03e05b84c73b895")
                .queryParam("includeNutrition", "false")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?minIron=-8")
                .then()
                .statusCode(200);

    }

    @Test
    void postChaynikTest(){
        given()
                .queryParam("apiKey" + "2d04372f8d2d4b36a03e05b84c73b895")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Pork roast with green beans")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine?apiKey=2d04372f8d2d4b36a03e05b84c73b895")
                .then()
                .statusCode(200);
        given()
                .queryParam("apiKey" + "2d04372f8d2d4b36a03e05b84c73b895")
                .contentType("application/x-www-form-urlencoded")
                .formParam("ingredientList","London Chiken")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine?apiKey=2d04372f8d2d4b36a03e05b84c73b895&ingredientList=London Chiken")
                .then()
                .statusCode(200);
        given()
                .queryParam("apiKey" + "2d04372f8d2d4b36a03e05b84c73b895")
                .contentType("application/x-www-form-urlencoded")
                .formParam("ingredientList","London Chiken")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine?apiKey=2d04372f8d2d4b36a03e05b84c73b895&ingredientList=London Chiken")
                .then()
                .statusCode(200);
        given()
                .queryParam("apiKey" + "2d04372f8d2d4b36a03e05b84c73b895")
                .contentType("application/x-www-form-urlencoded")
                .formParam("language","de")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine?apiKey=2d04372f8d2d4b36a03e05b84c73b895&language=de")
                .then()
                .contentType(ContentType.JSON);
        given()
                .queryParam("apiKey" + "2d04372f8d2d4b36a03e05b84c73b895")
                .contentType("application/x-www-form-urlencoded")
                .formParam("language","de")
                .when()
                .post("https://api.spoonacular.com/recipes/cuisine?apiKey=2d04372f8d2d4b36a03e05b84c73b895&language=de")
                .then()
                .statusLine("HTTP/1.1 200 OK");

    }

    @Test
    void addMealTest(){
       given()
                .queryParam("hash", "1930d1f309867974f36239aaf1d5fc67f477f477")
                .queryParam("apiKey", "2d04372f8d2d4b36a03e05b84c73b895")
                .body("{\n"
                        + " \"date\": 1644871111,\n"
                        + " \"slot\": 1,\n"
                        + " \"position\": 0,\n"
                        + " \"type\": \"INGREDIENTS\",\n"
                        + " \"value\": {\n"
                        + " \"ingredients\": [\n"
                        + " {\n"
                        + " \"name\": \"1 apple\"\n"
                        + " }\n"
                        + " ]\n"
                        + " }\n"
                        + "}")
                .when()
                .post("https://api.spoonacular.com/mealplanner/Takhir/items")
                .then()
                .statusCode(401);
    }
    @AfterEach
    void TearDown(){
        given()
                .queryParam("hash", "1930d1f309867974f36239aaf1d5fc67f477f477")
                .queryParam("apiKey", "2d04372f8d2d4b36a03e05b84c73b895")
                .delete("https://api.spoonacular.com/mealplanner/Takhir/items" + 1)
                .then()
                .statusCode(404);
    }



}
