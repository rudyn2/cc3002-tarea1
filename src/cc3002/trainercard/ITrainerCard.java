package cc3002.trainercard;

import cc3002.card.ICard;
import cc3002.trainer.ITrainer;
import cc3002.visitor.IVisitor;

public interface ITrainerCard extends ICard {

    void accept(IVisitor v);
}
