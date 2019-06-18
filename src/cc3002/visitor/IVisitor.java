package cc3002.visitor;

import cc3002.attack.IAbility;
import cc3002.game.GameDriver;
import cc3002.trainercard.InstantObject;
import cc3002.trainercard.Stadium;
import cc3002.trainercard.Support;

public interface IVisitor {

    void visitStadium(Stadium card);

    void visitSupport(Support support);

    void set(GameDriver gameDriver);

    void visitInstantObject(InstantObject instantObject);

    void visitAbility(IAbility ability);

}
