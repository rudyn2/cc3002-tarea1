package cc3002.visitor;

import cc3002.effect.Effect;
import cc3002.game.GameDriver;
import cc3002.trainer.ITrainer;
import cc3002.trainercard.ContinuousObject;
import cc3002.trainercard.InstantObject;
import cc3002.trainercard.Stadium;
import cc3002.trainercard.Support;

public class SpellVisitor implements IVisitor {

    private GameDriver gameDriver;

    @Override
    public void set(GameDriver gameDriver) {
        this.gameDriver = gameDriver;
    }

    @Override
    public void visitStadium(Stadium stadium) {
        gameDriver.setStadium(stadium);
        gameDriver.getActiveTrainer().discardCard(stadium);
        gameDriver.getQueue().remove(stadium);
    }

    @Override
    public void visitSupport(Support support) {
        this.playInstantEffect(support.getEffect());

    }

    @Override
    public void visitContinuousObject(ContinuousObject instantObject) {

    }

    @Override
    public void visitInstantObject(InstantObject instantObject) {
        this.playInstantEffect(instantObject.getEffect());
    }



    private void playInstantEffect(Effect F){
        F.set(gameDriver.getActiveTrainer(), gameDriver.getInactiveTrainer());
        F.execute();
    }


}
