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

import static org.junit.jupiter.api.Assertions.*;

class PsychicEvolutionTest {

    private Heal heal;
    private ArrayList<IAbility> basicAbilities;
    private PsychicAttack psychicAttack;

    private ArrayList<IAttack> psychicAttacks;

    private BasicPsychicPokemon mew;
    private S1PsychicPokemon mew1;
    private S2PsychicPokemon mew2;


    private ArrayList<ICard> hand1;


    private Trainer ash;
    private Deck ashDeck;
    private Potion healEffect;


    @BeforeEach
    void setUp() {
        psychicAttack = new PsychicAttack("LLama de mentes", "Fuego blanco", 10, 5);

        healEffect = new Potion("Random heal effect");
        heal = new Heal("Heal", "Habilidad sanadora", healEffect);
        basicAbilities = new ArrayList<>();
        basicAbilities.add(heal);

        // Creation of mew, the aim of the test isn't test the attacks so they will be repeated
        psychicAttacks = new ArrayList<>(Arrays.asList(psychicAttack));
        mew = new BasicPsychicPokemon(100, "Charmander", 1, psychicAttacks, basicAbilities);
        mew1 = new S1PsychicPokemon(120, "CharmanderS1", 1, psychicAttacks, basicAbilities);
        mew2 = new S2PsychicPokemon(140, "CharmanderS2", 1, psychicAttacks, basicAbilities);

        ashDeck = new Deck(new ArrayList<>(Arrays.asList(mew, mew1, mew2)));
        ash = new Trainer("Ash", ashDeck);

    }

    @Test
    void testFireEvolutionPokemon(){

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