package cc3002.pokemon;

import cc3002.attack.*;
import cc3002.effect.Potion;
import cc3002.energy.WaterEnergy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class WaterPokemonTest {

    private Heal heal;
    private ArrayList<IAbility> basicAbilities;

    private FireAttack fireAttack;
    private WaterAttack waterAttack;
    private ElectricAttack electricAttack;
    private FighterAttack fighterAttack;
    private GrassAttack grassAttack;
    private PsychicAttack psychicAttack;

    private WaterAttack supremeWaterAttack;

    private ArrayList<IAttack> waterAttacks;

    private BasicWaterPokemon firstSquirtle;
    private BasicWaterPokemon secondSquirtle;

    private WaterEnergy waterEnergy;
    private Potion healEffect;

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
        supremeWaterAttack = new WaterAttack("Tsunami", "", 50, 10);

        // squirtle attacks assignation
        waterAttacks = new ArrayList<>(Arrays.asList(waterAttack, supremeWaterAttack));
        healEffect = new Potion("Random heal effect");
        heal = new Heal("Heal", "Habilidad sanadora", healEffect);
        basicAbilities = new ArrayList<>();
        basicAbilities.add(heal);
        firstSquirtle = new BasicWaterPokemon(100, "First Squirtle",1, waterAttacks, basicAbilities);
        secondSquirtle = new BasicWaterPokemon(100, "Second Squirtle", 2, waterAttacks, basicAbilities);

        // energy creation
        waterEnergy = new WaterEnergy("Energía de agua", 40);


    }

    @Test
    void battleTest(){
        secondSquirtle.useAttack(firstSquirtle);
        assertEquals(secondSquirtle.getHp(), 100);

        waterEnergy.assignEnergy(firstSquirtle);
        firstSquirtle.useAttack(secondSquirtle);
        assertEquals(secondSquirtle.getHp(), 90);

        secondSquirtle.selectAttack(1);
        assertEquals(supremeWaterAttack, secondSquirtle.getSelectedAttack());
        waterEnergy.assignEnergy(secondSquirtle);
        secondSquirtle.useAttack(firstSquirtle);
        assertEquals(firstSquirtle.getHp(), 50);
        assertFalse(firstSquirtle.isDead());
    }

    @Test
    void descriptionTest(){
        assertEquals("First Squirtle", firstSquirtle.getName());
        assertEquals(100, firstSquirtle.getHp());
        assertFalse(firstSquirtle.isDead());
        assertEquals(waterAttacks, firstSquirtle.getAttacks());
        assertEquals(waterAttack, firstSquirtle.getSelectedAttack());

    }

    @Test
    void selectAttackTest(){
        firstSquirtle.selectAttack(1);
        assertEquals(supremeWaterAttack, firstSquirtle.getSelectedAttack());
        firstSquirtle.selectAttack(0);
        assertEquals(waterAttack, firstSquirtle.getSelectedAttack());
        firstSquirtle.selectAttack(-1);
        assertEquals(waterAttack, firstSquirtle.getSelectedAttack());
        firstSquirtle.selectAttack(10000);
        assertEquals(waterAttack, firstSquirtle.getSelectedAttack());
    }

    @Test
    void receiveAttacks(){
        fireAttack.attack(firstSquirtle);
        assertEquals(90, firstSquirtle.getHp());
        waterAttack.attack(firstSquirtle);
        assertEquals(80, firstSquirtle.getHp());
        grassAttack.attack(firstSquirtle);
        assertEquals(60, firstSquirtle.getHp());
        electricAttack.attack(firstSquirtle);
        assertEquals(40, firstSquirtle.getHp());
        fighterAttack.attack(firstSquirtle);
        assertEquals(40, firstSquirtle.getHp());
        psychicAttack.attack(firstSquirtle);
        assertEquals(30, firstSquirtle.getHp());
    }

}