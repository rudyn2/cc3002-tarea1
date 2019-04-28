package cc3002.pokemon;

import cc3002.attack.*;
import cc3002.energy.FireEnergy;
import cc3002.energy.WaterEnergy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FirePokemonTest {
    private FireAttack fireAttack;
    private WaterAttack waterAttack;
    private ElectricAttack electricAttack;
    private FighterAttack fighterAttack;
    private GrassAttack grassAttack;
    private PsychicAttack psychicAttack;

    private WaterAttack supremeWaterAttack;
    private FireAttack supremeFireAttack;


    private ArrayList<IAttack> fireAttacks;
    private ArrayList<IAttack> waterAttacks;

    private FirePokemon charmander;
    private WaterPokemon squirtle;

    private FireEnergy fireEnergy;
    private WaterEnergy waterEnergy;

    @BeforeEach
    void setUp() {

        // simple attack creation
        fireAttack = new FireAttack("LLama de fuego", "Fuego azul valyrio", 10, 5);
        waterAttack = new WaterAttack("Bola de agua", "", 10, 4);
        electricAttack = new ElectricAttack("Rayo bélico", "Chamas", 5, 2);
        grassAttack = new GrassAttack("Hiedra venenosa", "Te mata al tocarla", 5, 2);
        psychicAttack = new PsychicAttack("Hipnosis", "Te enloquezco", 10,2);
        fighterAttack = new FighterAttack("Combazo", "Te aturde", 10, 2);

        // special attack creation
        supremeFireAttack = new FireAttack("Tormenta de fuego", "", 50, 12);
        supremeWaterAttack = new WaterAttack("Tsunami", "", 50, 10);

        // charmander attacks assignation
        fireAttacks = new ArrayList<>(Arrays.asList(fireAttack, supremeFireAttack));
        charmander = new FirePokemon(100, "Charmander", 1, fireAttacks);

        // squirtle attacks assignation
        waterAttacks = new ArrayList<>(Arrays.asList(waterAttack, supremeWaterAttack));
        squirtle = new WaterPokemon(100, "Squirtle", 2, waterAttacks);

        // energy creation
        fireEnergy = new FireEnergy("Energía de fuego", 40);
        waterEnergy = new WaterEnergy("Energía de agua", 40);


    }

    @Test
    void battleTest(){
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

    @Test
    void descriptionTest(){
        assertEquals("Charmander", charmander.getName());
        assertEquals(100, charmander.getHp());
        assertFalse(charmander.isDead());
        assertEquals(fireAttacks, charmander.getAttacks());
        assertEquals(fireAttack, charmander.getSelectedAttack());

    }

    @Test
    void selectAttackTest(){
        charmander.selectAttack(1);
        assertEquals(supremeFireAttack, charmander.getSelectedAttack());
        charmander.selectAttack(0);
        assertEquals(fireAttack, charmander.getSelectedAttack());
        charmander.selectAttack(-1);
        assertEquals(fireAttack, charmander.getSelectedAttack());
        charmander.selectAttack(10000);
        assertEquals(fireAttack, charmander.getSelectedAttack());
    }

    @Test
    void receiveAttacks(){
        fireAttack.attack(charmander);
        assertEquals(90, charmander.getHp());
        waterAttack.attack(charmander);
        assertEquals(70, charmander.getHp());
        grassAttack.attack(charmander);
        assertEquals(65, charmander.getHp());
        electricAttack.attack(charmander);
        assertEquals(60, charmander.getHp());
        fighterAttack.attack(charmander);
        assertEquals(50, charmander.getHp());
        psychicAttack.attack(charmander);
        assertEquals(40, charmander.getHp());
    }


}