package cc3002.trainer;

import cc3002.bench.IBench;
import cc3002.card.ICard;
import cc3002.pokemon.IPokemon;

import java.util.ArrayList;

public class Trainer implements ITrainer {

    private String name;
    private ArrayList<ICard> hand;
    private IPokemon activePokemon;
    private IBench bench;

    /**
     * Generic constructor for the class Trainer. It will initialize a trainer with the minimal amount of
     * information required to begin some game.
     * @param name The name of the trainer.
     * @param hand An ArrayList with the initial cards.
     * @param activePokemon The initial active pokemon.
     * @param bench An ArrayList with the initial bench.
     */
    public Trainer(String name, ArrayList<ICard> hand, IPokemon activePokemon, IBench bench) {
        this.name = name;
        this.hand = hand;
        this.activePokemon = activePokemon;
        this.bench = bench;
    }

    /**
     * Getter for the name of the trainer.
     *
     * @return The name of the trainer.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Method that selects an specific attack of the active pokemon.
     *
     * @param option An integer that represents the position of the wanted attack.
     */
    @Override
    public void selectAttackOfActivePokemon(int option) {
        this.getActivePokemon().selectAttack(option);
    }

    /**
     * Getter for the active pokemon.
     *
     * @return The active pokemon of the trainer in the game.
     */
    @Override
    public IPokemon getActivePokemon() {
        return this.activePokemon;
    }

    /**
     * Method to attack the active pokemon of other trainer.
     *
     * @param trainer The trainer that will be attacked.
     */
    @Override
    public void attack(ITrainer trainer) {
        trainer.receiveAttack(this);
    }

    /**
     * Method to play some card. If the card is a energy it will be assigned to the active pokemon.
     * Else, the card is a pokemon and then will be added to the bench.
     *
     * @param option The number of the card that will be played.
     */
    @Override
    public void playCard(int option) {
        if(this.isValidOption(option)){
            this.hand.get(option).play(this);
        } else {
            System.out.println("Debe especificar una jugada válida.");
        }

    }

    /**
     * Method that adds a pokemon to the pokemon's bench.
     *
     * @param pokemon The pokemon that will be added to the bench.
     */
    @Override
    public void addPokemon(IPokemon pokemon) {
        this.bench.add(pokemon);
    }

    /**
     * Method that receives the attack from other trainer.
     * @param trainer The trainer that makes the attack.
     */
    @Override
    public void receiveAttack(ITrainer trainer) {
        trainer.getActivePokemon().attack(this.activePokemon);
    }

    /**
     * Getter for the hand of the trainer.
     *
     * @return An ArrayList with his cards.
     */
    @Override
    public ArrayList<ICard> getHand() {
        return this.hand;
    }

    /**
     * Method that helps to the trainer to see the cards in its hand. The information
     * of the cards will be printed into the console.
     */
    @Override
    public void visualizeHand() {
        if (this.hand.size() > 0){
            for(int i = 0; i < this.hand.size(); i ++){
                System.out.println(i + ".- " + this.hand.get(i).getInfo());
            }
        }

    }

    /**
     * Method that checks if the trainer has lost.
     *
     * @return True if the trainer lost.
     */
    @Override
    public boolean isOver() {
        return activePokemon.isDead() && bench.isEmpty();
    }



    /**
     * Method that checks if the option selected is a valid option (if that card is available).
     * @param option The option.
     * @return True if option is in the hand.
     */
    private boolean isValidOption(int option){
        return (option < this.hand.size()) && (option >= 0);
    }
}
