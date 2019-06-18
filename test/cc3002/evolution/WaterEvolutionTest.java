package cc3002.evolution;

import cc3002.attack.*;
import cc3002.card.ICard;
import cc3002.deck.Deck;
import cc3002.effect.Potion;
import cc3002.pokemon.*;
import cc3002.trainer.Trainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WaterEvolutionTest {

    private Heal heal;
    private ArrayList<IAbility> basicAbilities;
    private WaterAttack waterAttack;

    private ArrayList<IAttack> waterAttacks;

    private BasicWaterPokemon squirtle;
    private S1WaterPokemon s1squirtle;
    private S2WaterPokemon s2squirtle;


    private ArrayList<ICard> hand1;


    private Trainer ash;
    private Deck ashDeck;
    private Potion healEffect;


    @BeforeEach
    void setUp() {
        waterAttack = new WaterAttack("LLama de fuego", "Fuego azul valyrio", 10, 5);

        healEffect = new Potion("Random heal effect");
        heal = new Heal("Heal", "Habilidad sanadora", healEffect);
        basicAbilities = new ArrayList<>();
        basicAbilities.add(heal);

        // Creation of charmander, the aim of the test isn't test the attacks so they will be repeated
        waterAttacks = new ArrayList<>(Arrays.asList(waterAttack));
        squirtle = new BasicWaterPokemon(100, "Charmander", 1, waterAttacks, basicAbilities);
        s1squirtle = new S1WaterPokemon(120, "CharmanderS1", 1, waterAttacks, basicAbilities);
        s2squirtle = new S2WaterPokemon(140, "CharmanderS2", 1, waterAttacks, basicAbilities);

        ashDeck = new Deck(new ArrayList<>(Arrays.asList(squirtle, s1squirtle, s2squirtle)));
        ash = new Trainer("Ash", ashDeck);

    }

    @Test
    void testWaterEvolutionPokemon() {

        ash.visualizeHand();
        ash.drawCard();
        ash.drawCard();
        ash.drawCard();
        ash.visualizeHand();
        ash.playCard(2);

        assertEquals(1, ash.getBench().count());
        assertEquals(2, ash.getHand().size());

        ash.visualizeHand();
        ash.playCard(1);

        // Efectivamente se hace el reemplazo del pokemon Basic por S1
        assertEquals(1, ash.getBench().count());
        assertEquals(1, ash.getHand().size());
        ash.visualizeHand();
        ash.playCard(0);
        assertEquals(0, ash.getHand().size());
        ash.visualizeHand();

    }
}