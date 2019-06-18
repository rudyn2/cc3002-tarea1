package cc3002.evolution;

import cc3002.attack.*;
import cc3002.card.ICard;
import cc3002.deck.Deck;
import cc3002.effect.InstantEffect;
import cc3002.effect.Potion;
import cc3002.effect.ProfessorJuniper;
import cc3002.energy.FireEnergy;
import cc3002.energy.GrassEnergy;
import cc3002.energy.PsychicEnergy;
import cc3002.energy.WaterEnergy;
import cc3002.game.GameDriver;
import cc3002.pokemon.*;
import cc3002.trainer.Trainer;
import cc3002.trainercard.Support;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FireEvolutionTest {

    private Heal heal;
    private ArrayList<IAbility> basicAbilities;
    private FireAttack fireAttack;

    private ArrayList<IAttack> fireAttacks;

    private BasicFirePokemon charmander;
    private S1FirePokemon s1charmander;
    private S2FirePokemon s2charmander;


    private ArrayList<ICard> hand1;


    private Trainer ash;
    private Deck ashDeck;
    private Potion healEffect;


    @BeforeEach
    void setUp() {
        fireAttack = new FireAttack("LLama de fuego", "Fuego azul valyrio", 10, 5);

        healEffect = new Potion("Random heal effect");
        heal = new Heal("Heal", "Habilidad sanadora", healEffect);
        basicAbilities = new ArrayList<>();
        basicAbilities.add(heal);

        // Creation of charmander, the aim of the test isn't test the attacks so they will be repeated
        fireAttacks = new ArrayList<>(Arrays.asList(fireAttack));
        charmander = new BasicFirePokemon(100, "Charmander", 1, fireAttacks, basicAbilities);
        s1charmander = new S1FirePokemon(120, "CharmanderS1", 1, fireAttacks, basicAbilities);
        s2charmander = new S2FirePokemon(140, "CharmanderS2", 1, fireAttacks, basicAbilities);

        ashDeck = new Deck(new ArrayList<>(Arrays.asList(charmander, s1charmander, s2charmander)));
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