package cc3002.trainercard;

import cc3002.effect.ContinuousEffect;
import cc3002.effect.Effect;
import cc3002.trainer.ITrainer;
import cc3002.visitor.IVisitor;

public class ContinuousObject extends AbstractTrainerCard {
    public ContinuousObject(String name, ContinuousEffect effect) {
        super(name, effect);
    }

    @Override
    public void accept(IVisitor v) {
        v.visitContinuousObject(this);
    }


}
