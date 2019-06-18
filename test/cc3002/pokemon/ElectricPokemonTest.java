package cc3002.pokemon;

import cc3002.attack.*;
import cc3002.effect.Potion;
import cc3002.energy.ElectricEnergy;
import cc3002.energy.WaterEnergy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ElectricPokemonTest {

    private Heal heal;
    private ArrayList<IAbility> basicAbilities;

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

    private ElectricShock electricShock;
    private BasicElectricPokemon pikachu;
    private BasicWaterPokemon squirtle;

    private ElectricEnergy electricEnergy;
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
        supremeElectricAttack = new ElectricAttack("Tormenta de fuego", "", 50, 12);
        supremeWaterAttack = new WaterAttack("Tsunami", "", 50, 10);
        electricShock = new ElectricShock("Brutal shock", "Lo frie", 10, 3);

        // pikachu attacks assignation
        electricAttacks = new ArrayList<>(Arrays.asList(electricAttack, supremeElectricAttack, electricShock));
        healEffect = new Potion("Random heal effect");
        heal = new Heal("Heal", "Habilidad sanadora", healEffect);
        basicAbilities = new ArrayList<>();
        basicAbilities.add(heal);
        pikachu = new BasicElectricPokemon(100, "Pikachu", 1, electricAttacks, basicAbilities);

        // squirtle attacks assignation
        waterAttacks = new ArrayList<>(Arrays.asList(waterAttack, supremeWaterAttack));
        squirtle = new BasicWaterPokemon(100, "Squirtle", 2, waterAttacks, basicAbilities);

        // energy creation
        electricEnergy = new ElectricEnergy("Energía eléctrica", 40);
        waterEnergy = new WaterEnergy("Energía de agua", 40);


    }

    @Test
    void battleTest(){
        pikachu.useAttack(squirtle);
        assertEquals(squirtle.getHp(), 100);

        electricEnergy.assignEnergy(pikachu);
        pikachu.useAttack(squirtle);

        // Here pikachu uses Electric Shock
        pikachu.selectAttack(2);
        pikachu.useAttack(squirtle);
        assertTrue(heal.checkElectricEnergy(pikachu));

        // Pikachu has the heal ability
        assertEquals(1, pikachu.getAbilities().size());


        squirtle.selectAttack(1);
        assertEquals(supremeWaterAttack, squirtle.getSelectedAttack());
        waterEnergy.assignEnergy(squirtle);
        squirtle.useAttack(pikachu);
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