package cc3002.attack;

import cc3002.effect.Effect;
import cc3002.effect.InstantEffect;
import cc3002.visitor.IVisitor;

public interface IAbility extends ISkill {

    void accept(IVisitor v);

    Effect getEffect();

}
