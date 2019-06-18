package cc3002.trainer;

import cc3002.attack.IAbility;
import cc3002.attack.ISkill;
import cc3002.card.ICard;
import cc3002.pokemon.IPokemon;
import cc3002.trainercard.ITrainerCard;
import cc3002.trainercard.Stadium;

import java.util.ArrayList;

/**
 * Common interface for any type of trainer. A trainer has a hand with cards. He can also has
 * an active pokemon in the stadium. He can obtain his active pokemon, select the attack that his
 * active pokemon will use and change it.
 *
 */
public interface ITrainer {

    /**
     * Getter for the name of the trainer.
     * @return The name of the trainer.
     */
    String getName();

    /**
     * Method that selects an specific attack of the active pokemon.
     * @param option An integer that represents the position of the wanted attack.
     */
    void selectAttackOfActivePokemon(int option);

    /**
     * Getter for the active pokemon.
     * @return The active pokemon of the trainer in the game.
     */
    IPokemon getActivePokemon();


    /**
     * Method to attack the active pokemon of other trainer.
     * @param trainer The trainer that will be attacked.
     */
    void attack(ITrainer trainer);

    /**
     * Method to play some card that doesn't require a target like a trainer card or a pokemon. The case of the
     * energy card will be treated different.
     * Else, the card is a pokemon and then will be added to the bench.
     * @param option The number of the card that will be played.
     */
    void playCard(int option);


    /**
     * Method that adds a pokemon to the pokemon's bench.
     * @param pokemon The pokemon that will be added to the bench.
     */
    boolean addBasicPokemon(IPokemon pokemon);

    boolean addS1Pokemon(IPokemon pokemon);

    boolean addS2Pokemon(IPokemon pokemon);


    /**
     * Method that changes the active pokemon from someone chose between the available pokemon's in the hand.
     * If it's some pokemon as an active pokemon it will go to the bench, if the bench is full it will be to
     * the hand.
     * @param option The pokemon that will be the new active pokemon.
     */
    void changeActivePokemonFromTheHand(int option);

    /**
     * Method that receives an attack from other trainer. Its active pokemon will receive
     * the attack from the active pokemon of the other trainer.
     * @param trainer The trainer that makes the attack.
     */
    void receiveAttack(ITrainer trainer);

    /**
     * Getter for the hand of the trainer.
     * @return An ArrayList with his cards.
     */
    ArrayList<ICard> getHand();


    /**
     * Method that helps to the trainer to see the cards in its hand. The information
     * of the cards will be printed into the console.
     */
    void visualizeHand();

    void visualizeBench();

    /**
     * Method that checks if the trainer has lost.
     * @return True if the trainer lost.
     */
    boolean isOver();

    void drawCard();
    void  discardCard(ICard card);

    boolean addAbilityQueue(IAbility ability);
    boolean addTrainerCardQueue(ITrainerCard trainerCard);

    void usePokemonAbility();
    void usePokemonAttack(ITrainer targetTrainer);

    ArrayList<ITrainerCard> getTrainerQueue();

    ArrayList<IAbility> getAbilitiesQueue();

}
