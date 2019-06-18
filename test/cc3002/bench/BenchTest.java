package cc3002.bench;

import cc3002.attack.*;
import cc3002.effect.Potion;
import cc3002.pokemon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BenchTest {
    private Bench bench;

    private Heal heal;

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

    private ArrayList<IAbility> basicAbilities;

    private AbstractFirePokemon charmander;
    private AbstractWaterPokemon squirtle;
    private AbstractPsychicPokemon mew;
    private AbstractGrassPokemon bayleef;
    private Potion healEffect;

    @BeforeEach
    void setUp() {
        bench = new Bench();

        fireAttack = new FireAttack("LLama de fuego", "Fuego azul valyrio", 10, 5);
        supremeFireAttack = new FireAttack("Tormenta de fuego", "", 50, 12);
        waterAttack = new WaterAttack("Bola de agua", "", 10, 4);
        supremeWaterAttack = new WaterAttack("Tsunami", "", 50, 10);

        psychicAttack = new PsychicAttack("Engaño", "Te aturde", 10, 5);
        supremePsychicAttack = new PsychicAttack("Super engaño", "Te super aturde", 50, 10);
        grassAttack = new GrassAttack("Rama en la cara", "Muchas hojas", 10, 5);
        supremeGrassAttack = new GrassAttack("Ramazo", "Super hoja", 50, 10);

        healEffect = new Potion("Random heal effect");
        heal = new Heal("Heal", "Habilidad sanadora", healEffect);


        // Creation of charmander
        fireAttacks = new ArrayList<>(Arrays.asList(fireAttack, supremeFireAttack));
        charmander = new BasicFirePokemon(100, "Charmander", 1, fireAttacks, basicAbilities);

        // Creation of squirtle
        waterAttacks = new ArrayList<>(Arrays.asList(waterAttack, supremeWaterAttack));
        squirtle = new BasicWaterPokemon(100, "Squirtle", 2, waterAttacks, basicAbilities);

        // Creation of mew
        psychicAttacks = new ArrayList<>(Arrays.asList(psychicAttack, supremePsychicAttack));
        mew = new BasicPsychicPokemon(100, "Mew", 3, psychicAttacks, basicAbilities);

        // Creation of Bayleef
        grassAttacks = new ArrayList<>(Arrays.asList(grassAttack, supremeGrassAttack));
        bayleef = new BasicGrassPokemon(100, "Bayleef", 4, grassAttacks, basicAbilities);

    }

    /**
     * This test checks the general behavior of the bench class.
     */
    @Test
    void testBench(){
        bench.visualize();
        assertTrue(bench.isEmpty());
        bench.add(charmander);
        assertEquals(1, bench.count());
        bench.add(squirtle);
        bench.add(mew);
        assertEquals(mew, bench.pop());
        bench.add(mew);
        bench.add(bayleef);
        // This element is deliberately added in order to reduce pokemon creations.
        bench.add(charmander);
        assertTrue(bench.isFull());
        bench.visualize();

        // If the bench is full the pokemon isn't added to the bench.
        bench.add(bayleef);
        assertTrue(bench.isFull());

        // This check an invalid option
        assertNull(bench.replace(-1, charmander));

        bench.replace(4, mew);
        assertTrue(bench.isFull());

        // It doesn't crash for invalid inputs.
        bench.remove(1000);
        bench.remove(4);
        assertEquals(4, bench.count());


    }

    /**
     * The behavior expected is to raise ArrayIndexOutOfBoundsException. This error
     * cannot be made due to user interaction because, the limits of the checked is
     * before the user interactions and the pop method is for internal use.
     */
    @Test
    void testEmptyPop(){
        boolean t = false;
        try{
            bench.pop();
        } catch (ArrayIndexOutOfBoundsException e){
            t = true;
        }
        assertTrue(t);
    }

}