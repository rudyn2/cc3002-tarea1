package cc3002.attack;

import cc3002.effect.Effect;
import cc3002.effect.InstantEffect;
import cc3002.visitor.IVisitor;

/**
 * This interface defines the basic funcionality of an ability of the game. Like
 * accept some visitors or getting the effects of the abilities.
 */
public interface IAbility extends ISkill {

    void accept(IVisitor v);

    Effect getEffect();

}
