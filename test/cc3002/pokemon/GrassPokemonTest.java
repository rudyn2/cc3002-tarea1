package cc3002.pokemon;

import cc3002.attack.*;
import cc3002.effect.Potion;
import cc3002.energy.GrassEnergy;
import cc3002.energy.WaterEnergy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GrassPokemonTest {

    private Heal heal;
    private ArrayList<IAbility> basicAbilities;

    private FireAttack fireAttack;
    private WaterAttack waterAttack;
    private ElectricAttack electricAttack;
    private FighterAttack fighterAttack;
    private GrassAttack grassAttack;
    private PsychicAttack psychicAttack;

    private WaterAttack supremeWaterAttack;
    private GrassAttack supremeGrassAttack;


    private ArrayList<IAttack> grassAttacks;
    private ArrayList<IAttack> waterAttacks;

    private BasicGrassPokemon bulbasaur;
    private BasicWaterPokemon squirtle;

    private GrassEnergy grassEnergy;
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
        supremeGrassAttack = new GrassAttack("Tormenta de fuego", "", 50, 12);
        supremeWaterAttack = new WaterAttack("Tsunami", "", 50, 10);

        // bulbasaur attacks assignation
        grassAttacks = new ArrayList<>(Arrays.asList(grassAttack, supremeGrassAttack));
        healEffect = new Potion("Random heal effect");
        heal = new Heal("Heal", "Habilidad sanadora", healEffect);
        basicAbilities = new ArrayList<>();
        basicAbilities.add(heal);
        bulbasaur = new BasicGrassPokemon(100, "Bulbasaur", 1, grassAttacks, basicAbilities);

        // squirtle attacks assignation
        waterAttacks = new ArrayList<>(Arrays.asList(waterAttack, supremeWaterAttack));
        squirtle = new BasicWaterPokemon(100, "Squirtle", 2, waterAttacks, basicAbilities);

        // energy creation
        grassEnergy = new GrassEnergy("Energía de planta", 40);
        waterEnergy = new WaterEnergy("Energía de agua", 40);


    }

    @Test
    void battleTest(){
        bulbasaur.useAttack(squirtle);
        assertEquals(squirtle.getHp(), 100);

        grassEnergy.assignEnergy(bulbasaur);
        bulbasaur.useAttack(squirtle);
        assertEquals(squirtle.getHp(), 80);
        assertTrue(heal.checkGrassEnergy(bulbasaur));

        squirtle.selectAttack(1);
        assertEquals(supremeWaterAttack, squirtle.getSelectedAttack());
        waterEnergy.assignEnergy(squirtle);
        squirtle.useAttack(bulbasaur);
        assertEquals(bulbasaur.getHp(), 80);
        assertFalse(bulbasaur.isDead());
    }

    @Test
    void descriptionTest(){
        assertEquals("Bulbasaur", bulbasaur.getName());
        assertEquals(100, bulbasaur.getHp());
        assertFalse(bulbasaur.isDead());
        assertEquals(grassAttacks, bulbasaur.getAttacks());
        assertEquals(grassAttack, bulbasaur.getSelectedAttack());

    }

    @Test
    void selectAttackTest(){
        bulbasaur.selectAttack(1);
        assertEquals(supremeGrassAttack, bulbasaur.getSelectedAttack());
        bulbasaur.selectAttack(0);
        assertEquals(grassAttack, bulbasaur.getSelectedAttack());
        bulbasaur.selectAttack(-1);
        assertEquals(grassAttack, bulbasaur.getSelectedAttack());
        bulbasaur.selectAttack(10000);
        assertEquals(grassAttack, bulbasaur.getSelectedAttack());
    }

    @Test
    void receiveAttacks(){
        fireAttack.attack(bulbasaur);
        assertEquals(80, bulbasaur.getHp());
        waterAttack.attack(bulbasaur);
        assertEquals(80, bulbasaur.getHp());
        grassAttack.attack(bulbasaur);
        assertEquals(70, bulbasaur.getHp());
        electricAttack.attack(bulbasaur);
        assertEquals(60, bulbasaur.getHp());
        fighterAttack.attack(bulbasaur);
        assertEquals(50, bulbasaur.getHp());
        psychicAttack.attack(bulbasaur);
        assertEquals(40, bulbasaur.getHp());
    }


}