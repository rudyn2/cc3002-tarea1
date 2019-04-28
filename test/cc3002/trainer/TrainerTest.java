package cc3002.trainer;

import cc3002.attack.*;
import cc3002.bench.Bench;
import cc3002.card.ICard;
import cc3002.energy.FireEnergy;
import cc3002.energy.GrassEnergy;
import cc3002.energy.PsychicEnergy;
import cc3002.energy.WaterEnergy;
import cc3002.pokemon.FirePokemon;
import cc3002.pokemon.GrassPokemon;
import cc3002.pokemon.PsychicPokemon;
import cc3002.pokemon.WaterPokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {

    private FireAttack fireAttack;
    private FireAttack supremeFireAttack;

    private PsychicAttack psychicAttack;
    private PsychicAttack supremePsychicAttack;

    private GrassAttack grassAttack;
    private GrassAttack supremeGrassAttack;

    private WaterAttack waterAttack;
    private WaterAttack supremeWaterAttack;


    private ArrayList<IAttack> fireAttacks;
    private ArrayList<IAttack> waterAttacks;
    private ArrayList<IAttack> psychicAttacks;
    private ArrayList<IAttack> grassAttacks;

    private FirePokemon charmander;
    private WaterPokemon squirtle;
    private PsychicPokemon mew;
    private GrassPokemon bayleef;

    private FireEnergy fireEnergy;
    private WaterEnergy waterEnergy;
    private PsychicEnergy psychicEnergy;
    private GrassEnergy grassEnergy;

    private ArrayList<ICard> hand1;
    private ArrayList<ICard> hand2;

    private Trainer ash;
    private Trainer ash2;
    private Trainer harry;



    @BeforeEach
    void setUp() {
        fireAttack = new FireAttack("LLama de fuego", "Fuego azul valyrio", 10, 5);
        supremeFireAttack = new FireAttack("Tormenta de fuego", "", 50, 12);
        waterAttack = new WaterAttack("Bola de agua", "", 10, 4);
        supremeWaterAttack = new WaterAttack("Tsunami", "", 50, 10);

        psychicAttack = new PsychicAttack("Engaño", "Te aturde", 10, 5);
        supremePsychicAttack = new PsychicAttack("Super engaño", "Te super aturde", 50,10);
        grassAttack = new GrassAttack("Rama en la cara", "Muchas hojas", 10, 5);
        supremeGrassAttack = new GrassAttack("Ramazo", "Super hoja", 50, 10);

        // Creation of charmander
        fireAttacks = new ArrayList<>(Arrays.asList(fireAttack, supremeFireAttack));
        charmander = new FirePokemon(100, "Charmander", 1, fireAttacks);

        // Creation of squirtle
        waterAttacks = new ArrayList<>(Arrays.asList(waterAttack, supremeWaterAttack));
        squirtle = new WaterPokemon(100, "Squirtle", 2, waterAttacks);

        // Creation of mew
        psychicAttacks = new ArrayList<>(Arrays.asList(psychicAttack, supremePsychicAttack));
        mew = new PsychicPokemon(100, "Mew", 3, psychicAttacks);

        // Creation of Bayleef
        grassAttacks = new ArrayList<>(Arrays.asList(grassAttack, supremeGrassAttack));
        bayleef = new GrassPokemon(100, "Bayleef", 4, grassAttacks);


        fireEnergy = new FireEnergy("Energía de fuego", 40);
        waterEnergy = new WaterEnergy("Energía de agua", 40);
        psychicEnergy = new PsychicEnergy("Energía psiquica", 40);
        grassEnergy = new GrassEnergy("Energía de hoja", 40);

        // Creation of Ash
        hand1 = new ArrayList<>(Arrays.asList(charmander, squirtle, fireEnergy, waterEnergy));
        ash = new Trainer("Ash", hand1);
        ash2 = new Trainer("Ash2", hand1, mew, new Bench());

        // Creation of secondary (never used) Ash with initial active Pokemon. Just to test the constructors.

        // Creation of harry
        hand2 = new ArrayList<>(Arrays.asList(mew, bayleef, psychicEnergy, grassEnergy));
        harry = new Trainer("Harry", hand2);

    }

    @Test
    void testTrainerInfo() {
        assertEquals("Ash", ash.getName());
        assertNull(ash.getActivePokemon());

        // It must raise an error because Ash doesn't have an active pokemon neither someone in the bench.
        boolean t;
        try {
            ash.isOver();
            t = true;
        } catch (NullPointerException e) {
            t = false;
        }
        assertTrue(t);
        assertEquals(hand1, ash.getHand());

    }

    @Test
    void testTrainerInitScenario(){
        // Adds charmander to the bench
        ash.playCard(-1);
        ash.playCard(0);
        assertFalse(ash.isOver());
        // Put squirtle as active pokemon
        ash.changeActivePokemonFromTheHand(0);
        assertEquals(squirtle, ash.getActivePokemon());
        assertEquals(hand1, ash.getHand());
        // Change attack of active pokemon
        ash.selectAttackOfActivePokemon(1);
        assertEquals(supremeWaterAttack, ash.getActivePokemon().getSelectedAttack());
    }

    @Test
    void trainersBattle(){
        ash.changeActivePokemonFromTheHand(0);
        harry.changeActivePokemonFromTheHand(0);

        assertEquals(charmander, ash.getActivePokemon());
        assertEquals(mew, harry.getActivePokemon());

        // Ash intenta atacar pero su pokemon no tiene energía -> no produce daño
        ash.attack(harry);
        assertEquals(100, harry.getActivePokemon().getHp());

        // Ash baja squirtle a la banca
        ash.playCard(0);
        // Ash asigna energía a charmander
        ash.playCard(0);
        // Ash ve sus opciones y ataca al pokemon de harry
        ash.visualizeHand();
        ash.attack(harry);
        assertEquals(90, harry.getActivePokemon().getHp());

        // Harry asigna energía a su pokemon y ataca
        harry.playCard(1);
        harry.attack(ash);
        assertEquals(90, ash.getActivePokemon().getHp());

        // Ash ataca 9 veces y mata el pokemon al pokemon de harry
        harry.attack(ash);
        harry.attack(ash);
        harry.attack(ash);
        harry.attack(ash);
        harry.attack(ash);
        harry.attack(ash);
        harry.attack(ash);
        harry.attack(ash);
        assertEquals(10, ash.getActivePokemon().getHp());

        // Harry mata al charmander de Ash y se reemplaza por su squirtle
        harry.attack(ash);
        assertEquals(squirtle, ash.getActivePokemon());



    }
}