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

class FighterEvolutionTest {

    private Heal heal;
    private ArrayList<IAbility> basicAbilities;
    private FighterAttack fighterAttack;

    private ArrayList<IAttack> fighterAttacks;

    private BasicFighterPokemon machote;
    private S1FighterPokemon s1machote;
    private S2FighterPokemon s2machote;


    private ArrayList<ICard> hand1;


    private Trainer ash;
    private Deck ashDeck;
    private Potion healEffect;


    @BeforeEach
    void setUp() {
        fighterAttack = new FighterAttack("Combos", "Fuego rojo", 10, 5);

        healEffect = new Potion("Random heal effect");
        heal = new Heal("Heal", "Habilidad sanadora", healEffect);
        basicAbilities = new ArrayList<>();
        basicAbilities.add(heal);

        // Creation of charmander, the aim of the test isn't test the attacks so they will be repeated
        fighterAttacks = new ArrayList<>(Arrays.asList(fighterAttack));
        machote = new BasicFighterPokemon(100, "Machote", 1, fighterAttacks, basicAbilities);
        s1machote = new S1FighterPokemon(120, "machoteS1", 1, fighterAttacks, basicAbilities);
        s2machote = new S2FighterPokemon(140, "MachoteS2", 1, fighterAttacks, basicAbilities);

        ashDeck = new Deck(new ArrayList<>(Arrays.asList(machote, s1machote, s2machote)));
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