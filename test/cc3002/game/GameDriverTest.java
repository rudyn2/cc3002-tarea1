package cc3002.game;

import cc3002.attack.*;
import cc3002.card.ICard;
import cc3002.deck.Deck;
import cc3002.effect.InstantEffect;
import cc3002.effect.LuckyStadium;
import cc3002.effect.Potion;
import cc3002.effect.ProfessorJuniper;
import cc3002.energy.FireEnergy;
import cc3002.energy.GrassEnergy;
import cc3002.energy.PsychicEnergy;
import cc3002.energy.WaterEnergy;
import cc3002.pokemon.*;
import cc3002.trainer.Trainer;
import cc3002.trainercard.InstantObject;
import cc3002.trainercard.Stadium;
import cc3002.trainercard.Support;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GameDriverTest {

    private Heal heal;
    private ArrayList<IAbility> basicAbilities;

    private LuckyStadium luckyStadiumEffect;
    private Potion potionEffect;
    private Stadium stadiumCard;
    private InstantObject instantObject;

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

    private BasicFirePokemon charmander;
    private BasicWaterPokemon squirtle;
    private BasicPsychicPokemon mew;
    private BasicGrassPokemon bayleef;

    private S1FirePokemon s1charmander;

    private FireEnergy fireEnergy;
    private WaterEnergy waterEnergy;
    private PsychicEnergy psychicEnergy;
    private GrassEnergy grassEnergy;

    private ArrayList<ICard> hand1;
    private ArrayList<ICard> hand2;

    private Support professor;
    private InstantEffect professorEffect;
    private InstantEffect healEffect;

    private Trainer ash;
    private Deck ashDeck;
    private Trainer harry;
    private Deck harryDeck;

    private GameDriver game;


    @BeforeEach
    void setUp() {
        fireAttack = new FireAttack("LLama de fuego", "Fuego azul valyrio", 10, 5);
        supremeFireAttack = new FireAttack("Tormenta de fuego", "", 50, 12);
        waterAttack = new WaterAttack("Bola de agua", "", 10, 4);
        supremeWaterAttack = new WaterAttack("Tsunami", "", 50, 10);

        psychicAttack = new PsychicAttack("Engaño", "Te aturde", 10, 5);
        supremePsychicAttack = new PsychicAttack("Super engaño", "Te super aturde", 50, 10);
        grassAttack = new GrassAttack("Rama en la cara", "Muchas hojas", 10, 5);
        supremeGrassAttack = new GrassAttack("Ramazo", "Super hoja", 50, 10);

        professorEffect = new ProfessorJuniper("Efecto del profesor Juniper");
        professor = new Support("Profesor", professorEffect);

        healEffect = new Potion("Random heal effect");
        heal = new Heal("Heal", "Habilidad sanadora", healEffect);
        basicAbilities = new ArrayList<>();
        basicAbilities.add(heal);


        // Creation of charmander
        fireAttacks = new ArrayList<>(Arrays.asList(fireAttack, supremeFireAttack));
        charmander = new BasicFirePokemon(100, "Charmander", 1, fireAttacks, basicAbilities);
        s1charmander = new S1FirePokemon(120, "CharmanderS2", 1, fireAttacks, basicAbilities);

        // Creation of squirtle
        waterAttacks = new ArrayList<>(Arrays.asList(waterAttack, supremeWaterAttack));
        squirtle = new BasicWaterPokemon(100, "Squirtle", 2, waterAttacks, basicAbilities);

        // Creation of mew
        psychicAttacks = new ArrayList<>(Arrays.asList(psychicAttack, supremePsychicAttack));
        mew = new BasicPsychicPokemon(100, "Mew", 3, psychicAttacks, basicAbilities);

        // Creation of Bayleef
        grassAttacks = new ArrayList<>(Arrays.asList(grassAttack, supremeGrassAttack));
        bayleef = new BasicGrassPokemon(100, "Bayleef", 4, grassAttacks, basicAbilities);


        fireEnergy = new FireEnergy("Energía de fuego", 40);
        waterEnergy = new WaterEnergy("Energía de agua", 40);
        psychicEnergy = new PsychicEnergy("Energía psiquica", 40);
        grassEnergy = new GrassEnergy("Energía de hoja", 40);

        // Creation of trainer cards
        potionEffect = new Potion("Poción sanadora");
        luckyStadiumEffect = new LuckyStadium("Estadio de la suerte");

        stadiumCard = new Stadium("Lucky Stadium", luckyStadiumEffect);
        instantObject = new InstantObject("Objeto de poción", potionEffect);

        ashDeck = new Deck(new ArrayList<>(Arrays.asList(charmander, squirtle, fireEnergy, waterEnergy, s1charmander)));
        ashDeck.push(stadiumCard);
        ashDeck.push(instantObject);
        ash = new Trainer("Ash", ashDeck);

        harryDeck = new Deck(new ArrayList<>(Arrays.asList(bayleef, mew, psychicEnergy, grassEnergy, professor)));
        harry = new Trainer("Harry", harryDeck);

        game = new GameDriver(ash, harry);
    }

    @Test
    void trainerHandlingTest() {
        assertEquals(ash, game.getActiveTrainer());

        game.startTurn();
        assertEquals("Ash", ash.getName());
        ash.drawCard();
        ash.drawCard();
        ash.drawCard();
        ash.drawCard();
        ash.drawCard();

        game.watchCards(ash);

        // Selects charmander as active pokemon
        ash.changeActivePokemonFromTheHand(5);
        ash.selectAttackOfActivePokemon(0);
        assertEquals(squirtle, ash.getActivePokemon());
        squirtle.selectAbility(0);
        assertEquals(heal, squirtle.getSelectedAbility());
        assertEquals("Heal", heal.getName());
        // We check that effectively the heal doesnt require energies
        assertTrue(heal.checkWaterEnergy(squirtle));
        squirtle.makeDamage(10);
        assertEquals(90, squirtle.getHp());
        game.activateAbility();
        //game.watchCards(ash);
        game.finishTurn();
        // Squirtle has been healed
        assertEquals(100, squirtle.getHp());

        // Testing the change of turn
        assertEquals(ash, game.getInactiveTrainer());
        assertEquals(harry, game.getActiveTrainer());

        // Next Turn
        game.startTurn();
        harry.drawCard();
        harry.drawCard();
        harry.drawCard();
        harry.drawCard();
        harry.changeActivePokemonFromTheHand(3);

        game.watchCards(harry);
        harry.playCard(0);

        assertFalse(harry.isOver());
        game.activateAttack();
        game.finishTurn();
        game.watchCards(harry);
    }

    @Test
    void testEvolutionPokemon(){

        assertEquals(ash, game.getActiveTrainer());
        game.startTurn();
        ash.drawCard();
        ash.drawCard();
        ash.drawCard();
        ash.drawCard();

        ash.drawCard();
        ash.drawCard();

        // Plays an s1 pokemon, it is replaced by the basic pokemon in the bench,.
        ash.playCard(5);
        assertEquals(6, ash.getHand().size());
        ash.playCard(0);
        assertEquals(5, ash.getHand().size());

    }

    @Test
    void testTrainerCards(){
        game.startTurn();

        ash.drawCard();
        ash.drawCard();
        ash.drawCard();
        ash.drawCard();
        ash.drawCard();
        game.watchCards(ash);
        ash.changeActivePokemonFromTheHand(5);
        ash.getActivePokemon().makeDamage(10);

        assertEquals(5, ash.getHand().size());
        assertEquals(squirtle, ash.getActivePokemon());
        assertEquals(90, ash.getActivePokemon().getHp());

        // Launch the trainer cards
        ash.playCard(0);
        ash.playCard(0);
        game.watchCards(ash);
        game.finishTurn();
        // The potion was applied to the active pokemon, that means that the potion is working
        assertEquals(100, ash.getActivePokemon().getHp());
    }

}