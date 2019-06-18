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

class ElectricEvolutionTest {

    private Heal heal;
    private ArrayList<IAbility> basicAbilities;
    private ElectricAttack electricAttack;

    private ArrayList<IAttack> electricAttacks;

    private BasicElectricPokemon pikachu;
    private S1ElectricPokemon s1pikachu;
    private S2ElectricPokemon s2pikachu;


    private ArrayList<ICard> hand1;


    private Trainer ash;
    private Deck ashDeck;
    private Potion healEffect;


    @BeforeEach
    void setUp() {
        electricAttack = new ElectricAttack("LLama de rayos", "Fuego amarillo", 10, 5);

        healEffect = new Potion("Random heal effect");
        heal = new Heal("Heal", "Habilidad sanadora", healEffect);
        basicAbilities = new ArrayList<>();
        basicAbilities.add(heal);

        // Creation of charmander, the aim of the test isn't test the attacks so they will be repeated
        electricAttacks = new ArrayList<>(Arrays.asList(electricAttack));
        pikachu = new BasicElectricPokemon(100, "Pikachu", 1, electricAttacks, basicAbilities);
        s1pikachu = new S1ElectricPokemon(120, "S1Pikachu", 1, electricAttacks, basicAbilities);
        s2pikachu = new S2ElectricPokemon(140, "S2Pikachu", 1, electricAttacks, basicAbilities);

        ashDeck = new Deck(new ArrayList<>(Arrays.asList(pikachu, s1pikachu, s2pikachu)));
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