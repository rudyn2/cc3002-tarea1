package cc3002.pokemon;

import cc3002.attack.*;
import cc3002.energy.PsychicEnergy;
import cc3002.energy.WaterEnergy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PsychicPokemonTest {

    private FireAttack fireAttack;
    private WaterAttack waterAttack;
    private ElectricAttack electricAttack;
    private FighterAttack fighterAttack;
    private GrassAttack grassAttack;
    private PsychicAttack psychicAttack;

    private WaterAttack supremeWaterAttack;
    private PsychicAttack supremePsychicAttack;


    private ArrayList<IAttack> waterAttacks;
    private ArrayList<IAttack> psychicAttacks;

    private PsychicPokemon mewtwo;
    private WaterPokemon squirtle;

    private PsychicEnergy psychicEnergy;
    private WaterEnergy waterEnergy;

    @BeforeEach
    void setUp() {

        // simple attack creation
        fireAttack = new FireAttack("LLama de fuego", "Fuego azul valyrio", 10, 5);
        waterAttack = new WaterAttack("Bola de agua", "", 10, 4);
        electricAttack = new ElectricAttack("Rayo bélico", "Chamas", 10, 2);
        grassAttack = new GrassAttack("Hiedra venenosa", "Te mata al tocarla", 10, 2);
        psychicAttack = new PsychicAttack("Hipnosis", "Te enloquezco", 10,2);
        fighterAttack = new FighterAttack("Combazo", "Te aturde", 10, 2);

        // special attack creation
        supremePsychicAttack = new PsychicAttack("Hipnosis suculenta", "", 50, 12);
        supremeWaterAttack = new WaterAttack("Tsunami", "", 50, 10);

        // mewtwo attacks assignation
        psychicAttacks = new ArrayList<>(Arrays.asList(psychicAttack, supremePsychicAttack));
        mewtwo = new PsychicPokemon(100, "Mewtwo", 1, psychicAttacks);

        // squirtle attacks assignation
        waterAttacks = new ArrayList<>(Arrays.asList(waterAttack, supremeWaterAttack));
        squirtle = new WaterPokemon(100, "Squirtle", 2, waterAttacks);

        // energy creation
        psychicEnergy = new PsychicEnergy("Energía mental", 40);
        waterEnergy = new WaterEnergy("Energía de agua", 40);


    }

    @Test
    void battleTest(){
        mewtwo.attack(squirtle);
        assertEquals(squirtle.getHp(), 100);

        psychicEnergy.assignEnergy(mewtwo);
        mewtwo.attack(squirtle);
        assertEquals(squirtle.getHp(), 90);

        squirtle.selectAttack(1);
        assertEquals(supremeWaterAttack, squirtle.getSelectedAttack());
        waterEnergy.assignEnergy(squirtle);
        squirtle.attack(mewtwo);
        assertEquals(mewtwo.getHp(), 50);
        assertFalse(mewtwo.isDead());
    }

    @Test
    void descriptionTest(){
        assertEquals("Mewtwo", mewtwo.getName());
        assertEquals(100, mewtwo.getHp());
        assertFalse(mewtwo.isDead());
        assertEquals(psychicAttacks, mewtwo.getAttacks());
        assertEquals(psychicAttack, mewtwo.getSelectedAttack());

    }

    @Test
    void selectAttackTest(){
        mewtwo.selectAttack(1);
        assertEquals(supremePsychicAttack, mewtwo.getSelectedAttack());
        mewtwo.selectAttack(0);
        assertEquals(psychicAttack, mewtwo.getSelectedAttack());
        mewtwo.selectAttack(-1);
        assertEquals(psychicAttack, mewtwo.getSelectedAttack());
        mewtwo.selectAttack(10000);
        assertEquals(psychicAttack, mewtwo.getSelectedAttack());
    }

    @Test
    void receiveAttacks(){
        fireAttack.attack(mewtwo);
        assertEquals(90, mewtwo.getHp());
        waterAttack.attack(mewtwo);
        assertEquals(80, mewtwo.getHp());
        grassAttack.attack(mewtwo);
        assertEquals(70, mewtwo.getHp());
        electricAttack.attack(mewtwo);
        assertEquals(60, mewtwo.getHp());
        fighterAttack.attack(mewtwo);
        assertEquals(60, mewtwo.getHp());
        psychicAttack.attack(mewtwo);
        assertEquals(40, mewtwo.getHp());
    }

}