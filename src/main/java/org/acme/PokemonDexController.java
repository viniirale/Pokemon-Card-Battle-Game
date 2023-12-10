package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.io.File;
import java.util.List;
import java.util.Optional;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.security.RolesAllowed;

@Path("/pokemon")
public class PokemonDexController {
    @GET
    @Path("info/{id}")
    @RolesAllowed({"User", "Admin"})
    @Produces(MediaType.APPLICATION_JSON)
    public Pokemon getPokemonDex(@PathParam("id") int id) {
        try {
            // Crie o caminho para pegar o arquivo JSON contendo as informações do pokemon por ID
            File pokemonFile = new File("src/main/resources/pokedex.json");

            // Verifique se o arquivo existe
            if (pokemonFile.exists()) {
                // Cria uma lista a partir do arquivo JSON
                List<Pokemon> pokemonList = new ObjectMapper().readValue(pokemonFile, new TypeReference<List<Pokemon>>() {});
                Optional<Pokemon> pokemon = pokemonList.stream().filter(p -> p.getId() == id).findFirst();
                
                if (pokemon.isPresent()) {
                    return pokemon.get();
                } else {
                    // Se o Pokémon não for encontrado, retorne null (pode ser tratado como 404 do lado do cliente)
                    return null;
                }
            } else {
                // Se o arquivo não existir, retorne null (pode ser tratado como 404 do lado do cliente)
                return null;
            }
        } catch (Exception e) {
            // Retorna a mensagem de erro do debug
            System.out.println(e.getMessage());
            // Em caso de erro, retorne null (pode ser tratado como 500 do lado do cliente)
            return null;
        }
    }
}
