package cc3002.game;
import cc3002.attack.IAbility;
import cc3002.card.ICard;
import cc3002.trainer.ITrainer;
import cc3002.trainer.Trainer;
import cc3002.trainercard.ITrainerCard;
import cc3002.trainercard.Stadium;
import cc3002.visitor.IVisitor;
import cc3002.visitor.SpellVisitor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class that control the state of the game. It contains a lot of methods that
 * can execute the differents options that a trainer can have in a normal match.
 * It is focused to be a controller of the game.
 */
public class GameDriver {

    private boolean isOver;
    private ITrainer activeTrainer;
    private ITrainer inactiveTrainer;
    private ICard stadiumCard;


    private ArrayList<ITrainerCard> trainerQueue;
    private ArrayList<IAbility> abilitiesQueue;


    public  GameDriver(ITrainer trainer1, ITrainer trainer2) {
        this.isOver = false;
        this.activeTrainer = trainer1;
        this.inactiveTrainer = trainer2;
    }

    public void watchCards(ITrainer trainer){
        trainer.visualizeHand();
    }

    public void startTurn(){
        this.activeTrainer.drawCard();
    }

    public void activateAttack(){
        this.activeTrainer.usePokemonAttack(inactiveTrainer);
    }

    public void activateAbility(){
        this.activeTrainer.usePokemonAbility();
    }

    private void executeEffects(){
        trainerQueue = activeTrainer.getTrainerQueue();
        abilitiesQueue = activeTrainer.getAbilitiesQueue();
        Iterator<ITrainerCard> iter1 = trainerQueue.iterator();
        Iterator<IAbility> iter2 = abilitiesQueue.iterator();

        // An iterator executes all the trainer cards instant effects
        while (iter1.hasNext()) {
            ITrainerCard c = iter1.next();
            IVisitor v = new SpellVisitor();
            v.set(this);
            c.accept(v);
        }

        // A second iterator executes the abilities in case that someone was launched
        while (iter2.hasNext()) {
            IAbility ability = iter2.next();
            IVisitor v = new SpellVisitor();
            v.set(this);
            ability.accept(v);
        }
    }

    public void finishTurn(){
        if (this.activeTrainer.isOver()){
            this.isOver = true;
        } else {
            this.executeEffects();
            ITrainer aux;
            aux = this.activeTrainer;
            this.activeTrainer = inactiveTrainer;
            inactiveTrainer = aux;
        }

    }


    public ITrainer getActiveTrainer(){
        return this.activeTrainer;
    }
    public ITrainer getInactiveTrainer() {
        return this.inactiveTrainer;
    }

    public void setStadium(Stadium stadium) {
        this.stadiumCard = stadium;
    }


}
