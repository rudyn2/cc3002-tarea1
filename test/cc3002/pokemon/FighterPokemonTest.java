package cc3002.pokemon;

import cc3002.attack.*;
import cc3002.effect.Potion;
import cc3002.energy.FighterEnergy;
import cc3002.energy.WaterEnergy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FighterPokemonTest {

    private Heal heal;
    private ArrayList<IAbility> basicAbilities;

    private FireAttack fireAttack;
    private WaterAttack waterAttack;
    private ElectricAttack electricAttack;
    private FighterAttack fighterAttack;
    private GrassAttack grassAttack;
    private PsychicAttack psychicAttack;

    private FighterAttack supremeFighterAttack;
    private WaterAttack supremeWaterAttack;


    private ArrayList<IAttack> fighterAttacks;
    private ArrayList<IAttack> waterAttacks;

    private BasicFighterPokemon machoke;
    private BasicWaterPokemon squirtle;

    private FighterEnergy fighterEnergy;
    private WaterEnergy waterEnergy;
    private Potion healEffect;

    @BeforeEach
    void setUp() {

        // simple attack creation
        fireAttack = new FireAttack("LLama de fuego", "Fuego azul valyrio", 10, 5);
        waterAttack = new WaterAttack("Bola de agua", "", 10, 4);
        electricAttack = new ElectricAttack("Rayo bélico", "Chamas", 5, 2);
        grassAttack = new GrassAttack("Hiedra venenosa", "Te mata al tocarla", 5, 2);
        psychicAttack = new PsychicAttack("Hipnosis", "Te enloquezco", 10,2);
        fighterAttack = new FighterAttack("Combazo", "Te aturde", 40, 2);

        // special attack creation
        supremeFighterAttack = new FighterAttack("Combo en la cara", "Moreton seguro", 10, 2);
        supremeWaterAttack = new WaterAttack("Tsunami", "", 50, 10);

        // machoke attacks assignation
        fighterAttacks = new ArrayList<>(Arrays.asList(fighterAttack, supremeFighterAttack));
        healEffect = new Potion("Random heal effect");
        heal = new Heal("Heal", "Habilidad sanadora", healEffect);
        basicAbilities = new ArrayList<>();
        basicAbilities.add(heal);
        machoke = new BasicFighterPokemon(100, "Machoke", 1, fighterAttacks, basicAbilities);

        // squirtle attacks assignation
        waterAttacks = new ArrayList<>(Arrays.asList(waterAttack, supremeWaterAttack));
        squirtle = new BasicWaterPokemon(100, "Squirtle", 2, waterAttacks, basicAbilities);

        // energy creation
        fighterEnergy = new FighterEnergy("Energía para guerreros", 40);
        waterEnergy = new WaterEnergy("Energía de agua", 40);


    }

    @Test
    void battleTest(){

        // The fighter pokemon doesnt have energy
        machoke.useAttack(squirtle);
        assertEquals(100, squirtle.getHp());

        // Energy assignation and attack
        fighterEnergy.assignEnergy(machoke);
        machoke.useAttack(squirtle);
        assertEquals(90, squirtle.getHp());
        assertTrue(heal.checkFighterEnergy(machoke));

        machoke.useAttack(squirtle);
        assertEquals(squirtle.getHp(), 80);

        squirtle.selectAttack(1);
        waterEnergy.assignEnergy(squirtle);
        squirtle.useAttack(machoke);
        assertEquals(machoke.getHp(), 50);
        assertFalse(machoke.isDead());
    }

    @Test
    void descriptionTest(){
        assertEquals("Machoke", machoke.getName());
        assertEquals(100, machoke.getHp());
        assertFalse(machoke.isDead());
        assertEquals(fighterAttacks, machoke.getAttacks());
        assertEquals(fighterAttack, machoke.getSelectedAttack());

    }

    @Test
    void selectAttackTest(){
        machoke.selectAttack(1);
        assertEquals(supremeFighterAttack, machoke.getSelectedAttack());
        machoke.selectAttack(0);
        assertEquals(fighterAttack, machoke.getSelectedAttack());
        machoke.selectAttack(-1);
        assertEquals(fighterAttack, machoke.getSelectedAttack());
        machoke.selectAttack(10000);
        assertEquals(fighterAttack, machoke.getSelectedAttack());
    }

    @Test
    void receiveAttacks(){
        fighterAttack.attack(machoke);
        assertEquals(60, machoke.getHp());
        waterAttack.attack(machoke);
        assertEquals(50, machoke.getHp());
        grassAttack.attack(machoke);
        assertEquals(40, machoke.getHp());
        electricAttack.attack(machoke);
        assertEquals(35, machoke.getHp());
        fighterAttack.attack(machoke);
        assertEquals(0, machoke.getHp());
        psychicAttack.attack(machoke);
        assertEquals(0, machoke.getHp());
    }
}