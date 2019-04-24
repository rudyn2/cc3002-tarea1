package cc3002.pokemon;

import cc3002.attack.*;
import cc3002.energy.ElectricEnergy;
import cc3002.energy.WaterEnergy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ElectricPokemonTest {

    private FireAttack fireAttack;
    private WaterAttack waterAttack;
    private ElectricAttack electricAttack;
    private FighterAttack fighterAttack;
    private GrassAttack grassAttack;
    private PsychicAttack psychicAttack;

    private WaterAttack supremeWaterAttack;
    private ElectricAttack supremeElectricAttack;

    private ArrayList<IAttack> electricAttacks;
    private ArrayList<IAttack> waterAttacks;

    private ElectricPokemon pikachu;
    private WaterPokemon squirtle;

    private ElectricEnergy electricEnergy;
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
        supremeElectricAttack = new ElectricAttack("Tormenta de fuego", "", 50, 12);
        supremeWaterAttack = new WaterAttack("Tsunami", "", 50, 10);

        // pikachu attacks assignation
        electricAttacks = new ArrayList<>(Arrays.asList(electricAttack, supremeElectricAttack));
        pikachu = new ElectricPokemon(100, "Pikachu", electricAttacks);

        // squirtle attacks assignation
        waterAttacks = new ArrayList<>(Arrays.asList(waterAttack, supremeWaterAttack));
        squirtle = new WaterPokemon(100, "Squirtle", waterAttacks);

        // energy creation
        electricEnergy = new ElectricEnergy("Energía eléctrica", 40);
        waterEnergy = new WaterEnergy("Energía de agua", 40);


    }

    @Test
    void battleTest(){
        pikachu.attack(squirtle);
        assertEquals(squirtle.getHp(), 100);

        electricEnergy.assignEnergy(pikachu);
        pikachu.attack(squirtle);
        assertEquals(80, squirtle.getHp());

        squirtle.selectAttack(1);
        assertEquals(supremeWaterAttack, squirtle.getSelectedAttack());
        waterEnergy.assignEnergy(squirtle);
        squirtle.attack(pikachu);
        assertEquals(50, pikachu.getHp());
        assertFalse(pikachu.isDead());
    }

    @Test
    void descriptionTest(){
        assertEquals("Pikachu", pikachu.getName());
        assertEquals(100, pikachu.getHp());
        assertFalse(pikachu.isDead());
        assertEquals(electricAttacks, pikachu.getAttacks());
        assertEquals(electricAttack, pikachu.getSelectedAttack());

    }

    @Test
    void selectAttackTest(){
        pikachu.selectAttack(1);
        assertEquals(supremeElectricAttack, pikachu.getSelectedAttack());
        pikachu.selectAttack(0);
        assertEquals(electricAttack, pikachu.getSelectedAttack());
        pikachu.selectAttack(-1);
        assertEquals(electricAttack, pikachu.getSelectedAttack());
        pikachu.selectAttack(10000);
        assertEquals(electricAttack, pikachu.getSelectedAttack());
    }

    @Test
    void receiveAttacks(){
        fireAttack.attack(pikachu);
        assertEquals(90, pikachu.getHp());
        waterAttack.attack(pikachu);
        assertEquals(80, pikachu.getHp());
        grassAttack.attack(pikachu);
        assertEquals(70, pikachu.getHp());
        electricAttack.attack(pikachu);
        assertEquals(60, pikachu.getHp());
        fighterAttack.attack(pikachu);
        assertEquals(40, pikachu.getHp());
        psychicAttack.attack(pikachu);
        assertEquals(30, pikachu.getHp());
    }
}