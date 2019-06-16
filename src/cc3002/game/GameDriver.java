package cc3002.game;
import cc3002.card.ICard;
import cc3002.trainer.ITrainer;
import cc3002.trainercard.ITrainerCard;
import cc3002.trainercard.Stadium;
import cc3002.visitor.IVisitor;
import cc3002.visitor.SpellVisitor;

import java.util.ArrayList;

public class GameDriver {

    private boolean isOver;
    private ITrainer activeTrainer;
    private ITrainer inactiveTrainer;
    private ICard stadiumCard;


    private ArrayList<ITrainerCard> queue;


    public GameDriver(boolean isOver, ITrainer trainer1, ITrainer trainer2) {
        this.isOver = isOver;
        this.activeTrainer = trainer1;
        this.inactiveTrainer = trainer2;
    }

    private void watchCards(ITrainer trainer){
        for (ICard c: trainer.getHand()) {
            c.getName();
        }
    }

    private void startTurn(ITrainer trainer){
        trainer.drawCard();
        trainer.playCard(0);
    }

    private void activateAttack(){
        this.activeTrainer.usePokemonAttack(inactiveTrainer);
    }

    private void activateAbility(){
        this.activeTrainer.usePokemonAbility();
    }

    private void executeEffects(){
        queue = activeTrainer.getTrainerQueue();
        for(ITrainerCard c: queue){
            IVisitor v = new SpellVisitor();
            v.set(this);
            c.accept(v);
        }
    }

    private void finishTurn(){
        if (this.activeTrainer.isOver()){
            this.isOver = true;
        } else {
            ITrainer aux;
            aux = this.activeTrainer;
            this.activeTrainer = inactiveTrainer;
            inactiveTrainer = aux;
        }

    }

    public ITrainer getActiveTrainer(){ return this.activeTrainer;}
    public ITrainer getInactiveTrainer() { return this.inactiveTrainer;}
    public ArrayList<ITrainerCard> getQueue() {
        return queue;
    }

    public void setStadium(Stadium stadium) {
        this.stadiumCard = stadium;
    }


}
