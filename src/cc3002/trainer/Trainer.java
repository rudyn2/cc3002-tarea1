package cc3002.trainer;

import cc3002.bench.Bench;
import cc3002.bench.IBench;
import cc3002.card.ICard;
import cc3002.pokemon.IPokemon;

import java.util.ArrayList;

/**
 * Generic class that represents a Trainer in the pokemon game. The trainer administers the use of the cards,
 * the attacks of its pokemons and the bench. A Trainer must have a name, a hand with cards, an active pokemon
 * (it could be nothing if doesn't exists a pokemon that can take place) and a bench with pokemons. The minimal
 * features are explained with more details below.
 * @author Rudy García Alvarado
 */
public class Trainer implements ITrainer {

    /**
     * The name of the trainer
     */
    private String name;
    /**
     * An ArrayList with the cards of the hand of the Trainer.
     */
    private ArrayList<ICard> hand;
    /**
     * The active pokemon of the trainer
     */
    private IPokemon activePokemon;
    /**
     * The bench of the trainer.
     */
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
     * Generic constructor for the class Trainer. It will initialize a simplified
     * trainer with some information required to begin some game.
     * @param name The name of the trainer
     * @param hand The initial hand.
     */
    public Trainer(String name, ArrayList<ICard> hand) {
        this(name, hand, null, new Bench());
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
            this.hand.remove(option);
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
     * Method that changes the active pokemon from someone chose between the available pokemon's in the hand.
     * If it's some pokemon as an active pokemon it will go to the bench, if the bench is full it will be to
     * the hand.
     * @param option The pokemon that will be the new active pokemon.
     */
    @Override
    public void changeActivePokemonFromTheHand(int option) {
        if(this.isValidOption(option)){
            if (!this.bench.isEmpty() && !this.bench.isFull()){
                this.bench.add(this.getActivePokemon());
            } else {
                this.hand.add(this.getActivePokemon());
            }
            // The player needs to see the available's options so it has to be good. Other case
            // the casting will fail.
            this.activePokemon = (IPokemon)this.hand.remove(option);
        }
    }

    /**
     * Method that receives the attack from other enemyTrainer.
     * @param enemyTrainer The enemyTrainer that makes the attack.
     */
    @Override
    public void receiveAttack(ITrainer enemyTrainer) {
        // If it's alive attack
        if (this.activePokemon != null && !this.activePokemon.isDead()){
            enemyTrainer.getActivePokemon().attack(this.activePokemon);
        } else {
            // It it is not alive and exists someone, change it and attack it
            if (!this.bench.isEmpty()){
                this.activePokemon = this.bench.pop();
                enemyTrainer.getActivePokemon().attack(this.activePokemon);
            }
        }
        // If after the attack the active pokemon dies change it for someone in the bench
        if (this.activePokemon.isDead() && !this.bench.isEmpty())
            this.activePokemon = this.bench.pop();

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
                if (this.hand.get(i) != null)
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
        return (activePokemon == null || activePokemon.isDead()) && bench.isEmpty() ;
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
