package cc3002.pokemon;

import cc3002.attack.FireAttack;
import cc3002.attack.IAttack;
import cc3002.attack.WaterAttack;
import cc3002.energy.FireEnergy;
import cc3002.energy.WaterEnergy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FirePokemonTest {
    private FireAttack fireAttack;
    private FireAttack supremeFireAttack;
    private WaterAttack waterAttack;
    private WaterAttack supremeWaterAttack;
    private ArrayList<IAttack> fire_attacks;
    private ArrayList<IAttack> water_attacks;

    private FirePokemon charmander;
    private WaterPokemon squirtle;

    private FireEnergy fireEnergy;
    private WaterEnergy waterEnergy;

    @BeforeEach
    void setUp() {

        // fire attacks creation
        fireAttack = new FireAttack("LLama de fuego", "", 10, 5);
        supremeFireAttack = new FireAttack("Tormenta de fuego", "", 50, 12);

        // water attacks creation
        waterAttack = new WaterAttack("Bola de agua", "", 10, 4);
        supremeWaterAttack = new WaterAttack("Tsunami", "", 50, 10);

        // charmander attacks assignation
        fire_attacks = new ArrayList<>(Arrays.asList(fireAttack, supremeFireAttack));
        charmander = new FirePokemon(100, "Charmander", fire_attacks);

        // squirtle attacks assignation
        water_attacks = new ArrayList<>(Arrays.asList(waterAttack, supremeWaterAttack));
        squirtle = new WaterPokemon(100, "Squirtle", water_attacks);

        // energy creation
        fireEnergy = new FireEnergy("Energía de fuego", 40);
        waterEnergy = new WaterEnergy("Energía de agua", 40);


    }

    @Test
    void simpleAttack(){
        charmander.selectAttack(0);
        charmander.attack(squirtle);
    }

    @Test
    void epicBattleTest(){
        charmander.selectAttack(0);
        charmander.attack(squirtle);
        assertEquals(squirtle.getHp(), 100);

        fireEnergy.assignEnergy(charmander);
        charmander.attack(squirtle);
        assertEquals(squirtle.getHp(), 90);

        charmander.attack(squirtle);
        assertEquals(squirtle.getHp(), 80);

        squirtle.selectAttack(1);
        assertEquals(supremeWaterAttack, squirtle.getSelectedAttack());
        waterEnergy.assignEnergy(squirtle);
        squirtle.attack(charmander);
        assertEquals(charmander.getHp(), 0 );
        assertTrue(charmander.isDead());

    }



}