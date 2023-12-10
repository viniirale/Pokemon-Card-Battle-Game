package org.acme;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class TesteUnitarioPokemon {
    

    Pokemon pikachu = new Pokemon(
    25,
    Map.of("english", "pikachu"),
    List.of("elétrico"),
    Map.of(
        "HP", 45,
        "Attack", 49,
        "Defense", 49,
        "Sp. Attack", 65,
        "Sp. Defense", 65,
        "Speed", 45
    )
);

 
    @Test
    public void testNomePokemon() {
        assertEquals("pikachu", pikachu.getName().get("english"));
    }

  
    @Test
    public void testTipoPokemon() {
        assertEquals("elétrico", pikachu.getType().get(0));
    }

    @Test
    public void testBasePokemon() {
        assertEquals(45, pikachu.getBase().get("HP"));
        assertEquals(49, pikachu.getBase().get("Attack"));
        assertEquals(49, pikachu.getBase().get("Defense"));
        assertEquals(65, pikachu.getBase().get("Sp. Attack"));
        assertEquals(65, pikachu.getBase().get("Sp. Defense"));
        assertEquals(45, pikachu.getBase().get("Speed"));
    }
}