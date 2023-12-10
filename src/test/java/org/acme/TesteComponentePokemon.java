package org.acme;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;


@QuarkusTest
public class TesteComponentePokemon {
    

    @Test
    public void testGetPokemonDexEndpoint() {

        // Faça a chamada ao endpoint e verifique se o status é 200 (OK)
        given()
            .when()
                .get("/pokemon/info/{id}", 001) // substitua {id} pelo ID desejado
            .then()
                .statusCode(200);
    }

    @Test
    //teste se a resposta é do tipo JSON
    public void testGetPokemonDexEndpointJSON() {

        // Faça a chamada ao endpoint e verifique se o status é 200 (OK)
        given()
            .when()
                .get("/pokemon/info/{id}", 150) // substitua {id} pelo ID desejado
            .then()
                .statusCode(200)
                .contentType("application/json"); // Verifique se o tipo de conteúdo da resposta é JSON
    }

    @Test
    public void testGetPokemonDexEndpointNotFound() {

        // Faça a chamada ao endpoint e verifique se o status é 404 (não encontrado)
        given()
            .when()
                .get("/pokemon/info/{id}", "palavra") 
            .then()
                .statusCode(404);
    }

    @Test
    public void testGetPokemonDexEndpointNotContent() {

        // Faça a chamada ao endpoint e verifique se o status é 404 (não encontrado)
        given()
            .when()
                .get("/pokemon/info/{id}", 0) 
            .then()
                .statusCode(204);
    }

    @Test
    public void testGetPokemonImageEndpoint() {
        given()
            .when()
                .get("/pokemon/image/{id}", 123) // substitua {id} pelo ID desejado
            .then()
                .statusCode(200);
    }

    @Test
    public void testGetPokemonImageEndpointPNG() {
        given()
            .when()
                .get("/pokemon/image/{id}", 123) // substitua {id} pelo ID desejado
            .then()
                .statusCode(200)
                .contentType("image/png"); // Verifique se o tipo de conteúdo da resposta é imagem png
    }

    @Test
    public void testGetPokemonImageEndpointNotFound() {
        given()
            .when()
                .get("/pokemon/image/{id}", "palavra") // substitua {id} pelo ID desejado
            .then()
                .statusCode(404);
    }
    

}