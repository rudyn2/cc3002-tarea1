package cc3002.bench;

import cc3002.attack.*;
import cc3002.pokemon.ElectricPokemon;
import cc3002.pokemon.FirePokemon;
import cc3002.pokemon.GrassPokemon;
import cc3002.pokemon.PsychicPokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BenchTest {
    private Bench bench;

    private FireAttack fireAttack;
    private FireAttack supremeFireAttack;

    private ElectricAttack electricAttack;
    private ElectricAttack supremeElectricAttack;

    private GrassAttack grassAttack;
    private GrassAttack supremeGrassAttack;

    private PsychicAttack psychicAttack;
    private PsychicAttack supremePsychicAttack;


    private ArrayList<IAttack> fireAttacks;
    private ArrayList<IAttack> electricAttacks;
    private ArrayList<IAttack> psychicAttacks;
    private ArrayList<IAttack> grassAttacks;

    private FirePokemon charmander;
    private ElectricPokemon pikachu;
    private PsychicPokemon mew;
    private GrassPokemon bayleef;
    @BeforeEach
    void setUp() {
        bench = new Bench();

        fireAttack = new FireAttack("LLama de fuego", "Fuego azul valyrio", 10, 5);
        supremeFireAttack = new FireAttack("Tormenta de fuego", "", 50, 12);
        psychicAttack = new PsychicAttack("Engaño", "Te aturde", 10, 5);
        supremePsychicAttack = new PsychicAttack("Super engaño", "Te super aturde", 50,10);

        electricAttack = new ElectricAttack("Rayo", "Te electrocuta", 10, 5);
        supremeElectricAttack = new ElectricAttack("Rasho a 100 kV", "Te quema", 50,10);
        grassAttack = new GrassAttack("Rama en la cara", "Muchas hojas", 10, 5);
        supremeGrassAttack = new GrassAttack("Ramazo", "Super hoja", 50, 10);

        // Creation of charmander
        fireAttacks = new ArrayList<>(Arrays.asList(fireAttack, supremeFireAttack));
        charmander = new FirePokemon(100, "Charmander", 1, fireAttacks);

        // Creation of squirtle
        electricAttacks = new ArrayList<>(Arrays.asList(electricAttack, supremeElectricAttack));
        pikachu = new ElectricPokemon(100, "Pikachu", 2, electricAttacks);

        // Creation of mew
        psychicAttacks = new ArrayList<>(Arrays.asList(psychicAttack, supremePsychicAttack));
        mew = new PsychicPokemon(100, "Mew", 3, psychicAttacks);

        // Creation of Bayleef
        grassAttacks = new ArrayList<>(Arrays.asList(grassAttack, supremeGrassAttack));
        bayleef = new GrassPokemon(100, "Bayleef", 4, grassAttacks);
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
        bench.add(pikachu);
        bench.add(mew);
        assertEquals(mew, bench.pop());
        bench.add(mew);
        bench.add(bayleef);
        // This element is deliberately added in order to reduce pokemon creations.
        bench.add(pikachu);
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