package cc3002.pokemon;

import cc3002.attack.FireAttack;
import cc3002.attack.IAttack;
import cc3002.attack.WaterAttack;
import cc3002.energy.WaterEnergy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class FirePokemonTest {

    @BeforeEach
    public void setUp() {

        // Create attacks
        FireAttack fireAttack = new FireAttack("1", "", 10, 10);
        WaterAttack waterAttack = new WaterAttack("water", "", 5,2);

        // Create a pokemon with attacks
        ArrayList<IAttack> attacks = new ArrayList<>(Arrays.asList(fireAttack, waterAttack));
        FirePokemon firePokemon = new FirePokemon(20, "Charmander", attacks);

        // Assign energies
        WaterEnergy waterEnergy = new WaterEnergy("WaterEnergy", 10);
        waterEnergy.assignEnergy(firePokemon);
    }

    @Test
    public void attackTest(){


    }
}